package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
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
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * Applies the environment changes that a parent environment node has on its environment child. This operation operates
 * on the parent node. Its two arguments are the environment provided to the parent and the child node for which an
 * environment should be constructed. The returned value is that child node's environment.
 * <p/>
 * Note that here, the terms "parent" and "child" refer to the environment affect relationship and not necessarily to an
 * AST connectivity relationship. A compilation unit is the environment parent of a top-level type declaration, but the
 * environment parent of a block statement is usually the block statement which appeared immediately before it.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentModifyingNodeOperation implements BsjNodeOperation2Arguments<Environment, Node, Environment>
{
	/** The typechecker toolkit to use. */
	private TypecheckerToolkit toolkit;
	/** The compilation unit loader to use. */
	private CompilationUnitLoader loader;
	/** The diagnostic listener to use. */
	private DiagnosticListener<BsjSourceLocation> listener;

	public EnvironmentModifyingNodeOperation(TypecheckerToolkit toolkit, CompilationUnitLoader loader,
			DiagnosticListener<BsjSourceLocation> listener)
	{
		super();
		this.toolkit = toolkit;
		this.loader = loader;
		this.listener = listener;
	}

	@Override
	public Environment executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationBodyNode(AnnotationBodyNode node, Environment env, Node child)
	{
		// *** Create a new scope for inherited member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate elements inherited from java.lang.annotation.Annotation
		AnnotationDeclarationNode declarationNode = (AnnotationDeclarationNode) node.getParent();
		populateInheritedMembersFor(declarationNode, env);

		// *** Create a new scope for declared member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(env, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Environment env, Node child)
	{
		// The declaration of an annotation does not affect it in any way that its surrounding environment does not
		// already recognize.
		return env;
	}

	@Override
	public Environment executeAnnotationElementListNode(AnnotationElementListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationElementNode(AnnotationElementNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationListNode(AnnotationListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationMemberListNode(AnnotationMemberListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationMemberMetaprogramAnchorNode(AnnotationMemberMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationModifiersNode(AnnotationModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnnotationValueListNode(AnnotationValueListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Environment env, Node child)
	{
		// *** Make a new environment for inherited members
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate inherited members
		populateInheritedMembersFor(node, env);

		// *** Create a new environment for declared members
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate declared members
		populateElements(env, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeAnonymousClassMemberMetaprogramAnchorNode(AnonymousClassMemberMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeArrayAccessNode(ArrayAccessNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeArrayInitializerNode(ArrayInitializerNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeArrayTypeNode(ArrayTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAssertStatementNode(AssertStatementNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeAssignmentNode(AssignmentNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBinaryExpressionNode(BinaryExpressionNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBlockNode(BlockNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBlockStatementListNode(BlockStatementListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBooleanLiteralNode(BooleanLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeBreakNode(BreakNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCaseListNode(CaseListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCaseNode(CaseNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCatchListNode(CatchListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCatchNode(CatchNode node, Environment env, Node child)
	{
		// *** The scope of the parameter in a catch block is the body of that catch block
		if (node.getBody().equals(child))
		{
			env = makeEnvironment(env, EnvType.STATEMENT);
			populateParameters(env, Collections.singletonList(node.getParameter()));

		}
		return env;
	}

	@Override
	public Environment executeCharLiteralNode(CharLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeClassBodyNode(ClassBodyNode node, Environment env, Node child)
	{
		// *** Create a new scope for inherited member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Inherit member elements
		ClassDeclarationNode declarationNode = (ClassDeclarationNode) node.getParent();
		populateInheritedMembersFor(declarationNode, env);

		// *** Create a new scope for declared member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(env, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeClassDeclarationNode(ClassDeclarationNode node, Environment env, Node child)
	{
		// *** Create a new scope for type parameters
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(env, node.getTypeParameters());

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeClassLiteralNode(ClassLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeClassMemberListNode(ClassMemberListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeClassMemberMetaprogramAnchorNode(ClassMemberMetaprogramAnchorNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeClassModifiersNode(ClassModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCodeLiteralNode(CodeLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeCompilationUnitNode(CompilationUnitNode node, Environment env, Node child)
	{
		// Only the type declarations contained in a compilation unit benefit from the declarations contained within
		// it; import statements, for instance, do not apply to other import statements. Leave now if we're not
		// processing for a type declaration.
		if (!(child instanceof TypeDeclarationListNode))
		{
			return env;
		}

		// *** Create a new scope for the on-demand imports
		env = makeEnvironment(env, EnvType.ON_DEMAND_IMPORT);

		// *** Process on-demand imports. This namespace has a lazy error policy, as ambiguities in on-demand
		// imports (such as "import java.util.*; import java.awt.*;" only matter if the ambiguous name is used
		// (such as in "List").
		populateOnDemandImports(env.getTypeNamespaceMap(), node.getImports());

		// *** Process on-demand static imports.
		populateOnDemandStaticImports(env, node.getImports());

		// *** Process top-level package peers. This namespace has an eager error policy as any duplication means
		// a name conflict in the local package.
		TypeNamespaceMap typeNamespaceMap = makeTypeNamespace(env.getTypeNamespaceMap(), true, false);
		populateNamespaceMapWithPackage(typeNamespaceMap, (PackageNode) node.getParent(),
				node.getPackageDeclaration() == null ? node : node.getPackageDeclaration());

		// *** Process single-type imports. This namespace has a eager error policy, as ambiguities in single-type
		// imports cause the import statements to be useless in any context (such as
		// "import java.util.List; import java.awt.List;").
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true, false);
		populateSingleTypeImports(typeNamespaceMap, node.getImports());

		// *** Process single-type static imports.
		env = new Environment(typeNamespaceMap, makeMethodNamespace(env.getMethodNamespaceMap(), true, false),
				makeVariableNamespace(env.getVariableNamespaceMap(), true, false));
		populateSingleStaticImports(env, node.getImports());

		// *** Process top-level type declarations. The addition of the public top-level type declaration will, of
		// course, be redundant (because it was obtained in from package peers above). The same typespace map is used,
		// since a top-level type named N in the same compilation unit and a single-static import of a type named N will
		// conflict.
		populateElements(env, node.getTypeDecls(), AccessModifier.PUBLIC);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeConditionalExpressionNode(ConditionalExpressionNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstantDeclarationNode(ConstantDeclarationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstantModifiersNode(ConstantModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstructorBodyNode(ConstructorBodyNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstructorDeclarationNode(ConstructorDeclarationNode node, Environment env, Node child)
	{
		// *** Create a new environment for type parameter population
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(env, node.getTypeParameters());

		// *** Populate constructor parameters into constructor invocation and constructor body
		if (child instanceof ConstructorBodyNode)
		{
			populateParameters(env, node.getParameters());
		}

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeConstructorModifiersNode(ConstructorModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeContinueNode(ContinueNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeDeclaredTypeListNode(DeclaredTypeListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeDoWhileLoopNode(DoWhileLoopNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeDoubleLiteralNode(DoubleLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnhancedForLoopNode(EnhancedForLoopNode node, Environment env, Node child)
	{
		// *** The scope of the parameter to the enhanced for loop is the body of that loop
		if (node.getStatement().equals(child))
		{
			env = makeEnvironment(env, EnvType.STATEMENT);
			populateParameters(env, Collections.singletonList(node.getVariable()));
		}
		return env;
	}

	@Override
	public Environment executeEnumBodyNode(EnumBodyNode node, Environment env, Node child)
	{
		// *** Create a new scope for inherited member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Inherit member elements
		EnumDeclarationNode declarationNode = (EnumDeclarationNode) node.getParent();
		populateInheritedMembersFor(declarationNode, env);

		// *** Create a new scope for declared member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Add hard-coded elements as specified in JLS v3 S8.9
		// TODO: how do we create elements which are not backed by AST nodes?
		// public static E[] values();
		// public static E valueOf(String);

		// *** Populate enum constants
		populateElements(env, node.getConstants(), AccessModifier.PRIVATE);

		// *** Populate member elements
		populateElements(env, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnumConstantModifiersNode(EnumConstantModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnumDeclarationNode(EnumDeclarationNode node, Environment env, Node child)
	{
		// Nothing in the scope of the declaration itself affects the symbol table. (The members are in the scope
		// of the body.)
		return env;
	}

	@Override
	public Environment executeEnumModifiersNode(EnumModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeExpressionListNode(ExpressionListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeExpressionStatementNode(ExpressionStatementNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeFieldDeclarationNode(FieldDeclarationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeFieldModifiersNode(FieldModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeFloatLiteralNode(FloatLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeForInitializerExpressionNode(ForInitializerExpressionNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeForLoopNode(ForLoopNode node, Environment env, Node child)
	{
		if (child.equals(node.getInitializer()))
		{
			// Addressed by the children of this node. Either it's a statement expression list (in which case
			// no changes occur) or it's a local variable declaration (in which case the local variable declaration
			// handler will populate things properly).
		} else
		{
			// Populate all of the contents of the initializer
			if (node.getInitializer() instanceof ForInitializerDeclarationNode)
			{
				env = makeEnvironment(env, EnvType.STATEMENT);
				tryPopulateLocalVariable(env.getVariableNamespaceMap(),
						((ForInitializerDeclarationNode) node.getInitializer()).getDeclaration());
			}
		}
		return env;
	}

	@Override
	public Environment executeIdentifierListNode(IdentifierListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeIdentifierNode(IdentifierNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeIfNode(IfNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeImportListNode(ImportListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeImportOnDemandNode(ImportOnDemandNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeImportSingleTypeNode(ImportSingleTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeInitializerDeclarationNode(InitializerDeclarationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeInstanceOfNode(InstanceOfNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeIntLiteralNode(IntLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeInterfaceBodyNode(InterfaceBodyNode node, Environment env, Node child)
	{
		// *** Create a new scope for inherited member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Inherit member elements
		InterfaceDeclarationNode declarationNode = (InterfaceDeclarationNode) node.getParent();
		populateInheritedMembersFor(declarationNode, env);

		// *** Create a new scope for declared member elements
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate member elements
		populateElements(env, node.getMembers(), AccessModifier.PRIVATE);

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Environment env, Node child)
	{
		// *** Create a new scope for type parameters
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(env, node.getTypeParameters());

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeInterfaceMemberListNode(InterfaceMemberListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeInterfaceModifiersNode(InterfaceModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeJavadocNode(JavadocNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeLabeledStatementNode(LabeledStatementNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Environment env, Node child)
	{
		// *** Create a new environment to contain the declaration
		env = makeEnvironment(env, EnvType.STATEMENT);

		// *** Populate the type itself into the namespace
		env.getTypeNamespaceMap().add(node.getIdentifier().getIdentifier(), this.toolkit.makeElement(node), node);

		// *** Finished
		return env;
	}

	@Override
	public Environment executeLocalClassModifiersNode(LocalClassModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, Environment env,
			Node child)
	{
		if (node.getType().equals(child) || node.getModifiers().equals(child) || node.getDeclarators().equals(child))
		{
			// In this case, none of the declarators apply. We're going to let the declarator list sort out which of
			// its children get which values in scope. The only environment children that get all of the declarators
			// are those which follow this statement.
		} else
		{
			env = makeEnvironment(env, EnvType.STATEMENT);
			tryPopulateLocalVariable(env.getVariableNamespaceMap(), node);
		}
		return env;
	}

	@Override
	public Environment executeLongLiteralNode(LongLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationArrayValueNode(MetaAnnotationArrayValueNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationElementNode(MetaAnnotationElementNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationListNode(MetaAnnotationListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramDependencyNode(MetaprogramDependencyNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramImportListNode(MetaprogramImportListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramImportNode(MetaprogramImportNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramNode(MetaprogramNode node, Environment env, Node child)
	{
		// TODO: complete this section.
		/*
		 * Properly implementing this code would require the following:
		 * 
		 * 1. Metaprogram imports both from the compilation unit as well as the preamble would need to apply to the
		 * preamble's non-import section and the metaprogram body. Note that these imports would be coming from the
		 * *metaprogram's* classpath, not the object program's classpath.
		 * 
		 * 2. The metaprogram body needs to have a local variable be defined of type Context<T>. Note that, to be a
		 * correct implementation, the type of T must be properly filled out.
		 * 
		 * There is some question as to whether or not this method should ever be implemented; it probably wouldn't be
		 * necessary for a metaprogram to do this kind of analysis and the modeling of the imported types would get
		 * tedious at best. For now, we're just clearing out the environment to make clear the fact that none of the
		 * object program logic applies.
		 */
		return new Environment(new TypeNamespaceMap(null, this.listener, false, false), new MethodNamespaceMap(null,
				this.listener, false, false), new VariableNamespaceMap(null, this.listener, false, false));
	}

	@Override
	public Environment executeMetaprogramPreambleNode(MetaprogramPreambleNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramTargetListNode(MetaprogramTargetListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMetaprogramTargetNode(MetaprogramTargetNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMethodDeclarationNode(MethodDeclarationNode node, Environment env, Node child)
	{
		// *** Create a new environment for type parameter population
		env = makeEnvironment(env, EnvType.TYPE_OR_MEMBER);

		// *** Populate type parameters (which are in scope of the entire declaration)
		populateTypeParameters(env, node.getTypeParameters());

		// *** Populate method parameters into method body
		if (child instanceof BlockStatementListNode)
		{
			populateParameters(env, node.getParameters());
		}

		// *** Finished!
		return env;
	}

	@Override
	public Environment executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeMethodInvocationByNameNode(MethodInvocationByNameNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeMethodModifiersNode(MethodModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeNoOperationNode(NoOperationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeNormalAnnotationNode(NormalAnnotationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeNullLiteralNode(NullLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executePackageDeclarationNode(PackageDeclarationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executePackageNode(PackageNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeParameterizedTypeNode(ParameterizedTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executePrimitiveTypeNode(PrimitiveTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeQualifiedNameNode(QualifiedNameNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeRawCodeLiteralNode(RawCodeLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeReferenceTypeListNode(ReferenceTypeListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeReturnNode(ReturnNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSimpleNameNode(SimpleNameNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSingleElementMetaAnnotationNode(SingleElementMetaAnnotationNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeSingleStaticImportNode(SingleStaticImportNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeStatementExpressionListNode(StatementExpressionListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeStringLiteralNode(StringLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSuperFieldAccessNode(SuperFieldAccessNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSuperMethodInvocationNode(SuperMethodInvocationNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSwitchNode(SwitchNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeSynchronizedNode(SynchronizedNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeThisNode(ThisNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeThrowNode(ThrowNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTryNode(TryNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeArgumentListNode(TypeArgumentListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeCastNode(TypeCastNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeDeclarationListNode(TypeDeclarationListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeDeclarationMetaprogramAnchorNode(TypeDeclarationMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeParameterListNode(TypeParameterListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeTypeParameterNode(TypeParameterNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeUnaryExpressionNode(UnaryExpressionNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node,
			Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, Environment env,
			Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableAccessByNameNode(VariableAccessByNameNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableDeclaratorListNode(VariableDeclaratorListNode node, Environment env, Node child)
	{
		// *** A variable declarator child of this list has in its scope all declarators which appear before it in the
		// list (but not itself; that is handled at a finer granularity).

		if (child instanceof VariableDeclaratorNode)
		{
			env = makeEnvironment(env, EnvType.STATEMENT);
			VariableDeclaratorNode it = (VariableDeclaratorNode) child;
			it = node.getBefore(it);
			while (it != null)
			{
				tryPopulateVariableDeclarator(env.getVariableNamespaceMap(), it);
				it = node.getBefore(it);
			}
		}
		return env;
	}

	@Override
	public Environment executeVariableDeclaratorNode(VariableDeclaratorNode node, Environment env, Node child)
	{
		// *** The scope of a variable declarator includes its own initializer.
		if (child.equals(node.getInitializer()))
		{
			env = makeEnvironment(env, EnvType.STATEMENT);
			tryPopulateVariableDeclarator(env.getVariableNamespaceMap(), node);
		}

		return env;
	}

	@Override
	public Environment executeVariableInitializerListNode(VariableInitializerListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableListNode(VariableListNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableModifiersNode(VariableModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableNode(VariableNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVoidTypeNode(VoidTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeWhileLoopNode(WhileLoopNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeWildcardTypeNode(WildcardTypeNode node, Environment env, Node child)
	{
		return env;
	}

	// ***** BEGIN UTILITY METHODS *******************************************

	private void populateOnDemandImports(TypeNamespaceMap typeNamespaceMap, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportOnDemandNode)
			{
				switch (importNode.getName().getCategory(loader))
				{
					case PACKAGE:
						PackageNode packageNode = importNode.getRootPackage().getSubpackageByQualifiedName(
								importNode.getName());
						loader.loadAll(packageNode);
						populateNamespaceMapWithPackage(typeNamespaceMap, packageNode, importNode);
						break;
					case TYPE:
						NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
						if (type == null)
						{
							// TODO: emit an appropriate diagnostic - the type from which to import doesn't exist
							throw new NotImplementedYetException();
						} else
						{
							for (Node node : type.getBody().getMembers())
							{
								if (node instanceof NamedTypeDeclarationNode<?>)
								{
									tryPopulateMemberType(typeNamespaceMap, importNode,
											(NamedTypeDeclarationNode<?>) node, AccessModifier.PUBLIC, null);
								}
							}
						}
						break;
					default:
						// In this case, the name categorizer messed up
						throw new IllegalStateException(
								"Name categorizer gave non-package, non-type category to import name: "
										+ importNode.getName().getNameString() + " has category "
										+ importNode.getName().getCategory(loader));
				}
			}
		}
	}

	private void populateOnDemandStaticImports(Environment environment, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof StaticImportOnDemandNode)
			{
				if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
				{
					// On-demand static imports can only name types.
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				}

				// For each member of the type, import it if possible
				NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
				if (type == null)
				{
					// TODO: emit an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					populateElements(environment, type.getBody().getMembers(), AccessModifier.PUBLIC);
				}
			}
		}
	}

	private void populateSingleTypeImports(TypeNamespaceMap map, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportSingleTypeNode)
			{
				NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
				if (type == null)
				{
					// TODO: raise some kind of appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					map.add(type.getIdentifier().getIdentifier(), (BsjTypeElement) this.toolkit.makeElement(type),
							importNode);
				}
			}
		}
	}

	private void populateSingleStaticImports(Environment environment, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof SingleStaticImportNode)
			{
				if (importNode.getName().getCategory(loader) != NameCategory.TYPE)
				{
					// On-demand static imports can only name types.
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				}

				// Find all members of the type which have the specified name.
				NamedTypeDeclarationNode<?> type = this.toolkit.getAccessibleTypeFromFullyQualifiedName(importNode.getName());
				SingleStaticImportNode singleStaticImportNode = (SingleStaticImportNode) importNode;
				if (type == null)
				{
					// TODO: emit an appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					populateElements(environment, type.getBody().getMembers(), AccessModifier.PUBLIC, false,
							singleStaticImportNode.getIdentifier().getIdentifier());
				}
			}
		}
	}

	/**
	 * Populates the elements represented by a list of nodes into an environment as immediately-accessible members.
	 * 
	 * @param environment The environment into which to populate.
	 * @param nodes The list of nodes from which to extract the elements to populate.
	 * @param access The level of access to use during population.
	 */
	private void populateElements(Environment environment, Iterable<? extends Node> nodes, AccessModifier access)
	{
		populateElements(environment, nodes, access, false, null);
	}

	/**
	 * Populates the elements represented by a list of nodes into a set of namespace maps as immediately-accessible
	 * members.
	 * 
	 * @param environment The environment into which to populate.
	 * @param nodes The list of nodes from which to extract the elements to populate.
	 * @param access The level of access to use during population.
	 * @param skipNonMembers <code>true</code> if non-members such as constructors should be skipped; <code>false</code>
	 *            otherwise.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void populateElements(Environment environment, Iterable<? extends Node> nodes, AccessModifier access,
			boolean skipNonMembers, String name)
	{
		for (Node node : nodes)
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				tryPopulateMemberType(environment.getTypeNamespaceMap(), node, (NamedTypeDeclarationNode<?>) node,
						access, name);
			} else if (node instanceof FieldDeclarationNode)
			{
				tryPopulateMemberField(environment.getVariableNamespaceMap(), node, (FieldDeclarationNode) node,
						access, name);
			} else if (node instanceof ConstantDeclarationNode)
			{
				tryPopulateMemberConstant(environment.getVariableNamespaceMap(), node, (ConstantDeclarationNode) node,
						name);
			} else if (node instanceof EnumConstantDeclarationNode)
			{
				tryPopulateMemberEnumConstant(environment.getVariableNamespaceMap(), node,
						(EnumConstantDeclarationNode) node, name);
			} else if (node instanceof MethodDeclarationNode)
			{
				tryPopulateMemberMethod(environment.getMethodNamespaceMap(), node, (MethodDeclarationNode) node,
						access, name);
			} else if (node instanceof AnnotationMethodDeclarationNode)
			{
				tryPopulateAnnotationMemberMethod(environment.getMethodNamespaceMap(), node,
						(AnnotationMethodDeclarationNode) node, name);
			} else if (!skipNonMembers)
			{
				if (node instanceof ConstructorDeclarationNode && name == null)
				{
					tryPopulateMemberConstructor(environment.getMethodNamespaceMap(), node,
							(ConstructorDeclarationNode) node, access);
				}
			}
		}
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods. This
	 * method will also inherit the members of the specified type; as a result, this should not be used directly by the
	 * operation methods.
	 * 
	 * @param declarationNode The declaration to use.
	 * @param env The environment to use.
	 */
	private void populateInheritedMembersWithDynamicDispatchFor(NamedTypeDeclarationNode<?> declarationNode,
			Environment env)
	{
		// First, dispatch to the node's parents.
		declarationNode.executeOperation(new BsjDefaultNodeOperation<Environment, Void>()
		{
			@Override
			public Void executeDefault(Node node, Environment env)
			{
				throw new IllegalStateException("Don't know how to handle inherited type from node type "
						+ node.getClass());
			}

			@Override
			public Void executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Environment env)
			{
				populateInheritedMembersFor(node, env);
				return null;
			}

			@Override
			public Void executeClassDeclarationNode(ClassDeclarationNode node, Environment env)
			{
				populateInheritedMembersFor(node, env);
				return null;
			}

			@Override
			public Void executeEnumDeclarationNode(EnumDeclarationNode node, Environment env)
			{
				populateInheritedMembersFor(node, env);
				return null;
			}

			@Override
			public Void executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Environment env)
			{
				populateInheritedMembersFor(node, env);
				return null;
			}
		}, env);

		// Next, populate this node's members.
		// TODO: PROTECTED or PACKAGE?
		populateElements(env, declarationNode.getBody().getMembers(), AccessModifier.PROTECTED, true, null);
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if the anonymous class is an implicit subtype of
	 * the <tt>Foo</tt> class, the members of <tt>Foo</tt> will be populated.
	 * 
	 * @param declarationNode The type for which the inherited environment is desired.
	 * @param env The environment to populate.
	 */
	private void populateInheritedMembersFor(AnonymousClassBodyNode declarationNode, Environment env)
	{
		if (declarationNode.getParent() instanceof ClassInstantiationNode)
		{
			if (declarationNode.getParent() instanceof QualifiedClassInstantiationNode)
			{
				// TODO
				throw new NotImplementedYetException();
			} else if (declarationNode.getParent() instanceof UnqualifiedClassInstantiationNode)
			{
				UnqualifiedClassInstantiationNode instantiationNode = (UnqualifiedClassInstantiationNode) declarationNode.getParent();
				populateDeclaredSupertype(instantiationNode.getType(), env);
			} else
			{
				throw new IllegalStateException("Don't know how to handle class instantiation node of type "
						+ declarationNode.getParent().getClass());
			}
		} else if (declarationNode.getParent() instanceof EnumConstantDeclarationNode)
		{
			EnumDeclarationNode enumDeclarationNode = declarationNode.getNearestAncestorOfType(EnumDeclarationNode.class);
			populateInheritedMembersWithDynamicDispatchFor(enumDeclarationNode, env);
		} else
		{
			throw new IllegalStateException("Don't know how to handle anonymous class body parent of type "
					+ declarationNode.getParent().getClass());
		}

		BsjTypeElement annotationElement = toolkit.getTypeElementByName("java", "lang", "annotation", "Annotation");
		populateInheritedMembersWithDynamicDispatchFor(annotationElement.getDeclarationNode(), env);
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited environment is desired.
	 * @param env The environment to populate.
	 */
	private void populateInheritedMembersFor(AnnotationDeclarationNode declarationNode, Environment env)
	{
		BsjTypeElement annotationElement = toolkit.getTypeElementByName("java", "lang", "annotation", "Annotation");
		populateInheritedMembersWithDynamicDispatchFor(annotationElement.getDeclarationNode(), env);
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> extends <tt>Object</tt>, the returned environment will contain all <tt>Object</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited environment is desired.
	 * @param env The environment to populate.
	 */
	private void populateInheritedMembersFor(ClassDeclarationNode declarationNode, Environment env)
	{
		BsjTypeElement objectElement = (BsjTypeElement) toolkit.getTypeElementByName("java", "lang", "Object");
		if (objectElement.equals(toolkit.makeElement(declarationNode)))
		{
			// Then we're already done; Object inherits nothing.
			return;
		}

		// populate everything from the superclass
		BsjTypeElement superclassElement = null;
		if (declarationNode.getExtendsClause() != null)
		{
			populateDeclaredSupertype(declarationNode.getExtendsClause(), env);
		} else
		{
			superclassElement = objectElement;
		}
		if (superclassElement != null)
		{
			populateInheritedMembersWithDynamicDispatchFor(superclassElement.getDeclarationNode(), env);
		}

		// populate everything from the superinterfaces
		for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
		{
			populateDeclaredSupertype(declaredTypeNode, env);
		}
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> implements <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited environment is desired.
	 * @param env The environment to populate.
	 */
	private void populateInheritedMembersFor(EnumDeclarationNode declarationNode, Environment env)
	{
		BsjTypeElement enumElement = toolkit.getTypeElementByName("java", "lang", "Enum");
		populateInheritedMembersWithDynamicDispatchFor(enumElement.getDeclarationNode(), env);

		// populate everything from the superinterfaces
		for (DeclaredTypeNode declaredTypeNode : declarationNode.getImplementsClause())
		{
			populateDeclaredSupertype(declaredTypeNode, env);
		}
	}

	/**
	 * Populates an environment with the members inherited by the given type. This method populates a scope for
	 * inherited members by recursively inheriting the parent members of this type. Note that it does not populate the
	 * members or other elements of the provided type. For instance, if class <tt>Foo</tt> is provided to this method
	 * and <tt>Foo</tt> implements <tt>Bar</tt>, the returned environment will contain all <tt>Bar</tt> methods.
	 * 
	 * @param declarationNode The type for which the inherited environment is desired.
	 * @param env The environment to populate.
	 */
	private void populateInheritedMembersFor(InterfaceDeclarationNode declarationNode, Environment env)
	{
		if (declarationNode.getExtendsClause().size() > 0)
		{
			// then inherit from each superinterface
			for (DeclaredTypeNode declaredTypeNode : declarationNode.getExtendsClause())
			{
				populateDeclaredSupertype(declaredTypeNode, env);
			}
		} else
		{
			// then inherit from Object
			BsjTypeElement objectElement = (BsjTypeElement) toolkit.getTypeElementByName("java", "lang", "Object");
			populateInheritedMembersWithDynamicDispatchFor(objectElement.getDeclarationNode(), env);
		}
	}

	/**
	 * Attempts to recurisvely populate an environment with the inherited members of a certain type. If the provided
	 * type is not a legal supertype, java.lang.Object is populated and a diagnostic is raised.
	 */
	private void populateDeclaredSupertype(DeclaredTypeNode node, Environment env)
	{
		BsjExplicitlyDeclaredType explicitlyDeclaredType = getExplicitlyDeclaredTypeFromNode(node);
		BsjTypeElement typeElement;
		if (explicitlyDeclaredType == null)
		{
			// This indicates that the code tried to extend or implement a type parameter. This is not legal.
			// TODO: raise an appropriate diagnostic
			typeElement = toolkit.getTypeElementByName("java", "lang", "Object");
			// TODO: remove the following once a diagnostic is reported
			throw new NotImplementedYetException();
		} else
		{
			typeElement = explicitlyDeclaredType.asElement();
		}
		populateInheritedMembersWithDynamicDispatchFor(typeElement.getDeclarationNode(), env);
	}

	/**
	 * Converts a {@link DeclaredTypeNode} into a {@link BsjExplicitlyDeclaredType} if possible. This will not be
	 * possible if the {@link DeclaredTypeNode} actually refers to a type parameter. If this is the case,
	 * <code>null</code> is returned instead.
	 * 
	 * @param node The node to convert.
	 * @return The resulting type or <code>null</code> if the node indicates a type parameter.
	 */
	private BsjExplicitlyDeclaredType getExplicitlyDeclaredTypeFromNode(DeclaredTypeNode node)
	{
		BsjNamedReferenceType referenceType = toolkit.makeType(node);
		if (referenceType instanceof BsjExplicitlyDeclaredType)
		{
			return (BsjExplicitlyDeclaredType) referenceType;
		} else
		{
			return null;
		}
	}

	/**
	 * Populates the specified parameters into the current environment.
	 */
	private void populateParameters(Environment env, List<VariableNode> parameters)
	{
		for (VariableNode parameter : parameters)
		{
			env.getVariableNamespaceMap().add(parameter.getIdentifier().getIdentifier(),
					(BsjVariableElement) this.toolkit.makeElement(parameter), parameter);
		}
	}

	/**
	 * Populates the specified type parameters into the current environment.
	 * 
	 * @param env The environment to use.
	 * @param typeParameters The type parameters to populate.
	 */
	private void populateTypeParameters(Environment env, List<TypeParameterNode> typeParameters)
	{
		for (TypeParameterNode typeParameterNode : typeParameters)
		{
			env.getTypeNamespaceMap().add(typeParameterNode.getIdentifier().getIdentifier(),
					(BsjTypeLikeElement) this.toolkit.makeElement(typeParameterNode), typeParameterNode);
		}
	}

	/**
	 * Attempts to populate a member type into the provided type namespace map. This will succeed if and only if the
	 * type in question has an access modifier and that access modifier is less restrictive or equally restrictive to
	 * the level of access provided.
	 * 
	 * @param typeNamespaceMap The namespace into which to populate the type.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberType The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberType(TypeNamespaceMap typeNamespaceMap, Node indicator,
			NamedTypeDeclarationNode<?> memberType, AccessModifier access, String name)
	{
		if (memberType.getModifiers() instanceof AccessibleTypeModifiersNode
				&& ((AccessibleTypeModifiersNode) memberType.getModifiers()).getAccess().compareTo(access) < 0
				&& (name == null || memberType.getIdentifier().getIdentifier().equals(name)))
		{
			typeNamespaceMap.add(memberType.getIdentifier().getIdentifier(),
					(BsjTypeElement) this.toolkit.makeElement(memberType), indicator);
		}
	}

	/**
	 * Attempts to populate a member method into the provided method namespace map. This will succeed if and only if the
	 * method's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the method.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberMethod The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberMethod(MethodNamespaceMap methodNamespaceMap, Node indicator,
			MethodDeclarationNode memberMethod, AccessModifier access, String name)
	{
		if ((memberMethod.getModifiers()).getAccess().compareTo(access) < 0
				&& (name == null || memberMethod.getIdentifier().getIdentifier().equals(name)))
		{
			methodNamespaceMap.add(memberMethod.getIdentifier().getIdentifier(),
					(BsjExecutableElement) this.toolkit.makeElement(memberMethod), indicator);
		}
	}

	/**
	 * Attempts to populate a member variable into the provided method namespace map. This will succeed if and only if
	 * the variable's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberField The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberField(VariableNamespaceMap variableNamespaceMap, Node indicator,
			FieldDeclarationNode memberField, AccessModifier access, String name)
	{
		if ((memberField.getModifiers()).getAccess().compareTo(access) <= 0)
		{
			for (VariableDeclaratorNode declaratorNode : memberField.getDeclarators())
			{
				if (name == null || declaratorNode.getName().getIdentifier().equals(name))
				{
					variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
							(BsjVariableElement) this.toolkit.makeElement(declaratorNode), declaratorNode);
				}
			}
		}
	}

	/**
	 * Populates a member constant into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberConstant The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberConstant(VariableNamespaceMap variableNamespaceMap, Node indicator,
			ConstantDeclarationNode memberConstant, String name)
	{
		for (VariableDeclaratorNode declaratorNode : memberConstant.getDeclarators())
		{
			if ((name == null || declaratorNode.getName().getIdentifier().equals(name)))
			{
				variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
						(BsjVariableElement) this.toolkit.makeElement(memberConstant), declaratorNode);
			}
		}
	}

	/**
	 * Populates a local variable into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param memberConstant The declaration which is being populated.
	 */
	private void tryPopulateLocalVariable(VariableNamespaceMap variableNamespaceMap,
			LocalVariableDeclarationNode declarationNode)
	{
		for (VariableDeclaratorNode declaratorNode : declarationNode.getDeclarators())
		{
			variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
					(BsjVariableElement) this.toolkit.makeElement(declaratorNode), declaratorNode);
		}
	}

	/**
	 * Populates a local variable into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param memberConstant The declaration which is being populated.
	 */
	private void tryPopulateVariableDeclarator(VariableNamespaceMap variableNamespaceMap,
			VariableDeclaratorNode declaratorNode)
	{
		variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
				(BsjVariableElement) this.toolkit.makeElement(declaratorNode), declaratorNode);
	}

	/**
	 * Attempts to populate a constructor into the provided method namespace map. This will succeed if and only if the
	 * constructor's access modifier is less restrictive or equally restrictive to the level of access provided.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the constructor.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param constructor The declaration which is being populated.
	 * @param access The maximum level of restriction this mapping can tolerate.
	 */
	private void tryPopulateMemberConstructor(MethodNamespaceMap methodNamespaceMap, Node indicator,
			ConstructorDeclarationNode constructor, AccessModifier access)
	{
		if ((constructor.getModifiers()).getAccess().compareTo(access) < 0)
		{
			methodNamespaceMap.add(NamespaceUtilities.CONSTRUCTOR_NAME,
					(BsjExecutableElement) this.toolkit.makeElement(constructor), indicator);
		}
	}

	/**
	 * Attempts to populate an annotation member method into the provided method namespace map.
	 * 
	 * @param methodNamespaceMap The namespace into which to populate the method.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberMethod The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateAnnotationMemberMethod(MethodNamespaceMap methodNamespaceMap, Node indicator,
			AnnotationMethodDeclarationNode memberMethod, String name)
	{
		if (name == null || name.equals(memberMethod.getIdentifier().getIdentifier()))
		{
			methodNamespaceMap.add(memberMethod.getIdentifier().getIdentifier(),
					(BsjExecutableElement) this.toolkit.makeElement(memberMethod), indicator);
		}
	}

	/**
	 * Populates a member constant into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberConstant The declaration which is being populated.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void tryPopulateMemberEnumConstant(VariableNamespaceMap variableNamespaceMap, Node indicator,
			EnumConstantDeclarationNode memberConstant, String name)
	{
		if ((name == null || memberConstant.getIdentifier().getIdentifier().equals(name)))
		{
			variableNamespaceMap.add(memberConstant.getIdentifier().getIdentifier(),
					(BsjVariableElement) this.toolkit.makeElement(memberConstant), memberConstant);
		}
	}

	/**
	 * Populates a type namespace map with a given package's top-level types.
	 * 
	 * @param map The map to populate.
	 * @param packageNode The package in question.
	 * @param indicator The indicator node to which each entry is to be attributed.
	 */
	private void populateNamespaceMapWithPackage(TypeNamespaceMap map, PackageNode packageNode, Node indicator)
	{
		Iterator<CompilationUnitNode> siblingIterator = packageNode.getCompilationUnitIterator();
		while (siblingIterator.hasNext())
		{
			CompilationUnitNode sibling = siblingIterator.next();
			for (TypeDeclarationNode typeDeclarationNode : sibling.getTypeDecls())
			{
				if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
				{
					NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
					ModifiersNode modifiersNode = namedTypeDeclarationNode.getModifiers();
					if (modifiersNode instanceof AccessibleTypeModifiersNode)
					{
						AccessibleTypeModifiersNode accessibleTypeModifiersNode = (AccessibleTypeModifiersNode) modifiersNode;
						if (accessibleTypeModifiersNode.getAccess() == AccessModifier.PUBLIC)
						{
							// then this sibling is a publically accessible type and is available in the namespace
							// by default
							map.add(namedTypeDeclarationNode.getIdentifier().getIdentifier(),
									(BsjTypeElement) this.toolkit.makeElement(namedTypeDeclarationNode), indicator);
						}
					}
				}
			}
		}
	}

	/**
	 * Attempts to obtain a {@link BsjTypeElement} from a {@link DeclaredTypeNode}. This operation will fail (and return
	 * <code>null</code>) if the node represents a
	 * 
	 * @param node The node to use.
	 * @return The resulting {@link BsjTypeElement}, or <code>null</code> if the conversion failed.
	 */

	/**
	 * Convenience method for creating a type namespace.
	 */
	private TypeNamespaceMap makeTypeNamespace(TypeNamespaceMap map, boolean eager, boolean prohibitsOverlap)
	{
		return new TypeNamespaceMap(map, listener, eager, prohibitsOverlap);
	}

	/**
	 * Convenience method for creating a method namespace.
	 */
	private MethodNamespaceMap makeMethodNamespace(MethodNamespaceMap map, boolean eager, boolean prohibitsOverlap)
	{
		return new MethodNamespaceMap(map, listener, eager, prohibitsOverlap);
	}

	/**
	 * Convenience method for creating a variable namespace.
	 */
	private VariableNamespaceMap makeVariableNamespace(VariableNamespaceMap map, boolean eager, boolean prohibitsOverlap)
	{
		return new VariableNamespaceMap(map, listener, eager, prohibitsOverlap);
	}

	/**
	 * Convenience method for making a new environment.
	 */
	private Environment makeEnvironment(Environment env, boolean eager, boolean prohibitsOverlap)
	{
		return new Environment(makeTypeNamespace(env.getTypeNamespaceMap(), eager, prohibitsOverlap),
				makeMethodNamespace(env.getMethodNamespaceMap(), eager, prohibitsOverlap), makeVariableNamespace(
						env.getVariableNamespaceMap(), eager, prohibitsOverlap));
	}

	/**
	 * Convenience method for making a new environment.
	 */
	private Environment makeEnvironment(Environment env, EnvType envType)
	{
		return makeEnvironment(env, envType.isEager(), envType.isProhibitsOverlap());
	}

	/**
	 * An enumeration which categorizes environments based on their usual behaviors.
	 */
	private static enum EnvType
	{
		/** The category used for environments which handle on-demand imports. */
		ON_DEMAND_IMPORT(false, false),
		/** The category used for types and members. This is used for single imports as well. */
		TYPE_OR_MEMBER(true, false),
		/** The category used for sequential statements. */
		STATEMENT(true, true);

		private boolean eager;
		private boolean prohibitsOverlap;

		private EnvType(boolean eager, boolean prohibitsOverlap)
		{
			this.eager = eager;
			this.prohibitsOverlap = prohibitsOverlap;
		}

		public boolean isEager()
		{
			return eager;
		}

		public boolean isProhibitsOverlap()
		{
			return prohibitsOverlap;
		}
	}
}
