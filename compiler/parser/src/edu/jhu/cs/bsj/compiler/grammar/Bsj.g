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


grammar Bsj;

options {
    backtrack=true;
    memoize=true;
    language=Java;
}

scope Global {   
    Stack<String> className;
}

@lexer::header{
    package edu.jhu.cs.bsj.compiler.tool.parser.antlr;
}

@parser::header{
    package edu.jhu.cs.bsj.compiler.tool.parser.antlr;
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collection;
    import java.util.Collections;
    import java.util.List;
    import java.util.HashSet;
    import java.util.Set;
    import java.util.Stack;
    
    import edu.jhu.cs.bsj.compiler.ast.*;
    import edu.jhu.cs.bsj.compiler.ast.node.*;
    import edu.jhu.cs.bsj.compiler.ast.tags.*;
    import edu.jhu.cs.bsj.compiler.ast.node.meta.*;
}

@parser::members {
    // *** FACTORY NODE PROPERTY **********************************************
    /**
     * Factory used to generate nodes for the parser.
     */
    private BsjNodeFactory factory;
    
    public BsjNodeFactory getFactory()
    {
        return this.factory;
    }
    
    public void setFactory(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    // *** COMMONLY USED MODIFIERS ********************************************
    private static final List<Modifier> classModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.PROTECTED,
            Modifier.PRIVATE,
            Modifier.ABSTRACT,
            Modifier.STATIC,
            Modifier.FINAL,
            Modifier.STRICTFP);
    private static final List<Modifier> interfaceModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.PROTECTED,
            Modifier.PRIVATE,
            Modifier.ABSTRACT,
            Modifier.STATIC,
            Modifier.FINAL,
            Modifier.STRICTFP);
    private static final List<Modifier> variableModifiers = Arrays.asList(Modifier.FINAL);
    private static final List<Modifier> fieldModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.PROTECTED,
            Modifier.PRIVATE,
            Modifier.STATIC,
            Modifier.FINAL,
            Modifier.TRANSIENT,
            Modifier.VOLATILE);
    private static final List<Modifier> constantModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.STATIC,
            Modifier.FINAL);
    private static final List<Modifier> methodModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.PROTECTED,
            Modifier.PRIVATE,
            Modifier.ABSTRACT,
            Modifier.STATIC,
            Modifier.FINAL,
            Modifier.SYNCHRONIZED,
            Modifier.NATIVE,
            Modifier.STRICTFP);
    private static final List<Modifier> constructorModifiers = Arrays.asList(
            Modifier.PUBLIC,
            Modifier.PROTECTED,
            Modifier.PRIVATE);
    
    static class IntegerBaseResult
    {
        public int base;
        public String string;
        public IntegerBaseResult(int base, String string)
        {
            this.base = base;
            this.string = string;
        }
        public IntegerBaseResult(String string)
        {
            if (string.length()>1 && string.charAt(0)=='0')
            {
                this.base = 8;
                this.string = string.substring(1);
            } else if (s.startsWith("0x") || s.startsWith("0X"))
            {
                this.base = 16;
                this.string = string.substring(2);
            } else
            {
                this.base = 10;
                this.string = string;
            }
        }
    }
}

/********************************************************************************************
                          Parser section
*********************************************************************************************/

/* 
 * These rules only exist in the parser.  They may map to the language standard but are primarily used to abstract
 * away parser patterns and may not manifest in the AST. 
 */
 
// Represents the combination of an identifier and an initializer.  As the identifier can be followed with array type
// indicators, an in/out type is also required.  This construct is necessary on its own to support the multiple
// declaration sugar ("int x,y;").
variableDeclarator[TypeNode inType] returns [VariableDeclaratorNode ret]
	    @init {
	        TypeNode type = $inType;
	        ExpressionNode initializer = null;
	    }
    :
        id=IDENTIFIER
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
            IdentifierNode identifier = makeIdentifierNode($id.text);
            $ret = factory.makeVariableDeclaratorNode(type, identifier, initializer);
        }
    ;

// Represents the declaration of an array type over a normal type.  This construct only handles the parsing of the []
// symbols and the modification of a type.
arrayTypeIndicator[TypeNode inType] returns [TypeNode ret]
	    @init {
	        $ret = $inType;
	    }
    :
        (
            '[' ']'
            {
                $ret = factory.makeArrayTypeNode($ret);
            }
        )*
    ;

// Represents an abstraction for field declarations which allows legal modifiers to be specified (to differentiate
// between interface and class fields).
abstractFieldDeclaration[List<Modifier> legalModifiers] returns [FieldDeclarationNode ret]
	    @init {
	        List<VariableDeclaratorNode> list = new ArrayList<VariableDeclaratorNode>();
	    }
	    @after {
            $ret = factory.makeFieldDeclarationNode(
                    $modifiers.ret,
                    factory.makeListNode(list));
	    }
    :   
        modifiers[legalModifiers]
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
    ;

/** These are the actual grammar rules. */

compilationUnit returns [CompilationUnitNode ret]
    :
        packageDeclaration?
        importDeclarations
        typeDeclarations
        {
            $ret = factory.makeCompilationUnitNode(
                        $packageDeclaration.ret,
                        $importDeclarations.ret,
                        $typeDeclarations.ret);
        }
    ;

packageDeclaration returns [PackageDeclarationNode ret]
    :
        annotations?
        'package' qualifiedName ';'
        {
            $ret = factory.makePackageDeclarationNode(
                    $qualifiedName.ret,
                    $annotations.ret);
        }
    ;

importDeclarations returns [ListNode<ImportNode> ret]
        @init {
            List<ImportNode> list = new ArrayList<ImportNode>();
        }
        @after {
            $ret = factory.<ImportNode>makeListNode(list);
        }
    :
        (
            importDeclaration
            {
                list.add($importDeclaration.ret);
            }
        )*
    ;

importDeclaration returns [ImportNode ret]
    :   
        'import' 
        (staticImport='static')?
        id=IDENTIFIER '.' '*' ';'
        {
            $ret = factory.makeImportNode(
                factory.makeQualifiedNameNode(
                    factory.makeIdentifierNode($id.text),
                    factory.makeIdentifierNode("*")),
                staticImport!=null);
        }
    |
        'import'
        (staticImport='static')?
        qualifiedImportName
        ';'
        {
            $ret = factory.makeImportNode(
                $qualifiedImportName.ret,
                staticImport!=null);
        }
    ;

qualifiedImportName returns [QualifiedNameNode ret]
    :
        necessarilyQualifiedName (starQual=('.' '*')?)
        {
            if ($starQual!=null)
            {
                $ret = factory.makeQualifiedNameNode(
                    $necessarilyQualifiedName.ret,
                    factory.makeIdentifierNode("*"));
            } else
            {
                $ret = $necessarilyQualifiedName.ret;
            } 
        }
    ;

necessarilyQualifiedName returns [QualifiedNameNode ret]
    :   
        a=IDENTIFIER '.' b=IDENTIFIER
        {
            $ret = factory.makeQualifiedNameNode(
                    factory.makeIdentifierNode($a.text),
                    factory.makeIdentifierNode($b.text));
        }
        (
            '.' c=IDENTIFIER
            {
                $ret = factory.makeQualifiedNameNode(
                    $ret,
                    factory.makeIdentifierNode($c.text));
            }
        )*
    ;

typeDeclarations returns [ListNode<TypeDeclarationNode> ret]
        @init {
            List<TypeDeclarationNode> list = new ArrayList<TypeDeclarationNode>();
        }
        @after {
            $ret = factory.<TypeDeclarationNode>makeListNode(list);
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
    :
        classOrInterfaceDeclaration
        {
            $ret = $classOrInterfaceDeclaration.ret;
        }
    |
        voidTypeDeclaration
        {
            $ret = $voidTypeDeclaration.ret;
        }
    ;

voidTypeDeclaration returns [VoidTypeDeclarationNode ret]
    :
	    ';'
	    {
	        $ret = factory.makeVoidTypeDeclarationNode();
	    }
    ;

classOrInterfaceDeclaration returns [TypeDeclarationNode ret]
    :
        classDeclaration
        {
            $ret = $classDeclaration.ret;
        }
    |
        interfaceDeclaration
        {
            $ret = $interfaceDeclaration.ret;
        }
    ;
    
// Accepts as a parameter the set of legal modifiers.  null means all of them are legal.
// TODO: which modifiers are legal should be in the *type system!*  (Oops)
modifiers[Collection<Modifier> legalModifiers] returns [ModifiersNode ret]
        @init {
            List<AnnotationNode> list = new ArrayList<AnnotationNode>();
            Set<Modifier> modifiers = new HashSet<Modifier>();
        }
        @after {
            $ret = factory.makeModifiersNode(
                        factory.makeListNode(list),
                        modifiers);
        }
    :
        (
            modifier
            {
                if ($modifier.mod==null)
                {
                    list.add($modifier.ann);
                } else
                {
                    if ($legalModifiers==null || $legalModifiers.contains($modifier.mod))
                    {
                        // TODO: if this next call returns true, that's something like "public public void".  Figure out
                        // error handling.
                        modifiers.add($modifier.mod);
                    } else
                    {
                        // TODO: if we get here, that's like "volatile" on a class declaration.  Figure out error
                        // handling.
                        // TODO: We should handle the error here, but it should be recognized in the factory, the node,
                        // or somewhere else like that.  That will ensure that the type system handles the problem and
                        // it's caught automatically in metaprograms.
                    }
                }
            }
        )*
    ;

modifier returns [Modifier mod, AnnotationNode ann]
        @init {
            $ann = null;
            $mod = null;
        }
    :
            annotation
        {
            $ann = $annotation.ret;
        }
        |   'public'        { $mod = Modifier.PUBLIC; }
        |   'protected'     { $mod = Modifier.PROTECTED; }
        |   'private'       { $mod = Modifier.PRIVATE; }
        |   'static'        { $mod = Modifier.STATIC; }
        |   'abstract'      { $mod = Modifier.ABSTRACT; }
        |   'final'         { $mod = Modifier.FINAL; }
        |   'native'        { $mod = Modifier.NATIVE; }
        |   'synchronized'  { $mod = Modifier.SYNCHRONIZED; }
        |   'transient'     { $mod = Modifier.TRANSIENT; }
        |   'volatile'      { $mod = Modifier.VOLATILE; }
        |   'strictfp'      { $mod = Modifier.STRICTFP; }
    ;

variableModifiers returns [ModifiersNode ret]
    :
        modifiers[variableModifiers]
        {
            $ret = $modifiers.ret;
        }
    ;

classDeclaration returns [TypeDeclarationNode ret] 
    :
        normalClassDeclaration
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
    scope Global;
    :   
        modifiers[classModifiers]
        'class' id=IDENTIFIER
        {
            if ($Global::className == null)
            {
                $Global::className = new Stack<String>();
            }
            $Global::className.push($id.text);
        }
        typeParameters?
        ('extends' type)?
        ('implements' typeList)?            
        classBody
        {            
            $ret = factory.makeClassDeclarationNode(
                    $type.ret,
                    $typeList.ret,
                    $classBody.ret,
                    $typeParameters.ret,
                    factory.makeIdentifierNode($id.text),
                    $modifiers.ret);
            $Global::className.pop();
        }
    ;


typeParameters returns [ListNode<TypeParameterNode> ret]
	    @init {
	            List<TypeParameterNode> list = new ArrayList<TypeParameterNode>();
	    }
	    @after {
	            $ret = factory.<TypeParameterNode>makeListNode(list);
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
        @init {
            ListNode<BoundType> typeBoundNode = factory.<BoundType>makeNode(Collections.emptyList());
        }
    :   
        id=IDENTIFIER
        (
            'extends' typeBound
            {
                typeBoundNode = $typeBound.ret;
            }
        )?
        {
            $ret = factory.makeTypeParameterNode(
                        factory.makeIdentifierNode($id.text),
                        typeBoundNode);
        }        
    ;


typeBound returns [ListNode<BoundType> ret]
	    @init {
	        List<BoundType> list = new ArrayList<BoundType>();
	    }
	    @after {
	        $ret = factory.makeListNode(list);
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
    scope Global;
    :   
        modifiers[classModifiers]
        'enum' 
        id=IDENTIFIER
        {
            if ($Global::className == null)
            {
                $Global::className = new Stack<String>();
            }        
            $Global::className.push(id.text);
        }
        ('implements' typeList)?
        enumBody
        {
            $ret = factory.makeEnumDeclarationNode(
                        $typeList.ret,
                        $enumBody.ret,
                        factory.makeIdentifierNode($id.text),
                        $modifiers.ret);
            $Global::className.pop();                        
        }
    ;


enumBody returns [EnumBodyNode ret]
        @init {
            ListNode<EnumConstantDeclarationNode> enumConstantsNode = factory.makeListNode(
                    Collections.<EnumConstantDeclarationNode>emptyList());
            ListNode<ClassMember> enumBodyDeclarationsNode = factory.makeListNode(Collections.<ClassMember>emptyList());
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

enumConstants returns [ListNode<EnumConstantDeclarationNode> ret]
        @init {
            List<EnumConstantDeclarationNode> list = new ArrayList<EnumConstantDeclarationNode>();
        }
        @after {
            $ret = factory.<EnumConstantDeclarationNode>makeListNode(list);
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
        @init {
            ListNode<AnnotationNode> annotationsNode = factory.makeListNode(Collections.<AnnotationNode>emptyList());
            ListNode<ExpressionNode> argumentsNode = factory.makeListNode(Collections.<ExpressionNode>emptyList());
            AnonymousClassBodyNode anonymousClassBodyNode = null;
        }
    :   
        (
            annotations
            {
                annotationsNode = $annotations.ret;
            }
        )?
        id=IDENTIFIER
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
                factory.makeIdentifierNode($id.text),
                argumentsNode,
                anonymousClassBodyNode);
        }
    ;

enumBodyDeclarations returns [ListNode<EnumBodyDeclaration> ret]
        @init {
            List<EnumBodyDeclaration> list = new ArrayList<EnumBodyDeclaration>();
        }
        @after {
            $ret = factory.<EnumBodyDeclaration>makeListNode(list);
        }
    :
        ';'
        (
            classDeclaration
            {
                list.add($classDeclaration.ret);
            }
        )*
    ;


interfaceDeclaration returns [TypeDeclarationNode ret] 
    :   
        a=normalInterfaceDeclaration
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
    scope Global;
    :   
        modifiers[interfaceModifiers]
        'interface' id=IDENTIFIER
        {
            if ($Global::className == null)
            {
                $Global::className = new Stack<String>();
            }        
            $Global::className.push($id.text);
        }        
        (typeParameters
        )?
        ('extends' typeList
        )?
        interfaceBody
        {
            $ret = factory.makeInterfaceDeclarationNode(
                    $typeList.ret,
                    $interfaceBody.ret,
                    $typeParameters.ret,
                    factory.makeIdentifierNode($id.text),
                    $modifiers.ret);
            $Global::className.pop();                    
        }
    ;

typeList returns [ListNode<TypeNode> ret]
        @init {
            List<TypeNode> list = new ArrayList<TypeNode>();
        }
        @after {
            $ret = factory.<TypeNode>makeListNode(list);
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
	    @init {
	            List<ClassMember> list = new ArrayList<ClassMember>();
	    }
	    @after {
	            $ret = factory.makeClassBodyNode(list);
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
        @init {
                List<AnonymousClassMember> list = new ArrayList<AnonymousClassMember>();
        }
        @after {
                $ret = factory.makeAnonymousClassBodyNode(list);
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
        @init {
                List<InterfaceMember> list = new ArrayList<InterfaceMember>();
        }
        @after {
                $ret = factory.makeInterfaceBodyNode(list);
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
    :
        staticText='static'?
        block
        {
            $ret = factory.makeInitializerDeclarationNode(
                    $staticText!=null,
                    $block.ret);
        }
    ;
    
classBodyDeclaration returns [ClassMember ret]
    :
        voidTypeDeclaration
        {
            $ret = $voidTypeDeclaration.ret;
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

anonymousClassBodyDeclaration returns [AnonymousClassMember ret]
    :
        voidTypeDeclaration
        {
            $ret = $voidTypeDeclaration.ret;
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
    ;

memberDecl returns [AnonymousClassMember ret]
    :    
        fieldDeclaration
        {
            $ret = $fieldDeclaration.ret;
        }
    |   
        methodDeclaration
        {
            $ret = $methodDeclaration.ret;
        }
    |   
        classDeclaration
        {
            $ret = $classDeclaration.ret;
        }
    |   
        interfaceDeclaration
        {
            $ret = $interfaceDeclaration.ret;
        }
    ;

methodReturnType returns [TypeNode ret]
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
    scope Global;
    :
        modifiers[constructorModifiers]
        typeParameters?
        IDENTIFIER
        formalParameters
        ('throws' qualifiedNameList)?
        constructorBody
        {
            if ($Global::className.empty())
            {
                //TODO error handling            
            }
            else if (!$IDENTIFIER.text.equals($Global::className.peek()))
            {
                //TODO error handling
            }
            $ret = factory.makeConstructorDeclarationNode(
                    $constructorBody.ret,
                    $modifiers.ret,
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    $qualifiedNameList.ret,
                    $typeParameters.ret);
        }
    ;

constructorBody returns [ConstructorBodyNode ret]
	    @init {
	        List<StatementNode> list = new ArrayList<StatementNode>();
	        ConstructorInvocationNode constructorInvocationNode = null;
	    }
	    @after {
	        $ret = factory.makeConstructorBodyNode(
	                constructorInvocationNode,
	                factory.makeBlockStatementNode(list));
	    }
    :
        '{' 
        (
            explicitConstructorInvocation
            {
                constructorInvocationNode = $explicitConstructorInvocation.ret;
            }
        )?
        (
            blockStatement
            {
                list.add($blockStatement.ret);
            }
        )*
        '}'
    ;

methodDeclaration returns [MethodDeclarationNode ret]
        @init {
            BlockStatementNode blockStatementNode = null;
            ListNode<TypeParameterNode> typeParametersNode =
                    factory.makeListNode(Collections.<TypeParameterNode>emptySet());
        }
    :
        modifiers[methodModifiers]
        (
            typeParameters
            {
                typeParametersNode = $typeParameters.ret;
            }
        )?
        methodReturnType
        id=IDENTIFIER
        formalParameters
        (
            arrayTypeIndicator[$methodReturnType]
            {
                $methodReturnType = $arrayTypeIndicator.ret;
            }
        )?
        'throws' qualifiedNameList?            
        (        
            block
            {
                blockStatementNode = $block.ret;
            }
        |
            ';' 
        )
        {
            $ret = factory.makeMethodDeclarationNode(
                    blockStatementNode,
                    $modifiers.ret,
                    factory.makeIdentifierNode($id.text),
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    $methodReturnType.ret,
                    $qualifiedNameList.ret,
                    typeParametersNode;
        }        
    ;


fieldDeclaration returns [FieldDeclarationNode ret]
    :
        abstractFieldDeclaration[fieldModifiers]
        {
            $ret = $abstractFieldDeclaration.ret;
        }   
    ;

interfaceBodyDeclaration returns [InterfaceMember ret]
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
        voidTypeDeclaration
        {
            $ret = $voidTypeDeclaration.ret;
        }
    ;

interfaceMethodDeclaration returns [MethodDeclarationNode ret]
    :   
        modifiers[interfaceModifiers]
        typeParameters?
        methodReturnType
        id=IDENTIFIER
        formalParameters
        (
            arrayTypeIndicator[$methodReturnType]
            {
                $methodReturnType = $arrayTypeIndicator.ret;
            }
        )?
        ('throws' qualifiedNameList)? ';'
        {
            $ret = factory.makeMethodDeclarationNode(
                    null, // No body for interface methods; thus null
                    $modifiers.ret,
                    factory.makeIdentifierNode($id.text),
                    $formalParameters.parameters,
                    $formalParameters.varargParameter,
                    $methodReturnType.ret,
                    $qualifiedNameList.ret,
                    $typeParameters.ret);
        }         
    ;

interfaceFieldDeclaration returns [FieldDeclarationNode ret]
    :   
        abstractFieldDeclaration[constantModifiers]
        {
            $ret = $abstractFieldDeclaration.ret;
        }
    ;

nonprimitiveType returns [TypeNode ret]
    :
        classOrInterfaceType
        {
            $ret = $classOrInterfaceType.ret;
        }
        (
            arrayTypeIndicator[$ret]
            {
                $ret = factory.$ret;
            }
        )?
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
            arrayTypeIndicator[$ret]
            {
                $ret = factory.$ret;
            }
        )?
    ;

// The following rule does not exist in the language standard; it is solely for the purpose of making
// classOrInterfaceType less repetetive.
unqualifiedClassOrInterfaceType[BoundType in] returns [BoundType ret]
        @init {
            $ret = $in;
        }
    :
        a=IDENTIFIER
        {
            DeclaredTypeNode selected = factory.makeDeclaredTypeNode(factory.makeIdentifierNode($a.text));
            if ($ret == null)
            {
                $ret = selected;
            } else
            {
                $ret = factory.makeTypeSelectNode($ret, selected);
            }
        }
        
        (
            typeArguments
            {
                $ret = factory.makeParameterizedTypeNode($ret, $typeArguments.ret);
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
classOrInterfaceType returns [BoundType ret]
    :   
        a=unqualifiedClassOrInterfaceType[null]
        {
            $ret = $a.ret;
        }
        (
            '.'
            b=unqualifiedClassOrInterfaceType[$ret]
            {
                $ret = $b.ret;
            }
        )*
    ;

// Parses a primitive type.
// For example, in
//     boolean b = true;
// this rule matches
//     boolean
primitiveType returns [PrimitiveTypeNode ret]
        @init {
                PrimitiveType temp;
        }
        @after {
                $ret = factory.makePrimitiveTypeNode(temp);
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
typeArguments returns [ListNode<TypeArgument> ret]
        @init {
            List<TypeArgument> list = new ArrayList<TypeArgument>();
        }
        @after {
            $ret = factory.<TypeArgument>makeListNode(list);
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
typeArgument returns [TypeArgument ret]
        @init {
            boolean upper = false;
        } 
    :
        nonprimitiveType
        {
            // All nonprimitive types are potential type arguments.
            $ret = (TypeArgument)($nonprimitiveType.ret);
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
            'super' { upper = false; }
        )
        nonprimitiveType
        {
            $ret = factory.makeWildcardTypeNode(
                        (TypeArgument)($nonprimitiveType.ret),
                        upper);
        }
    ;

// TODO: should this be a ListNode<DeclaredTypeNode>?  Are QualifiedNameNode and DeclaredTypeNode different enough that
// we can keep them separate?
qualifiedNameList returns [ListNode<QualifiedNameNode> ret]
        @init {
            List<QualifiedNameNode> list = new ArrayList<QualifiedNameNode>();
        }
        @after {
            $ret = factory.<QualifiedNameNode>makeListNode(list);
        }
    :   
        a=qualifiedName
            {
                list.add($a.ret);
            }    
        (
            ',' b=qualifiedName
            {
                list.add($b.ret);
            }
        )*
    ;

// Matches a formal parameter list.
// For example, in
//     public void foo(int x, int y)
// this rule matches
//     (int x, int y)
formalParameters returns [ListNode<VariableNode> parameters, VariableNode varargParameter]
    :
        '('
        (
            formalParameterDecls
        )? 
        ')'
        {
            if ($formalParameterDecls == null)
            {
                $parameters = factory.makeListNode(new ArrayList<VariableNode>());
                $varargParameter = null;
            } else
            {
                $parameters = $formalParameterDecls.parameters;
                $varargParameter = $formalParameterDecls.varargParameter;
            }
        }
    ;

// This rule is expected to produce a list of parameter declarations (multiple results)
formalParameterDecls returns [ListNode<VariableNode> parameters, VariableNode varargParameter]
        @init {
            List<VariableNode> list = new ArrayList<VariableNode>();
        }
        @after {
            $parameters = factory.makeListNode(list);
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
    :
        mod=variableModifiers t=type id=IDENTIFIER
        t=arrayTypeIndicator[$t.ret]
        {
            $ret = factory.makeVariableNode($mod.ret, $t.ret, factory.makeIdentifierNode($id.text));
        }
    ;

ellipsisParameterDecl returns [VariableNode ret]
    :
        mod=variableModifiers t=type '...' id=IDENTIFIER
        {
            $ret = factory.makeVariableNode($mod.ret, $t.ret, factory.makeIdentifierNode($id.text));
        }
    ;

alternateConstructorInvocation returns [AlternateConstructorInvocationNode ret]
    :
        nonWildcardTypeArguments? 'this' arguments ';'
        {
            $ret = factory.makeAlternateConstructorInvocationNode(
                        $arguments.ret,
                        $nonWildcardTypeArguments.ret);
        }
    ;

superclassConstructorInvocation returns [SuperclassConstructorInvocationNode ret]
    :
        (primary '.')?
        nonWildcardTypeArguments? 'super' arguments ';'
        {
            $ret = factory.makeSuperclassConstructorInvocationNode(
                        $primary == null? null : $primary.ret,
                        $arguments.ret,
                        $nonWildcardTypeArguments.ret);
        }
    ;

explicitConstructorInvocation returns [ConstructorInvocationNode ret]
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

qualifiedName returns [QualifiedNameNode ret]
    :
        IDENTIFIER ('.' IDENTIFIER)*
        // TODO
    ;

annotations returns [ListNode<AnnotationNode> ret]
	    @init {
	            List<AnnotationNode> list = new ArrayList<AnnotationNode>();
	    }
	    @after {
	            $ret = factory.makeListNode(list);
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
    :   
        // TODO: qualifiedName.ret is not a DeclaredTypeNode
        '@' qualifiedName
        {
            $ret = factory.makeNormalAnnotationNode(
                    factory.makeListNode(new ArrayList<AnnotationElementNode>()),
                    $qualifiedName.ret);
        }
        (
            '('   
            (
                elementValuePairs
                {
                    $ret = factory.makeNormalAnnotationNode(
                            $elementValuePairs.ret,
                            $qualifiedName.ret);
                }
            |
                elementValue
                {
                    $ret = factory.makeSingleElementAnnotationNode(
                            $elementValue.ret,
                            $qualifiedName.ret);
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
elementValuePairs returns [ListNode<AnnotationElementNode> ret]
        @init {
            List<AnnotationElementNode> list = new ArrayList<AnnotationElementNode>();
        }
        @after {
            $ret = factory.makeListNode(list);
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
    :
        id=IDENTIFIER '=' elementValue
        {
            $ret = factory.makeAnnotationElementNode(factory.makeIdentifierNode($id.text), $elementValue.ret);
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
        @init {
            List<AnnotationValueNode> list = new ArrayList<AnnotationValueNode>();
        }
        @after {
            $ret = factory.makeAnnotationArrayValueNode(factory.makeListNode(list));
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
    :   
        modifiers[interfaceModifiers] '@'
        'interface'
        id=IDENTIFIER
        annotationTypeBody
        {
            $ret = factory.makeAnnotationDeclarationNode(
                $annotationTypeBody.ret,
                factory.makeIdentifierNode($id.text),
                $modifiers.ret);
        }
    ;


annotationTypeBody returns [AnnotationBodyNode ret]
	    @init {
	            List<AnnotationMember> list = new ArrayList<AnnotationMember>();
	    }
	    @after {
	            $ret = factory.makeAnnotationBodyNode(factory.makeListNode(list));
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

annotationTypeElementDeclaration returns [AnnotationMember ret]
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
        voidTypeDeclaration
        {
            $ret = $voidTypeDeclaration.ret;
        }
    ;

annotationMethodDeclaration returns [AnnotationMethodDeclarationNode ret]
    :   
        modifiers[interfaceModifiers] type id=IDENTIFIER
        '(' ')'
        ('default' elementValue)?
        ';'
        {
            $ret = factory.makeAnnotationMethodDeclarationNode(
                $modifiers.ret,
                $type.ret,
                factory.makeIdentifierNode($id.text),
                elementValue == null ? null || $elementValue.ret);
        }
        ;

block returns [BlockStatementNode ret]
	    @init {
	            List<StatementNode> list = new ArrayList<StatementNode>();
	    }
	    @after {
	            $ret = factory.makeBlockStatementNode(list);
	    }
    :   
        '{'
        (blockStatement
            {
                list.add($blockStatement.ret);
            }
        )*
        '}'
    ;

// Parses a statement from a block of statements.
blockStatement returns [StatementNode ret]
    :   
        localVariableDeclarationStatement
        {
            $ret = $localVariableDeclarationStatement.ret;
        }
    |   
        classDeclaration
        {
            $ret = factory.makeInlineTypeDeclarationNode($classDeclaration.ret);
        }
    |   
        statement
        {
            $ret = $statement.ret;
        }        
    ;

// Parses local variable declaration statement.
// For example, this rule would match
//     int x = 5, y;
localVariableDeclarationStatement returns [VariableDeclarationNode ret]
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
        @init {
            List<VariableDeclaratorNode> list = new ArrayList<VariableDeclaratorNode>();
        }
        @after {
            $ret = factory.makeVariableDeclarationNode(
                    $variableModifiers.ret,
                    factory.makeListNode(list));
        }
    :   
        variableModifiers type
        a=variableDeclarator[$type]
        {
            list.add($a.ret); 
        }
        (
            ',' b=variableDeclarator[$type]
            {
	            list.add($b.ret); 
            }
        )*
    ;

statement returns [StatementNode ret]
    :   
        block
        {
            $ret = $block.ret;
        }
    |   
        'assert' e1=expression (':' e2=expression)? ';'   
        {
            $ret = factory.makeAssertStatementNode(
                $e1.ret,
                e2 == null ? null | $e2.ret);
        }        
    |   
        'if' parExpression s1=statement ('else' s2=statement)?    
        {
            $ret = factory.makeIfNode(
                $parExpression.ret
                $s1.ret,
                s2 == null ? null : $s2.ret);
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
        'return' expression? ';'
        {
            $ret = factory.makeReturnNode($expression == null ? null : $expression.ret);
        }
    |   
        'throw' expression ';'
        {
            $ret = factory.makeThrowNode(
                $expression.ret);
        }
    |   
        'break' (a=IDENTIFIER)? ';'
        {
            $ret = factory.makeBreakNode(
                $a == null ? null : factory.makeIdentifierNode($a.text));
        }
    |   
        'continue' (a=IDENTIFIER)? ';'
        {
            $ret = factory.makeContinueNode(
                $a == null ? null : factory.makeIdentifierNode($a.text));
        }
    |   
        expression  ';'  
        {
            $ret = $expression.ret;
        }   
    |   
        a=IDENTIFIER ':' s=statement
        {
            $ret = factory.makeLabeledStatementNode(
                factory.makeIdentifierNode($a.text),
                $s.ret);
        }
    |   
        ';'
        {
            $ret = factory.makeVoidStatementNode();
        }
    ;

switchBlockStatementGroups returns [ListNode<CaseNode> ret]
    @init {
            List<CaseNode> list = new ArrayList<CaseNode>();
    }
    @after {
            $ret = factory.makeListNode(list);
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
    @init {
            List<StatementNode> list = new ArrayList<StatementNode>();
            ExpressionNode label;
    }
    @after {
            $ret = factory.makeCaseNode(label, list);
    }
    :
        switchLabel
        {
            label = $switchLabel.ret;
        }
        (
            blockStatement
            {
                list.add($blockStatement.ret);
            }
        )*
    ;

switchLabel returns [ExpressionNode ret]
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
        @init {
            List<CatchNode> catchList = factory.makeListNode(new ArrayList<CatchNode>());
            BlockStatementNode finallyBlock = null;
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

catches returns [ListNode<CatchNode> ret]
        @init {
            List<CatchNode> list = new ArrayList<CatchNode>();
        }
        @after {
            $ret = factory.<CatchNode>makeListNode(list);
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
    :   
        variableModifiers type id=IDENTIFIER
        arrayTypeIndicator[$type.ret]
        {
            $ret = factory.makeVariableNode($variableModifiers.ret, $arrayTypeIndicator.ret,
                    factory.makeIdentifierNode($id.text));
        }
    ;

forstatement returns [StatementNode ret]
    @init{
        ExpressionNode forInitNode = null;
        ExpressionNode expNode = null;
        ListNode<ExpressionNode> expListNode = factory.<ExpressionStatementNode>makeListNode(
            new ArrayList<ExpressionStatementNode>();
    }
    :   
        // enhanced for loop
        'for' '(' variableModifiers type id=IDENTIFIER ':' 
        expression ')' statement
        {
            $ret = factory.makeEnhancedForLoopNode(
                factory.makeVariableNode(
                    $variableModifiers.ret, 
                    $type.ret,
                    factory.makeIdentifierNode($id.text)),
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
            expressionList
            {
                expListNode = $expressionList.ret;
            }
        )? ')'
        statement
        {
            $ret = factory.makeForLoopNode(
                    forInitNode, 
                    expListNode,
                    expNode,
                    $statement.ret);
        }                 
    ;

// Parses the initializer for a standard for loop.  This may either be a list of variable declarations or a list of
// initialization expressions.
forInit returns [ForInitializerNode ret]
    :   
        localVariableDeclaration
        {
            $ret = factory.makeForInitializerDeclarationNode($localVariableDeclaration.ret);
        }
    |   
        expressionList
        {
            $ret = factory.makeForInitializerExpressionNode($expressionList.ret);
        }
    ;

parExpression returns [ExpressionNode ret]
    :   
        '(' expression ')'
        {
            $ret = $expression.ret;
        }
    ;

expressionList returns [ListNode<ExpressionNode> ret]
	    @init {
	        List<ExpressionNode> list = new ArrayList<ExpressionNode>();
	    }
	    @after {
	        $ret = factory.<ExpressionNode>makeListNode(list);
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


expression returns [ExpressionNode ret]
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
            $ret = AssignmentOperator.RIGHT_SHIFT_ASSIGNMENT;
        }        
    |   
        '>' '>' '='
        {
            $ret = AssignmentOperator.UNSIGNED_RIGHT_SHIFT_ASSIGNMENT;
        }         
    ;


conditionalExpression returns [ExpressionNode ret]
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

conditionalOrExpression returns [ExpressionNode ret]
    :   
        e1=conditionalAndExpression
        {
            $ret = $e1.ret;
        }    
        (
            '||' e2=conditionalAndExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.CONDITIONAL_OR);
            }            
        )*
    ;

conditionalAndExpression returns [ExpressionNode ret]
    :   
        e1=inclusiveOrExpression
        {
            $ret = $e1.ret;
        }         
        (
            '&&' e2=inclusiveOrExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.CONDITIONAL_AND);
            }             
        )*
    ;

inclusiveOrExpression returns [ExpressionNode ret]
    :   
        e1=exclusiveOrExpression
        {
            $ret = $e1.ret;
        }    
        (
            '|' e2=exclusiveOrExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.LOGICAL_OR);
            }             
        )*
    ;

exclusiveOrExpression returns [ExpressionNode ret]
    :   
        e1=andExpression
        {
            $ret = $e1.ret;
        }          
        (
            '^' e2=andExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.XOR);
            }            
        )*
    ;

andExpression returns [ExpressionNode ret]
    :   
        e1=equalityExpression
        {
            $ret = $e1.ret;
        }         
        (
            '&' e2=equalityExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    BinaryOperator.LOGICAL_AND);
            }              
        )*
    ;

equalityExpression returns [ExpressionNode ret]
        @init{
            BinaryOperator op;
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
                    op = BinaryOperator.NOT_EQUALS;
                }            
            )
            e2=instanceOfExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    op);
            }             
        )*
    ;

instanceOfExpression returns [ExpressionNode ret]
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

relationalExpression returns [ExpressionNode ret]
    :   
        e1=shiftExpression
        {
            $ret = $e1.ret;
        }         
        (
            op=relationalOp e2=shiftExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    $op.ret);
            }             
        )*
    ;

relationalOp returns [BinaryOperator ret]
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

shiftExpression returns [ExpressionNode ret]
    :   
        e1=additiveExpression
        {
            $ret = $e1.ret;
        }        
        (
            op=shiftOp e2=additiveExpression
            {
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    $op.ret);
            }            
        )*
    ;


shiftOp returns [BinaryOperator ret]
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


additiveExpression returns [ExpressionNode ret]
        @init{
            BinaryOperator op;
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
                $ret = factory.makeBinaryOperatorNode(
                    $ret, 
                    $e2.ret, 
                    op);
            }             
        )*
    ;

multiplicativeExpression returns [ExpressionNode ret]
        @init{
            BinaryOperator op;
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
                $ret = factory.makeBinaryOperatorNode(
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
unaryExpression returns [ExpressionNode ret]
    :   
        '+'  e=unaryExpression
        {
            $ret = factory.makeUnaryOperatorNode(
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
            $ret = factory.makeUnaryOperatorNode(
                $e.ret,
                UnaryOperator.UNARY_MINUS);
        }        
    |   
        '++' e=unaryExpression
        {
            $ret = factory.makeUnaryOperatorNode(
                $e.ret,
                UnaryOperator.PREFIX_INCREMENT);
        }
    |   
        '--' e=unaryExpression
        {
            $ret = factory.makeUnaryOperatorNode(
                $e.ret,
                UnaryOperator.PREFIX_DECREMENT);
        }        
    |   
        unaryExpressionNotPlusMinus
        {
            $ret = $unaryExpressionNotPlusMinus.ret;
        }
    ;

unaryExpressionNotPlusMinus returns [ExpressionNode ret] // TODO primary
    :   
        '~' unaryExpression
        {
            $ret = factory.makeUnaryOperatorNode(
                $unaryExpression.ret,
                UnaryOperator.BITWISE_COMPLEMENT);
        }        
    |   
        '!' unaryExpression
        {
            $ret = factory.makeUnaryOperatorNode(
                $unaryExpression.ret,
                UnaryOperator.LOGICAL_COMPLEMENT);
        }        
    |   
        castExpression
        {
            $ret = $castExpression.ret;
        }
    |   
        primary
        (selector
        )*
        (   '++'
        |   '--'
        )?
    ;

castExpression returns [TypeCastNode ret]
    :   
        '(' primitiveType ')' unaryExpression
        {
            $ret = factory.makeTypeCastNode(
                $unaryExpression.ret,
                $primitiveType.ret);
        }
    |   
        '(' type ')' unaryExpressionNotPlusMinus
        {
            $ret = factory.makeTypeCastNode(
                $unaryExpressionNotPlusMinus.ret,
                $type.ret);
        }
    ;

/**
 * have to use scope here, parameter passing isn't well supported in antlr.
 */
primary //TODO
    :   parExpression            
    |   'this'
        ('.' IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   IDENTIFIER
        ('.' IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   'super'
        superSuffix
    |   literal
    |   creator
    |   primitiveType
        ('[' ']'
        )*
        '.' 'class'
    |   'void' '.' 'class'
    ;
    

superSuffix  //TODO
    :   arguments
    |   '.' (typeArguments
        )?
        IDENTIFIER
        (arguments
        )?
    ;


identifierSuffix //TODO
    :   ('[' ']'
        )+
        '.' 'class'
    |   ('[' expression ']'
        )+
    |   arguments
    |   '.' 'class'
    |   '.' nonWildcardTypeArguments IDENTIFIER arguments
    |   '.' 'this'
    |   '.' 'super' arguments
    |   innerCreator
    ;


selector  //TODO
    :   '.' IDENTIFIER
        (arguments
        )?
    |   '.' 'this'
    |   '.' 'super'
        superSuffix
    |   innerCreator
    |   '[' expression ']'
    ;

creator //TODO
    :   'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
    |   'new' classOrInterfaceType classCreatorRest
    |   arrayCreator
    ;

arrayCreator //TODO
    :   'new' createdName
        '[' ']'
        ('[' ']'
        )*
        arrayInitializer

    |   'new' createdName
        '[' expression
        ']'
        (   '[' expression
            ']'
        )*
        ('[' ']'
        )*
    ;

variableInitializer returns [ExpressionNode ret]
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

arrayInitializer //TODO
    :   
        '{' 
            (variableInitializer
                (',' variableInitializer
                )*
            )? 
            (',')? 
        '}'             //Yang's fix, position change.
    ;


createdName //TODO
    :   classOrInterfaceType
    |   primitiveType
    ;

innerCreator  //TODO
    :   '.' 'new'
        (nonWildcardTypeArguments
        )?
        IDENTIFIER
        (typeArguments
        )?
        classCreatorRest
    ;


classCreatorRest //TODO
    :   arguments
        (anonymousClassBody
        )?
    ;


nonWildcardTypeArguments returns [ListNode<TypeNode> ret]
    :   
        '<' typeList
        {
            $ret = $typeList.ret;
        }
        '>'
    ;

arguments returns [ListNode<ExpressionNode> ret]
    :
        {
            // initialize to empty list
            $ret = factory.<ExpressionNode>makeListNode(new ArrayList<ExpressionNode>());
        }
        '(' (expressionList
            {
                $ret = $expressionList.ret;
            }
        )? ')'
    ;
    
intLiteral [boolean isNegative] returns [LiteralNode<?> ret]
    :  
        INTLITERAL
        {
            IntegerBaseResult ibr = new IntegerBaseResult($INTLITERAL.text);
            Integer i;
            try
            {
                i = Integer.parseInt(
                    (isNegative ? "-" : "") + ibr.string, ibr.base);
            } catch (NumberFormatException nfe)
            {
                // TODO: report and handle error
            }
            $ret = factory.makeIntegerLiteralNode(i);
        }
    ;   
    
longLiteral [boolean isNegative] returns [LiteralNode<?> ret]    
    :
        LONGLITERAL
        {
            String s = $LONGLITERAL.text;
            s = s.substring(0, s.length()-1);
            IntegerBaseResult ibr = new IntegerBaseResult(s);
            Long l;
            try
            {
                l = Long.parseLong(
                    (isNegative ? "-" : "") + ibr.string, ibr.base);
            } catch (NumberFormatException nfe)
            {
                // TODO: report and handle error
            }
            $ret = factory.makeLongLiteralNode(l);
        }    
    ;

literal returns [LiteralNode<?> ret]
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
            s = s.substring(0,s.length()-1);
            Float f;
            try
            {
                f = Float.parseFloat(s);
            } catch (NumberFormatException nfe)
            {
                // TODO: report and handle error
            }
            $ret = factory.makeFloatLiteralNode(f);
        }
    |   
        DOUBLELITERAL
        {
            String s = $DOUBLELITERAL.text;
            if (s.endsWith("d") || s.endsWith("D"))
            {
                s = s.substring(0,s.length()-1);
            }
            Double d;
            try
            {
                d = Double.parseDouble(s);
            } catch (NumberFormatException nfe)
            {
                // TODO: report and handle error
            }
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



/********************************************************************************************
                  Lexer section
*********************************************************************************************/

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

