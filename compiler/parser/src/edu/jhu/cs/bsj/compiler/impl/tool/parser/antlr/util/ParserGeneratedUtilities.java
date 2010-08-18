package edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.util;

import javax.annotation.Generated;

import org.antlr.runtime.RecognitionException;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassModifiersNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
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
    public static <T extends Node> T parseFromAntlr(BsjAntlrParser parser, ParseRule<T> rule)
        throws RecognitionException
    {
        if (rule == null)
        {
            throw new IllegalArgumentException("Parse rule cannot be null.");
        }
        if (rule.equals(ParseRule.ABSTRACT_METHOD_MODIFIERS))
        {
            AnnotationMethodModifiersNode node = parser.parseRule_AbstractMethodModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATION))
        {
            AnnotationNode node = parser.parseRule_Annotation();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATIONS))
        {
            AnnotationListNode node = parser.parseRule_Annotations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATION_MODIFIERS))
        {
            AnnotationModifiersNode node = parser.parseRule_AnnotationModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_BODY))
        {
            AnnotationBodyNode node = parser.parseRule_AnnotationTypeBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_ELEMENT_DECLARATIONS))
        {
            AnnotationMemberListNode node = parser.parseRule_AnnotationTypeElementDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANNOTATION_TYPE_ELEMENT_DECLARATION))
        {
            AnnotationMemberNode node = parser.parseRule_AnnotationTypeElementDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY))
        {
            AnonymousClassBodyNode node = parser.parseRule_AnonymousClassBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ANONYMOUS_CLASS_BODY_DECLARATIONS))
        {
            AnonymousClassMemberListNode node = parser.parseRule_AnonymousClassBodyDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ARGUMENT_LIST))
        {
            ExpressionListNode node = parser.parseRule_ArgumentList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENT))
        {
            BlockStatementNode node = parser.parseRule_BlockStatement();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.BLOCK_STATEMENTS))
        {
            BlockStatementListNode node = parser.parseRule_BlockStatements();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CATCH_CLAUSE))
        {
            CatchNode node = parser.parseRule_CatchClause();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CATCHES))
        {
            CatchListNode node = parser.parseRule_Catches();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CLASS_BODY))
        {
            ClassBodyNode node = parser.parseRule_ClassBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CLASS_BODY_DECLARATION))
        {
            ClassMemberNode node = parser.parseRule_ClassBodyDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CLASS_BODY_DECLARATIONS))
        {
            ClassMemberListNode node = parser.parseRule_ClassBodyDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CLASS_MODIFIERS))
        {
            ClassModifiersNode node = parser.parseRule_ClassModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CLASS_OR_INTERFACE_TYPE_LIST))
        {
            DeclaredTypeListNode node = parser.parseRule_ClassOrInterfaceTypeList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.COMPILATION_UNIT))
        {
            CompilationUnitNode node = parser.parseRule_CompilationUnit();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CONSTANT_DECLARATION))
        {
            ConstantDeclarationNode node = parser.parseRule_ConstantDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CONSTANT_MODIFIERS))
        {
            ConstantModifiersNode node = parser.parseRule_ConstantModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_BODY))
        {
            ConstructorBodyNode node = parser.parseRule_ConstructorBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.CONSTRUCTOR_MODIFIERS))
        {
            ConstructorModifiersNode node = parser.parseRule_ConstructorModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE))
        {
            AnnotationValueNode node = parser.parseRule_ElementValue();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ELEMENT_VALUES))
        {
            AnnotationValueListNode node = parser.parseRule_ElementValues();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIR))
        {
            AnnotationElementNode node = parser.parseRule_ElementValuePair();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ELEMENT_VALUE_PAIRS))
        {
            AnnotationElementListNode node = parser.parseRule_ElementValuePairs();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ENUM_BODY))
        {
            EnumBodyNode node = parser.parseRule_EnumBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ENUM_CONSTANT))
        {
            EnumConstantDeclarationNode node = parser.parseRule_EnumConstant();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ENUM_CONSTANTS))
        {
            EnumConstantDeclarationListNode node = parser.parseRule_EnumConstants();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.ENUM_MODIFIERS))
        {
            EnumModifiersNode node = parser.parseRule_EnumModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.EXCEPTION_TYPE_LIST))
        {
            UnparameterizedTypeListNode node = parser.parseRule_ExceptionTypeList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.EXPLICIT_CONSTRUCTOR_INVOCATION))
        {
            ConstructorInvocationNode node = parser.parseRule_ExplicitConstructorInvocation();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.FIELD_MODIFIERS))
        {
            FieldModifiersNode node = parser.parseRule_FieldModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.FOR_INIT))
        {
            ForInitializerNode node = parser.parseRule_ForInit();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.FORMAL_PARAMETER))
        {
            VariableNode node = parser.parseRule_FormalParameter();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.FORMAL_PARAMETERS))
        {
            VariableListNode node = parser.parseRule_FormalParameters();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.IDENTIFIER))
        {
            IdentifierNode node = parser.parseRule_Identifier();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.IDENTIFIER_LIST))
        {
            IdentifierListNode node = parser.parseRule_IdentifierList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATION))
        {
            ImportNode node = parser.parseRule_ImportDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.IMPORT_DECLARATIONS))
        {
            ImportListNode node = parser.parseRule_ImportDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.INTERFACE_BODY))
        {
            InterfaceBodyNode node = parser.parseRule_InterfaceBody();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.INTERFACE_MEMBER_DECLARATION))
        {
            InterfaceMemberNode node = parser.parseRule_InterfaceMemberDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.INTERFACE_MEMBER_DECLARATIONS))
        {
            InterfaceMemberListNode node = parser.parseRule_InterfaceMemberDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.INTERFACE_MODIFIERS))
        {
            InterfaceModifiersNode node = parser.parseRule_InterfaceModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.JAVADOC_COMMENT))
        {
            JavadocNode node = parser.parseRule_JavadocComment();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.LOCAL_CLASS_DECLARATION))
        {
            LocalClassDeclarationNode node = parser.parseRule_LocalClassDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.LOCAL_CLASS_MODIFIERS))
        {
            LocalClassModifiersNode node = parser.parseRule_LocalClassModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION))
        {
            MetaAnnotationNode node = parser.parseRule_MetaAnnotation();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION_LIST))
        {
            MetaAnnotationListNode node = parser.parseRule_MetaAnnotationList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT))
        {
            MetaAnnotationElementNode node = parser.parseRule_MetaAnnotationElement();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENTS))
        {
            MetaAnnotationElementListNode node = parser.parseRule_MetaAnnotationElements();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUE))
        {
            MetaAnnotationValueNode node = parser.parseRule_MetaAnnotationElementValue();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.META_ANNOTATION_ELEMENT_VALUES))
        {
            MetaAnnotationValueListNode node = parser.parseRule_MetaAnnotationElementValues();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM))
        {
            MetaprogramNode node = parser.parseRule_Metaprogram();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY))
        {
            MetaprogramDependencyNode node = parser.parseRule_MetaprogramDependency();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION))
        {
            MetaprogramDependencyDeclarationNode node = parser.parseRule_MetaprogramDependencyDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_DECLARATION_LIST))
        {
            MetaprogramDependencyDeclarationListNode node = parser.parseRule_MetaprogramDependencyDeclarationList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_DEPENDENCY_LIST))
        {
            MetaprogramDependencyListNode node = parser.parseRule_MetaprogramDependencyList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION))
        {
            MetaprogramImportNode node = parser.parseRule_MetaprogramImportDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_IMPORT_DECLARATION_LIST))
        {
            MetaprogramImportListNode node = parser.parseRule_MetaprogramImportDeclarationList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION))
        {
            MetaprogramTargetNode node = parser.parseRule_MetaprogramTargetDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METAPROGRAM_TARGET_DECLARATION_LIST))
        {
            MetaprogramTargetListNode node = parser.parseRule_MetaprogramTargetDeclarationList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.METHOD_MODIFIERS))
        {
            MethodModifiersNode node = parser.parseRule_MethodModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.NAME))
        {
            NameNode node = parser.parseRule_Name();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.PACKAGE_DECLARATION))
        {
            PackageDeclarationNode node = parser.parseRule_PackageDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.PREAMBLE))
        {
            MetaprogramPreambleNode node = parser.parseRule_Preamble();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.REFERENCE_TYPE_LIST))
        {
            ReferenceTypeListNode node = parser.parseRule_ReferenceTypeList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.STATEMENT_EXPRESSION_LIST))
        {
            StatementExpressionListNode node = parser.parseRule_StatementExpressionList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUP))
        {
            CaseNode node = parser.parseRule_SwitchBlockStatementGroup();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.SWITCH_BLOCK_STATEMENT_GROUPS))
        {
            CaseListNode node = parser.parseRule_SwitchBlockStatementGroups();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE))
        {
            TypeNode node = parser.parseRule_Type();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE_ARGUMENT_LIST))
        {
            TypeArgumentListNode node = parser.parseRule_TypeArgumentList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE_DECLARATION))
        {
            TypeDeclarationNode node = parser.parseRule_TypeDeclaration();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE_DECLARATIONS))
        {
            TypeDeclarationListNode node = parser.parseRule_TypeDeclarations();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE_PARAMETER))
        {
            TypeParameterNode node = parser.parseRule_TypeParameter();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.TYPE_PARAMETER_LIST))
        {
            TypeParameterListNode node = parser.parseRule_TypeParameterList();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATOR))
        {
            VariableDeclaratorNode node = parser.parseRule_VariableDeclarator();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.VARIABLE_DECLARATORS))
        {
            VariableDeclaratorListNode node = parser.parseRule_VariableDeclarators();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZER))
        {
            VariableInitializerNode node = parser.parseRule_VariableInitializer();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.VARIABLE_INITIALIZERS))
        {
            VariableInitializerListNode node = parser.parseRule_VariableInitializers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.VARIABLE_MODIFIERS))
        {
            VariableModifiersNode node = parser.parseRule_VariableModifiers();
            return rule.getNodeClass().cast(node);
        }
        if (rule.equals(ParseRule.WILDCARD))
        {
            WildcardTypeNode node = parser.parseRule_Wildcard();
            return rule.getNodeClass().cast(node);
        }
        throw new IllegalStateException("Unrecognized parse rule " + rule);
    }
    
}
