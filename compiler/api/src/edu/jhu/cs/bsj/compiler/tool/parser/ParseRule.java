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
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
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
	private Class<T> nodeClass;
	private Collection<Class<? extends T>> bottomMostClasses;

	private ParseRule(Class<T> nodeClass, Collection<Class<? extends T>> bottomMostClasses)
	{
		this.nodeClass = nodeClass;
		this.bottomMostClasses = Collections.unmodifiableCollection(bottomMostClasses);
	}

	/**
	 * Retrieves the type of node which is produced by this parse rule.
	 * 
	 * @return The type of node produced by this parse rule.
	 */
	public Class<T> getNodeClass()
	{
		return this.nodeClass;
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
    public static final ParseRule<AnnotationMethodModifiersNode> ABSTRACT_METHOD_MODIFIERS = 
        new ParseRule<AnnotationMethodModifiersNode>(AnnotationMethodModifiersNode.class,
            Collections.<Class<? extends AnnotationMethodModifiersNode>>singleton(AnnotationMethodModifiersNode.class));
    
    public static final ParseRule<AnnotationNode> ANNOTATION;
    static
    {
        List<Class<? extends AnnotationNode>> list = new ArrayList<Class<? extends AnnotationNode>>(2);
        list.add(NormalAnnotationNode.class);
        list.add(SingleElementAnnotationNode.class);
        ANNOTATION = new ParseRule<AnnotationNode>(AnnotationNode.class, list);
    }
    
    public static final ParseRule<AnnotationListNode> ANNOTATIONS = 
        new ParseRule<AnnotationListNode>(AnnotationListNode.class,
            Collections.<Class<? extends AnnotationListNode>>singleton(AnnotationListNode.class));
    
    public static final ParseRule<AnnotationModifiersNode> ANNOTATION_MODIFIERS = 
        new ParseRule<AnnotationModifiersNode>(AnnotationModifiersNode.class,
            Collections.<Class<? extends AnnotationModifiersNode>>singleton(AnnotationModifiersNode.class));
    
    public static final ParseRule<AnnotationBodyNode> ANNOTATION_TYPE_BODY = 
        new ParseRule<AnnotationBodyNode>(AnnotationBodyNode.class,
            Collections.<Class<? extends AnnotationBodyNode>>singleton(AnnotationBodyNode.class));
    
    public static final ParseRule<AnnotationMemberListNode> ANNOTATION_TYPE_ELEMENT_DECLARATIONS = 
        new ParseRule<AnnotationMemberListNode>(AnnotationMemberListNode.class,
            Collections.<Class<? extends AnnotationMemberListNode>>singleton(AnnotationMemberListNode.class));
    
    public static final ParseRule<AnnotationMemberNode> ANNOTATION_TYPE_ELEMENT_DECLARATION;
    static
    {
        List<Class<? extends AnnotationMemberNode>> list = new ArrayList<Class<? extends AnnotationMemberNode>>(8);
        list.add(AnnotationDeclarationNode.class);
        list.add(AnnotationMemberMetaprogramAnchorNode.class);
        list.add(AnnotationMethodDeclarationNode.class);
        list.add(ClassDeclarationNode.class);
        list.add(ConstantDeclarationNode.class);
        list.add(EnumDeclarationNode.class);
        list.add(InterfaceDeclarationNode.class);
        list.add(NoOperationNode.class);
        ANNOTATION_TYPE_ELEMENT_DECLARATION = new ParseRule<AnnotationMemberNode>(AnnotationMemberNode.class, list);
    }
    
    public static final ParseRule<AnonymousClassBodyNode> ANONYMOUS_CLASS_BODY = 
        new ParseRule<AnonymousClassBodyNode>(AnonymousClassBodyNode.class,
            Collections.<Class<? extends AnonymousClassBodyNode>>singleton(AnonymousClassBodyNode.class));
    
    public static final ParseRule<AnonymousClassMemberListNode> ANONYMOUS_CLASS_BODY_DECLARATIONS = 
        new ParseRule<AnonymousClassMemberListNode>(AnonymousClassMemberListNode.class,
            Collections.<Class<? extends AnonymousClassMemberListNode>>singleton(AnonymousClassMemberListNode.class));
    
    public static final ParseRule<ClassMemberNode> ANONYMOUS_CLASS_BODY_DECLARATION;
    static
    {
        List<Class<? extends ClassMemberNode>> list = new ArrayList<Class<? extends ClassMemberNode>>(9);
        list.add(AnnotationDeclarationNode.class);
        list.add(ClassDeclarationNode.class);
        list.add(ClassMemberMetaprogramAnchorNode.class);
        list.add(EnumDeclarationNode.class);
        list.add(FieldDeclarationNode.class);
        list.add(InitializerDeclarationNode.class);
        list.add(InterfaceDeclarationNode.class);
        list.add(MethodDeclarationNode.class);
        list.add(NoOperationNode.class);
        ANONYMOUS_CLASS_BODY_DECLARATION = new ParseRule<ClassMemberNode>(ClassMemberNode.class, list);
    }
    
    public static final ParseRule<ExpressionListNode> ARGUMENT_LIST = 
        new ParseRule<ExpressionListNode>(ExpressionListNode.class,
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
        BLOCK_STATEMENT = new ParseRule<BlockStatementNode>(BlockStatementNode.class, list);
    }
    
    public static final ParseRule<BlockStatementListNode> BLOCK_STATEMENTS = 
        new ParseRule<BlockStatementListNode>(BlockStatementListNode.class,
            Collections.<Class<? extends BlockStatementListNode>>singleton(BlockStatementListNode.class));
    
    public static final ParseRule<CatchNode> CATCH_CLAUSE = 
        new ParseRule<CatchNode>(CatchNode.class,
            Collections.<Class<? extends CatchNode>>singleton(CatchNode.class));
    
    public static final ParseRule<CatchListNode> CATCHES = 
        new ParseRule<CatchListNode>(CatchListNode.class,
            Collections.<Class<? extends CatchListNode>>singleton(CatchListNode.class));
    
    public static final ParseRule<ClassBodyNode> CLASS_BODY = 
        new ParseRule<ClassBodyNode>(ClassBodyNode.class,
            Collections.<Class<? extends ClassBodyNode>>singleton(ClassBodyNode.class));
    
    public static final ParseRule<ClassMemberNode> CLASS_BODY_DECLARATION;
    static
    {
        List<Class<? extends ClassMemberNode>> list = new ArrayList<Class<? extends ClassMemberNode>>(10);
        list.add(AnnotationDeclarationNode.class);
        list.add(ClassDeclarationNode.class);
        list.add(ClassMemberMetaprogramAnchorNode.class);
        list.add(ConstructorDeclarationNode.class);
        list.add(EnumDeclarationNode.class);
        list.add(FieldDeclarationNode.class);
        list.add(InitializerDeclarationNode.class);
        list.add(InterfaceDeclarationNode.class);
        list.add(MethodDeclarationNode.class);
        list.add(NoOperationNode.class);
        CLASS_BODY_DECLARATION = new ParseRule<ClassMemberNode>(ClassMemberNode.class, list);
    }
    
    public static final ParseRule<ClassMemberListNode> CLASS_BODY_DECLARATIONS = 
        new ParseRule<ClassMemberListNode>(ClassMemberListNode.class,
            Collections.<Class<? extends ClassMemberListNode>>singleton(ClassMemberListNode.class));
    
    public static final ParseRule<ClassModifiersNode> CLASS_MODIFIERS = 
        new ParseRule<ClassModifiersNode>(ClassModifiersNode.class,
            Collections.<Class<? extends ClassModifiersNode>>singleton(ClassModifiersNode.class));
    
    public static final ParseRule<DeclaredTypeListNode> CLASS_OR_INTERFACE_TYPE_LIST = 
        new ParseRule<DeclaredTypeListNode>(DeclaredTypeListNode.class,
            Collections.<Class<? extends DeclaredTypeListNode>>singleton(DeclaredTypeListNode.class));
    
    public static final ParseRule<CompilationUnitNode> COMPILATION_UNIT = 
        new ParseRule<CompilationUnitNode>(CompilationUnitNode.class,
            Collections.<Class<? extends CompilationUnitNode>>singleton(CompilationUnitNode.class));
    
    public static final ParseRule<ConstantDeclarationNode> CONSTANT_DECLARATION = 
        new ParseRule<ConstantDeclarationNode>(ConstantDeclarationNode.class,
            Collections.<Class<? extends ConstantDeclarationNode>>singleton(ConstantDeclarationNode.class));
    
    public static final ParseRule<ConstantModifiersNode> CONSTANT_MODIFIERS = 
        new ParseRule<ConstantModifiersNode>(ConstantModifiersNode.class,
            Collections.<Class<? extends ConstantModifiersNode>>singleton(ConstantModifiersNode.class));
    
    public static final ParseRule<ConstructorBodyNode> CONSTRUCTOR_BODY = 
        new ParseRule<ConstructorBodyNode>(ConstructorBodyNode.class,
            Collections.<Class<? extends ConstructorBodyNode>>singleton(ConstructorBodyNode.class));
    
    public static final ParseRule<ConstructorModifiersNode> CONSTRUCTOR_MODIFIERS = 
        new ParseRule<ConstructorModifiersNode>(ConstructorModifiersNode.class,
            Collections.<Class<? extends ConstructorModifiersNode>>singleton(ConstructorModifiersNode.class));
    
    public static final ParseRule<AnnotationValueNode> ELEMENT_VALUE;
    static
    {
        List<Class<? extends AnnotationValueNode>> list = new ArrayList<Class<? extends AnnotationValueNode>>(3);
        list.add(AnnotationAnnotationValueNode.class);
        list.add(AnnotationArrayValueNode.class);
        list.add(AnnotationExpressionValueNode.class);
        ELEMENT_VALUE = new ParseRule<AnnotationValueNode>(AnnotationValueNode.class, list);
    }
    
    public static final ParseRule<AnnotationValueListNode> ELEMENT_VALUES = 
        new ParseRule<AnnotationValueListNode>(AnnotationValueListNode.class,
            Collections.<Class<? extends AnnotationValueListNode>>singleton(AnnotationValueListNode.class));
    
    public static final ParseRule<AnnotationElementNode> ELEMENT_VALUE_PAIR = 
        new ParseRule<AnnotationElementNode>(AnnotationElementNode.class,
            Collections.<Class<? extends AnnotationElementNode>>singleton(AnnotationElementNode.class));
    
    public static final ParseRule<AnnotationElementListNode> ELEMENT_VALUE_PAIRS = 
        new ParseRule<AnnotationElementListNode>(AnnotationElementListNode.class,
            Collections.<Class<? extends AnnotationElementListNode>>singleton(AnnotationElementListNode.class));
    
    public static final ParseRule<EnumBodyNode> ENUM_BODY = 
        new ParseRule<EnumBodyNode>(EnumBodyNode.class,
            Collections.<Class<? extends EnumBodyNode>>singleton(EnumBodyNode.class));
    
    public static final ParseRule<EnumConstantDeclarationNode> ENUM_CONSTANT = 
        new ParseRule<EnumConstantDeclarationNode>(EnumConstantDeclarationNode.class,
            Collections.<Class<? extends EnumConstantDeclarationNode>>singleton(EnumConstantDeclarationNode.class));
    
    public static final ParseRule<EnumConstantDeclarationListNode> ENUM_CONSTANTS = 
        new ParseRule<EnumConstantDeclarationListNode>(EnumConstantDeclarationListNode.class,
            Collections.<Class<? extends EnumConstantDeclarationListNode>>singleton(EnumConstantDeclarationListNode.class));
    
    public static final ParseRule<EnumModifiersNode> ENUM_MODIFIERS = 
        new ParseRule<EnumModifiersNode>(EnumModifiersNode.class,
            Collections.<Class<? extends EnumModifiersNode>>singleton(EnumModifiersNode.class));
    
    public static final ParseRule<UnparameterizedTypeListNode> EXCEPTION_TYPE_LIST = 
        new ParseRule<UnparameterizedTypeListNode>(UnparameterizedTypeListNode.class,
            Collections.<Class<? extends UnparameterizedTypeListNode>>singleton(UnparameterizedTypeListNode.class));
    
    public static final ParseRule<ConstructorInvocationNode> EXPLICIT_CONSTRUCTOR_INVOCATION;
    static
    {
        List<Class<? extends ConstructorInvocationNode>> list = new ArrayList<Class<? extends ConstructorInvocationNode>>(2);
        list.add(AlternateConstructorInvocationNode.class);
        list.add(SuperclassConstructorInvocationNode.class);
        EXPLICIT_CONSTRUCTOR_INVOCATION = new ParseRule<ConstructorInvocationNode>(ConstructorInvocationNode.class, list);
    }
    
    public static final ParseRule<FieldModifiersNode> FIELD_MODIFIERS = 
        new ParseRule<FieldModifiersNode>(FieldModifiersNode.class,
            Collections.<Class<? extends FieldModifiersNode>>singleton(FieldModifiersNode.class));
    
    public static final ParseRule<ForInitializerNode> FOR_INIT;
    static
    {
        List<Class<? extends ForInitializerNode>> list = new ArrayList<Class<? extends ForInitializerNode>>(2);
        list.add(ForInitializerDeclarationNode.class);
        list.add(ForInitializerExpressionNode.class);
        FOR_INIT = new ParseRule<ForInitializerNode>(ForInitializerNode.class, list);
    }
    
    public static final ParseRule<VariableNode> FORMAL_PARAMETER = 
        new ParseRule<VariableNode>(VariableNode.class,
            Collections.<Class<? extends VariableNode>>singleton(VariableNode.class));
    
    public static final ParseRule<IdentifierNode> IDENTIFIER = 
        new ParseRule<IdentifierNode>(IdentifierNode.class,
            Collections.<Class<? extends IdentifierNode>>singleton(IdentifierNode.class));
    
    public static final ParseRule<IdentifierListNode> IDENTIFIER_LIST = 
        new ParseRule<IdentifierListNode>(IdentifierListNode.class,
            Collections.<Class<? extends IdentifierListNode>>singleton(IdentifierListNode.class));
    
    public static final ParseRule<ImportNode> IMPORT_DECLARATION;
    static
    {
        List<Class<? extends ImportNode>> list = new ArrayList<Class<? extends ImportNode>>(4);
        list.add(ImportOnDemandNode.class);
        list.add(ImportSingleTypeNode.class);
        list.add(SingleStaticImportNode.class);
        list.add(StaticImportOnDemandNode.class);
        IMPORT_DECLARATION = new ParseRule<ImportNode>(ImportNode.class, list);
    }
    
    public static final ParseRule<ImportListNode> IMPORT_DECLARATIONS = 
        new ParseRule<ImportListNode>(ImportListNode.class,
            Collections.<Class<? extends ImportListNode>>singleton(ImportListNode.class));
    
    public static final ParseRule<InterfaceBodyNode> INTERFACE_BODY = 
        new ParseRule<InterfaceBodyNode>(InterfaceBodyNode.class,
            Collections.<Class<? extends InterfaceBodyNode>>singleton(InterfaceBodyNode.class));
    
    public static final ParseRule<InterfaceMemberNode> INTERFACE_MEMBER_DECLARATION;
    static
    {
        List<Class<? extends InterfaceMemberNode>> list = new ArrayList<Class<? extends InterfaceMemberNode>>(8);
        list.add(AnnotationDeclarationNode.class);
        list.add(ClassDeclarationNode.class);
        list.add(ConstantDeclarationNode.class);
        list.add(EnumDeclarationNode.class);
        list.add(InterfaceDeclarationNode.class);
        list.add(InterfaceMemberMetaprogramAnchorNode.class);
        list.add(MethodDeclarationNode.class);
        list.add(NoOperationNode.class);
        INTERFACE_MEMBER_DECLARATION = new ParseRule<InterfaceMemberNode>(InterfaceMemberNode.class, list);
    }
    
    public static final ParseRule<InterfaceMemberListNode> INTERFACE_MEMBER_DECLARATIONS = 
        new ParseRule<InterfaceMemberListNode>(InterfaceMemberListNode.class,
            Collections.<Class<? extends InterfaceMemberListNode>>singleton(InterfaceMemberListNode.class));
    
    public static final ParseRule<InterfaceModifiersNode> INTERFACE_MODIFIERS = 
        new ParseRule<InterfaceModifiersNode>(InterfaceModifiersNode.class,
            Collections.<Class<? extends InterfaceModifiersNode>>singleton(InterfaceModifiersNode.class));
    
    public static final ParseRule<JavadocNode> JAVADOC_COMMENT = 
        new ParseRule<JavadocNode>(JavadocNode.class,
            Collections.<Class<? extends JavadocNode>>singleton(JavadocNode.class));
    
    public static final ParseRule<LocalClassDeclarationNode> LOCAL_CLASS_DECLARATION = 
        new ParseRule<LocalClassDeclarationNode>(LocalClassDeclarationNode.class,
            Collections.<Class<? extends LocalClassDeclarationNode>>singleton(LocalClassDeclarationNode.class));
    
    public static final ParseRule<LocalClassModifiersNode> LOCAL_CLASS_MODIFIERS = 
        new ParseRule<LocalClassModifiersNode>(LocalClassModifiersNode.class,
            Collections.<Class<? extends LocalClassModifiersNode>>singleton(LocalClassModifiersNode.class));
    
    public static final ParseRule<MetaAnnotationNode> META_ANNOTATION;
    static
    {
        List<Class<? extends MetaAnnotationNode>> list = new ArrayList<Class<? extends MetaAnnotationNode>>(2);
        list.add(NormalMetaAnnotationNode.class);
        list.add(SingleElementMetaAnnotationNode.class);
        META_ANNOTATION = new ParseRule<MetaAnnotationNode>(MetaAnnotationNode.class, list);
    }
    
    public static final ParseRule<MetaAnnotationListNode> META_ANNOTATION_LIST = 
        new ParseRule<MetaAnnotationListNode>(MetaAnnotationListNode.class,
            Collections.<Class<? extends MetaAnnotationListNode>>singleton(MetaAnnotationListNode.class));
    
    public static final ParseRule<MetaAnnotationElementNode> META_ANNOTATION_ELEMENT = 
        new ParseRule<MetaAnnotationElementNode>(MetaAnnotationElementNode.class,
            Collections.<Class<? extends MetaAnnotationElementNode>>singleton(MetaAnnotationElementNode.class));
    
    public static final ParseRule<MetaAnnotationElementListNode> META_ANNOTATION_ELEMENTS = 
        new ParseRule<MetaAnnotationElementListNode>(MetaAnnotationElementListNode.class,
            Collections.<Class<? extends MetaAnnotationElementListNode>>singleton(MetaAnnotationElementListNode.class));
    
    public static final ParseRule<MetaAnnotationValueNode> META_ANNOTATION_ELEMENT_VALUE;
    static
    {
        List<Class<? extends MetaAnnotationValueNode>> list = new ArrayList<Class<? extends MetaAnnotationValueNode>>(3);
        list.add(MetaAnnotationArrayValueNode.class);
        list.add(MetaAnnotationExpressionValueNode.class);
        list.add(MetaAnnotationMetaAnnotationValueNode.class);
        META_ANNOTATION_ELEMENT_VALUE = new ParseRule<MetaAnnotationValueNode>(MetaAnnotationValueNode.class, list);
    }
    
    public static final ParseRule<MetaAnnotationValueListNode> META_ANNOTATION_ELEMENT_VALUES = 
        new ParseRule<MetaAnnotationValueListNode>(MetaAnnotationValueListNode.class,
            Collections.<Class<? extends MetaAnnotationValueListNode>>singleton(MetaAnnotationValueListNode.class));
    
    public static final ParseRule<MetaprogramNode> METAPROGRAM = 
        new ParseRule<MetaprogramNode>(MetaprogramNode.class,
            Collections.<Class<? extends MetaprogramNode>>singleton(MetaprogramNode.class));
    
    public static final ParseRule<MetaprogramDependencyNode> METAPROGRAM_DEPENDENCY = 
        new ParseRule<MetaprogramDependencyNode>(MetaprogramDependencyNode.class,
            Collections.<Class<? extends MetaprogramDependencyNode>>singleton(MetaprogramDependencyNode.class));
    
    public static final ParseRule<MetaprogramDependencyDeclarationNode> METAPROGRAM_DEPENDENCY_DECLARATION = 
        new ParseRule<MetaprogramDependencyDeclarationNode>(MetaprogramDependencyDeclarationNode.class,
            Collections.<Class<? extends MetaprogramDependencyDeclarationNode>>singleton(MetaprogramDependencyDeclarationNode.class));
    
    public static final ParseRule<MetaprogramDependencyDeclarationListNode> METAPROGRAM_DEPENDENCY_DECLARATION_LIST = 
        new ParseRule<MetaprogramDependencyDeclarationListNode>(MetaprogramDependencyDeclarationListNode.class,
            Collections.<Class<? extends MetaprogramDependencyDeclarationListNode>>singleton(MetaprogramDependencyDeclarationListNode.class));
    
    public static final ParseRule<MetaprogramDependencyListNode> METAPROGRAM_DEPENDENCY_LIST = 
        new ParseRule<MetaprogramDependencyListNode>(MetaprogramDependencyListNode.class,
            Collections.<Class<? extends MetaprogramDependencyListNode>>singleton(MetaprogramDependencyListNode.class));
    
    public static final ParseRule<MetaprogramImportNode> METAPROGRAM_IMPORT_DECLARATION = 
        new ParseRule<MetaprogramImportNode>(MetaprogramImportNode.class,
            Collections.<Class<? extends MetaprogramImportNode>>singleton(MetaprogramImportNode.class));
    
    public static final ParseRule<MetaprogramImportListNode> METAPROGRAM_IMPORT_DECLARATION_LIST = 
        new ParseRule<MetaprogramImportListNode>(MetaprogramImportListNode.class,
            Collections.<Class<? extends MetaprogramImportListNode>>singleton(MetaprogramImportListNode.class));
    
    public static final ParseRule<MetaprogramTargetNode> METAPROGRAM_TARGET_DECLARATION = 
        new ParseRule<MetaprogramTargetNode>(MetaprogramTargetNode.class,
            Collections.<Class<? extends MetaprogramTargetNode>>singleton(MetaprogramTargetNode.class));
    
    public static final ParseRule<MetaprogramTargetListNode> METAPROGRAM_TARGET_DECLARATION_LIST = 
        new ParseRule<MetaprogramTargetListNode>(MetaprogramTargetListNode.class,
            Collections.<Class<? extends MetaprogramTargetListNode>>singleton(MetaprogramTargetListNode.class));
    
    public static final ParseRule<MethodModifiersNode> METHOD_MODIFIERS = 
        new ParseRule<MethodModifiersNode>(MethodModifiersNode.class,
            Collections.<Class<? extends MethodModifiersNode>>singleton(MethodModifiersNode.class));
    
    public static final ParseRule<NameNode> NAME;
    static
    {
        List<Class<? extends NameNode>> list = new ArrayList<Class<? extends NameNode>>(2);
        list.add(QualifiedNameNode.class);
        list.add(SimpleNameNode.class);
        NAME = new ParseRule<NameNode>(NameNode.class, list);
    }
    
    public static final ParseRule<PackageDeclarationNode> PACKAGE_DECLARATION = 
        new ParseRule<PackageDeclarationNode>(PackageDeclarationNode.class,
            Collections.<Class<? extends PackageDeclarationNode>>singleton(PackageDeclarationNode.class));
    
    public static final ParseRule<MetaprogramPreambleNode> PREAMBLE = 
        new ParseRule<MetaprogramPreambleNode>(MetaprogramPreambleNode.class,
            Collections.<Class<? extends MetaprogramPreambleNode>>singleton(MetaprogramPreambleNode.class));
    
    public static final ParseRule<ReferenceTypeListNode> REFERENCE_TYPE_LIST = 
        new ParseRule<ReferenceTypeListNode>(ReferenceTypeListNode.class,
            Collections.<Class<? extends ReferenceTypeListNode>>singleton(ReferenceTypeListNode.class));
    
    public static final ParseRule<StatementExpressionListNode> STATEMENT_EXPRESSION_LIST = 
        new ParseRule<StatementExpressionListNode>(StatementExpressionListNode.class,
            Collections.<Class<? extends StatementExpressionListNode>>singleton(StatementExpressionListNode.class));
    
    public static final ParseRule<CaseNode> SWITCH_BLOCK_STATEMENT_GROUP = 
        new ParseRule<CaseNode>(CaseNode.class,
            Collections.<Class<? extends CaseNode>>singleton(CaseNode.class));
    
    public static final ParseRule<CaseListNode> SWITCH_BLOCK_STATEMENT_GROUPS = 
        new ParseRule<CaseListNode>(CaseListNode.class,
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
        TYPE = new ParseRule<TypeNode>(TypeNode.class, list);
    }
    
    public static final ParseRule<TypeArgumentListNode> TYPE_ARGUMENTS = 
        new ParseRule<TypeArgumentListNode>(TypeArgumentListNode.class,
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
        TYPE_DECLARATION = new ParseRule<TypeDeclarationNode>(TypeDeclarationNode.class, list);
    }
    
    public static final ParseRule<TypeDeclarationListNode> TYPE_DECLARATIONS = 
        new ParseRule<TypeDeclarationListNode>(TypeDeclarationListNode.class,
            Collections.<Class<? extends TypeDeclarationListNode>>singleton(TypeDeclarationListNode.class));
    
    public static final ParseRule<TypeParameterNode> TYPE_PARAMETER = 
        new ParseRule<TypeParameterNode>(TypeParameterNode.class,
            Collections.<Class<? extends TypeParameterNode>>singleton(TypeParameterNode.class));
    
    public static final ParseRule<TypeParameterListNode> TYPE_PARAMETERS = 
        new ParseRule<TypeParameterListNode>(TypeParameterListNode.class,
            Collections.<Class<? extends TypeParameterListNode>>singleton(TypeParameterListNode.class));
    
    public static final ParseRule<VariableDeclaratorNode> VARIABLE_DECLARATOR = 
        new ParseRule<VariableDeclaratorNode>(VariableDeclaratorNode.class,
            Collections.<Class<? extends VariableDeclaratorNode>>singleton(VariableDeclaratorNode.class));
    
    public static final ParseRule<VariableDeclaratorListNode> VARIABLE_DECLARATORS = 
        new ParseRule<VariableDeclaratorListNode>(VariableDeclaratorListNode.class,
            Collections.<Class<? extends VariableDeclaratorListNode>>singleton(VariableDeclaratorListNode.class));
    
    public static final ParseRule<VariableInitializerNode> VARIABLE_INITIALIZER;
    static
    {
        List<Class<? extends VariableInitializerNode>> list = new ArrayList<Class<? extends VariableInitializerNode>>(31);
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
        list.add(MethodInvocationByExpressionNode.class);
        list.add(MethodInvocationByNameNode.class);
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
        VARIABLE_INITIALIZER = new ParseRule<VariableInitializerNode>(VariableInitializerNode.class, list);
    }
    
    public static final ParseRule<VariableInitializerListNode> VARIABLE_INITIALIZERS = 
        new ParseRule<VariableInitializerListNode>(VariableInitializerListNode.class,
            Collections.<Class<? extends VariableInitializerListNode>>singleton(VariableInitializerListNode.class));
    
    public static final ParseRule<VariableModifiersNode> VARIABLE_MODIFIERS = 
        new ParseRule<VariableModifiersNode>(VariableModifiersNode.class,
            Collections.<Class<? extends VariableModifiersNode>>singleton(VariableModifiersNode.class));
    
    public static final ParseRule<WildcardTypeNode> WILDCARD = 
        new ParseRule<WildcardTypeNode>(WildcardTypeNode.class,
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
