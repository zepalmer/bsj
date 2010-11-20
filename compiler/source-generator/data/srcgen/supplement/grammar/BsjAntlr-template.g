/*%% templateComment= value="""

    DISCUSSION OF BSJ ANTLR GRAMMAR TEMPLATE FILE
    =============================================
    This file is a template which is used by the BSJ source generator to create an ANTLR grammar for the BSJ language.
    Certain patterns appear in this grammar which require somewhat sophisticated tooling, so a templating system was
    devised in order to reduce duplicate effort and maintenance burden.
    
    Comments of the form used by this comment (starting with /*%% and ending with the reverse) are parsed by the source
    generator and replaced in-place with other content.  For the remainder of this discussion, the delimiter %% will be
    used to indicate template commands so as to avoid inadvertently inserting an end-of-comment character sequence.  :)
    
    Template comments are of a following form:
    
        %% command= name=value name=value ... %%
    
    The name of the command must contain only alphabetic characters.  The command can take any sequence of name-value
    pairs for arguments.  Which arguments are valid is dependent upon the particular command that is invoked; validation
    occurs in the source generator module which produces the ANTLR grammar.  Arguments which are not used by the
    appropriate command submodule cause the source generator to terminate with an error; required arguments which are
    not present do so as well.
    
    In order to support a variety of argument values and formats, an awk-like syntax is used.  The two characters
    immediately following the command name have special semantic meaning: the first is the character used to separate
    names from values while the second is the character used to separate name-value pairs from each other.  For
    instance,
    
        %% foo= bar=baz bar2=baz2 %%

    is equivalent in every way to
    
        %% foo#!bar#baz!bar2#baz2#%%
    
    This is convenient when the argument value includes the '=' character, such as in describing a token for equality
    operations.
    
    In addition to the specified separator character, newlines may be used to separate name-value pairs.  As a result,
    
        %% foo= bar=baz
                bar2=baz2  %%

    Is equivalent to both of the above.
    
    In order to permit multi-line arguments, triple-quoting syntax is used.  If the value of an argument contains a
    sequence of three quotation marks, those quotation marks begin a literal quote which ends and the next sequence of
    three quotation marks.  The quotation marks themselves are not included in the value.  If further characters appear
    before the next name-value separator, they are concatenated onto the resulting value.  This is similar in behavior
    to string concatenation in bash (where "hel"'lo' is equivalent to "hello") and to tripe-quote syntax in Python.
    There are no escape sequences which would allow a triple quote to be provided as the argument to a parameter.
    
    For an example of triple-quoting, please refer to this comment.  This comment is of the form of a template command.
    It uses the command named "templateComment" and has a single parameter named "value".  The entire body of this
    comment is the argument provided for the "value" parameter.  The semantics of the templateComment command simply
    consist of removing the comment and any trailing whitespace from the grammar.  As a result, this comment will not
    appear in that grammar.
    
    The specific behaviors of the template commands are not described here out of concern for the integrity of such
    documentation.  The edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.AntlrGrammarProcessor class is
    responsible for the processing of this file.  It contains a number of member classes which implement the commands
    in question.
    
    The philosophy behind the structure of the template commands is of particular note.  Rather than generating entire
    rules using template commands, the declaration of the rule is left in place and the template command is placed
    immediately after the rule name.  After the template command, some body may be provided for the rule.  In some
    cases, the body may be used; in others, a faux ":;" body is expected and will be replaced when the command is
    expanded.  The rationale behind this structure (as well as behind the use of semantically-loaded comments) is that
    this template file still reads as a valid (if incorrect) ANTLR grammar and so is parseable and syntax highlightable
    by standard tools.  The ANTLR-IDE Eclipse plugin, for instance, builds a sensible outline view for this template
    even though it is not truly the BSJ ANTLR grammar.  Template commands introduced in the future should continue to
    follow this tradition.
    
""" %%*/


/*
 [The "BSD license"]
 Copyright (c) 2007-2008 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/*%% generationComment= %%*/

/*
 * This file was obtained from www.antlr.org and included modifications by
 * Yang Jiang (yang.jiang.z@gmail.com).  It is a modified version of the
 * ANTLR Java grammar.
 *
 * The original comments have been pruned.  The authors who were listed in
 * those comments are as follows:
 *
 *      Marko van Dooren
 *      Chris Hogue
 *      Yang Jiang
 *      Hiroaki Nakamura
 *      Terence Parr
 *      John Ridgway
 *      Koen Vanderkimpen
 *
 * Authors of the modifications for BSJ are:
 *
 *      Zachary Palmer
 *      Joe Riley
 *
 * This grammar should be compiled using the ANTLR option
 * "-Xconversiontimeout 100000" to ensure proper translation.
 * Failure to provide sufficient timeout leniency will result in numerous
 * messages of the "Multiple token rules can match input" variety.
 */

grammar BsjAntlr;

options {
    language=Java;
    backtrack=true;
}

// this scope tracks information about the rule on top of the call stack
scope Rule {
    String name;
    Token firstToken;
}

@lexer::header{
    package edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr;

    import javax.tools.DiagnosticListener;
    
    import org.apache.log4j.Logger;
    
    import edu.jhu.cs.bsj.compiler.ast.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.lexer.*;
    
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.util.BsjAntlrParserUtils;
}

@lexer::members{
    // *** LOG4J **************************************************************
    private Logger logger = Logger.getLogger(this.getClass());
    
    // *** TOKEN LOGGING ******************************************************
    public Token nextToken()
    {
        Token token = super.nextToken();
        if (logger.isTraceEnabled())
        {
            logger.trace("Token processed at " + BsjAntlrParserUtils.getTokenLocation(token) +
                    " with text: " + token.getText());
        }
        return token;
    }
    
    // *** SOURCE LOCATION TRACKING *******************************************
    /** The resource which is being parsed. */
    private String resourceName;
    /**
     * Produces a resource name for the resource in this parser.
     */
    public String getResourceName()
    {
        return (this.resourceName == null) ? "<unknown>" : resourceName;
    }
    /**
     * Produces a resource name for the resource in this parser.
     */
    public void setResourceName(String resourceName)
    {
        this.resourceName = resourceName;
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getLineNumber()
    {
        return this.getLine();
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getColumnNumber()
    {
        return this.getCharPositionInLine() + 1;
    }
    /**
     * Retrieves a source location object describing the start of the specified relative token index (as per input.LT).
     */
    protected BsjSourceLocation getSourceLocation()
    {
        return new BsjSourceLocation(getResourceName(), this.getLine(), this.getCharPositionInLine() + 1);
    }

    // *** ERROR REPORTING AND HANDLING ***************************************
    /** The diagnostic listener to which we report events. */
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;
    
    /** Assigns a diagnostic listener to this parser. */
    public void setDiagnosticListener(DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        this.diagnosticListener = diagnosticListener;
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(BsjDiagnostic diagnostic)
    {
        reportDiagnostic(diagnostic, false);
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(BsjDiagnostic diagnostic, boolean force)
    {
        if (logger.isTraceEnabled())
        {
            logger.trace("Received diagnostic (force="+force+",bt="+state.backtracking+"): "+diagnostic.getMessage(null));
        }
        if (state.backtracking == 0 || force)
        {
            this.diagnosticListener.report(diagnostic);
        }
    }
    
    /**
     * Overrides the mechanism for displaying recognition errors.  While it is possible to do something very similar by
     * overriding emitErrorMessage, this method is extracted instead in order to allow the exception itself to be
     * trapped for more informative error handling.
     */
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        int character = input.LT(1);
        BsjLexerDiagnostic diagnostic = BsjAntlrParserUtils.convertFromLexer(
                e, tokenNames, getSourceLocation(), character);
        reportDiagnostic(diagnostic, true);
    }
}

@parser::header{
    package edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr;
    
    import java.io.ByteArrayOutputStream;
    import java.io.PrintStream;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collection;
    import java.util.Collections;
    import java.util.List;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.Stack;
    
    import javax.tools.Diagnostic;
    import javax.tools.DiagnosticListener;
    import javax.tools.JavaFileObject;

    import org.apache.log4j.Logger;

    import edu.jhu.cs.bsj.compiler.ast.*;
    import edu.jhu.cs.bsj.compiler.ast.node.*;
    import edu.jhu.cs.bsj.compiler.ast.node.list.*;
    import edu.jhu.cs.bsj.compiler.ast.node.meta.*;
    import edu.jhu.cs.bsj.compiler.ast.util.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.parser.*;
    import edu.jhu.cs.bsj.compiler.impl.diagnostic.*;
    import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.*;
    
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.*;
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.util.BsjAntlrParserUtils;
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.util.BsjParserConfiguration;

    import edu.jhu.cs.bsj.compiler.tool.typechecker.*;
}

@parser::members {
    // *** LOG4J **************************************************************
    private Logger logger = Logger.getLogger(this.getClass());
    
    // *** BSJ PARSING CONTROL ************************************************
    /** The configuration of this parser. */
    private BsjParserConfiguration configuration = BsjParserConfiguration.BSJ_1_0;
    /**
     * Changes the configuration of this parser.
     */
    public void setConfiguration(BsjParserConfiguration configuration)
    {
        this.configuration = configuration;
    }
    
    // *** SOURCE LOCATION TRACKING *******************************************
    /** The resource which is being parsed. */
    private String resourceName;
    /**
     * Produces a resource name for the resource in this parser.
     */
    public String getResourceName()
    {
        return (this.resourceName == null) ? "<unknown>" : resourceName;
    }
    /**
     * Produces a resource name for the resource in this parser.
     */
    public void setResourceName(String resourceName)
    {
        this.resourceName = resourceName;
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getLineNumber(int rel)
    {
        return getLineNumber(input.LT(rel));
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getColumnNumber(int rel)
    {
        return getColumnNumber(input.LT(rel));
    }
    /**
     * Retrieves the line number for the specified token.
     */
    protected int getLineNumber(Token token)
    {
        if (token == null)
        {
            return BsjSourceLocation.NOPOS;
        } else
        {
            return token.getLine();
        }
    }
    /**
     * Retrieves the line number for the specified token.
     */
    protected int getColumnNumber(Token token)
    {
        if (token == null)
        {
            return BsjSourceLocation.NOPOS;
        } else
        {
            return token.getCharPositionInLine() + 1;
        }
    }
    /**
     * Retrieves a source location object describing the start of the specified relative token index (as per input.LT).
     */
    protected BsjSourceLocation getSourceLocation(int rel)
    {
        return new BsjSourceLocation(getResourceName(), getLineNumber(rel), getColumnNumber(rel));
    }
    /**
     * Retrieves a source location object describing the start of the specified relative token index (as per input.LT).
     */
    protected BsjSourceLocation getSourceLocation(Token token)
    {
        return new BsjSourceLocation(getResourceName(), getLineNumber(token), getColumnNumber(token));
    }

    // *** FACTORY NODE PROPERTY **********************************************
    /**
     * Factory used to generate nodes for the parser.
     */
    private BsjNodeFactory factory;
    
    public BsjNodeFactory getFactory()
    {
        return this.factory;
    }
    
    /** Used to override the factory's concept of source locations for the current node.  If set, the factory will not
     *  assign source locations (meaning that the caller of the make method must provide them). */
    private boolean factorySourceLocationOverride = false;
    
    public void setFactory(BsjNodeFactory factory)
    {
        this.factory = new BsjNodeFactoryDecorator(factory)
        {
            protected void before()
            {
                if (!factorySourceLocationOverride)
                {
                    BsjSourceLocation start = 
                            new BsjSourceLocation(getResourceName(), $Rule::firstToken.getLine(),
                                    $Rule::firstToken.getCharPositionInLine() + 1);
                    setStartSourceLocation(start);
                    
                    BsjSourceLocation stop;
                    Token token = input.LT(-1);
                    if (token == null)
                    {
                        stop = new BsjSourceLocation(getResourceName(), BsjSourceLocation.NOPOS, BsjSourceLocation.NOPOS);
                    } else
                    {
                        stop = new BsjSourceLocation(getResourceName(), token.getLine(),
                                token.getCharPositionInLine() + token.getText().length() + 1);
                    }
                    
                    // If the start location is greater than the stop location, then the last token consumed appears
                    // before the next token when the rule started.  In other words, the rule consumed no tokens.
                    // Therefore, we give the stop location as matching the start location.
                    if (start.compareTo(stop) > 0)
                    {
                        stop = start;
                    }
                    setStopSourceLocation(stop);
                    
                    if (logger.isTraceEnabled())
                    {
                        logger.trace("Created node while parsing rule " + $Rule::name);
                        logger.trace("First token = " +
                                (($Rule::firstToken==null)?
                                "null" : ($Rule::firstToken.getText())) +
                                " at " + start);
                        logger.trace("Last token = " +
                                ((token==null)?
                                "null" : (token.getText())) +
                            " at " + stop);
                    }
                }
            }
            
            protected void after(Node node)
            {
                if (logger.isTraceEnabled())
                {
                    logger.trace("Instantiated node of type " + node.getClass().getSimpleName() + " as " +
                            node.toString());
                    logger.trace("input.LT(1) = " + input.LT(1));
                    logger.trace("input.LT(-1) = " + input.LT(-1));
                }
            }
        };
    }
    
    // *** SUPPORT FOR MODIFIER PARSING ***************************************
    enum Modifier // does not cover access modifiers
    {
        ABSTRACT, 
        FINAL,
        NATIVE,
        PRIVATE,
        PROTECTED,
        PUBLIC,
        STATIC,
        STRICTFP,
        SYNCHRONIZED,
        TRANSIENT,
        VOLATILE
    }
    enum ModifierState
    {
        DISALLOWED,
        NOT_SEEN,
        SEEN
    }
    class ModifierSet
    {
        ModifierState[] state = new ModifierState[Modifier.values().length];
        public ModifierSet(Modifier... allowed)
        {
            for (int i=0;i<state.length;i++)
            {
                state[i] = ModifierState.DISALLOWED;
            }
            for (int i=0;i<allowed.length;i++)
            {
                state[allowed[i].ordinal()] = ModifierState.NOT_SEEN;
            }
        }
        public boolean has(Modifier mod)
        {
            return (state[mod.ordinal()] == ModifierState.SEEN);
        }
        public void notifySeen(Modifier mod)
        {
            switch (state[mod.ordinal()])
            {
                case DISALLOWED:
                    reportDiagnostic(new InvalidModifierDiagnosticImpl(
                            getSourceLocation(-1),
                            $Rule::name,
                            mod.toString().toLowerCase()));
                    break;
                case NOT_SEEN:
                    state[mod.ordinal()] = ModifierState.SEEN;
                    break;
                case SEEN:
                    reportDiagnostic(new DuplicateModifierDiagnosticImpl(
                            getSourceLocation(-1),
                            $Rule::name,
                            mod.toString().toLowerCase()));
                    break;
            }
        }
    }
    
    // *** SUPPORT FOR MODE PARSING *******************************************
    class ModeValues
    {
        private MetaprogramLocalMode localMode = null;
        private MetaprogramPackageMode packageMode = null;
        
        private boolean checkDuplicateOrConflicting(Object oldObj, Object newObj, BsjSourceLocation location)
        {
            if (oldObj == null)
                return false;
            
            if (oldObj == newObj)
            {
                reportDiagnostic(new DuplicateModeDiagnosticImpl(
                        location,
                        $Rule::name,
                        newObj.toString()));
            } else
            {
                reportDiagnostic(new ConflictingModeDiagnosticImpl(
                        location,
                        $Rule::name,
                        oldObj.toString(),
                        newObj.toString()));
            }
            return true;
        }
        
        public void setLocalMode(MetaprogramLocalMode localMode, BsjSourceLocation location)
        {
            if (!checkDuplicateOrConflicting(this.localMode, localMode, location))
            {
                this.localMode = localMode;
            }
        }
        
        public void setPackageMode(MetaprogramPackageMode packageMode, BsjSourceLocation location)
        {
            if (!checkDuplicateOrConflicting(this.packageMode, packageMode, location))
            {
                this.packageMode = packageMode;
            }
        }
        
        public MetaprogramLocalMode getLocalMode()
        {
            if (this.localMode == null)
                return MetaprogramLocalMode.INSERT;
            else
                return this.localMode;
        }
        
        public MetaprogramPackageMode getPackageMode()
        {
            if (this.packageMode == null)
                return MetaprogramPackageMode.READ_ONLY;
            else
                return this.packageMode;
        }
        
        public void parse(IdentifierNode identifierNode)
        {
            String id = identifierNode.getIdentifier();
            BsjSourceLocation location = identifierNode.getStartLocation();
            if (id.equals("readOnly"))
            {
                setLocalMode(MetaprogramLocalMode.READ_ONLY, location);
            } else if (id.equals("insert"))
            {
                setLocalMode(MetaprogramLocalMode.INSERT, location);
            } else if (id.equals("mutate"))
            {
                setLocalMode(MetaprogramLocalMode.MUTATE, location);
            } else if (id.equals("fullMutate"))
            {
                setLocalMode(MetaprogramLocalMode.FULL_MUTATE, location);
            } else if (id.equals("packageRead"))
            {
                setPackageMode(MetaprogramPackageMode.READ_ONLY, location);
            } else if (id.equals("packageInsert"))
            {
                setPackageMode(MetaprogramPackageMode.INSERT, location);
            } else 
            {
                reportDiagnostic(new InvalidModeDiagnosticImpl(
                        location,
                        $Rule::name,
                        id));
            }
        }
    }
    
    // *** SUPPORT FOR TYPECHECKING SPLICES ***********************************
    /**
     * The current typechecker to use when typechecking splice expressions.  If <code>null</code>, splice expressions
     * are forbidden.
     */
    private BsjTypechecker spliceTypechecker;
    /**
     * The AST node that should be used for a typechecking context when typechecking splices.
     */
    private Node spliceContext;
    /**
     * Sets up the typechecking context for this parser.
     * @param spliceTypechecker The typechecker to use when checking splices or <code>null</code> if splices are not
     *                          allowed.
     * @param spliceContext The AST node that should be used for a typechecking context when typechecking splices.  If
     *                      <code>spliceTypechecker</code> is <code>null</code>, this value is ignored.
     */
    public void setTypecheckingContext(BsjTypechecker spliceTypechecker, Node spliceContext)
    {
        this.spliceTypechecker = spliceTypechecker;
        if (spliceTypechecker != null)
        {
            this.spliceContext = spliceContext;
        }
    }
    
    // *** ERROR REPORTING AND HANDLING ***************************************
    /** The diagnostic listener to which we report events. */
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;
    
    /** Assigns a diagnostic listener to this parser. */
    public void setDiagnosticListener(DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        this.diagnosticListener = diagnosticListener;
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(BsjDiagnostic diagnostic)
    {
        reportDiagnostic(diagnostic, false);
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(BsjDiagnostic diagnostic, boolean force)
    {
        if (logger.isTraceEnabled())
        {
            logger.trace("Received diagnostic (force="+force+",bt="+state.backtracking+"): "+diagnostic.getMessage(null));
        }
        if (state.backtracking == 0 || force)
        {
            this.diagnosticListener.report(diagnostic);
        }
    }
        
    /**
     * Overrides the mechanism for displaying recognition errors.  While it is possible to do something very similar by
     * overriding emitErrorMessage, this method is extracted instead in order to allow the exception itself to be
     * trapped for more informative error handling.
     */
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        BsjDiagnostic diagnostic =
                BsjAntlrParserUtils.convertFromParser(e, tokenNames, getSourceLocation(1), input.LT(1), $Rule::name);
        reportDiagnostic(diagnostic, true);
    }
    
    // *** PARSING ACTION SUPPORT *********************************************
    // Extracts the content of a javadoc comment into a string.
    public static String parseJavadoc(String input)
    {
       // verify that this is a stored javadoc
       input = input.trim();
       if (!(input.startsWith("/**") && input.endsWith("*/")))
       {
         throw new IllegalStateException("Invalid javadoc comment");
       }
       
       // remove /** and */
       input = input.substring(3, input.length()-2);
       
       // parse out individual lines
       String tokens[] = input.split("\n");
       StringBuilder ret = new StringBuilder();
       for (String temp : tokens)
       {
         temp = temp.trim();
         if (!temp.isEmpty() && temp.charAt(0) == '*')
         {
           temp = temp.replaceFirst("\\*", "");
         }
         ret.append(temp.trim()).append("\n");
       }
       
       return ret.toString().trim();
    }
    
    /**
     * Creates a splice node given the specified expression.  This method is parameterized so as to select the type
     * of created splice node based on the type of the provided class.
     */ 
    private <T extends Node> NodeUnion<T> createSpliceNodeUnion(Class<T> expectedType, ExpressionNode expr)
    {
       return factory.<T>makeSpliceNodeUnion(factory.makeSpliceNode(expr));
    }
    
    /**
     * Creates a duplicate copy of the provided node's union.  Casts that copy to the provided type.
     * @param union The union to copy.
     * @param type The type of the node in the union.
     * @return The copied union.
     */
    private <T extends Node> NodeUnion<T> deepCopyUnion(NodeUnion<? extends T> union, Class<T> type)
    {
        switch (union.getType())
        {
            case NORMAL:
                return factory.<Node>makeNormalNodeUnion(union.getNormalNode().deepCopy(factory)).castNodeType(factory, type);
            case SPLICE:
                return factory.<T>makeSpliceNodeUnion(union.getSpliceNode());
            default:
                throw new IllegalStateException("Unknown union type: " + union.getType());
        }
    }
    
    /**
     * Performs type wrapping for a counted array type.
     * @param type The node representing the type which is wrapped in array levels.
     * @param levels The number of levels to wrap.
     * @return The resulting type.
     */
    private NodeUnion<? extends ArrayTypeNode> wrapArrayLevels(NodeUnion<? extends TypeNode> type, int levels)
    {
        if (levels < 1)
            throw new IllegalArgumentException("Invalid number of array levels: " + levels);
        
        NodeUnion<? extends ArrayTypeNode> ret = factory.makeNormalNodeUnion(factory.makeArrayTypeNodeWithUnions(type));
        for (int i=1;i<levels;i++)
        {
            ret = factory.makeNormalNodeUnion(factory.makeArrayTypeNodeWithUnions(ret));
        }        
        return ret;
    }
    
    // *** RULE AOP METHODS ***************************************************
    private void ruleStart(String ruleName)
    {
        $Rule::name = ruleName;
        $Rule::firstToken = input.LT(1);
        if (logger.isTraceEnabled())
        {
            logger.trace("Rule started: " + ruleName);
            logger.trace("    currently at " + getSourceLocation(1) + " with token text '" + input.LT(1).getText() +
                    "' and backtracking = " + state.backtracking);
            StringBuilder sb = new StringBuilder("    Rule stack: ");
            boolean first = true;
            List<Rule_scope> rules = new java.util.LinkedList<Rule_scope>();
            for (Object ruleObj : Rule_stack)
            {
                rules.add(0, (Rule_scope)ruleObj);
            }
            for (Rule_scope rule : rules)
            {
                if (!first)
                    sb.append(" << ");
                sb.append(rule.name);
                first = false;
            }
            logger.trace(sb.toString());
        }
    }
    
    private void ruleStop()
    {
        if (logger.isTraceEnabled())
        {
            logger.trace("Rule stopped: " + $Rule::name);
        }
    }
}

@synpredgate { true }

/********************************************************************************************
                          Parser section
*********************************************************************************************/

/* ===========================================================================
 * These rules only exist in the parser.  They may map to the language standard but are primarily used to abstract
 * away parser patterns and may not manifest in the AST. 
 * ===========================================================================
 */

// Represents the declaration of an array type over a normal type.  This construct parses the [] symbols and returns
// a count of the number encountered.  Note that this rule must parse at least one pair of brackets; thus, it
// should be optional anywhere that a non-array type is permissible.
arrayTypeCounter returns [int ret]
        scope Rule;
        @init {
            ruleStart("arrayTypeCounter");
        }
        @after {
            ruleStop();
        }
    :
        '[' ']'
        {
            $ret = 1;
        }
        (
            '[' ']'
            {
                $ret++;
            }
        )*
    ;

/* ===========================================================================
 * These are the BSJ grammar rules.
 * ===========================================================================
 */

/* This rule parses a BSJ metaprogram. */
bsjMetaprogram /*%% standardRuleIntro= type=MetaprogramNode %%*/
    :
        /*%% spliceClause= type=MetaprogramNode %%*/
        '[:'
        preamble
        optionalBlockStatementList
        ':]'
        {
            $ret = factory.makeNormalNodeUnion(
                    factory.makeMetaprogramNodeWithUnions($preamble.ret, $optionalBlockStatementList.ret));
        }
    ;

/* This rule parses a BSJ metaprogram preamble */
preamble /*%% standardRuleIntro= type=MetaprogramPreambleNode
                  init0="""MetaprogramPackageMode packageMode = MetaprogramPackageMode.READ_ONLY;"""
                  init1="""MetaprogramLocalMode localMode = MetaprogramLocalMode.INSERT;""" %%*/
    :
        /*%% spliceClause= type=MetaprogramPreambleNode %%*/
        optionalMetaImportDeclarations
        (
            metaprogramMode
            {
                packageMode = $metaprogramMode.packageMode;
                localMode = $metaprogramMode.localMode;
            }
        )?
        optionalMetaprogramTargetList
        optionalMetaprogramDependencyDeclarationList
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramPreambleNodeWithUnions($optionalMetaImportDeclarations.ret,
                    localMode, packageMode, $optionalMetaprogramTargetList.ret,
                    $optionalMetaprogramDependencyDeclarationList.ret));
        }
    ;

metaprogramImport /*%% standardRuleIntro= type=MetaprogramImportNode %%*/
    :   
        /*%% spliceClause= type=MetaprogramImportNode %%*/
        '#import'
        metaprogramImportBody
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramImportNodeWithUnions(
                    $metaprogramImportBody.ret));
        }
    ;

metaprogramImportBody /*%% standardRuleIntro= type=ImportNode %%*/
    :
        /*%% spliceClause= type=ImportNode %%*/
        importBody
        {
            $ret = $importBody.ret;
        }
    ;
    
metaprogramMode returns [MetaprogramPackageMode packageMode, MetaprogramLocalMode localMode]
        scope Rule;
        @init {
            ruleStart("metaprogramMode");
            ModeValues modeValues = new ModeValues();
        }
        @after {
            $packageMode = modeValues.getPackageMode();
            $localMode = modeValues.getLocalMode();
            ruleStop();
        }
    :
        '#mode'
        (
            a=unsplicableIdentifier
            {
                modeValues.parse($a.ret);
            }
            (
                ','
                b=unsplicableIdentifier
                {
                    modeValues.parse($b.ret);
                }
            )*
            ','?
        )?
        ';'
    ;

metaprogramDependencyDeclarationList /*%% generateListRule= type=MetaprogramDependencyDeclarationListNode %%*/ :;

metaprogramDependencyDeclaration /*%% standardRuleIntro= type=MetaprogramDependencyDeclarationNode %%*/
    :   
        /*%% spliceClause= type=MetaprogramDependencyDeclarationNode %%*/
        '#depends'
        metaprogramDependencyList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(
                    factory.makeMetaprogramDependencyDeclarationNodeWithUnions($metaprogramDependencyList.ret));
        }
    ;

metaprogramDependencyList /*%% generateListRule= type=MetaprogramDependencyListNode
                      separator=',' lastSeparator=true %%*/ :;

metaprogramDependency /*%% standardRuleIntro: type:MetaprogramDependencyNode
                               init0:"""boolean weak = false;""" %%*/ 
    :
        /*%% spliceClause= type=MetaprogramDependencyNode %%*/
        (
            '#weak'
            {
                weak = true;
            }
        )?
        metaprogramTargetName
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramDependencyNodeWithUnions($metaprogramTargetName.ret, weak));
        }
    ;

metaprogramTargetList /*%% generateListRule= type=MetaprogramTargetListNode %%*/ :;

metaprogramTarget /*%% standardRuleIntro= type=MetaprogramTargetNode %%*/
    :
        /*%% spliceClause= type=MetaprogramTargetNode %%*/   
        '#target'
        identifierList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramTargetNodeWithUnions($identifierList.ret));
        }
    ;

metaprogramTargetName /*%% standardRuleIntro= type=NameNode %%*/
    :
        name
        {
            $ret = $name.ret;
        }
    ;

identifierList /*%% generateListRule= type=IdentifierListNode
                      separator=',' lastSeparator=true %%*/ :;

typeDeclarationBsjMetaprogramAnchor /*%% standardRuleIntro= type=TypeDeclarationMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeDeclarationMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;    

annotationMemberBsjMetaprogramAnchor /*%% standardRuleIntro= type=AnnotationMemberMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

anonymousClassMemberBsjMetaprogramAnchor /*%% standardRuleIntro= type=AnonymousClassMemberMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

classMemberBsjMetaprogramAnchor /*%% standardRuleIntro= type=ClassMemberMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

interfaceMemberBsjMetaprogramAnchor /*%% standardRuleIntro= type=InterfaceMemberMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

blockStatementBsjMetaprogramAnchor /*%% standardRuleIntro= type=BlockStatementMetaprogramAnchorNode %%*/
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBlockStatementMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

// Parses a list of meta-annotations.  Note that this rule is not used for declarations, since meta-annotations can be
// interspersed amongst annotations and modifiers.  This rule is used for meta-annotations which are applied to
// statements and other constructs which only permit meta-annotations and not other modifiers.
metaAnnotationList /*%% generateListRule= type=MetaAnnotationListNode %%*/ :;

// Parses a meta-annotation.
// For example, in
//     @@Test("foo")
//     public void foo() { }
// This rule would parse
//     @@Test("foo")
metaAnnotation /*%% standardRuleIntro= type=MetaAnnotationNode %%*/
    :   
        {configuration.getMetaAnnotationsSupported()}?=>
        (
            /*%% spliceClause= type=MetaAnnotationNode %%*/
            '@' '@' unparameterizedType
            (
                (
                    '('   
                    (
                        optionalMetaAnnotationElementValuePairs
                        {
                            $ret = factory.makeNormalNodeUnion(
                                       factory.makeNormalMetaAnnotationNodeWithUnions(
                                               $optionalMetaAnnotationElementValuePairs.ret,
                                               $unparameterizedType.ret));
                        }
                    |
                        metaAnnotationElementValue
                        {
                            $ret = factory.makeNormalNodeUnion(
                                       factory.makeSingleElementMetaAnnotationNodeWithUnions(
                                           $metaAnnotationElementValue.ret,
                                           $unparameterizedType.ret));
                        }
                    )? 
                    ')' 
                )
            |
                {
                    $ret = factory.makeNormalNodeUnion(
                               factory.makeNormalMetaAnnotationNodeWithUnions(
                                   factory.makeNormalNodeUnion(factory.makeMetaAnnotationElementListNode()),
                                   $unparameterizedType.ret));
                }            
            )
        )
    ;

// Parses a meta-annotation's element-value pairs.
// For example, in
//     @@Foo(bar="baz",happy=5)
// this rule would parse
//     bar="baz",happy=5
metaAnnotationElementValuePairs /*%% generateListRule= type=MetaAnnotationElementListNode
                      componentName=metaAnnotationElementValuePair
                      separator=',' lastSeparator=false %%*/ :;

// Parses a single meta-annotation element-value pair.
// For example, in
//     @@Foo(bar="baz",happy=5)
// this rule would parse either
//     bar="baz"
// or
//     happy=5
metaAnnotationElementValuePair /*%% standardRuleIntro= type=MetaAnnotationElementNode %%*/
    :
        /*%% spliceClause= type=MetaAnnotationElementNode %%*/
        id=identifier '=' metaAnnotationElementValue
        {
            $ret = factory.makeNormalNodeUnion(
                    factory.makeMetaAnnotationElementNodeWithUnions($id.ret, $metaAnnotationElementValue.ret));
        }
    ;

// Parses a meta-annotation element value.
// For example, in
//    @@Ann(a=5,b={7,8},c=@@Test)
// this rule would parse one of
//    5
// or
//    {7,8}
// or
//    @@Test
metaAnnotationElementValue /*%% standardRuleIntro= type=MetaAnnotationValueNode %%*/
    :
        /*%% spliceClause= type=MetaAnnotationValueNode nontype0=MetaAnnotationArrayValueNode %%*/   
        conditionalExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationExpressionValueNodeWithUnions($conditionalExpression.ret));
        }
    |   
        metaAnnotation
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationMetaAnnotationValueNodeWithUnions($metaAnnotation.ret));
        }
    |   
        metaAnnotationElementValueArrayInitializer
        {
            $ret = $metaAnnotationElementValueArrayInitializer.ret;
        }
    ;

// Parses a meta-annotation element value list.
// For example, in
//     @@Ann({@@Foo,@@Bar(5)})
// this rule would parse
//     @@Foo,@@Bar(5)
// and in
//     @@Test({1,2,3})
// this rule would parse
//     1,2,3
metaAnnotationElementValues /*%% generateListRule= type=MetaAnnotationValueListNode
                      componentName=metaAnnotationElementValue
                      separator=',' lastSeparator=false %%*/ :;

// Parses a meta-annotation element array.
// For example, in
//     @@Ann({@@Foo,@@Bar(5)})
// this rule would parse
//     {@@Foo,@@Bar(5)}
// and in
//     @@Test({1,2,3})
// this rule would parse
//     {1,2,3}
metaAnnotationElementValueArrayInitializer /*%% standardRuleIntro= type=MetaAnnotationArrayValueNode %%*/
    :   
        /*%% spliceClause= type=MetaAnnotationArrayValueNode %%*/
        '{'
        optionalMetaAnnotationElementValues
        {
            $ret = factory.makeNormalNodeUnion(
                        factory.makeMetaAnnotationArrayValueNodeWithUnions($optionalMetaAnnotationElementValues.ret));
        }
        ','?
        '}'
    ;

// Parses a code literal
codeLiteral /*%% standardRuleIntro= type=RawCodeLiteralNode %%*/
    :
        {configuration.getCodeLiteralsSupported()}?=>
        (
            /*%% spliceClause= type=RawCodeLiteralNode %%*/
            '<:'
            codeLiteralBody
            ':>'
            {
                $ret = factory.makeNormalNodeUnion(factory.makeRawCodeLiteralNode(new BsjRawCodeLiteralPayloadAntlrImpl(
                        getResourceName(),
                        $codeLiteralBody.ret)));
            }
        )
    ;

// Parses the body of a raw code literal
codeLiteralBody returns [List<BsjTokenImpl> ret]
        scope Rule;
        @init {
            ruleStart("codeLiteralBody");
            $ret = new ArrayList<BsjTokenImpl>();
        }
        @after {
            ruleStop();
        }
    :
        (
            anyNonCodeLiteralToken
            {
                $ret.add($anyNonCodeLiteralToken.ret);
            }
        |
            '<:'
            {
                $ret.add(new BsjTokenImpl(input.get(input.index()-1)));
            }
            inner=codeLiteralBody
            {
                $ret.addAll($inner.ret);
            }
            ':>'
            {
                $ret.add(new BsjTokenImpl(input.get(input.index()-1)));
            }
        )+
    ;

// This rule matches exactly one token which is not a code literal delimiter
anyNonCodeLiteralToken /*%% standardRuleIntro= type=BsjTokenImpl %%*/
    :
        ~(CODELITERAL_START | CODELITERAL_STOP)
        {
            $ret = new BsjTokenImpl(input.get(input.index()-1));
        }
    ;

// This rule matches a code splice.  The output type is "Node" because any grammar rule may call this routine; the
// type parameter of the union does not represent a splice but instead represents the value that would be present
// normally.  The caller of this grammar rule must perform a runtime-checked cast of the resulting union to get the
// desired result (which will always be safe if the cast uses the expected type provided here).
splice /*%% standardRuleIntro= ruleParams="""Class<? extends Node> expectedType, List<Class<? extends Node>> forbiddenTypes"""
            type=Node initvar0=BsjTypechecker option0="""memoize=false;""" %%*/
    :
        {configuration.getCodeSplicingSupported()}?=>
        (
            '~:'
            {
                this.spliceTypechecker != null// are splices allowed right now?
            }?
            {
                // Disable the typechecker while parsing the following splice expression (so that it does not contain
                // splices)
                bsjTypechecker = this.spliceTypechecker;
                this.spliceTypechecker = null;
            }
            expression
            {
                // Now put the splice typechecker back
                this.spliceTypechecker = bsjTypechecker;
            }
            ':~'
            {
                BsjAntlrParserUtils.isValidExpressionType("splice", this.spliceTypechecker, this.spliceContext,
                        $expression.ret, expectedType, forbiddenTypes, input)
            }?
            {
                $ret = createSpliceNodeUnion(expectedType, $expression.ret.getNormalNode());
            }
        )
    ;

/* ===========================================================================
 * These are the Java grammar rules.
 * ===========================================================================
 */

compilationUnit /*%% standardRuleIntro= ruleParams="""String name""" type=CompilationUnitNode %%*/
    :
        /*%% spliceClause= type=CompilationUnitNode %%*/
        packageDeclaration?
        optionalMetaImportDeclarations
        optionalImportDeclarations
        optionalTypeDeclarations
        EOF
        {
            $ret = factory.makeNormalNodeUnion(factory.makeCompilationUnitNodeWithUnions(
                        name,
                        $packageDeclaration.ret,
                        $optionalMetaImportDeclarations.ret,
                        $optionalImportDeclarations.ret,
                        $optionalTypeDeclarations.ret));
        }
    ;

packageDeclaration /*%% standardRuleIntro= type=PackageDeclarationNode %%*/
    :
        /*%% spliceClause= type=PackageDeclarationNode %%*/
        modifiers[false]
        'package' name ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makePackageDeclarationNodeWithUnions(
                    $name.ret,
                    factory.makeNormalNodeUnion($modifiers.metaAnnotations),
                    factory.makeNormalNodeUnion($modifiers.annotations)));
        }
    ;

metaImportDeclarations /*%% generateListRule= type=MetaprogramImportListNode
                      componentName=metaprogramImport %%*/ :;

importDeclarations /*%% generateListRule= type=ImportListNode
                      componentName=importDeclaration %%*/ :;

importBody /*%% standardRuleIntro= type=ImportNode %%*/
    :
        /*%% deferProduction= rule0=importStaticOnDemandBody
                              rule1=importStaticSingleBody
                              rule2=importOnDemandBody
                              rule3=importSingleBody %%*/
    ;

importStaticOnDemandBody /*%% standardRuleIntro= type=StaticImportOnDemandNode %%*/
    :
        'static' name '.' '*'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeStaticImportOnDemandNodeWithUnions($name.ret));
        }
    ;

importStaticSingleBody /*%% standardRuleIntro= type=SingleStaticImportNode %%*/
    :
        'static' separatedQualifiedName
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSingleStaticImportNodeWithUnions(
                    $separatedQualifiedName.name, $separatedQualifiedName.ident));
        }
    ;

importOnDemandBody /*%% standardRuleIntro= type=ImportOnDemandNode %%*/
    :
        name '.' '*'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeImportOnDemandNodeWithUnions($name.ret));
        }
    ;

importSingleBody /*%% standardRuleIntro= type=ImportSingleTypeNode %%*/
    :
        name
        {
            $ret = factory.makeNormalNodeUnion(factory.makeImportSingleTypeNodeWithUnions($name.ret));
        }
    ;

importDeclaration /*%% standardRuleIntro= type=ImportNode %%*/
    :
        /*%% spliceClause= type=ImportNode %%*/
        'import'
        importBody
        ';'
        {
            $ret = $importBody.ret;
        }
    ;

javadoc returns [NodeUnion<JavadocNode> ret] // TODO: parse out Javadoc contents
        scope Rule;
        @init{
            ruleStart("javadoc");
            int index = input.index();
            while(--index >= 0)
            {
                if (input.get(index).getType() == BsjAntlrLexer.COMMENT)
                {
                    Token token = input.get(index);
                    BsjSourceLocation startSourceLocation = new BsjSourceLocation(
                            getResourceName(), token.getLine(), token.getCharPositionInLine() + 1);
                    BsjSourceLocation stopSourceLocation = new BsjSourceLocation(
                            getResourceName(), token.getLine(),
                            token.getCharPositionInLine() + token.getText().length() + 1);
                    factory.setStartSourceLocation(startSourceLocation);
                    factory.setStopSourceLocation(stopSourceLocation);
                    factorySourceLocationOverride = true;
                    $ret = factory.makeNormalNodeUnion(factory.makeJavadocNode(parseJavadoc(token.getText())));
                    factorySourceLocationOverride = false;
                    break;
                }
                else if  (input.get(index).getChannel() == org.antlr.runtime.Token.DEFAULT_CHANNEL)
                {
                    break;
                }       
            }
        }
        @after {
            ruleStop();
        }
    :
    ;

typeDeclarations /*%% generateListRule= type=TypeDeclarationListNode
                      componentName=typeDeclaration %%*/ :;

typeDeclaration /*%% standardRuleIntro= type=TypeDeclarationNode %%*/
    :
        /*%% spliceClause= type=TypeDeclarationNode
                           nontype0=ClassDeclarationNode
                           nontype1=EnumDeclarationNode
                           nontype2=InterfaceDeclarationNode
                           nontype3=AnnotationDeclarationNode
                           nontype4=NoOperationNode %%*/
        classOrInterfaceDeclaration
        {
            $ret = $classOrInterfaceDeclaration.ret;
        }
    |
        noOp
        {
            $ret = $noOp.ret;
        }
    |
        {configuration.getMetaprogramsSupported()}?=> typeDeclarationBsjMetaprogramAnchor
        {
            $ret = $typeDeclarationBsjMetaprogramAnchor.ret;
        }
    ;

noOp /*%% standardRuleIntro= type=NoOperationNode %%*/
    :
        /*%% spliceClause= type=NoOperationNode %%*/
        optionalMetaAnnotationList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeNoOperationNodeWithUnions($optionalMetaAnnotationList.ret));
        }
    ;

classOrInterfaceDeclaration /*%% standardRuleIntro= type=TypeDeclarationNode %%*/
    :
        (classHeader | enumHeader) => classDeclaration
        {
            $ret = $classDeclaration.ret;
        }
    |
        interfaceDeclaration
        {
            $ret = $interfaceDeclaration.ret;
        }
    ;
    
// Parses a set of modifiers.  As input, the caller must specify:
// * whether or not access modifiers are allowed (if false, access modifiers are parsed like normal modifiers)
// * a list of those modifiers which are allowed
modifiers[boolean accessAllowed, Modifier... mods]
    returns [ModifierSet modifiers, AccessModifier access, AnnotationListNode annotations,
             MetaAnnotationListNode metaAnnotations]
        scope Rule;
        @init {
            ruleStart("modifiers");
            List<NodeUnion<? extends AnnotationNode>> annotationList =
                    new ArrayList<NodeUnion<? extends AnnotationNode>>();
            List<NodeUnion<? extends MetaAnnotationNode>> metaAnnotationList =
                    new ArrayList<NodeUnion<? extends MetaAnnotationNode>>();
            $access = AccessModifier.PACKAGE;
            $modifiers = new ModifierSet(mods);
            AccessModifier currentAccess = null;
            Modifier accessAsModifier = null;
        }
        @after {
            $annotations = factory.makeAnnotationListNodeWithUnions(annotationList);
            $metaAnnotations = factory.makeMetaAnnotationListNodeWithUnions(metaAnnotationList);
            ruleStop();
        }
    :
        (
            metaAnnotation
            {
                // TODO: fix with error nodes
                if ($metaAnnotation.ret != null && $metaAnnotation.ret.getNodeValue() != null)
                {
                    metaAnnotationList.add($metaAnnotation.ret);
                } else
                {
                    reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                            getSourceLocation($metaAnnotation.start),
                            "metaAnnotation",
                            getSourceLocation($metaAnnotation.stop)));
                }
            }
        |
            annotation
            {
                // TODO: fix with error nodes
                if ($annotation.ret != null && $annotation.ret.getNodeValue() != null)
                {
                    annotationList.add($annotation.ret);
                } else
                {
                    reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                            getSourceLocation($annotation.start),
                            "annotation",
                            getSourceLocation($annotation.stop)));
                }
            }
        |
            (
                'public'
                {
                    currentAccess = AccessModifier.PUBLIC;
                    accessAsModifier = Modifier.PUBLIC;
                }
            |
                'protected'
                {
                    currentAccess = AccessModifier.PROTECTED;
                    accessAsModifier = Modifier.PROTECTED;
                }
            |
                'private'
                {
                    currentAccess = AccessModifier.PRIVATE;
                    accessAsModifier = Modifier.PRIVATE;
                }
            )
            {
                if (accessAllowed)
                {
                    if ($access != AccessModifier.PACKAGE)
                    {
                        if ($access == currentAccess)
                        {
                            reportDiagnostic(new DuplicateModifierDiagnosticImpl(
                                    getSourceLocation(-1),
                                    $Rule::name,
                                    currentAccess.toString().toLowerCase()));
                        } else
                        {
                            reportDiagnostic(new ConflictingAccessModifierDiagnosticImpl(
                                    getSourceLocation(-1),
                                    $Rule::name,
                                    $access.toString().toLowerCase(),
                                    currentAccess.toString().toLowerCase()));
                        }
                    } else
                    {
                        $access = currentAccess;
                    }
                } else
                {
                    $modifiers.notifySeen(accessAsModifier);
                }
            }
        |
            'abstract'
            {
                $modifiers.notifySeen(Modifier.ABSTRACT);
            }
        |
            'final'
            {
                $modifiers.notifySeen(Modifier.FINAL);
            }
        |
            'native'
            {
                $modifiers.notifySeen(Modifier.NATIVE);
            }
        |
            'static'
            {
                $modifiers.notifySeen(Modifier.STATIC);
            }
        |
            'strictfp'
            {
                $modifiers.notifySeen(Modifier.STRICTFP);
            }
        |
            'synchronized'
            {
                $modifiers.notifySeen(Modifier.SYNCHRONIZED);
            }
        |
            'transient'
            {
                $modifiers.notifySeen(Modifier.TRANSIENT);
            }
        |
            'volatile'
            {
                $modifiers.notifySeen(Modifier.VOLATILE);
            }
        )*
    ;

annotationMethodModifiers /*%% generateModifierRule= opmod0=PUBLIC opmod1=ABSTRACT access=false %%*/ :;
annotationModifiers /*%% generateModifierRule= opmod0=ABSTRACT mod0=STATIC mod1=STRICTFP access=true %%*/ :;     
classModifiers /*%% generateModifierRule= mod0=ABSTRACT mod1=STATIC mod2=FINAL mod3=STRICTFP access=true %%*/ :;
constantModifiers /*%% generateModifierRule= opmod0=PUBLIC opmod1=STATIC opmod2=FINAL access=false %%*/ :;
constructorModifiers /*%% generateModifierRule= access=true %%*/ :;
enumConstantModifiers /*%% generateModifierRule= access=false %%*/ :;
enumModifiers /*%% generateModifierRule= opmod0=STATIC mod0=STRICTFP access=true %%*/ :;
fieldModifiers /*%% generateModifierRule= mod0=STATIC mod1=FINAL mod2=TRANSIENT mod3=VOLATILE access=true %%*/ :;
localClassModifiers /*%% generateModifierRule= mod0=ABSTRACT mod1=FINAL mod2=STRICTFP access=false %%*/ :;
interfaceModifiers /*%% generateModifierRule= opmod0=ABSTRACT mod0=STATIC mod1=STRICTFP access=true %%*/ :;
methodModifiers /*%% generateModifierRule= mod0=ABSTRACT mod1=STATIC mod2=FINAL mod3=SYNCHRONIZED mod4=NATIVE
                         mod5=STRICTFP access=true %%*/ :;
variableModifiers /*%% generateModifierRule= mod0=FINAL access=false %%*/ :;

classDeclaration /*%% standardRuleIntro= type=TypeDeclarationNode %%*/
    :
        (classHeader)=>normalClassDeclaration
        {
            $ret = $normalClassDeclaration.ret;
        }
    |
        enumDeclaration
        {
            $ret = $enumDeclaration.ret;
        }
    ;

normalClassDeclaration /*%% standardRuleIntro= type=ClassDeclarationNode initvar0=DeclaredTypeListNode %%*/
    :   
        /*%% spliceClause= type=ClassDeclarationNode %%*/
        javadoc classModifiers
        'class' id=identifier
        optionalTypeParameters
        ('extends' classOrInterfaceType)?
        (
            'implements' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?            
        classBody
        {            
            $ret = factory.makeNormalNodeUnion(factory.makeClassDeclarationNodeWithUnions(
                    $classModifiers.ret,
                    $classOrInterfaceType.ret,
                    declaredTypeListNode,
                    $classBody.ret,
                    $optionalTypeParameters.ret,                    
                    $id.ret,
                    $javadoc.ret));
        }
    ;

localClassDeclaration /*%% standardRuleIntro= type=LocalClassDeclarationNode initvar0=DeclaredTypeListNode %%*/
    :   
        /*%% spliceClause= type=LocalClassDeclarationNode %%*/
        javadoc localClassModifiers
        'class' id=identifier
        optionalTypeParameters
        ('extends' classOrInterfaceType)?
        (
            'implements' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?            
        classBody
        {            
            $ret = factory.makeNormalNodeUnion(factory.makeLocalClassDeclarationNodeWithUnions(
                    $localClassModifiers.ret,
                    $classOrInterfaceType.ret,
                    declaredTypeListNode,
                    $classBody.ret,
                    $optionalTypeParameters.ret,                    
                    $id.ret,
                    $javadoc.ret));
        }
    ;

typeParameters /*%% generateListRule= type=TypeParameterListNode
                      componentName=typeParameter separator=',' lastSeparator=false
                      prefix='<' postfix='>' %%*/ :;

typeParameter /*%% standardRuleIntro= type=TypeParameterNode initvar0=typeBoundNode:DeclaredTypeListNode %%*/
    :
        /*%% spliceClause= type=TypeParameterNode %%*/
        id=identifier
        (
            'extends' typeBound
            {
                typeBoundNode = $typeBound.ret;
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeParameterNodeWithUnions($id.ret, typeBoundNode));
        }        
    ;

typeBound /*%% generateListRule= type=DeclaredTypeListNode
                      componentName=classOrInterfaceType separator='&' lastSeparator=false %%*/ :;

enumDeclaration /*%% standardRuleIntro= type=EnumDeclarationNode initvar0=declaredTypeListNode:DeclaredTypeListNode %%*/
    :   
        /*%% spliceClause= type=EnumDeclarationNode %%*/
        javadoc enumModifiers
        'enum' 
        id=identifier
        (
            'implements' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?
        enumBody
        {
            $ret = factory.makeNormalNodeUnion(factory.makeEnumDeclarationNodeWithUnions(
                        $enumModifiers.ret,
                        declaredTypeListNode,
                        $enumBody.ret,
                        $id.ret,
                        $javadoc.ret));
        }
    ;

enumBody /*%% standardRuleIntro= type=EnumBodyNode initvar0=enumBodyDeclarationsNode:ClassMemberListNode %%*/
    :   
        /*%% spliceClause= type=EnumBodyNode %%*/
        '{'
        optionalEnumConstants
        ','?
        (
            enumBodyDeclarations
            {
                enumBodyDeclarationsNode = $enumBodyDeclarations.ret;
            }
        )?
        '}'
        {
            $ret = factory.makeNormalNodeUnion(
                        factory.makeEnumBodyNodeWithUnions($optionalEnumConstants.ret, enumBodyDeclarationsNode));
        }
    ;

enumConstants /*%% generateListRule= type=EnumConstantDeclarationListNode
                       componentName=enumConstant separator=',' %%*/ :;

enumConstant /*%% standardRuleIntro= type=EnumConstantDeclarationNode
                      initvar0=annotationsNode:AnnotationListNode
                      initvar1=metaAnnotationsNode:MetaAnnotationListNode
                      initvar2=argumentsNode:ExpressionListNode
                      initvar3=AnonymousClassBodyNode %%*/
    :   
        /*%% spliceClause= type=EnumConstantDeclarationNode %%*/
        javadoc enumConstantModifiers
        id=identifier
        (
            arguments
            {
                argumentsNode = $arguments.ret;
            }
        )?
        (
            anonymousClassBody
            {
                anonymousClassBodyNode = $anonymousClassBody.ret;
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeEnumConstantDeclarationNodeWithUnions(
                $enumConstantModifiers.ret,
                $id.ret,
                argumentsNode,
                anonymousClassBodyNode,
                $javadoc.ret));
        }
    ;

enumBodyDeclarations /*%% standardRuleIntro= type=ClassMemberListNode %%*/
    :
        ';'
        optionalClassBodyDeclarations
        {
            $ret = $optionalClassBodyDeclarations.ret;
        }
    ;

interfaceDeclaration /*%% standardRuleIntro= type=TypeDeclarationNode %%*/
    :   
        (interfaceHeader)=>a=normalInterfaceDeclaration
        {
            $ret = $a.ret;
        }
    |
        b=annotationTypeDeclaration
        {
            $ret = $b.ret;
        }
    ;
    
normalInterfaceDeclaration /*%% standardRuleIntro= type=InterfaceDeclarationNode initvar0=declaredTypeListNode:DeclaredTypeListNode %%*/
    :   
        /*%% spliceClause= type=InterfaceDeclarationNode %%*/
        javadoc interfaceModifiers
        'interface' id=identifier
        optionalTypeParameters
        (
            'extends' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?        
        interfaceBody
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceDeclarationNodeWithUnions(
                    $interfaceModifiers.ret,
                    declaredTypeListNode,
                    $interfaceBody.ret,
                    $optionalTypeParameters.ret,
                    $id.ret,
                    $javadoc.ret));
        }
    ;

declaredTypeList /*%% generateListRule= type=DeclaredTypeListNode
                       componentName=classOrInterfaceType separator=',' %%*/ :;

referenceTypeList /*%% generateListRule= type=ReferenceTypeListNode
                       componentName=referenceType separator=',' %%*/ :;

classBody /*%% standardRuleIntro= type=ClassBodyNode %%*/
    :
        /*%% spliceClause= type=ClassBodyNode %%*/
        '{'
        optionalClassBodyDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassBodyNodeWithUnions($optionalClassBodyDeclarations.ret));
        }
    ;

anonymousClassBody /*%% standardRuleIntro= type=AnonymousClassBodyNode %%*/
    :   
        /*%% spliceClause= type=AnonymousClassBodyNode %%*/
        '{' 
        optionalAnonymousClassBodyDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassBodyNodeWithUnions($optionalAnonymousClassBodyDeclarations.ret));
        }
    ;

interfaceBody /*%% standardRuleIntro= type=InterfaceBodyNode %%*/
    :
        /*%% spliceClause= type=InterfaceBodyNode %%*/   
        '{'
        optionalInterfaceBodyDeclarations 
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceBodyNodeWithUnions($optionalInterfaceBodyDeclarations.ret));
        }
    ;

initializerBlock /*%% standardRuleIntro= type=InitializerDeclarationNode %%*/
    :
        /*%% spliceClause= type=InitializerDeclarationNode %%*/
        optionalMetaAnnotationList
        staticText='static'?
        block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInitializerDeclarationNodeWithUnions(
                    $staticText!=null,
                    $block.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

classBodyDeclarations /*%% generateListRule= type=ClassMemberListNode
                       componentName=classBodyDeclaration %%*/ :;
    
classBodyDeclaration /*%% standardRuleIntro= type=ClassMemberNode %%*/
    :
        /*%% spliceClause= type=ClassMemberNode
                           nontype0=InitializerDeclarationNode
                           nontype1=ConstructorDeclarationNode
                           nontype2=FieldDeclarationNode
                           nontype3=MethodDeclarationNode
                           nontype4=ClassDeclarationNode
                           nontype5=EnumDeclarationNode
                           nontype6=InterfaceDeclarationNode
                           nontype7=AnnotationDeclarationNode
                           nontype8=NoOperationNode %%*/
        /* This has to go at the top so it overrides the anonymousClassMemberBsjMetaprogramAnchor
         * Otherwise, it would be impossible to create a metaprogram that could replace itself with an initializer or
         * a constructor. */
        {configuration.getMetaprogramsSupported()}?=> classMemberBsjMetaprogramAnchor
        {
            $ret = $classMemberBsjMetaprogramAnchor.ret;
        }
    |
        noOp
        {
            $ret = $noOp.ret;
        }
    |
        initializerBlock
        {
            $ret = $initializerBlock.ret;
        }
    |
        constructorDeclaration
        {
            $ret = $constructorDeclaration.ret;
        }
    |
        memberDecl
        {
            $ret = $memberDecl.ret;
        }
    ;

anonymousClassBodyDeclarations /*%% generateListRule= type=AnonymousClassMemberListNode
                       componentName=anonymousClassBodyDeclaration %%*/ :;
    
anonymousClassBodyDeclaration /*%% standardRuleIntro= type=AnonymousClassMemberNode %%*/
    :
        /*%% spliceClause= type=AnonymousClassMemberNode
                           nontype0=InitializerDeclarationNode
                           nontype1=FieldDeclarationNode
                           nontype2=MethodDeclarationNode
                           nontype3=ClassDeclarationNode
                           nontype4=EnumDeclarationNode
                           nontype5=InterfaceDeclarationNode
                           nontype6=AnnotationDeclarationNode
                           nontype7=NoOperationNode %%*/
        noOp
        {
            $ret = $noOp.ret;
        }
    |
        initializerBlock
        {
            $ret = $initializerBlock.ret;
        }
    |
        memberDecl
        {
            $ret = $memberDecl.ret;
        }
    |
        {configuration.getMetaprogramsSupported()}?=> anonymousClassMemberBsjMetaprogramAnchor
        {
            $ret = $anonymousClassMemberBsjMetaprogramAnchor.ret;
        }
    ;

memberDecl /*%% standardRuleIntro= type=AnonymousClassMemberNode %%*/
    :    
        (fieldHeader)=>fieldDeclaration
        {
            $ret = $fieldDeclaration.ret;
        }
    |   
        (methodHeader)=>methodDeclaration
        {
            $ret = $methodDeclaration.ret;
        }
    |   
        (classHeader|enumHeader)=>classDeclaration
        {
            $ret = $classDeclaration.ret;
        }
    |   
        (interfaceHeader|annotationHeader)=>interfaceDeclaration
        {
            $ret = $interfaceDeclaration.ret;
        }
    ;

methodReturnType /*%% standardRuleIntro= type=TypeNode %%*/
    :
        /*%% spliceClause= type=VoidTypeNode %%*/
        type
        {
            $ret = $type.ret;
        }
    |
        'void'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVoidTypeNode());
        }
    ;

constructorDeclaration /*%% standardRuleIntro= type=ConstructorDeclarationNode initvar0=throwsNode:UnparameterizedTypeListNode %%*/
    :
        /*%% spliceClause= type=ConstructorDeclarationNode %%*/
        javadoc constructorModifiers
        optionalTypeParameters
        identifier
        formalParameters
        (
            throwsClause
            {
                throwsNode = $throwsClause.ret;
            }
        )?
        constructorBody
        {
            $ret = factory.makeNormalNodeUnion(factory.makeConstructorDeclarationNodeWithUnions(
                $identifier.ret,
                $constructorBody.ret,
                $constructorModifiers.ret,
                $formalParameters.parameters,
                $formalParameters.varargParameter,
                throwsNode,
                $optionalTypeParameters.ret,
                $javadoc.ret));
        }
    ;

constructorBody /*%% standardRuleIntro= type=ConstructorBodyNode %%*/
    :
        /*%% spliceClause= type=ConstructorBodyNode %%*/
        '{' 
        explicitConstructorInvocation?
        optionalBlockStatementList
        '}'
        {
            $ret = factory.makeNormalNodeUnion(
                        factory.makeConstructorBodyNodeWithUnions(
                                $explicitConstructorInvocation.ret,
                                $optionalBlockStatementList.ret));
        }
    ;

methodDeclaration /*%% standardRuleIntro= type=MethodDeclarationNode
                           initvar0=body:BlockStatementListNode
                           initvar1=throwsNode:UnparameterizedTypeListNode
                           initvar2=returnTypeNode:TypeNode %%*/
    :
        /*%% spliceClause= type=MethodDeclarationNode %%*/
        javadoc methodModifiers
        optionalTypeParameters
        methodReturnType
        {
            returnTypeNode = $methodReturnType.ret;
        }
        id=identifier
        formalParameters
        (
            arrayTypeCounter
            {
                returnTypeNode = wrapArrayLevels(returnTypeNode, $arrayTypeCounter.ret);
            }
        )?
        (
            throwsClause
            {
                throwsNode = $throwsClause.ret;
            }
        )?
        (        
            block   
            {
                body = $block.ret;
            }
        |
            ';' 
        )
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMethodDeclarationNodeWithUnions(
                    body,
                    $methodModifiers.ret,
                    $id.ret,
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    returnTypeNode,
                    throwsNode,
                    $optionalTypeParameters.ret,
                    $javadoc.ret));
        }        
    ;

fieldDeclaration /*%% standardRuleIntro= type=FieldDeclarationNode %%*/
    :   
        /*%% spliceClause= type=FieldDeclarationNode %%*/
        javadoc fieldModifiers
        type
        variableDeclarators
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeFieldDeclarationNodeWithUnions(
                    $fieldModifiers.ret,
                    $type.ret,
                    $variableDeclarators.ret,
                    $javadoc.ret));
        }
    ;
    
interfaceBodyDeclarations /*%% generateListRule= type=InterfaceMemberListNode
                       componentName=interfaceBodyDeclaration %%*/ :;
    
interfaceBodyDeclaration /*%% standardRuleIntro= type=InterfaceMemberNode %%*/
    :
        /*%% spliceClause= type=InterfaceMemberNode
                           nontype0=ConstantDeclarationNode
                           nontype1=MethodDeclarationNode
                           nontype2=ClassDeclarationNode
                           nontype3=EnumDeclarationNode
                           nontype4=InterfaceDeclarationNode
                           nontype5=AnnotationDeclarationNode
                           nontype6=NoOperationNode %%*/
        constantDeclaration
        {
            $ret = $constantDeclaration.ret;
        }        
    |   
        interfaceMethodDeclaration
        {
            $ret = $interfaceMethodDeclaration.ret;
        }
    |   
        interfaceDeclaration
        {
            $ret = $interfaceDeclaration.ret;
        }
    |   
        classDeclaration
        {
            $ret = $classDeclaration.ret;
        }
    |   
        noOp
        {
            $ret = $noOp.ret;
        }
    |
        {configuration.getMetaprogramsSupported()}?=> interfaceMemberBsjMetaprogramAnchor
        {
            $ret = $interfaceMemberBsjMetaprogramAnchor.ret;
        }
    ;

interfaceMethodDeclaration /*%% standardRuleIntro= type=MethodDeclarationNode
                                    initvar0=returnTypeNode:TypeNode
                                    initvar1=throwsNode:UnparameterizedTypeListNode %%*/
    :   
        // TODO: replace with an interface-specific node type
        /*%% spliceClause= type=MethodDeclarationNode %%*/
        javadoc methodModifiers
        optionalTypeParameters
        methodReturnType
        {
            returnTypeNode = $methodReturnType.ret;
        }
        id=identifier
        formalParameters
        (
            arrayTypeCounter
            {
                returnTypeNode = wrapArrayLevels(returnTypeNode, $arrayTypeCounter.ret);
            }
        )?
        (
            throwsClause
            {
                throwsNode = $throwsClause.ret;
            }
        )?
        ';'
        {
            // TODO: this would be cleaner if we actually had a type for interface methods (like the JLS grammar does)
            $ret = factory.makeNormalNodeUnion(factory.makeMethodDeclarationNodeWithUnions(
                    null, // No body for interface methods; thus null
                    $methodModifiers.ret,
                    $id.ret,
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    returnTypeNode,
                    throwsNode,
                    $optionalTypeParameters.ret,
                    $javadoc.ret));
        }         
    ;

constantDeclaration /*%% standardRuleIntro= type=ConstantDeclarationNode %%*/
    :   
        /*%% spliceClause= type=ConstantDeclarationNode %%*/
        javadoc constantModifiers
        type
        variableDeclarators
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeConstantDeclarationNodeWithUnions(
                    $constantModifiers.ret,
                    $type.ret,
                    $variableDeclarators.ret,
                    $javadoc.ret));
        }
    ;

// Represents a non-empty sequence of variable declarators.
variableDeclarators /*%% generateListRule= type=VariableDeclaratorListNode
                       componentName=variableDeclarator separator=',' %%*/ :;
 
// Represents the combination of an identifier and an initializer.  This construct is necessary on its own to support
// the multiple declaration sugar ("int x,y;").
variableDeclarator /*%% standardRuleIntro= type=VariableDeclaratorNode
                            init0="""int arrayLevels = 0;"""
                            initvar0=initializer:VariableInitializerNode %%*/
    :
        /*%% spliceClause= type=VariableDeclaratorNode %%*/
        id=identifier
        (
            arrayTypeCounter
            {
                arrayLevels = $arrayTypeCounter.ret;
            }
        )?
        (
            '=' variableInitializer
            {
                initializer = $variableInitializer.ret;
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableDeclaratorNodeWithUnions($id.ret, arrayLevels, initializer));
        }
    ;

unparameterizedType /*%% standardRuleIntro= type=UnparameterizedTypeNode %%*/
    :
        /*%% spliceClause= type=UnparameterizedTypeNode %%*/   
        name
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeNodeWithUnions($name.ret));
        }
    ;

unparameterizedTypeList /*%% generateListRule= type=UnparameterizedTypeListNode separator=',' %%*/ :;

throwsClause /*%% standardRuleIntro= type=UnparameterizedTypeListNode %%*/
    :
        THROWS
        unparameterizedTypeList
        {
            $ret = $unparameterizedTypeList.ret;
        }
    ;

referenceType /*%% standardRuleIntro= type=ReferenceTypeNode %%*/
    :
        classOrInterfaceType
        {
            $ret = $classOrInterfaceType.ret;
        }
        (
            arrayTypeCounter
            {
                $ret = wrapArrayLevels($ret, $arrayTypeCounter.ret);
            }
        )?
    |
        primitiveType arrayTypeCounter
        {
            if ($arrayTypeCounter.ret > 0)
            {
                $ret = wrapArrayLevels($primitiveType.ret, $arrayTypeCounter.ret);
            }
        }
    ;

// This rule matches any legal Java type.
// For example, this rule would match any of the following:
//     int
//     boolean[]
//     String
//     Comparator<String>
//     Map.Entry<K,V>
//     List<String>[] (even though this generates a warning later)
type /*%% standardRuleIntro= type=TypeNode %%*/
    :
        (
            /*%% spliceClause= type=TypeNode
                               nontype0=PrimitiveTypeNode
                               nontype1=DeclaredTypeNode
                               nontype2=VoidTypeNode %%*/   
            (
                classOrInterfaceType
                {
                    $ret = $classOrInterfaceType.ret;
                }
            |
                primitiveType
                {
                    $ret = $primitiveType.ret;
                }
            )
        )
        (
            arrayTypeCounter
            {
                $ret = wrapArrayLevels($ret, $arrayTypeCounter.ret);
            }
        )?
    ;

// Parses a class or interface type.
// For example, in
//     Map.Entry<K,V> entry;
// this rule matches
//     Map.Entry<K,V>
// Note that the legal types can get pretty complex, as in
//     A<X,Y>.B.C<Z>.D
classOrInterfaceType /*%% standardRuleIntro= type=DeclaredTypeNode
                              initvar0=UnparameterizedTypeNode
                              initvar1=ParameterizedTypeNode %%*/
    :
        unparameterizedType
        {
            unparameterizedTypeNode = $unparameterizedType.ret;
            $ret = unparameterizedTypeNode;
        }
        (
            typeArguments
            {
                parameterizedTypeNode = factory.makeNormalNodeUnion(
                        factory.makeParameterizedTypeNodeWithUnions(unparameterizedTypeNode, $typeArguments.ret));
                $ret = parameterizedTypeNode;
            }
            (
                '.' next=classOrInterfaceType
                {
                    $ret = factory.makeNormalNodeUnion(
                            factory.makeParameterizedTypeSelectNodeWithUnions(parameterizedTypeNode, $next.ret));
                }
            )?
        )?
    |
        /*%% spliceClause= type=ParameterizedTypeNode nocond=true
                           action0="""parameterizedTypeNode = $ret.castNodeType(factory, ParameterizedTypeNode.class);"""
                           %%*/
        (
            '.' next=classOrInterfaceType
            {
                $ret = factory.makeNormalNodeUnion(
                        factory.makeParameterizedTypeSelectNodeWithUnions(parameterizedTypeNode, $next.ret));
            }
        )?
    |
        /*%% spliceClause= type=DeclaredTypeNode nocond=true
                           nontype0=UnparameterizedTypeNode
                           nontype1=ParameterizedTypeNode %%*/
    ;

// Parses a primitive type.
// For example, in
//     boolean b = true;
// this rule matches
//     boolean
primitiveType /*%% standardRuleIntro= type=PrimitiveTypeNode
                       init0="""PrimitiveType temp = null;"""
                       after0="""$ret = factory.makeNormalNodeUnion(factory.makePrimitiveTypeNode(temp));""" %%*/
    :   
        /*%% spliceClause= type=PrimitiveTypeNode %%*/   
        'boolean'
        {
            temp = PrimitiveType.BOOLEAN;
        }
    |   
        'char'
        {
            temp = PrimitiveType.CHAR;
        }
    |   
        'byte'
        {
            temp = PrimitiveType.BYTE;
        }
    |   
        'short'
        {
            temp = PrimitiveType.SHORT;
        }    
    |   
        'int'
        {
            temp = PrimitiveType.INT;
        }    
    |   
        'long'
        {
            temp = PrimitiveType.LONG;
        }
    |   
        'float'
        {
            temp = PrimitiveType.FLOAT;
        }
    |   
        'double'
        {
            temp = PrimitiveType.DOUBLE;
        }    
    ;

// Parses type arguments for a declared type.
// For example, in
//     Map.Entry<K,V> entry;
// this rule would parse
//     <K,V>
typeArguments /*%% generateListRule= type=TypeArgumentListNode
                       componentName=typeArgument separator=',' prefix='<' postfix='>' %%*/ :;

// Parses a single type argument for a declared type.
// For example, in
//     Map.Entry<K,V> entry;
// this rule would parse either K or V.  Also, in
//     Foo<? extends Bar>
// this rule would parse
//     ? extends Bar
typeArgument /*%% standardRuleIntro= type=TypeArgumentNode %%*/
    :
        /*%% spliceClause= type=TypeArgumentNode
                           nontype0=ReferenceTypeNode
                           nontype1=WildcardTypeNode %%*/
        referenceType
        {
            $ret = $referenceType.ret;
        }
    |
        wildcard
        {
            $ret = $wildcard.ret;
        }
    ;

wildcard /*%% standardRuleIntro= type=WildcardTypeNode init0="""boolean upper = false;""" %%*/
    :
        /*%% spliceClause= type=WildcardTypeNode %%*/
        '?'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeWildcardTypeNode((ReferenceTypeNode)null, false));
        }
        (
            (
                EXTENDS { upper = true; }
            |
                SUPER { upper = false; }
            )
            referenceType
            {
                $ret = factory.makeNormalNodeUnion(factory.makeWildcardTypeNodeWithUnions($referenceType.ret, upper));
            }
        )?
    ;

// Matches a formal parameter list.
// For example, in
//     public void foo(int x, int y)
// this rule matches
//     (int x, int y)
formalParameters returns [NodeUnion<? extends VariableListNode> parameters, NodeUnion<? extends VariableNode> varargParameter]
        scope Rule;
        @init {
            ruleStart("formalParameters");
            $parameters = factory.makeNormalNodeUnion(factory.makeVariableListNode());
            $varargParameter = null;
        }
        @after {
            ruleStop();
        }
    :
        '('
        (
            formalParameterDecls
            {
                $parameters = $formalParameterDecls.parameters;
                $varargParameter = $formalParameterDecls.varargParameter;
            }
        )? 
        ')'
    ;

// This rule is expected to produce a list of parameter declarations (multiple results)
formalParameterDecls returns [NodeUnion<? extends VariableListNode> parameters, NodeUnion<? extends VariableNode> varargParameter]
        scope Rule;
        @init {
            ruleStart("formalParameterDecls");
        }
        @after {
            ruleStop();
        }
    :
        normalParameterDecls
        ','
        ellipsisParameterDecl
        {
            $parameters = $normalParameterDecls.ret;
            $varargParameter = $ellipsisParameterDecl.ret;
        }
    |
        normalParameterDecls
        {
            $parameters = $normalParameterDecls.ret;
            $varargParameter = null;            
        }
    |
        ellipsisParameterDecl
        {
            $parameters = factory.makeNormalNodeUnion(factory.makeVariableListNode());
            $varargParameter = $ellipsisParameterDecl.ret;
        }
    ;

normalParameterDecls /*%% generateListRule= type=VariableListNode componentName=normalParameterDecl
                                            separator=',' %%*/ :;

normalParameterDecl /*%% standardRuleIntro= type=VariableNode
                             init0="""NodeUnion<? extends TypeNode> typeNode = null;""" %%*/ 
    :
        /*%% spliceClause= type=VariableNode %%*/
        mod=variableModifiers
        t=type
        {
            typeNode = $t.ret;
        }
        id=identifier
        (
            arrayTypeCounter
            {
                typeNode = wrapArrayLevels(typeNode, $arrayTypeCounter.ret);
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableNodeWithUnions($mod.ret, typeNode, $id.ret));
        }
    ;

ellipsisParameterDecl /*%% standardRuleIntro= type=VariableNode
                               init0="""NodeUnion<? extends TypeNode> typeNode = null;""" %%*/
    :
        mod=variableModifiers
        t=type
        {
            typeNode = $t.ret;
        }
        '...'
        id=identifier
        (
            arrayTypeCounter
            {
                typeNode = wrapArrayLevels(typeNode, $arrayTypeCounter.ret);
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableNodeWithUnions($mod.ret, typeNode, $id.ret));
        }
    ;

alternateConstructorInvocation /*%% standardRuleIntro= type=AlternateConstructorInvocationNode %%*/
    :
        optionalNonWildcardTypeArguments 'this' arguments ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAlternateConstructorInvocationNodeWithUnions(
                        $arguments.ret,
                        $optionalNonWildcardTypeArguments.ret));
        }
    ;

superclassConstructorInvocation /*%% standardRuleIntro= type=SuperclassConstructorInvocationNode %%*/
    :
        (
            primary '.'
        )?
        optionalNonWildcardTypeArguments
        SUPER arguments ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSuperclassConstructorInvocationNodeWithUnions(
                        $primary.ret,
                        $arguments.ret,
                        $optionalNonWildcardTypeArguments.ret));
        }
    ;

explicitConstructorInvocation /*%% standardRuleIntro= type=ConstructorInvocationNode %%*/
    :
        /*%% spliceClause= type=ConstructorInvocationNode %%*/
        alternateConstructorInvocation
        {
            $ret = $alternateConstructorInvocation.ret;
        }
    |
        superclassConstructorInvocation
        {
            $ret = $superclassConstructorInvocation.ret;
        }
    ;

annotations /*%% generateListRule= type=AnnotationListNode componentName=annotation %%*/ :;

// Parses an annotation.
// For example, in
//     @Test("foo")
//     public void foo() { }
// This rule would parse
//     @Test("foo")
annotation /*%% standardRuleIntro= type=AnnotationNode %%*/
    :
        /*%% spliceClause= type=AnnotationNode %%*/
        '@' unparameterizedType
        (
            (
                '('   
                (
                    optionalElementValuePairs
                    {
                        $ret = factory.makeNormalNodeUnion(factory.makeNormalAnnotationNodeWithUnions(
                                        $optionalElementValuePairs.ret,
                                        $unparameterizedType.ret));
                    }
                |
                    elementValue
                    {
                        $ret = factory.makeNormalNodeUnion(factory.makeSingleElementAnnotationNodeWithUnions(
                                        $elementValue.ret,
                                        $unparameterizedType.ret));
                    }
                )? 
                ')' 
            )
        |
            {
                $ret = factory.makeNormalNodeUnion(factory.makeNormalAnnotationNodeWithUnions(
                                factory.makeNormalNodeUnion(factory.makeAnnotationElementListNode()),
                                $unparameterizedType.ret));
            }
        )        
    ;

// Parses an annotation's element-value pairs.
// For example, in
//     @Foo(bar="baz",happy=5)
// this rule would parse
//     bar="baz",happy=5
elementValuePairs /*%% generateListRule= type=AnnotationElementListNode
                       componentName=elementValuePair separator=',' %%*/ :;

// Parses a single annotation element-value pair.
// For example, in
//     @Foo(bar="baz",happy=5)
// this rule would parse either
//     bar="baz"
// or
//     happy=5
elementValuePair /*%% standardRuleIntro= type=AnnotationElementNode %%*/
    :
        /*%% spliceClause= type=AnnotationElementNode %%*/
        id=identifier '=' elementValue
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationElementNodeWithUnions($id.ret, $elementValue.ret));
        }
    ;

// Parses an annotation element value.
// For example, in
//    @Ann(a=5,b={7,8},c=@Test)
// this rule would parse one of
//    5
// or
//    {7,8}
// or
//    @Test
elementValue /*%% standardRuleIntro= type=AnnotationValueNode %%*/
    :   
        /*%% spliceClause= type=AnnotationValueNode nontype0=AnnotationArrayValueNode %%*/
        conditionalExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationExpressionValueNodeWithUnions($conditionalExpression.ret));
        }
    |   
        annotation
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationAnnotationValueNodeWithUnions($annotation.ret));
        }
    |   
        elementValueArrayInitializer
        {
            $ret = $elementValueArrayInitializer.ret;
        }
    ;

// Parses a non-empty list of annotation element values.
elementValues /*%% generateListRule= type=AnnotationValueListNode
                       componentName=elementValue separator=',' lastSeparator=true %%*/ :;
    
// Parses an annotation element array.
// For example, in
//     @Ann({@Foo,@Bar(5)})
// this rule would parse
//     {@Foo,@Bar(5)}
// and in
//     @Test({1,2,3})
// this rule would parse
//     {1,2,3}
elementValueArrayInitializer /*%% standardRuleIntro= type=AnnotationArrayValueNode %%*/
    :   
        /*%% spliceClause= type=AnnotationArrayValueNode %%*/
        '{'
        optionalElementValues
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationArrayValueNodeWithUnions($optionalElementValues.ret));
        }
    ;

/**
 * Annotation declaration.
 */
annotationTypeDeclaration /*%% standardRuleIntro= type=AnnotationDeclarationNode %%*/
    :   
        /*%% spliceClause= type=AnnotationDeclarationNode %%*/
        javadoc annotationModifiers '@'
        'interface'
        id=identifier
        annotationTypeBody
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationDeclarationNodeWithUnions(
                    $annotationModifiers.ret,
                    $annotationTypeBody.ret,
                    $id.ret,
                    $javadoc.ret));
        }
    ;

annotationTypeBody /*%% standardRuleIntro= type=AnnotationBodyNode %%*/
    :   
        /*%% spliceClause= type=AnnotationBodyNode %%*/
        '{'
        optionalAnnotationTypeElementDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationBodyNodeWithUnions(
                        $optionalAnnotationTypeElementDeclarations.ret));
        }
    ;
    
annotationTypeElementDeclarations /*%% generateListRule= type=AnnotationMemberListNode
                       componentName=annotationTypeElementDeclaration %%*/ :;

annotationTypeElementDeclaration /*%% standardRuleIntro= type=AnnotationMemberNode %%*/
    :   
        annotationMethodDeclaration
        {
            $ret = $annotationMethodDeclaration.ret;
        }
    |   
        constantDeclaration
        {
            $ret = $constantDeclaration.ret;
        }
    |   
        normalClassDeclaration
        {
            $ret = $normalClassDeclaration.ret;
        }
    |   
        normalInterfaceDeclaration
        {
            $ret = $normalInterfaceDeclaration.ret;
        }
    |   
        enumDeclaration
        {
            $ret = $enumDeclaration.ret;
        }
    |   
        annotationTypeDeclaration
        {
            $ret = $annotationTypeDeclaration.ret;
        }
    |   
        noOp
        {
            $ret = $noOp.ret;
        }
    |
        {configuration.getMetaprogramsSupported()}?=> annotationMemberBsjMetaprogramAnchor
        {
            $ret = $annotationMemberBsjMetaprogramAnchor.ret;
        }
    ;

annotationMethodDeclaration /*%% standardRuleIntro= type=AnnotationMethodDeclarationNode %%*/
    :   
        /*%% spliceClause= type=AnnotationMethodDeclarationNode %%*/
        javadoc annotationMethodModifiers
        type
        id=identifier
        '(' ')'
        (
            'default' 
            elementValue
        )?
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMethodDeclarationNodeWithUnions(
                $annotationMethodModifiers.ret,
                $type.ret,
                $id.ret,
                $elementValue.ret,
                $javadoc.ret));
        }
    ;

block /*%% standardRuleIntro= type=BlockStatementListNode %%*/
    :   
        '{'
        optionalBlockStatementList
        '}'
        {
            $ret = $optionalBlockStatementList.ret;
        }
    ;

blockStatementList /*%% generateListRule= type=BlockStatementListNode %%*/ :;

// Parses a statement from a block of statements.
blockStatement /*%% standardRuleIntro= type=BlockStatementNode %%*/
    :   
        /*%% spliceClause= type=BlockStatementNode
                           nontype0=LocalVariableDeclarationNode
                           nontype1=LocalClassDeclarationNode
                           nontype2=StatementNode %%*/
        (localVariableHeader)=>localVariableDeclarationStatement
        {
            $ret = $localVariableDeclarationStatement.ret;
        }
    |   
        (typeHeader)=>localClassDeclaration
        {
            $ret = $localClassDeclaration.ret;
        }
    |   
        statement
        {
            $ret = $statement.ret;
        }
    |
        {configuration.getMetaprogramsSupported()}?=> blockStatementBsjMetaprogramAnchor
        {
            $ret = $blockStatementBsjMetaprogramAnchor.ret;
        }        
    ;

// Parses local variable declaration statement.
// For example, this rule would match
//     int x = 5, y;
localVariableDeclarationStatement /*%% standardRuleIntro= type=LocalVariableDeclarationNode %%*/
    :
        /*%% spliceClause= type=LocalVariableDeclarationNode %%*/
        localVariableDeclaration ';'
        {
            $ret = $localVariableDeclaration.ret;
        }
    ;

// Parses a local variable declaration.  Note that local variable declarations may declare multiple variables.
// For example, this rule would match
//     int x = 5, y
// Note the absence of a semicolon.
localVariableDeclaration /*%% standardRuleIntro= type=LocalVariableDeclarationNode %%*/
    :   
        variableModifiers type
        variableDeclarators
        {
            $ret = factory.makeNormalNodeUnion(factory.makeLocalVariableDeclarationNodeWithUnions(
                        $variableModifiers.ret,
                        $type.ret,
                        $variableDeclarators.ret));
        }
    ;

statement /*%% standardRuleIntro= type=StatementNode %%*/
    :
        /*%% spliceClause= type=StatementNode %%*/
        /*%% deferProduction= rule0=blockAsStatement
                              rule1=assertStatement
                              rule2=ifStatement
                              rule3=forStatement
                              rule4=whileStatement
                              rule5=doWhileStatement
                              rule6=tryStatement
                              rule7=switchStatement
                              rule8=synchronizedStatement
                              rule9=returnStatement
                              rule10=throwStatement
                              rule11=breakStatement
                              rule12=continueStatement
                              rule13=expressionStatement
                              rule14=labeledStatement
                              rule15=noOpStatement %%*/
    ;

blockAsStatement /*%% standardRuleIntro= type=BlockNode %%*/
    :
        optionalMetaAnnotationList
        block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBlockNodeWithUnions($block.ret, $optionalMetaAnnotationList.ret));
        }
    ;

assertStatement /*%% standardRuleIntro= type=AssertStatementNode %%*/
    :
        optionalMetaAnnotationList
        'assert' e1=expression 
        (
            ':' e2=expression
        )?
        ';'   
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAssertStatementNodeWithUnions(
                $e1.ret,
                $e2.ret,
                $optionalMetaAnnotationList.ret));
        }        
    ;

ifStatement /*%% standardRuleIntro= type=IfNode %%*/
    :
        optionalMetaAnnotationList
        'if' parExpression s1=statement 
        (
            'else' s2=statement
        )?    
        {
            $ret = factory.makeNormalNodeUnion(factory.makeIfNodeWithUnions(
                $parExpression.ret,
                $s1.ret,
                $s2.ret,
                $optionalMetaAnnotationList.ret));
        }   
    ;

forStatement /*%% standardRuleIntro= type=StatementNode %%*/
    :   
        /*%% deferProduction= rule0=enhancedForStatement
                              rule1=basicForStatement %%*/
    ;

enhancedForStatement /*%% standardRuleIntro= type=EnhancedForLoopNode %%*/
    :
        optionalMetaAnnotationList
        'for''(' variableModifiers type id=identifier ':' expression ')' statement
        {
            $ret = factory.makeNormalNodeUnion(factory.makeEnhancedForLoopNodeWithUnions(
                    factory.makeNormalNodeUnion(
                        factory.makeVariableNodeWithUnions(
                                $variableModifiers.ret, 
                                $type.ret,
                                $id.ret)),
                    $expression.ret,
                    $statement.ret,
                    $optionalMetaAnnotationList.ret));
        }        
    ;

basicForStatement /*%% standardRuleIntro= type=ForLoopNode %%*/
    :
        optionalMetaAnnotationList
        'for'
        '(' 
        forInit?
        ';' 
        expression?
        ';'
        optionalStatementExpressionList
        ')'
        statement
        {
            $ret = factory.makeNormalNodeUnion(factory.makeForLoopNodeWithUnions(
                    $forInit.ret, 
                    $expression.ret,
                    $optionalStatementExpressionList.ret,
                    $statement.ret,
                    $optionalMetaAnnotationList.ret));
        }                 
    ;

whileStatement /*%% standardRuleIntro= type=WhileLoopNode %%*/
    :
        optionalMetaAnnotationList
        'while' parExpression s=statement
        {
            $ret = factory.makeNormalNodeUnion(factory.makeWhileLoopNodeWithUnions(
                $parExpression.ret,
                $s.ret,
                $optionalMetaAnnotationList.ret));
        }
    ;

doWhileStatement /*%% standardRuleIntro= type=DoWhileLoopNode %%*/
    :
        optionalMetaAnnotationList
        'do' s=statement 'while' parExpression ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeDoWhileLoopNodeWithUnions(
                $parExpression.ret,
                $s.ret,
                $optionalMetaAnnotationList.ret));
        }
    ;

tryStatement /*%% standardRuleIntro= type=TryNode
                      init0="""NodeUnion<? extends CatchListNode> catchList = null;"""
                      init1="""NodeUnion<? extends BlockStatementListNode> finallyBlock = null;""" %%*/
    :   
        optionalMetaAnnotationList
        'try' b=block
        (
            c=catches 'finally' fb=block
            {
                catchList = $c.ret;
                finallyBlock = $fb.ret;
            }
        |   
            c=catches
            {
                catchList = $c.ret;
                finallyBlock = null;
            }            
        |   
            'finally' fb=block
            {
                catchList = factory.makeNormalNodeUnion(factory.makeCatchListNode());
                finallyBlock = $fb.ret;
            }            
        )
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTryNodeWithUnions(
                    $b.ret,
                    catchList,
                    finallyBlock,
                    $optionalMetaAnnotationList.ret));
        }        
    ;

switchStatement /*%% standardRuleIntro= type=SwitchNode %%*/
    :
        optionalMetaAnnotationList
        'switch'
        '('
        expression
        ')'
        switchBlock
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSwitchNodeWithUnions(
                    $expression.ret,
                    $switchBlock.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

synchronizedStatement /*%% standardRuleIntro= type=SynchronizedNode %%*/
    :
        optionalMetaAnnotationList
        'synchronized' parExpression block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSynchronizedNodeWithUnions(
                $parExpression.ret,
                $block.ret,
                $optionalMetaAnnotationList.ret));
        }
    ;

returnStatement /*%% standardRuleIntro= type=ReturnNode %%*/
    :
        optionalMetaAnnotationList
        'return' 
        expression?
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeReturnNodeWithUnions(
                    $expression.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

throwStatement /*%% standardRuleIntro= type=ThrowNode %%*/
    :
        optionalMetaAnnotationList
        'throw' expression ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeThrowNodeWithUnions(
                    $expression.ret, $optionalMetaAnnotationList.ret));
        }
    ;

breakStatement /*%% standardRuleIntro= type=BreakNode %%*/
    :
        optionalMetaAnnotationList
        'break' identifier? ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBreakNodeWithUnions(
                    $identifier.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

continueStatement /*%% standardRuleIntro= type=ContinueNode %%*/
    :
        optionalMetaAnnotationList
        'continue' identifier? ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeContinueNodeWithUnions(
                    $identifier.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

expressionStatement /*%% standardRuleIntro= type=ExpressionStatementNode %%*/
    :
        optionalMetaAnnotationList
        statementExpression  ';'  
        {
            $ret = factory.makeNormalNodeUnion(factory.makeExpressionStatementNodeWithUnions(
                    $statementExpression.ret,
                    $optionalMetaAnnotationList.ret));
        }   
    ;
    
labeledStatement /*%% standardRuleIntro= type=LabeledStatementNode %%*/
    :
        optionalMetaAnnotationList
        identifier ':' statement
        {
            $ret = factory.makeNormalNodeUnion(factory.makeLabeledStatementNodeWithUnions(
                $identifier.ret,
                $statement.ret,
                $optionalMetaAnnotationList.ret));
        }
    ;

noOpStatement /*%% standardRuleIntro= type=NoOperationNode %%*/
    :
        optionalMetaAnnotationList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeNoOperationNodeWithUnions($optionalMetaAnnotationList.ret));
        }
    ;

catches /*%% generateListRule= type=CatchListNode componentName=catchClause %%*/ :;

catchClause /*%% standardRuleIntro= type=CatchNode %%*/
    :   
        /*%% spliceClause= type=CatchNode %%*/
        'catch' '(' formalParameter ')'
        block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeCatchNodeWithUnions(
                    $block.ret,
                    $formalParameter.ret));
        }
    ;

switchBlock /*%% standardRuleIntro= type=CaseListNode %%*/
    :
        '{'
        optionalSwitchBlockStatementGroups
        '}'
        {
            $ret = $optionalSwitchBlockStatementGroups.ret;
        }
    ;

switchBlockStatementGroups /*%% generateListRule= type=CaseListNode componentName=switchBlockStatementGroup %%*/ :;

switchBlockStatementGroup /*%% standardRuleIntro= type=CaseNode %%*/
    :
        /*%% spliceClause= type=CaseNode %%*/
        switchLabel
        optionalBlockStatementList
        {
            $ret = factory.makeNormalNodeUnion(factory.makeCaseNodeWithUnions($switchLabel.ret, $optionalBlockStatementList.ret));
        }
    ;

switchLabel /*%% standardRuleIntro= type=ExpressionNode %%*/
    :   
        'case' expression ':'
        {
            $ret = $expression.ret;
        }
    |   
        'default' ':'
        {
            $ret = null;
        }
    ;

// Parses the formal parameter of a catch block.
// For example, in
//     try { ... } catch (IOException e) { ... }
// this rule would match
//     IOException e
formalParameter /*%% standardRuleIntro= type=VariableNode
                         init0="""NodeUnion<? extends TypeNode> typeNode = null;""" %%*/
    :   
        variableModifiers
        type
        {
            typeNode = $type.ret;
        }
        id=identifier
        (
            arrayTypeCounter
            {
                typeNode = wrapArrayLevels(typeNode, $arrayTypeCounter.ret);
            }
        )?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableNodeWithUnions(
                $variableModifiers.ret, 
                typeNode,
                $id.ret));
        }
    ;

// Parses the initializer for a standard for loop.  This may either be a list of variable declarations or a list of
// initialization expressions.
forInit /*%% standardRuleIntro= type=ForInitializerNode %%*/
    :   
        /*%% spliceClause= type=ForInitializerNode %%*/
        localVariableDeclaration
        {
            $ret = factory.makeNormalNodeUnion(factory.makeForInitializerDeclarationNodeWithUnions(
                    $localVariableDeclaration.ret));
        }
    |   
        statementExpressionList
        {
            $ret = factory.makeNormalNodeUnion(factory.makeForInitializerExpressionNodeWithUnions($statementExpressionList.ret));
        }
    ;

parExpression /*%% standardRuleIntro= type=ExpressionNode %%*/
    :   
        '(' expression ')'
        {
            $ret = $expression.ret;
        }
    ;

statementExpressionList /*%% generateListRule= type=StatementExpressionListNode separator=',' %%*/ :;

expressionList /*%% generateListRule= type=ExpressionListNode separator=',' %%*/ :;
                       
/* This rule parses a statement expression.  A statement expression is one of those types of expressions which may be
 * used as a statement (such as x++) but not any other kind of expression (such as ~x). */
statementExpression /*%% standardRuleIntro= type=StatementExpressionNode %%*/
    :
        // Okay, this is a bit hacky but seriously reduces duplication as well as maintenance.
        // We'll just grab any expression we can.  If it's not a statement expression, we raise an exception.
        expression
        {
            ($expression.ret != null && $expression.ret.getType().equals(NodeUnion.Type.NORMAL) &&
                        $expression.ret.getNormalNode() instanceof StatementExpressionNode)
            // TODO: permit splices of statement expressions!
        }?
        {
            $ret = factory.makeNormalNodeUnion((StatementExpressionNode)($expression.ret.getNormalNode()));
        }
    ;

expression /*%% standardRuleIntro= type=ExpressionNode %%*/
    :
        assignmentExpression
        {
            $ret = $assignmentExpression.ret;
        }
    ;

assignmentExpression /*%% standardRuleIntro= type=ExpressionNode %%*/
    :   
        (
            /*%% spliceClause= type=ExpressionNode nontype0=NonAssignmentExpressionNode %%*/
            conditionalExpression
            {
                $ret = $conditionalExpression.ret;
            }
        )
        (
            assignmentOperator
            e=expression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAssignmentNodeWithUnions(
                        $ret,
                        $assignmentOperator.ret,
                        $e.ret));
            }
        )?
    ;

assignmentOperator /*%% standardRuleIntro= type=AssignmentOperator %%*/
    :   
        '='
        {
            $ret = AssignmentOperator.ASSIGNMENT;
        }
    |   
        '+='
        {
            $ret = AssignmentOperator.PLUS_ASSIGNMENT;
        }        
    |   
        '-='
        {
            $ret = AssignmentOperator.MINUS_ASSIGNMENT;
        }    
    |   
        '*='
        {
            $ret = AssignmentOperator.MULTIPLY_ASSIGNMENT;
        }        
    |   
        '/='
        {
            $ret = AssignmentOperator.DIVIDE_ASSIGNMENT;
        }        
    |   
        '&='
        {
            $ret = AssignmentOperator.AND_ASSIGNMENT;
        }
    |   
        '|='
        {
            $ret = AssignmentOperator.OR_ASSIGNMENT;
        }        
    |   
        '^='
        {
            $ret = AssignmentOperator.XOR_ASSIGNMENT;
        }        
    |   
        '%='
        {
            $ret = AssignmentOperator.MODULUS_ASSIGNMENT;
        }        
    |   
        '<' '<' '='
        {
            $ret = AssignmentOperator.LEFT_SHIFT_ASSIGNMENT;
        }    
    |    
        '>' '>' '>' '='
        {
            $ret = AssignmentOperator.UNSIGNED_RIGHT_SHIFT_ASSIGNMENT;
        }        
    |   
        '>' '>' '='
        {
            $ret = AssignmentOperator.RIGHT_SHIFT_ASSIGNMENT;
        }         
    ;

conditionalExpression /*%% standardRuleIntro= type=NonAssignmentExpressionNode %%*/
    :   
        conditionalOrExpression
        {
            $ret = $conditionalOrExpression.ret;
        }
        (
            '?' e1=expression ':' e2=conditionalExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeConditionalExpressionNodeWithUnions(
                    $ret, 
                    $e1.ret, 
                    $e2.ret));
            }
        )?
    ;

conditionalOrExpression /*%% generateBinaryExpressionRule= chainRule=conditionalAndExpression
                                 op0='||'#BinaryOperator.CONDITIONAL_OR %%*/ :;

conditionalAndExpression /*%% generateBinaryExpressionRule= chainRule=inclusiveOrExpression
                                 op0='&&'#BinaryOperator.CONDITIONAL_AND %%*/ :;

inclusiveOrExpression /*%% generateBinaryExpressionRule= chainRule=exclusiveOrExpression
                                 op0='|'#BinaryOperator.LOGICAL_OR %%*/ :;

exclusiveOrExpression /*%% generateBinaryExpressionRule= chainRule=andExpression
                                 op0='^'#BinaryOperator.XOR %%*/ :;

andExpression /*%% generateBinaryExpressionRule= chainRule=equalityExpression
                                 op0='&'#BinaryOperator.LOGICAL_AND %%*/ :;

equalityExpression /*%% generateBinaryExpressionRule: chainRule:instanceOfExpression
                                 op0:'=='#BinaryOperator.EQUAL
                                 op1:'!='#BinaryOperator.NOT_EQUAL %%*/ :;

instanceOfExpression /*%% standardRuleIntro= type=NonAssignmentExpressionNode %%*/
    :   
        relationalExpression
        {
            $ret = $relationalExpression.ret;
        }        
        (
            'instanceof' type
            {
                $ret = factory.makeNormalNodeUnion(factory.makeInstanceOfNodeWithUnions(
                    $relationalExpression.ret, 
                    $type.ret));
            }        
        )?
    ;

relationalExpression /*%% generateBinaryExpressionRule: chainRule:shiftExpression
                                 op0:"""'<' '='"""#BinaryOperator.LESS_THAN_EQUAL
                                 op1:"""'>' '='"""#BinaryOperator.GREATER_THAN_EQUAL
                                 op2:'<'#BinaryOperator.LESS_THAN
                                 op3:'>'#BinaryOperator.GREATER_THAN %%*/ :;

shiftExpression /*%% generateBinaryExpressionRule= chainRule=additiveExpression
                                 op0="""'<' '<'"""#BinaryOperator.LEFT_SHIFT
                                 op1="""'>' '>' '>'"""#BinaryOperator.UNSIGNED_RIGHT_SHIFT
                                 op2="""'>' '>'"""#BinaryOperator.RIGHT_SHIFT %%*/ :;

additiveExpression /*%% generateBinaryExpressionRule= chainRule=multiplicativeExpression
                                 op0='+'#BinaryOperator.PLUS
                                 op1='-'#BinaryOperator.MINUS %%*/ :;

multiplicativeExpression /*%% generateBinaryExpressionRule= chainRule=unaryExpression
                                 op0='*'#BinaryOperator.MULTIPLY
                                 op1='/'#BinaryOperator.DIVIDE
                                 op2='%'#BinaryOperator.MODULUS %%*/ :;

/**
 * NOTE: for '+' and '-', if the next token is int or long literal, then it's not a unary expression.
 *       it's a literal with signed value. INTLITERAL AND LONG LITERAL are added here for this.
 */
unaryExpression /*%% standardRuleIntro= type=NonAssignmentExpressionNode %%*/
    :   
        '+'  e=unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryExpressionNodeWithUnions(
                $e.ret,
                UnaryOperator.UNARY_PLUS));
        }        
    |
        '-' intLiteral[true]
        {
            $ret = $intLiteral.ret;
        }   
    |
        '-' longLiteral[true]
        {
            $ret = $longLiteral.ret;
        }    
    |
        '-' e=unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryExpressionNodeWithUnions(
                $e.ret,
                UnaryOperator.UNARY_MINUS));
        }        
    |   
        '++' e=unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryStatementExpressionNodeWithUnions(
                $e.ret,
                UnaryStatementOperator.PREFIX_INCREMENT));
        }
    |   
        '--' e=unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryStatementExpressionNodeWithUnions(
                $e.ret,
                UnaryStatementOperator.PREFIX_DECREMENT));
        }        
    |   
        unaryExpressionNotPlusMinus
        {
            $ret = $unaryExpressionNotPlusMinus.ret;
        }
    ;

unaryExpressionNotPlusMinus /*%% standardRuleIntro= type=NonAssignmentExpressionNode %%*/
    :   
        '~' unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryExpressionNodeWithUnions(
                $unaryExpression.ret,
                UnaryOperator.BITWISE_COMPLEMENT));
        }        
    |   
        '!' unaryExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnaryExpressionNodeWithUnions(
                $unaryExpression.ret,
                UnaryOperator.LOGICAL_COMPLEMENT));
        }        
    |   
        castExpression
        {
            $ret = $castExpression.ret;
        }
    |   
        postfixExpression
        {
            $ret = $postfixExpression.ret;
        }
    ;

castExpression /*%% standardRuleIntro= type=TypeCastNode %%*/
    :   
        '(' type ')' unaryExpressionNotPlusMinus
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeCastNodeWithUnions(
                $unaryExpressionNotPlusMinus.ret,
                $type.ret));
        }
    ;

postfixExpression /*%% standardRuleIntro= type=NonAssignmentExpressionNode %%*/
    :
        (
            /*%% spliceClause= type=NonAssignmentExpressionNode nontype0=PrimaryExpressionNode %%*/
            primary
            {
                $ret = $primary.ret;
            }
        )
        (
            '++'
            {
                $ret = factory.makeNormalNodeUnion(factory.makeUnaryStatementExpressionNodeWithUnions(
                        $ret, UnaryStatementOperator.POSTFIX_INCREMENT));
            }
        |
            '--'
            {
                $ret = factory.makeNormalNodeUnion(factory.makeUnaryStatementExpressionNodeWithUnions(
                        $ret, UnaryStatementOperator.POSTFIX_DECREMENT));
            }
        )*
    ;

primary returns [NodeUnion<? extends PrimaryExpressionNode> ret]
        // This rule is complex enough that ANTLR's parameter passing breaks down.  Using scope instead.
        // Note that ANTLR is clever enough to create a new scope for each rule; this recurses appropriately.
        scope {
            NodeUnion<? extends PrimaryExpressionNode> result;
        }
        scope Rule;
        @init {
            ruleStart("primary");
        }
        @after {
            ruleStop();
        }
    :
        (
            /*%% spliceClause= type=PrimaryExpressionNode
                               nontype0=RestrictedPrimaryExpressionNode
                               nontype1=ArrayCreationNode %%*/
            arrayCreator
            {
                $primary::result = $arrayCreator.ret;
            }
        |
            restrictedPrimary
            {
                $primary::result  = $restrictedPrimary.ret;
            }
        )
        (
            primarySuffix
            {
                $primary::result = $primarySuffix.ret;
            }
        )*
        {
            $ret = $primary::result;
        }
    ;

restrictedPrimary /*%% standardRuleIntro= type=RestrictedPrimaryExpressionNode %%*/
    :
        /*%% spliceClause= type=RestrictedPrimaryExpressionNode
                           nontype0=UnqualifiedClassInstantiationNode
                           nontype1=SuperFieldAccessNode
                           nontype2=SuperMethodInvocationNode %%*/
        /*%% templateComment= value="""
                 NOTE: in the following production deference, the superMethodInvocation rule MUST preceed the
                       superFieldAccess rule; otherwise, ANTLR's backtracking prioritization will mess up the parse
             """ %%*/
        /*%% deferProduction= rule0=lexicalLiteral
                              rule1=primitiveClassLiteral
                              rule2=declaredClassLiteral
                              rule3=voidClassLiteral
                              rule4=thisClause
                              rule5=parenthesizedExpression
                              rule6=unqualifiedClassInstantiation
                              rule7=superMethodInvocation
                              rule8=superFieldAccess
                              rule9=methodInvocationByName
                              rule10=typeQualifiedTypeArgumentMethodInvocation
                              rule11=variableAccessByName %%*/
        (
            arrayAccess[ret]
            {
                $ret = $arrayAccess.ret;
            }
        )?
    ;
    
// ANTLR's parameter passing has broken down by this point due to the complexity of this rule.  Using scope instead;
// thankfully, we know which rule is calling this one.
primarySuffix /*%% standardRuleIntro= type=RestrictedPrimaryExpressionNode %%*/
    :
        (
            // qualified class instantiation
            qualifiedClassInstantiationPrimarySuffix
            {
                $ret = $qualifiedClassInstantiationPrimarySuffix.ret;
            }
        |
            // method invocation with type arguments
            typeArgumentMethodInvocationSuffix
            {
                $ret = $typeArgumentMethodInvocationSuffix.ret;
            }
        |
            // field access on an expression
            fieldAccessPrimarySuffix
            {
                $ret = $fieldAccessPrimarySuffix.ret;
            }
        )
        (
            arrayAccess[ret]
            {
                $ret = $arrayAccess.ret;
            }
        )?
    ;

thisClause /*%% standardRuleIntro= type=ThisNode %%*/
    :
        (unparameterizedType '.')? THIS
        {
            $ret = factory.makeNormalNodeUnion(factory.makeThisNodeWithUnions($unparameterizedType.ret));
        }
    ;

parenthesizedExpression /*%% standardRuleIntro= type=ParenthesizedExpressionNode %%*/
    :
        parExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeParenthesizedExpressionNodeWithUnions($parExpression.ret));
        }
    ;

unqualifiedClassInstantiation /*%% standardRuleIntro= type=UnqualifiedClassInstantiationNode %%*/
    :
        /*%% spliceClause= type=UnqualifiedClassInstantiationNode %%*/
        NEW
        optionalTypeArguments
        classOrInterfaceType arguments
        anonymousClassBody?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnqualifiedClassInstantiationNodeWithUnions(
                    $classOrInterfaceType.ret,
                    $optionalTypeArguments.ret,
                    $arguments.ret,
                    $anonymousClassBody.ret));
        }
    ;

// Parses a super field access.  For example, this rule would parse
//     super.x;
// or
//     X.super.x;
// The latter case is used to specify which enclosing type's supertype should be accessed.  (See the documentation of
// SuperFieldAccessNode for more information.)
superFieldAccess /*%% standardRuleIntro= type=SuperFieldAccessNode %%*/
    :
        /*%% spliceClause= type=SuperFieldAccessNode %%*/
        (unparameterizedType '.')? SUPER '.' identifier
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSuperFieldAccessNodeWithUnions(
                    $unparameterizedType.ret,
                    $identifier.ret));
        }
    ;

// Parses a method invocation by name.  For example, this rule would parse
//     foo();
// or
//     someField.aMethod();
// or
//     Utils.stuff();
methodInvocationByName /*%% standardRuleIntro= type=MethodInvocationNode
                                initvar0=qualifier:RestrictedPrimaryExpressionNode
                                initvar1=ident:IdentifierNode %%*/
    :
        a=identifier
        {
            ident = $a.ret;
        }
        (
            '.' b=identifier
            {
                qualifier = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions(qualifier, ident));
                ident = $b.ret;
            }
        )*
        arguments
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMethodInvocationNodeWithUnions(
                    qualifier,
                    ident,
                    $arguments.ret,
                    factory.makeNormalNodeUnion(factory.makeReferenceTypeListNode())));
        }
    ;

// Parses a super method invocation.  For example, this rule would parse
//     super.toString();
// or
//     X.super.foo();
// The latter case is used to specify which enclosing type's supertype should be accessed.  (See the documentation of
// SuperMethodInvocationNode for more information.)
superMethodInvocation /*%% standardRuleIntro= type=SuperMethodInvocationNode %%*/
    :
        /*%% spliceClause= type=SuperMethodInvocationNode %%*/
        (unparameterizedType '.')?
        SUPER '.'
        optionalNonWildcardTypeArguments
        identifier arguments
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSuperMethodInvocationNodeWithUnions(
                    $unparameterizedType.ret,
                    $identifier.ret,
                    $arguments.ret,
                    $optionalNonWildcardTypeArguments.ret));
        }
    ;

// This rule invokes a method against a type while providing type arguments, as in
//     Collections.<Integer>emptySet();
typeQualifiedTypeArgumentMethodInvocation /*%% standardRuleIntro= type=MethodInvocationNode
                                                   initvar0=qualifier:RestrictedPrimaryExpressionNode %%*/
    :
        a=identifier
        {
            qualifier = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions(null, $a.ret));
        }
        (
            '.' b=identifier
            {
                qualifier = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions(qualifier, $b.ret));
            }
        )*
        '.' nonWildcardTypeArguments c=identifier arguments
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMethodInvocationNodeWithUnions(
                    qualifier,
                    $c.ret,
                    $arguments.ret,
                    $nonWildcardTypeArguments.ret));
        }
    ;

// This rule instantiates a class using the expression before the suffix as the enclosing instance.
// For example:
//     (foo.bar()).new MyClass()
qualifiedClassInstantiationPrimarySuffix /*%% standardRuleIntro= type=QualifiedClassInstantiationNode %%*/
    :
        '.' NEW
        constructorTypeArguments=optionalTypeArguments
        identifier
        classTypeArguments=optionalTypeArguments
        arguments
        anonymousClassBody?
        {
            $ret = factory.makeNormalNodeUnion(factory.makeQualifiedClassInstantiationNodeWithUnions(
                    deepCopyUnion($primary::result, PrimaryExpressionNode.class),
                    $identifier.ret,
                    $classTypeArguments.ret,
                    $constructorTypeArguments.ret,
                    $arguments.ret,
                    $anonymousClassBody.ret));
        }
    ;

// Parses a field access based on an expression, such as
//     (new int[5]).length
fieldAccessPrimarySuffix /*%% standardRuleIntro= type=RestrictedPrimaryExpressionNode %%*/
    :
        '.' identifier
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions(
                        deepCopyUnion($primary::result, PrimaryExpressionNode.class), $identifier.ret));
        }
    ;

// Parses a method invocation based on an expression, such as
//     array[4].toString()
// or
//     foo().bar()    
typeArgumentMethodInvocationSuffix /*%% standardRuleIntro= type=RestrictedPrimaryExpressionNode %%*/
    :
        '.'
        optionalNonWildcardTypeArguments
        identifier arguments
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMethodInvocationNodeWithUnions(
                    deepCopyUnion($primary::result, PrimaryExpressionNode.class),
                    $identifier.ret,
                    $arguments.ret,
                    $optionalNonWildcardTypeArguments.ret));
        }
    ;

variableAccessByName /*%% standardRuleIntro= type=VariableAccessNode %%*/
    :
        a=identifier
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions(null, $a.ret));
        }
        (
            '.' b=identifier
            {
                $ret = factory.makeNormalNodeUnion(factory.makeVariableAccessNodeWithUnions($ret, $b.ret));
            }
        )*
    ;
    
arrayAccess /*%% standardRuleIntro= ruleParams="""NodeUnion<? extends RestrictedPrimaryExpressionNode> in"""
                     type=ArrayAccessNode %%*/
    :
        '[' a=expression ']'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeArrayAccessNodeWithUnions($in, $a.ret));
        }
        (
            '[' b=expression ']'
            {
                $ret = factory.makeNormalNodeUnion(factory.makeArrayAccessNodeWithUnions($ret, $b.ret));
            }
        )*
    ;

declaredClassLiteral /*%% standardRuleIntro= type=ClassLiteralNode
                              init0="""NodeUnion<? extends LiteralizableTypeNode> typeNode = null;""" %%*/
    :
        unparameterizedType
        {
            typeNode = $unparameterizedType.ret;
        }
        (
            arrayTypeCounter
            {
                typeNode = wrapArrayLevels(typeNode, $arrayTypeCounter.ret);
            }
        )?
        '.' 'class'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassLiteralNodeWithUnions(typeNode));
        }
    ;

primitiveClassLiteral /*%% standardRuleIntro= type=ClassLiteralNode
                               init0="""NodeUnion<? extends LiteralizableTypeNode> typeNode = null;""" %%*/
    :
        primitiveType
        {
            typeNode = $primitiveType.ret;
        }
        (
            arrayTypeCounter
            {
                typeNode = wrapArrayLevels(typeNode, $arrayTypeCounter.ret);
            }
        )?
        '.' 'class'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassLiteralNodeWithUnions(typeNode));
        }
    ;

voidClassLiteral /*%% standardRuleIntro= type=ClassLiteralNode %%*/
    :
        'void' '.' 'class'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassLiteralNodeWithUnions(
                    factory.makeNormalNodeUnion(factory.makeVoidTypeNode())));
        }
    ;

// Parses an array creater from one of two forms.
// Either:
//     new int[][]{{1,1},{2,2}};
// Or:
//     new int[2][][];
arrayCreator /*%% standardRuleIntro= type=ArrayCreationNode %%*/
    :   
        /*%% spliceClause= type=ArrayCreationNode %%*/
        /*%% deferProduction= rule0=arrayInitializerCreator rule1=arrayInstantiatorCreator %%*/
    ;

arrayInitializerCreator /*%% standardRuleIntro= type=ArrayInitializerCreationNode init0="""int levels = 0"""; %%*/
    :
        NEW createdName
        '[' ']'
        {
            levels = 1;
        }
        (
            '[' ']'
            {
                levels++;
            }
        )*
        arrayInitializer
        {
            $ret = factory.makeNormalNodeUnion(factory.makeArrayInitializerCreationNodeWithUnions(
                $arrayInitializer.ret,
                $createdName.ret,
                levels));
        }
    ;

arrayInstantiatorCreator /*%% standardRuleIntro= type=ArrayInstantiatorCreationNode init0="""int levels = 0;""" %%*/
    :
        NEW createdName
        arrayInstantiatorExpressionList
        (
            '[' ']'
            {
                levels++;
            }            
        )*
        {
            $ret = factory.makeNormalNodeUnion(factory.makeArrayInstantiatorCreationNodeWithUnions(
                $arrayInstantiatorExpressionList.ret,
                $createdName.ret,
                levels));
        }        
    ;

arrayInstantiatorExpressionList /*%% generateListRule= type=ExpressionListNode
                                         componentName=arrayInstantiatorExpression %%*/ :;

arrayInstantiatorExpression /*%% standardRuleIntro= type=ExpressionNode %%*/
    :
        '[' expression ']'
        {
            $ret = $expression.ret;
        }
    ;

variableInitializer /*%% standardRuleIntro= type=VariableInitializerNode %%*/
    :   
        /*%% spliceClause= type=VariableInitializerNode nontype0=ArrayInitializerNode nontype1=ExpressionNode %%*/   
        /*%% deferProduction= rule0=arrayInitializer rule1=expression %%*/
    ;

variableInitializers /*%% generateListRule= type=VariableInitializerListNode
                          componentName=variableInitializer separator=',' %%*/ :;

arrayInitializer /*%% standardRuleIntro= type=ArrayInitializerNode %%*/
    :
        /*%% spliceClause= type=ArrayInitializerNode %%*/   
        '{' 
            optionalVariableInitializers
            ','? 
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeArrayInitializerNodeWithUnions($optionalVariableInitializers.ret));
        }
    ;

createdName /*%% standardRuleIntro= type=BaseTypeNode %%*/
    :
        /*%% deferProduction= rule0=classOrInterfaceType rule1=primitiveType %%*/
    ;

optionalNonWildcardTypeArguments /*%% standardRuleIntro= type=ReferenceTypeListNode %%*/
    :
        nonWildcardTypeArguments
        {
            $ret = $nonWildcardTypeArguments.ret;
        }
    |
        {
            $ret = factory.makeNormalNodeUnion(factory.makeReferenceTypeListNode());
        }
    ;

nonWildcardTypeArguments /*%% standardRuleIntro= type=ReferenceTypeListNode %%*/
    :   
        '<'
        referenceTypeList
        {
            $ret = $referenceTypeList.ret;
        }
        '>'
    ;

arguments /*%% standardRuleIntro= type=ExpressionListNode %%*/
    :
        '('
        optionalExpressionList
        ')'
        {
            $ret = $optionalExpressionList.ret;
        }
    ;

// Parses a name chain.
name /*%% standardRuleIntro= type=NameNode %%*/
    :
        (
            /*%% spliceClause= type=NameNode %%*/
            a=identifier
            {
                $ret = factory.makeNormalNodeUnion(factory.makeSimpleNameNodeWithUnions($a.ret));
            }
        )
        (
            '.'
            b=identifier
            {
                $ret = factory.makeNormalNodeUnion(factory.makeQualifiedNameNodeWithUnions($ret, $b.ret));
            }
        )*
    ;

separatedQualifiedName returns [NodeUnion<? extends NameNode> name, NodeUnion<? extends IdentifierNode> ident]
        scope Rule;
        @init {
            ruleStart("separatedQualifiedName");
        }
        @after {
            ruleStop();
        }
    :
        a=identifier b=identifier
        {
            $name = factory.makeNormalNodeUnion(factory.makeSimpleNameNodeWithUnions($a.ret));
            $ident = $b.ret;                            
        }
        (
            c=identifier
            {
                $name = factory.makeNormalNodeUnion(factory.makeQualifiedNameNodeWithUnions($name, $ident));
                $ident = $c.ret;
            }
        )*
    ;

intLiteral /*%% standardRuleIntro= ruleParams="""boolean isNegative""" type=IntLiteralNode %%*/
    :  
        INTLITERAL
        {
            String s = $INTLITERAL.text;
            Integer i = BsjAntlrParserUtils.parseInt(
                    s,
                    isNegative,
                    getSourceLocation(-1),
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeNormalNodeUnion(factory.makeIntLiteralNode(i));
        }
    ;   
    
longLiteral /*%% standardRuleIntro= ruleParams="""boolean isNegative""" type=LongLiteralNode %%*/    
    :
        LONGLITERAL
        {
            String s = $LONGLITERAL.text;
            Long l = BsjAntlrParserUtils.parseLong(
                    s,
                    isNegative,
                    getSourceLocation(-1),
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeNormalNodeUnion(factory.makeLongLiteralNode(l));
        }
    ;

lexicalLiteral /*%% standardRuleIntro= type=LiteralNode<?> %%*/
    :
        intLiteral[false]
        {
            $ret = $intLiteral.ret;
        }
    |   
        longLiteral[false]
        {
            $ret = $longLiteral.ret;
        }
    |   
        FLOATLITERAL
        {
            String s = $FLOATLITERAL.text;
            float f = BsjAntlrParserUtils.parseFloat(
                    s,
                    getSourceLocation(-1),
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeNormalNodeUnion(factory.makeFloatLiteralNode(f));
        }
    |   
        DOUBLELITERAL
        {
            String s = $DOUBLELITERAL.text;
            double d = BsjAntlrParserUtils.parseDouble(
                    s,
                    getSourceLocation(-1),
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeNormalNodeUnion(factory.makeDoubleLiteralNode(d));
        }
    |   
        CHARLITERAL
        {
            String s = $CHARLITERAL.text;
            s = s.substring(1,s.length()-1);
            s = BsjAntlrParserUtils.unescape(s);
            if (s.length()!=1)
            {
                throw new IllegalStateException("Unescape of \"" + $CHARLITERAL.text + "\" resulted in \"" + s +
                        "\" (length!=1)");
            }
            $ret = factory.makeNormalNodeUnion(factory.makeCharLiteralNode(s.charAt(0)));
        }
    |   
        STRINGLITERAL
        {
            String s = $STRINGLITERAL.text;
            s = s.substring(1,s.length()-1);
            s = BsjAntlrParserUtils.unescape(s);
            $ret = factory.makeNormalNodeUnion(factory.makeStringLiteralNode(s));
        }
    |   
        TRUE
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBooleanLiteralNode(true));
        }
    |   
        FALSE
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBooleanLiteralNode(false));
        }
    |   
        NULL
        {
            $ret = factory.makeNormalNodeUnion(factory.makeNullLiteralNode());
        }
    |
        codeLiteral
        {
            $ret = $codeLiteral.ret;
        }
    ;

identifier /*%% standardRuleIntro= type=IdentifierNode %%*/
    :
        /*%% spliceClause= type=IdentifierNode %%*/
        IDENTIFIER
        {
            $ret = factory.makeNormalNodeUnion(factory.makeIdentifierNode($IDENTIFIER.text));
        }
    ;

unsplicableIdentifier /*%% standardRuleIntro= type=IdentifierNode unioned=false %%*/
    :
        IDENTIFIER
        {
            $ret = factory.makeIdentifierNode($IDENTIFIER.text);
        }        
    ;

// The following rules are for performance and error recovery purposes.  They are used as semantic hinting predicates to
// direct the parser down the correct path (so that a failed parse of "public class Foo ..." results in an error inside
// of the class rather than claiming that "class" should be an "@" for an annotation declaration).

classHeader 
    :   classModifiers 'class' identifier
    ;

enumHeader 
    :   enumModifiers ('enum'|identifier) identifier
    ;

interfaceHeader 
    :   interfaceModifiers 'interface' identifier
    ;

annotationHeader 
    :   annotationModifiers '@' 'interface' identifier
    ;

typeHeader
    :   (classModifiers | enumModifiers | interfaceModifiers | annotationModifiers) ('class'|'enum'|('@' ? 'interface')) identifier
    ;

methodHeader 
    :   methodModifiers typeParameters? (type|'void')? identifier '('
    ;

fieldHeader 
    :   fieldModifiers type identifier ('['']')* ('='|','|';')
    ;

localVariableHeader 
    :   variableModifiers type identifier ('['']')* ('='|','|';')
    ;

/* *** BSJ Code Literal Parse Rules *************************************** */

parseRule_AbstractMethodModifiers /*%% generateParseRule= antlrRuleName=annotationMethodModifiers type=AnnotationMethodModifiersNode %%*/ :;
parseRule_Annotation /*%% generateParseRule= type=AnnotationNode %%*/ :;
parseRule_Annotations /*%% generateParseRule= type=AnnotationListNode %%*/ :;
parseRule_AnnotationMethodDeclaration /*%% generateParseRule= type=AnnotationMethodDeclarationNode %%*/ :;
parseRule_AnnotationModifiers /*%% generateParseRule= type=AnnotationModifiersNode %%*/ :;
parseRule_AnnotationTypeBody /*%% generateParseRule= type=AnnotationBodyNode %%*/ :;
parseRule_AnnotationTypeElementDeclarations /*%% generateParseRule= type=AnnotationMemberListNode %%*/ :;
parseRule_AnnotationTypeElementDeclaration /*%% generateParseRule= type=AnnotationMemberNode %%*/ :;
parseRule_AnonymousClassBody /*%% generateParseRule= type=AnonymousClassBodyNode %%*/ :;
parseRule_AnonymousClassBodyDeclarations /*%% generateParseRule= type=AnonymousClassMemberListNode %%*/ :;
parseRule_AnonymousClassBodyDeclaration /*%% generateParseRule= type=AnonymousClassMemberNode %%*/ :;
parseRule_ArgumentList /*%% generateParseRule= antlrRuleName=expressionList type=ExpressionListNode %%*/ :;
parseRule_BlockStatement /*%% generateParseRule= type=BlockStatementNode %%*/ :;
parseRule_BlockStatements /*%% generateParseRule= antlrRuleName=blockStatementList type=BlockStatementListNode %%*/ :;
parseRule_CatchClause /*%% generateParseRule= type=CatchNode %%*/ :;
parseRule_Catches /*%% generateParseRule= type=CatchListNode %%*/ :;
parseRule_ClassBody /*%% generateParseRule= type=ClassBodyNode %%*/ :;
parseRule_ClassBodyDeclaration /*%% generateParseRule= type=ClassMemberNode %%*/ :;
parseRule_ClassBodyDeclarations /*%% generateParseRule= type=ClassMemberListNode %%*/ :;
parseRule_ClassModifiers /*%% generateParseRule= type=ClassModifiersNode %%*/ :;
parseRule_ClassOrInterfaceTypeList /*%% generateParseRule= antlrRuleName=declaredTypeList type=DeclaredTypeListNode %%*/ :;
parseRule_CompilationUnit[String name] returns [NodeUnion<? extends CompilationUnitNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_CompilationUnit");
        }
        @after {
            ruleStop();
        }
    :
        compilationUnit[name]
        EOF
        {
            $ret = $compilationUnit.ret;
        }
    ;

parseRule_ConstantDeclaration /*%% generateParseRule= type=ConstantDeclarationNode %%*/ :;
parseRule_ConstantModifiers /*%% generateParseRule= type=ConstantModifiersNode %%*/ :;
parseRule_ConstructorBody /*%% generateParseRule= type=ConstructorBodyNode %%*/ :;
parseRule_ConstructorDeclaration /*%% generateParseRule= type=ConstructorDeclarationNode %%*/ :;
parseRule_ConstructorModifiers /*%% generateParseRule= type=ConstructorModifiersNode %%*/ :;
parseRule_ElementValue /*%% generateParseRule= type=AnnotationValueNode %%*/ :;
parseRule_ElementValues /*%% generateParseRule= type=AnnotationValueListNode %%*/ :;
parseRule_ElementValuePair /*%% generateParseRule= type=AnnotationElementNode %%*/ :;
parseRule_ElementValuePairs /*%% generateParseRule= type=AnnotationElementListNode %%*/ :;
parseRule_EnumBody /*%% generateParseRule= type=EnumBodyNode %%*/ :;
parseRule_EnumConstant /*%% generateParseRule= type=EnumConstantDeclarationNode %%*/ :;
parseRule_EnumConstants /*%% generateParseRule= type=EnumConstantDeclarationListNode %%*/ :;
parseRule_EnumModifiers /*%% generateParseRule= type=EnumModifiersNode %%*/ :;
parseRule_ExceptionTypeList /*%% generateParseRule= antlrRuleName=unparameterizedTypeList type=UnparameterizedTypeListNode %%*/ :;
parseRule_ExplicitConstructorInvocation /*%% generateParseRule= type=ConstructorInvocationNode %%*/ :;
parseRule_FieldDeclaration /*%% generateParseRule= type=FieldDeclarationNode %%*/ :;
parseRule_FieldModifiers /*%% generateParseRule= type=FieldModifiersNode %%*/ :;
parseRule_ForInit /*%% generateParseRule= type=ForInitializerNode %%*/ :;
parseRule_FormalParameter /*%% generateParseRule= type=VariableNode %%*/ :;
parseRule_Identifier /*%% generateParseRule= type=IdentifierNode %%*/ :;
parseRule_IdentifierList /*%% generateParseRule= type=IdentifierListNode %%*/ :;
parseRule_ImportDeclaration /*%% generateParseRule= type=ImportNode %%*/ :;
parseRule_ImportDeclarations /*%% generateParseRule= type=ImportListNode %%*/ :;
parseRule_Initializer /*%% generateParseRule= antlrRuleName=initializerBlock type=InitializerDeclarationNode %%*/ :;
parseRule_InterfaceBody /*%% generateParseRule= type=InterfaceBodyNode %%*/ :;
parseRule_InterfaceMemberDeclaration /*%% generateParseRule= antlrRuleName=interfaceBodyDeclaration type=InterfaceMemberNode %%*/ :;
parseRule_InterfaceMemberDeclarations /*%% generateParseRule= antlrRuleName=interfaceBodyDeclarations type=InterfaceMemberListNode %%*/ :;
parseRule_InterfaceModifiers /*%% generateParseRule= type=InterfaceModifiersNode %%*/ :;
parseRule_JavadocComment returns [NodeUnion<? extends JavadocNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_JavadocComment");
        }
        @after {
            ruleStop();
        }
    :
        /* TODO */
        EOF
    ;

parseRule_LocalClassDeclaration /*%% generateParseRule= antlrRuleName=localClassDeclaration type=LocalClassDeclarationNode %%*/ :;
parseRule_LocalClassModifiers /*%% generateParseRule= antlrRuleName=localClassModifiers type=LocalClassModifiersNode %%*/ :;
parseRule_MetaAnnotation /*%% generateParseRule= type=MetaAnnotationNode %%*/ :;
parseRule_MetaAnnotationList /*%% generateParseRule= type=MetaAnnotationListNode %%*/ :;
parseRule_MetaAnnotationElement /*%% generateParseRule= antlrRuleName=metaAnnotationElementValuePair type=MetaAnnotationElementNode %%*/ :;
parseRule_MetaAnnotationElements /*%% generateParseRule= antlrRuleName=metaAnnotationElementValuePairs type=MetaAnnotationElementListNode %%*/ :;
parseRule_MetaAnnotationElementValue /*%% generateParseRule= type=MetaAnnotationValueNode %%*/ :;
parseRule_MetaAnnotationElementValues /*%% generateParseRule= type=MetaAnnotationValueListNode %%*/ :;
parseRule_Metaprogram /*%% generateParseRule= antlrRuleName=bsjMetaprogram type=MetaprogramNode %%*/ :;
parseRule_MetaprogramDependency /*%% generateParseRule= type=MetaprogramDependencyNode %%*/ :;
parseRule_MetaprogramDependencyDeclaration /*%% generateParseRule= type=MetaprogramDependencyDeclarationNode %%*/ :;
parseRule_MetaprogramDependencyDeclarationList /*%% generateParseRule= type=MetaprogramDependencyDeclarationListNode %%*/ :;
parseRule_MetaprogramDependencyList /*%% generateParseRule= type=MetaprogramDependencyListNode %%*/ :;
parseRule_MetaprogramImportDeclaration /*%% generateParseRule= antlrRuleName=metaprogramImport type=MetaprogramImportNode %%*/ :;
parseRule_MetaprogramImportDeclarationList /*%% generateParseRule= antlrRuleName=metaImportDeclarations type=MetaprogramImportListNode %%*/ :;
parseRule_MetaprogramTargetDeclaration /*%% generateParseRule= antlrRuleName=metaprogramTarget type=MetaprogramTargetNode %%*/ :;
parseRule_MetaprogramTargetDeclarationList /*%% generateParseRule= antlrRuleName=metaprogramTargetList type=MetaprogramTargetListNode %%*/ :;
parseRule_MethodDeclaration /*%% generateParseRule= type=MethodDeclarationNode %%*/ :;
parseRule_MethodModifiers /*%% generateParseRule= type=MethodModifiersNode %%*/ :;
parseRule_Name /*%% generateParseRule= type=NameNode %%*/ :;
parseRule_PackageDeclaration /*%% generateParseRule= type=PackageDeclarationNode %%*/ :;
parseRule_Preamble /*%% generateParseRule= type=MetaprogramPreambleNode %%*/ :;
parseRule_ReferenceTypeList /*%% generateParseRule= type=ReferenceTypeListNode %%*/ :;
parseRule_StatementExpressionList /*%% generateParseRule= type=StatementExpressionListNode %%*/ :;
parseRule_SwitchBlockStatementGroup /*%% generateParseRule= type=CaseNode %%*/ :;
parseRule_SwitchBlockStatementGroups /*%% generateParseRule= type=CaseListNode %%*/ :;
parseRule_Type /*%% generateParseRule= type=TypeNode %%*/ :;
parseRule_TypeArguments /*%% generateParseRule= type=TypeArgumentListNode %%*/ :;
parseRule_TypeDeclaration /*%% generateParseRule= type=TypeDeclarationNode %%*/ :;
parseRule_TypeDeclarations /*%% generateParseRule= type=TypeDeclarationListNode %%*/ :;
parseRule_TypeParameter /*%% generateParseRule= type=TypeParameterNode %%*/ :;
parseRule_TypeParameters /*%% generateParseRule= type=TypeParameterListNode %%*/ :;
parseRule_VariableDeclarator /*%% generateParseRule= type=VariableDeclaratorNode %%*/ :;
parseRule_VariableDeclarators /*%% generateParseRule= type=VariableDeclaratorListNode %%*/ :;
parseRule_VariableInitializer /*%% generateParseRule= type=VariableInitializerNode %%*/ :;
parseRule_VariableInitializers /*%% generateParseRule= type=VariableInitializerListNode %%*/ :;
parseRule_VariableModifiers /*%% generateParseRule= type=VariableModifiersNode %%*/ :;
parseRule_Wildcard /*%% generateParseRule= type=WildcardTypeNode %%*/ :;

/********************************************************************************************
                  Lexer section
*********************************************************************************************/

/* *** BSJ lexer rules **************************************************** */

METAIMPORT
    :   '#import'
    ;

METATARGET
    :   '#target'
    ;

METADEPENDS
    :   '#depends'
    ;

METAWEAK
    :   '#weak'
    ;

METAPROGRAM_START
    :   '[:'
    ;
    
METAPROGRAM_STOP
    :   ':]'
    ;
    
CODELITERAL_START
    :   '<:'
    ;

CODELITERAL_STOP
    :   ':>'
    ;

/* *** Java lexer rules *************************************************** */

LONGLITERAL
    :   IntegerNumber LongSuffix
    ;

    
INTLITERAL
    :   IntegerNumber 
    ;
    
fragment
IntegerNumber
    :   '0' 
    |   '1'..'9' ('0'..'9')*    
    |   '0' ('0'..'7')+         
    |   HexPrefix HexDigit+        
    ;

fragment
HexPrefix
    :   '0x' | '0X'
    ;
        
fragment
HexDigit
    :   ('0'..'9'|'a'..'f'|'A'..'F')
    ;

fragment
LongSuffix
    :   'l' | 'L'
    ;

fragment
NonIntegerNumber
    :   ('0' .. '9')+ '.' ('0' .. '9')* Exponent?  
    |   '.' ( '0' .. '9' )+ Exponent?  
    |   ('0' .. '9')+ Exponent  
    |   ('0' .. '9')+ 
    |   
        HexPrefix (HexDigit )* 
        (    () 
        |    ('.' (HexDigit )* ) 
        ) 
        ( 'p' | 'P' ) 
        ( '+' | '-' )? 
        ( '0' .. '9' )+
        ;
        
fragment 
Exponent    
    :   ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ 
    ;
    
fragment 
FloatSuffix
    :   'f' | 'F' 
    ;     

fragment
DoubleSuffix
    :   'd' | 'D'
    ;
        
FLOATLITERAL
    :   NonIntegerNumber FloatSuffix
    ;
    
DOUBLELITERAL
    :   NonIntegerNumber DoubleSuffix?
    ;

CHARLITERAL
    :   '\'' 
        (   EscapeSequence 
        |   ~( '\'' | '\\' | '\r' | '\n' )
        ) 
        '\''
    ; 

STRINGLITERAL
    :   '"' 
        (   EscapeSequence
        |   ~( '\\' | '"' | '\r' | '\n' )        
        )* 
        '"' 
    ;

fragment
EscapeSequence 
    :   '\\' (
                 'b' 
             |   't' 
             |   'n' 
             |   'f' 
             |   'r' 
             |   '\"' 
             |   '\'' 
             |   '\\' 
             |       
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |       
                 ('0'..'7') ('0'..'7') 
             |       
                 ('0'..'7')
             )          
;     

WS  
    :   (
             ' '
        |    '\r'
        |    '\t'
        |    '\u000C'
        |    '\n'
        ) 
            {
                skip();
            }          
    ;
    
COMMENT
         @init{
            boolean isJavaDoc = false;
        }
    :   '/*'
            {
                if((char)input.LA(1) == '*'){
                    isJavaDoc = true;
                }
            }
        (options {greedy=false;} : . )* 
        '*/'
            {
                if(isJavaDoc==true){
                    $channel=HIDDEN;
                }else{
                    skip();
                }
            }
    ;

LINE_COMMENT
    :   '//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') 
            {
                skip();
            }
    |   '//' ~('\n'|'\r')*     // a line comment could appear at the end of the file without CR/LF
            {
                skip();
            }
    ;   
        
ABSTRACT
    :   'abstract'
    ;
    
ASSERT
    :   'assert'
    ;
    
BOOLEAN
    :   'boolean'
    ;
    
BREAK
    :   'break'
    ;
    
BYTE
    :   'byte'
    ;
    
CASE
    :   'case'
    ;
    
CATCH
    :   'catch'
    ;
    
CHAR
    :   'char'
    ;
    
CLASS
    :   'class'
    ;
    
CONST
    :   'const'
    ;

CONTINUE
    :   'continue'
    ;

DEFAULT
    :   'default'
    ;

DO
    :   'do'
    ;

DOUBLE
    :   'double'
    ;

ELSE
    :   'else'
    ;

ENUM
    :   'enum'
    ;             

EXTENDS
    :   'extends'
    ;

FINAL
    :   'final'
    ;

FINALLY
    :   'finally'
    ;

FLOAT
    :   'float'
    ;

FOR
    :   'for'
    ;

GOTO
    :   'goto'
    ;

IF
    :   'if'
    ;

IMPLEMENTS
    :   'implements'
    ;

IMPORT
    :   'import'
    ;

INSTANCEOF
    :   'instanceof'
    ;

INT
    :   'int'
    ;

INTERFACE
    :   'interface'
    ;

LONG
    :   'long'
    ;

NATIVE
    :   'native'
    ;

NEW
    :   'new'
    ;

PACKAGE
    :   'package'
    ;

PRIVATE
    :   'private'
    ;

PROTECTED
    :   'protected'
    ;

PUBLIC
    :   'public'
    ;

RETURN
    :   'return'
    ;

SHORT
    :   'short'
    ;

STATIC
    :   'static'
    ;

STRICTFP
    :   'strictfp'
    ;

SUPER
    :   'super'
    ;

SWITCH
    :   'switch'
    ;

SYNCHRONIZED
    :   'synchronized'
    ;

THIS
    :   'this'
    ;

THROW
    :   'throw'
    ;

THROWS
    :   'throws'
    ;

TRANSIENT
    :   'transient'
    ;

TRY
    :   'try'
    ;

VOID
    :   'void'
    ;

VOLATILE
    :   'volatile'
    ;

WHILE
    :   'while'
    ;

TRUE
    :   'true'
    ;

FALSE
    :   'false'
    ;

NULL
    :   'null'
    ;

LPAREN
    :   '('
    ;

RPAREN
    :   ')'
    ;

LBRACE
    :   '{'
    ;

RBRACE
    :   '}'
    ;

LBRACKET
    :   '['
    ;

RBRACKET
    :   ']'
    ;

SEMI
    :   ';'
    ;

COMMA
    :   ','
    ;

DOT
    :   '.'
    ;

ELLIPSIS
    :   '...'
    ;

EQ
    :   '='
    ;

BANG
    :   '!'
    ;

TILDE
    :   '~'
    ;

QUES
    :   '?'
    ;

COLON
    :   ':'
    ;

EQEQ
    :   '=='
    ;

AMPAMP
    :   '&&'
    ;

BARBAR
    :   '||'
    ;

PLUSPLUS
    :   '++'
    ;

SUBSUB
    :   '--'
    ;

PLUS
    :   '+'
    ;

SUB
    :   '-'
    ;

STAR
    :   '*'
    ;

SLASH
    :   '/'
    ;

AMP
    :   '&'
    ;

BAR
    :   '|'
    ;

CARET
    :   '^'
    ;

PERCENT
    :   '%'
    ;

PLUSEQ
    :   '+='
    ; 
    
SUBEQ
    :   '-='
    ;

STAREQ
    :   '*='
    ;

SLASHEQ
    :   '/='
    ;

AMPEQ
    :   '&='
    ;

BAREQ
    :   '|='
    ;

CARETEQ
    :   '^='
    ;

PERCENTEQ
    :   '%='
    ;

MONKEYS_AT
    :   '@'
    ;

BANGEQ
    :   '!='
    ;

GT
    :   '>'
    ;

LT
    :   '<'
    ;        
              
IDENTIFIER
    :   IdentifierStart IdentifierPart*
    ;

fragment
SurrogateIdentifer 
    :   ('\ud800'..'\udbff') ('\udc00'..'\udfff') 
    ;                 

fragment
IdentifierStart
    :   '\u0024'
    |   '\u0041'..'\u005a'
    |   '\u005f'
    |   '\u0061'..'\u007a'
    |   '\u00a2'..'\u00a5'
    |   '\u00aa'
    |   '\u00b5'
    |   '\u00ba'
    |   '\u00c0'..'\u00d6'
    |   '\u00d8'..'\u00f6'
    |   '\u00f8'..'\u0236'
    |   '\u0250'..'\u02c1'
    |   '\u02c6'..'\u02d1'
    |   '\u02e0'..'\u02e4'
    |   '\u02ee'
    |   '\u037a'
    |   '\u0386'
    |   '\u0388'..'\u038a'
    |   '\u038c'
    |   '\u038e'..'\u03a1'
    |   '\u03a3'..'\u03ce'
    |   '\u03d0'..'\u03f5'
    |   '\u03f7'..'\u03fb'
    |   '\u0400'..'\u0481'
    |   '\u048a'..'\u04ce'
    |   '\u04d0'..'\u04f5'
    |   '\u04f8'..'\u04f9'
    |   '\u0500'..'\u050f'
    |   '\u0531'..'\u0556'
    |   '\u0559'
    |   '\u0561'..'\u0587'
    |   '\u05d0'..'\u05ea'
    |   '\u05f0'..'\u05f2'
    |   '\u0621'..'\u063a'
    |   '\u0640'..'\u064a'
    |   '\u066e'..'\u066f'
    |   '\u0671'..'\u06d3'
    |   '\u06d5'
    |   '\u06e5'..'\u06e6'
    |   '\u06ee'..'\u06ef'
    |   '\u06fa'..'\u06fc'
    |   '\u06ff'
    |   '\u0710'
    |   '\u0712'..'\u072f'
    |   '\u074d'..'\u074f'
    |   '\u0780'..'\u07a5'
    |   '\u07b1'
    |   '\u0904'..'\u0939'
    |   '\u093d'
    |   '\u0950'
    |   '\u0958'..'\u0961'
    |   '\u0985'..'\u098c'
    |   '\u098f'..'\u0990'
    |   '\u0993'..'\u09a8'
    |   '\u09aa'..'\u09b0'
    |   '\u09b2'
    |   '\u09b6'..'\u09b9'
    |   '\u09bd'
    |   '\u09dc'..'\u09dd'
    |   '\u09df'..'\u09e1'
    |   '\u09f0'..'\u09f3'
    |   '\u0a05'..'\u0a0a'
    |   '\u0a0f'..'\u0a10'
    |   '\u0a13'..'\u0a28'
    |   '\u0a2a'..'\u0a30'
    |   '\u0a32'..'\u0a33'
    |   '\u0a35'..'\u0a36'
    |   '\u0a38'..'\u0a39'
    |   '\u0a59'..'\u0a5c'
    |   '\u0a5e'
    |   '\u0a72'..'\u0a74'
    |   '\u0a85'..'\u0a8d'
    |   '\u0a8f'..'\u0a91'
    |   '\u0a93'..'\u0aa8'
    |   '\u0aaa'..'\u0ab0'
    |   '\u0ab2'..'\u0ab3'
    |   '\u0ab5'..'\u0ab9'
    |   '\u0abd'
    |   '\u0ad0'
    |   '\u0ae0'..'\u0ae1'
    |   '\u0af1'
    |   '\u0b05'..'\u0b0c'
    |   '\u0b0f'..'\u0b10'
    |   '\u0b13'..'\u0b28'
    |   '\u0b2a'..'\u0b30'
    |   '\u0b32'..'\u0b33'
    |   '\u0b35'..'\u0b39'
    |   '\u0b3d'
    |   '\u0b5c'..'\u0b5d'
    |   '\u0b5f'..'\u0b61'
    |   '\u0b71'
    |   '\u0b83'
    |   '\u0b85'..'\u0b8a'
    |   '\u0b8e'..'\u0b90'
    |   '\u0b92'..'\u0b95'
    |   '\u0b99'..'\u0b9a'
    |   '\u0b9c'
    |   '\u0b9e'..'\u0b9f'
    |   '\u0ba3'..'\u0ba4'
    |   '\u0ba8'..'\u0baa'
    |   '\u0bae'..'\u0bb5'
    |   '\u0bb7'..'\u0bb9'
    |   '\u0bf9'
    |   '\u0c05'..'\u0c0c'
    |   '\u0c0e'..'\u0c10'
    |   '\u0c12'..'\u0c28'
    |   '\u0c2a'..'\u0c33'
    |   '\u0c35'..'\u0c39'
    |   '\u0c60'..'\u0c61'
    |   '\u0c85'..'\u0c8c'
    |   '\u0c8e'..'\u0c90'
    |   '\u0c92'..'\u0ca8'
    |   '\u0caa'..'\u0cb3'
    |   '\u0cb5'..'\u0cb9'
    |   '\u0cbd'
    |   '\u0cde'
    |   '\u0ce0'..'\u0ce1'
    |   '\u0d05'..'\u0d0c'
    |   '\u0d0e'..'\u0d10'
    |   '\u0d12'..'\u0d28'
    |   '\u0d2a'..'\u0d39'
    |   '\u0d60'..'\u0d61'
    |   '\u0d85'..'\u0d96'
    |   '\u0d9a'..'\u0db1'
    |   '\u0db3'..'\u0dbb'
    |   '\u0dbd'
    |   '\u0dc0'..'\u0dc6'
    |   '\u0e01'..'\u0e30'
    |   '\u0e32'..'\u0e33'
    |   '\u0e3f'..'\u0e46'
    |   '\u0e81'..'\u0e82'
    |   '\u0e84'
    |   '\u0e87'..'\u0e88'
    |   '\u0e8a'
    |   '\u0e8d'
    |   '\u0e94'..'\u0e97'
    |   '\u0e99'..'\u0e9f'
    |   '\u0ea1'..'\u0ea3'
    |   '\u0ea5'
    |   '\u0ea7'
    |   '\u0eaa'..'\u0eab'
    |   '\u0ead'..'\u0eb0'
    |   '\u0eb2'..'\u0eb3'
    |   '\u0ebd'
    |   '\u0ec0'..'\u0ec4'
    |   '\u0ec6'
    |   '\u0edc'..'\u0edd'
    |   '\u0f00'
    |   '\u0f40'..'\u0f47'
    |   '\u0f49'..'\u0f6a'
    |   '\u0f88'..'\u0f8b'
    |   '\u1000'..'\u1021'
    |   '\u1023'..'\u1027'
    |   '\u1029'..'\u102a'
    |   '\u1050'..'\u1055'
    |   '\u10a0'..'\u10c5'
    |   '\u10d0'..'\u10f8'
    |   '\u1100'..'\u1159'
    |   '\u115f'..'\u11a2'
    |   '\u11a8'..'\u11f9'
    |   '\u1200'..'\u1206'
    |   '\u1208'..'\u1246'
    |   '\u1248'
    |   '\u124a'..'\u124d'
    |   '\u1250'..'\u1256'
    |   '\u1258'
    |   '\u125a'..'\u125d'
    |   '\u1260'..'\u1286'
    |   '\u1288'
    |   '\u128a'..'\u128d'
    |   '\u1290'..'\u12ae'
    |   '\u12b0'
    |   '\u12b2'..'\u12b5'
    |   '\u12b8'..'\u12be'
    |   '\u12c0'
    |   '\u12c2'..'\u12c5'
    |   '\u12c8'..'\u12ce'
    |   '\u12d0'..'\u12d6'
    |   '\u12d8'..'\u12ee'
    |   '\u12f0'..'\u130e'
    |   '\u1310'
    |   '\u1312'..'\u1315'
    |   '\u1318'..'\u131e'
    |   '\u1320'..'\u1346'
    |   '\u1348'..'\u135a'
    |   '\u13a0'..'\u13f4'
    |   '\u1401'..'\u166c'
    |   '\u166f'..'\u1676'
    |   '\u1681'..'\u169a'
    |   '\u16a0'..'\u16ea'
    |   '\u16ee'..'\u16f0'
    |   '\u1700'..'\u170c'
    |   '\u170e'..'\u1711'
    |   '\u1720'..'\u1731'
    |   '\u1740'..'\u1751'
    |   '\u1760'..'\u176c'
    |   '\u176e'..'\u1770'
    |   '\u1780'..'\u17b3'
    |   '\u17d7' 
    |   '\u17db'..'\u17dc'
    |   '\u1820'..'\u1877'
    |   '\u1880'..'\u18a8'
    |   '\u1900'..'\u191c'
    |   '\u1950'..'\u196d'
    |   '\u1970'..'\u1974'
    |   '\u1d00'..'\u1d6b'
    |   '\u1e00'..'\u1e9b'
    |   '\u1ea0'..'\u1ef9'
    |   '\u1f00'..'\u1f15'
    |   '\u1f18'..'\u1f1d'
    |   '\u1f20'..'\u1f45'
    |   '\u1f48'..'\u1f4d'
    |   '\u1f50'..'\u1f57'
    |   '\u1f59'
    |   '\u1f5b'
    |   '\u1f5d'
    |   '\u1f5f'..'\u1f7d'
    |   '\u1f80'..'\u1fb4'
    |   '\u1fb6'..'\u1fbc'
    |   '\u1fbe'
    |   '\u1fc2'..'\u1fc4'
    |   '\u1fc6'..'\u1fcc'
    |   '\u1fd0'..'\u1fd3'
    |   '\u1fd6'..'\u1fdb'
    |   '\u1fe0'..'\u1fec'
    |   '\u1ff2'..'\u1ff4'
    |   '\u1ff6'..'\u1ffc'
    |   '\u203f'..'\u2040'
    |   '\u2054'
    |   '\u2071'
    |   '\u207f'
    |   '\u20a0'..'\u20b1'
    |   '\u2102'
    |   '\u2107'
    |   '\u210a'..'\u2113'
    |   '\u2115'
    |   '\u2119'..'\u211d'
    |   '\u2124'
    |   '\u2126'
    |   '\u2128'
    |   '\u212a'..'\u212d'
    |   '\u212f'..'\u2131'
    |   '\u2133'..'\u2139'
    |   '\u213d'..'\u213f'
    |   '\u2145'..'\u2149'
    |   '\u2160'..'\u2183'
    |   '\u3005'..'\u3007'
    |   '\u3021'..'\u3029'
    |   '\u3031'..'\u3035'
    |   '\u3038'..'\u303c'
    |   '\u3041'..'\u3096'
    |   '\u309d'..'\u309f'
    |   '\u30a1'..'\u30ff'
    |   '\u3105'..'\u312c'
    |   '\u3131'..'\u318e'
    |   '\u31a0'..'\u31b7'
    |   '\u31f0'..'\u31ff'
    |   '\u3400'..'\u4db5'
    |   '\u4e00'..'\u9fa5'
    |   '\ua000'..'\ua48c'
    |   '\uac00'..'\ud7a3'
    |   '\uf900'..'\ufa2d'
    |   '\ufa30'..'\ufa6a'
    |   '\ufb00'..'\ufb06'
    |   '\ufb13'..'\ufb17'
    |   '\ufb1d'
    |   '\ufb1f'..'\ufb28'
    |   '\ufb2a'..'\ufb36'
    |   '\ufb38'..'\ufb3c'
    |   '\ufb3e'
    |   '\ufb40'..'\ufb41'
    |   '\ufb43'..'\ufb44'
    |   '\ufb46'..'\ufbb1'
    |   '\ufbd3'..'\ufd3d'
    |   '\ufd50'..'\ufd8f'
    |   '\ufd92'..'\ufdc7'
    |   '\ufdf0'..'\ufdfc'
    |   '\ufe33'..'\ufe34'
    |   '\ufe4d'..'\ufe4f'
    |   '\ufe69'
    |   '\ufe70'..'\ufe74'
    |   '\ufe76'..'\ufefc'
    |   '\uff04'
    |   '\uff21'..'\uff3a'
    |   '\uff3f'
    |   '\uff41'..'\uff5a'
    |   '\uff65'..'\uffbe'
    |   '\uffc2'..'\uffc7'
    |   '\uffca'..'\uffcf'
    |   '\uffd2'..'\uffd7'
    |   '\uffda'..'\uffdc'
    |   '\uffe0'..'\uffe1'
    |   '\uffe5'..'\uffe6'
    |   ('\ud800'..'\udbff') ('\udc00'..'\udfff') 
    ;                
                       
fragment 
IdentifierPart
    :   '\u0000'..'\u0008'
    |   '\u000e'..'\u001b'
    |   '\u0024'
    |   '\u0030'..'\u0039'
    |   '\u0041'..'\u005a'
    |   '\u005f'
    |   '\u0061'..'\u007a'
    |   '\u007f'..'\u009f'
    |   '\u00a2'..'\u00a5'
    |   '\u00aa'
    |   '\u00ad'
    |   '\u00b5'
    |   '\u00ba'
    |   '\u00c0'..'\u00d6'
    |   '\u00d8'..'\u00f6'
    |   '\u00f8'..'\u0236'
    |   '\u0250'..'\u02c1'
    |   '\u02c6'..'\u02d1'
    |   '\u02e0'..'\u02e4'
    |   '\u02ee'
    |   '\u0300'..'\u0357'
    |   '\u035d'..'\u036f'
    |   '\u037a'
    |   '\u0386'
    |   '\u0388'..'\u038a'
    |   '\u038c'
    |   '\u038e'..'\u03a1'
    |   '\u03a3'..'\u03ce'
    |   '\u03d0'..'\u03f5'
    |   '\u03f7'..'\u03fb'
    |   '\u0400'..'\u0481'
    |   '\u0483'..'\u0486'
    |   '\u048a'..'\u04ce'
    |   '\u04d0'..'\u04f5'
    |   '\u04f8'..'\u04f9'
    |   '\u0500'..'\u050f'
    |   '\u0531'..'\u0556'
    |   '\u0559'
    |   '\u0561'..'\u0587'
    |   '\u0591'..'\u05a1'
    |   '\u05a3'..'\u05b9'
    |   '\u05bb'..'\u05bd'
    |   '\u05bf'
    |   '\u05c1'..'\u05c2'
    |   '\u05c4'
    |   '\u05d0'..'\u05ea'
    |   '\u05f0'..'\u05f2'
    |   '\u0600'..'\u0603'
    |   '\u0610'..'\u0615'
    |   '\u0621'..'\u063a'
    |   '\u0640'..'\u0658'
    |   '\u0660'..'\u0669'
    |   '\u066e'..'\u06d3'
    |   '\u06d5'..'\u06dd'
    |   '\u06df'..'\u06e8'
    |   '\u06ea'..'\u06fc'
    |   '\u06ff'
    |   '\u070f'..'\u074a'
    |   '\u074d'..'\u074f'
    |   '\u0780'..'\u07b1'
    |   '\u0901'..'\u0939'
    |   '\u093c'..'\u094d'
    |   '\u0950'..'\u0954'
    |   '\u0958'..'\u0963'
    |   '\u0966'..'\u096f'
    |   '\u0981'..'\u0983'
    |   '\u0985'..'\u098c'
    |   '\u098f'..'\u0990'
    |   '\u0993'..'\u09a8'
    |   '\u09aa'..'\u09b0'
    |   '\u09b2'
    |   '\u09b6'..'\u09b9'
    |   '\u09bc'..'\u09c4'
    |   '\u09c7'..'\u09c8'
    |   '\u09cb'..'\u09cd'
    |   '\u09d7'
    |   '\u09dc'..'\u09dd'
    |   '\u09df'..'\u09e3'
    |   '\u09e6'..'\u09f3'
    |   '\u0a01'..'\u0a03'
    |   '\u0a05'..'\u0a0a'
    |   '\u0a0f'..'\u0a10'
    |   '\u0a13'..'\u0a28'
    |   '\u0a2a'..'\u0a30'
    |   '\u0a32'..'\u0a33'
    |   '\u0a35'..'\u0a36'
    |   '\u0a38'..'\u0a39'
    |   '\u0a3c'
    |   '\u0a3e'..'\u0a42'
    |   '\u0a47'..'\u0a48'
    |   '\u0a4b'..'\u0a4d'
    |   '\u0a59'..'\u0a5c'
    |   '\u0a5e'
    |   '\u0a66'..'\u0a74'
    |   '\u0a81'..'\u0a83'
    |   '\u0a85'..'\u0a8d'
    |   '\u0a8f'..'\u0a91'
    |   '\u0a93'..'\u0aa8'
    |   '\u0aaa'..'\u0ab0'
    |   '\u0ab2'..'\u0ab3'
    |   '\u0ab5'..'\u0ab9'
    |   '\u0abc'..'\u0ac5'
    |   '\u0ac7'..'\u0ac9'
    |   '\u0acb'..'\u0acd'
    |   '\u0ad0'
    |   '\u0ae0'..'\u0ae3'
    |   '\u0ae6'..'\u0aef'
    |   '\u0af1'
    |   '\u0b01'..'\u0b03'
    |   '\u0b05'..'\u0b0c'        
    |   '\u0b0f'..'\u0b10'
    |   '\u0b13'..'\u0b28'
    |   '\u0b2a'..'\u0b30'
    |   '\u0b32'..'\u0b33'
    |   '\u0b35'..'\u0b39'
    |   '\u0b3c'..'\u0b43'
    |   '\u0b47'..'\u0b48'
    |   '\u0b4b'..'\u0b4d'
    |   '\u0b56'..'\u0b57'
    |   '\u0b5c'..'\u0b5d'
    |   '\u0b5f'..'\u0b61'
    |   '\u0b66'..'\u0b6f'
    |   '\u0b71'
    |   '\u0b82'..'\u0b83'
    |   '\u0b85'..'\u0b8a'
    |   '\u0b8e'..'\u0b90'
    |   '\u0b92'..'\u0b95'
    |   '\u0b99'..'\u0b9a'
    |   '\u0b9c'
    |   '\u0b9e'..'\u0b9f'
    |   '\u0ba3'..'\u0ba4'
    |   '\u0ba8'..'\u0baa'
    |   '\u0bae'..'\u0bb5'
    |   '\u0bb7'..'\u0bb9'
    |   '\u0bbe'..'\u0bc2'
    |   '\u0bc6'..'\u0bc8'
    |   '\u0bca'..'\u0bcd'
    |   '\u0bd7'
    |   '\u0be7'..'\u0bef'
    |   '\u0bf9'
    |   '\u0c01'..'\u0c03'
    |   '\u0c05'..'\u0c0c'
    |   '\u0c0e'..'\u0c10'
    |   '\u0c12'..'\u0c28'
    |   '\u0c2a'..'\u0c33'
    |   '\u0c35'..'\u0c39'
    |   '\u0c3e'..'\u0c44'
    |   '\u0c46'..'\u0c48'
    |   '\u0c4a'..'\u0c4d'
    |   '\u0c55'..'\u0c56'
    |   '\u0c60'..'\u0c61'
    |   '\u0c66'..'\u0c6f'        
    |   '\u0c82'..'\u0c83'
    |   '\u0c85'..'\u0c8c'
    |   '\u0c8e'..'\u0c90'
    |   '\u0c92'..'\u0ca8'
    |   '\u0caa'..'\u0cb3'
    |   '\u0cb5'..'\u0cb9'
    |   '\u0cbc'..'\u0cc4'
    |   '\u0cc6'..'\u0cc8'
    |   '\u0cca'..'\u0ccd'
    |   '\u0cd5'..'\u0cd6'
    |   '\u0cde'
    |   '\u0ce0'..'\u0ce1'
    |   '\u0ce6'..'\u0cef'
    |   '\u0d02'..'\u0d03'
    |   '\u0d05'..'\u0d0c'
    |   '\u0d0e'..'\u0d10'
    |   '\u0d12'..'\u0d28'
    |   '\u0d2a'..'\u0d39'
    |   '\u0d3e'..'\u0d43'
    |   '\u0d46'..'\u0d48'
    |   '\u0d4a'..'\u0d4d'
    |   '\u0d57'
    |   '\u0d60'..'\u0d61'
    |   '\u0d66'..'\u0d6f'
    |   '\u0d82'..'\u0d83'
    |   '\u0d85'..'\u0d96'
    |   '\u0d9a'..'\u0db1'
    |   '\u0db3'..'\u0dbb'
    |   '\u0dbd'
    |   '\u0dc0'..'\u0dc6'
    |   '\u0dca'
    |   '\u0dcf'..'\u0dd4'
    |   '\u0dd6'
    |   '\u0dd8'..'\u0ddf'
    |   '\u0df2'..'\u0df3'
    |   '\u0e01'..'\u0e3a'
    |   '\u0e3f'..'\u0e4e'
    |   '\u0e50'..'\u0e59'
    |   '\u0e81'..'\u0e82'
    |   '\u0e84'
    |   '\u0e87'..'\u0e88'        
    |   '\u0e8a'
    |   '\u0e8d'
    |   '\u0e94'..'\u0e97'
    |   '\u0e99'..'\u0e9f'
    |   '\u0ea1'..'\u0ea3'
    |   '\u0ea5'
    |   '\u0ea7'
    |   '\u0eaa'..'\u0eab'
    |   '\u0ead'..'\u0eb9'
    |   '\u0ebb'..'\u0ebd'
    |   '\u0ec0'..'\u0ec4'
    |   '\u0ec6'
    |   '\u0ec8'..'\u0ecd'
    |   '\u0ed0'..'\u0ed9'
    |   '\u0edc'..'\u0edd'
    |   '\u0f00'
    |   '\u0f18'..'\u0f19'
    |   '\u0f20'..'\u0f29'
    |   '\u0f35'
    |   '\u0f37'
    |   '\u0f39'
    |   '\u0f3e'..'\u0f47'
    |   '\u0f49'..'\u0f6a'
    |   '\u0f71'..'\u0f84'
    |   '\u0f86'..'\u0f8b'
    |   '\u0f90'..'\u0f97'
    |   '\u0f99'..'\u0fbc'
    |   '\u0fc6'
    |   '\u1000'..'\u1021'
    |   '\u1023'..'\u1027'
    |   '\u1029'..'\u102a'
    |   '\u102c'..'\u1032'
    |   '\u1036'..'\u1039'
    |   '\u1040'..'\u1049'
    |   '\u1050'..'\u1059'
    |   '\u10a0'..'\u10c5'
    |   '\u10d0'..'\u10f8'
    |   '\u1100'..'\u1159'
    |   '\u115f'..'\u11a2'
    |   '\u11a8'..'\u11f9'
    |   '\u1200'..'\u1206'        
    |   '\u1208'..'\u1246'
    |   '\u1248'
    |   '\u124a'..'\u124d'
    |   '\u1250'..'\u1256'
    |   '\u1258'
    |   '\u125a'..'\u125d'
    |   '\u1260'..'\u1286'
    |   '\u1288'        
    |   '\u128a'..'\u128d'
    |   '\u1290'..'\u12ae'
    |   '\u12b0'
    |   '\u12b2'..'\u12b5'
    |   '\u12b8'..'\u12be'
    |   '\u12c0'
    |   '\u12c2'..'\u12c5'
    |   '\u12c8'..'\u12ce'
    |   '\u12d0'..'\u12d6'
    |   '\u12d8'..'\u12ee'
    |   '\u12f0'..'\u130e'
    |   '\u1310'
    |   '\u1312'..'\u1315'
    |   '\u1318'..'\u131e'
    |   '\u1320'..'\u1346'
    |   '\u1348'..'\u135a'
    |   '\u1369'..'\u1371'
    |   '\u13a0'..'\u13f4'
    |   '\u1401'..'\u166c'
    |   '\u166f'..'\u1676'
    |   '\u1681'..'\u169a'
    |   '\u16a0'..'\u16ea'
    |   '\u16ee'..'\u16f0'
    |   '\u1700'..'\u170c'
    |   '\u170e'..'\u1714'
    |   '\u1720'..'\u1734'
    |   '\u1740'..'\u1753'
    |   '\u1760'..'\u176c'
    |   '\u176e'..'\u1770'
    |   '\u1772'..'\u1773'
    |   '\u1780'..'\u17d3'
    |   '\u17d7'
    |   '\u17db'..'\u17dd'
    |   '\u17e0'..'\u17e9'
    |   '\u180b'..'\u180d'
    |   '\u1810'..'\u1819'
    |   '\u1820'..'\u1877'
    |   '\u1880'..'\u18a9'
    |   '\u1900'..'\u191c'
    |   '\u1920'..'\u192b'
    |   '\u1930'..'\u193b'
    |   '\u1946'..'\u196d'
    |   '\u1970'..'\u1974'
    |   '\u1d00'..'\u1d6b'
    |   '\u1e00'..'\u1e9b'
    |   '\u1ea0'..'\u1ef9'
    |   '\u1f00'..'\u1f15'
    |   '\u1f18'..'\u1f1d'
    |   '\u1f20'..'\u1f45'
    |   '\u1f48'..'\u1f4d'
    |   '\u1f50'..'\u1f57'
    |   '\u1f59'
    |   '\u1f5b'
    |   '\u1f5d'
    |   '\u1f5f'..'\u1f7d'
    |   '\u1f80'..'\u1fb4'
    |   '\u1fb6'..'\u1fbc'        
    |   '\u1fbe'
    |   '\u1fc2'..'\u1fc4'
    |   '\u1fc6'..'\u1fcc'
    |   '\u1fd0'..'\u1fd3'
    |   '\u1fd6'..'\u1fdb'
    |   '\u1fe0'..'\u1fec'
    |   '\u1ff2'..'\u1ff4'
    |   '\u1ff6'..'\u1ffc'
    |   '\u200c'..'\u200f'
    |   '\u202a'..'\u202e'
    |   '\u203f'..'\u2040'
    |   '\u2054'
    |   '\u2060'..'\u2063'
    |   '\u206a'..'\u206f'
    |   '\u2071'
    |   '\u207f'
    |   '\u20a0'..'\u20b1'
    |   '\u20d0'..'\u20dc'
    |   '\u20e1'
    |   '\u20e5'..'\u20ea'
    |   '\u2102'
    |   '\u2107'
    |   '\u210a'..'\u2113'
    |   '\u2115'
    |   '\u2119'..'\u211d'
    |   '\u2124'
    |   '\u2126'
    |   '\u2128'
    |   '\u212a'..'\u212d'
    |   '\u212f'..'\u2131'
    |   '\u2133'..'\u2139'
    |   '\u213d'..'\u213f'
    |   '\u2145'..'\u2149'
    |   '\u2160'..'\u2183'
    |   '\u3005'..'\u3007'
    |   '\u3021'..'\u302f'        
    |   '\u3031'..'\u3035'
    |   '\u3038'..'\u303c'
    |   '\u3041'..'\u3096'
    |   '\u3099'..'\u309a'
    |   '\u309d'..'\u309f'
    |   '\u30a1'..'\u30ff'
    |   '\u3105'..'\u312c'
    |   '\u3131'..'\u318e'
    |   '\u31a0'..'\u31b7'
    |   '\u31f0'..'\u31ff'
    |   '\u3400'..'\u4db5'
    |   '\u4e00'..'\u9fa5'
    |   '\ua000'..'\ua48c'
    |   '\uac00'..'\ud7a3'
    |   '\uf900'..'\ufa2d'
    |   '\ufa30'..'\ufa6a'
    |   '\ufb00'..'\ufb06'
    |   '\ufb13'..'\ufb17'
    |   '\ufb1d'..'\ufb28'
    |   '\ufb2a'..'\ufb36'
    |   '\ufb38'..'\ufb3c'
    |   '\ufb3e'
    |   '\ufb40'..'\ufb41'
    |   '\ufb43'..'\ufb44'
    |   '\ufb46'..'\ufbb1'
    |   '\ufbd3'..'\ufd3d'
    |   '\ufd50'..'\ufd8f'
    |   '\ufd92'..'\ufdc7'
    |   '\ufdf0'..'\ufdfc'
    |   '\ufe00'..'\ufe0f'
    |   '\ufe20'..'\ufe23'
    |   '\ufe33'..'\ufe34'
    |   '\ufe4d'..'\ufe4f'
    |   '\ufe69'
    |   '\ufe70'..'\ufe74'
    |   '\ufe76'..'\ufefc'
    |   '\ufeff'
    |   '\uff04'
    |   '\uff10'..'\uff19'
    |   '\uff21'..'\uff3a'
    |   '\uff3f'
    |   '\uff41'..'\uff5a'
    |   '\uff65'..'\uffbe'
    |   '\uffc2'..'\uffc7'
    |   '\uffca'..'\uffcf'
    |   '\uffd2'..'\uffd7'
    |   '\uffda'..'\uffdc'
    |   '\uffe0'..'\uffe1'
    |   '\uffe5'..'\uffe6'
    |   '\ufff9'..'\ufffb' 
    |   ('\ud800'..'\udbff') ('\udc00'..'\udfff')
    ;
