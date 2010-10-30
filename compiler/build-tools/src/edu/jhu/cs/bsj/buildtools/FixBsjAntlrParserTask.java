package edu.jhu.cs.bsj.buildtools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * The purpose of this ANT task is to perform customized operations on the output of the BSJ ANTLR parser. The generated
 * parser source is problematic in some ways; this task is meant to be executed over that source to make it suitable for
 * the Java compiler. Specifically, this task performs the following operations:
 * <ol>
 * <li><b>Simplification of redundant semantic predicates.</b> The generated parser sometimes contains semantic
 * predicates which are thousands of characters long and which are only that complicated because they repeat the same
 * condition over and over. This task will remedy that by replacing such conditions with equivalent but simpler
 * conditions. (Regular expressions aren't fast enough.)</li>
 * <li><b>Moving static DFA fields into the respective DFA classes.</b> The generated parser produces these fields and
 * static initializers in the scope of the whole parser class. Since they are not used outside of the DFA class itself,
 * the two scopes are equivalent. Leaving them in the scope of the whole parser class causes the parser's static
 * initialization to be larger than 64K, causing a compile error. Instead, this task moves them to be members of the
 * inner class, ensuring that they do not overcomplicate the parser's static initializer.</li>
 * </ol>
 * 
 * @author Zachary Palmer
 * 
 */
public class FixBsjAntlrParserTask extends Task
{
    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    private File parserFile;

    @Override
    public void execute() throws BuildException
    {
        if (this.parserFile == null)
        {
            throw new BuildException("You must specify the parser file.");
        }

        String parser;

        this.log("Loading parser file " + this.parserFile, Project.MSG_VERBOSE);

        try
        {
            parser = readParserFile();
        } catch (IOException e)
        {
            throw new BuildException(e);
        }

        final String originalParser = parser;

        this.log("Simplifying conditions...", Project.MSG_VERBOSE);

        parser = simplifyConditions(parser);

        this.log("Moving DFA members...", Project.MSG_VERBOSE);

        parser = moveDfaMembers(parser);

        if (!parser.equals(originalParser))
        {
            this.log("Saving parser file " + this.parserFile, Project.MSG_VERBOSE);

            try
            {
                writeParserFile(parser);
            } catch (IOException e)
            {
                throw new BuildException(e);
            }
        } else
        {
            this.log("Not saving parser file because no changes have occurred.", Project.MSG_VERBOSE);
        }

        this.log("Finished!", Project.MSG_VERBOSE);

    }

    private String simplifyConditions(String parser)
    {
        int index = 0;
        int lineNo = 0;
        StringBuilder sb = new StringBuilder();
        while (index < parser.length())
        {
            // Find the next line
            lineNo++;
            final int lineStartIndex = index;
            while (index < parser.length() && parser.charAt(index) != '\n')
            {
                index++;
            }
            String line = parser.substring(lineStartIndex, index);
            final boolean newline;
            if (index < parser.length())
            {
                newline = true;
                index++;
            } else
            {
                newline = false;
            }

            // Examine the line to determine if it matches the expected form:
            // \s*if\s*\(\s*\(LA_[0-9]+_[0-9]+==[0-9]+\)\s*&&\s*\(\(
            // and then a bunch of ||-separated conditions followed by
            // \)*.*
            // Regular expression processor is too slow, which is why everything is being written here.
            try
            {
                StringHandler handler = new StringHandler(line);
                handler.consumeWhitespace();
                handler.demandString("if");
                handler.consumeWhitespace();
                handler.demandCharacter('(');
                handler.consumeWhitespace();
                handler.demandCharacter('(');
                handler.demandString("LA");
                handler.demandCharacter(DIGITS);
                while (handler.consumeCharacter(DIGITS) != null)
                {
                }
                handler.demandCharacter('_');
                handler.demandCharacter(DIGITS);
                while (handler.consumeCharacter(DIGITS) != null)
                {
                }
                handler.demandString("==");
                handler.demandCharacter(DIGITS);
                while (handler.consumeCharacter(DIGITS) != null)
                {
                }
                handler.demandCharacter(')');
                handler.consumeWhitespace();
                handler.demandString("&&");
                handler.consumeWhitespace();
                handler.demandString("((");

                final int termsStartIndex = handler.getIndex();
                Set<String> terms = new HashSet<String>();
                terms.add(handler.readParenGroup());
                while (handler.getIndex() < line.length() - 1
                        && line.substring(handler.getIndex(), handler.getIndex() + 2).equals("||"))
                {
                    handler.demandString("||");
                    terms.add(handler.readParenGroup());
                }

                final int termsStopIndex = handler.getIndex();

                List<String> termList = new ArrayList<String>(terms);
                Collections.sort(termList);
                StringBuilder rewrittenLineBuilder = new StringBuilder();
                rewrittenLineBuilder.append(line.substring(0, termsStartIndex));
                boolean first = true;
                for (String term : termList)
                {
                    if (!first)
                        rewrittenLineBuilder.append("||");
                    first = false;
                    rewrittenLineBuilder.append(term);
                }
                rewrittenLineBuilder.append(line.substring(termsStopIndex));

                sb.append(rewrittenLineBuilder.toString());
            } catch (RecognitionFailureException e)
            {
                sb.append(line);
            }

            if (newline)
            {
                sb.append('\n');
            }
        }

        return sb.toString();
    }

    private String moveDfaMembers(String parser)
    {
        int index = 0;
        int lineNo = 0;
        StringBuilder sb = new StringBuilder();

        String currentDfaName = null;
        List<String> currentLines = new ArrayList<String>();
        boolean parsingInitializer = false;
        boolean parsingStaticBlock = false;
        boolean innerClass = false;
        int innerClassIndentationIndex = 0;
        int staticBlockIndentationIndex = 0;

        while (index < parser.length())
        {
            // Find the next line
            lineNo++;
            final int lineStartIndex = index;
            while (index < parser.length() && parser.charAt(index) != '\n')
            {
                index++;
            }
            final String line = parser.substring(lineStartIndex, index);
            final boolean newline;
            if (index < parser.length())
            {
                newline = true;
                index++;
            } else
            {
                newline = false;
            }

            final String logMessage;

            // Branch depending on state
            if (innerClass)
            {
                // Then leave everything alone.
                sb.append(line);
                if (newline)
                    sb.append('\n');
                if (line.trim().startsWith("}") && line.indexOf('}') == innerClassIndentationIndex)
                {
                    innerClass = false;
                    logMessage = "Leaving inner class";
                } else
                {
                    logMessage = "Inside inner class";
                }
            } else if (line.trim().startsWith("class") || line.trim().startsWith("static class"))
            {
                if (currentDfaName != null)
                {
                    // If it's a DFA class name header, we will write out the static class containing the DFA's
                    // initialization variables.
                    boolean matchesDfaClassHeader = line.trim().startsWith("class DFA" + currentDfaName);
                    if (matchesDfaClassHeader)
                    {
                        sb.append("    static class DFA" + currentDfaName + "Data {\n");
                        logMessage = "Matches DFA" + currentDfaName + " class header - dumping initializer lines";
                        for (String initializerLine : currentLines)
                        {
                            sb.append("    ");
                            sb.append(initializerLine);
                            sb.append('\n');
                        }
                        currentLines.clear();
                        currentDfaName = null;
                        sb.append("    }\n");
                    } else
                    {
                        logMessage = "Unrelated line - copying verbatim";
                    }
                } else
                {
                    logMessage = "Entering non-DFA inner class";
                }
                sb.append(line);
                if (newline)
                    sb.append('\n');
                innerClass = true;
                innerClassIndentationIndex = line.indexOf(line.trim().charAt(0));
            } else if (parsingInitializer)
            {
                // Then add this portion to our current initializer list that needs to be moved to the DFA class.
                currentLines.add(line);
                if (line.trim().endsWith(";"))
                {
                    parsingInitializer = false;
                    logMessage = "Exiting initializer";
                } else
                {
                    logMessage = "Parsing initializer";
                }
            } else if (parsingStaticBlock)
            {
                currentLines.add(line);
                if (line.trim().equals("}") && line.indexOf('}') == staticBlockIndentationIndex)
                {
                    parsingStaticBlock = false;
                    logMessage = "Finishing static block";
                } else
                {
                    logMessage = "Continuing static block";
                }
            } else if (line.trim().equals("static {") && currentDfaName != null)
            {
                parsingStaticBlock = true;
                staticBlockIndentationIndex = line.indexOf('s');
                logMessage = "Starting static block";
                currentLines.add(line);
            } else
            {
                // Determine if the current line looks like it starts a DFA variable declaration
                String dfaName;
                String varName;
                if (line.contains("Data.DFA"))
                {
                    dfaName = null;
                    varName = null;
                } else
                {
                    try
                    {
                        StringHandler handler = new StringHandler(line);
                        handler.consumeWhitespace();
                        handler.demandString("static final ");
                        handler.demandOneString("String", "byte", "short", "char", "int", "long");
                        while (handler.consumeString("[]"))
                        {
                        }
                        handler.consumeWhitespace();
                        final int varNameIndex = handler.getIndex();
                        handler.demandString("DFA");
                        StringBuilder dfaNameBuilder = new StringBuilder();
                        Character c;
                        while ((c = handler.consumeCharacter(DIGITS)) != null)
                        {
                            dfaNameBuilder.append(c);
                        }
                        if (dfaNameBuilder.length() == 0)
                        {
                            throw new RecognitionFailureException();
                        }
                        dfaName = dfaNameBuilder.toString();
                        int varNameEndIndex = varNameIndex;
                        while (varNameEndIndex < line.length()
                                && Character.isJavaIdentifierPart(line.charAt(varNameEndIndex)))
                            varNameEndIndex++;
                        varName = line.substring(varNameIndex, varNameEndIndex);
                        sb.append(line.substring(0, varNameEndIndex));
                        sb.append(" = DFA" + dfaName + "Data." + varName + ";\n");
                    } catch (RecognitionFailureException e)
                    {
                        // Not a DFA name.
                        dfaName = null;
                        varName = null;
                    }
                }

                if (dfaName != null && (currentDfaName == null || currentDfaName.equals(dfaName)))
                {
                    currentDfaName = dfaName;
                    currentLines.add(line);
                    if (!line.trim().endsWith(";"))
                    {
                        logMessage = "Starting initializer";
                        parsingInitializer = true;
                    } else
                    {
                        logMessage = "Found single-line initializer";
                    }
                } else
                {
                    logMessage = "Unrelated line - copying verbatim";
                    sb.append(line);
                    if (newline)
                        sb.append('\n');
                }
            }

            this.log("Line " + lineNo + ": " + logMessage + ": " + line, Project.MSG_VERBOSE);
        }

        return sb.toString();
    }

    private String readParserFile() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(this.parserFile)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
        {
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }

    private void writeParserFile(String parser) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(this.parserFile);
        PrintStream ps = new PrintStream(fos);
        ps.print(parser);
        ps.close();
    }

    public void setParserFile(File parserFile)
    {
        this.parserFile = parserFile;
    }

    private static class StringHandler
    {
        private String s;
        private int index;

        public StringHandler(String s)
        {
            this.s = s;
            this.index = 0;
        }

        public void consumeWhitespace()
        {
            while (consumeCharacter(' ', '\t') != null)
            {
            }
        }

        public Character consumeCharacter(char... c)
        {
            if (this.index < this.s.length())
            {
                for (char cc : c)
                {
                    if (this.s.charAt(this.index) == cc)
                    {
                        this.index++;
                        return cc;
                    }
                }
            }
            return null;
        }

        public char demandCharacter(char... c) throws RecognitionFailureException
        {
            if (this.index < this.s.length())
            {
                for (char cc : c)
                {
                    if (this.s.charAt(this.index) == cc)
                    {
                        this.index++;
                        return cc;
                    }
                }
            }
            throw new RecognitionFailureException();
        }

        public boolean consumeString(String s)
        {
            final int nowIndex = this.index;
            try
            {
                demandString(s);
                return true;
            } catch (RecognitionFailureException e)
            {
                this.index = nowIndex;
                return false;
            }
        }

        public void demandOneString(String... ss) throws RecognitionFailureException
        {
            for (String s : ss)
            {
                if (consumeString(s))
                {
                    return;
                }
            }
            throw new RecognitionFailureException();
        }

        public void demandString(String s) throws RecognitionFailureException
        {
            for (char c : s.toCharArray())
            {
                demandCharacter(c);
            }
        }

        public int getIndex()
        {
            return this.index;
        }

        public String readParenGroup() throws RecognitionFailureException
        {
            final int startIndex = this.index;
            demandCharacter('(');
            int parens = 1;
            do
            {
                if (this.index < this.s.length())
                {
                    switch (this.s.charAt(this.index))
                    {
                        case '(':
                            parens++;
                            break;
                        case ')':
                            parens--;
                            break;
                    }
                    this.index++;
                } else if (parens > 0)
                {
                    throw new RecognitionFailureException("Don't know how to handle this line!");
                }
            } while (parens > 0);
            final int stopIndex = this.index;
            return this.s.substring(startIndex, stopIndex);
        }
    }

    public static class RecognitionFailureException extends Exception
    {
        private static final long serialVersionUID = 1L;

        public RecognitionFailureException()
        {
            super();
        }

        public RecognitionFailureException(String message, Throwable cause)
        {
            super(message, cause);
        }

        public RecognitionFailureException(String message)
        {
            super(message);
        }

        public RecognitionFailureException(Throwable cause)
        {
            super(cause);
        }
    }
}
