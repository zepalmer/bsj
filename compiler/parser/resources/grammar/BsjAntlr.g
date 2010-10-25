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

/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

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
bsjMetaprogram returns [NodeUnion<? extends MetaprogramNode> ret]
        scope Rule;
        @init {
            ruleStart("bsjMetaprogram");
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaprogramNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramNode.class);
        }
    |
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
preamble returns [NodeUnion<? extends MetaprogramPreambleNode> ret]
        scope Rule;
        @init {
            ruleStart("preamble");
            MetaprogramPackageMode packageMode = MetaprogramPackageMode.READ_ONLY;
            MetaprogramLocalMode localMode = MetaprogramLocalMode.INSERT;
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaprogramPreambleNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramPreambleNode.class);
        }
    |
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

metaprogramImport returns [NodeUnion<? extends MetaprogramImportNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramImport");
        }
        @after {
            ruleStop();
        }
    :   
        splice[MetaprogramImportNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramImportNode.class);
        }
    |
        '#import'
        metaprogramImportBody
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramImportNodeWithUnions(
                    $metaprogramImportBody.ret));
        }
    ;

metaprogramImportBody returns [NodeUnion<? extends ImportNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramImportBody");
        }
        @after {
            ruleStop();
        }
    :
        splice[ImportNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ImportNode.class);
        }
    |
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

metaprogramDependencyDeclarationList returns [NodeUnion<? extends MetaprogramDependencyDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramDependencyDeclarationList");
            List<NodeUnion<? extends MetaprogramDependencyDeclarationNode>> list =
                    new ArrayList<NodeUnion<? extends MetaprogramDependencyDeclarationNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramDependencyDeclarationListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaprogramDependencyDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaprogramDependencyDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=metaprogramDependencyDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaprogramDependencyDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaprogramDependencyDeclarationList returns [NodeUnion<? extends MetaprogramDependencyDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaprogramDependencyDeclarationList");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaprogramDependencyDeclarationList
            {
                $ret = $metaprogramDependencyDeclarationList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramDependencyDeclarationListNode());
            }
        )
    ;


metaprogramDependencyDeclaration returns [NodeUnion<? extends MetaprogramDependencyDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramDependencyDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        splice[MetaprogramDependencyDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramDependencyDeclarationNode.class);
        }
    |
        '#depends'
        metaprogramDependencyList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(
                    factory.makeMetaprogramDependencyDeclarationNodeWithUnions($metaprogramDependencyList.ret));
        }
    ;

metaprogramDependencyList returns [NodeUnion<? extends MetaprogramDependencyListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramDependencyList");
            List<NodeUnion<? extends MetaprogramDependencyNode>> list =
                    new ArrayList<NodeUnion<? extends MetaprogramDependencyNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramDependencyListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaprogramDependency
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaprogramDependency", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=metaprogramDependency
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaprogramDependency", getSourceLocation($b.stop)));
	            }
            }
        )*
        ','?
    ;

optionalMetaprogramDependencyList returns [NodeUnion<? extends MetaprogramDependencyListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaprogramDependencyList");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaprogramDependencyList
            {
                $ret = $metaprogramDependencyList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramDependencyListNode());
            }
        )
    ;


metaprogramDependency returns [NodeUnion<? extends MetaprogramDependencyNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramDependency");
            boolean weak = false;
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaprogramDependencyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramDependencyNode.class);
        }
    |
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

metaprogramTargetList returns [NodeUnion<? extends MetaprogramTargetListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTargetList");
            List<NodeUnion<? extends MetaprogramTargetNode>> list =
                    new ArrayList<NodeUnion<? extends MetaprogramTargetNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramTargetListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaprogramTarget
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaprogramTarget", getSourceLocation($a.stop)));
            }
        }
        (
            b=metaprogramTarget
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaprogramTarget", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaprogramTargetList returns [NodeUnion<? extends MetaprogramTargetListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaprogramTargetList");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaprogramTargetList
            {
                $ret = $metaprogramTargetList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramTargetListNode());
            }
        )
    ;


metaprogramTarget returns [NodeUnion<? extends MetaprogramTargetNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTarget");
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaprogramTargetNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaprogramTargetNode.class);
        }
    |   
        '#target'
        identifierList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramTargetNodeWithUnions($identifierList.ret));
        }
    ;

metaprogramTargetName returns [NodeUnion<? extends NameNode> ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTargetName");
        }
        @after {
            ruleStop();
        }
    :
        name
        {
            $ret = $name.ret;
        }
    ;

identifierList returns [NodeUnion<? extends IdentifierListNode> ret]
        scope Rule;
        @init {
            ruleStart("identifierList");
            List<NodeUnion<? extends IdentifierNode>> list =
                    new ArrayList<NodeUnion<? extends IdentifierNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeIdentifierListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=identifier
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "identifier", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=identifier
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "identifier", getSourceLocation($b.stop)));
	            }
            }
        )*
        ','?
    ;

optionalIdentifierList returns [NodeUnion<? extends IdentifierListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalIdentifierList");
        }
        @after {
            ruleStop();
        }
    :
        (
            identifierList
            {
                $ret = $identifierList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeIdentifierListNode());
            }
        )
    ;


typeDeclarationBsjMetaprogramAnchor returns [NodeUnion<? extends TypeDeclarationMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("typeDeclarationBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeDeclarationMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;    

annotationMemberBsjMetaprogramAnchor returns [NodeUnion<? extends AnnotationMemberMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationMemberBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

anonymousClassMemberBsjMetaprogramAnchor returns [NodeUnion<? extends AnonymousClassMemberMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassMemberBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

classMemberBsjMetaprogramAnchor returns [NodeUnion<? extends ClassMemberMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("classMemberBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

interfaceMemberBsjMetaprogramAnchor returns [NodeUnion<? extends InterfaceMemberMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceMemberBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceMemberMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

blockStatementBsjMetaprogramAnchor returns [NodeUnion<? extends BlockStatementMetaprogramAnchorNode> ret]
        scope Rule;
        @init {
            ruleStart("blockStatementBsjMetaprogramAnchor");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBlockStatementMetaprogramAnchorNodeWithUnions($bsjMetaprogram.ret));
        }
    ;

// Parses a list of meta-annotations.  Note that this rule is not used for declarations, since meta-annotations can be
// interspersed amongst annotations and modifiers.  This rule is used for meta-annotations which are applied to
// statements and other constructs which only permit meta-annotations and not other modifiers.
metaAnnotationList returns [NodeUnion<? extends MetaAnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationList");
            List<NodeUnion<? extends MetaAnnotationNode>> list =
                    new ArrayList<NodeUnion<? extends MetaAnnotationNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaAnnotation
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaAnnotation", getSourceLocation($a.stop)));
            }
        }
        (
            b=metaAnnotation
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaAnnotation", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaAnnotationList returns [NodeUnion<? extends MetaAnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaAnnotationList");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaAnnotationList
            {
                $ret = $metaAnnotationList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationListNode());
            }
        )
    ;


// Parses a meta-annotation.
// For example, in
//     @@Test("foo")
//     public void foo() { }
// This rule would parse
//     @@Test("foo")
metaAnnotation returns [NodeUnion<? extends MetaAnnotationNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotation");
        }
        @after {
            ruleStop();
        }
    :   
        {configuration.getMetaAnnotationsSupported()}?=>
        (
            splice[MetaAnnotationNode.class, Arrays.<Class<? extends Node>>asList()]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, MetaAnnotationNode.class);
            }
        |
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
metaAnnotationElementValuePairs returns [NodeUnion<? extends MetaAnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationElementValuePairs");
            List<NodeUnion<? extends MetaAnnotationElementNode>> list =
                    new ArrayList<NodeUnion<? extends MetaAnnotationElementNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationElementListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaAnnotationElementValuePair
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaAnnotationElementValuePair", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=metaAnnotationElementValuePair
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaAnnotationElementValuePair", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaAnnotationElementValuePairs returns [NodeUnion<? extends MetaAnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaAnnotationElementValuePairs");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaAnnotationElementValuePairs
            {
                $ret = $metaAnnotationElementValuePairs.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationElementListNode());
            }
        )
    ;


// Parses a single meta-annotation element-value pair.
// For example, in
//     @@Foo(bar="baz",happy=5)
// this rule would parse either
//     bar="baz"
// or
//     happy=5
metaAnnotationElementValuePair returns [NodeUnion<? extends MetaAnnotationElementNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationElementValuePair");
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaAnnotationElementNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaAnnotationElementNode.class);
        }
    |
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
metaAnnotationElementValue returns [NodeUnion<? extends MetaAnnotationValueNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationElementValue");
        }
        @after {
            ruleStop();
        }
    :
        splice[MetaAnnotationValueNode.class, Arrays.<Class<? extends Node>>asList(MetaAnnotationArrayValueNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaAnnotationValueNode.class);
        }
    |   
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
metaAnnotationElementValues returns [NodeUnion<? extends MetaAnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationElementValues");
            List<NodeUnion<? extends MetaAnnotationValueNode>> list =
                    new ArrayList<NodeUnion<? extends MetaAnnotationValueNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationValueListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaAnnotationElementValue
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaAnnotationElementValue", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=metaAnnotationElementValue
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaAnnotationElementValue", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaAnnotationElementValues returns [NodeUnion<? extends MetaAnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaAnnotationElementValues");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaAnnotationElementValues
            {
                $ret = $metaAnnotationElementValues.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaAnnotationValueListNode());
            }
        )
    ;


// Parses a meta-annotation element array.
// For example, in
//     @@Ann({@@Foo,@@Bar(5)})
// this rule would parse
//     {@@Foo,@@Bar(5)}
// and in
//     @@Test({1,2,3})
// this rule would parse
//     {1,2,3}
metaAnnotationElementValueArrayInitializer returns [NodeUnion<? extends MetaAnnotationArrayValueNode> ret]
        scope Rule;
        @init {
            ruleStart("metaAnnotationElementValueArrayInitializer");
        }
        @after {
            ruleStop();
        }
    :   
        splice[MetaAnnotationArrayValueNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MetaAnnotationArrayValueNode.class);
        }
    |
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
codeLiteral returns [NodeUnion<? extends RawCodeLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("codeLiteral");
        }
        @after {
            ruleStop();
        }
    :
        {configuration.getCodeLiteralsSupported()}?=>
        (
            splice[RawCodeLiteralNode.class, Arrays.<Class<? extends Node>>asList()]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, RawCodeLiteralNode.class);
            }
        |
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
anyNonCodeLiteralToken returns [BsjTokenImpl ret]
        scope Rule;
        @init {
            ruleStart("anyNonCodeLiteralToken");
        }
        @after {
            ruleStop();
        }
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
splice[Class<? extends Node> expectedType, List<Class<? extends Node>> forbiddenTypes] returns [NodeUnion<? extends Node> ret]
        options {
            memoize=false;
        }        scope Rule;
        @init {
            ruleStart("splice");
            BsjTypechecker bsjTypechecker = 
                    null;
        }
        @after {
            ruleStop();
        }
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

compilationUnit[String name] returns [NodeUnion<? extends CompilationUnitNode> ret]
        scope Rule;
        @init {
            ruleStart("compilationUnit");
        }
        @after {
            ruleStop();
        }
    :
        splice[CompilationUnitNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, CompilationUnitNode.class);
        }
    |
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

packageDeclaration returns [NodeUnion<? extends PackageDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("packageDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[PackageDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, PackageDeclarationNode.class);
        }
    |
        modifiers[false]
        'package' name ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makePackageDeclarationNodeWithUnions(
                    $name.ret,
                    factory.makeNormalNodeUnion($modifiers.metaAnnotations),
                    factory.makeNormalNodeUnion($modifiers.annotations)));
        }
    ;

metaImportDeclarations returns [NodeUnion<? extends MetaprogramImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("metaImportDeclarations");
            List<NodeUnion<? extends MetaprogramImportNode>> list =
                    new ArrayList<NodeUnion<? extends MetaprogramImportNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramImportListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=metaprogramImport
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "metaprogramImport", getSourceLocation($a.stop)));
            }
        }
        (
            b=metaprogramImport
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "metaprogramImport", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalMetaImportDeclarations returns [NodeUnion<? extends MetaprogramImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalMetaImportDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            metaImportDeclarations
            {
                $ret = $metaImportDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeMetaprogramImportListNode());
            }
        )
    ;


importDeclarations returns [NodeUnion<? extends ImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("importDeclarations");
            List<NodeUnion<? extends ImportNode>> list =
                    new ArrayList<NodeUnion<? extends ImportNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeImportListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=importDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "importDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=importDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "importDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalImportDeclarations returns [NodeUnion<? extends ImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalImportDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            importDeclarations
            {
                $ret = $importDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeImportListNode());
            }
        )
    ;


importBody returns [NodeUnion<? extends ImportNode> ret]
        scope Rule;
        @init {
            ruleStart("importBody");
        }
        @after {
            ruleStop();
        }
    :
        (
            importStaticOnDemandBody
            {
                $ret = $importStaticOnDemandBody.ret;
            }
        |
            importStaticSingleBody
            {
                $ret = $importStaticSingleBody.ret;
            }
        |
            importOnDemandBody
            {
                $ret = $importOnDemandBody.ret;
            }
        |
            importSingleBody
            {
                $ret = $importSingleBody.ret;
            }
        )

    ;

importStaticOnDemandBody returns [NodeUnion<? extends StaticImportOnDemandNode> ret]
        scope Rule;
        @init {
            ruleStart("importStaticOnDemandBody");
        }
        @after {
            ruleStop();
        }
    :
        'static' name '.' '*'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeStaticImportOnDemandNodeWithUnions($name.ret));
        }
    ;

importStaticSingleBody returns [NodeUnion<? extends SingleStaticImportNode> ret]
        scope Rule;
        @init {
            ruleStart("importStaticSingleBody");
        }
        @after {
            ruleStop();
        }
    :
        'static' separatedQualifiedName
        {
            $ret = factory.makeNormalNodeUnion(factory.makeSingleStaticImportNodeWithUnions(
                    $separatedQualifiedName.name, $separatedQualifiedName.ident));
        }
    ;

importOnDemandBody returns [NodeUnion<? extends ImportOnDemandNode> ret]
        scope Rule;
        @init {
            ruleStart("importOnDemandBody");
        }
        @after {
            ruleStop();
        }
    :
        name '.' '*'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeImportOnDemandNodeWithUnions($name.ret));
        }
    ;

importSingleBody returns [NodeUnion<? extends ImportSingleTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("importSingleBody");
        }
        @after {
            ruleStop();
        }
    :
        name
        {
            $ret = factory.makeNormalNodeUnion(factory.makeImportSingleTypeNodeWithUnions($name.ret));
        }
    ;

importDeclaration returns [NodeUnion<? extends ImportNode> ret]
        scope Rule;
        @init {
            ruleStart("importDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[ImportNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ImportNode.class);
        }
    |
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

typeDeclarations returns [NodeUnion<? extends TypeDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("typeDeclarations");
            List<NodeUnion<? extends TypeDeclarationNode>> list =
                    new ArrayList<NodeUnion<? extends TypeDeclarationNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeDeclarationListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=typeDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "typeDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=typeDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "typeDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalTypeDeclarations returns [NodeUnion<? extends TypeDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalTypeDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            typeDeclarations
            {
                $ret = $typeDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeTypeDeclarationListNode());
            }
        )
    ;


typeDeclaration returns [NodeUnion<? extends TypeDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("typeDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[TypeDeclarationNode.class, Arrays.<Class<? extends Node>>asList(ClassDeclarationNode.class, EnumDeclarationNode.class, InterfaceDeclarationNode.class, AnnotationDeclarationNode.class, NoOperationNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, TypeDeclarationNode.class);
        }
    |
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

noOp returns [NodeUnion<? extends NoOperationNode> ret]
        scope Rule;
        @init {
            ruleStart("noOp");
        }
        @after {
            ruleStop();
        }
    :
        splice[NoOperationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, NoOperationNode.class);
        }
    |
        optionalMetaAnnotationList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeNoOperationNodeWithUnions($optionalMetaAnnotationList.ret));
        }
    ;

classOrInterfaceDeclaration returns [NodeUnion<? extends TypeDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("classOrInterfaceDeclaration");
        }
        @after {
            ruleStop();
        }
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

annotationMethodModifiers returns [NodeUnion<? extends AnnotationMethodModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationMethodModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[false, Modifier.PUBLIC, Modifier.ABSTRACT]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMethodModifiersNode(
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

annotationModifiers returns [NodeUnion<? extends AnnotationModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.STATIC, Modifier.STRICTFP, Modifier.ABSTRACT]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;
     
classModifiers returns [NodeUnion<? extends ClassModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("classModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.ABSTRACT, Modifier.STATIC, Modifier.FINAL, Modifier.STRICTFP]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.ABSTRACT),
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

constantModifiers returns [NodeUnion<? extends ConstantModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("constantModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[false, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeConstantModifiersNode(
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

constructorModifiers returns [NodeUnion<? extends ConstructorModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("constructorModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeConstructorModifiersNode(
                    $modifiers.access,
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

enumConstantModifiers returns [NodeUnion<? extends EnumConstantModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("enumConstantModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[false]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeEnumConstantModifiersNode(
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

enumModifiers returns [NodeUnion<? extends EnumModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("enumModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.STRICTFP, Modifier.STATIC]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeEnumModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

fieldModifiers returns [NodeUnion<? extends FieldModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("fieldModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.STATIC, Modifier.FINAL, Modifier.TRANSIENT, Modifier.VOLATILE]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeFieldModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.TRANSIENT),
                    $modifiers.modifiers.has(Modifier.VOLATILE),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

localClassModifiers returns [NodeUnion<? extends LocalClassModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("localClassModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[false, Modifier.ABSTRACT, Modifier.FINAL, Modifier.STRICTFP]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeLocalClassModifiersNode(
                    $modifiers.modifiers.has(Modifier.ABSTRACT),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

interfaceModifiers returns [NodeUnion<? extends InterfaceModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.STATIC, Modifier.STRICTFP, Modifier.ABSTRACT]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

methodModifiers returns [NodeUnion<? extends MethodModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("methodModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.ABSTRACT, Modifier.STATIC, Modifier.FINAL, Modifier.SYNCHRONIZED, Modifier.NATIVE, Modifier.STRICTFP]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeMethodModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.ABSTRACT),
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.SYNCHRONIZED),
                    $modifiers.modifiers.has(Modifier.NATIVE),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;

variableModifiers returns [NodeUnion<? extends VariableModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("variableModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[false, Modifier.FINAL]
        {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableModifiersNode(
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.metaAnnotations,
                    $modifiers.annotations));
        }
    ;


classDeclaration returns [NodeUnion<? extends TypeDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("classDeclaration");
        }
        @after {
            ruleStop();
        }
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

normalClassDeclaration returns [NodeUnion<? extends ClassDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("normalClassDeclaration");
            NodeUnion<? extends DeclaredTypeListNode> declaredTypeListNode = 
                    factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
        }
        @after {
            ruleStop();
        }
    :   
        splice[ClassDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ClassDeclarationNode.class);
        }
    |
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

localClassDeclaration returns [NodeUnion<? extends LocalClassDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("localClassDeclaration");
            NodeUnion<? extends DeclaredTypeListNode> declaredTypeListNode = 
                    factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
        }
        @after {
            ruleStop();
        }
    :   
        splice[LocalClassDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, LocalClassDeclarationNode.class);
        }
    |
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

typeParameters returns [NodeUnion<? extends TypeParameterListNode> ret]
        scope Rule;
        @init {
            ruleStart("typeParameters");
            List<NodeUnion<? extends TypeParameterNode>> list =
                    new ArrayList<NodeUnion<? extends TypeParameterNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeParameterListNodeWithUnions(list));
            ruleStop();
        }
    :
        '<'
        a=typeParameter
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "typeParameter", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=typeParameter
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "typeParameter", getSourceLocation($b.stop)));
	            }
            }
        )*
        '>'
    ;

optionalTypeParameters returns [NodeUnion<? extends TypeParameterListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalTypeParameters");
        }
        @after {
            ruleStop();
        }
    :
        (
            typeParameters
            {
                $ret = $typeParameters.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeTypeParameterListNode());
            }
        )
    ;


typeParameter returns [NodeUnion<? extends TypeParameterNode> ret]
        scope Rule;
        @init {
            ruleStart("typeParameter");
            NodeUnion<? extends DeclaredTypeListNode> typeBoundNode = 
                    factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
        }
        @after {
            ruleStop();
        }
    :
        splice[TypeParameterNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, TypeParameterNode.class);
        }
    |
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

typeBound returns [NodeUnion<? extends DeclaredTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("typeBound");
            List<NodeUnion<? extends DeclaredTypeNode>> list =
                    new ArrayList<NodeUnion<? extends DeclaredTypeNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=classOrInterfaceType
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "classOrInterfaceType", getSourceLocation($a.stop)));
            }
        }
        (
            '&'
            b=classOrInterfaceType
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "classOrInterfaceType", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalTypeBound returns [NodeUnion<? extends DeclaredTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalTypeBound");
        }
        @after {
            ruleStop();
        }
    :
        (
            typeBound
            {
                $ret = $typeBound.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
            }
        )
    ;


enumDeclaration returns [NodeUnion<? extends EnumDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("enumDeclaration");
            NodeUnion<? extends DeclaredTypeListNode> declaredTypeListNode = 
                    factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
        }
        @after {
            ruleStop();
        }
    :   
        splice[EnumDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, EnumDeclarationNode.class);
        }
    |
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

enumBody returns [NodeUnion<? extends EnumBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("enumBody");
            NodeUnion<? extends ClassMemberListNode> enumBodyDeclarationsNode = 
                    factory.makeNormalNodeUnion(factory.makeClassMemberListNode());
        }
        @after {
            ruleStop();
        }
    :   
        splice[EnumBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, EnumBodyNode.class);
        }
    |
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

enumConstants returns [NodeUnion<? extends EnumConstantDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("enumConstants");
            List<NodeUnion<? extends EnumConstantDeclarationNode>> list =
                    new ArrayList<NodeUnion<? extends EnumConstantDeclarationNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeEnumConstantDeclarationListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=enumConstant
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "enumConstant", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=enumConstant
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "enumConstant", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalEnumConstants returns [NodeUnion<? extends EnumConstantDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalEnumConstants");
        }
        @after {
            ruleStop();
        }
    :
        (
            enumConstants
            {
                $ret = $enumConstants.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeEnumConstantDeclarationListNode());
            }
        )
    ;


enumConstant returns [NodeUnion<? extends EnumConstantDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("enumConstant");
            NodeUnion<? extends AnnotationListNode> annotationsNode = 
                    factory.makeNormalNodeUnion(factory.makeAnnotationListNode());
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotationsNode = 
                    factory.makeNormalNodeUnion(factory.makeMetaAnnotationListNode());
            NodeUnion<? extends ExpressionListNode> argumentsNode = 
                    factory.makeNormalNodeUnion(factory.makeExpressionListNode());
            NodeUnion<? extends AnonymousClassBodyNode> anonymousClassBodyNode = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
    :   
        splice[EnumConstantDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, EnumConstantDeclarationNode.class);
        }
    |
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

enumBodyDeclarations returns [NodeUnion<? extends ClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("enumBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        ';'
        optionalClassBodyDeclarations
        {
            $ret = $optionalClassBodyDeclarations.ret;
        }
    ;

interfaceDeclaration returns [NodeUnion<? extends TypeDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceDeclaration");
        }
        @after {
            ruleStop();
        }
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
    
normalInterfaceDeclaration returns [NodeUnion<? extends InterfaceDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("normalInterfaceDeclaration");
            NodeUnion<? extends DeclaredTypeListNode> declaredTypeListNode = 
                    factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
        }
        @after {
            ruleStop();
        }
    :   
        splice[InterfaceDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, InterfaceDeclarationNode.class);
        }
    |
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

declaredTypeList returns [NodeUnion<? extends DeclaredTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("declaredTypeList");
            List<NodeUnion<? extends DeclaredTypeNode>> list =
                    new ArrayList<NodeUnion<? extends DeclaredTypeNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=classOrInterfaceType
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "classOrInterfaceType", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=classOrInterfaceType
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "classOrInterfaceType", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalDeclaredTypeList returns [NodeUnion<? extends DeclaredTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalDeclaredTypeList");
        }
        @after {
            ruleStop();
        }
    :
        (
            declaredTypeList
            {
                $ret = $declaredTypeList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeDeclaredTypeListNode());
            }
        )
    ;


referenceTypeList returns [NodeUnion<? extends ReferenceTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("referenceTypeList");
            List<NodeUnion<? extends ReferenceTypeNode>> list =
                    new ArrayList<NodeUnion<? extends ReferenceTypeNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeReferenceTypeListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=referenceType
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "referenceType", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=referenceType
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "referenceType", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalReferenceTypeList returns [NodeUnion<? extends ReferenceTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalReferenceTypeList");
        }
        @after {
            ruleStop();
        }
    :
        (
            referenceTypeList
            {
                $ret = $referenceTypeList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeReferenceTypeListNode());
            }
        )
    ;


classBody returns [NodeUnion<? extends ClassBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("classBody");
        }
        @after {
            ruleStop();
        }
    :
        splice[ClassBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ClassBodyNode.class);
        }
    |
        '{'
        optionalClassBodyDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeClassBodyNodeWithUnions($optionalClassBodyDeclarations.ret));
        }
    ;

anonymousClassBody returns [NodeUnion<? extends AnonymousClassBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassBody");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnonymousClassBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnonymousClassBodyNode.class);
        }
    |
        '{' 
        optionalAnonymousClassBodyDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassBodyNodeWithUnions($optionalAnonymousClassBodyDeclarations.ret));
        }
    ;

interfaceBody returns [NodeUnion<? extends InterfaceBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceBody");
        }
        @after {
            ruleStop();
        }
    :
        splice[InterfaceBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, InterfaceBodyNode.class);
        }
    |   
        '{'
        optionalInterfaceBodyDeclarations 
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceBodyNodeWithUnions($optionalInterfaceBodyDeclarations.ret));
        }
    ;

initializerBlock returns [NodeUnion<? extends InitializerDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("initializerBlock");
        }
        @after {
            ruleStop();
        }
    :
        splice[InitializerDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, InitializerDeclarationNode.class);
        }
    |
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

classBodyDeclarations returns [NodeUnion<? extends ClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("classBodyDeclarations");
            List<NodeUnion<? extends ClassMemberNode>> list =
                    new ArrayList<NodeUnion<? extends ClassMemberNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeClassMemberListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=classBodyDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "classBodyDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=classBodyDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "classBodyDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalClassBodyDeclarations returns [NodeUnion<? extends ClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalClassBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            classBodyDeclarations
            {
                $ret = $classBodyDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeClassMemberListNode());
            }
        )
    ;

    
classBodyDeclaration returns [NodeUnion<? extends ClassMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("classBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[ClassMemberNode.class, Arrays.<Class<? extends Node>>asList(InitializerDeclarationNode.class, ConstructorDeclarationNode.class, FieldDeclarationNode.class, MethodDeclarationNode.class, ClassDeclarationNode.class, EnumDeclarationNode.class, InterfaceDeclarationNode.class, AnnotationDeclarationNode.class, NoOperationNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ClassMemberNode.class);
        }
    |
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

anonymousClassBodyDeclarations returns [NodeUnion<? extends AnonymousClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassBodyDeclarations");
            List<NodeUnion<? extends AnonymousClassMemberNode>> list =
                    new ArrayList<NodeUnion<? extends AnonymousClassMemberNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassMemberListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=anonymousClassBodyDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "anonymousClassBodyDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=anonymousClassBodyDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "anonymousClassBodyDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalAnonymousClassBodyDeclarations returns [NodeUnion<? extends AnonymousClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalAnonymousClassBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            anonymousClassBodyDeclarations
            {
                $ret = $anonymousClassBodyDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAnonymousClassMemberListNode());
            }
        )
    ;

    
anonymousClassBodyDeclaration returns [NodeUnion<? extends AnonymousClassMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[AnonymousClassMemberNode.class, Arrays.<Class<? extends Node>>asList(InitializerDeclarationNode.class, FieldDeclarationNode.class, MethodDeclarationNode.class, ClassDeclarationNode.class, EnumDeclarationNode.class, InterfaceDeclarationNode.class, AnnotationDeclarationNode.class, NoOperationNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnonymousClassMemberNode.class);
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

memberDecl returns [NodeUnion<? extends AnonymousClassMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("memberDecl");
        }
        @after {
            ruleStop();
        }
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

methodReturnType returns [NodeUnion<? extends TypeNode> ret]
        scope Rule;
        @init {
            ruleStart("methodReturnType");
        }
        @after {
            ruleStop();
        }
    :
        splice[VoidTypeNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, VoidTypeNode.class);
        }
    |
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

constructorDeclaration returns [NodeUnion<? extends ConstructorDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("constructorDeclaration");
            NodeUnion<? extends UnparameterizedTypeListNode> throwsNode = 
                    factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeListNode());
        }
        @after {
            ruleStop();
        }
    :
        splice[ConstructorDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ConstructorDeclarationNode.class);
        }
    |
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

constructorBody returns [NodeUnion<? extends ConstructorBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("constructorBody");
        }
        @after {
            ruleStop();
        }
    :
        splice[ConstructorBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ConstructorBodyNode.class);
        }
    |
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

methodDeclaration returns [NodeUnion<? extends MethodDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("methodDeclaration");
            NodeUnion<? extends BlockStatementListNode> body = 
                    factory.makeNormalNodeUnion(factory.makeBlockStatementListNode());
            NodeUnion<? extends UnparameterizedTypeListNode> throwsNode = 
                    factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeListNode());
            NodeUnion<? extends TypeNode> returnTypeNode = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
    :
        splice[MethodDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MethodDeclarationNode.class);
        }
    |
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

fieldDeclaration returns [NodeUnion<? extends FieldDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("fieldDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        splice[FieldDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, FieldDeclarationNode.class);
        }
    |
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
    
interfaceBodyDeclarations returns [NodeUnion<? extends InterfaceMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceBodyDeclarations");
            List<NodeUnion<? extends InterfaceMemberNode>> list =
                    new ArrayList<NodeUnion<? extends InterfaceMemberNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeInterfaceMemberListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=interfaceBodyDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "interfaceBodyDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=interfaceBodyDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "interfaceBodyDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalInterfaceBodyDeclarations returns [NodeUnion<? extends InterfaceMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalInterfaceBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            interfaceBodyDeclarations
            {
                $ret = $interfaceBodyDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeInterfaceMemberListNode());
            }
        )
    ;

    
interfaceBodyDeclaration returns [NodeUnion<? extends InterfaceMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        splice[InterfaceMemberNode.class, Arrays.<Class<? extends Node>>asList(ConstantDeclarationNode.class, MethodDeclarationNode.class, ClassDeclarationNode.class, EnumDeclarationNode.class, InterfaceDeclarationNode.class, AnnotationDeclarationNode.class, NoOperationNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, InterfaceMemberNode.class);
        }
    |
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

interfaceMethodDeclaration returns [NodeUnion<? extends MethodDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("interfaceMethodDeclaration");
            NodeUnion<? extends TypeNode> returnTypeNode = 
                    factory.makeNormalNodeUnion(null);
            NodeUnion<? extends UnparameterizedTypeListNode> throwsNode = 
                    factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeListNode());
        }
        @after {
            ruleStop();
        }
    :   
        // TODO: replace with an interface-specific node type
        splice[MethodDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, MethodDeclarationNode.class);
        }
    |
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

constantDeclaration returns [NodeUnion<? extends ConstantDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("constantDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        splice[ConstantDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ConstantDeclarationNode.class);
        }
    |
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
variableDeclarators returns [NodeUnion<? extends VariableDeclaratorListNode> ret]
        scope Rule;
        @init {
            ruleStart("variableDeclarators");
            List<NodeUnion<? extends VariableDeclaratorNode>> list =
                    new ArrayList<NodeUnion<? extends VariableDeclaratorNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableDeclaratorListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=variableDeclarator
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "variableDeclarator", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=variableDeclarator
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "variableDeclarator", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalVariableDeclarators returns [NodeUnion<? extends VariableDeclaratorListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalVariableDeclarators");
        }
        @after {
            ruleStop();
        }
    :
        (
            variableDeclarators
            {
                $ret = $variableDeclarators.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeVariableDeclaratorListNode());
            }
        )
    ;

 
// Represents the combination of an identifier and an initializer.  This construct is necessary on its own to support
// the multiple declaration sugar ("int x,y;").
variableDeclarator returns [NodeUnion<? extends VariableDeclaratorNode> ret]
        scope Rule;
        @init {
            ruleStart("variableDeclarator");
            int arrayLevels = 0;
            NodeUnion<? extends VariableInitializerNode> initializer = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
    :
        splice[VariableDeclaratorNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, VariableDeclaratorNode.class);
        }
    |
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

unparameterizedType returns [NodeUnion<? extends UnparameterizedTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("unparameterizedType");
        }
        @after {
            ruleStop();
        }
    :
        splice[UnparameterizedTypeNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, UnparameterizedTypeNode.class);
        }
    |   
        name
        {
            $ret = factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeNodeWithUnions($name.ret));
        }
    ;

unparameterizedTypeList returns [NodeUnion<? extends UnparameterizedTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("unparameterizedTypeList");
            List<NodeUnion<? extends UnparameterizedTypeNode>> list =
                    new ArrayList<NodeUnion<? extends UnparameterizedTypeNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=unparameterizedType
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "unparameterizedType", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=unparameterizedType
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "unparameterizedType", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalUnparameterizedTypeList returns [NodeUnion<? extends UnparameterizedTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalUnparameterizedTypeList");
        }
        @after {
            ruleStop();
        }
    :
        (
            unparameterizedTypeList
            {
                $ret = $unparameterizedTypeList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeUnparameterizedTypeListNode());
            }
        )
    ;


throwsClause returns [NodeUnion<? extends UnparameterizedTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("throwsClause");
        }
        @after {
            ruleStop();
        }
    :
        THROWS
        unparameterizedTypeList
        {
            $ret = $unparameterizedTypeList.ret;
        }
    ;

referenceType returns [NodeUnion<? extends ReferenceTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("referenceType");
        }
        @after {
            ruleStop();
        }
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
            $ret = wrapArrayLevels($primitiveType.ret, $arrayTypeCounter.ret);
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
type returns [NodeUnion<? extends TypeNode> ret]
        scope Rule;
        @init {
            ruleStart("type");
        }
        @after {
            ruleStop();
        }
    :
        (
            splice[TypeNode.class, Arrays.<Class<? extends Node>>asList(PrimitiveTypeNode.class, DeclaredTypeNode.class, VoidTypeNode.class)]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, TypeNode.class);
            }
        |   
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
classOrInterfaceType returns [NodeUnion<? extends DeclaredTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("classOrInterfaceType");
            NodeUnion<? extends UnparameterizedTypeNode> unparameterizedTypeNode = 
                    factory.makeNormalNodeUnion(null);
            NodeUnion<? extends ParameterizedTypeNode> parameterizedTypeNode = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
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
        splice[ParameterizedTypeNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ParameterizedTypeNode.class);
            parameterizedTypeNode = $ret.castNodeType(factory, ParameterizedTypeNode.class);
        }
        (
            '.' next=classOrInterfaceType
            {
                $ret = factory.makeNormalNodeUnion(
                        factory.makeParameterizedTypeSelectNodeWithUnions(parameterizedTypeNode, $next.ret));
            }
        )?
    |
        splice[DeclaredTypeNode.class, Arrays.<Class<? extends Node>>asList(UnparameterizedTypeNode.class, ParameterizedTypeNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, DeclaredTypeNode.class);
        }
    ;

// Parses a primitive type.
// For example, in
//     boolean b = true;
// this rule matches
//     boolean
primitiveType returns [NodeUnion<? extends PrimitiveTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("primitiveType");
            PrimitiveType temp = null;
        }
        @after {
            ruleStop();
            $ret = factory.makeNormalNodeUnion(factory.makePrimitiveTypeNode(temp));
        }
    :   
        splice[PrimitiveTypeNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, PrimitiveTypeNode.class);
        }
    |   
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
typeArguments returns [NodeUnion<? extends TypeArgumentListNode> ret]
        scope Rule;
        @init {
            ruleStart("typeArguments");
            List<NodeUnion<? extends TypeArgumentNode>> list =
                    new ArrayList<NodeUnion<? extends TypeArgumentNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeArgumentListNodeWithUnions(list));
            ruleStop();
        }
    :
        '<'
        a=typeArgument
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "typeArgument", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=typeArgument
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "typeArgument", getSourceLocation($b.stop)));
	            }
            }
        )*
        '>'
    ;

optionalTypeArguments returns [NodeUnion<? extends TypeArgumentListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalTypeArguments");
        }
        @after {
            ruleStop();
        }
    :
        (
            typeArguments
            {
                $ret = $typeArguments.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeTypeArgumentListNode());
            }
        )
    ;


// Parses a single type argument for a declared type.
// For example, in
//     Map.Entry<K,V> entry;
// this rule would parse either K or V.  Also, in
//     Foo<? extends Bar>
// this rule would parse
//     ? extends Bar
typeArgument returns [NodeUnion<? extends TypeArgumentNode> ret]
        scope Rule;
        @init {
            ruleStart("typeArgument");
        }
        @after {
            ruleStop();
        }
    :
        splice[TypeArgumentNode.class, Arrays.<Class<? extends Node>>asList(ReferenceTypeNode.class, WildcardTypeNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, TypeArgumentNode.class);
        }
    |
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

wildcard returns [NodeUnion<? extends WildcardTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("wildcard");
            boolean upper = false;
        }
        @after {
            ruleStop();
        }
    :
        splice[WildcardTypeNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, WildcardTypeNode.class);
        }
    |
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

normalParameterDecls returns [NodeUnion<? extends VariableListNode> ret]
        scope Rule;
        @init {
            ruleStart("normalParameterDecls");
            List<NodeUnion<? extends VariableNode>> list =
                    new ArrayList<NodeUnion<? extends VariableNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=normalParameterDecl
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "normalParameterDecl", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=normalParameterDecl
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "normalParameterDecl", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalNormalParameterDecls returns [NodeUnion<? extends VariableListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalNormalParameterDecls");
        }
        @after {
            ruleStop();
        }
    :
        (
            normalParameterDecls
            {
                $ret = $normalParameterDecls.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeVariableListNode());
            }
        )
    ;


normalParameterDecl returns [NodeUnion<? extends VariableNode> ret]
        scope Rule;
        @init {
            ruleStart("normalParameterDecl");
            NodeUnion<? extends TypeNode> typeNode = null;
        }
        @after {
            ruleStop();
        }
    :
        splice[VariableNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, VariableNode.class);
        }
    |
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

ellipsisParameterDecl returns [NodeUnion<? extends VariableNode> ret]
        scope Rule;
        @init {
            ruleStart("ellipsisParameterDecl");
            NodeUnion<? extends TypeNode> typeNode = null;
        }
        @after {
            ruleStop();
        }
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

alternateConstructorInvocation returns [NodeUnion<? extends AlternateConstructorInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("alternateConstructorInvocation");
        }
        @after {
            ruleStop();
        }
    :
        optionalNonWildcardTypeArguments 'this' arguments ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAlternateConstructorInvocationNodeWithUnions(
                        $arguments.ret,
                        $optionalNonWildcardTypeArguments.ret));
        }
    ;

superclassConstructorInvocation returns [NodeUnion<? extends SuperclassConstructorInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("superclassConstructorInvocation");
        }
        @after {
            ruleStop();
        }
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

explicitConstructorInvocation returns [NodeUnion<? extends ConstructorInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("explicitConstructorInvocation");
        }
        @after {
            ruleStop();
        }
    :
        splice[ConstructorInvocationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ConstructorInvocationNode.class);
        }
    |
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

annotations returns [NodeUnion<? extends AnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("annotations");
            List<NodeUnion<? extends AnnotationNode>> list =
                    new ArrayList<NodeUnion<? extends AnnotationNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=annotation
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "annotation", getSourceLocation($a.stop)));
            }
        }
        (
            b=annotation
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "annotation", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalAnnotations returns [NodeUnion<? extends AnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalAnnotations");
        }
        @after {
            ruleStop();
        }
    :
        (
            annotations
            {
                $ret = $annotations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAnnotationListNode());
            }
        )
    ;


// Parses an annotation.
// For example, in
//     @Test("foo")
//     public void foo() { }
// This rule would parse
//     @Test("foo")
annotation returns [NodeUnion<? extends AnnotationNode> ret]
        scope Rule;
        @init {
            ruleStart("annotation");
        }
        @after {
            ruleStop();
        }
    :
        splice[AnnotationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationNode.class);
        }
    |
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
elementValuePairs returns [NodeUnion<? extends AnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("elementValuePairs");
            List<NodeUnion<? extends AnnotationElementNode>> list =
                    new ArrayList<NodeUnion<? extends AnnotationElementNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationElementListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=elementValuePair
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "elementValuePair", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=elementValuePair
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "elementValuePair", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalElementValuePairs returns [NodeUnion<? extends AnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalElementValuePairs");
        }
        @after {
            ruleStop();
        }
    :
        (
            elementValuePairs
            {
                $ret = $elementValuePairs.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAnnotationElementListNode());
            }
        )
    ;


// Parses a single annotation element-value pair.
// For example, in
//     @Foo(bar="baz",happy=5)
// this rule would parse either
//     bar="baz"
// or
//     happy=5
elementValuePair returns [NodeUnion<? extends AnnotationElementNode> ret]
        scope Rule;
        @init {
            ruleStart("elementValuePair");
        }
        @after {
            ruleStop();
        }
    :
        splice[AnnotationElementNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationElementNode.class);
        }
    |
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
elementValue returns [NodeUnion<? extends AnnotationValueNode> ret]
        scope Rule;
        @init {
            ruleStart("elementValue");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnnotationValueNode.class, Arrays.<Class<? extends Node>>asList(AnnotationArrayValueNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationValueNode.class);
        }
    |
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
elementValues returns [NodeUnion<? extends AnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("elementValues");
            List<NodeUnion<? extends AnnotationValueNode>> list =
                    new ArrayList<NodeUnion<? extends AnnotationValueNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationValueListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=elementValue
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "elementValue", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=elementValue
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "elementValue", getSourceLocation($b.stop)));
	            }
            }
        )*
        ','?
    ;

optionalElementValues returns [NodeUnion<? extends AnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalElementValues");
        }
        @after {
            ruleStop();
        }
    :
        (
            elementValues
            {
                $ret = $elementValues.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAnnotationValueListNode());
            }
        )
    ;

    
// Parses an annotation element array.
// For example, in
//     @Ann({@Foo,@Bar(5)})
// this rule would parse
//     {@Foo,@Bar(5)}
// and in
//     @Test({1,2,3})
// this rule would parse
//     {1,2,3}
elementValueArrayInitializer returns [NodeUnion<? extends AnnotationArrayValueNode> ret]
        scope Rule;
        @init {
            ruleStart("elementValueArrayInitializer");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnnotationArrayValueNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationArrayValueNode.class);
        }
    |
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
annotationTypeDeclaration returns [NodeUnion<? extends AnnotationDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnnotationDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationDeclarationNode.class);
        }
    |
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

annotationTypeBody returns [NodeUnion<? extends AnnotationBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeBody");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnnotationBodyNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationBodyNode.class);
        }
    |
        '{'
        optionalAnnotationTypeElementDeclarations
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationBodyNodeWithUnions(
                        $optionalAnnotationTypeElementDeclarations.ret));
        }
    ;
    
annotationTypeElementDeclarations returns [NodeUnion<? extends AnnotationMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeElementDeclarations");
            List<NodeUnion<? extends AnnotationMemberNode>> list =
                    new ArrayList<NodeUnion<? extends AnnotationMemberNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMemberListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=annotationTypeElementDeclaration
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "annotationTypeElementDeclaration", getSourceLocation($a.stop)));
            }
        }
        (
            b=annotationTypeElementDeclaration
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "annotationTypeElementDeclaration", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalAnnotationTypeElementDeclarations returns [NodeUnion<? extends AnnotationMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalAnnotationTypeElementDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        (
            annotationTypeElementDeclarations
            {
                $ret = $annotationTypeElementDeclarations.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeAnnotationMemberListNode());
            }
        )
    ;


annotationTypeElementDeclaration returns [NodeUnion<? extends AnnotationMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeElementDeclaration");
        }
        @after {
            ruleStop();
        }
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

annotationMethodDeclaration returns [NodeUnion<? extends AnnotationMethodDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("annotationMethodDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        splice[AnnotationMethodDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, AnnotationMethodDeclarationNode.class);
        }
    |
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

block returns [NodeUnion<? extends BlockStatementListNode> ret]
        scope Rule;
        @init {
            ruleStart("block");
        }
        @after {
            ruleStop();
        }
    :   
        '{'
        optionalBlockStatementList
        '}'
        {
            $ret = $optionalBlockStatementList.ret;
        }
    ;

blockStatementList returns [NodeUnion<? extends BlockStatementListNode> ret]
        scope Rule;
        @init {
            ruleStart("blockStatementList");
            List<NodeUnion<? extends BlockStatementNode>> list =
                    new ArrayList<NodeUnion<? extends BlockStatementNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeBlockStatementListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=blockStatement
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "blockStatement", getSourceLocation($a.stop)));
            }
        }
        (
            b=blockStatement
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "blockStatement", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalBlockStatementList returns [NodeUnion<? extends BlockStatementListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalBlockStatementList");
        }
        @after {
            ruleStop();
        }
    :
        (
            blockStatementList
            {
                $ret = $blockStatementList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBlockStatementListNode());
            }
        )
    ;


// Parses a statement from a block of statements.
blockStatement returns [NodeUnion<? extends BlockStatementNode> ret]
        scope Rule;
        @init {
            ruleStart("blockStatement");
        }
        @after {
            ruleStop();
        }
    :   
        splice[BlockStatementNode.class, Arrays.<Class<? extends Node>>asList(LocalVariableDeclarationNode.class, LocalClassDeclarationNode.class, StatementNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, BlockStatementNode.class);
        }
    |
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
localVariableDeclarationStatement returns [NodeUnion<? extends LocalVariableDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("localVariableDeclarationStatement");
        }
        @after {
            ruleStop();
        }
    :
        splice[LocalVariableDeclarationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, LocalVariableDeclarationNode.class);
        }
    |
        localVariableDeclaration ';'
        {
            $ret = $localVariableDeclaration.ret;
        }
    ;

// Parses a local variable declaration.  Note that local variable declarations may declare multiple variables.
// For example, this rule would match
//     int x = 5, y
// Note the absence of a semicolon.
localVariableDeclaration returns [NodeUnion<? extends LocalVariableDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("localVariableDeclaration");
        }
        @after {
            ruleStop();
        }
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

statement returns [NodeUnion<? extends StatementNode> ret]
        scope Rule;
        @init {
            ruleStart("statement");
        }
        @after {
            ruleStop();
        }
    :
        splice[StatementNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, StatementNode.class);
        }
    |
        (
            blockAsStatement
            {
                $ret = $blockAsStatement.ret;
            }
        |
            assertStatement
            {
                $ret = $assertStatement.ret;
            }
        |
            ifStatement
            {
                $ret = $ifStatement.ret;
            }
        |
            forStatement
            {
                $ret = $forStatement.ret;
            }
        |
            whileStatement
            {
                $ret = $whileStatement.ret;
            }
        |
            doWhileStatement
            {
                $ret = $doWhileStatement.ret;
            }
        |
            tryStatement
            {
                $ret = $tryStatement.ret;
            }
        |
            switchStatement
            {
                $ret = $switchStatement.ret;
            }
        |
            synchronizedStatement
            {
                $ret = $synchronizedStatement.ret;
            }
        |
            returnStatement
            {
                $ret = $returnStatement.ret;
            }
        |
            throwStatement
            {
                $ret = $throwStatement.ret;
            }
        |
            breakStatement
            {
                $ret = $breakStatement.ret;
            }
        |
            continueStatement
            {
                $ret = $continueStatement.ret;
            }
        |
            expressionStatement
            {
                $ret = $expressionStatement.ret;
            }
        |
            labeledStatement
            {
                $ret = $labeledStatement.ret;
            }
        |
            noOpStatement
            {
                $ret = $noOpStatement.ret;
            }
        )

    ;

blockAsStatement returns [NodeUnion<? extends BlockNode> ret]
        scope Rule;
        @init {
            ruleStart("blockAsStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBlockNodeWithUnions($block.ret, $optionalMetaAnnotationList.ret));
        }
    ;

assertStatement returns [NodeUnion<? extends AssertStatementNode> ret]
        scope Rule;
        @init {
            ruleStart("assertStatement");
        }
        @after {
            ruleStop();
        }
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

ifStatement returns [NodeUnion<? extends IfNode> ret]
        scope Rule;
        @init {
            ruleStart("ifStatement");
        }
        @after {
            ruleStop();
        }
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

forStatement returns [NodeUnion<? extends StatementNode> ret]
        scope Rule;
        @init {
            ruleStart("forStatement");
        }
        @after {
            ruleStop();
        }
    :   
        (
            enhancedForStatement
            {
                $ret = $enhancedForStatement.ret;
            }
        |
            basicForStatement
            {
                $ret = $basicForStatement.ret;
            }
        )

    ;

enhancedForStatement returns [NodeUnion<? extends EnhancedForLoopNode> ret]
        scope Rule;
        @init {
            ruleStart("enhancedForStatement");
        }
        @after {
            ruleStop();
        }
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

basicForStatement returns [NodeUnion<? extends ForLoopNode> ret]
        scope Rule;
        @init {
            ruleStart("basicForStatement");
        }
        @after {
            ruleStop();
        }
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

whileStatement returns [NodeUnion<? extends WhileLoopNode> ret]
        scope Rule;
        @init {
            ruleStart("whileStatement");
        }
        @after {
            ruleStop();
        }
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

doWhileStatement returns [NodeUnion<? extends DoWhileLoopNode> ret]
        scope Rule;
        @init {
            ruleStart("doWhileStatement");
        }
        @after {
            ruleStop();
        }
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

tryStatement returns [NodeUnion<? extends TryNode> ret]
        scope Rule;
        @init {
            ruleStart("tryStatement");
            NodeUnion<? extends CatchListNode> catchList = null;
            NodeUnion<? extends BlockStatementListNode> finallyBlock = null;
        }
        @after {
            ruleStop();
        }
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

switchStatement returns [NodeUnion<? extends SwitchNode> ret]
        scope Rule;
        @init {
            ruleStart("switchStatement");
        }
        @after {
            ruleStop();
        }
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

synchronizedStatement returns [NodeUnion<? extends SynchronizedNode> ret]
        scope Rule;
        @init {
            ruleStart("synchronizedStatement");
        }
        @after {
            ruleStop();
        }
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

returnStatement returns [NodeUnion<? extends ReturnNode> ret]
        scope Rule;
        @init {
            ruleStart("returnStatement");
        }
        @after {
            ruleStop();
        }
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

throwStatement returns [NodeUnion<? extends ThrowNode> ret]
        scope Rule;
        @init {
            ruleStart("throwStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        'throw' expression ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeThrowNodeWithUnions(
                    $expression.ret, $optionalMetaAnnotationList.ret));
        }
    ;

breakStatement returns [NodeUnion<? extends BreakNode> ret]
        scope Rule;
        @init {
            ruleStart("breakStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        'break' identifier? ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeBreakNodeWithUnions(
                    $identifier.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

continueStatement returns [NodeUnion<? extends ContinueNode> ret]
        scope Rule;
        @init {
            ruleStart("continueStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        'continue' identifier? ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeContinueNodeWithUnions(
                    $identifier.ret,
                    $optionalMetaAnnotationList.ret));
        }
    ;

expressionStatement returns [NodeUnion<? extends ExpressionStatementNode> ret]
        scope Rule;
        @init {
            ruleStart("expressionStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        statementExpression  ';'  
        {
            $ret = factory.makeNormalNodeUnion(factory.makeExpressionStatementNodeWithUnions(
                    $statementExpression.ret,
                    $optionalMetaAnnotationList.ret));
        }   
    ;
    
labeledStatement returns [NodeUnion<? extends LabeledStatementNode> ret]
        scope Rule;
        @init {
            ruleStart("labeledStatement");
        }
        @after {
            ruleStop();
        }
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

noOpStatement returns [NodeUnion<? extends NoOperationNode> ret]
        scope Rule;
        @init {
            ruleStart("noOpStatement");
        }
        @after {
            ruleStop();
        }
    :
        optionalMetaAnnotationList
        ';'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeNoOperationNodeWithUnions($optionalMetaAnnotationList.ret));
        }
    ;

catches returns [NodeUnion<? extends CatchListNode> ret]
        scope Rule;
        @init {
            ruleStart("catches");
            List<NodeUnion<? extends CatchNode>> list =
                    new ArrayList<NodeUnion<? extends CatchNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeCatchListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=catchClause
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "catchClause", getSourceLocation($a.stop)));
            }
        }
        (
            b=catchClause
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "catchClause", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalCatches returns [NodeUnion<? extends CatchListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalCatches");
        }
        @after {
            ruleStop();
        }
    :
        (
            catches
            {
                $ret = $catches.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeCatchListNode());
            }
        )
    ;


catchClause returns [NodeUnion<? extends CatchNode> ret]
        scope Rule;
        @init {
            ruleStart("catchClause");
        }
        @after {
            ruleStop();
        }
    :   
        splice[CatchNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, CatchNode.class);
        }
    |
        'catch' '(' formalParameter ')'
        block
        {
            $ret = factory.makeNormalNodeUnion(factory.makeCatchNodeWithUnions(
                    $block.ret,
                    $formalParameter.ret));
        }
    ;

switchBlock returns [NodeUnion<? extends CaseListNode> ret]
        scope Rule;
        @init {
            ruleStart("switchBlock");
        }
        @after {
            ruleStop();
        }
    :
        '{'
        optionalSwitchBlockStatementGroups
        '}'
        {
            $ret = $optionalSwitchBlockStatementGroups.ret;
        }
    ;

switchBlockStatementGroups returns [NodeUnion<? extends CaseListNode> ret]
        scope Rule;
        @init {
            ruleStart("switchBlockStatementGroups");
            List<NodeUnion<? extends CaseNode>> list =
                    new ArrayList<NodeUnion<? extends CaseNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeCaseListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=switchBlockStatementGroup
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "switchBlockStatementGroup", getSourceLocation($a.stop)));
            }
        }
        (
            b=switchBlockStatementGroup
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "switchBlockStatementGroup", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalSwitchBlockStatementGroups returns [NodeUnion<? extends CaseListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalSwitchBlockStatementGroups");
        }
        @after {
            ruleStop();
        }
    :
        (
            switchBlockStatementGroups
            {
                $ret = $switchBlockStatementGroups.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeCaseListNode());
            }
        )
    ;


switchBlockStatementGroup returns [NodeUnion<? extends CaseNode> ret]
        scope Rule;
        @init {
            ruleStart("switchBlockStatementGroup");
        }
        @after {
            ruleStop();
        }
    :
        splice[CaseNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, CaseNode.class);
        }
    |
        switchLabel
        optionalBlockStatementList
        {
            $ret = factory.makeNormalNodeUnion(factory.makeCaseNodeWithUnions($switchLabel.ret, $optionalBlockStatementList.ret));
        }
    ;

switchLabel returns [NodeUnion<? extends ExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("switchLabel");
        }
        @after {
            ruleStop();
        }
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
formalParameter returns [NodeUnion<? extends VariableNode> ret]
        scope Rule;
        @init {
            ruleStart("formalParameter");
            NodeUnion<? extends TypeNode> typeNode = null;
        }
        @after {
            ruleStop();
        }
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
forInit returns [NodeUnion<? extends ForInitializerNode> ret]
        scope Rule;
        @init {
            ruleStart("forInit");
        }
        @after {
            ruleStop();
        }
    :   
        splice[ForInitializerNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ForInitializerNode.class);
        }
    |
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

parExpression returns [NodeUnion<? extends ExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("parExpression");
        }
        @after {
            ruleStop();
        }
    :   
        '(' expression ')'
        {
            $ret = $expression.ret;
        }
    ;

statementExpressionList returns [NodeUnion<? extends StatementExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("statementExpressionList");
            List<NodeUnion<? extends StatementExpressionNode>> list =
                    new ArrayList<NodeUnion<? extends StatementExpressionNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeStatementExpressionListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=statementExpression
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "statementExpression", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=statementExpression
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "statementExpression", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalStatementExpressionList returns [NodeUnion<? extends StatementExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalStatementExpressionList");
        }
        @after {
            ruleStop();
        }
    :
        (
            statementExpressionList
            {
                $ret = $statementExpressionList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeStatementExpressionListNode());
            }
        )
    ;


expressionList returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("expressionList");
            List<NodeUnion<? extends ExpressionNode>> list =
                    new ArrayList<NodeUnion<? extends ExpressionNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeExpressionListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=expression
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "expression", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=expression
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "expression", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalExpressionList returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalExpressionList");
        }
        @after {
            ruleStop();
        }
    :
        (
            expressionList
            {
                $ret = $expressionList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeExpressionListNode());
            }
        )
    ;

                       
/* This rule parses a statement expression.  A statement expression is one of those types of expressions which may be
 * used as a statement (such as x++) but not any other kind of expression (such as ~x). */
statementExpression returns [NodeUnion<? extends StatementExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("statementExpression");
        }
        @after {
            ruleStop();
        }
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

expression returns [NodeUnion<? extends ExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("expression");
        }
        @after {
            ruleStop();
        }
    :
        assignmentExpression
        {
            $ret = $assignmentExpression.ret;
        }
    ;

assignmentExpression returns [NodeUnion<? extends ExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("assignmentExpression");
        }
        @after {
            ruleStop();
        }
    :   
        (
            splice[ExpressionNode.class, Arrays.<Class<? extends Node>>asList(NonAssignmentExpressionNode.class)]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, ExpressionNode.class);
            }
        |
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

assignmentOperator returns [AssignmentOperator ret]
        scope Rule;
        @init {
            ruleStart("assignmentOperator");
        }
        @after {
            ruleStop();
        }
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

conditionalExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("conditionalExpression");
        }
        @after {
            ruleStop();
        }
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

conditionalOrExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("conditionalOrExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=conditionalAndExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '||'
                {
                    op = BinaryOperator.CONDITIONAL_OR;
                }
            )
            e2=conditionalAndExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


conditionalAndExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("conditionalAndExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=inclusiveOrExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '&&'
                {
                    op = BinaryOperator.CONDITIONAL_AND;
                }
            )
            e2=inclusiveOrExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


inclusiveOrExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("inclusiveOrExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=exclusiveOrExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '|'
                {
                    op = BinaryOperator.LOGICAL_OR;
                }
            )
            e2=exclusiveOrExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


exclusiveOrExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("exclusiveOrExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=andExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '^'
                {
                    op = BinaryOperator.XOR;
                }
            )
            e2=andExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


andExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("andExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=equalityExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '&'
                {
                    op = BinaryOperator.LOGICAL_AND;
                }
            )
            e2=equalityExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


equalityExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("equalityExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=instanceOfExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '=='
                {
                    op = BinaryOperator.EQUAL;
                }
            |
                '!='
                {
                    op = BinaryOperator.NOT_EQUAL;
                }
            )
            e2=instanceOfExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


instanceOfExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("instanceOfExpression");
        }
        @after {
            ruleStop();
        }
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

relationalExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("relationalExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=shiftExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '<' '='
                {
                    op = BinaryOperator.LESS_THAN_EQUAL;
                }
            |
                '>' '='
                {
                    op = BinaryOperator.GREATER_THAN_EQUAL;
                }
            |
                '<'
                {
                    op = BinaryOperator.LESS_THAN;
                }
            |
                '>'
                {
                    op = BinaryOperator.GREATER_THAN;
                }
            )
            e2=shiftExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


shiftExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("shiftExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=additiveExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '<' '<'
                {
                    op = BinaryOperator.LEFT_SHIFT;
                }
            |
                '>' '>' '>'
                {
                    op = BinaryOperator.UNSIGNED_RIGHT_SHIFT;
                }
            |
                '>' '>'
                {
                    op = BinaryOperator.RIGHT_SHIFT;
                }
            )
            e2=additiveExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


additiveExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("additiveExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=multiplicativeExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '+'
                {
                    op = BinaryOperator.PLUS;
                }
            |
                '-'
                {
                    op = BinaryOperator.MINUS;
                }
            )
            e2=multiplicativeExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


multiplicativeExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("multiplicativeExpression");
            BinaryOperator op = null;
        }
        @after {
            ruleStop();
        }
    :   
        e1=unaryExpression
        {
            $ret = $e1.ret;
        }    
        (
            (
                '*'
                {
                    op = BinaryOperator.MULTIPLY;
                }
            |
                '/'
                {
                    op = BinaryOperator.DIVIDE;
                }
            |
                '%'
                {
                    op = BinaryOperator.MODULUS;
                }
            )
            e2=unaryExpression
            {
                $ret = factory.makeNormalNodeUnion(factory.makeBinaryExpressionNodeWithUnions($ret, $e2.ret, op));
            }            
        )*
    ;


/**
 * NOTE: for '+' and '-', if the next token is int or long literal, then it's not a unary expression.
 *       it's a literal with signed value. INTLITERAL AND LONG LITERAL are added here for this.
 */
unaryExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("unaryExpression");
        }
        @after {
            ruleStop();
        }
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

unaryExpressionNotPlusMinus returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("unaryExpressionNotPlusMinus");
        }
        @after {
            ruleStop();
        }
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

castExpression returns [NodeUnion<? extends TypeCastNode> ret]
        scope Rule;
        @init {
            ruleStart("castExpression");
        }
        @after {
            ruleStop();
        }
    :   
        '(' type ')' unaryExpressionNotPlusMinus
        {
            $ret = factory.makeNormalNodeUnion(factory.makeTypeCastNodeWithUnions(
                $unaryExpressionNotPlusMinus.ret,
                $type.ret));
        }
    ;

postfixExpression returns [NodeUnion<? extends NonAssignmentExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("postfixExpression");
        }
        @after {
            ruleStop();
        }
    :
        (
            splice[NonAssignmentExpressionNode.class, Arrays.<Class<? extends Node>>asList(PrimaryExpressionNode.class)]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, NonAssignmentExpressionNode.class);
            }
        |
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
            splice[PrimaryExpressionNode.class, Arrays.<Class<? extends Node>>asList(RestrictedPrimaryExpressionNode.class, ArrayCreationNode.class)]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, PrimaryExpressionNode.class);
            }
        |
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

restrictedPrimary returns [NodeUnion<? extends RestrictedPrimaryExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("restrictedPrimary");
        }
        @after {
            ruleStop();
        }
    :
        splice[RestrictedPrimaryExpressionNode.class, Arrays.<Class<? extends Node>>asList(UnqualifiedClassInstantiationNode.class, SuperFieldAccessNode.class, SuperMethodInvocationNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, RestrictedPrimaryExpressionNode.class);
        }
    |
        (
            lexicalLiteral
            {
                $ret = $lexicalLiteral.ret;
            }
        |
            primitiveClassLiteral
            {
                $ret = $primitiveClassLiteral.ret;
            }
        |
            declaredClassLiteral
            {
                $ret = $declaredClassLiteral.ret;
            }
        |
            voidClassLiteral
            {
                $ret = $voidClassLiteral.ret;
            }
        |
            thisClause
            {
                $ret = $thisClause.ret;
            }
        |
            parenthesizedExpression
            {
                $ret = $parenthesizedExpression.ret;
            }
        |
            unqualifiedClassInstantiation
            {
                $ret = $unqualifiedClassInstantiation.ret;
            }
        |
            superMethodInvocation
            {
                $ret = $superMethodInvocation.ret;
            }
        |
            superFieldAccess
            {
                $ret = $superFieldAccess.ret;
            }
        |
            methodInvocationByName
            {
                $ret = $methodInvocationByName.ret;
            }
        |
            typeQualifiedTypeArgumentMethodInvocation
            {
                $ret = $typeQualifiedTypeArgumentMethodInvocation.ret;
            }
        |
            variableAccessByName
            {
                $ret = $variableAccessByName.ret;
            }
        )

        (
            arrayAccess[ret]
            {
                $ret = $arrayAccess.ret;
            }
        )?
    ;
    
// ANTLR's parameter passing has broken down by this point due to the complexity of this rule.  Using scope instead;
// thankfully, we know which rule is calling this one.
primarySuffix returns [NodeUnion<? extends RestrictedPrimaryExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("primarySuffix");
        }
        @after {
            ruleStop();
        }
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

thisClause returns [NodeUnion<? extends ThisNode> ret]
        scope Rule;
        @init {
            ruleStart("thisClause");
        }
        @after {
            ruleStop();
        }
    :
        (unparameterizedType '.')? THIS
        {
            $ret = factory.makeNormalNodeUnion(factory.makeThisNodeWithUnions($unparameterizedType.ret));
        }
    ;

parenthesizedExpression returns [NodeUnion<? extends ParenthesizedExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("parenthesizedExpression");
        }
        @after {
            ruleStop();
        }
    :
        parExpression
        {
            $ret = factory.makeNormalNodeUnion(factory.makeParenthesizedExpressionNodeWithUnions($parExpression.ret));
        }
    ;

unqualifiedClassInstantiation returns [NodeUnion<? extends UnqualifiedClassInstantiationNode> ret]
        scope Rule;
        @init {
            ruleStart("unqualifiedClassInstantiation");
        }
        @after {
            ruleStop();
        }
    :
        splice[UnqualifiedClassInstantiationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, UnqualifiedClassInstantiationNode.class);
        }
    |
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
superFieldAccess returns [NodeUnion<? extends SuperFieldAccessNode> ret]
        scope Rule;
        @init {
            ruleStart("superFieldAccess");
        }
        @after {
            ruleStop();
        }
    :
        splice[SuperFieldAccessNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, SuperFieldAccessNode.class);
        }
    |
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
methodInvocationByName returns [NodeUnion<? extends MethodInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("methodInvocationByName");
            NodeUnion<? extends RestrictedPrimaryExpressionNode> qualifier = 
                    factory.makeNormalNodeUnion(null);
            NodeUnion<? extends IdentifierNode> ident = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
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
superMethodInvocation returns [NodeUnion<? extends SuperMethodInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("superMethodInvocation");
        }
        @after {
            ruleStop();
        }
    :
        splice[SuperMethodInvocationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, SuperMethodInvocationNode.class);
        }
    |
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
typeQualifiedTypeArgumentMethodInvocation returns [NodeUnion<? extends MethodInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("typeQualifiedTypeArgumentMethodInvocation");
            NodeUnion<? extends RestrictedPrimaryExpressionNode> qualifier = 
                    factory.makeNormalNodeUnion(null);
        }
        @after {
            ruleStop();
        }
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
qualifiedClassInstantiationPrimarySuffix returns [NodeUnion<? extends QualifiedClassInstantiationNode> ret]
        scope Rule;
        @init {
            ruleStart("qualifiedClassInstantiationPrimarySuffix");
        }
        @after {
            ruleStop();
        }
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
fieldAccessPrimarySuffix returns [NodeUnion<? extends RestrictedPrimaryExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("fieldAccessPrimarySuffix");
        }
        @after {
            ruleStop();
        }
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
typeArgumentMethodInvocationSuffix returns [NodeUnion<? extends RestrictedPrimaryExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("typeArgumentMethodInvocationSuffix");
        }
        @after {
            ruleStop();
        }
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

variableAccessByName returns [NodeUnion<? extends VariableAccessNode> ret]
        scope Rule;
        @init {
            ruleStart("variableAccessByName");
        }
        @after {
            ruleStop();
        }
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
    
arrayAccess[NodeUnion<? extends RestrictedPrimaryExpressionNode> in] returns [NodeUnion<? extends ArrayAccessNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayAccess");
        }
        @after {
            ruleStop();
        }
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

declaredClassLiteral returns [NodeUnion<? extends ClassLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("declaredClassLiteral");
            NodeUnion<? extends LiteralizableTypeNode> typeNode = null;
        }
        @after {
            ruleStop();
        }
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

primitiveClassLiteral returns [NodeUnion<? extends ClassLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("primitiveClassLiteral");
            NodeUnion<? extends LiteralizableTypeNode> typeNode = null;
        }
        @after {
            ruleStop();
        }
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

voidClassLiteral returns [NodeUnion<? extends ClassLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("voidClassLiteral");
        }
        @after {
            ruleStop();
        }
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
arrayCreator returns [NodeUnion<? extends ArrayCreationNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayCreator");
        }
        @after {
            ruleStop();
        }
    :   
        splice[ArrayCreationNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ArrayCreationNode.class);
        }
    |
        (
            arrayInitializerCreator
            {
                $ret = $arrayInitializerCreator.ret;
            }
        |
            arrayInstantiatorCreator
            {
                $ret = $arrayInstantiatorCreator.ret;
            }
        )

    ;

arrayInitializerCreator returns [NodeUnion<? extends ArrayInitializerCreationNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayInitializerCreator");
            int levels = 0;
        }
        @after {
            ruleStop();
        }
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

arrayInstantiatorCreator returns [NodeUnion<? extends ArrayInstantiatorCreationNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayInstantiatorCreator");
            int levels = 0;
        }
        @after {
            ruleStop();
        }
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

arrayInstantiatorExpressionList returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayInstantiatorExpressionList");
            List<NodeUnion<? extends ExpressionNode>> list =
                    new ArrayList<NodeUnion<? extends ExpressionNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeExpressionListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=arrayInstantiatorExpression
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "arrayInstantiatorExpression", getSourceLocation($a.stop)));
            }
        }
        (
            b=arrayInstantiatorExpression
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "arrayInstantiatorExpression", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalArrayInstantiatorExpressionList returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalArrayInstantiatorExpressionList");
        }
        @after {
            ruleStop();
        }
    :
        (
            arrayInstantiatorExpressionList
            {
                $ret = $arrayInstantiatorExpressionList.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeExpressionListNode());
            }
        )
    ;


arrayInstantiatorExpression returns [NodeUnion<? extends ExpressionNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayInstantiatorExpression");
        }
        @after {
            ruleStop();
        }
    :
        '[' expression ']'
        {
            $ret = $expression.ret;
        }
    ;

variableInitializer returns [NodeUnion<? extends VariableInitializerNode> ret]
        scope Rule;
        @init {
            ruleStart("variableInitializer");
        }
        @after {
            ruleStop();
        }
    :   
        splice[VariableInitializerNode.class, Arrays.<Class<? extends Node>>asList(ArrayInitializerNode.class, ExpressionNode.class)]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, VariableInitializerNode.class);
        }
    |   
        (
            arrayInitializer
            {
                $ret = $arrayInitializer.ret;
            }
        |
            expression
            {
                $ret = $expression.ret;
            }
        )

    ;

variableInitializers returns [NodeUnion<? extends VariableInitializerListNode> ret]
        scope Rule;
        @init {
            ruleStart("variableInitializers");
            List<NodeUnion<? extends VariableInitializerNode>> list =
                    new ArrayList<NodeUnion<? extends VariableInitializerNode>>();
        }
        @after {
            $ret = factory.makeNormalNodeUnion(factory.makeVariableInitializerListNodeWithUnions(list));
            ruleStop();
        }
    :
        a=variableInitializer
        {
            // TODO: fix this with error nodes
            if ($a.ret != null && $a.ret.getNodeValue() != null)
            {
                list.add($a.ret);
            } else
            {
                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
                        getSourceLocation($a.start), "variableInitializer", getSourceLocation($a.stop)));
            }
        }
        (
            ','
            b=variableInitializer
            {
	            // TODO: fix this with error nodes
	            if ($b.ret != null && $b.ret.getNodeValue() != null)
	            {
	                list.add($b.ret);
	            } else
	            {
	                reportDiagnostic(new RuleParseFailureDiagnosticImpl(
	                        getSourceLocation($b.start), "variableInitializer", getSourceLocation($b.stop)));
	            }
            }
        )*
    ;

optionalVariableInitializers returns [NodeUnion<? extends VariableInitializerListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalVariableInitializers");
        }
        @after {
            ruleStop();
        }
    :
        (
            variableInitializers
            {
                $ret = $variableInitializers.ret;
            }
        )
    |
        (
            {
                $ret = factory.makeNormalNodeUnion(factory.makeVariableInitializerListNode());
            }
        )
    ;


arrayInitializer returns [NodeUnion<? extends ArrayInitializerNode> ret]
        scope Rule;
        @init {
            ruleStart("arrayInitializer");
        }
        @after {
            ruleStop();
        }
    :
        splice[ArrayInitializerNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, ArrayInitializerNode.class);
        }
    |   
        '{' 
            optionalVariableInitializers
            ','? 
        '}'
        {
            $ret = factory.makeNormalNodeUnion(factory.makeArrayInitializerNodeWithUnions($optionalVariableInitializers.ret));
        }
    ;

createdName returns [NodeUnion<? extends BaseTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("createdName");
        }
        @after {
            ruleStop();
        }
    :
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

    ;

optionalNonWildcardTypeArguments returns [NodeUnion<? extends ReferenceTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("optionalNonWildcardTypeArguments");
        }
        @after {
            ruleStop();
        }
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

nonWildcardTypeArguments returns [NodeUnion<? extends ReferenceTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("nonWildcardTypeArguments");
        }
        @after {
            ruleStop();
        }
    :   
        '<'
        referenceTypeList
        {
            $ret = $referenceTypeList.ret;
        }
        '>'
    ;

arguments returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("arguments");
        }
        @after {
            ruleStop();
        }
    :
        '('
        optionalExpressionList
        ')'
        {
            $ret = $optionalExpressionList.ret;
        }
    ;

// Parses a name chain.
name returns [NodeUnion<? extends NameNode> ret]
        scope Rule;
        @init {
            ruleStart("name");
        }
        @after {
            ruleStop();
        }
    :
        (
            splice[NameNode.class, Arrays.<Class<? extends Node>>asList()]
            {
                if ($splice.ret != null)
                    $ret = $splice.ret.castNodeType(factory, NameNode.class);
            }
        |
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

intLiteral[boolean isNegative] returns [NodeUnion<? extends IntLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("intLiteral");
        }
        @after {
            ruleStop();
        }
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
    
longLiteral[boolean isNegative] returns [NodeUnion<? extends LongLiteralNode> ret]
        scope Rule;
        @init {
            ruleStart("longLiteral");
        }
        @after {
            ruleStop();
        }
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

lexicalLiteral returns [NodeUnion<? extends LiteralNode<?>> ret]
        scope Rule;
        @init {
            ruleStart("lexicalLiteral");
        }
        @after {
            ruleStop();
        }
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

identifier returns [NodeUnion<? extends IdentifierNode> ret]
        scope Rule;
        @init {
            ruleStart("identifier");
        }
        @after {
            ruleStop();
        }
    :
        splice[IdentifierNode.class, Arrays.<Class<? extends Node>>asList()]
        {
            if ($splice.ret != null)
                $ret = $splice.ret.castNodeType(factory, IdentifierNode.class);
        }
    |
        IDENTIFIER
        {
            $ret = factory.makeNormalNodeUnion(factory.makeIdentifierNode($IDENTIFIER.text));
        }
    ;

unsplicableIdentifier returns [IdentifierNode ret]
        scope Rule;
        @init {
            ruleStart("unsplicableIdentifier");
        }
        @after {
            ruleStop();
        }
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

parseRule_AbstractMethodModifiers returns [NodeUnion<? extends AnnotationMethodModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AbstractMethodModifiers");
        }
        @after {
            ruleStop();
        }
    :
        annotationMethodModifiers
        EOF
        {
            $ret = $annotationMethodModifiers.ret;
        }
    ;

parseRule_Annotation returns [NodeUnion<? extends AnnotationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Annotation");
        }
        @after {
            ruleStop();
        }
    :
        annotation
        EOF
        {
            $ret = $annotation.ret;
        }
    ;

parseRule_Annotations returns [NodeUnion<? extends AnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Annotations");
        }
        @after {
            ruleStop();
        }
    :
        annotations
        EOF
        {
            $ret = $annotations.ret;
        }
    ;

parseRule_AnnotationMethodDeclaration returns [NodeUnion<? extends AnnotationMethodDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnnotationMethodDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        annotationMethodDeclaration
        EOF
        {
            $ret = $annotationMethodDeclaration.ret;
        }
    ;

parseRule_AnnotationModifiers returns [NodeUnion<? extends AnnotationModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnnotationModifiers");
        }
        @after {
            ruleStop();
        }
    :
        annotationModifiers
        EOF
        {
            $ret = $annotationModifiers.ret;
        }
    ;

parseRule_AnnotationTypeBody returns [NodeUnion<? extends AnnotationBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnnotationTypeBody");
        }
        @after {
            ruleStop();
        }
    :
        annotationTypeBody
        EOF
        {
            $ret = $annotationTypeBody.ret;
        }
    ;

parseRule_AnnotationTypeElementDeclarations returns [NodeUnion<? extends AnnotationMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnnotationTypeElementDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        annotationTypeElementDeclarations
        EOF
        {
            $ret = $annotationTypeElementDeclarations.ret;
        }
    ;

parseRule_AnnotationTypeElementDeclaration returns [NodeUnion<? extends AnnotationMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnnotationTypeElementDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        annotationTypeElementDeclaration
        EOF
        {
            $ret = $annotationTypeElementDeclaration.ret;
        }
    ;

parseRule_AnonymousClassBody returns [NodeUnion<? extends AnonymousClassBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnonymousClassBody");
        }
        @after {
            ruleStop();
        }
    :
        anonymousClassBody
        EOF
        {
            $ret = $anonymousClassBody.ret;
        }
    ;

parseRule_AnonymousClassBodyDeclarations returns [NodeUnion<? extends AnonymousClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnonymousClassBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        anonymousClassBodyDeclarations
        EOF
        {
            $ret = $anonymousClassBodyDeclarations.ret;
        }
    ;

parseRule_AnonymousClassBodyDeclaration returns [NodeUnion<? extends AnonymousClassMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_AnonymousClassBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        anonymousClassBodyDeclaration
        EOF
        {
            $ret = $anonymousClassBodyDeclaration.ret;
        }
    ;

parseRule_ArgumentList returns [NodeUnion<? extends ExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ArgumentList");
        }
        @after {
            ruleStop();
        }
    :
        expressionList
        EOF
        {
            $ret = $expressionList.ret;
        }
    ;

parseRule_BlockStatement returns [NodeUnion<? extends BlockStatementNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_BlockStatement");
        }
        @after {
            ruleStop();
        }
    :
        blockStatement
        EOF
        {
            $ret = $blockStatement.ret;
        }
    ;

parseRule_BlockStatements returns [NodeUnion<? extends BlockStatementListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_BlockStatements");
        }
        @after {
            ruleStop();
        }
    :
        blockStatementList
        EOF
        {
            $ret = $blockStatementList.ret;
        }
    ;

parseRule_CatchClause returns [NodeUnion<? extends CatchNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_CatchClause");
        }
        @after {
            ruleStop();
        }
    :
        catchClause
        EOF
        {
            $ret = $catchClause.ret;
        }
    ;

parseRule_Catches returns [NodeUnion<? extends CatchListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Catches");
        }
        @after {
            ruleStop();
        }
    :
        catches
        EOF
        {
            $ret = $catches.ret;
        }
    ;

parseRule_ClassBody returns [NodeUnion<? extends ClassBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ClassBody");
        }
        @after {
            ruleStop();
        }
    :
        classBody
        EOF
        {
            $ret = $classBody.ret;
        }
    ;

parseRule_ClassBodyDeclaration returns [NodeUnion<? extends ClassMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ClassBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        classBodyDeclaration
        EOF
        {
            $ret = $classBodyDeclaration.ret;
        }
    ;

parseRule_ClassBodyDeclarations returns [NodeUnion<? extends ClassMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ClassBodyDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        classBodyDeclarations
        EOF
        {
            $ret = $classBodyDeclarations.ret;
        }
    ;

parseRule_ClassModifiers returns [NodeUnion<? extends ClassModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ClassModifiers");
        }
        @after {
            ruleStop();
        }
    :
        classModifiers
        EOF
        {
            $ret = $classModifiers.ret;
        }
    ;

parseRule_ClassOrInterfaceTypeList returns [NodeUnion<? extends DeclaredTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ClassOrInterfaceTypeList");
        }
        @after {
            ruleStop();
        }
    :
        declaredTypeList
        EOF
        {
            $ret = $declaredTypeList.ret;
        }
    ;

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

parseRule_ConstantDeclaration returns [NodeUnion<? extends ConstantDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ConstantDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        constantDeclaration
        EOF
        {
            $ret = $constantDeclaration.ret;
        }
    ;

parseRule_ConstantModifiers returns [NodeUnion<? extends ConstantModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ConstantModifiers");
        }
        @after {
            ruleStop();
        }
    :
        constantModifiers
        EOF
        {
            $ret = $constantModifiers.ret;
        }
    ;

parseRule_ConstructorBody returns [NodeUnion<? extends ConstructorBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ConstructorBody");
        }
        @after {
            ruleStop();
        }
    :
        constructorBody
        EOF
        {
            $ret = $constructorBody.ret;
        }
    ;

parseRule_ConstructorDeclaration returns [NodeUnion<? extends ConstructorDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ConstructorDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        constructorDeclaration
        EOF
        {
            $ret = $constructorDeclaration.ret;
        }
    ;

parseRule_ConstructorModifiers returns [NodeUnion<? extends ConstructorModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ConstructorModifiers");
        }
        @after {
            ruleStop();
        }
    :
        constructorModifiers
        EOF
        {
            $ret = $constructorModifiers.ret;
        }
    ;

parseRule_ElementValue returns [NodeUnion<? extends AnnotationValueNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ElementValue");
        }
        @after {
            ruleStop();
        }
    :
        elementValue
        EOF
        {
            $ret = $elementValue.ret;
        }
    ;

parseRule_ElementValues returns [NodeUnion<? extends AnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ElementValues");
        }
        @after {
            ruleStop();
        }
    :
        elementValues
        EOF
        {
            $ret = $elementValues.ret;
        }
    ;

parseRule_ElementValuePair returns [NodeUnion<? extends AnnotationElementNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ElementValuePair");
        }
        @after {
            ruleStop();
        }
    :
        elementValuePair
        EOF
        {
            $ret = $elementValuePair.ret;
        }
    ;

parseRule_ElementValuePairs returns [NodeUnion<? extends AnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ElementValuePairs");
        }
        @after {
            ruleStop();
        }
    :
        elementValuePairs
        EOF
        {
            $ret = $elementValuePairs.ret;
        }
    ;

parseRule_EnumBody returns [NodeUnion<? extends EnumBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_EnumBody");
        }
        @after {
            ruleStop();
        }
    :
        enumBody
        EOF
        {
            $ret = $enumBody.ret;
        }
    ;

parseRule_EnumConstant returns [NodeUnion<? extends EnumConstantDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_EnumConstant");
        }
        @after {
            ruleStop();
        }
    :
        enumConstant
        EOF
        {
            $ret = $enumConstant.ret;
        }
    ;

parseRule_EnumConstants returns [NodeUnion<? extends EnumConstantDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_EnumConstants");
        }
        @after {
            ruleStop();
        }
    :
        enumConstants
        EOF
        {
            $ret = $enumConstants.ret;
        }
    ;

parseRule_EnumModifiers returns [NodeUnion<? extends EnumModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_EnumModifiers");
        }
        @after {
            ruleStop();
        }
    :
        enumModifiers
        EOF
        {
            $ret = $enumModifiers.ret;
        }
    ;

parseRule_ExceptionTypeList returns [NodeUnion<? extends UnparameterizedTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ExceptionTypeList");
        }
        @after {
            ruleStop();
        }
    :
        unparameterizedTypeList
        EOF
        {
            $ret = $unparameterizedTypeList.ret;
        }
    ;

parseRule_ExplicitConstructorInvocation returns [NodeUnion<? extends ConstructorInvocationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ExplicitConstructorInvocation");
        }
        @after {
            ruleStop();
        }
    :
        explicitConstructorInvocation
        EOF
        {
            $ret = $explicitConstructorInvocation.ret;
        }
    ;

parseRule_FieldDeclaration returns [NodeUnion<? extends FieldDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_FieldDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        fieldDeclaration
        EOF
        {
            $ret = $fieldDeclaration.ret;
        }
    ;

parseRule_FieldModifiers returns [NodeUnion<? extends FieldModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_FieldModifiers");
        }
        @after {
            ruleStop();
        }
    :
        fieldModifiers
        EOF
        {
            $ret = $fieldModifiers.ret;
        }
    ;

parseRule_ForInit returns [NodeUnion<? extends ForInitializerNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ForInit");
        }
        @after {
            ruleStop();
        }
    :
        forInit
        EOF
        {
            $ret = $forInit.ret;
        }
    ;

parseRule_FormalParameter returns [NodeUnion<? extends VariableNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_FormalParameter");
        }
        @after {
            ruleStop();
        }
    :
        formalParameter
        EOF
        {
            $ret = $formalParameter.ret;
        }
    ;

parseRule_Identifier returns [NodeUnion<? extends IdentifierNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Identifier");
        }
        @after {
            ruleStop();
        }
    :
        identifier
        EOF
        {
            $ret = $identifier.ret;
        }
    ;

parseRule_IdentifierList returns [NodeUnion<? extends IdentifierListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_IdentifierList");
        }
        @after {
            ruleStop();
        }
    :
        identifierList
        EOF
        {
            $ret = $identifierList.ret;
        }
    ;

parseRule_ImportDeclaration returns [NodeUnion<? extends ImportNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ImportDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        importDeclaration
        EOF
        {
            $ret = $importDeclaration.ret;
        }
    ;

parseRule_ImportDeclarations returns [NodeUnion<? extends ImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ImportDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        importDeclarations
        EOF
        {
            $ret = $importDeclarations.ret;
        }
    ;

parseRule_Initializer returns [NodeUnion<? extends InitializerDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Initializer");
        }
        @after {
            ruleStop();
        }
    :
        initializerBlock
        EOF
        {
            $ret = $initializerBlock.ret;
        }
    ;

parseRule_InterfaceBody returns [NodeUnion<? extends InterfaceBodyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_InterfaceBody");
        }
        @after {
            ruleStop();
        }
    :
        interfaceBody
        EOF
        {
            $ret = $interfaceBody.ret;
        }
    ;

parseRule_InterfaceMemberDeclaration returns [NodeUnion<? extends InterfaceMemberNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_InterfaceMemberDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        interfaceBodyDeclaration
        EOF
        {
            $ret = $interfaceBodyDeclaration.ret;
        }
    ;

parseRule_InterfaceMemberDeclarations returns [NodeUnion<? extends InterfaceMemberListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_InterfaceMemberDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        interfaceBodyDeclarations
        EOF
        {
            $ret = $interfaceBodyDeclarations.ret;
        }
    ;

parseRule_InterfaceModifiers returns [NodeUnion<? extends InterfaceModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_InterfaceModifiers");
        }
        @after {
            ruleStop();
        }
    :
        interfaceModifiers
        EOF
        {
            $ret = $interfaceModifiers.ret;
        }
    ;

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

parseRule_LocalClassDeclaration returns [NodeUnion<? extends LocalClassDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_LocalClassDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        localClassDeclaration
        EOF
        {
            $ret = $localClassDeclaration.ret;
        }
    ;

parseRule_LocalClassModifiers returns [NodeUnion<? extends LocalClassModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_LocalClassModifiers");
        }
        @after {
            ruleStop();
        }
    :
        localClassModifiers
        EOF
        {
            $ret = $localClassModifiers.ret;
        }
    ;

parseRule_MetaAnnotation returns [NodeUnion<? extends MetaAnnotationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotation");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotation
        EOF
        {
            $ret = $metaAnnotation.ret;
        }
    ;

parseRule_MetaAnnotationList returns [NodeUnion<? extends MetaAnnotationListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotationList");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotationList
        EOF
        {
            $ret = $metaAnnotationList.ret;
        }
    ;

parseRule_MetaAnnotationElement returns [NodeUnion<? extends MetaAnnotationElementNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotationElement");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotationElementValuePair
        EOF
        {
            $ret = $metaAnnotationElementValuePair.ret;
        }
    ;

parseRule_MetaAnnotationElements returns [NodeUnion<? extends MetaAnnotationElementListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotationElements");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotationElementValuePairs
        EOF
        {
            $ret = $metaAnnotationElementValuePairs.ret;
        }
    ;

parseRule_MetaAnnotationElementValue returns [NodeUnion<? extends MetaAnnotationValueNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotationElementValue");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotationElementValue
        EOF
        {
            $ret = $metaAnnotationElementValue.ret;
        }
    ;

parseRule_MetaAnnotationElementValues returns [NodeUnion<? extends MetaAnnotationValueListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaAnnotationElementValues");
        }
        @after {
            ruleStop();
        }
    :
        metaAnnotationElementValues
        EOF
        {
            $ret = $metaAnnotationElementValues.ret;
        }
    ;

parseRule_Metaprogram returns [NodeUnion<? extends MetaprogramNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Metaprogram");
        }
        @after {
            ruleStop();
        }
    :
        bsjMetaprogram
        EOF
        {
            $ret = $bsjMetaprogram.ret;
        }
    ;

parseRule_MetaprogramDependency returns [NodeUnion<? extends MetaprogramDependencyNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramDependency");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramDependency
        EOF
        {
            $ret = $metaprogramDependency.ret;
        }
    ;

parseRule_MetaprogramDependencyDeclaration returns [NodeUnion<? extends MetaprogramDependencyDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramDependencyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramDependencyDeclaration
        EOF
        {
            $ret = $metaprogramDependencyDeclaration.ret;
        }
    ;

parseRule_MetaprogramDependencyDeclarationList returns [NodeUnion<? extends MetaprogramDependencyDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramDependencyDeclarationList");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramDependencyDeclarationList
        EOF
        {
            $ret = $metaprogramDependencyDeclarationList.ret;
        }
    ;

parseRule_MetaprogramDependencyList returns [NodeUnion<? extends MetaprogramDependencyListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramDependencyList");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramDependencyList
        EOF
        {
            $ret = $metaprogramDependencyList.ret;
        }
    ;

parseRule_MetaprogramImportDeclaration returns [NodeUnion<? extends MetaprogramImportNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramImportDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramImport
        EOF
        {
            $ret = $metaprogramImport.ret;
        }
    ;

parseRule_MetaprogramImportDeclarationList returns [NodeUnion<? extends MetaprogramImportListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramImportDeclarationList");
        }
        @after {
            ruleStop();
        }
    :
        metaImportDeclarations
        EOF
        {
            $ret = $metaImportDeclarations.ret;
        }
    ;

parseRule_MetaprogramTargetDeclaration returns [NodeUnion<? extends MetaprogramTargetNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramTargetDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramTarget
        EOF
        {
            $ret = $metaprogramTarget.ret;
        }
    ;

parseRule_MetaprogramTargetDeclarationList returns [NodeUnion<? extends MetaprogramTargetListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MetaprogramTargetDeclarationList");
        }
        @after {
            ruleStop();
        }
    :
        metaprogramTargetList
        EOF
        {
            $ret = $metaprogramTargetList.ret;
        }
    ;

parseRule_MethodDeclaration returns [NodeUnion<? extends MethodDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MethodDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        methodDeclaration
        EOF
        {
            $ret = $methodDeclaration.ret;
        }
    ;

parseRule_MethodModifiers returns [NodeUnion<? extends MethodModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_MethodModifiers");
        }
        @after {
            ruleStop();
        }
    :
        methodModifiers
        EOF
        {
            $ret = $methodModifiers.ret;
        }
    ;

parseRule_Name returns [NodeUnion<? extends NameNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Name");
        }
        @after {
            ruleStop();
        }
    :
        name
        EOF
        {
            $ret = $name.ret;
        }
    ;

parseRule_PackageDeclaration returns [NodeUnion<? extends PackageDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_PackageDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        packageDeclaration
        EOF
        {
            $ret = $packageDeclaration.ret;
        }
    ;

parseRule_Preamble returns [NodeUnion<? extends MetaprogramPreambleNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Preamble");
        }
        @after {
            ruleStop();
        }
    :
        preamble
        EOF
        {
            $ret = $preamble.ret;
        }
    ;

parseRule_ReferenceTypeList returns [NodeUnion<? extends ReferenceTypeListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_ReferenceTypeList");
        }
        @after {
            ruleStop();
        }
    :
        referenceTypeList
        EOF
        {
            $ret = $referenceTypeList.ret;
        }
    ;

parseRule_StatementExpressionList returns [NodeUnion<? extends StatementExpressionListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_StatementExpressionList");
        }
        @after {
            ruleStop();
        }
    :
        statementExpressionList
        EOF
        {
            $ret = $statementExpressionList.ret;
        }
    ;

parseRule_SwitchBlockStatementGroup returns [NodeUnion<? extends CaseNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_SwitchBlockStatementGroup");
        }
        @after {
            ruleStop();
        }
    :
        switchBlockStatementGroup
        EOF
        {
            $ret = $switchBlockStatementGroup.ret;
        }
    ;

parseRule_SwitchBlockStatementGroups returns [NodeUnion<? extends CaseListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_SwitchBlockStatementGroups");
        }
        @after {
            ruleStop();
        }
    :
        switchBlockStatementGroups
        EOF
        {
            $ret = $switchBlockStatementGroups.ret;
        }
    ;

parseRule_Type returns [NodeUnion<? extends TypeNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Type");
        }
        @after {
            ruleStop();
        }
    :
        type
        EOF
        {
            $ret = $type.ret;
        }
    ;

parseRule_TypeArguments returns [NodeUnion<? extends TypeArgumentListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_TypeArguments");
        }
        @after {
            ruleStop();
        }
    :
        typeArguments
        EOF
        {
            $ret = $typeArguments.ret;
        }
    ;

parseRule_TypeDeclaration returns [NodeUnion<? extends TypeDeclarationNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_TypeDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        typeDeclaration
        EOF
        {
            $ret = $typeDeclaration.ret;
        }
    ;

parseRule_TypeDeclarations returns [NodeUnion<? extends TypeDeclarationListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_TypeDeclarations");
        }
        @after {
            ruleStop();
        }
    :
        typeDeclarations
        EOF
        {
            $ret = $typeDeclarations.ret;
        }
    ;

parseRule_TypeParameter returns [NodeUnion<? extends TypeParameterNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_TypeParameter");
        }
        @after {
            ruleStop();
        }
    :
        typeParameter
        EOF
        {
            $ret = $typeParameter.ret;
        }
    ;

parseRule_TypeParameters returns [NodeUnion<? extends TypeParameterListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_TypeParameters");
        }
        @after {
            ruleStop();
        }
    :
        typeParameters
        EOF
        {
            $ret = $typeParameters.ret;
        }
    ;

parseRule_VariableDeclarator returns [NodeUnion<? extends VariableDeclaratorNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_VariableDeclarator");
        }
        @after {
            ruleStop();
        }
    :
        variableDeclarator
        EOF
        {
            $ret = $variableDeclarator.ret;
        }
    ;

parseRule_VariableDeclarators returns [NodeUnion<? extends VariableDeclaratorListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_VariableDeclarators");
        }
        @after {
            ruleStop();
        }
    :
        variableDeclarators
        EOF
        {
            $ret = $variableDeclarators.ret;
        }
    ;

parseRule_VariableInitializer returns [NodeUnion<? extends VariableInitializerNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_VariableInitializer");
        }
        @after {
            ruleStop();
        }
    :
        variableInitializer
        EOF
        {
            $ret = $variableInitializer.ret;
        }
    ;

parseRule_VariableInitializers returns [NodeUnion<? extends VariableInitializerListNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_VariableInitializers");
        }
        @after {
            ruleStop();
        }
    :
        variableInitializers
        EOF
        {
            $ret = $variableInitializers.ret;
        }
    ;

parseRule_VariableModifiers returns [NodeUnion<? extends VariableModifiersNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_VariableModifiers");
        }
        @after {
            ruleStop();
        }
    :
        variableModifiers
        EOF
        {
            $ret = $variableModifiers.ret;
        }
    ;

parseRule_Wildcard returns [NodeUnion<? extends WildcardTypeNode> ret]
        scope Rule;
        @init {
            ruleStart("parseRule_Wildcard");
        }
        @after {
            ruleStop();
        }
    :
        wildcard
        EOF
        {
            $ret = $wildcard.ret;
        }
    ;


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

