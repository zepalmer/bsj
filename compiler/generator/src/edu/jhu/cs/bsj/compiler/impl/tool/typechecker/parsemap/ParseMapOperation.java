package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * This operation is intended to evaluate the parse map relation as specified in the BSJ Language Specification. The
 * node on which this operation is being executed is the AST node in the relation; the return value of this operation is
 * the parse map. The operation's input value is an object indicating the environment at the time of the request.
 * 
 * @author Zachary Palmer
 */
public class ParseMapOperation extends
		BsjDefaultNodeOperation<ParseMapperEnvironment, Map<RawCodeLiteralNode, ParseMapEntry>>
{
	/** The manager to use. */
	private TypecheckerManager manager;
	/** A cached instance of the BSJ AST Node type. */
	private BsjExplicitlyDeclaredType nodeType;

	public ParseMapOperation(TypecheckerManager manager)
	{
		super();
		this.manager = manager;

		this.nodeType = this.manager.getToolkit().getNodeElement().asType();
	}
	
	/* TODO: rules not yet implemented
	 * 
	 * * Code Literal Rule (p49)
	 * * Assignment Rule (p49)
	 * * Return Rule (p49)
	 * * Method Declaration Rule (p50)
	 * * Meta-Annotation Rule (p50)
	 * * Array Value Rule (p50)
	 * * Method Invocation Rule (p51)
	 */

	/**
	 * Provides a simple default operation most AST nodes: derive a new environment using {@link Node} as the expected
	 * type, recursively execute on the node's children, and then union the results.
	 */
	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeDefault(Node node, ParseMapperEnvironment env)
	{
		ParseMapperEnvironment childEnv = env.deriveForType(this.nodeType);
		Iterator<? extends Node> childIterator = node.getChildIterable().iterator();
		if (childIterator.hasNext())
		{
			Map<RawCodeLiteralNode, ParseMapEntry> map = new HashMap<RawCodeLiteralNode, ParseMapEntry>();
			while (childIterator.hasNext())
			{
				map.putAll(childIterator.next().executeOperation(this, childEnv));
			}
			return Collections.unmodifiableMap(map);
		} else
		{
			return Collections.emptyMap();
		}
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAlternateConstructorInvocationNode(
			AlternateConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationAnnotationValueNode(
			AnnotationAnnotationValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationArrayValueNode(AnnotationArrayValueNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationBodyNode(AnnotationBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationDeclarationNode(AnnotationDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationElementListNode(AnnotationElementListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationElementNode(AnnotationElementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationExpressionValueNode(
			AnnotationExpressionValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationListNode(AnnotationListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationMemberListNode(AnnotationMemberListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationMemberMetaprogramAnchorNode(
			AnnotationMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationMethodDeclarationNode(
			AnnotationMethodDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnnotationValueListNode(AnnotationValueListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnonymousClassBodyNode(AnonymousClassBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnonymousClassMemberListNode(
			AnonymousClassMemberListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAnonymousClassMemberMetaprogramAnchorNode(
			AnonymousClassMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayAccessNode(ArrayAccessNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInitializerCreationNode(
			ArrayInitializerCreationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInitializerNode(ArrayInitializerNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayInstantiatorCreationNode(
			ArrayInstantiatorCreationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeArrayTypeNode(ArrayTypeNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAssertStatementNode(AssertStatementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeAssignmentNode(AssignmentNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBinaryExpressionNode(BinaryExpressionNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBlockNode(BlockNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBlockStatementListNode(BlockStatementListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBlockStatementMetaprogramAnchorNode(
			BlockStatementMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBooleanLiteralNode(BooleanLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeBreakNode(BreakNode node, ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCaseListNode(CaseListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCaseNode(CaseNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCatchListNode(CatchListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCatchNode(CatchNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCharLiteralNode(CharLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeClassBodyNode(ClassBodyNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeClassDeclarationNode(ClassDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeClassLiteralNode(ClassLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeClassMemberListNode(ClassMemberListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeClassMemberMetaprogramAnchorNode(
			ClassMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeCodeLiteralNode(CodeLiteralNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConditionalExpressionNode(ConditionalExpressionNode node,
			ParseMapperEnvironment env)
	{
		Map<RawCodeLiteralNode, ParseMapEntry> map = new HashMap<RawCodeLiteralNode, ParseMapEntry>();
		map.putAll(node.getCondition().executeOperation(this, env.deriveForType(this.nodeType)));
		map.putAll(node.getTrueExpression().executeOperation(this, env));
		map.putAll(node.getFalseExpression().executeOperation(this, env));
		return map;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConstantDeclarationNode(ConstantDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConstructorBodyNode(ConstructorBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeConstructorDeclarationNode(ConstructorDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeContinueNode(ContinueNode node, ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeDeclaredTypeListNode(DeclaredTypeListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeDoWhileLoopNode(DoWhileLoopNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeDoubleLiteralNode(DoubleLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeEnhancedForLoopNode(EnhancedForLoopNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeEnumBodyNode(EnumBodyNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeEnumConstantDeclarationListNode(
			EnumConstantDeclarationListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeEnumDeclarationNode(EnumDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeExpressionListNode(ExpressionListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeExpressionStatementNode(ExpressionStatementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeFieldDeclarationNode(FieldDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeFloatLiteralNode(FloatLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeForInitializerDeclarationNode(
			ForInitializerDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeForInitializerExpressionNode(
			ForInitializerExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeForLoopNode(ForLoopNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeIdentifierListNode(IdentifierListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeIdentifierNode(IdentifierNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeIfNode(IfNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeImportListNode(ImportListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeImportOnDemandNode(ImportOnDemandNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeImportSingleTypeNode(ImportSingleTypeNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInitializerDeclarationNode(InitializerDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInstanceOfNode(InstanceOfNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeIntLiteralNode(IntLiteralNode node, ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInterfaceBodyNode(InterfaceBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInterfaceDeclarationNode(InterfaceDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInterfaceMemberListNode(InterfaceMemberListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeInterfaceMemberMetaprogramAnchorNode(
			InterfaceMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeJavadocNode(JavadocNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeLabeledStatementNode(LabeledStatementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeLocalClassDeclarationNode(LocalClassDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeLocalVariableDeclarationNode(
			LocalVariableDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeLongLiteralNode(LongLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationArrayValueNode(
			MetaAnnotationArrayValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationElementListNode(
			MetaAnnotationElementListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationElementNode(MetaAnnotationElementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationExpressionValueNode(
			MetaAnnotationExpressionValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationListNode(MetaAnnotationListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationMetaAnnotationValueNode(
			MetaAnnotationMetaAnnotationValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationMetaprogramAnchorNode(
			MetaAnnotationMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramDependencyDeclarationListNode(
			MetaprogramDependencyDeclarationListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramDependencyDeclarationNode(
			MetaprogramDependencyDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramDependencyListNode(
			MetaprogramDependencyListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramDependencyNode(MetaprogramDependencyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramImportListNode(MetaprogramImportListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramImportNode(MetaprogramImportNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramNode(MetaprogramNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramPreambleNode(MetaprogramPreambleNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramTargetListNode(MetaprogramTargetListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMetaprogramTargetNode(MetaprogramTargetNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMethodDeclarationNode(MethodDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMethodInvocationByExpressionNode(
			MethodInvocationByExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeMethodInvocationByNameNode(MethodInvocationByNameNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeNoOperationNode(NoOperationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeNormalAnnotationNode(NormalAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeNullLiteralNode(NullLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executePackageDeclarationNode(PackageDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executePackageNode(PackageNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeParameterizedTypeNode(ParameterizedTypeNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeParenthesizedExpressionNode(ParenthesizedExpressionNode node,
			ParseMapperEnvironment env)
	{
		return node.getExpression().executeOperation(this, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executePrimitiveTypeNode(PrimitiveTypeNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeQualifiedClassInstantiationNode(
			QualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeQualifiedNameNode(QualifiedNameNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeRawCodeLiteralNode(RawCodeLiteralNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeReferenceTypeListNode(ReferenceTypeListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeReturnNode(ReturnNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSimpleNameNode(SimpleNameNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSingleElementAnnotationNode(SingleElementAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSingleElementMetaAnnotationNode(
			SingleElementMetaAnnotationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSingleStaticImportNode(SingleStaticImportNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeStatementExpressionListNode(StatementExpressionListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeStaticImportOnDemandNode(StaticImportOnDemandNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeStringLiteralNode(StringLiteralNode node,
			ParseMapperEnvironment env)
	{
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSuperFieldAccessNode(SuperFieldAccessNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSuperMethodInvocationNode(SuperMethodInvocationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSuperclassConstructorInvocationNode(
			SuperclassConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSwitchNode(SwitchNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeSynchronizedNode(SynchronizedNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeThisNode(ThisNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeThrowNode(ThrowNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTryNode(TryNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeArgumentListNode(TypeArgumentListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeCastNode(TypeCastNode node, ParseMapperEnvironment env)
	{
		BsjType type = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		return node.getExpression().executeOperation(this, env.deriveForType(type));
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeDeclarationListNode(TypeDeclarationListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeDeclarationMetaprogramAnchorNode(
			TypeDeclarationMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeParameterListNode(TypeParameterListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeTypeParameterNode(TypeParameterNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnaryExpressionNode(UnaryExpressionNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnaryStatementExpressionNode(
			UnaryStatementExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnparameterizedTypeListNode(UnparameterizedTypeListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnparameterizedTypeNode(UnparameterizedTypeNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeUnqualifiedClassInstantiationNode(
			UnqualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableAccessByExpressionNode(
			VariableAccessByExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableAccessByNameNode(VariableAccessByNameNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableDeclaratorListNode(VariableDeclaratorListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableDeclaratorNode(VariableDeclaratorNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableInitializerListNode(VariableInitializerListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableListNode(VariableListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVariableNode(VariableNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeVoidTypeNode(VoidTypeNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeWhileLoopNode(WhileLoopNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry> executeWildcardTypeNode(WildcardTypeNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
