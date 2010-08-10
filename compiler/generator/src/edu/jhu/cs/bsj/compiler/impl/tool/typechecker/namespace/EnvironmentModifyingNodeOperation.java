package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Iterator;

import javax.lang.model.type.DeclaredType;
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
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
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
		// TODO Auto-generated method stub
		return null;
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
		// *** Declare variables for symbol table
		TypeNamespaceMap typeNamespaceMap = env.getTypeNamespaceMap();
		MethodNamespaceMap methodNamespaceMap = env.getMethodNamespaceMap();
		VariableNamespaceMap variableNamespaceMap = env.getVariableNamespaceMap();

		// *** Create a new scope for inherited member elements
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);

		// *** Populate elements inherited from java.lang.annotation.Annotation
		populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				(DeclaredType) this.toolkit.getElementByName("java", "lang", "annotation", "Annotation").asType());

		// *** Create a new scope for declared member elements
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);

		// *** Populate member elements
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getMembers(),
				AccessModifier.PRIVATE);

		// *** Finished!
		return new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeBlockStatementListNode(BlockStatementListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeBlockStatementMetaprogramAnchorNode(BlockStatementMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCaseNode(CaseNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCatchListNode(CatchListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCatchNode(CatchNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCharLiteralNode(CharLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeClassBodyNode(ClassBodyNode node, Environment env, Node child)
	{
		TypeNamespaceMap typeNamespaceMap = env.getTypeNamespaceMap();
		MethodNamespaceMap methodNamespaceMap = env.getMethodNamespaceMap();
		VariableNamespaceMap variableNamespaceMap = env.getVariableNamespaceMap();

		// *** Create a new scope for inherited member elements
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);

		// *** Inherit member elements
		ClassDeclarationNode classDeclarationNode = (ClassDeclarationNode) node.getParent();
		populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				classDeclarationNode.getExtendsClause());
		for (DeclaredTypeNode implementsType : classDeclarationNode.getImplementsClause())
		{
			populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, implementsType);
		}

		// *** Create a new scope for declared member elements
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);

		// *** Populate member elements
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getMembers(),
				AccessModifier.PRIVATE);

		// *** Finished!
		return new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
	}

	@Override
	public Environment executeClassDeclarationNode(ClassDeclarationNode node, Environment env, Node child)
	{
		// *** Declare variables for symbol table
		TypeNamespaceMap typeNamespaceMap = env.getTypeNamespaceMap();
		MethodNamespaceMap methodNamespaceMap = env.getMethodNamespaceMap();
		VariableNamespaceMap variableNamespaceMap = env.getVariableNamespaceMap();

		// *** Create a new scope for type parameters
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);

		// *** Populate type parameters (which are in scope of the entire declaration)
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		for (TypeParameterNode typeParameterNode : node.getTypeParameters())
		{
			// TODO: This should be a BsjTypeParameterElement.  Is it okay to store type parameters and types in the
			// same namespace map?
			typeNamespaceMap.add(typeParameterNode.getIdentifier().getIdentifier(),
					(BsjTypeLikeElement) this.toolkit.makeElement(typeParameterNode), typeParameterNode);
		}

		// *** Finished!
		return new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
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

		// *** Create variables for the symbol table
		TypeNamespaceMap typeNamespaceMap = env.getTypeNamespaceMap();
		MethodNamespaceMap methodNamespaceMap = env.getMethodNamespaceMap();
		VariableNamespaceMap variableNamespaceMap = env.getVariableNamespaceMap();
		
		// *** Create a new scope for the on-demand imports
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, false);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, false);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, false);

		// *** Process on-demand imports. This namespace has a lazy error policy, as ambiguities in on-demand
		// imports (such as "import java.util.*; import java.awt.*;" only matter if the ambiguous name is used
		// (such as in "List").
		populateOnDemandImports(typeNamespaceMap, node.getImports());

		// *** Process on-demand static imports.
		populateOnDemandStaticImports(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getImports());

		// *** Process top-level package peers. This namespace has an eager error policy as any duplication means
		// a name conflict in the local package.
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		populateNamespaceMapWithPackage(typeNamespaceMap, (PackageNode) node.getParent(), node.getPackageDeclaration());

		// *** Process single-type imports. This namespace has a eager error policy, as ambiguities in single-type
		// imports cause the import statements to be useless in any context (such as
		// "import java.util.List; import java.awt.List;").
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		populateSingleTypeImports(typeNamespaceMap, node.getImports());

		// *** Process single-type static imports.
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);
		populateSingleStaticImports(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getImports());

		// *** Process top-level type declarations. The addition of the public top-level type declaration will, of
		// course, be redundant (because it was obtained in from package peers above). The same typespace map is used,
		// since a top-level type named N in the same compilation unit and a single-static import of a type named N will
		// conflict.
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getTypeDecls(),
				AccessModifier.PUBLIC);

		// *** Finished!
		return new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
	}

	@Override
	public Environment executeConditionalExpressionNode(ConditionalExpressionNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstantDeclarationNode(ConstantDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeConstantModifiersNode(ConstantModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeConstructorBodyNode(ConstructorBodyNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeConstructorDeclarationNode(ConstructorDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeDoWhileLoopNode(DoWhileLoopNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeDoubleLiteralNode(DoubleLiteralNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnhancedForLoopNode(EnhancedForLoopNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumBodyNode(EnumBodyNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, Environment env,
			Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumConstantModifiersNode(EnumConstantModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeEnumDeclarationNode(EnumDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeFieldDeclarationNode(FieldDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeForInitializerExpressionNode(ForInitializerExpressionNode node, Environment env,
			Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeForLoopNode(ForLoopNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceMemberListNode(InterfaceMemberListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceMemberMetaprogramAnchorNode(InterfaceMemberMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationElementListNode(MetaAnnotationElementListNode node, Environment env,
			Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationElementNode(MetaAnnotationElementNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationExpressionValueNode(MetaAnnotationExpressionValueNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationListNode(MetaAnnotationListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationMetaAnnotationValueNode(MetaAnnotationMetaAnnotationValueNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationMetaprogramAnchorNode(MetaAnnotationMetaprogramAnchorNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramDependencyDeclarationListNode(MetaprogramDependencyDeclarationListNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramDependencyDeclarationNode(MetaprogramDependencyDeclarationNode node,
			Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramDependencyListNode(MetaprogramDependencyListNode node, Environment env,
			Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramDependencyNode(MetaprogramDependencyNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramImportListNode(MetaprogramImportListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramImportNode(MetaprogramImportNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramNode(MetaprogramNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramPreambleNode(MetaprogramPreambleNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramTargetListNode(MetaprogramTargetListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMetaprogramTargetNode(MetaprogramTargetNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMethodDeclarationNode(MethodDeclarationNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSingleStaticImportNode(SingleStaticImportNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeStatementExpressionListNode(StatementExpressionListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSwitchNode(SwitchNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSynchronizedNode(SynchronizedNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeThisNode(ThisNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeThrowNode(ThrowNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTryNode(TryNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTypeArgumentListNode(TypeArgumentListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableDeclaratorNode(VariableDeclaratorNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableInitializerListNode(VariableInitializerListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableListNode(VariableListNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableModifiersNode(VariableModifiersNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeVariableNode(VariableNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVoidTypeNode(VoidTypeNode node, Environment env, Node child)
	{
		return env;
	}

	@Override
	public Environment executeWhileLoopNode(WhileLoopNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeWildcardTypeNode(WildcardTypeNode node, Environment env, Node child)
	{
		// TODO Auto-generated method stub
		return null;
	}

	// ***** BEGIN UTILITY METHODS *******************************************

	private void populateOnDemandImports(TypeNamespaceMap typeNamespaceMap,
			Iterable<ImportNode> imports)
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
							// TODO: emit an appropriate diagnostic
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

	private void populateOnDemandStaticImports(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			Iterable<ImportNode> imports)
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
					populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
							type.getBody().getMembers(), AccessModifier.PUBLIC);
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
					map.add(type.getIdentifier().getIdentifier(),
							(BsjTypeElement) this.toolkit.makeElement(type), importNode);
				}
			}
		}
	}

	private void populateSingleStaticImports(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			Iterable<ImportNode> imports)
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
					populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
							type.getBody().getMembers(), AccessModifier.PUBLIC, false,
							singleStaticImportNode.getIdentifier().getIdentifier());
				}
			}
		}
	}

	/**
	 * Populates the elements represented by a list of nodes into a set of namespace maps as immediately-accessible
	 * members.
	 * 
	 * @param typeNamespaceMap The type namespace into which to populate.
	 * @param methodNamespaceMap The method namespace into which to populate.
	 * @param variableNamespaceMap The variable namespace into which to populate.
	 * @param nodes The list of nodes from which to extract the elements to populate.
	 * @param access The level of access to use during population.
	 */
	private void populateElements(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			Iterable<? extends Node> nodes, AccessModifier access)
	{
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, nodes, access, false, null);
	}

	/**
	 * Populates the elements represented by a list of nodes into a set of namespace maps as immediately-accessible
	 * members.
	 * 
	 * @param typeNamespaceMap The type namespace into which to populate.
	 * @param methodNamespaceMap The method namespace into which to populate.
	 * @param variableNamespaceMap The variable namespace into which to populate.
	 * @param nodes The list of nodes from which to extract the elements to populate.
	 * @param access The level of access to use during population.
	 * @param skipNonMembers <code>true</code> if non-members such as constructors should be skipped; <code>false</code>
	 *            otherwise.
	 * @param name The name the member must have in order to be included or <code>null</code> to accept any name.
	 */
	private void populateElements(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			Iterable<? extends Node> nodes, AccessModifier access, boolean skipNonMembers, String name)
	{
		for (Node node : nodes)
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				tryPopulateMemberType(typeNamespaceMap, node, (NamedTypeDeclarationNode<?>) node, access, name);
			} else if (node instanceof AbstractMemberVariableDeclarationNode<?>)
			{
				tryPopulateMemberField(variableNamespaceMap, node, (FieldDeclarationNode) node, access, name);
			} else if (node instanceof ConstantDeclarationNode)
			{
				tryPopulateMemberConstant(variableNamespaceMap, node, (ConstantDeclarationNode) node, name);
			} else if (node instanceof MethodDeclarationNode)
			{
				tryPopulateMemberMethod(methodNamespaceMap, node, (MethodDeclarationNode) node, access, name);
			} else if (node instanceof AnnotationMethodDeclarationNode)
			{
				tryPopulateAnnotationMemberMethod(methodNamespaceMap, node, (AnnotationMethodDeclarationNode) node,
						name);
			} else if (!skipNonMembers)
			{
				if (node instanceof ConstructorDeclarationNode && name == null)
				{
					tryPopulateMemberConstructor(methodNamespaceMap, node, (ConstructorDeclarationNode) node, access);
				}
			}
		}
	}

	/**
	 * Populates the elements inherited from a given type. This method will populate into the provided namespaces those
	 * elements which are inheritable; constructors, for instance, will not be included.
	 * 
	 * @param typeNamespaceMap The type namespace into which to populate.
	 * @param methodNamespaceMap The method namespace into which to populate.
	 * @param variableNamespaceMap The variable namespace into which to populate.
	 * @param typeNode The type from which elements are being inherited.
	 */
	private void populateInheritedElements(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			DeclaredTypeNode typeNode)
	{
		if (typeNode == null)
			return;
		populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				(DeclaredType) this.toolkit.makeType(typeNode));
	}

	/**
	 * Populates the elements inherited from a given type. This method will populate into the provided namespaces those
	 * elements which are inheritable; constructors, for instance, will not be included.
	 * 
	 * @param typeNamespaceMap The type namespace into which to populate.
	 * @param methodNamespaceMap The method namespace into which to populate.
	 * @param variableNamespaceMap The variable namespace into which to populate.
	 * @param type The type from which elements are being inherited.
	 */
	private void populateInheritedElements(TypeNamespaceMap typeNamespaceMap,
			MethodNamespaceMap methodNamespaceMap, VariableNamespaceMap variableNamespaceMap,
			DeclaredType type)
	{
		// TODO: detect cycles to prevent stack overflow

		// TODO: figure out whether we have PACKAGE or PROTECTED access
		AccessModifier access = AccessModifier.PROTECTED;

		// Locate the actual element representing the indicated type.
		BsjTypeElement element = (BsjTypeElement) type.asElement();

		// Populate its non-constructor elements
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				((NamedTypeDeclarationNode<?>)element.getDeclarationNode()).getBody().getMembers(), access, true, null);
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
		if (((AccessibleTypeModifiersNode) memberMethod.getModifiers()).getAccess().compareTo(access) < 0
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
		if (((AccessibleTypeModifiersNode) memberField.getModifiers()).getAccess().compareTo(access) < 0)
		{
			for (VariableDeclaratorNode declaratorNode : memberField.getDeclarators())
			{
				if (name == null || declaratorNode.getName().getIdentifier().equals(name))
				{
					variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
							(BsjVariableElement) this.toolkit.makeElement(memberField), declaratorNode);
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
		if (((AccessibleTypeModifiersNode) constructor.getModifiers()).getAccess().compareTo(access) < 0)
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
					(BsjExecutableElement)this.toolkit.makeElement(memberMethod), indicator);
		}
	}


	/**
	 * Populates a type namespace map with a given package's top-level types.
	 * 
	 * @param map The map to populate.
	 * @param packageNode The package in question.
	 * @param indicator The indicator node to which each entry is to be attributed.
	 */
	private void populateNamespaceMapWithPackage(TypeNamespaceMap map, PackageNode packageNode,
			Node indicator)
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
									(BsjTypeElement) this.toolkit.makeElement(namedTypeDeclarationNode),
									indicator);
						}
					}
				}
			}
		}
	}

	/**
	 * Convenience method for creating a type namespace.
	 */
	private TypeNamespaceMap makeTypeNamespace(TypeNamespaceMap map,
			boolean eager)
	{
		return new TypeNamespaceMap(map, listener, eager);
	}

	/**
	 * Convenience method for creating a method namespace.
	 */
	private MethodNamespaceMap makeMethodNamespace(MethodNamespaceMap map, boolean eager)
	{
		return new MethodNamespaceMap(map, listener, eager);
	}

	/**
	 * Convenience method for creating a variable namespace.
	 */
	private VariableNamespaceMap makeVariableNamespace(VariableNamespaceMap map, boolean eager)
	{
		return new VariableNamespaceMap(map, listener, eager);
	}
}
