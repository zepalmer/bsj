package edu.jhu.cs.bsj.compiler.tool.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.*;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;

/**
 * This class is used as an enum-like structure which defines the parse rules set forth in the BSJ Language
 * Specification with respect to code literals. As a result of the need for a type parameter, the Java <tt>enum</tt>
 * type could not be used. Each of these elements represents a single parse rule which can be provided to a
 * {@link BsjParser}.
 * 
 * @param <T> An upper bound on the type of node that this parse rule produces.
 * 
 * @author Zachary Palmer
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParseRule<T extends Node>
{
	private String name;
	private Collection<Class<? extends T>> bottomMostClasses;

	private ParseRule(String name, Collection<Class<? extends T>> bottomMostClasses)
	{
		this.name = name;
		this.bottomMostClasses = Collections.unmodifiableCollection(bottomMostClasses);
	}
	
	/**
	 * Retrieves a string naming this parse rule.
	 * @return The name of this parse rule.
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Retrieves a collection of the most specific types which can be produced by this parse rule.
	 * 
	 * @return The most specific types which can be produced by this parse rule.
	 */
	public Collection<Class<? extends T>> getBottomMostClasses()
	{
		return this.bottomMostClasses;
	}
	
	@Override
	public String toString()
	{
		return this.name + " rule";
	}
    public static final ParseRule<AnnotationMethodModifiersNode> ABSTRACT_METHOD_MODIFIERS = 
        new ParseRule<AnnotationMethodModifiersNode>("AbstractMethodModifiers",
            Collections.<Class<? extends AnnotationMethodModifiersNode>>singleton(AnnotationMethodModifiersNode.class));
    
    public static final ParseRule<AnnotationNode> ANNOTATION;
    static
    {
        List<Class<? extends AnnotationNode>> list = new ArrayList<Class<? extends AnnotationNode>>(2);
        list.add(NormalAnnotationNode.class);
        list.add(SingleElementAnnotationNode.class);
        ANNOTATION = new ParseRule<AnnotationNode>("Annotation", list);
    }
    
    public static final ParseRule<AnnotationListNode> ANNOTATIONS = 
        new ParseRule<AnnotationListNode>("Annotations",
            Collections.<Class<? extends AnnotationListNode>>singleton(AnnotationListNode.class));
    
    public static final ParseRule<AnnotationMethodDeclarationNode> ANNOTATION_METHOD = 
        new ParseRule<AnnotationMethodDeclarationNode>("AnnotationMethod",
            Collections.<Class<? extends AnnotationMethodDeclarationNode>>singleton(AnnotationMethodDeclarationNode.class));
    
    public static final ParseRule<AnnotationModifiersNode> ANNOTATION_MODIFIERS = 
        new ParseRule<AnnotationModifiersNode>("AnnotationModifiers",
            Collections.<Class<? extends AnnotationModifiersNode>>singleton(AnnotationModifiersNode.class));
    
    public static final ParseRule<AnnotationBodyNode> ANNOTATION_TYPE_BODY = 
        new ParseRule<AnnotationBodyNode>("AnnotationTypeBody",
            Collections.<Class<? extends AnnotationBodyNode>>singleton(AnnotationBodyNode.class));
    
    public static final ParseRule<AnnotationMemberListNode> ANNOTATION_TYPE_ELEMENT_DECLARATIONS = 
        new ParseRule<AnnotationMemberListNode>("AnnotationTypeElementDeclarations",
            Collections.<Class<? extends AnnotationMemberListNode>>singleton(AnnotationMemberListNode.class));
    
    public static final ParseRule<AnonymousClassBodyNode> ANONYMOUS_CLASS_BODY = 
        new ParseRule<AnonymousClassBodyNode>("AnonymousClassBody",
            Collections.<Class<? extends AnonymousClassBodyNode>>singleton(AnonymousClassBodyNode.class));
    
    public static final ParseRule<AnonymousClassMemberListNode> ANONYMOUS_CLASS_BODY_DECLARATIONS = 
        new ParseRule<AnonymousClassMemberListNode>("AnonymousClassBodyDeclarations",
            Collections.<Class<? extends AnonymousClassMemberListNode>>singleton(AnonymousClassMemberListNode.class));
    
    public static final ParseRule<ExpressionListNode> ARGUMENT_LIST = 
        new ParseRule<ExpressionListNode>("ArgumentList",
            Collections.<Class<? extends ExpressionListNode>>singleton(ExpressionListNode.class));
    
    public static final ParseRule<BlockStatementNode> BLOCK_STATEMENT;
    static
    {
        List<Class<? extends BlockStatementNode>> list = new ArrayList<Class<? extends BlockStatementNode>>(20);
        list.add(AssertStatementNode.class);
        list.add(BlockNode.class);
        list.add(BreakNode.class);
        list.add(ContinueNode.class);
        list.add(DoWhileLoopNode.class);
        list.add(EnhancedForLoopNode.class);
        list.add(ExpressionStatementNode.class);
        list.add(ForLoopNode.class);
        list.add(IfNode.class);
        list.add(LabeledStatementNode.class);
        list.add(LocalClassDeclarationNode.class);
        list.add(LocalVariableDeclarationNode.class);
        list.add(NoOperationNode.class);
        list.add(ReturnNode.class);
        list.add(StatementNode.class);
        list.add(SwitchNode.class);
        list.add(SynchronizedNode.class);
        list.add(ThrowNode.class);
        list.add(TryNode.class);
        list.add(WhileLoopNode.class);
        BLOCK_STATEMENT = new ParseRule<BlockStatementNode>("BlockStatement", list);
    }
    
    public static final ParseRule<BlockStatementListNode> BLOCK_STATEMENTS = 
        new ParseRule<BlockStatementListNode>("BlockStatements",
            Collections.<Class<? extends BlockStatementListNode>>singleton(BlockStatementListNode.class));
    
    public static final ParseRule<CatchNode> CATCH_CLAUSE = 
        new ParseRule<CatchNode>("CatchClause",
            Collections.<Class<? extends CatchNode>>singleton(CatchNode.class));
    
    public static final ParseRule<CatchListNode> CATCHES = 
        new ParseRule<CatchListNode>("Catches",
            Collections.<Class<? extends CatchListNode>>singleton(CatchListNode.class));
    
    public static final ParseRule<ClassBodyNode> CLASS_BODY = 
        new ParseRule<ClassBodyNode>("ClassBody",
            Collections.<Class<? extends ClassBodyNode>>singleton(ClassBodyNode.class));
    
    public static final ParseRule<ClassMemberListNode> CLASS_BODY_DECLARATIONS = 
        new ParseRule<ClassMemberListNode>("ClassBodyDeclarations",
            Collections.<Class<? extends ClassMemberListNode>>singleton(ClassMemberListNode.class));
    
    public static final ParseRule<ClassModifiersNode> CLASS_MODIFIERS = 
        new ParseRule<ClassModifiersNode>("ClassModifiers",
            Collections.<Class<? extends ClassModifiersNode>>singleton(ClassModifiersNode.class));
    
    public static final ParseRule<DeclaredTypeListNode> CLASS_OR_INTERFACE_TYPE_LIST = 
        new ParseRule<DeclaredTypeListNode>("ClassOrInterfaceTypeList",
            Collections.<Class<? extends DeclaredTypeListNode>>singleton(DeclaredTypeListNode.class));
    
    public static final ParseRule<CompilationUnitNode> COMPILATION_UNIT = 
        new ParseRule<CompilationUnitNode>("CompilationUnit",
            Collections.<Class<? extends CompilationUnitNode>>singleton(CompilationUnitNode.class));
    
    public static final ParseRule<ConstantDeclarationNode> CONSTANT_DECLARATION = 
        new ParseRule<ConstantDeclarationNode>("ConstantDeclaration",
            Collections.<Class<? extends ConstantDeclarationNode>>singleton(ConstantDeclarationNode.class));
    
    public static final ParseRule<ConstantModifiersNode> CONSTANT_MODIFIERS = 
        new ParseRule<ConstantModifiersNode>("ConstantModifiers",
            Collections.<Class<? extends ConstantModifiersNode>>singleton(ConstantModifiersNode.class));
    
    public static final ParseRule<ConstructorBodyNode> CONSTRUCTOR_BODY = 
        new ParseRule<ConstructorBodyNode>("ConstructorBody",
            Collections.<Class<? extends ConstructorBodyNode>>singleton(ConstructorBodyNode.class));
    
    public static final ParseRule<ConstructorDeclarationNode> CONSTRUCTOR_DECLARATION = 
        new ParseRule<ConstructorDeclarationNode>("ConstructorDeclaration",
            Collections.<Class<? extends ConstructorDeclarationNode>>singleton(ConstructorDeclarationNode.class));
    
    public static final ParseRule<ConstructorModifiersNode> CONSTRUCTOR_MODIFIERS = 
        new ParseRule<ConstructorModifiersNode>("ConstructorModifiers",
            Collections.<Class<? extends ConstructorModifiersNode>>singleton(ConstructorModifiersNode.class));
    
    public static final ParseRule<AnnotationValueNode> ELEMENT_VALUE;
    static
    {
        List<Class<? extends AnnotationValueNode>> list = new ArrayList<Class<? extends AnnotationValueNode>>(3);
        list.add(AnnotationAnnotationValueNode.class);
        list.add(AnnotationArrayValueNode.class);
        list.add(AnnotationExpressionValueNode.class);
        ELEMENT_VALUE = new ParseRule<AnnotationValueNode>("ElementValue", list);
    }
    
    public static final ParseRule<AnnotationValueListNode> ELEMENT_VALUES = 
        new ParseRule<AnnotationValueListNode>("ElementValues",
            Collections.<Class<? extends AnnotationValueListNode>>singleton(AnnotationValueListNode.class));
    
    public static final ParseRule<AnnotationElementNode> ELEMENT_VALUE_PAIR = 
        new ParseRule<AnnotationElementNode>("ElementValuePair",
            Collections.<Class<? extends AnnotationElementNode>>singleton(AnnotationElementNode.class));
    
    public static final ParseRule<AnnotationElementListNode> ELEMENT_VALUE_PAIRS = 
        new ParseRule<AnnotationElementListNode>("ElementValuePairs",
            Collections.<Class<? extends AnnotationElementListNode>>singleton(AnnotationElementListNode.class));
    
    public static final ParseRule<EnumBodyNode> ENUM_BODY = 
        new ParseRule<EnumBodyNode>("EnumBody",
            Collections.<Class<? extends EnumBodyNode>>singleton(EnumBodyNode.class));
    
    public static final ParseRule<EnumConstantDeclarationNode> ENUM_CONSTANT = 
        new ParseRule<EnumConstantDeclarationNode>("EnumConstant",
            Collections.<Class<? extends EnumConstantDeclarationNode>>singleton(EnumConstantDeclarationNode.class));
    
    public static final ParseRule<EnumConstantDeclarationListNode> ENUM_CONSTANTS = 
        new ParseRule<EnumConstantDeclarationListNode>("EnumConstants",
            Collections.<Class<? extends EnumConstantDeclarationListNode>>singleton(EnumConstantDeclarationListNode.class));
    
    public static final ParseRule<EnumModifiersNode> ENUM_MODIFIERS = 
        new ParseRule<EnumModifiersNode>("EnumModifiers",
            Collections.<Class<? extends EnumModifiersNode>>singleton(EnumModifiersNode.class));
    
    public static final ParseRule<UnparameterizedTypeListNode> EXCEPTION_TYPE_LIST = 
        new ParseRule<UnparameterizedTypeListNode>("ExceptionTypeList",
            Collections.<Class<? extends UnparameterizedTypeListNode>>singleton(UnparameterizedTypeListNode.class));
    
    public static final ParseRule<ConstructorInvocationNode> EXPLICIT_CONSTRUCTOR_INVOCATION;
    static
    {
        List<Class<? extends ConstructorInvocationNode>> list = new ArrayList<Class<? extends ConstructorInvocationNode>>(2);
        list.add(AlternateConstructorInvocationNode.class);
        list.add(SuperclassConstructorInvocationNode.class);
        EXPLICIT_CONSTRUCTOR_INVOCATION = new ParseRule<ConstructorInvocationNode>("ExplicitConstructorInvocation", list);
    }
    
    public static final ParseRule<FieldDeclarationNode> FIELD_DECLARATION = 
        new ParseRule<FieldDeclarationNode>("FieldDeclaration",
            Collections.<Class<? extends FieldDeclarationNode>>singleton(FieldDeclarationNode.class));
    
    public static final ParseRule<FieldModifiersNode> FIELD_MODIFIERS = 
        new ParseRule<FieldModifiersNode>("FieldModifiers",
            Collections.<Class<? extends FieldModifiersNode>>singleton(FieldModifiersNode.class));
    
    public static final ParseRule<ForInitializerNode> FOR_INIT;
    static
    {
        List<Class<? extends ForInitializerNode>> list = new ArrayList<Class<? extends ForInitializerNode>>(2);
        list.add(ForInitializerDeclarationNode.class);
        list.add(ForInitializerExpressionNode.class);
        FOR_INIT = new ParseRule<ForInitializerNode>("ForInit", list);
    }
    
    public static final ParseRule<VariableNode> FORMAL_PARAMETER = 
        new ParseRule<VariableNode>("FormalParameter",
            Collections.<Class<? extends VariableNode>>singleton(VariableNode.class));
    
    public static final ParseRule<IdentifierNode> IDENTIFIER = 
        new ParseRule<IdentifierNode>("Identifier",
            Collections.<Class<? extends IdentifierNode>>singleton(IdentifierNode.class));
    
    public static final ParseRule<IdentifierListNode> IDENTIFIER_LIST = 
        new ParseRule<IdentifierListNode>("IdentifierList",
            Collections.<Class<? extends IdentifierListNode>>singleton(IdentifierListNode.class));
    
    public static final ParseRule<ImportNode> IMPORT_DECLARATION;
    static
    {
        List<Class<? extends ImportNode>> list = new ArrayList<Class<? extends ImportNode>>(4);
        list.add(ImportOnDemandNode.class);
        list.add(ImportSingleTypeNode.class);
        list.add(SingleStaticImportNode.class);
        list.add(StaticImportOnDemandNode.class);
        IMPORT_DECLARATION = new ParseRule<ImportNode>("ImportDeclaration", list);
    }
    
    public static final ParseRule<ImportListNode> IMPORT_DECLARATIONS = 
        new ParseRule<ImportListNode>("ImportDeclarations",
            Collections.<Class<? extends ImportListNode>>singleton(ImportListNode.class));
    
    public static final ParseRule<InitializerDeclarationNode> INITIALIZER = 
        new ParseRule<InitializerDeclarationNode>("Initializer",
            Collections.<Class<? extends InitializerDeclarationNode>>singleton(InitializerDeclarationNode.class));
    
    public static final ParseRule<InterfaceBodyNode> INTERFACE_BODY = 
        new ParseRule<InterfaceBodyNode>("InterfaceBody",
            Collections.<Class<? extends InterfaceBodyNode>>singleton(InterfaceBodyNode.class));
    
    public static final ParseRule<InterfaceMemberListNode> INTERFACE_MEMBER_DECLARATIONS = 
        new ParseRule<InterfaceMemberListNode>("InterfaceMemberDeclarations",
            Collections.<Class<? extends InterfaceMemberListNode>>singleton(InterfaceMemberListNode.class));
    
    public static final ParseRule<InterfaceModifiersNode> INTERFACE_MODIFIERS = 
        new ParseRule<InterfaceModifiersNode>("InterfaceModifiers",
            Collections.<Class<? extends InterfaceModifiersNode>>singleton(InterfaceModifiersNode.class));
    
    public static final ParseRule<JavadocNode> JAVADOC_COMMENT = 
        new ParseRule<JavadocNode>("JavadocComment",
            Collections.<Class<? extends JavadocNode>>singleton(JavadocNode.class));
    
    public static final ParseRule<LocalClassModifiersNode> LOCAL_CLASS_MODIFIERS = 
        new ParseRule<LocalClassModifiersNode>("LocalClassModifiers",
            Collections.<Class<? extends LocalClassModifiersNode>>singleton(LocalClassModifiersNode.class));
    
    public static final ParseRule<MetaAnnotationNode> META_ANNOTATION;
    static
    {
        List<Class<? extends MetaAnnotationNode>> list = new ArrayList<Class<? extends MetaAnnotationNode>>(2);
        list.add(NormalMetaAnnotationNode.class);
        list.add(SingleElementMetaAnnotationNode.class);
        META_ANNOTATION = new ParseRule<MetaAnnotationNode>("MetaAnnotation", list);
    }
    
    public static final ParseRule<MetaAnnotationListNode> META_ANNOTATION_LIST = 
        new ParseRule<MetaAnnotationListNode>("MetaAnnotationList",
            Collections.<Class<? extends MetaAnnotationListNode>>singleton(MetaAnnotationListNode.class));
    
    public static final ParseRule<MetaAnnotationElementNode> META_ANNOTATION_ELEMENT = 
        new ParseRule<MetaAnnotationElementNode>("MetaAnnotationElement",
            Collections.<Class<? extends MetaAnnotationElementNode>>singleton(MetaAnnotationElementNode.class));
    
    public static final ParseRule<MetaAnnotationElementListNode> META_ANNOTATION_ELEMENTS = 
        new ParseRule<MetaAnnotationElementListNode>("MetaAnnotationElements",
            Collections.<Class<? extends MetaAnnotationElementListNode>>singleton(MetaAnnotationElementListNode.class));
    
    public static final ParseRule<MetaAnnotationValueNode> META_ANNOTATION_ELEMENT_VALUE;
    static
    {
        List<Class<? extends MetaAnnotationValueNode>> list = new ArrayList<Class<? extends MetaAnnotationValueNode>>(3);
        list.add(MetaAnnotationArrayValueNode.class);
        list.add(MetaAnnotationExpressionValueNode.class);
        list.add(MetaAnnotationMetaAnnotationValueNode.class);
        META_ANNOTATION_ELEMENT_VALUE = new ParseRule<MetaAnnotationValueNode>("MetaAnnotationElementValue", list);
    }
    
    public static final ParseRule<MetaAnnotationValueListNode> META_ANNOTATION_ELEMENT_VALUES = 
        new ParseRule<MetaAnnotationValueListNode>("MetaAnnotationElementValues",
            Collections.<Class<? extends MetaAnnotationValueListNode>>singleton(MetaAnnotationValueListNode.class));
    
    public static final ParseRule<MethodDeclarationNode> METHOD_DECLARATION = 
        new ParseRule<MethodDeclarationNode>("MethodDeclaration",
            Collections.<Class<? extends MethodDeclarationNode>>singleton(MethodDeclarationNode.class));
    
    public static final ParseRule<MetaprogramNode> METAPROGRAM = 
        new ParseRule<MetaprogramNode>("Metaprogram",
            Collections.<Class<? extends MetaprogramNode>>singleton(MetaprogramNode.class));
    
    public static final ParseRule<MetaprogramDependencyNode> METAPROGRAM_DEPENDENCY = 
        new ParseRule<MetaprogramDependencyNode>("MetaprogramDependency",
            Collections.<Class<? extends MetaprogramDependencyNode>>singleton(MetaprogramDependencyNode.class));
    
    public static final ParseRule<MetaprogramDependencyDeclarationNode> METAPROGRAM_DEPENDENCY_DECLARATION = 
        new ParseRule<MetaprogramDependencyDeclarationNode>("MetaprogramDependencyDeclaration",
            Collections.<Class<? extends MetaprogramDependencyDeclarationNode>>singleton(MetaprogramDependencyDeclarationNode.class));
    
    public static final ParseRule<MetaprogramDependencyDeclarationListNode> METAPROGRAM_DEPENDENCY_DECLARATION_LIST = 
        new ParseRule<MetaprogramDependencyDeclarationListNode>("MetaprogramDependencyDeclarationList",
            Collections.<Class<? extends MetaprogramDependencyDeclarationListNode>>singleton(MetaprogramDependencyDeclarationListNode.class));
    
    public static final ParseRule<MetaprogramDependencyListNode> METAPROGRAM_DEPENDENCY_LIST = 
        new ParseRule<MetaprogramDependencyListNode>("MetaprogramDependencyList",
            Collections.<Class<? extends MetaprogramDependencyListNode>>singleton(MetaprogramDependencyListNode.class));
    
    public static final ParseRule<MetaprogramImportNode> METAPROGRAM_IMPORT_DECLARATION = 
        new ParseRule<MetaprogramImportNode>("MetaprogramImportDeclaration",
            Collections.<Class<? extends MetaprogramImportNode>>singleton(MetaprogramImportNode.class));
    
    public static final ParseRule<MetaprogramImportListNode> METAPROGRAM_IMPORT_DECLARATION_LIST = 
        new ParseRule<MetaprogramImportListNode>("MetaprogramImportDeclarationList",
            Collections.<Class<? extends MetaprogramImportListNode>>singleton(MetaprogramImportListNode.class));
    
    public static final ParseRule<MetaprogramTargetNode> METAPROGRAM_TARGET_DECLARATION = 
        new ParseRule<MetaprogramTargetNode>("MetaprogramTargetDeclaration",
            Collections.<Class<? extends MetaprogramTargetNode>>singleton(MetaprogramTargetNode.class));
    
    public static final ParseRule<MetaprogramTargetListNode> METAPROGRAM_TARGET_DECLARATION_LIST = 
        new ParseRule<MetaprogramTargetListNode>("MetaprogramTargetDeclarationList",
            Collections.<Class<? extends MetaprogramTargetListNode>>singleton(MetaprogramTargetListNode.class));
    
    public static final ParseRule<MethodModifiersNode> METHOD_MODIFIERS = 
        new ParseRule<MethodModifiersNode>("MethodModifiers",
            Collections.<Class<? extends MethodModifiersNode>>singleton(MethodModifiersNode.class));
    
    public static final ParseRule<NameNode> NAME;
    static
    {
        List<Class<? extends NameNode>> list = new ArrayList<Class<? extends NameNode>>(2);
        list.add(QualifiedNameNode.class);
        list.add(SimpleNameNode.class);
        NAME = new ParseRule<NameNode>("Name", list);
    }
    
    public static final ParseRule<PackageDeclarationNode> PACKAGE_DECLARATION = 
        new ParseRule<PackageDeclarationNode>("PackageDeclaration",
            Collections.<Class<? extends PackageDeclarationNode>>singleton(PackageDeclarationNode.class));
    
    public static final ParseRule<MetaprogramPreambleNode> PREAMBLE = 
        new ParseRule<MetaprogramPreambleNode>("Preamble",
            Collections.<Class<? extends MetaprogramPreambleNode>>singleton(MetaprogramPreambleNode.class));
    
    public static final ParseRule<ReferenceTypeListNode> REFERENCE_TYPE_LIST = 
        new ParseRule<ReferenceTypeListNode>("ReferenceTypeList",
            Collections.<Class<? extends ReferenceTypeListNode>>singleton(ReferenceTypeListNode.class));
    
    public static final ParseRule<StatementExpressionListNode> STATEMENT_EXPRESSION_LIST = 
        new ParseRule<StatementExpressionListNode>("StatementExpressionList",
            Collections.<Class<? extends StatementExpressionListNode>>singleton(StatementExpressionListNode.class));
    
    public static final ParseRule<CaseNode> SWITCH_BLOCK_STATEMENT_GROUP = 
        new ParseRule<CaseNode>("SwitchBlockStatementGroup",
            Collections.<Class<? extends CaseNode>>singleton(CaseNode.class));
    
    public static final ParseRule<CaseListNode> SWITCH_BLOCK_STATEMENT_GROUPS = 
        new ParseRule<CaseListNode>("SwitchBlockStatementGroups",
            Collections.<Class<? extends CaseListNode>>singleton(CaseListNode.class));
    
    public static final ParseRule<TypeNode> TYPE;
    static
    {
        List<Class<? extends TypeNode>> list = new ArrayList<Class<? extends TypeNode>>(6);
        list.add(ArrayTypeNode.class);
        list.add(ParameterizedTypeNode.class);
        list.add(ParameterizedTypeSelectNode.class);
        list.add(PrimitiveTypeNode.class);
        list.add(UnparameterizedTypeNode.class);
        list.add(VoidTypeNode.class);
        TYPE = new ParseRule<TypeNode>("Type", list);
    }
    
    public static final ParseRule<TypeArgumentListNode> TYPE_ARGUMENTS = 
        new ParseRule<TypeArgumentListNode>("TypeArguments",
            Collections.<Class<? extends TypeArgumentListNode>>singleton(TypeArgumentListNode.class));
    
    public static final ParseRule<TypeDeclarationNode> TYPE_DECLARATION;
    static
    {
        List<Class<? extends TypeDeclarationNode>> list = new ArrayList<Class<? extends TypeDeclarationNode>>(5);
        list.add(AnnotationDeclarationNode.class);
        list.add(ClassDeclarationNode.class);
        list.add(EnumDeclarationNode.class);
        list.add(InterfaceDeclarationNode.class);
        list.add(NoOperationNode.class);
        TYPE_DECLARATION = new ParseRule<TypeDeclarationNode>("TypeDeclaration", list);
    }
    
    public static final ParseRule<TypeDeclarationListNode> TYPE_DECLARATIONS = 
        new ParseRule<TypeDeclarationListNode>("TypeDeclarations",
            Collections.<Class<? extends TypeDeclarationListNode>>singleton(TypeDeclarationListNode.class));
    
    public static final ParseRule<TypeParameterNode> TYPE_PARAMETER = 
        new ParseRule<TypeParameterNode>("TypeParameter",
            Collections.<Class<? extends TypeParameterNode>>singleton(TypeParameterNode.class));
    
    public static final ParseRule<TypeParameterListNode> TYPE_PARAMETERS = 
        new ParseRule<TypeParameterListNode>("TypeParameters",
            Collections.<Class<? extends TypeParameterListNode>>singleton(TypeParameterListNode.class));
    
    public static final ParseRule<VariableDeclaratorNode> VARIABLE_DECLARATOR = 
        new ParseRule<VariableDeclaratorNode>("VariableDeclarator",
            Collections.<Class<? extends VariableDeclaratorNode>>singleton(VariableDeclaratorNode.class));
    
    public static final ParseRule<VariableDeclaratorListNode> VARIABLE_DECLARATORS = 
        new ParseRule<VariableDeclaratorListNode>("VariableDeclarators",
            Collections.<Class<? extends VariableDeclaratorListNode>>singleton(VariableDeclaratorListNode.class));
    
    public static final ParseRule<VariableInitializerNode> VARIABLE_INITIALIZER;
    static
    {
        List<Class<? extends VariableInitializerNode>> list = new ArrayList<Class<? extends VariableInitializerNode>>(30);
        list.add(ArrayAccessNode.class);
        list.add(ArrayInitializerCreationNode.class);
        list.add(ArrayInitializerNode.class);
        list.add(ArrayInstantiatorCreationNode.class);
        list.add(AssignmentNode.class);
        list.add(BinaryExpressionNode.class);
        list.add(BooleanLiteralNode.class);
        list.add(CharLiteralNode.class);
        list.add(ClassLiteralNode.class);
        list.add(CodeLiteralNode.class);
        list.add(ConditionalExpressionNode.class);
        list.add(DoubleLiteralNode.class);
        list.add(FloatLiteralNode.class);
        list.add(InstanceOfNode.class);
        list.add(IntLiteralNode.class);
        list.add(LongLiteralNode.class);
        list.add(MethodInvocationNode.class);
        list.add(NullLiteralNode.class);
        list.add(ParenthesizedExpressionNode.class);
        list.add(QualifiedClassInstantiationNode.class);
        list.add(RawCodeLiteralNode.class);
        list.add(StringLiteralNode.class);
        list.add(SuperFieldAccessNode.class);
        list.add(SuperMethodInvocationNode.class);
        list.add(ThisNode.class);
        list.add(TypeCastNode.class);
        list.add(UnaryExpressionNode.class);
        list.add(UnaryStatementExpressionNode.class);
        list.add(UnqualifiedClassInstantiationNode.class);
        list.add(VariableAccessNode.class);
        VARIABLE_INITIALIZER = new ParseRule<VariableInitializerNode>("VariableInitializer", list);
    }
    
    public static final ParseRule<VariableInitializerListNode> VARIABLE_INITIALIZERS = 
        new ParseRule<VariableInitializerListNode>("VariableInitializers",
            Collections.<Class<? extends VariableInitializerListNode>>singleton(VariableInitializerListNode.class));
    
    public static final ParseRule<VariableModifiersNode> VARIABLE_MODIFIERS = 
        new ParseRule<VariableModifiersNode>("VariableModifiers",
            Collections.<Class<? extends VariableModifiersNode>>singleton(VariableModifiersNode.class));
    
    public static final ParseRule<WildcardTypeNode> WILDCARD = 
        new ParseRule<WildcardTypeNode>("Wildcard",
            Collections.<Class<? extends WildcardTypeNode>>singleton(WildcardTypeNode.class));
    
    private static Iterable<? extends ParseRule<?>> valuesIterable = null;
    public static Iterable<? extends ParseRule<?>> values()
    {
        if (valuesIterable == null)
        {
            List<ParseRule<?>> list = new ArrayList<ParseRule<?>>(84);
            list.add(ABSTRACT_METHOD_MODIFIERS);
            list.add(ANNOTATION);
            list.add(ANNOTATIONS);
            list.add(ANNOTATION_METHOD);
            list.add(ANNOTATION_MODIFIERS);
            list.add(ANNOTATION_TYPE_BODY);
            list.add(ANNOTATION_TYPE_ELEMENT_DECLARATIONS);
            list.add(ANONYMOUS_CLASS_BODY);
            list.add(ANONYMOUS_CLASS_BODY_DECLARATIONS);
            list.add(ARGUMENT_LIST);
            list.add(BLOCK_STATEMENT);
            list.add(BLOCK_STATEMENTS);
            list.add(CATCH_CLAUSE);
            list.add(CATCHES);
            list.add(CLASS_BODY);
            list.add(CLASS_BODY_DECLARATIONS);
            list.add(CLASS_MODIFIERS);
            list.add(CLASS_OR_INTERFACE_TYPE_LIST);
            list.add(COMPILATION_UNIT);
            list.add(CONSTANT_DECLARATION);
            list.add(CONSTANT_MODIFIERS);
            list.add(CONSTRUCTOR_BODY);
            list.add(CONSTRUCTOR_DECLARATION);
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
            list.add(FIELD_DECLARATION);
            list.add(FIELD_MODIFIERS);
            list.add(FOR_INIT);
            list.add(FORMAL_PARAMETER);
            list.add(IDENTIFIER);
            list.add(IDENTIFIER_LIST);
            list.add(IMPORT_DECLARATION);
            list.add(IMPORT_DECLARATIONS);
            list.add(INITIALIZER);
            list.add(INTERFACE_BODY);
            list.add(INTERFACE_MEMBER_DECLARATIONS);
            list.add(INTERFACE_MODIFIERS);
            list.add(JAVADOC_COMMENT);
            list.add(LOCAL_CLASS_MODIFIERS);
            list.add(META_ANNOTATION);
            list.add(META_ANNOTATION_LIST);
            list.add(META_ANNOTATION_ELEMENT);
            list.add(META_ANNOTATION_ELEMENTS);
            list.add(META_ANNOTATION_ELEMENT_VALUE);
            list.add(META_ANNOTATION_ELEMENT_VALUES);
            list.add(METHOD_DECLARATION);
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
