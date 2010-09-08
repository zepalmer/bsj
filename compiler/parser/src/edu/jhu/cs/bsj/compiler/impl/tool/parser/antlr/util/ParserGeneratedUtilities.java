package edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.util;

import javax.annotation.Generated;

import org.antlr.runtime.RecognitionException;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

/**
 * Contains a number of utility functions for parsing operations.  These
 * operations are separated solely because the source for them is generated.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParserGeneratedUtilities
{
    public static <T extends Node> T parseFromAntlr(BsjAntlrParser parser, ParseRule<T> rule, String name)
        throws RecognitionException
    {
        if (rule == null)
        {
            throw new IllegalArgumentException("Parse rule cannot be null.");
        }
        if (rule.equals(ParseRule.ABSTRACT_METHOD_MODIFIERS))
        {
            AnnotationMethodModifiersNode node = parser.parseRule_AbstractMethodModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION))
        {
            AnnotationNode node = parser.parseRule_Annotation();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATIONS))
        {
            AnnotationListNode node = parser.parseRule_Annotations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_METHOD))
        {
            AnnotationMethodDeclarationNode node = parser.parseRule_AnnotationMethod();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_MODIFIERS))
        {
            AnnotationModifiersNode node = parser.parseRule_AnnotationModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_BODY))
        {
            AnnotationBodyNode node = parser.parseRule_AnnotationTypeBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_ELEMENT_DECLARATIONS))
        {
            AnnotationMemberListNode node = parser.parseRule_AnnotationTypeElementDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY))
        {
            AnonymousClassBodyNode node = parser.parseRule_AnonymousClassBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY_DECLARATIONS))
        {
            AnonymousClassMemberListNode node = parser.parseRule_AnonymousClassBodyDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ARGUMENT_LIST))
        {
            ExpressionListNode node = parser.parseRule_ArgumentList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENT))
        {
            BlockStatementNode node = parser.parseRule_BlockStatement();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENTS))
        {
            BlockStatementListNode node = parser.parseRule_BlockStatements();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CATCH_CLAUSE))
        {
            CatchNode node = parser.parseRule_CatchClause();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CATCHES))
        {
            CatchListNode node = parser.parseRule_Catches();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_BODY))
        {
            ClassBodyNode node = parser.parseRule_ClassBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_BODY_DECLARATIONS))
        {
            ClassMemberListNode node = parser.parseRule_ClassBodyDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_MODIFIERS))
        {
            ClassModifiersNode node = parser.parseRule_ClassModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_OR_INTERFACE_TYPE_LIST))
        {
            DeclaredTypeListNode node = parser.parseRule_ClassOrInterfaceTypeList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.COMPILATION_UNIT))
        {
            CompilationUnitNode node = parser.parseRule_CompilationUnit(name);
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTANT_DECLARATION))
        {
            ConstantDeclarationNode node = parser.parseRule_ConstantDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTANT_MODIFIERS))
        {
            ConstantModifiersNode node = parser.parseRule_ConstantModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_BODY))
        {
            ConstructorBodyNode node = parser.parseRule_ConstructorBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_DECLARATION))
        {
            ConstructorDeclarationNode node = parser.parseRule_ConstructorDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_MODIFIERS))
        {
            ConstructorModifiersNode node = parser.parseRule_ConstructorModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE))
        {
            AnnotationValueNode node = parser.parseRule_ElementValue();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUES))
        {
            AnnotationValueListNode node = parser.parseRule_ElementValues();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIR))
        {
            AnnotationElementNode node = parser.parseRule_ElementValuePair();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIRS))
        {
            AnnotationElementListNode node = parser.parseRule_ElementValuePairs();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_BODY))
        {
            EnumBodyNode node = parser.parseRule_EnumBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_CONSTANT))
        {
            EnumConstantDeclarationNode node = parser.parseRule_EnumConstant();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_CONSTANTS))
        {
            EnumConstantDeclarationListNode node = parser.parseRule_EnumConstants();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_MODIFIERS))
        {
            EnumModifiersNode node = parser.parseRule_EnumModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.EXCEPTION_TYPE_LIST))
        {
            UnparameterizedTypeListNode node = parser.parseRule_ExceptionTypeList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.EXPLICIT_CONSTRUCTOR_INVOCATION))
        {
            ConstructorInvocationNode node = parser.parseRule_ExplicitConstructorInvocation();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.FIELD_DECLARATION))
        {
            FieldDeclarationNode node = parser.parseRule_FieldDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.FIELD_MODIFIERS))
        {
            FieldModifiersNode node = parser.parseRule_FieldModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.FOR_INIT))
        {
            ForInitializerNode node = parser.parseRule_ForInit();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.FORMAL_PARAMETER))
        {
            VariableNode node = parser.parseRule_FormalParameter();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.IDENTIFIER))
        {
            IdentifierNode node = parser.parseRule_Identifier();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.IDENTIFIER_LIST))
        {
            IdentifierListNode node = parser.parseRule_IdentifierList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATION))
        {
            ImportNode node = parser.parseRule_ImportDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATIONS))
        {
            ImportListNode node = parser.parseRule_ImportDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.INITIALIZER))
        {
            InitializerDeclarationNode node = parser.parseRule_Initializer();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_BODY))
        {
            InterfaceBodyNode node = parser.parseRule_InterfaceBody();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_MEMBER_DECLARATIONS))
        {
            InterfaceMemberListNode node = parser.parseRule_InterfaceMemberDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_MODIFIERS))
        {
            InterfaceModifiersNode node = parser.parseRule_InterfaceModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.JAVADOC_COMMENT))
        {
            JavadocNode node = parser.parseRule_JavadocComment();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.LOCAL_CLASS_MODIFIERS))
        {
            LocalClassModifiersNode node = parser.parseRule_LocalClassModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION))
        {
            MetaAnnotationNode node = parser.parseRule_MetaAnnotation();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_LIST))
        {
            MetaAnnotationListNode node = parser.parseRule_MetaAnnotationList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT))
        {
            MetaAnnotationElementNode node = parser.parseRule_MetaAnnotationElement();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENTS))
        {
            MetaAnnotationElementListNode node = parser.parseRule_MetaAnnotationElements();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUE))
        {
            MetaAnnotationValueNode node = parser.parseRule_MetaAnnotationElementValue();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUES))
        {
            MetaAnnotationValueListNode node = parser.parseRule_MetaAnnotationElementValues();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METHOD_DECLARATION))
        {
            MethodDeclarationNode node = parser.parseRule_MethodDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM))
        {
            MetaprogramNode node = parser.parseRule_Metaprogram();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY))
        {
            MetaprogramDependencyNode node = parser.parseRule_MetaprogramDependency();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION))
        {
            MetaprogramDependencyDeclarationNode node = parser.parseRule_MetaprogramDependencyDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION_LIST))
        {
            MetaprogramDependencyDeclarationListNode node = parser.parseRule_MetaprogramDependencyDeclarationList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_LIST))
        {
            MetaprogramDependencyListNode node = parser.parseRule_MetaprogramDependencyList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION))
        {
            MetaprogramImportNode node = parser.parseRule_MetaprogramImportDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION_LIST))
        {
            MetaprogramImportListNode node = parser.parseRule_MetaprogramImportDeclarationList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION))
        {
            MetaprogramTargetNode node = parser.parseRule_MetaprogramTargetDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION_LIST))
        {
            MetaprogramTargetListNode node = parser.parseRule_MetaprogramTargetDeclarationList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.METHOD_MODIFIERS))
        {
            MethodModifiersNode node = parser.parseRule_MethodModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.NAME))
        {
            NameNode node = parser.parseRule_Name();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.PACKAGE_DECLARATION))
        {
            PackageDeclarationNode node = parser.parseRule_PackageDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.PREAMBLE))
        {
            MetaprogramPreambleNode node = parser.parseRule_Preamble();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.REFERENCE_TYPE_LIST))
        {
            ReferenceTypeListNode node = parser.parseRule_ReferenceTypeList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.STATEMENT_EXPRESSION_LIST))
        {
            StatementExpressionListNode node = parser.parseRule_StatementExpressionList();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUP))
        {
            CaseNode node = parser.parseRule_SwitchBlockStatementGroup();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUPS))
        {
            CaseListNode node = parser.parseRule_SwitchBlockStatementGroups();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE))
        {
            TypeNode node = parser.parseRule_Type();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_ARGUMENTS))
        {
            TypeArgumentListNode node = parser.parseRule_TypeArguments();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_DECLARATION))
        {
            TypeDeclarationNode node = parser.parseRule_TypeDeclaration();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_DECLARATIONS))
        {
            TypeDeclarationListNode node = parser.parseRule_TypeDeclarations();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_PARAMETER))
        {
            TypeParameterNode node = parser.parseRule_TypeParameter();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_PARAMETERS))
        {
            TypeParameterListNode node = parser.parseRule_TypeParameters();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATOR))
        {
            VariableDeclaratorNode node = parser.parseRule_VariableDeclarator();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATORS))
        {
            VariableDeclaratorListNode node = parser.parseRule_VariableDeclarators();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZER))
        {
            VariableInitializerNode node = parser.parseRule_VariableInitializer();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZERS))
        {
            VariableInitializerListNode node = parser.parseRule_VariableInitializers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_MODIFIERS))
        {
            VariableModifiersNode node = parser.parseRule_VariableModifiers();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        if (rule.equals(ParseRule.WILDCARD))
        {
            WildcardTypeNode node = parser.parseRule_Wildcard();
            @SuppressWarnings("unchecked") T ret = (T)node;
            return ret;
        }
        throw new IllegalStateException("Unrecognized parse rule " + rule);
    }
    
}
