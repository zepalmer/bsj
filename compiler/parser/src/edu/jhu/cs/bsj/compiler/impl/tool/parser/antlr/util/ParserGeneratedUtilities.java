/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.util;

import javax.annotation.Generated;

import org.antlr.runtime.RecognitionException;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
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
    public static <T extends Node> NodeUnion<? extends T> parseFromAntlr(BsjAntlrParser parser, ParseRule<T> rule, String name)
        throws RecognitionException
    {
        if (rule == null)
        {
            throw new IllegalArgumentException("Parse rule cannot be null.");
        }
        if (rule.equals(ParseRule.ABSTRACT_METHOD_MODIFIERS))
        {
            NodeUnion<? extends AnnotationMethodModifiersNode> node = parser.parseRule_AbstractMethodModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION))
        {
            NodeUnion<? extends AnnotationNode> node = parser.parseRule_Annotation();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATIONS))
        {
            NodeUnion<? extends AnnotationListNode> node = parser.parseRule_Annotations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_METHOD_DECLARATION))
        {
            NodeUnion<? extends AnnotationMethodDeclarationNode> node = parser.parseRule_AnnotationMethodDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_MODIFIERS))
        {
            NodeUnion<? extends AnnotationModifiersNode> node = parser.parseRule_AnnotationModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_BODY))
        {
            NodeUnion<? extends AnnotationBodyNode> node = parser.parseRule_AnnotationTypeBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_ELEMENT_DECLARATIONS))
        {
            NodeUnion<? extends AnnotationMemberListNode> node = parser.parseRule_AnnotationTypeElementDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY))
        {
            NodeUnion<? extends AnonymousClassBodyNode> node = parser.parseRule_AnonymousClassBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY_DECLARATIONS))
        {
            NodeUnion<? extends AnonymousClassMemberListNode> node = parser.parseRule_AnonymousClassBodyDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ARGUMENT_LIST))
        {
            NodeUnion<? extends ExpressionListNode> node = parser.parseRule_ArgumentList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENT))
        {
            NodeUnion<? extends BlockStatementNode> node = parser.parseRule_BlockStatement();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENTS))
        {
            NodeUnion<? extends BlockStatementListNode> node = parser.parseRule_BlockStatements();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CATCH_CLAUSE))
        {
            NodeUnion<? extends CatchNode> node = parser.parseRule_CatchClause();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CATCHES))
        {
            NodeUnion<? extends CatchListNode> node = parser.parseRule_Catches();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_BODY))
        {
            NodeUnion<? extends ClassBodyNode> node = parser.parseRule_ClassBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_BODY_DECLARATIONS))
        {
            NodeUnion<? extends ClassMemberListNode> node = parser.parseRule_ClassBodyDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_MODIFIERS))
        {
            NodeUnion<? extends ClassModifiersNode> node = parser.parseRule_ClassModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CLASS_OR_INTERFACE_TYPE_LIST))
        {
            NodeUnion<? extends DeclaredTypeListNode> node = parser.parseRule_ClassOrInterfaceTypeList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.COMPILATION_UNIT))
        {
            NodeUnion<? extends CompilationUnitNode> node = parser.parseRule_CompilationUnit(name);
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTANT_DECLARATION))
        {
            NodeUnion<? extends ConstantDeclarationNode> node = parser.parseRule_ConstantDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTANT_MODIFIERS))
        {
            NodeUnion<? extends ConstantModifiersNode> node = parser.parseRule_ConstantModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_BODY))
        {
            NodeUnion<? extends ConstructorBodyNode> node = parser.parseRule_ConstructorBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_DECLARATION))
        {
            NodeUnion<? extends ConstructorDeclarationNode> node = parser.parseRule_ConstructorDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_MODIFIERS))
        {
            NodeUnion<? extends ConstructorModifiersNode> node = parser.parseRule_ConstructorModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE))
        {
            NodeUnion<? extends AnnotationValueNode> node = parser.parseRule_ElementValue();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUES))
        {
            NodeUnion<? extends AnnotationValueListNode> node = parser.parseRule_ElementValues();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIR))
        {
            NodeUnion<? extends AnnotationElementNode> node = parser.parseRule_ElementValuePair();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIRS))
        {
            NodeUnion<? extends AnnotationElementListNode> node = parser.parseRule_ElementValuePairs();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_BODY))
        {
            NodeUnion<? extends EnumBodyNode> node = parser.parseRule_EnumBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_CONSTANT))
        {
            NodeUnion<? extends EnumConstantDeclarationNode> node = parser.parseRule_EnumConstant();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_CONSTANTS))
        {
            NodeUnion<? extends EnumConstantDeclarationListNode> node = parser.parseRule_EnumConstants();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.ENUM_MODIFIERS))
        {
            NodeUnion<? extends EnumModifiersNode> node = parser.parseRule_EnumModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.EXCEPTION_TYPE_LIST))
        {
            NodeUnion<? extends UnparameterizedTypeListNode> node = parser.parseRule_ExceptionTypeList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.EXPLICIT_CONSTRUCTOR_INVOCATION))
        {
            NodeUnion<? extends ConstructorInvocationNode> node = parser.parseRule_ExplicitConstructorInvocation();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.FIELD_DECLARATION))
        {
            NodeUnion<? extends FieldDeclarationNode> node = parser.parseRule_FieldDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.FIELD_MODIFIERS))
        {
            NodeUnion<? extends FieldModifiersNode> node = parser.parseRule_FieldModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.FOR_INIT))
        {
            NodeUnion<? extends ForInitializerNode> node = parser.parseRule_ForInit();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.FORMAL_PARAMETER))
        {
            NodeUnion<? extends VariableNode> node = parser.parseRule_FormalParameter();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.IDENTIFIER))
        {
            NodeUnion<? extends IdentifierNode> node = parser.parseRule_Identifier();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.IDENTIFIER_LIST))
        {
            NodeUnion<? extends IdentifierListNode> node = parser.parseRule_IdentifierList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATION))
        {
            NodeUnion<? extends ImportNode> node = parser.parseRule_ImportDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATIONS))
        {
            NodeUnion<? extends ImportListNode> node = parser.parseRule_ImportDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.INITIALIZER))
        {
            NodeUnion<? extends InitializerDeclarationNode> node = parser.parseRule_Initializer();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_BODY))
        {
            NodeUnion<? extends InterfaceBodyNode> node = parser.parseRule_InterfaceBody();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_MEMBER_DECLARATIONS))
        {
            NodeUnion<? extends InterfaceMemberListNode> node = parser.parseRule_InterfaceMemberDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.INTERFACE_MODIFIERS))
        {
            NodeUnion<? extends InterfaceModifiersNode> node = parser.parseRule_InterfaceModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.JAVADOC_COMMENT))
        {
            NodeUnion<? extends JavadocNode> node = parser.parseRule_JavadocComment();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.LOCAL_CLASS_MODIFIERS))
        {
            NodeUnion<? extends LocalClassModifiersNode> node = parser.parseRule_LocalClassModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION))
        {
            NodeUnion<? extends MetaAnnotationNode> node = parser.parseRule_MetaAnnotation();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_LIST))
        {
            NodeUnion<? extends MetaAnnotationListNode> node = parser.parseRule_MetaAnnotationList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT))
        {
            NodeUnion<? extends MetaAnnotationElementNode> node = parser.parseRule_MetaAnnotationElement();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENTS))
        {
            NodeUnion<? extends MetaAnnotationElementListNode> node = parser.parseRule_MetaAnnotationElements();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUE))
        {
            NodeUnion<? extends MetaAnnotationValueNode> node = parser.parseRule_MetaAnnotationElementValue();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUES))
        {
            NodeUnion<? extends MetaAnnotationValueListNode> node = parser.parseRule_MetaAnnotationElementValues();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METHOD_DECLARATION))
        {
            NodeUnion<? extends MethodDeclarationNode> node = parser.parseRule_MethodDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM))
        {
            NodeUnion<? extends MetaprogramNode> node = parser.parseRule_Metaprogram();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY))
        {
            NodeUnion<? extends MetaprogramDependencyNode> node = parser.parseRule_MetaprogramDependency();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION))
        {
            NodeUnion<? extends MetaprogramDependencyDeclarationNode> node = parser.parseRule_MetaprogramDependencyDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION_LIST))
        {
            NodeUnion<? extends MetaprogramDependencyDeclarationListNode> node = parser.parseRule_MetaprogramDependencyDeclarationList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_LIST))
        {
            NodeUnion<? extends MetaprogramDependencyListNode> node = parser.parseRule_MetaprogramDependencyList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION))
        {
            NodeUnion<? extends MetaprogramImportNode> node = parser.parseRule_MetaprogramImportDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION_LIST))
        {
            NodeUnion<? extends MetaprogramImportListNode> node = parser.parseRule_MetaprogramImportDeclarationList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION))
        {
            NodeUnion<? extends MetaprogramTargetNode> node = parser.parseRule_MetaprogramTargetDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION_LIST))
        {
            NodeUnion<? extends MetaprogramTargetListNode> node = parser.parseRule_MetaprogramTargetDeclarationList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.METHOD_MODIFIERS))
        {
            NodeUnion<? extends MethodModifiersNode> node = parser.parseRule_MethodModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.NAME))
        {
            NodeUnion<? extends NameNode> node = parser.parseRule_Name();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.PACKAGE_DECLARATION))
        {
            NodeUnion<? extends PackageDeclarationNode> node = parser.parseRule_PackageDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.PREAMBLE))
        {
            NodeUnion<? extends MetaprogramPreambleNode> node = parser.parseRule_Preamble();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.REFERENCE_TYPE_LIST))
        {
            NodeUnion<? extends ReferenceTypeListNode> node = parser.parseRule_ReferenceTypeList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.STATEMENT_EXPRESSION_LIST))
        {
            NodeUnion<? extends StatementExpressionListNode> node = parser.parseRule_StatementExpressionList();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUP))
        {
            NodeUnion<? extends CaseNode> node = parser.parseRule_SwitchBlockStatementGroup();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUPS))
        {
            NodeUnion<? extends CaseListNode> node = parser.parseRule_SwitchBlockStatementGroups();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE))
        {
            NodeUnion<? extends TypeNode> node = parser.parseRule_Type();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_ARGUMENTS))
        {
            NodeUnion<? extends TypeArgumentListNode> node = parser.parseRule_TypeArguments();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_DECLARATION))
        {
            NodeUnion<? extends TypeDeclarationNode> node = parser.parseRule_TypeDeclaration();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_DECLARATIONS))
        {
            NodeUnion<? extends TypeDeclarationListNode> node = parser.parseRule_TypeDeclarations();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_PARAMETER))
        {
            NodeUnion<? extends TypeParameterNode> node = parser.parseRule_TypeParameter();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.TYPE_PARAMETERS))
        {
            NodeUnion<? extends TypeParameterListNode> node = parser.parseRule_TypeParameters();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATOR))
        {
            NodeUnion<? extends VariableDeclaratorNode> node = parser.parseRule_VariableDeclarator();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATORS))
        {
            NodeUnion<? extends VariableDeclaratorListNode> node = parser.parseRule_VariableDeclarators();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZER))
        {
            NodeUnion<? extends VariableInitializerNode> node = parser.parseRule_VariableInitializer();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZERS))
        {
            NodeUnion<? extends VariableInitializerListNode> node = parser.parseRule_VariableInitializers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.VARIABLE_MODIFIERS))
        {
            NodeUnion<? extends VariableModifiersNode> node = parser.parseRule_VariableModifiers();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        if (rule.equals(ParseRule.WILDCARD))
        {
            NodeUnion<? extends WildcardTypeNode> node = parser.parseRule_Wildcard();
            @SuppressWarnings("unchecked") NodeUnion<? extends T> ret = (NodeUnion<T>)node;
            return ret;
        }
        throw new IllegalStateException("Unrecognized parse rule " + rule);
    }
    
}
