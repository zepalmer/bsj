package edu.jhu.cs.bsj.compiler.tool.parser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

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

/**
 * This class is used as an enum-like structure which defines the parse rules set forth in the BSJ Language
 * Specification with respect to code literals.  As a result of the need for a type parameter, the Java <tt>enum</tt>
 * type could not be used.  Each of these elements represents a single parse rule which can be provided to a
 * {@link BsjParser}.
 * 
 * @param <T> An upper bound on the type of node that this parse rule produces.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParseRule<T extends Node>
{
	private Class<T> nodeClass;
	
	private ParseRule(Class<T> nodeClass)
	{
		this.nodeClass = nodeClass;
	}
	
	/**
	 * Retrieves the type of node which is produced by this parse rule.
	 * @return The type of node produced by this parse rule.
	 */
	public Class<T> getNodeClass()
	{
		return this.nodeClass;
	}
    public static final ParseRule<AnnotationMethodModifiersNode> ABSTRACT_METHOD_MODIFIERS = 
        new ParseRule<AnnotationMethodModifiersNode>(AnnotationMethodModifiersNode.class);
    
    public static final ParseRule<AnnotationNode> ANNOTATION = 
        new ParseRule<AnnotationNode>(AnnotationNode.class);
    
    public static final ParseRule<AnnotationListNode> ANNOTATIONS = 
        new ParseRule<AnnotationListNode>(AnnotationListNode.class);
    
    public static final ParseRule<AnnotationModifiersNode> ANNOTATION_MODIFIERS = 
        new ParseRule<AnnotationModifiersNode>(AnnotationModifiersNode.class);
    
    public static final ParseRule<AnnotationBodyNode> ANNOTATION_TYPE_BODY = 
        new ParseRule<AnnotationBodyNode>(AnnotationBodyNode.class);
    
    public static final ParseRule<AnnotationMemberListNode> ANNOTATION_TYPE_ELEMENT_DECLARATIONS = 
        new ParseRule<AnnotationMemberListNode>(AnnotationMemberListNode.class);
    
    public static final ParseRule<AnnotationMemberNode> ANNOTATION_TYPE_ELEMENT_DECLARATION = 
        new ParseRule<AnnotationMemberNode>(AnnotationMemberNode.class);
    
    public static final ParseRule<AnonymousClassBodyNode> ANONYMOUS_CLASS_BODY = 
        new ParseRule<AnonymousClassBodyNode>(AnonymousClassBodyNode.class);
    
    public static final ParseRule<AnonymousClassMemberListNode> ANONYMOUS_CLASS_BODY_DECLARATIONS = 
        new ParseRule<AnonymousClassMemberListNode>(AnonymousClassMemberListNode.class);
    
    public static final ParseRule<ClassMemberNode> ANONYMOUS_CLASS_BODY_DECLARATION = 
        new ParseRule<ClassMemberNode>(ClassMemberNode.class);
    
    public static final ParseRule<ExpressionListNode> ARGUMENT_LIST = 
        new ParseRule<ExpressionListNode>(ExpressionListNode.class);
    
    public static final ParseRule<BlockStatementNode> BLOCK_STATEMENT = 
        new ParseRule<BlockStatementNode>(BlockStatementNode.class);
    
    public static final ParseRule<BlockStatementListNode> BLOCK_STATEMENTS = 
        new ParseRule<BlockStatementListNode>(BlockStatementListNode.class);
    
    public static final ParseRule<CatchNode> CATCH_CLAUSE = 
        new ParseRule<CatchNode>(CatchNode.class);
    
    public static final ParseRule<CatchListNode> CATCHES = 
        new ParseRule<CatchListNode>(CatchListNode.class);
    
    public static final ParseRule<ClassBodyNode> CLASS_BODY = 
        new ParseRule<ClassBodyNode>(ClassBodyNode.class);
    
    public static final ParseRule<ClassMemberNode> CLASS_BODY_DECLARATION = 
        new ParseRule<ClassMemberNode>(ClassMemberNode.class);
    
    public static final ParseRule<ClassMemberListNode> CLASS_BODY_DECLARATIONS = 
        new ParseRule<ClassMemberListNode>(ClassMemberListNode.class);
    
    public static final ParseRule<ClassModifiersNode> CLASS_MODIFIERS = 
        new ParseRule<ClassModifiersNode>(ClassModifiersNode.class);
    
    public static final ParseRule<DeclaredTypeListNode> CLASS_OR_INTERFACE_TYPE_LIST = 
        new ParseRule<DeclaredTypeListNode>(DeclaredTypeListNode.class);
    
    public static final ParseRule<CompilationUnitNode> COMPILATION_UNIT = 
        new ParseRule<CompilationUnitNode>(CompilationUnitNode.class);
    
    public static final ParseRule<ConstantDeclarationNode> CONSTANT_DECLARATION = 
        new ParseRule<ConstantDeclarationNode>(ConstantDeclarationNode.class);
    
    public static final ParseRule<ConstantModifiersNode> CONSTANT_MODIFIERS = 
        new ParseRule<ConstantModifiersNode>(ConstantModifiersNode.class);
    
    public static final ParseRule<ConstructorBodyNode> CONSTRUCTOR_BODY = 
        new ParseRule<ConstructorBodyNode>(ConstructorBodyNode.class);
    
    public static final ParseRule<ConstructorModifiersNode> CONSTRUCTOR_MODIFIERS = 
        new ParseRule<ConstructorModifiersNode>(ConstructorModifiersNode.class);
    
    public static final ParseRule<AnnotationValueNode> ELEMENT_VALUE = 
        new ParseRule<AnnotationValueNode>(AnnotationValueNode.class);
    
    public static final ParseRule<AnnotationValueListNode> ELEMENT_VALUES = 
        new ParseRule<AnnotationValueListNode>(AnnotationValueListNode.class);
    
    public static final ParseRule<AnnotationElementNode> ELEMENT_VALUE_PAIR = 
        new ParseRule<AnnotationElementNode>(AnnotationElementNode.class);
    
    public static final ParseRule<AnnotationElementListNode> ELEMENT_VALUE_PAIRS = 
        new ParseRule<AnnotationElementListNode>(AnnotationElementListNode.class);
    
    public static final ParseRule<EnumBodyNode> ENUM_BODY = 
        new ParseRule<EnumBodyNode>(EnumBodyNode.class);
    
    public static final ParseRule<EnumConstantDeclarationNode> ENUM_CONSTANT = 
        new ParseRule<EnumConstantDeclarationNode>(EnumConstantDeclarationNode.class);
    
    public static final ParseRule<EnumConstantDeclarationListNode> ENUM_CONSTANTS = 
        new ParseRule<EnumConstantDeclarationListNode>(EnumConstantDeclarationListNode.class);
    
    public static final ParseRule<EnumModifiersNode> ENUM_MODIFIERS = 
        new ParseRule<EnumModifiersNode>(EnumModifiersNode.class);
    
    public static final ParseRule<UnparameterizedTypeListNode> EXCEPTION_TYPE_LIST = 
        new ParseRule<UnparameterizedTypeListNode>(UnparameterizedTypeListNode.class);
    
    public static final ParseRule<ConstructorInvocationNode> EXPLICIT_CONSTRUCTOR_INVOCATION = 
        new ParseRule<ConstructorInvocationNode>(ConstructorInvocationNode.class);
    
    public static final ParseRule<FieldModifiersNode> FIELD_MODIFIERS = 
        new ParseRule<FieldModifiersNode>(FieldModifiersNode.class);
    
    public static final ParseRule<ForInitializerNode> FOR_INIT = 
        new ParseRule<ForInitializerNode>(ForInitializerNode.class);
    
    public static final ParseRule<VariableNode> FORMAL_PARAMETER = 
        new ParseRule<VariableNode>(VariableNode.class);
    
    public static final ParseRule<IdentifierNode> IDENTIFIER = 
        new ParseRule<IdentifierNode>(IdentifierNode.class);
    
    public static final ParseRule<IdentifierListNode> IDENTIFIER_LIST = 
        new ParseRule<IdentifierListNode>(IdentifierListNode.class);
    
    public static final ParseRule<ImportNode> IMPORT_DECLARATION = 
        new ParseRule<ImportNode>(ImportNode.class);
    
    public static final ParseRule<ImportListNode> IMPORT_DECLARATIONS = 
        new ParseRule<ImportListNode>(ImportListNode.class);
    
    public static final ParseRule<InterfaceBodyNode> INTERFACE_BODY = 
        new ParseRule<InterfaceBodyNode>(InterfaceBodyNode.class);
    
    public static final ParseRule<InterfaceMemberNode> INTERFACE_MEMBER_DECLARATION = 
        new ParseRule<InterfaceMemberNode>(InterfaceMemberNode.class);
    
    public static final ParseRule<InterfaceMemberListNode> INTERFACE_MEMBER_DECLARATIONS = 
        new ParseRule<InterfaceMemberListNode>(InterfaceMemberListNode.class);
    
    public static final ParseRule<InterfaceModifiersNode> INTERFACE_MODIFIERS = 
        new ParseRule<InterfaceModifiersNode>(InterfaceModifiersNode.class);
    
    public static final ParseRule<JavadocNode> JAVADOC_COMMENT = 
        new ParseRule<JavadocNode>(JavadocNode.class);
    
    public static final ParseRule<LocalClassDeclarationNode> LOCAL_CLASS_DECLARATION = 
        new ParseRule<LocalClassDeclarationNode>(LocalClassDeclarationNode.class);
    
    public static final ParseRule<LocalClassModifiersNode> LOCAL_CLASS_MODIFIERS = 
        new ParseRule<LocalClassModifiersNode>(LocalClassModifiersNode.class);
    
    public static final ParseRule<MetaAnnotationNode> META_ANNOTATION = 
        new ParseRule<MetaAnnotationNode>(MetaAnnotationNode.class);
    
    public static final ParseRule<MetaAnnotationListNode> META_ANNOTATION_LIST = 
        new ParseRule<MetaAnnotationListNode>(MetaAnnotationListNode.class);
    
    public static final ParseRule<MetaAnnotationElementNode> META_ANNOTATION_ELEMENT = 
        new ParseRule<MetaAnnotationElementNode>(MetaAnnotationElementNode.class);
    
    public static final ParseRule<MetaAnnotationElementListNode> META_ANNOTATION_ELEMENTS = 
        new ParseRule<MetaAnnotationElementListNode>(MetaAnnotationElementListNode.class);
    
    public static final ParseRule<MetaAnnotationValueNode> META_ANNOTATION_ELEMENT_VALUE = 
        new ParseRule<MetaAnnotationValueNode>(MetaAnnotationValueNode.class);
    
    public static final ParseRule<MetaAnnotationValueListNode> META_ANNOTATION_ELEMENT_VALUES = 
        new ParseRule<MetaAnnotationValueListNode>(MetaAnnotationValueListNode.class);
    
    public static final ParseRule<MetaprogramNode> METAPROGRAM = 
        new ParseRule<MetaprogramNode>(MetaprogramNode.class);
    
    public static final ParseRule<MetaprogramDependencyNode> METAPROGRAM_DEPENDENCY = 
        new ParseRule<MetaprogramDependencyNode>(MetaprogramDependencyNode.class);
    
    public static final ParseRule<MetaprogramDependencyDeclarationNode> METAPROGRAM_DEPENDENCY_DECLARATION = 
        new ParseRule<MetaprogramDependencyDeclarationNode>(MetaprogramDependencyDeclarationNode.class);
    
    public static final ParseRule<MetaprogramDependencyDeclarationListNode> METAPROGRAM_DEPENDENCY_DECLARATION_LIST = 
        new ParseRule<MetaprogramDependencyDeclarationListNode>(MetaprogramDependencyDeclarationListNode.class);
    
    public static final ParseRule<MetaprogramDependencyListNode> METAPROGRAM_DEPENDENCY_LIST = 
        new ParseRule<MetaprogramDependencyListNode>(MetaprogramDependencyListNode.class);
    
    public static final ParseRule<MetaprogramImportNode> METAPROGRAM_IMPORT_DECLARATION = 
        new ParseRule<MetaprogramImportNode>(MetaprogramImportNode.class);
    
    public static final ParseRule<MetaprogramImportListNode> METAPROGRAM_IMPORT_DECLARATION_LIST = 
        new ParseRule<MetaprogramImportListNode>(MetaprogramImportListNode.class);
    
    public static final ParseRule<MetaprogramTargetNode> METAPROGRAM_TARGET_DECLARATION = 
        new ParseRule<MetaprogramTargetNode>(MetaprogramTargetNode.class);
    
    public static final ParseRule<MetaprogramTargetListNode> METAPROGRAM_TARGET_DECLARATION_LIST = 
        new ParseRule<MetaprogramTargetListNode>(MetaprogramTargetListNode.class);
    
    public static final ParseRule<MethodModifiersNode> METHOD_MODIFIERS = 
        new ParseRule<MethodModifiersNode>(MethodModifiersNode.class);
    
    public static final ParseRule<NameNode> NAME = 
        new ParseRule<NameNode>(NameNode.class);
    
    public static final ParseRule<PackageDeclarationNode> PACKAGE_DECLARATION = 
        new ParseRule<PackageDeclarationNode>(PackageDeclarationNode.class);
    
    public static final ParseRule<MetaprogramPreambleNode> PREAMBLE = 
        new ParseRule<MetaprogramPreambleNode>(MetaprogramPreambleNode.class);
    
    public static final ParseRule<ReferenceTypeListNode> REFERENCE_TYPE_LIST = 
        new ParseRule<ReferenceTypeListNode>(ReferenceTypeListNode.class);
    
    public static final ParseRule<StatementExpressionListNode> STATEMENT_EXPRESSION_LIST = 
        new ParseRule<StatementExpressionListNode>(StatementExpressionListNode.class);
    
    public static final ParseRule<CaseNode> SWITCH_BLOCK_STATEMENT_GROUP = 
        new ParseRule<CaseNode>(CaseNode.class);
    
    public static final ParseRule<CaseListNode> SWITCH_BLOCK_STATEMENT_GROUPS = 
        new ParseRule<CaseListNode>(CaseListNode.class);
    
    public static final ParseRule<TypeNode> TYPE = 
        new ParseRule<TypeNode>(TypeNode.class);
    
    public static final ParseRule<TypeArgumentListNode> TYPE_ARGUMENTS = 
        new ParseRule<TypeArgumentListNode>(TypeArgumentListNode.class);
    
    public static final ParseRule<TypeDeclarationNode> TYPE_DECLARATION = 
        new ParseRule<TypeDeclarationNode>(TypeDeclarationNode.class);
    
    public static final ParseRule<TypeDeclarationListNode> TYPE_DECLARATIONS = 
        new ParseRule<TypeDeclarationListNode>(TypeDeclarationListNode.class);
    
    public static final ParseRule<TypeParameterNode> TYPE_PARAMETER = 
        new ParseRule<TypeParameterNode>(TypeParameterNode.class);
    
    public static final ParseRule<TypeParameterListNode> TYPE_PARAMETERS = 
        new ParseRule<TypeParameterListNode>(TypeParameterListNode.class);
    
    public static final ParseRule<VariableDeclaratorNode> VARIABLE_DECLARATOR = 
        new ParseRule<VariableDeclaratorNode>(VariableDeclaratorNode.class);
    
    public static final ParseRule<VariableDeclaratorListNode> VARIABLE_DECLARATORS = 
        new ParseRule<VariableDeclaratorListNode>(VariableDeclaratorListNode.class);
    
    public static final ParseRule<VariableInitializerNode> VARIABLE_INITIALIZER = 
        new ParseRule<VariableInitializerNode>(VariableInitializerNode.class);
    
    public static final ParseRule<VariableInitializerListNode> VARIABLE_INITIALIZERS = 
        new ParseRule<VariableInitializerListNode>(VariableInitializerListNode.class);
    
    public static final ParseRule<VariableModifiersNode> VARIABLE_MODIFIERS = 
        new ParseRule<VariableModifiersNode>(VariableModifiersNode.class);
    
    public static final ParseRule<WildcardTypeNode> WILDCARD = 
        new ParseRule<WildcardTypeNode>(WildcardTypeNode.class);
    
    private static Iterable<? extends ParseRule<?>> valuesIterable = null;
    public static Iterable<? extends ParseRule<?>> values()
    {
        if (valuesIterable == null)
        {
            List<ParseRule<?>> list = new ArrayList<ParseRule<?>>(84);
            list.add(ABSTRACT_METHOD_MODIFIERS);
            list.add(ANNOTATION);
            list.add(ANNOTATIONS);
            list.add(ANNOTATION_MODIFIERS);
            list.add(ANNOTATION_TYPE_BODY);
            list.add(ANNOTATION_TYPE_ELEMENT_DECLARATIONS);
            list.add(ANNOTATION_TYPE_ELEMENT_DECLARATION);
            list.add(ANONYMOUS_CLASS_BODY);
            list.add(ANONYMOUS_CLASS_BODY_DECLARATIONS);
            list.add(ANONYMOUS_CLASS_BODY_DECLARATION);
            list.add(ARGUMENT_LIST);
            list.add(BLOCK_STATEMENT);
            list.add(BLOCK_STATEMENTS);
            list.add(CATCH_CLAUSE);
            list.add(CATCHES);
            list.add(CLASS_BODY);
            list.add(CLASS_BODY_DECLARATION);
            list.add(CLASS_BODY_DECLARATIONS);
            list.add(CLASS_MODIFIERS);
            list.add(CLASS_OR_INTERFACE_TYPE_LIST);
            list.add(COMPILATION_UNIT);
            list.add(CONSTANT_DECLARATION);
            list.add(CONSTANT_MODIFIERS);
            list.add(CONSTRUCTOR_BODY);
            list.add(CONSTRUCTOR_MODIFIERS);
            list.add(ELEMENT_VALUE);
            list.add(ELEMENT_VALUES);
            list.add(ELEMENT_VALUE_PAIR);
            list.add(ELEMENT_VALUE_PAIRS);
            list.add(ENUM_BODY);
            list.add(ENUM_CONSTANT);
            list.add(ENUM_CONSTANTS);
            list.add(ENUM_MODIFIERS);
            list.add(EXCEPTION_TYPE_LIST);
            list.add(EXPLICIT_CONSTRUCTOR_INVOCATION);
            list.add(FIELD_MODIFIERS);
            list.add(FOR_INIT);
            list.add(FORMAL_PARAMETER);
            list.add(IDENTIFIER);
            list.add(IDENTIFIER_LIST);
            list.add(IMPORT_DECLARATION);
            list.add(IMPORT_DECLARATIONS);
            list.add(INTERFACE_BODY);
            list.add(INTERFACE_MEMBER_DECLARATION);
            list.add(INTERFACE_MEMBER_DECLARATIONS);
            list.add(INTERFACE_MODIFIERS);
            list.add(JAVADOC_COMMENT);
            list.add(LOCAL_CLASS_DECLARATION);
            list.add(LOCAL_CLASS_MODIFIERS);
            list.add(META_ANNOTATION);
            list.add(META_ANNOTATION_LIST);
            list.add(META_ANNOTATION_ELEMENT);
            list.add(META_ANNOTATION_ELEMENTS);
            list.add(META_ANNOTATION_ELEMENT_VALUE);
            list.add(META_ANNOTATION_ELEMENT_VALUES);
            list.add(METAPROGRAM);
            list.add(METAPROGRAM_DEPENDENCY);
            list.add(METAPROGRAM_DEPENDENCY_DECLARATION);
            list.add(METAPROGRAM_DEPENDENCY_DECLARATION_LIST);
            list.add(METAPROGRAM_DEPENDENCY_LIST);
            list.add(METAPROGRAM_IMPORT_DECLARATION);
            list.add(METAPROGRAM_IMPORT_DECLARATION_LIST);
            list.add(METAPROGRAM_TARGET_DECLARATION);
            list.add(METAPROGRAM_TARGET_DECLARATION_LIST);
            list.add(METHOD_MODIFIERS);
            list.add(NAME);
            list.add(PACKAGE_DECLARATION);
            list.add(PREAMBLE);
            list.add(REFERENCE_TYPE_LIST);
            list.add(STATEMENT_EXPRESSION_LIST);
            list.add(SWITCH_BLOCK_STATEMENT_GROUP);
            list.add(SWITCH_BLOCK_STATEMENT_GROUPS);
            list.add(TYPE);
            list.add(TYPE_ARGUMENTS);
            list.add(TYPE_DECLARATION);
            list.add(TYPE_DECLARATIONS);
            list.add(TYPE_PARAMETER);
            list.add(TYPE_PARAMETERS);
            list.add(VARIABLE_DECLARATOR);
            list.add(VARIABLE_DECLARATORS);
            list.add(VARIABLE_INITIALIZER);
            list.add(VARIABLE_INITIALIZERS);
            list.add(VARIABLE_MODIFIERS);
            list.add(WILDCARD);
            valuesIterable = list;
        }
        return valuesIterable;
    }
    
}
