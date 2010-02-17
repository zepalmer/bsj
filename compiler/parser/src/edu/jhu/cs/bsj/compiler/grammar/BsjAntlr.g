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
 */


grammar BsjAntlr;

options {
    language=Java;
    backtrack=true;
    memoize=true;
}

// this scope tracks information about the rule on top of the call stack
scope Rule {
    String name;
    Token firstToken;
}

@lexer::header{
    package edu.jhu.cs.bsj.compiler.tool.parser.antlr;

    import javax.tools.Diagnostic;
    import javax.tools.DiagnosticListener;
    import javax.tools.JavaFileObject;
    
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
    private JavaFileObject resource;
    /** Getter for the resource name indicating which resource is being parsed. */
    public JavaFileObject getResource()
    {
        return resource;
    }
    public void setResource(JavaFileObject resource)
    {
        this.resource = resource;
    }
    /**
     * Produces a resource name for the resource in this parser.
     */
    protected String getResourceName()
    {
        return this.resource == null ? "<unknown>" : this.resource.toString();
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
    protected BsjSourceLocation getSourceLocation(int rel)
    {
        return new BsjSourceLocation(getResourceName(), this.getLine(), this.getCharPositionInLine() + 1);
    }

    // *** ERROR REPORTING AND HANDLING ***************************************
    /** The diagnostic listener to which we report events. */
    private DiagnosticListener<? super JavaFileObject> diagnosticListener;
    
    /** Assigns a diagnostic listener to this parser. */
    public void setDiagnosticListener(DiagnosticListener<? super JavaFileObject> diagnosticListener)
    {
        this.diagnosticListener = diagnosticListener;
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(Diagnostic<? extends JavaFileObject> diagnostic)
    {
        this.diagnosticListener.report(diagnostic);
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
                e, tokenNames, getLineNumber(), getColumnNumber(), resource, character);
        reportDiagnostic(diagnostic);
    }
}

@parser::header{
    package edu.jhu.cs.bsj.compiler.tool.parser.antlr;
    
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
    import edu.jhu.cs.bsj.compiler.ast.node.meta.*;
    import edu.jhu.cs.bsj.compiler.ast.util.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.*;
    import edu.jhu.cs.bsj.compiler.diagnostic.parser.*;
    
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.util.BsjAntlrParserUtils;
    import edu.jhu.cs.bsj.compiler.tool.parser.antlr.util.BsjParserConfiguration;
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
    private JavaFileObject resource;
    /** Getter for the resource name indicating which resource is being parsed. */
    public JavaFileObject getResource()
    {
        return resource;
    }
    public void setResource(JavaFileObject resource)
    {
        this.resource = resource;
    }
    /**
     * Produces a resource name for the resource in this parser.
     */
    protected String getResourceName()
    {
        return this.resource == null ? "<unknown>" : this.resource.toString();
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getLineNumber(int rel)
    {
        Token token = input.LT(rel);
        return token == null ? BsjSourceLocation.NOPOS : token.getLine();
    }
    /**
     * Retrieves the line number for the specified relative token index (as per input.LT).
     */
    protected int getColumnNumber(int rel)
    {
        Token token = input.LT(rel);
        return token == null ? BsjSourceLocation.NOPOS : token.getCharPositionInLine() + 1;
    }
    /**
     * Retrieves a source location object describing the start of the specified relative token index (as per input.LT).
     */
    protected BsjSourceLocation getSourceLocation(int rel)
    {
        Token token = input.LT(rel);
        return new BsjSourceLocation(
                getResourceName(),
                token==null ? BsjSourceLocation.NOPOS : token.getLine(),
                token==null ? BsjSourceLocation.NOPOS : token.getCharPositionInLine() + 1);
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
    
    // *** DATA STRUCTURE FOR MODIFIER PARSING ********************************
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
                    reportDiagnostic(new InvalidModifierDiagnostic<JavaFileObject>(
                            getLineNumber(-1),
                            getColumnNumber(-1),
                            resource,
                            $Rule::name,
                            mod.toString().toLowerCase()));
                    break;
                case NOT_SEEN:
                    state[mod.ordinal()] = ModifierState.SEEN;
                    break;
                case SEEN:
                    reportDiagnostic(new DuplicateModifierDiagnostic<JavaFileObject>(
                            getLineNumber(-1),
                            getColumnNumber(-1),
                            resource,
                            $Rule::name,
                            mod.toString().toLowerCase()));
                    break;
            }
        }
    }
    
    // *** ERROR REPORTING AND HANDLING ***************************************
    /** The diagnostic listener to which we report events. */
    private DiagnosticListener<? super JavaFileObject> diagnosticListener;
    
    /** Assigns a diagnostic listener to this parser. */
    public void setDiagnosticListener(DiagnosticListener<? super JavaFileObject> diagnosticListener)
    {
        this.diagnosticListener = diagnosticListener;
    }
    
    /** Reports a diagnostic. */
    private void reportDiagnostic(Diagnostic<? extends JavaFileObject> diagnostic)
    {
        this.diagnosticListener.report(diagnostic);
    }
    
    /**
     * Overrides the mechanism for displaying recognition errors.  While it is possible to do something very similar by
     * overriding emitErrorMessage, this method is extracted instead in order to allow the exception itself to be
     * trapped for more informative error handling.
     */
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        Diagnostic<? extends JavaFileObject> diagnostic =
                BsjAntlrParserUtils.convertFromParser(
                        e, tokenNames, getLineNumber(1), getColumnNumber(1), resource, input.LT(1), $Rule::name);
        reportDiagnostic(diagnostic);
    }
    
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
    
    // *** RULE AOP METHODS ***************************************************
    private void ruleStart(String ruleName)
    {
        $Rule::name = ruleName;
        $Rule::firstToken = input.LT(1);
    }
    
    private void ruleStop()
    {
    }
}



/********************************************************************************************
                          Parser section
*********************************************************************************************/

/* ===========================================================================
 * These rules only exist in the parser.  They may map to the language standard but are primarily used to abstract
 * away parser patterns and may not manifest in the AST. 
 * ===========================================================================
 */
 
// Represents the combination of an identifier and an initializer.  As the identifier can be followed with array type
// indicators, an in/out type is also required.  This construct is necessary on its own to support the multiple
// declaration sugar ("int x,y;").
variableDeclarator[TypeNode inType] returns [VariableDeclaratorNode ret]
        scope Rule;
        @init {
            ruleStart("variableDeclarator");
            TypeNode type = inType;
            VariableInitializerNode initializer = null;
        }
        @after {
            ruleStop();
        }
    :
        id=identifier
        {
            if (logger.isTraceEnabled())
            {
                logger.trace("Parsing variable declarator with name " + $id.ret.getIdentifier());
            }
        }
        (
            arrayTypeIndicator[inType]
            {
                type = $arrayTypeIndicator.ret;
            }
        )?
        (
            '=' variableInitializer
            {
                initializer = $variableInitializer.ret;
            }
        )?
        {
            $ret = factory.makeVariableDeclaratorNode(type, $id.ret, initializer);
        }
    ;

// Represents the declaration of an array type over a normal type.  This construct only handles the parsing of the []
// symbols and the modification of a type.  Note that this rule must parse at least one pair of brackets; thus, it
// should be optional anywhere that a non-array type is permissible.
arrayTypeIndicator[TypeNode inType] returns [ArrayTypeNode ret]
        scope Rule;
        @init {
            ruleStart("arrayTypeIndicator");
        }
        @after {
            ruleStop();
        }
    :
        '[' ']'
        {
            $ret = factory.makeArrayTypeNode(inType);
        }
        (
            '[' ']'
            {
                $ret = factory.makeArrayTypeNode($ret);
            }
        )*
    ;

/* ===========================================================================
 * These are the BSJ grammar rules.
 * ===========================================================================
 */

/* This rule parses a BSJ metaprogram. */
bsjMetaprogram returns [MetaprogramNode ret]
        scope Rule;
        @init {
            ruleStart("bsjMetaprogram");
        }
        @after {
            ruleStop();
        }
    :
        '[' ':'
        preamble
        blockStatementList
        ':' ']'
        {
            $ret = factory.makeMetaprogramNode($preamble.ret, $blockStatementList.ret);
        }
    ;

/* This rule parses a BSJ metaprogram preamble */
preamble returns [MetaprogramPreambleNode ret]
        scope Rule;
        @init {
            ruleStart("preamble");
            List<MetaprogramImportNode> list = new ArrayList<MetaprogramImportNode>();
            MetaprogramTargetNode target = null;
            MetaprogramDependsNode depends = null;
        }
        @after {
            $ret = factory.makeMetaprogramPreambleNode(factory.makeMetaprogramImportListNode(list), target,depends);
            ruleStop();
        }
    :
        (
            metaprogramImport
            {
                list.add($metaprogramImport.ret);
            }
        )*
        (
            metaprogramTarget
            {
                target = $metaprogramTarget.ret;
            }
        )?
        (
            metaprogramDependency
            {
                depends = $metaprogramDependency.ret;
            }
        )?
    ;

metaprogramImport returns [MetaprogramImportNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramImport");
        }
        @after {
            ruleStop();
        }
    :   
        '#import'
        importBody
        ';'
        {
            ImportNode node;
            if ($importBody.onDemand)
            {
                node = factory.makeImportOnDemandNode($importBody.name, $importBody.staticImport);
            } else
            {
                node = factory.makeImportSingleTypeNode($importBody.name, $importBody.staticImport);
            }
            $ret = factory.makeMetaprogramImportNode(node);
        }
    ;

metaprogramDependency returns [MetaprogramDependsNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramDependency");
        }
        @after {
            ruleStop();
        }
    :   
        '#depends'
        metaprogramTargetNameList
        ';'
        {
            $ret = factory.makeMetaprogramDependsNode($metaprogramTargetNameList.ret);
        }
    ;

metaprogramTarget returns [MetaprogramTargetNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTargetNode");
        }
        @after {
            ruleStop();
        }
    :   
        '#target'
        identifierList
        ';'
        {
            $ret = factory.makeMetaprogramTargetNode($identifierList.ret);
        }
    ;

metaprogramTargetNameList returns [NameListNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTargetNameList");
            List<NameNode> names = new ArrayList<NameNode>();
        }
        @after {
            $ret = factory.makeNameListNode(names);
            ruleStop();
        }
    :
        a=metaprogramTargetName
        {
            names.add($a.ret);
        }
        (
            b=metaprogramTargetName
            {
                names.add($b.ret);
            }
        )*
        ','?
    ;

metaprogramTargetName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramTargetName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.PACKAGE_OR_TYPE, NameCategory.TYPE, NameCategory.METAPROGRAM_TARGET]
        {
            $ret = $categorizedName.ret;
        }
    ;
    
identifierList returns [IdentifierListNode ret]
        scope Rule;
        @init {
            ruleStart("metaprogramIdentifierList");
            List<IdentifierNode> ids = new ArrayList<IdentifierNode>();
        }
        @after {
            $ret = factory.makeIdentifierListNode(ids);
            ruleStop();
        }
    :
        a=identifier
        {
            ids.add($a.ret);
        }
        (
            ',' b=identifier
            {
                ids.add($b.ret);
            }
        )*
        ','?
    ;
        
typeDeclarationBsjMetaprogramAnchor returns [TypeDeclarationMetaprogramAnchorNode ret]
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
            $ret = factory.makeTypeDeclarationMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;    

annotationMemberBsjMetaprogramAnchor returns [AnnotationMemberMetaprogramAnchorNode ret]
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
            $ret = factory.makeAnnotationMemberMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;

anonymousClassMemberBsjMetaprogramAnchor returns [AnonymousClassMemberMetaprogramAnchorNode ret]
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
            $ret = factory.makeAnonymousClassMemberMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;

classMemberBsjMetaprogramAnchor returns [ClassMemberMetaprogramAnchorNode ret]
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
            $ret = factory.makeClassMemberMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;

interfaceMemberBsjMetaprogramAnchor returns [InterfaceMemberMetaprogramAnchorNode ret]
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
            $ret = factory.makeInterfaceMemberMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;

blockStatementBsjMetaprogramAnchor returns [BlockStatementMetaprogramAnchorNode ret]
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
            $ret = factory.makeBlockStatementMetaprogramAnchorNode($bsjMetaprogram.ret);
        }
    ;

/* ===========================================================================
 * These are the Java grammar rules.
 * ===========================================================================
 */

compilationUnit returns [CompilationUnitNode ret]
        scope Rule;
        @init {
            ruleStart("compilationUnit");
        }
        @after {
            ruleStop();
        }
    :
        packageDeclaration?
        importDeclarations
        typeDeclarations
        EOF
        {
            $ret = factory.makeCompilationUnitNode(
                        $packageDeclaration.ret,
                        $importDeclarations.metaprogramImportList,
                        $importDeclarations.importList,
                        $typeDeclarations.ret);
        }
    ;

packageDeclaration returns [PackageDeclarationNode ret]
        scope Rule;
        @init{
            ruleStart("packageDeclaration");
            AnnotationListNode annotationsNode = 
                factory.makeAnnotationListNode(Collections.<AnnotationNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :
        (
            annotations
            {
                annotationsNode = $annotations.ret;
            }
        )?
        'package' packageName ';'
        {
            $ret = factory.makePackageDeclarationNode(
                    $packageName.ret,
                    annotationsNode);
        }
    ;

importDeclarations returns [ImportListNode importList, MetaprogramImportListNode metaprogramImportList]
        scope Rule;
        @init {
            ruleStart("importDeclarations");
            List<ImportNode> importList = new ArrayList<ImportNode>();
            List<MetaprogramImportNode> metaprogramImportList = new ArrayList<MetaprogramImportNode>();
        }
        @after {
            $importList = factory.makeImportListNode(importList);
            $metaprogramImportList = factory.makeMetaprogramImportListNode(metaprogramImportList);
            ruleStop();
        }
    :
        (
            importDeclaration
            {
                importList.add($importDeclaration.ret);
            }
        |
            metaprogramImport
            {
                metaprogramImportList.add($metaprogramImport.ret);
            }
        )*
    ;

importBody returns [boolean staticImport, boolean onDemand, NameNode name]
        scope Rule;
        @init {
            ruleStart("importBody");
        }
        @after {
            ruleStop();
        }
    :
        'static' typeName
        {
            $staticImport = true;
            $onDemand = false;
            $name = $typeName.ret;
        }
        (
            '.' '*'
            {
                $onDemand = true;
            }
        )?
    |
        packageOrTypeName '.' '*'
        {
            $staticImport = false;
            $onDemand = true;
            $name = $packageOrTypeName.ret;
        }
    |
        typeName
        {
            $staticImport = false;
            $onDemand = false;
            $name = $typeName.ret;
        }
    ;

importDeclaration returns [ImportNode ret]
        scope Rule;
        @init {
            ruleStart("importDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        'import'
        importBody
        ';'
        {
            if ($importBody.onDemand)
            {
                $ret = factory.makeImportOnDemandNode($importBody.name, $importBody.staticImport);
            } else
            {
                $ret = factory.makeImportSingleTypeNode($importBody.name, $importBody.staticImport);
            }
        }
    ;

javadoc returns [JavadocNode ret] // TODO: parse out Javadoc contents
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
                    $ret = factory.makeJavadocNode(parseJavadoc(token.getText()));
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

typeDeclarations returns [TypeDeclarationListNode ret]
        scope Rule;
        @init {
            ruleStart("typeDeclarations");
            List<TypeDeclarationNode> list = new ArrayList<TypeDeclarationNode>();
        }
        @after {
            $ret = factory.makeTypeDeclarationListNode(list);
            ruleStop();
        }
    :
        (
            typeDeclaration
            {
                list.add($typeDeclaration.ret);
            }
        )*
    ;

typeDeclaration returns [TypeDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("typeDeclaration");
        }
        @after {
            ruleStop();
        }
    :
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

noOp returns [NoOperationNode ret]
        scope Rule;
        @init {
            ruleStart("noOp");
        }
        @after {
            ruleStop();
        }
    :
        ';'
        {
            $ret = factory.makeNoOperationNode();
        }
    ;

classOrInterfaceDeclaration returns [TypeDeclarationNode ret]
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
    returns [ModifierSet modifiers, AccessModifier access, AnnotationListNode annotations]
        scope Rule;
        @init {
            ruleStart("classOrInterfaceDeclaration");
            List<AnnotationNode> annotationList = new ArrayList<AnnotationNode>();
            $access = AccessModifier.PACKAGE;
            $modifiers = new ModifierSet(mods);
            AccessModifier currentAccess = null;
            Modifier accessAsModifier = null;
        }
        @after {
            $annotations = factory.makeAnnotationListNode(annotationList);
            ruleStop();
        }
    :
        (
            annotation
            {
                annotationList.add($annotation.ret);
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
                            reportDiagnostic(new DuplicateModifierDiagnostic<JavaFileObject>(
                                    getLineNumber(-1),
                                    getColumnNumber(-1),
                                    resource,
                                    $Rule::name,
                                    currentAccess.toString().toLowerCase()));
                        } else
                        {
                            reportDiagnostic(new ConflictingAccessModifierDiagnostic<JavaFileObject>(
                                    getLineNumber(-1),
                                    getColumnNumber(-1),
                                    resource,
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

annotationMethodModifiers returns [AnnotationMethodModifiersNode ret]
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
            $ret = factory.makeAnnotationMethodModifiersNode($modifiers.annotations);
        }
    ;

annotationModifiers returns [AnnotationModifiersNode ret]
        scope Rule;
        @init {
            ruleStart("annotationModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.ABSTRACT, Modifier.STATIC, Modifier.STRICTFP]
        {
            $ret = factory.makeAnnotationModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.annotations);
        }
    ;
    
classModifiers returns [ClassModifiersNode ret]
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
            $ret = factory.makeClassModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.ABSTRACT),
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.annotations);
        }
    ;
    
constructorModifiers returns [ConstructorModifiersNode ret]
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
            $ret = factory.makeConstructorModifiersNode($modifiers.access, $modifiers.annotations);
        }
    ;
    
enumModifiers returns [EnumModifiersNode ret]
        scope Rule;
        @init {
            ruleStart("enumModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.STATIC, Modifier.STRICTFP]
        {
            $ret = factory.makeEnumModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.annotations);
        }
    ;
    
fieldModifiers returns [FieldModifiersNode ret]
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
            $ret = factory.makeFieldModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.TRANSIENT),
                    $modifiers.modifiers.has(Modifier.VOLATILE),
                    $modifiers.annotations);
        }
    ;
    
interfaceModifiers returns [InterfaceModifiersNode ret]
        scope Rule;
        @init {
            ruleStart("interfaceModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.ABSTRACT, Modifier.STATIC, Modifier.STRICTFP]
        {
            $ret = factory.makeInterfaceModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.annotations);
        }
    ;
    
methodModifiers returns [MethodModifiersNode ret]
        scope Rule;
        @init {
            ruleStart("methodModifiers");
        }
        @after {
            ruleStop();
        }
    :
        modifiers[true, Modifier.ABSTRACT, Modifier.STATIC, Modifier.FINAL, Modifier.SYNCHRONIZED, Modifier.NATIVE,
            Modifier.STRICTFP]
        {
            $ret = factory.makeMethodModifiersNode(
                    $modifiers.access,
                    $modifiers.modifiers.has(Modifier.ABSTRACT),
                    $modifiers.modifiers.has(Modifier.STATIC),
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.modifiers.has(Modifier.SYNCHRONIZED),
                    $modifiers.modifiers.has(Modifier.NATIVE),
                    $modifiers.modifiers.has(Modifier.STRICTFP),
                    $modifiers.annotations);
        }
    ;
    
variableModifiers returns [VariableModifiersNode ret]
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
            $ret = factory.makeVariableModifiersNode(
                    $modifiers.modifiers.has(Modifier.FINAL),
                    $modifiers.annotations);
        }
    ;

classDeclaration returns [InlineTypeDeclarableNode ret] 
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

normalClassDeclaration returns [ClassDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("normalClassDeclaration");
            DeclaredTypeListNode declaredTypeListNode = factory.makeDeclaredTypeListNode();
            TypeParameterListNode typeParamsNode = factory.makeTypeParameterListNode();
        }         
        @after {
            ruleStop();
        }
    :   
        javadoc classModifiers
        'class' id=identifier
        (
            typeParameters
            {
                typeParamsNode = $typeParameters.ret;
            }
        )?
        ('extends' classOrInterfaceType)?
        (
            'implements' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?            
        classBody
        {            
            $ret = factory.makeClassDeclarationNode(
                    $classModifiers.ret,
                    $classOrInterfaceType.ret,
                    declaredTypeListNode,
                    $classBody.ret,
                    typeParamsNode,                    
                    $id.ret,
                    $javadoc.ret);
        }
    ;


typeParameters returns [TypeParameterListNode ret]
        scope Rule;
        @init {
            ruleStart("typeParameters");
            List<TypeParameterNode> list = new ArrayList<TypeParameterNode>();
        }
        @after {
            $ret = factory.makeTypeParameterListNode(list);
            ruleStop();
        }
    :   
        '<'
            a=typeParameter
            {
                list.add($a.ret);
            }
            (',' b=typeParameter
                {
                    list.add($b.ret);
                }
            )*
        '>'
    ;


typeParameter returns [TypeParameterNode ret]
        scope Rule;
        @init {
            ruleStart("typeParameter");
            DeclaredTypeListNode typeBoundNode = factory.makeDeclaredTypeListNode(Collections.<DeclaredTypeNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :   
        id=identifier
        (
            'extends' typeBound
            {
                typeBoundNode = $typeBound.ret;
            }
        )?
        {
            $ret = factory.makeTypeParameterNode(
                        $id.ret,
                        typeBoundNode);
        }        
    ;


typeBound returns [DeclaredTypeListNode ret]
        scope Rule;
        @init {
            ruleStart("typeBound");
            List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
        }
        @after {
            $ret = factory.makeDeclaredTypeListNode(list);
            ruleStop();
        }
    :   
        a=classOrInterfaceType
        {
            list.add($a.ret);
        }
        (
            '&' b=classOrInterfaceType
            {
                list.add($b.ret);
            }
        )*
    ;


enumDeclaration returns [EnumDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("enumDeclaration");
            DeclaredTypeListNode declaredTypeListNode = factory.makeDeclaredTypeListNode();
        } 
        @after {
            ruleStop();
        }
    :   
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
            $ret = factory.makeEnumDeclarationNode(
                        $enumModifiers.ret,
                        declaredTypeListNode,
                        $enumBody.ret,
                        $id.ret,
                        $javadoc.ret);
        }
    ;


enumBody returns [EnumBodyNode ret]
        scope Rule;
        @init {
            ruleStart("enumBody");
            EnumConstantDeclarationListNode enumConstantsNode = factory.makeEnumConstantDeclarationListNode(
                    Collections.<EnumConstantDeclarationNode>emptyList());
            ClassMemberListNode enumBodyDeclarationsNode =
                    factory.makeClassMemberListNode(Collections.<ClassMemberNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :   
        '{'
        (
            enumConstants
            {
                enumConstantsNode = $enumConstants.ret;
            }
        )? 
        ','?
        (
            enumBodyDeclarations
            {
                enumBodyDeclarationsNode = $enumBodyDeclarations.ret;
            }
        )?
        '}'
        {
            $ret = factory.makeEnumBodyNode(
                    enumConstantsNode,
                    enumBodyDeclarationsNode);
        }
    ;

enumConstants returns [EnumConstantDeclarationListNode ret]
        scope Rule;
        @init {
            ruleStart("enumConstants");
            List<EnumConstantDeclarationNode> list = new ArrayList<EnumConstantDeclarationNode>();
        }
        @after {
            $ret = factory.makeEnumConstantDeclarationListNode(list);
            ruleStop();
        }
    :
        a=enumConstant
        {
            list.add($a.ret);
        }
        (
            ','
            b=enumConstant
            {
                list.add($b.ret);
            }
        )*
    ;

enumConstant returns [EnumConstantDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("enumConstant");
            AnnotationListNode annotationsNode = factory.makeAnnotationListNode(Collections.<AnnotationNode>emptyList());
            ExpressionListNode argumentsNode = factory.makeExpressionListNode(Collections.<ExpressionNode>emptyList());
            AnonymousClassBodyNode anonymousClassBodyNode = null;
        }
        @after {
            ruleStop();
        }
    :   
        javadoc
        (
            annotations
            {
                annotationsNode = $annotations.ret;
            }
        )?
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
            $ret = factory.makeEnumConstantDeclarationNode(
                annotationsNode,
                $id.ret,
                argumentsNode,
                anonymousClassBodyNode,
                $javadoc.ret);
        }
    ;

enumBodyDeclarations returns [ClassMemberListNode ret]
        scope Rule;
        @init {
            ruleStart("enumBodyDeclarations");
            List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();
        }
        @after {
            $ret = factory.makeClassMemberListNode(list);
            ruleStop();
        }
    :
        ';'
        (
            classBodyDeclaration
            {
                list.add($classBodyDeclaration.ret);
            }
        )*
    ;


interfaceDeclaration returns [TypeDeclarationNode ret] 
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
    
normalInterfaceDeclaration returns [InterfaceDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("normalInterfaceDeclaration");
            DeclaredTypeListNode declaredTypeListNode = factory.makeDeclaredTypeListNode();
            TypeParameterListNode typeParamsNode = factory.makeTypeParameterListNode();
        } 
        @after {
            ruleStop();
        }
    :   
        javadoc interfaceModifiers
        'interface' id=identifier
        (
            typeParameters
            {
                typeParamsNode = $typeParameters.ret;
            }
        )?
        (
            'extends' declaredTypeList
            {
                declaredTypeListNode = $declaredTypeList.ret;
            }
        )?        
        interfaceBody
        {
            $ret = factory.makeInterfaceDeclarationNode(
                    $interfaceModifiers.ret,
                    declaredTypeListNode,
                    $interfaceBody.ret,
                    typeParamsNode,
                    $id.ret,
                    $javadoc.ret);
        }
    ;

declaredTypeList returns [DeclaredTypeListNode ret]
        scope Rule;
        @init {
            ruleStart("typeList");
            List<DeclaredTypeNode> list = new ArrayList<DeclaredTypeNode>();
        }
        @after {
            $ret = factory.makeDeclaredTypeListNode(list);
            ruleStop();
        }
    :   
        a=classOrInterfaceType
        {
            list.add($a.ret);
        }
        (
            ',' b=classOrInterfaceType
            {
                list.add($b.ret);
            }
        )*
    ;

referenceTypeList returns [ReferenceTypeListNode ret]
        scope Rule;
        @init {
            ruleStart("typeList");
            List<ReferenceTypeNode> list = new ArrayList<ReferenceTypeNode>();
        }
        @after {
            $ret = factory.makeReferenceTypeListNode(list);
            ruleStop();
        }
    :   
        a=referenceType
        {
            list.add($a.ret);
        }
        (
            ',' b=referenceType
            {
                list.add($b.ret);
            }
        )*
    ;

typeList returns [TypeListNode ret]
        scope Rule;
        @init {
            ruleStart("typeList");
            List<TypeNode> list = new ArrayList<TypeNode>();
        }
        @after {
            $ret = factory.makeTypeListNode(list);
            ruleStop();
        }
    :   
        a=type
        {
            list.add($a.ret);
        }
        (
            ',' b=type
            {
                list.add($b.ret);
            }
        )*
    ;

classBody returns [ClassBodyNode ret]
        scope Rule;
        @init {
            ruleStart("classBody");
            List<ClassMemberNode> list = new ArrayList<ClassMemberNode>();
        }
        @after {
            $ret = factory.makeClassBodyNode(factory.makeClassMemberListNode(list));
            ruleStop();
        }
    :   
        '{' 
        (
            classBodyDeclaration
            {
                list.add($classBodyDeclaration.ret);
            }
        )* 
        '}'
    ;

anonymousClassBody returns [AnonymousClassBodyNode ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassBody");
            List<AnonymousClassMemberNode> list = new ArrayList<AnonymousClassMemberNode>();
        }
        @after {
            $ret = factory.makeAnonymousClassBodyNode(factory.makeAnonymousClassMemberListNode(list));
            ruleStop();
        }
    :   
        '{' 
        (
            anonymousClassBodyDeclaration
            {
                list.add($anonymousClassBodyDeclaration.ret);
            }
        )* 
        '}'
    ;

interfaceBody returns [InterfaceBodyNode ret]
        scope Rule;
        @init {
            ruleStart("interfaceBody");
            List<InterfaceMemberNode> list = new ArrayList<InterfaceMemberNode>();
        }
        @after {
            $ret = factory.makeInterfaceBodyNode(factory.makeInterfaceMemberListNode(list));
            ruleStop();
        }
    :   
        '{' 
        (
            interfaceBodyDeclaration
            {
                list.add($interfaceBodyDeclaration.ret);
            }        
        )* 
        '}'
    ;

initializerBlock returns [InitializerDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("initializerBlock");
        }
        @after {
            ruleStop();
        }
    :
        staticText='static'?
        block
        {
            $ret = factory.makeInitializerDeclarationNode(
                    $staticText!=null,
                    $block.ret);
        }
    ;
    
classBodyDeclaration returns [ClassMemberNode ret]
        scope Rule;
        @init {
            ruleStart("classBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
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

anonymousClassBodyDeclaration returns [AnonymousClassMemberNode ret]
        scope Rule;
        @init {
            ruleStart("anonymousClassBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
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

memberDecl returns [AnonymousClassMemberNode ret]
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

methodReturnType returns [TypeNode ret]
        scope Rule;
        @init {
            ruleStart("methodReturnType");
        }
        @after {
            ruleStop();
        }
    :
        type
        {
            $ret = $type.ret;
        }
    |
        'void'
        {
            $ret = factory.makeVoidTypeNode();
        }
    ;

constructorDeclaration returns [ConstructorDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("constructorDeclaration");
            TypeParameterListNode typeParametersNode =
                    factory.makeTypeParameterListNode(Collections.<TypeParameterNode>emptyList());
            UnparameterizedTypeListNode throwsNode = factory.makeUnparameterizedTypeListNode(Collections.<UnparameterizedTypeNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :
        javadoc constructorModifiers
        (
            typeParameters
            {
                typeParametersNode = $typeParameters.ret;
            }
        )?
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
            $ret = factory.makeConstructorDeclarationNode(
                $identifier.ret,
                $constructorBody.ret,
                $constructorModifiers.ret,
                $formalParameters.parameters,
                $formalParameters.varargParameter,
                throwsNode,
                typeParametersNode,
                $javadoc.ret);
        }
    ;

constructorBody returns [ConstructorBodyNode ret]
        scope Rule;
        @init {
            ruleStart("constructorBody");
            BlockStatementListNode listNode = null;
            ConstructorInvocationNode constructorInvocationNode = null;
        }
        @after {
            $ret = factory.makeConstructorBodyNode(
                    constructorInvocationNode,
                    listNode);
            ruleStop();
        }
    :
        '{' 
        (
            explicitConstructorInvocation
            {
                constructorInvocationNode = $explicitConstructorInvocation.ret;
            }
        )?
        blockStatementList
        {
            listNode = $blockStatementList.ret;
        }
        '}'
    ;

methodDeclaration returns [MethodDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("methodDeclaration");
            BlockNode blockNode = null;
            TypeParameterListNode typeParametersNode =
                    factory.makeTypeParameterListNode(Collections.<TypeParameterNode>emptyList());
            UnparameterizedTypeListNode throwsNode = factory.makeUnparameterizedTypeListNode(Collections.<UnparameterizedTypeNode>emptyList());
            TypeNode returnTypeNode = null;
        }
        @after {
            ruleStop();
        }
    :
        javadoc methodModifiers
        (
            typeParameters
            {
                typeParametersNode = $typeParameters.ret;
            }
        )?
        methodReturnType
        {
            returnTypeNode = $methodReturnType.ret;
        }
        id=identifier
        formalParameters
        (
            arrayTypeIndicator[returnTypeNode]
            {
                returnTypeNode = $arrayTypeIndicator.ret;
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
                blockNode = $block.ret;
            }
        |
            ';' 
        )
        {
            $ret = factory.makeMethodDeclarationNode(
                    blockNode,
                    $methodModifiers.ret,
                    $id.ret,
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    returnTypeNode,
                    throwsNode,
                    typeParametersNode,
                    $javadoc.ret);
        }        
    ;

fieldDeclaration returns [FieldDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("fieldDeclaration");
            List<VariableDeclaratorNode> list = new ArrayList<VariableDeclaratorNode>();
        }
        @after {
            ruleStop();
        }
    :   
        javadoc fieldModifiers
        type
        a=variableDeclarator[$type.ret] // process type in case identifier has [] after it
        {
            list.add($a.ret);
        }
        (
            ',' b=variableDeclarator[$type.ret]
            {
                list.add($b.ret);
            }
        )*
        ';'
        {
            $ret = factory.makeFieldDeclarationNode(
                    $fieldModifiers.ret,
                    factory.makeVariableDeclaratorListNode(list),
                    $javadoc.ret);
        }
    ;

interfaceBodyDeclaration returns [InterfaceMemberNode ret]
        scope Rule;
        @init {
            ruleStart("interfaceBodyDeclaration");
        }
        @after {
            ruleStop();
        }
    :
        interfaceFieldDeclaration
        {
            $ret = $interfaceFieldDeclaration.ret;
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

interfaceMethodDeclaration returns [MethodDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("interfaceMethodDeclaration");
            TypeNode returnTypeNode = null;
            UnparameterizedTypeListNode throwsNode = factory.makeUnparameterizedTypeListNode(Collections.<UnparameterizedTypeNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :   
        javadoc methodModifiers
        typeParameters?
        methodReturnType
        {
            returnTypeNode = $methodReturnType.ret;
        }
        id=identifier
        formalParameters
        (
            arrayTypeIndicator[returnTypeNode]
            {
                returnTypeNode = $arrayTypeIndicator.ret;
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
            $ret = factory.makeMethodDeclarationNode(
                    null, // No body for interface methods; thus null
                    $methodModifiers.ret,
                    $id.ret,
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    returnTypeNode,
                    throwsNode,
                    $typeParameters.ret,
                    $javadoc.ret);
        }         
    ;

interfaceFieldDeclaration returns [FieldDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("interfaceFieldDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        fieldDeclaration
        {
            $ret = $fieldDeclaration.ret;
        }
    ;

throwsClause returns [UnparameterizedTypeListNode ret]
        scope Rule;
        @init {
            ruleStart("throwsClause");
            List<UnparameterizedTypeNode> list = new ArrayList<UnparameterizedTypeNode>();
        }
        @after {
            $ret = factory.makeUnparameterizedTypeListNode(list);
            ruleStop();
        }
    :
        THROWS
        a=typeName
        {
            list.add(factory.makeUnparameterizedTypeNode($a.ret));
        }
        (
            ',' b=typeName
            {
                list.add(factory.makeUnparameterizedTypeNode($b.ret));
            }
        )*
    ;

referenceType returns [ReferenceTypeNode ret]
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
            arrayTypeIndicator[ret]
            {
                $ret = $arrayTypeIndicator.ret;
            }
        )?
    |
        primitiveType arrayTypeIndicator[$primitiveType.ret]
        {
            $ret = $arrayTypeIndicator.ret;
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
type returns [TypeNode ret]
        scope Rule;
        @init {
            ruleStart("type");
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
        (
            arrayTypeIndicator[ret]
            {
                $ret = $arrayTypeIndicator.ret;
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
classOrInterfaceType returns [DeclaredTypeNode ret]
        scope Rule;
        @init {
            ruleStart("classOrInterfaceType");
            UnparameterizedTypeNode unparameterizedTypeNode = null;
            ParameterizedTypeNode parameterizedTypeNode = null;
        }
        @after {
            ruleStop();
        }
    :
        typeName
        {
            unparameterizedTypeNode = factory.makeUnparameterizedTypeNode($typeName.ret);
            $ret = unparameterizedTypeNode;
        }
        (
            typeArguments
            {
                parameterizedTypeNode = factory.makeParameterizedTypeNode(unparameterizedTypeNode, $typeArguments.ret);
                $ret = parameterizedTypeNode;
            }
            (
                '.' next=classOrInterfaceType
                {
                    $ret = factory.makeParameterizedTypeSelectNode(parameterizedTypeNode, $next.ret);
                }
            )?
        )?
    ;

// Parses a primitive type.
// For example, in
//     boolean b = true;
// this rule matches
//     boolean
primitiveType returns [PrimitiveTypeNode ret]
        scope Rule;
        @init {
            ruleStart("primitiveType");
            PrimitiveType temp = null;
        }
        @after {
            $ret = factory.makePrimitiveTypeNode(temp);
            ruleStop();
        }
    :   
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
// this node would parse
//     <K,V>
typeArguments returns [TypeArgumentListNode ret]
        scope Rule;
        @init {
            ruleStart("typeArguments");
            List<TypeArgumentNode> list = new ArrayList<TypeArgumentNode>();
        }
        @after {
            $ret = factory.makeTypeArgumentListNode(list);
            ruleStop();
        }
    :   
        '<' a=typeArgument
        {
            list.add($a.ret);
        }
        (
            ',' b=typeArgument
            {
                list.add($b.ret);
            }
        )* 
        '>'
    ;

// Parses a single type argument for a declared type.
// For example, in
//     Map.Entry<K,V> entry;
// this node would parse either K or V.  Also, in
//     Foo<? extends Bar>
// this node would parse
//     ? extends Bar
typeArgument returns [TypeArgumentNode ret]
        scope Rule;
        @init {
            ruleStart("typeArgument");
            boolean upper = false;
        } 
        @after {
            ruleStop();
        }
    :
        unboundedType=referenceType
        {
            $ret = $unboundedType.ret;
        }
    |   
        '?'
        {
            $ret = factory.makeWildcardTypeNode(null, false);
        }
    |
        '?'
        (
            'extends' { upper = true; }
        |
            SUPER { upper = false; }
        )
        boundedType=referenceType
        {
            $ret = factory.makeWildcardTypeNode($boundedType.ret, upper);
        }
    ;

// Matches a formal parameter list.
// For example, in
//     public void foo(int x, int y)
// this rule matches
//     (int x, int y)
formalParameters returns [VariableListNode parameters, VariableNode varargParameter]
        scope Rule;
        @init {
            ruleStart("formalParameters");
            $parameters = factory.makeVariableListNode(Collections.<VariableNode>emptyList());
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
formalParameterDecls returns [VariableListNode parameters, VariableNode varargParameter]
        scope Rule;
        @init {
            ruleStart("formalParameterDecls");
            List<VariableNode> list = new ArrayList<VariableNode>();
        }
        @after {
            $parameters = factory.makeVariableListNode(list);
            ruleStop();
        }
    :
        ellipsisParameterDecl
        {
            $varargParameter = $ellipsisParameterDecl.ret;
        }
    |
        a=normalParameterDecl
        {
            list.add($a.ret);
        }
        (
            ',' b=normalParameterDecl
            {
                list.add($b.ret);
            }
        )*
        {
            $varargParameter = null;
        }
    |
        (
            normalParameterDecl
            {
                list.add($normalParameterDecl.ret);
            }
            ','
        )+
        ellipsisParameterDecl
        {
            $varargParameter = $ellipsisParameterDecl.ret;
        }
    ;

normalParameterDecl returns [VariableNode ret]
        scope Rule;
        @init {
            ruleStart("normalParameterDecl");
            TypeNode typeNode = null;
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
        id=identifier
        (
            arrayTypeIndicator[typeNode]
            {
                typeNode = $arrayTypeIndicator.ret;
            }
        )?
        {
            $ret = factory.makeVariableNode($mod.ret, $t.ret, $id.ret);
        }
    ;

ellipsisParameterDecl returns [VariableNode ret]
        scope Rule;
        @init {
            ruleStart("ellipsisParameterDecl");
        }
        @after {
            ruleStop();
        }
    :
        mod=variableModifiers t=type '...' id=identifier
        {
            $ret = factory.makeVariableNode($mod.ret, $t.ret, $id.ret);
        }
    ;

alternateConstructorInvocation returns [AlternateConstructorInvocationNode ret]
        scope Rule;
        @init {
            ruleStart("alternateConstructorInvocation");
        }
        @after {
            ruleStop();
        }
    :
        nonWildcardTypeArguments? 'this' arguments ';'
        {
            $ret = factory.makeAlternateConstructorInvocationNode(
                        $arguments.ret,
                        $nonWildcardTypeArguments.ret);
        }
    ;

superclassConstructorInvocation returns [SuperclassConstructorInvocationNode ret]
        scope Rule;
        @init {
            ruleStart("superclassConstructorInvocation");
            PrimaryExpressionNode qualifyingExpression = null;
            ReferenceTypeListNode typeArgumentsNode = factory.makeReferenceTypeListNode();
        }
        @after {
            ruleStop();
        }
    :
        (
            primary '.'
            {
                qualifyingExpression = $primary.ret;
            }
        )?
        (
            nonWildcardTypeArguments
            {
                typeArgumentsNode = $nonWildcardTypeArguments.ret;
            }
        )?
        SUPER arguments ';'
        {
            $ret = factory.makeSuperclassConstructorInvocationNode(
                        qualifyingExpression,
                        $arguments.ret,
                        typeArgumentsNode);
        }
    ;

explicitConstructorInvocation returns [ConstructorInvocationNode ret]
        scope Rule;
        @init {
            ruleStart("explicitConstructorInvocation");
        }
        @after {
            ruleStop();
        }
    :
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

annotations returns [AnnotationListNode ret]
        scope Rule;
        @init {
            ruleStart("annotations");
            List<AnnotationNode> list = new ArrayList<AnnotationNode>();
        }
        @after {
            $ret = factory.makeAnnotationListNode(list);
            ruleStop();
        }
    :   
        (
            annotation
            {
                list.add($annotation.ret);
            }
        )+
    ;

// Parses an annotation.
// For example, in
//     @Test("foo")
//     public void foo() { }
// This rule would parse
//     @Test("foo")
annotation returns [AnnotationNode ret]
        scope Rule;
        @init {
            ruleStart("annotation");
        }
        @after {
            ruleStop();
        }
    :   
        '@' typeName
        {
            $ret = factory.makeNormalAnnotationNode(
                    factory.makeAnnotationElementListNode(new ArrayList<AnnotationElementNode>()),
                    factory.makeUnparameterizedTypeNode($typeName.ret));
        }
        (
            '('   
            (
                elementValuePairs
                {
                    $ret = factory.makeNormalAnnotationNode(
                            $elementValuePairs.ret,
                            factory.makeUnparameterizedTypeNode($typeName.ret));
                }
            |
                elementValue
                {
                    $ret = factory.makeSingleElementAnnotationNode(
                            $elementValue.ret,
                            factory.makeUnparameterizedTypeNode($typeName.ret));
                }
            )? 
            ')' 
        )?
    ;

// Parses an annotation's element-value pairs.
// For example, in
//     @Foo(bar="baz",happy=5)
// this rule would parse
//     bar="baz",happy=5
elementValuePairs returns [AnnotationElementListNode ret]
        scope Rule;
        @init {
            ruleStart("elementValuePairs");
            List<AnnotationElementNode> list = new ArrayList<AnnotationElementNode>();
        }
        @after {
            $ret = factory.makeAnnotationElementListNode(list);
            ruleStop();
        }
    :
        a=elementValuePair
        {
            list.add($a.ret);
        }
        (
            ','
            b=elementValuePair
            {
                list.add($b.ret);
            }
        )*
    ;

// Parses a single annotation element-value pair.
// For example, in
//     @Foo(bar="baz",happy=5)
// this rule would parse either
//     bar="baz"
// or
//     happy=5
elementValuePair returns [AnnotationElementNode ret]
        scope Rule;
        @init {
            ruleStart("elementValuePair");
        }
        @after {
            ruleStop();
        }
    :
        id=identifier '=' elementValue
        {
            $ret = factory.makeAnnotationElementNode($id.ret, $elementValue.ret);
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
elementValue returns [AnnotationValueNode ret]
        scope Rule;
        @init {
            ruleStart("elementValue");
        }
        @after {
            ruleStop();
        }
    :   
        conditionalExpression
        {
            $ret = factory.makeAnnotationExpressionValueNode($conditionalExpression.ret);
        }
    |   
        annotation
        {
            $ret = factory.makeAnnotationAnnotationValueNode($annotation.ret);
        }
    |   
        elementValueArrayInitializer
        {
            $ret = $elementValueArrayInitializer.ret;
        }
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
elementValueArrayInitializer returns [AnnotationArrayValueNode ret]
        scope Rule;
        @init {
            ruleStart("elementValueArrayInitializer");
            List<AnnotationValueNode> list = new ArrayList<AnnotationValueNode>();
        }
        @after {
            $ret = factory.makeAnnotationArrayValueNode(factory.makeAnnotationValueListNode(list));
            ruleStop();
        }
    :   
        '{'
        (
            a=elementValue
            {
                list.add($a.ret);
            }
            (
                ',' b=elementValue
                {
                    list.add($b.ret);
                }
            )*
        )?
        ','?
        '}'
    ;

/**
 * Annotation declaration.
 */
annotationTypeDeclaration returns [AnnotationDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeDeclaration");
        }
        @after {
            ruleStop();
        }
    :   
        javadoc annotationModifiers '@'
        'interface'
        id=identifier
        annotationTypeBody
        {
            $ret = factory.makeAnnotationDeclarationNode(
                $annotationModifiers.ret,
                $annotationTypeBody.ret,
                $id.ret,
                $javadoc.ret);
        }
    ;


annotationTypeBody returns [AnnotationBodyNode ret]
        scope Rule;
        @init {
            ruleStart("annotationTypeBody");
            List<AnnotationMemberNode> list = new ArrayList<AnnotationMemberNode>();
        }
        @after {
            $ret = factory.makeAnnotationBodyNode(factory.makeAnnotationMemberListNode(list));
            ruleStop();
        }
    :   
        '{' 
        (
            annotationTypeElementDeclaration
            {
                list.add($annotationTypeElementDeclaration.ret);
            }
        )* 
        '}'
    ;

annotationTypeElementDeclaration returns [AnnotationMemberNode ret]
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
        interfaceFieldDeclaration
        {
            $ret = $interfaceFieldDeclaration.ret;
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

annotationMethodDeclaration returns [AnnotationMethodDeclarationNode ret]
        scope Rule;
        @init{
            ruleStart("annotationMethodDeclaration");
            AnnotationValueNode elementValueNode = null;
        }
        @after {
            ruleStop();
        }
    :   
        javadoc annotationMethodModifiers
        type
        id=identifier
        '(' ')'
        (
            'default' 
            elementValue
            {
                elementValueNode = $elementValue.ret;
            }
        )?
        ';'
        {
            $ret = factory.makeAnnotationMethodDeclarationNode(
                $annotationMethodModifiers.ret,
                $type.ret,
                $id.ret,
                elementValueNode,
                $javadoc.ret);
        }
        ;

block returns [BlockNode ret]
        scope Rule;
        @init {
            ruleStart("block");
        }
        @after {
            ruleStop();
        }
    :   
        '{'
        blockStatementList
        '}'
        {
            $ret = factory.makeBlockNode($blockStatementList.ret);
        }
    ;

blockStatementList returns [BlockStatementListNode ret]
        scope Rule;
        @init {
            ruleStart("blockStatementList");
            List<BlockStatementNode> list = new ArrayList<BlockStatementNode>();
        }
        @after {
            $ret = factory.makeBlockStatementListNode(list);
            ruleStop();
        }
    :
        (
            blockStatement
            {
                list.add($blockStatement.ret);
            }
        )*
    ;

// Parses a statement from a block of statements.
blockStatement returns [BlockStatementNode ret]
        scope Rule;
        @init {
            ruleStart("blockStatement");
        }
        @after {
            ruleStop();
        }
    :   
        (localVariableHeader)=>localVariableDeclarationStatement
        {
            $ret = $localVariableDeclarationStatement.ret;
        }
    |   
        (typeHeader)=>classDeclaration
        {
            $ret = factory.makeInlineTypeDeclarationNode($classDeclaration.ret);
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
localVariableDeclarationStatement returns [VariableDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("localVariableDeclarationStatement");
        }
        @after {
            ruleStop();
        }
    :
        localVariableDeclaration ';'
        {
            $ret = $localVariableDeclaration.ret;
        }
    ;

// Parses a local variable declaration.  Note that local variable declarations may declare multiple variables.
// For example, this rule would match
//     int x = 5, y
// Note the absence of a semicolon.
localVariableDeclaration returns [VariableDeclarationNode ret]
        scope Rule;
        @init {
            ruleStart("localVariableDeclaration");
            List<VariableDeclaratorNode> list = new ArrayList<VariableDeclaratorNode>();
        }
        @after {
            ruleStop();
        }
    :   
        variableModifiers type
        a=variableDeclarator[$type.ret]
        {
            list.add($a.ret); 
        }
        (
            ',' b=variableDeclarator[$type.ret]
            {
                list.add($b.ret); 
            }
        )*
        {
            $ret = factory.makeVariableDeclarationNode(
                    $variableModifiers.ret,
                    factory.makeVariableDeclaratorListNode(list));
        }
    ;

statement returns [StatementNode ret]
        scope Rule;
        @init{
            ruleStart("statement");
            IdentifierNode idNode = null;
            ExpressionNode expNode = null;
            StatementNode stmtNode = null;
        }
        @after {
            ruleStop();
        }
    :   
        block
        {
            $ret = $block.ret;
        }
    |   
        'assert' e1=expression 
        (
            ':' e2=expression
            {
                expNode = $e2.ret;
            }
        )? ';'   
        {
            $ret = factory.makeAssertStatementNode(
                $e1.ret,
                expNode);
        }        
    |   
        'if' parExpression s1=statement 
        (
            'else' s2=statement
            {
                stmtNode = $s2.ret;
            }
        )?    
        {
            $ret = factory.makeIfNode(
                $parExpression.ret,
                $s1.ret,
                stmtNode);
        }   
    |   
        forstatement
        {
            $ret = $forstatement.ret;
        }
    |   
        'while' parExpression s=statement
        {
            $ret = factory.makeWhileLoopNode(
                $parExpression.ret,
                $s.ret);
        }
    |   
        'do' s=statement 'while' parExpression ';'
        {
            $ret = factory.makeDoWhileLoopNode(
                $parExpression.ret,
                $s.ret);
        }
    |   
        trystatement
        {
            $ret = $trystatement.ret;
        }
    |   
        'switch' parExpression '{' switchBlockStatementGroups '}'
        {
            $ret = factory.makeSwitchNode(
                $parExpression.ret,
                $switchBlockStatementGroups.ret);
        }
    |   
        'synchronized' parExpression block
        {
            $ret = factory.makeSynchronizedNode(
                $parExpression.ret,
                $block.ret);
        }
    |   
        'return' 
        (
            expression
            {
                expNode = $expression.ret;
            }
        )? ';'
        {
            $ret = factory.makeReturnNode(expNode);
        }
    |   
        'throw' expression ';'
        {
            $ret = factory.makeThrowNode(
                $expression.ret);
        }
    |   
        'break'
        (
            id=identifier
            {
                idNode = $id.ret;
            }
        )? ';'
        {
            $ret = factory.makeBreakNode(idNode);
        }
    |   
        'continue' 
        (
            id=identifier
            {
                idNode = $id.ret;
            }
        )? ';'
        {
            $ret = factory.makeContinueNode(idNode);
        }
    |   
        statementExpression  ';'  
        {
            $ret = factory.makeExpressionStatementNode($statementExpression.ret);
        }   
    |   
        a=identifier ':' s=statement
        {
            $ret = factory.makeLabeledStatementNode(
                $a.ret,
                $s.ret);
        }
    |   
        noOp
        {
            $ret = $noOp.ret;
        }
    ;

switchBlockStatementGroups returns [CaseListNode ret]
        scope Rule;
        @init {
            ruleStart("switchBlockStatementGroups");
            List<CaseNode> list = new ArrayList<CaseNode>();
        }
        @after {
            $ret = factory.makeCaseListNode(list);
            ruleStop();
        }
    :   
        (
            switchBlockStatementGroup 
            {
                list.add($switchBlockStatementGroup.ret);
            }   
        )*
    ;

switchBlockStatementGroup returns [CaseNode ret]
        scope Rule;
        @init {
            ruleStart("switchBlockStatementGroup");
            BlockStatementListNode listNode = null;
            ExpressionNode label = null;
        }
        @after {
            $ret = factory.makeCaseNode(label, listNode);
            ruleStop();
        }
    :
        switchLabel
        {
            label = $switchLabel.ret;
        }
        blockStatementList
        {
            listNode = $blockStatementList.ret;
        }
    ;

switchLabel returns [ExpressionNode ret]
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


trystatement returns [TryNode ret]
        scope Rule;
        @init {
            ruleStart("trystatement");
            CatchListNode catchList = factory.makeCatchListNode(new ArrayList<CatchNode>());
            BlockNode finallyBlock = null;
        }    
        @after {
            ruleStop();
        }
    :   
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
            }            
        |   
            'finally' fb=block
            {
                finallyBlock = $fb.ret;
            }            
        )
        {
            $ret = factory.makeTryNode(
                    $b.ret,
                    catchList,
                    finallyBlock);
        }        
    ;

catches returns [CatchListNode ret]
        scope Rule;
        @init {
            ruleStart("catches");
            List<CatchNode> list = new ArrayList<CatchNode>();
        }
        @after {
            $ret = factory.makeCatchListNode(list);
            ruleStop();
        }
    :   
        a=catchClause
        {
            list.add($a.ret);
        }
        (
            b=catchClause
            {
                list.add($b.ret);
            }
        )*
    ;

catchClause returns [CatchNode ret]
        scope Rule;
        @init {
            ruleStart("catchClause");
        }
        @after {
            ruleStop();
        }
    :   
        'catch' '(' formalParameter ')'
        block
        {
            $ret = factory.makeCatchNode(
                    $block.ret,
                    $formalParameter.ret);
        }
    ;

// Parses the formal parameter of a catch block.
// For example, in
//     try { ... } catch (IOException e) { ... }
// this rule would match
//     IOException e
formalParameter returns [VariableNode ret]
        scope Rule;
        @init {
            ruleStart("formalParameter");
            TypeNode typeNode = null;
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
            arrayTypeIndicator[typeNode]
            {
                typeNode = $arrayTypeIndicator.ret;
            }
        )?
        {
            $ret = factory.makeVariableNode(
                $variableModifiers.ret, 
                typeNode,
                $id.ret);
        }
    ;

forstatement returns [StatementNode ret]
        scope Rule;
        @init{
            ruleStart("forstatement");
            ForInitializerNode forInitNode = null;
            ExpressionNode expNode = null;
            StatementExpressionListNode expListNode =
                    factory.makeStatementExpressionListNode(Collections.<StatementExpressionNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :   
        // enhanced for loop
        'for' '(' variableModifiers type id=identifier ':' 
        expression ')' statement
        {
            $ret = factory.makeEnhancedForLoopNode(
                factory.makeVariableNode(
                    $variableModifiers.ret, 
                    $type.ret,
                    $id.ret),
                $expression.ret,
                $statement.ret);
        }        
    |   
        // normal for loop
        'for' '(' 
        (
            forInit
            {
                forInitNode = $forInit.ret;
            }
        )? ';' 
        (
            expression
            {
                expNode = $expression.ret;
            }
        )? ';' 
        (
            statementExpressionList
            {
                expListNode = $statementExpressionList.ret;
            }
        )?
        ')'
        statement
        {
            $ret = factory.makeForLoopNode(
                    forInitNode, 
                    expNode,
                    expListNode,
                    $statement.ret);
        }                 
    ;

// Parses the initializer for a standard for loop.  This may either be a list of variable declarations or a list of
// initialization expressions.
forInit returns [ForInitializerNode ret]
        scope Rule;
        @init {
            ruleStart("forInit");
        }
        @after {
            ruleStop();
        }
    :   
        localVariableDeclaration
        {
            $ret = factory.makeForInitializerDeclarationNode($localVariableDeclaration.ret);
        }
    |   
        statementExpressionList
        {
            $ret = factory.makeForInitializerExpressionNode($statementExpressionList.ret);
        }
    ;

parExpression returns [ExpressionNode ret]
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

statementExpressionList returns [StatementExpressionListNode ret]
        scope Rule;
        @init {
            ruleStart("statementExpressionList");
            List<StatementExpressionNode> list = new ArrayList<StatementExpressionNode>();
        }
        @after {
            $ret = factory.makeStatementExpressionListNode(list);
            ruleStop();
        }
    :   
        a=statementExpression
        {
            list.add($a.ret);
        }
        (
            ',' b=statementExpression
            {
                list.add($b.ret);
            }
        )*
    ;

expressionList returns [ExpressionListNode ret]
        scope Rule;
        @init {
            ruleStart("expressionList");
            List<ExpressionNode> list = new ArrayList<ExpressionNode>();
        }
        @after {
            $ret = factory.makeExpressionListNode(list);
            ruleStop();
        }
    :   
        a=expression
        {
            list.add($a.ret);
        }
        (
            ',' b=expression
            {
                list.add($b.ret);
            }
        )*
    ;

/* This rule parses a statement expression.  A statement expression is one of those types of expressions which may be
 * used as a statement (such as x++) but not any other kind of expression (such as ~x). */
statementExpression returns [StatementExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("statementExpression");
        }
        @after {
            ruleStop();
        }
    :
        // Okay, this is a bit hacky but seriously reduces duplication as well as maintenance.
        // We'll just grab any expression we can.  If it's not a statement expression, we raise a RecognitionException.
        expression
        {
            if ($expression.ret instanceof StatementExpressionNode)
            {
                $ret = (StatementExpressionNode)($expression.ret);
            } else
            {
                // TODO: replace with BSJ exception
                throw new FailedPredicateException(input, "statementExpression",
                        "$expression.ret instanceof StatementExpressionNode ");
            }
        }
    ;

expression returns [ExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("expression");
        }
        @after {
            ruleStop();
        }
    :   
        conditionalExpression
        {
            $ret = $conditionalExpression.ret;
        }
        (
            assignmentOperator
            e=expression
            {
                $ret = factory.makeAssignmentNode(
                        $ret,
                        $assignmentOperator.ret,
                        $e.ret);
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


conditionalExpression returns [NonAssignmentExpressionNode ret]
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
                $ret = factory.makeConditionalExpressionNode(
                    $ret, 
                    $e1.ret, 
                    $e2.ret);
            }
        )?
    ;

conditionalOrExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("conditionalOrExpression");
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
            '||' e2=conditionalAndExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.CONDITIONAL_OR);
            }            
        )*
    ;

conditionalAndExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("conditionalAndExpression");
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
            '&&' e2=inclusiveOrExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.CONDITIONAL_AND);
            }             
        )*
    ;

inclusiveOrExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("inclusiveOrExpression");
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
            '|' e2=exclusiveOrExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.LOGICAL_OR);
            }             
        )*
    ;

exclusiveOrExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("exclusiveOrExpression");
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
            '^' e2=andExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.XOR);
            }            
        )*
    ;

andExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("andExpression");
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
            '&' e2=equalityExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.LOGICAL_AND);
            }              
        )*
    ;

equalityExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init{
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
            (   '=='
                {
                    op = BinaryOperator.EQUAL;
                }
            |   '!='
                {
                    op = BinaryOperator.NOT_EQUAL;
                }            
            )
            e2=instanceOfExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    op);
            }             
        )*
    ;

instanceOfExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("instanceOfExpression");
        }
        @after {
            ruleStop();
        }
    :   
        e1=relationalExpression
        {
            $ret = $e1.ret;
        }        
        (
            'instanceof' t1=type
            {
                $ret = factory.makeInstanceOfNode(
                    $ret, 
                    $t1.ret);
            }        
        )?
    ;

relationalExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("relationalExpression");
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
            op=relationalOp e2=shiftExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    $op.ret);
            }             
        )*
    ;

relationalOp returns [BinaryOperator ret]
        scope Rule;
        @init {
            ruleStart("relationalOp");
        }
        @after {
            ruleStop();
        }
    :    
        '<' '='
        {
            $ret = BinaryOperator.LESS_THAN_EQUAL;
        }         
    |   
        '>' '='
        {
            $ret = BinaryOperator.GREATER_THAN_EQUAL;
        }         
    |   
        '<'
        {
            $ret = BinaryOperator.LESS_THAN;
        }         
    |   
        '>'
        {
            $ret = BinaryOperator.GREATER_THAN;
        }         
    ;

shiftExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("shiftExpression");
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
            op=shiftOp e2=additiveExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    $op.ret);
            }            
        )*
    ;


shiftOp returns [BinaryOperator ret]
        scope Rule;
        @init {
            ruleStart("shiftOp");
        }
        @after {
            ruleStop();
        }
    :    
        '<' '<'
        {
            $ret = BinaryOperator.LEFT_SHIFT;
        }         
    |   
        '>' '>' '>'
        {
            $ret = BinaryOperator.UNSIGNED_RIGHT_SHIFT;
        }         
    |   
        '>' '>'
        {
            $ret = BinaryOperator.RIGHT_SHIFT;
        }        
    ;


additiveExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init{
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
            (   '+'
                {
                    op = BinaryOperator.PLUS;
                }
            |   '-'
                {
                    op = BinaryOperator.MINUS;
                }            
            )
            e2=multiplicativeExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    op);
            }             
        )*
    ;

multiplicativeExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init{
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
            (   '*'
                {
                    op = BinaryOperator.MULTIPLY;
                }            
            |   '/'
                {
                    op = BinaryOperator.DIVIDE;
                }            
            |   '%'
                {
                    op = BinaryOperator.MODULUS;
                }            
            )
            e2=unaryExpression
            {
                $ret = factory.makeBinaryExpressionNode(
                    $ret, 
                    $e2.ret, 
                    op);
            }            
        )*
    ;

/**
 * NOTE: for '+' and '-', if the next token is int or long literal, then it's not a unary expression.
 *       it's a literal with signed value. INTLITERAL AND LONG LITERAL are added here for this.
 */
unaryExpression returns [NonAssignmentExpressionNode ret]
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
            $ret = factory.makeUnaryExpressionNode(
                $e.ret,
                UnaryOperator.UNARY_PLUS);
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
            $ret = factory.makeUnaryExpressionNode(
                $e.ret,
                UnaryOperator.UNARY_MINUS);
        }        
    |   
        '++' e=unaryExpression
        {
            $ret = factory.makeUnaryStatementExpressionNode(
                $e.ret,
                UnaryStatementOperator.PREFIX_INCREMENT);
        }
    |   
        '--' e=unaryExpression
        {
            $ret = factory.makeUnaryStatementExpressionNode(
                $e.ret,
                UnaryStatementOperator.PREFIX_DECREMENT);
        }        
    |   
        unaryExpressionNotPlusMinus
        {
            $ret = $unaryExpressionNotPlusMinus.ret;
        }
    ;

unaryExpressionNotPlusMinus returns [NonAssignmentExpressionNode ret]
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
            $ret = factory.makeUnaryExpressionNode(
                $unaryExpression.ret,
                UnaryOperator.BITWISE_COMPLEMENT);
        }        
    |   
        '!' unaryExpression
        {
            $ret = factory.makeUnaryExpressionNode(
                $unaryExpression.ret,
                UnaryOperator.LOGICAL_COMPLEMENT);
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

castExpression returns [TypeCastNode ret]
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
            $ret = factory.makeTypeCastNode(
                $unaryExpressionNotPlusMinus.ret,
                $type.ret);
        }
    ;

postfixExpression returns [NonAssignmentExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("postfixExpression");
        }
        @after {
            ruleStop();
        }
    :
        primary
        {
            $ret = $primary.ret;
        }
        (
            '++'
            {
                $ret = factory.makeUnaryStatementExpressionNode($ret, UnaryStatementOperator.POSTFIX_INCREMENT);
            }
        |
            '--'
            {
                $ret = factory.makeUnaryStatementExpressionNode($ret, UnaryStatementOperator.POSTFIX_DECREMENT);
            }
        )*
    ;

primary returns [PrimaryExpressionNode ret]
        // This rule is complex enough that ANTLR's parameter passing breaks down.  Using scope instead.
        // Note that ANTLR is clever enough to create a new scope for each rule; this recurses appropriately.
        scope {
            PrimaryExpressionNode result;
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

restrictedPrimary returns [RestrictedPrimaryExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("restrictedPrimary");
        }
        @after {
            ruleStop();
        }
    :
        (
            // lexical literal
            lexicalLiteral 
            {
                $ret = $lexicalLiteral.ret;
            }
        |
            // class literal for primitive types
            primitiveClassLiteral
            {
                $ret = $primitiveClassLiteral.ret;
            }            
        |
            // class literal for declared types
            declaredClassLiteral
            {
            	$ret = $declaredClassLiteral.ret;
            }
        |
            // void class literal
            voidClassLiteral 
            {
                $ret = $voidClassLiteral.ret;
            }
        |
            // qualified or unqualified this
            thisClause
            {
                $ret = $thisClause.ret;
            }
        |
            // parenthesized expression (used as a primary expression)
            parExpression
            {
                $ret = factory.makeParenthesizedExpressionNode($parExpression.ret);
            }
        |
            // unqualified class instantiation
            unqualifiedClassInstantiation
            {
                $ret = $unqualifiedClassInstantiation.ret;
            }
        |
            // method invocation from super
            // this rule must preceed the superFieldAccess rule or it will not be parsed correctly
            // ideally, backtracking would prevent this... but it doesn't seem to do so
            superMethodInvocation
            {
                $ret = $superMethodInvocation.ret;
            }
        |
            // field access from super
            superFieldAccess
            {
                $ret = $superFieldAccess.ret;
            }
        |
            // standard method invocation
            methodInvocationByName
            {
                $ret = $methodInvocationByName.ret;
            }
        |
            // method invocation against a type with type arguments
            typeQualifiedTypeArgumentMethodInvocation
            {
                $ret = $typeQualifiedTypeArgumentMethodInvocation.ret;
            }
        |
            // field access by expression name (such as "x" or "x.y")
            expressionName
            {
                $ret = factory.makeFieldAccessByNameNode($expressionName.ret);
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
primarySuffix returns [RestrictedPrimaryExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("primarySuffix");
            PrimaryExpressionNode in = $primary::result;
        }
        @after {
            ruleStop();
        }
    :
        (
	        // qualified class instantiation
	        qualifiedClassInstantiationPrimarySuffix[in]
	        {
	            $ret = $qualifiedClassInstantiationPrimarySuffix.ret;
	        }
	    |
	        // field access on an expression
	        '.' identifier
	        {
	            $ret = factory.makeFieldAccessByExpressionNode(in, $identifier.ret);
	        }
	    |
	        // method invocation with type arguments
	        typeArgumentMethodInvocationSuffix[in]
	        {
	            $ret = $typeArgumentMethodInvocationSuffix.ret;
	        }
        )
        (
            arrayAccess[ret]
            {
                $ret = $arrayAccess.ret;
            }
        )?
    ;

thisClause returns [ThisNode ret]
        scope Rule;
        @init {
            ruleStart("thisClause");
            UnparameterizedTypeNode qualifyingType = null;
        }
        @after {
            $ret = factory.makeThisNode(qualifyingType);
            ruleStop();
        }
    :
        (
            thisQualifierName=typeName '.'
            {
                qualifyingType = factory.makeUnparameterizedTypeNode($thisQualifierName.ret);
            }
        )?
        THIS
    ;

unqualifiedClassInstantiation returns [UnqualifiedClassInstantiationNode ret]
        scope Rule;
        @init {
            ruleStart("unqualifiedClassInstantiation");
            AnonymousClassBodyNode anonymousClassBodyNode = null;
            TypeArgumentListNode typeArgumentsNode =
                    factory.makeTypeArgumentListNode(Collections.<TypeArgumentNode>emptyList());
        }
        @after {
            ruleStop();
        }
    :
        NEW
        (
            typeArguments
            {
                typeArgumentsNode = $typeArguments.ret;
            }
        )?
        classOrInterfaceType arguments
        (
            anonymousClassBody
            {
                anonymousClassBodyNode = $anonymousClassBody.ret;
            }
        )?
        {
            $ret = factory.makeUnqualifiedClassInstantiationNode(
                    $classOrInterfaceType.ret,
                    typeArgumentsNode,
                    $arguments.ret,
                    anonymousClassBodyNode);
        }
    ;

// Parses a super field access.  For example, this rule would parse
//     super.x;
// or
//     X.super.x;
// The latter case is used to specify which enclosing type's supertype should be accessed.  (See the documentation of
// SuperFieldAccessNode for more information.)
superFieldAccess returns [SuperFieldAccessNode ret]
        scope Rule;
        @init {
            ruleStart("superFieldAccess");
            UnparameterizedTypeNode qualifyingTypeNode = null;
        }
        @after {
            ruleStop();
        }
    :
        (
            typeName '.'
            {
                qualifyingTypeNode = factory.makeUnparameterizedTypeNode($typeName.ret);
            }
        )?
        SUPER '.' identifier
        {
            $ret = factory.makeSuperFieldAccessNode(qualifyingTypeNode, $identifier.ret);
        }
    ;

// Parses a method invocation by name.  For example, this rule would parse
//     foo();
// or
//     someField.aMethod();
// or
//     Utils.stuff();
methodInvocationByName returns [MethodInvocationByNameNode ret]
        scope Rule;
        @init {
            ruleStart("methodInvocationByName");
        }
        @after {
            ruleStop();
        }
    :
        methodName arguments
        {
            $ret = factory.makeMethodInvocationByNameNode(
                    $methodName.ret,
                    $arguments.ret,
                    factory.makeReferenceTypeListNode());
        }
    ;

// Parses a super method invocation.  For example, this rule would parse
//     super.toString();
// or
//     X.super.foo();
// The latter case is used to specify which enclosing type's supertype should be accessed.  (See the documentation of
// SuperMethodInvocationNode for more information.)
superMethodInvocation returns [SuperMethodInvocationNode ret]
        scope Rule;
        @init {
            ruleStart("superMethodInvocation");
            UnparameterizedTypeNode qualifyingTypeNode = null;
            ReferenceTypeListNode typeArgumentsNode = factory.makeReferenceTypeListNode();
        }
        @after {
            ruleStop();
        }
    :
        (
            typeName '.'
            {
                qualifyingTypeNode = factory.makeUnparameterizedTypeNode($typeName.ret);
            }
        )?
        SUPER '.'
        (
            nonWildcardTypeArguments
            {
                typeArgumentsNode = $nonWildcardTypeArguments.ret;
            }
        )?
        identifier arguments
        {
            $ret = factory.makeSuperMethodInvocationNode(
                    qualifyingTypeNode,
                    $identifier.ret,
                    $arguments.ret,
                    typeArgumentsNode);
        }
    ;

// This rule invokes a method against a type while providing type arguments, as in
//     Collections.<Integer>emptySet();
typeQualifiedTypeArgumentMethodInvocation returns [MethodInvocationByNameNode ret]
        scope Rule;
        @init {
            ruleStart("typeQualifiedTypeArgumentMethodInvocation");
        }
        @after {
            ruleStop();
        }
    :
        typeName '.' nonWildcardTypeArguments identifier arguments
        {
            NameNode methodName = factory.makeQualifiedNameNode(
                    $typeName.ret,
                    $identifier.ret,
                    NameCategory.METHOD);
            $ret = factory.makeMethodInvocationByNameNode(
                    methodName,
                    $arguments.ret,
                    $nonWildcardTypeArguments.ret);
        }
    ;

// This rule instantiates a class using the expression before the suffix as the enclosing instance.
// For example:
//     (foo.bar()).new MyClass()
qualifiedClassInstantiationPrimarySuffix[PrimaryExpressionNode in] returns [QualifiedClassInstantiationNode ret]
        scope Rule;
        @init {
            ruleStart("qualifiedClassInstantiationPrimarySuffix");
            TypeArgumentListNode constructorTypeArgumentsNode =
                    factory.makeTypeArgumentListNode(Collections.<TypeArgumentNode>emptyList());
            TypeArgumentListNode classTypeArgumentsNode =
                    factory.makeTypeArgumentListNode(Collections.<TypeArgumentNode>emptyList());
            AnonymousClassBodyNode anonymousClassBodyNode = null;
        }
        @after {
            ruleStop();
        }
    :
        '.' NEW
        (
            constructorTypeArguments=typeArguments
            {
                constructorTypeArgumentsNode = $constructorTypeArguments.ret;
            }
        )?
        identifier
        (
            classTypeArguments=typeArguments
            {
                classTypeArgumentsNode = $classTypeArguments.ret;
            }
        )?
        arguments
        (
            anonymousClassBody
            {
                anonymousClassBodyNode = $anonymousClassBody.ret;
            }
        )?
        {
            $ret = factory.makeQualifiedClassInstantiationNode(
                    $in,
                    $identifier.ret,
                    classTypeArgumentsNode,
                    constructorTypeArgumentsNode,
                    $arguments.ret,
                    $anonymousClassBody.ret);
        }
    ;

// Parses a method invocation based on an expression, such as
//     array[4].toString()
// or
//     foo().bar()    
typeArgumentMethodInvocationSuffix[PrimaryExpressionNode in] returns [RestrictedPrimaryExpressionNode ret]
        scope Rule;
        @init {
            ruleStart("typeArgumentMethodInvocationSuffix");
            ReferenceTypeListNode typeArgumentsNode = factory.makeReferenceTypeListNode();
        }
        @after {
            ruleStop();
        }
    :
        '.'
        (
            nonWildcardTypeArguments
            {
                typeArgumentsNode = $nonWildcardTypeArguments.ret;
            }
        )?
        identifier arguments
        {
            $ret = factory.makeMethodInvocationByExpressionNode(
                    in,
                    $identifier.ret,
                    $arguments.ret,
                    typeArgumentsNode);
        }
    ;
    
arrayAccess[RestrictedPrimaryExpressionNode in] returns [ArrayAccessNode ret]
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
            $ret = factory.makeArrayAccessNode($in, $a.ret);
        }
        (
            '[' b=expression ']'
            {
                $ret = factory.makeArrayAccessNode($ret, $b.ret);
            }
        )*
    ;

declaredClassLiteral returns [ClassLiteralNode ret]
        scope Rule;
        @init {
            ruleStart("classLiteralName");
            LiteralizableTypeNode typeNode = null;
        }
        @after {
            $ret = factory.makeClassLiteralNode(typeNode);
            ruleStop();
        }
    :
        typeName
        {
            typeNode = factory.makeUnparameterizedTypeNode($typeName.ret);
        }
        (
            arrayTypeIndicator[typeNode]
            {
                typeNode = $arrayTypeIndicator.ret;
            }
        )?
        '.' 'class'
    ;

primitiveClassLiteral returns [ClassLiteralNode ret]
        scope Rule;
        @init {
            ruleStart("primitiveClassLiteral");
            LiteralizableTypeNode typeNode = null;
        }
        @after {
            $ret = factory.makeClassLiteralNode(typeNode);
            ruleStop();
        }
    :
        primitiveType
        {
            typeNode = $primitiveType.ret;
        }
        (
            arrayTypeIndicator[typeNode]
            {
                typeNode = $arrayTypeIndicator.ret;
            }
        )?
        '.' 'class'
    ;

voidClassLiteral returns [ClassLiteralNode ret]
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
            $ret = factory.makeClassLiteralNode(factory.makeVoidTypeNode());
        }
    ;

// Parses an array creater from one of two forms.
// Either:
//     new int[][]{{1,1},{2,2}};
// Or:
//     new int[2][][];
arrayCreator returns [ArrayCreationNode ret]
        scope Rule;
    @init{
            ruleStart("arrayCreator");
        int levels = 0;
        List<ExpressionNode> list = new ArrayList<ExpressionNode>();
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
            $ret = factory.makeArrayInitializerCreationNode(
                $arrayInitializer.ret,
                $createdName.ret,
                levels);
        }
    |   
        NEW createdName
        '[' e1=expression ']'
        {
            list.add($e1.ret);
        }        
        (   
            '[' e2=expression ']'
            {
                list.add($e2.ret);
            }            
        )*
        (
            '[' ']'
            {
                levels++;
            }            
        )*
        {
            $ret = factory.makeArrayInstantiatorCreationNode(
                factory.makeExpressionListNode(list),
                $createdName.ret,
                levels);
        }        
    ;

variableInitializer returns [VariableInitializerNode ret]
        scope Rule;
        @init {
            ruleStart("variableInitializer");
        }
        @after {
            ruleStop();
        }
    :   
        arrayInitializer
        {
            $ret = $arrayInitializer.ret;
        }        
    |   
        expression
        {
            $ret = $expression.ret;
        }
    ;

arrayInitializer returns [ArrayInitializerNode ret]
        scope Rule;
    @init {
            ruleStart("arrayInitializer");
            List<VariableInitializerNode> list = new ArrayList<VariableInitializerNode>();
    }
    @after {
            $ret = factory.makeArrayInitializerNode(
                factory.makeVariableInitializerListNode(list));
            ruleStop();
    }
    :   
        '{' 
            (
                v1=variableInitializer
                {
                    list.add($v1.ret);   
                }            
                (
                    ',' v2=variableInitializer
                    {
                        list.add($v2.ret);   
                    }                    
                )*
            )? 
            (',')? 
        '}'             //Yang's fix, position change.
    ;


createdName returns [BaseTypeNode ret]
        scope Rule;
        @init {
            ruleStart("createdName");
        }
        @after {
            ruleStop();
        }
    :   
        classOrInterfaceType
        {
            $ret = $classOrInterfaceType.ret;
        }
    |   primitiveType
        {
            $ret = $primitiveType.ret;
        }    
    ;

nonWildcardTypeArguments returns [ReferenceTypeListNode ret]
        scope Rule;
        @init {
            ruleStart("nonWildcardTypeArguments");
        }
        @after {
            ruleStop();
        }
    :   
        '<' referenceTypeList
        {
            $ret = $referenceTypeList.ret;
        }
        '>'
    ;

arguments returns [ExpressionListNode ret]
        scope Rule;
        @init {
            ruleStart("arguments");
        }
        @after {
            ruleStop();
        }
    :
        {
            // initialize to empty list
            $ret = factory.makeExpressionListNode(new ArrayList<ExpressionNode>());
        }
        '(' (expressionList
            {
                $ret = $expressionList.ret;
            }
        )? ')'
    ;

// Parses a package name chain.
packageName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("packageName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.PACKAGE, NameCategory.PACKAGE]
        {
            $ret = $categorizedName.ret;
        }
    ;

// Parses a type name chain.  The last node is of the category TYPE; the rest are PACKAGE_OR_TYPE.
typeName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("typeName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.PACKAGE_OR_TYPE, NameCategory.TYPE]
        {
            $ret = $categorizedName.ret;
        }
    ;

// Parses an expression name chain.  The last node is of the category EXPRESSION; the rest are AMBIGUOUS.
expressionName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("expressionName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.AMBIGUOUS, NameCategory.EXPRESSION]
        {
            $ret = $categorizedName.ret;
        }
    ;

// Parses a method name chain.  The last node is of the category METHOD; the rest are AMBIGUOUS.
methodName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("methodName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.AMBIGUOUS, NameCategory.METHOD]
        {
            $ret = $categorizedName.ret;
        }
    ;
    
// Parses a package-or-type name chain.
packageOrTypeName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("packageOrTypeName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.PACKAGE_OR_TYPE, NameCategory.PACKAGE_OR_TYPE]
        {
            $ret = $categorizedName.ret;
        }
    ;

// Parses an ambiguous name.
ambiguousName returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("ambiguousName");
        }
        @after {
            ruleStop();
        }
    :
        categorizedName[NameCategory.AMBIGUOUS, NameCategory.AMBIGUOUS]
        {
            $ret = $categorizedName.ret;
        }
    ;

// Parses a name (a dot-separated sequence of identifiers) and assigns each of them the specified category.  The top
// name node is assigned another category.  This rule does not correspond directly to anything in the JLS; it is used as
// a parsing subroutine.
categorizedName[NameCategory... category] returns [NameNode ret]
        scope Rule;
        @init {
            ruleStart("categorizedName");
            List<IdentifierNode> identifierNodes = new ArrayList<IdentifierNode>();
        }
        @after {
            $ret = null;
            for (int i=0;i<identifierNodes.size();i++)
            {
                NameCategory currentCategory = category[Math.max(0, category.length - identifierNodes.size() + i)];
                if (i==0)
                {
                    $ret = factory.makeSimpleNameNode(identifierNodes.get(0), currentCategory);
                } else
                {
	                $ret = factory.makeQualifiedNameNode(
	                        $ret,
	                        identifierNodes.get(i),
	                        currentCategory);
            ruleStop();
                }
            }
            if (logger.isTraceEnabled())
            {
                logger.trace("Parsed name " + $ret.toString());
            }
        }
    :
        a=identifier
        {
            identifierNodes.add($a.ret);
        }
        (
            '.' b=identifier
            {
                identifierNodes.add($b.ret);
            }
        )*
    ;

intLiteral [boolean isNegative] returns [LiteralNode<?> ret]
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
                    getLineNumber(-1),
                    getColumnNumber(-1),
                    resource,
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeIntLiteralNode(i);
        }
    ;   
    
longLiteral [boolean isNegative] returns [LiteralNode<?> ret]    
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
                    getLineNumber(-1),
                    getColumnNumber(-1),
                    resource,
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeLongLiteralNode(l);
        }
    ;

lexicalLiteral returns [LiteralNode<?> ret]
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
                    getLineNumber(-1),
                    getColumnNumber(-1),
                    resource,
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeFloatLiteralNode(f);
        }
    |   
        DOUBLELITERAL
        {
            String s = $DOUBLELITERAL.text;
            double d = BsjAntlrParserUtils.parseDouble(
                    s,
                    getLineNumber(-1),
                    getColumnNumber(-1),
                    resource,
                    diagnosticListener,
                    $Rule::name);
            $ret = factory.makeDoubleLiteralNode(d);
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
            $ret = factory.makeCharLiteralNode(s.charAt(0));
        }
    |   
        STRINGLITERAL
        {
            String s = $STRINGLITERAL.text;
            s = s.substring(1,s.length()-1);
            s = BsjAntlrParserUtils.unescape(s);
            $ret = factory.makeStringLiteralNode(s);
        }
    |   
        TRUE
        {
            $ret = factory.makeBooleanLiteralNode(true);
        }
    |   
        FALSE
        {
            $ret = factory.makeBooleanLiteralNode(false);
        }
    |   
        NULL
        {
            $ret = factory.makeNullLiteralNode(null);
        }
    ;

identifier returns [IdentifierNode ret]
        scope Rule;
        @init {
            ruleStart("identifier");
        }
        @after {
            ruleStop();
        }
    :
        IDENTIFIER
        {
            if (logger.isTraceEnabled())
            {
                logger.trace("Parsed identifier at " + BsjAntlrParserUtils.getTokenLocation($IDENTIFIER) +
                        " with text " + $IDENTIFIER.text);
            }
            $ret = factory.makeIdentifierNode($IDENTIFIER.text);
        }
    ;

// The following rules are for performance and error recovery purposes.  They are used as semantic hinting predicates to
// direct the parser down the correct path (so that a failed parse of "public class Foo ..." results in an error inside
// of the class rather than claiming that "class" should be an "@" for an annotation declaration).

classHeader 
    :   classModifiers 'class' IDENTIFIER
    ;

enumHeader 
    :   enumModifiers ('enum'|IDENTIFIER) IDENTIFIER
    ;

interfaceHeader 
    :   interfaceModifiers 'interface' IDENTIFIER
    ;

annotationHeader 
    :   annotationModifiers '@' 'interface' IDENTIFIER
    ;

typeHeader
    :   (classModifiers | enumModifiers | interfaceModifiers | annotationModifiers) ('class'|'enum'|('@' ? 'interface')) IDENTIFIER
    ;

methodHeader 
    :   methodModifiers typeParameters? (type|'void')? IDENTIFIER '('
    ;

fieldHeader 
    :   fieldModifiers type IDENTIFIER ('['']')* ('='|','|';')
    ;

localVariableHeader 
    :   variableModifiers type IDENTIFIER ('['']')* ('='|','|';')
    ;

/********************************************************************************************
                  Lexer section
*********************************************************************************************/

/* *** BSJ lexer rules **************************************************** */

METAIMPORT
    :   '#import'
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
