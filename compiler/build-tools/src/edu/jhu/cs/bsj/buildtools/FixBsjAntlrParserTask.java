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
 * conditions.  (Regular expressions aren't fast enough.)</li>
 * </ol>
 * 
 * @author Zachary Palmer
 * 
 */
public class FixBsjAntlrParserTask extends Task
{
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
                char[] nums = { '0','1','2','3','4','5','6','7','8','9' };
                handler.consumeWhitespace();
                handler.demandString("if");
                handler.consumeWhitespace();
                handler.demandCharacter('(');
                handler.consumeWhitespace();
                handler.demandCharacter('(');
                handler.demandString("LA");
                handler.demandCharacter(nums);
                while (handler.consumeCharacter(nums)) { }
                handler.demandCharacter('_');
                handler.demandCharacter(nums);
                while (handler.consumeCharacter(nums)) { }
                handler.demandString("==");
                handler.demandCharacter(nums);
                while (handler.consumeCharacter(nums)) { }
                handler.demandCharacter(')');
                handler.consumeWhitespace();
                handler.demandString("&&");
                handler.consumeWhitespace();
                handler.demandString("((");
                
                final int termsStartIndex = handler.getIndex();
                Set<String> terms = new HashSet<String>();
                terms.add(handler.readParenGroup());
                while (handler.getIndex() < line.length() - 1 && line.substring(handler.getIndex(), handler.getIndex()+2).equals("||"))
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
            while (consumeCharacter(' ','\t')) { }
        }
        
        public boolean consumeCharacter(char... c)
        {
            if (this.index < this.s.length())
            {
                for (char cc : c)
                {
                    if (this.s.charAt(this.index) == cc)
                    {
                        this.index++;
                        return true;
                    }
                }
            }
            return false;
        }
        
        public void demandCharacter(char... c) throws RecognitionFailureException
        {
            if (this.index < this.s.length())
            {
                for (char cc : c)
                {
                    if (this.s.charAt(this.index) == cc)
                    {
                        this.index++;
                        return;
                    }
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
