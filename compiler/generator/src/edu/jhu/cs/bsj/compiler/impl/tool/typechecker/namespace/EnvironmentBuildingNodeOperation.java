package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
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
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.util.JavaNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

/**
 * This node operation builds {@link Environment}s for BSJ nodes. The environment which is provided as input to each
 * operation method is the environment that the node should consider to be its base. The environment which is returned
 * by each operation method is the environment which that node will be using. All returned environments are recorded in
 * a map for future reference.
 * <p/>
 * If this operation is asked to build an environment for a BSJ-specific node other than a code literal or raw code
 * literal, an {@link IllegalStateException} will result.
 * 
 * @author Zachary Palmer
 */
public class EnvironmentBuildingNodeOperation extends JavaNodeOperation<Environment, Environment>
{
	/**
	 * The node-to-environment mapping that this operation is populating. Each constructed environment is stored here.
	 */
	private Map<Node, Environment> environmentMap;
	/**
	 * The package node which acts as the root of the AST.
	 */
	private PackageNode rootPackage;
	/**
	 * The typechecker toolkit to use to create model elements.
	 */
	private TypecheckerToolkit toolkit;
	/**
	 * The diagnostic listener to which errors are reported.
	 */
	private DiagnosticListener<BsjSourceLocation> listener;

	public EnvironmentBuildingNodeOperation(Map<Node, Environment> environmentMap, PackageNode rootPackage,
			TypecheckerToolkit toolkit, DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.environmentMap = environmentMap;
		this.rootPackage = rootPackage;
		this.toolkit = toolkit;
		this.listener = diagnosticListener;
	}

	@Override
	public Environment handleBsjSpecificNode(BsjSpecificNode node, Environment p)
	{
		throw new IllegalStateException("Environments should not be built when BSJ-specific node of type "
				+ node.getClass() + " is still present.  Node string: " + node.toString());
	}

	@Override
	public Environment executeAlternateConstructorInvocationNode(AlternateConstructorInvocationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationAnnotationValueNode(AnnotationAnnotationValueNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationBodyNode(AnnotationBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationDeclarationNode(AnnotationDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationElementListNode(AnnotationElementListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationElementNode(AnnotationElementNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationListNode(AnnotationListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationMemberListNode(AnnotationMemberListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationMethodDeclarationNode(AnnotationMethodDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnnotationMethodModifiersNode(AnnotationMethodModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeAnnotationModifiersNode(AnnotationModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeAnnotationValueListNode(AnnotationValueListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnonymousClassBodyNode(AnonymousClassBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAnonymousClassMemberListNode(AnonymousClassMemberListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeArrayAccessNode(ArrayAccessNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeArrayInitializerCreationNode(ArrayInitializerCreationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeArrayInitializerNode(ArrayInitializerNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeArrayInstantiatorCreationNode(ArrayInstantiatorCreationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeArrayTypeNode(ArrayTypeNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeAssertStatementNode(AssertStatementNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAssignmentNode(AssignmentNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeBinaryExpressionNode(BinaryExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeBlockNode(BlockNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeBlockStatementListNode(BlockStatementListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeBooleanLiteralNode(BooleanLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeBreakNode(BreakNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeCaseListNode(CaseListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCaseNode(CaseNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCatchListNode(CatchListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCatchNode(CatchNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCharLiteralNode(CharLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeClassBodyNode(ClassBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeClassDeclarationNode(ClassDeclarationNode node, Environment p)
	{
		NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap = p.getTypeNamespaceMap();

		// Step 1: Populate member types
		// TODO: insert appropriate diagnostic factory
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		populateTypes(typeNamespaceMap, node.getBody().getMembers());

		// TODO: finish

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeClassLiteralNode(ClassLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeClassMemberListNode(ClassMemberListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeClassModifiersNode(ClassModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeCodeLiteralNode(CodeLiteralNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeCompilationUnitNode(CompilationUnitNode node, Environment p)
	{
		// Create variables for the symbol table
		NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap = makeTypeNamespace(null, false);
		NamespaceMap<ExecutableElement> methodNamespaceMap = makeMethodNamespace(null, false);
		NamespaceMap<VariableElement> variableNamespaceMap = makeVariableNamespace(null, false);
		Environment emptyEnvironment = new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);

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
		populateSingleTypeStaticImports(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getImports());

		// *** Process top-level type declarations. The addition of the public top-level type declaration will, of
		// course, be redundant (because it was obtained in from package peers above). The same typespace map is used,
		// since a top-level
		// type named N in the same compilation unit and a single-static import of a type named N will conflict.
		populateTypes(typeNamespaceMap, node.getTypeDecls());

		// *** Store this environment
		Environment environment = new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
		recordEnvironment(node, environment);

		// *** Build the environments for each of the children
		node.getPackageDeclaration().executeOperation(this, emptyEnvironment);
		node.getImports().executeOperation(this, emptyEnvironment);
		node.getTypeDecls().executeOperation(this, environment);

		// Finished!
		return null;
	}

	@Override
	public Environment executeConditionalExpressionNode(ConditionalExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeConstantDeclarationNode(ConstantDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeConstantModifiersNode(ConstantModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeConstructorBodyNode(ConstructorBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeConstructorDeclarationNode(ConstructorDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeConstructorModifiersNode(ConstructorModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeContinueNode(ContinueNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeDeclaredTypeListNode(DeclaredTypeListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeDoubleLiteralNode(DoubleLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeDoWhileLoopNode(DoWhileLoopNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnhancedForLoopNode(EnhancedForLoopNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumBodyNode(EnumBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumConstantDeclarationListNode(EnumConstantDeclarationListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumConstantModifiersNode(EnumConstantModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeEnumDeclarationNode(EnumDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeEnumModifiersNode(EnumModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeExpressionListNode(ExpressionListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeExpressionStatementNode(ExpressionStatementNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeFieldDeclarationNode(FieldDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeFieldModifiersNode(FieldModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeFloatLiteralNode(FloatLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeForInitializerDeclarationNode(ForInitializerDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeForInitializerExpressionNode(ForInitializerExpressionNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeForLoopNode(ForLoopNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeIdentifierListNode(IdentifierListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeIdentifierNode(IdentifierNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeIfNode(IfNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeImportListNode(ImportListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeImportOnDemandNode(ImportOnDemandNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeImportSingleTypeNode(ImportSingleTypeNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeInitializerDeclarationNode(InitializerDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInstanceOfNode(InstanceOfNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeInterfaceBodyNode(InterfaceBodyNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceDeclarationNode(InterfaceDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceMemberListNode(InterfaceMemberListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeInterfaceModifiersNode(InterfaceModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeIntLiteralNode(IntLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeJavadocNode(JavadocNode node, Environment p)
	{
		return p;
	}

	@Override
	public Environment executeLabeledStatementNode(LabeledStatementNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeLocalClassDeclarationNode(LocalClassDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeLocalClassModifiersNode(LocalClassModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeLocalVariableDeclarationNode(LocalVariableDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeLongLiteralNode(LongLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeMethodDeclarationNode(MethodDeclarationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeMethodInvocationByExpressionNode(MethodInvocationByExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeMethodInvocationByNameNode(MethodInvocationByNameNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeMethodModifiersNode(MethodModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeNoOperationNode(NoOperationNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeNormalAnnotationNode(NormalAnnotationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeNullLiteralNode(NullLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executePackageDeclarationNode(PackageDeclarationNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executePackageNode(PackageNode node, Environment p)
	{
		return p;
	}

	@Override
	public Environment executeParameterizedTypeNode(ParameterizedTypeNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeParenthesizedExpressionNode(ParenthesizedExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executePrimitiveTypeNode(PrimitiveTypeNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeQualifiedClassInstantiationNode(QualifiedClassInstantiationNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeQualifiedNameNode(QualifiedNameNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeRawCodeLiteralNode(RawCodeLiteralNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeReferenceTypeListNode(ReferenceTypeListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeReturnNode(ReturnNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeSimpleNameNode(SimpleNameNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeSingleElementAnnotationNode(SingleElementAnnotationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSingleStaticImportNode(SingleStaticImportNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeStatementExpressionListNode(StatementExpressionListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeStaticImportOnDemandNode(StaticImportOnDemandNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeStringLiteralNode(StringLiteralNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeSuperclassConstructorInvocationNode(SuperclassConstructorInvocationNode node,
			Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSuperFieldAccessNode(SuperFieldAccessNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSuperMethodInvocationNode(SuperMethodInvocationNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSwitchNode(SwitchNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeSynchronizedNode(SynchronizedNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeThisNode(ThisNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeThrowNode(ThrowNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTryNode(TryNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTypeArgumentListNode(TypeArgumentListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTypeCastNode(TypeCastNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeTypeDeclarationListNode(TypeDeclarationListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTypeParameterListNode(TypeParameterListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeTypeParameterNode(TypeParameterNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeUnaryExpressionNode(UnaryExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeUnaryStatementExpressionNode(UnaryStatementExpressionNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeUnqualifiedClassInstantiationNode(UnqualifiedClassInstantiationNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeVariableAccessByExpressionNode(VariableAccessByExpressionNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableAccessByNameNode(VariableAccessByNameNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableDeclaratorListNode(VariableDeclaratorListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableDeclaratorNode(VariableDeclaratorNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableInitializerListNode(VariableInitializerListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableListNode(VariableListNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVariableModifiersNode(VariableModifiersNode node, Environment p)
	{
		return handleModifiersNode(node, p);
	}

	@Override
	public Environment executeVariableNode(VariableNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeVoidTypeNode(VoidTypeNode node, Environment p)
	{
		return recordEnvironment(node, p);
	}

	@Override
	public Environment executeWhileLoopNode(WhileLoopNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment executeWildcardTypeNode(WildcardTypeNode node, Environment p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	// *** UTILITY METHODS BEGIN HERE ****************************************

	/**
	 * Records an environment for a specific node.
	 * 
	 * @param node The node in question.
	 * @param environment The new environment.
	 * @return The same environment.
	 */
	private Environment recordEnvironment(Node node, Environment environment)
	{
		return this.recordEnvironment(node, null, environment);
	}

	/**
	 * Records an environment for a specific node. If the environment is replacable by its base environment, the base
	 * environment is used instead (to conserve memory).
	 * 
	 * @param node The node in question.
	 * @param base The base environment from which the node's environment was constructed. If <code>null</code>, the new
	 *            environment is always used.
	 * @param environment The new environment.
	 * @return The environment which was used.
	 */
	private Environment recordEnvironment(Node node, Environment base, Environment environment)
	{
		Environment result;
		if (base == null)
		{
			result = environment;
		} else
		{
			result = new Environment(
					(environment.getTypeNamespaceMap().definitelyReplacableBy(base.getTypeNamespaceMap()) ? base
							: environment).getTypeNamespaceMap(),
					(environment.getMethodNamespaceMap().definitelyReplacableBy(base.getMethodNamespaceMap()) ? base
							: environment).getMethodNamespaceMap(),
					(environment.getVariableNamespaceMap().definitelyReplacableBy(base.getVariableNamespaceMap()) ? base
							: environment).getVariableNamespaceMap());
		}
		this.environmentMap.put(node, result);
		return result;
	}

	private void populateOnDemandImports(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportOnDemandNode)
			{
				switch (importNode.getName().getCategory())
				{
					case PACKAGE:
						PackageNode packageNode = rootPackage.getSubpackageByQualifiedName(importNode.getName());
						populateNamespaceMapWithPackage(typeNamespaceMap, packageNode, importNode);
						break;
					case TYPE:
						NamedTypeDeclarationNode<?> type = getAccessibleTypeFromCanonicalName(importNode.getName());
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
											(NamedTypeDeclarationNode<?>) node);
								}
							}
						}
						break;
					default:
						// In this case, the name categorizer messed up
						throw new IllegalStateException(
								"Name categorizer gave non-package, non-type category to import name: "
										+ importNode.getName().getNameString() + " has category "
										+ importNode.getName().getCategory());
				}
			}
		}
	}

	private void tryPopulateMemberType(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap, Node indicator,
			NamedTypeDeclarationNode<?> memberType)
	{
		if (memberType.getModifiers() instanceof AccessibleTypeModifiersNode
				&& ((AccessibleTypeModifiersNode) memberType.getModifiers()).getAccess() == AccessModifier.PUBLIC)
		{
			typeNamespaceMap.add(memberType.getIdentifier().getIdentifier(),
					(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(memberType), indicator);
		}
	}

	private void tryPopulateMemberMethod(NamespaceMap<ExecutableElement> methodNamespaceMap, Node indicator,
			MethodDeclarationNode memberMethod)
	{
		if (memberMethod.getModifiers().getAccess() == AccessModifier.PUBLIC)
		{
			methodNamespaceMap.add(memberMethod.getIdentifier().getIdentifier(),
					(ExecutableElement) this.toolkit.makeElement(memberMethod), indicator);
		}
	}

	private void tryPopulateMemberField(NamespaceMap<VariableElement> variableNamespaceMap, Node indicator,
			FieldDeclarationNode memberField)
	{
		if (memberField.getModifiers().getAccess() == AccessModifier.PUBLIC)
		{
			for (VariableDeclaratorNode declaratorNode : memberField.getDeclarators())
			{
				variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
						(VariableElement) this.toolkit.makeElement(memberField), declaratorNode);
			}
		}
	}

	private void populateOnDemandStaticImports(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap,
			Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof StaticImportOnDemandNode)
			{
				if (importNode.getName().getCategory() != NameCategory.TYPE)
				{
					// On-demand static imports can only name types.
					// TODO: report an appropriate diagnostic
					throw new NotImplementedYetException();
				}

				// For each member of the type, import it if possible
				NamedTypeDeclarationNode<?> type = getAccessibleTypeFromCanonicalName(importNode.getName());
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
							tryPopulateMemberType(typeNamespaceMap, importNode, (NamedTypeDeclarationNode<?>) node);
						} else if (node instanceof FieldDeclarationNode)
						{
							tryPopulateMemberField(variableNamespaceMap, importNode, (FieldDeclarationNode) node);
						} else if (node instanceof MethodDeclarationNode)
						{
							tryPopulateMemberMethod(methodNamespaceMap, importNode, (MethodDeclarationNode) node);
						}
					}
				}
			}
		}
	}

	private void populateSingleTypeImports(NamespaceMap<DeclaredTypeElementImpl<?>> map, Iterable<ImportNode> imports)
	{
		for (ImportNode importNode : imports)
		{
			if (importNode instanceof ImportSingleTypeNode)
			{
				NamedTypeDeclarationNode<?> type = getAccessibleTypeFromCanonicalName(importNode.getName());
				if (type == null)
				{
					// TODO: raise some kind of appropriate diagnostic
					throw new NotImplementedYetException();
				} else
				{
					map.add(type.getIdentifier().getIdentifier(),
							(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(type), importNode);
				}
			}
		}
	}

	private void populateSingleTypeStaticImports(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap,
			Iterable<ImportNode> imports)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Obtains a named type declaration from the specified canonical name. The type declaration must be accessible from
	 * the name in question. For instance, if the type declaration has private access, the name must be in a subtree of
	 * the enclosing type inside of which the named type is declared.
	 * 
	 * @param name The name of the type declaration to locate.
	 * @return The resulting type declaration, or <code>null</code> if no such accessible type declaration exists.
	 */
	private NamedTypeDeclarationNode<?> getAccessibleTypeFromCanonicalName(NameNode name)
	{
		// Get the name of the package.
		List<String> typeNames = new ArrayList<String>();
		while (name != null && name.getCategory() != NameCategory.PACKAGE)
		{
			if (name.getCategory() != NameCategory.TYPE)
			{
				throw new IllegalStateException("Name categorizer gave non-package, non-type category to import name: "
						+ name.getNameString() + " has category " + name.getCategory());
			}
			typeNames.add(name.getIdentifier().getIdentifier());
			if (name instanceof SimpleNameNode)
			{
				name = null;
			} else
			{
				name = ((QualifiedNameNode) name).getBase();
			}
		}

		if (typeNames.size() == 0)
		{
			// We were provided with a package name, not a type name
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}

		// Ascertain the package in which the imported type lives
		PackageNode packageNode;
		if (name == null)
		{
			packageNode = this.rootPackage;
		} else
		{
			packageNode = this.rootPackage.getSubpackageByQualifiedName(name);
		}

		// Obtain the type from the package
		NamedTypeDeclarationNode<?> type = packageNode.getTopLevelTypeDeclaration(typeNames.get(0));
		if (type == null)
		{
			// The type does not exist
			// TODO: raise an appropriate diagnostic
			throw new NotImplementedYetException();
		}
		for (int index = 1; index < typeNames.size(); index++)
		{
			type = type.getTypeDeclaration(typeNames.get(index));
			if (type == null)
			{
				// The type does not exist
				// TODO: raise an appropriate diagnostic
				throw new NotImplementedYetException();
			}
		}

		// TODO: verify that the requested type is accessible from the provided NameNode

		return type;
	}

	/**
	 * Populates a type namespace map with a given package's top-level types.
	 * 
	 * @param map The map to populate.
	 * @param packageNode The package in question.
	 * @param indicator The indicator node to which each entry is to be attributed.
	 */
	private void populateNamespaceMapWithPackage(NamespaceMap<DeclaredTypeElementImpl<?>> map, PackageNode packageNode,
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
									(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(namedTypeDeclarationNode),
									indicator);
						}
					}
				}
			}
		}
	}

	/**
	 * Populates the types contained in a list of nodes into a type namespace map as immediately-accessible members.
	 * 
	 * @param typeNamespaceMap
	 * @param nodes
	 */
	private void populateTypes(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap, Iterable<? extends Node> nodes)
	{
		for (Node node : nodes)
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> type = (NamedTypeDeclarationNode<?>) node;
				typeNamespaceMap.add(type.getIdentifier().getIdentifier(),
						(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(type), type);
			}
		}
	}

	/**
	 * Processes a node which does not perform any namespace assignments and for which the children of the node are
	 * typespace-independent. A binary expression, for instance, could be processed by this method. While the contents
	 * of the binary expression may have implications on their own scope, no legal Java AST would allow an expression to
	 * declare a new language element. Furthermore, the two children of the binary expression are independent; the
	 * scoping implications in one subexpression (such as by declaration of an anonymous class) do not affect the scope
	 * of the other subexpression.
	 * 
	 * @param node The node in question.
	 * @param environment The environment to record for the node and to pass to its children.
	 * @return The same environment.
	 */
	private Environment handleNondefiningNode(Node node, Environment environment)
	{
		recordEnvironment(node, environment);
		for (Node child : node.getChildIterable())
		{
			if (child != null)
			{
				child.executeOperation(this, environment);
			}
		}
		return environment;
	}

	private Environment handleModifiersNode(ModifiersNode node, Environment environment)
	{
		return handleNondefiningNode(node, environment);
	}

	/**
	 * Convenience method for creating a type namespace.
	 */
	private NamespaceMap<DeclaredTypeElementImpl<?>> makeTypeNamespace(NamespaceMap<DeclaredTypeElementImpl<?>> map,
			boolean eager)
	{
		return NamespaceMap.makeType(map, this.listener, eager);
	}

	/**
	 * Convenience method for creating a method namespace.
	 */
	private NamespaceMap<ExecutableElement> makeMethodNamespace(NamespaceMap<ExecutableElement> map, boolean eager)
	{
		return NamespaceMap.makeMethod(map, this.listener, eager);
	}

	/**
	 * Convenience method for creating a variable namespace.
	 */
	private NamespaceMap<VariableElement> makeVariableNamespace(NamespaceMap<VariableElement> map, boolean eager)
	{
		return NamespaceMap.makeVariable(map, this.listener, eager);
	}
}
