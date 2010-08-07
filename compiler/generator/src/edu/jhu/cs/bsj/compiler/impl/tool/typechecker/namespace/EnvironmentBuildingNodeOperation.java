package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.Iterator;
import java.util.Map;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
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

// TODO: method environment stuff is broken; it doesn't allow for overloading

/**
 * This node operation builds {@link Environment}s for BSJ nodes. The environment which is provided as input to each
 * operation method is the environment that the node should consider to be its base. The environment which is returned
 * by each operation method is the environment which that node will be using. All returned environments are recorded in
 * a map for future reference.
 * <p/>
 * If this operation is asked to build an environment for a BSJ-specific node other than a code literal or raw code
 * literal, an {@link IllegalStateException} will result.
 * <p/>
 * The mapping which stores the environments maps each node to the environment that its descendents should use if they
 * have no further additions to the symbol table. A {@link CompilationUnitNode}, for instance, will be mapped to the
 * environment that it prescribes for its declared types. In this way, for instance, a type declaration node is mapped
 * to the symbol table available to its callers. That is, if a type <tt>Foo</tt> has a field named <tt>bar</tt>, then
 * the environment mapped by the name <tt>Foo</tt> will contain a variable symbol table entry for <tt>bar</tt>; this
 * simplifies processing of qualified names such as <tt>Foo.bar</tt>.
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
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationArrayValueNode(AnnotationArrayValueNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationElementNode(AnnotationElementNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationExpressionValueNode(AnnotationExpressionValueNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationListNode(AnnotationListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationModifiersNode(AnnotationModifiersNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeAnnotationValueListNode(AnnotationValueListNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap = p.getTypeNamespaceMap();
		NamespaceMap<ExecutableElement> methodNamespaceMap = p.getMethodNamespaceMap();
		NamespaceMap<VariableElement> variableNamespaceMap = p.getVariableNamespaceMap();

		// *** Populate member elements
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		methodNamespaceMap = makeMethodNamespace(methodNamespaceMap, true);
		variableNamespaceMap = makeVariableNamespace(variableNamespaceMap, true);
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getMembers(),
				AccessModifier.PRIVATE);

		// *** Inherit member elements
		ClassDeclarationNode classDeclarationNode = (ClassDeclarationNode) node.getParent();
		populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				classDeclarationNode.getExtendsClause());
		for (DeclaredTypeNode implementsType : classDeclarationNode.getImplementsClause())
		{
			populateInheritedElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, implementsType);
		}

		// *** Store the resulting environment
		Environment environment = new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
		recordEnvironment(node, p, environment);

		// *** Deal with children
		for (Node child : node.getChildIterable())
		{
			child.executeOperation(this, environment);
		}

		// *** Finished!
		return environment;
	}

	@Override
	public Environment executeClassDeclarationNode(ClassDeclarationNode node, Environment p)
	{
		NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap = p.getTypeNamespaceMap();
		NamespaceMap<ExecutableElement> methodNamespaceMap = p.getMethodNamespaceMap();
		NamespaceMap<VariableElement> variableNamespaceMap = p.getVariableNamespaceMap();

		// *** Populate type parameters (which are in scope of the entire declaration)
		typeNamespaceMap = makeTypeNamespace(typeNamespaceMap, true);
		for (TypeParameterNode typeParameterNode : node.getTypeParameters())
		{
			typeNamespaceMap.add(typeParameterNode.getIdentifier().getIdentifier(),
					(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(typeParameterNode), typeParameterNode);
		}

		// *** Store the resulting environment
		Environment environment = new Environment(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap);
		recordEnvironment(node, p, environment);

		// *** Deal with children
		for (Node child : node.getChildIterable())
		{
			child.executeOperation(this, environment);
		}

		// *** Finished!
		return environment;
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
		return handleNondefiningNode(node, p);
	}

	@Override
	public Environment executeCodeLiteralNode(CodeLiteralNode node, Environment p)
	{
		return handleNondefiningNode(node, p);
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
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, node.getTypeDecls(),
				AccessModifier.PUBLIC);

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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
		return handleNondefiningNode(node, p);
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
											(NamedTypeDeclarationNode<?>) node, AccessModifier.PUBLIC);
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

	private void populateSingleTypeImports(NamespaceMap<DeclaredTypeElementImpl<?>> map, Iterable<ImportNode> imports)
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
	 * Populates the elements represented by a list of nodes into a set of namespace maps as immediately-accessible
	 * members.
	 * 
	 * @param typeNamespaceMap The type namespace into which to populate.
	 * @param methodNamespaceMap The method namespace into which to populate.
	 * @param variableNamespaceMap The variable namespace into which to populate.
	 * @param nodes The list of nodes from which to extract the elements to populate.
	 * @param access The level of access to use during population.
	 */
	private void populateElements(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap,
			Iterable<? extends Node> nodes, AccessModifier access)
	{
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap, nodes, access, false);
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
	 */
	private void populateElements(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap,
			Iterable<? extends Node> nodes, AccessModifier access, boolean skipNonMembers)
	{
		for (Node node : nodes)
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				tryPopulateMemberType(typeNamespaceMap, node, (NamedTypeDeclarationNode<?>) node, access);
			} else if (node instanceof AbstractMemberVariableDeclarationNode<?>)
			{
				tryPopulateMemberField(variableNamespaceMap, node, (FieldDeclarationNode) node, access);
			} else if (node instanceof MethodDeclarationNode)
			{
				tryPopulateMemberMethod(methodNamespaceMap, node, (MethodDeclarationNode) node, access);
			} else if (node instanceof ConstantDeclarationNode)
			{
				tryPopulateMemberConstant(variableNamespaceMap, node, (ConstantDeclarationNode) node);
			} else if (node instanceof ConstructorDeclarationNode && !skipNonMembers)
			{
				tryPopulateMemberConstructor(methodNamespaceMap, node, (ConstructorDeclarationNode) node, access);
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
	private void populateInheritedElements(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap,
			NamespaceMap<ExecutableElement> methodNamespaceMap, NamespaceMap<VariableElement> variableNamespaceMap,
			DeclaredTypeNode typeNode)
	{
		// TODO: detect cycles to prevent stack overflow
		
		// TODO: figure out whether we have PACKAGE or PROTECTED access
		AccessModifier access = AccessModifier.PROTECTED;

		// Locate the actual element representing the indicated type.
		DeclaredType type = (DeclaredType) this.toolkit.makeType(typeNode);
		DeclaredTypeElementImpl<?> element = (DeclaredTypeElementImpl<?>) type.asElement();

		// Populate its non-constructor elements
		populateElements(typeNamespaceMap, methodNamespaceMap, variableNamespaceMap,
				element.getBackingNode().getBody().getMembers(), access, true);
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
	 */
	private void tryPopulateMemberType(NamespaceMap<DeclaredTypeElementImpl<?>> typeNamespaceMap, Node indicator,
			NamedTypeDeclarationNode<?> memberType, AccessModifier access)
	{
		if (memberType.getModifiers() instanceof AccessibleTypeModifiersNode
				&& ((AccessibleTypeModifiersNode) memberType.getModifiers()).getAccess().compareTo(access) < 0)
		{
			typeNamespaceMap.add(memberType.getIdentifier().getIdentifier(),
					(DeclaredTypeElementImpl<?>) this.toolkit.makeElement(memberType), indicator);
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
	 */
	private void tryPopulateMemberMethod(NamespaceMap<ExecutableElement> methodNamespaceMap, Node indicator,
			MethodDeclarationNode memberMethod, AccessModifier access)
	{
		if (((AccessibleTypeModifiersNode) memberMethod.getModifiers()).getAccess().compareTo(access) < 0)
		{
			methodNamespaceMap.add(memberMethod.getIdentifier().getIdentifier(),
					(ExecutableElement) this.toolkit.makeElement(memberMethod), indicator);
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
	 */
	private void tryPopulateMemberField(NamespaceMap<VariableElement> variableNamespaceMap, Node indicator,
			FieldDeclarationNode memberField, AccessModifier access)
	{
		if (((AccessibleTypeModifiersNode) memberField.getModifiers()).getAccess().compareTo(access) < 0)
		{
			for (VariableDeclaratorNode declaratorNode : memberField.getDeclarators())
			{
				variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
						(VariableElement) this.toolkit.makeElement(memberField), declaratorNode);
			}
		}
	}

	/**
	 * Populates a member constant into the provided method namespace map.
	 * 
	 * @param variableNamespaceMap The namespace into which to populate the variable.
	 * @param indicator The node responsible for indicating this mapping.
	 * @param memberConstant The declaration which is being populated.
	 */
	private void tryPopulateMemberConstant(NamespaceMap<VariableElement> variableNamespaceMap, Node indicator,
			ConstantDeclarationNode memberConstant)
	{
		for (VariableDeclaratorNode declaratorNode : memberConstant.getDeclarators())
		{
			variableNamespaceMap.add(declaratorNode.getName().getIdentifier(),
					(VariableElement) this.toolkit.makeElement(memberConstant), declaratorNode);
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
	private void tryPopulateMemberConstructor(NamespaceMap<ExecutableElement> methodNamespaceMap, Node indicator,
			ConstructorDeclarationNode constructor, AccessModifier access)
	{
		if (((AccessibleTypeModifiersNode) constructor.getModifiers()).getAccess().compareTo(access) < 0)
		{
			methodNamespaceMap.add(NamespaceUtilities.CONSTRUCTOR_NAME,
					(ExecutableElement) this.toolkit.makeElement(constructor), indicator);
		}
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
