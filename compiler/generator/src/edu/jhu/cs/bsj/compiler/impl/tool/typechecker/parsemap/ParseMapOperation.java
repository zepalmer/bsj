package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.AlternateConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InstanceOfNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParenthesizedExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReturnNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperFieldAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableAccessByExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnnotationMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.AnonymousClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.BlockStatementMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.InterfaceMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationExpressionValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.TypeDeclarationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

/**
 * This operation is intended to evaluate the parse map relation as specified in the BSJ Language Specification. The
 * node on which this operation is being executed is the AST node in the relation; the return value of this operation is
 * the parse map. The operation's input value is an object indicating the environment at the time of the request.
 * 
 * @author Zachary Palmer
 */
public class ParseMapOperation extends
		BsjDefaultNodeOperation<ParseMapperEnvironment, Map<RawCodeLiteralNode, ParseMapEntry<?>>>
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

	/*
	 * TODO: rules not yet implemented
	 * 
	 * * Code Literal Rule (p49) * Assignment Rule (p49) * Return Rule (p49) * Method Declaration Rule (p50) *
	 * Meta-Annotation Rule (p50) * Array Value Rule (p50) * Method Invocation Rule (p51)
	 */

	/**
	 * Provides a simple default operation most AST nodes: derive a new environment using {@link Node} as the expected
	 * type, recursively execute on the node's children, and then union the results.
	 */
	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeDefault(Node node, ParseMapperEnvironment env)
	{
		ParseMapperEnvironment childEnv = env.deriveForExpectedType(this.nodeType);
		return calculateNodeUnionWithEnvironment(node.getChildIterable(), childEnv);
	}

	/**
	 * Calculates the union of the parse maps of all of the specified nodes. The children are provided the specified
	 * environment.
	 * 
	 * @param nodes The node whose children are to be used.
	 * @param env The environment to provide the children.
	 * @return The union of the parse maps of the children.
	 */
	private Map<RawCodeLiteralNode, ParseMapEntry<?>> calculateNodeUnionWithEnvironment(Iterable<? extends Node> nodes,
			ParseMapperEnvironment env)
	{
		Iterator<? extends Node> childIterator = nodes.iterator();
		if (childIterator.hasNext())
		{
			Map<RawCodeLiteralNode, ParseMapEntry<?>> map = new HashMap<RawCodeLiteralNode, ParseMapEntry<?>>();
			while (childIterator.hasNext())
			{
				Node child = childIterator.next();
				if (child != null)
				{
					map.putAll(child.executeOperation(this, env));
				}
			}
			return Collections.unmodifiableMap(map);
		} else
		{
			return Collections.emptyMap();
		}
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAlternateConstructorInvocationNode(
			AlternateConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationAnnotationValueNode(
			AnnotationAnnotationValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationArrayValueNode(AnnotationArrayValueNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationBodyNode(AnnotationBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationDeclarationNode(AnnotationDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationElementListNode(AnnotationElementListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationElementNode(AnnotationElementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationExpressionValueNode(
			AnnotationExpressionValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationMemberMetaprogramAnchorNode(
			AnnotationMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationMethodDeclarationNode(
			AnnotationMethodDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnnotationValueListNode(AnnotationValueListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnonymousClassBodyNode(AnonymousClassBodyNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAnonymousClassMemberMetaprogramAnchorNode(
			AnonymousClassMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeArrayInitializerCreationNode(
			ArrayInitializerCreationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeArrayInitializerNode(ArrayInitializerNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeArrayInstantiatorCreationNode(
			ArrayInstantiatorCreationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeAssignmentNode(AssignmentNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeBlockStatementMetaprogramAnchorNode(
			BlockStatementMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeClassMemberMetaprogramAnchorNode(
			ClassMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeConditionalExpressionNode(ConditionalExpressionNode node,
			ParseMapperEnvironment env)
	{
		Map<RawCodeLiteralNode, ParseMapEntry<?>> map = new HashMap<RawCodeLiteralNode, ParseMapEntry<?>>();
		map.putAll(node.getCondition().executeOperation(this, env.deriveForExpectedType(this.nodeType)));
		map.putAll(node.getTrueExpression().executeOperation(this, env));
		map.putAll(node.getFalseExpression().executeOperation(this, env));
		return map;
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeConstantDeclarationNode(ConstantDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeEnumConstantDeclarationNode(EnumConstantDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO: Complete this method. Observe that an enum constant declaration is much like a constructor invocation.
		// As a result, there may be an overloaded invocation here and we can't simply dismiss this as a default case.
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeExpressionListNode(ExpressionListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeFieldDeclarationNode(FieldDeclarationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeInstanceOfNode(InstanceOfNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeInterfaceMemberMetaprogramAnchorNode(
			InterfaceMemberMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeLocalVariableDeclarationNode(
			LocalVariableDeclarationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationArrayValueNode(
			MetaAnnotationArrayValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationElementListNode(
			MetaAnnotationElementListNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationElementNode(MetaAnnotationElementNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationExpressionValueNode(
			MetaAnnotationExpressionValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationMetaAnnotationValueNode(
			MetaAnnotationMetaAnnotationValueNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationMetaprogramAnchorNode(
			MetaAnnotationMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaAnnotationValueListNode(MetaAnnotationValueListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMetaprogramNode(MetaprogramNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMethodDeclarationNode(MethodDeclarationNode node,
			ParseMapperEnvironment env)
	{
		BsjType returnType = this.manager.getToolkit().getTypeBuilder().makeType(node.getReturnType());
		ParseMapperEnvironment childEnv = env.deriveForExpectedReturnType(returnType);
		return calculateNodeUnionWithEnvironment(node.getChildIterable(), childEnv);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMethodInvocationByExpressionNode(
			MethodInvocationByExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeMethodInvocationByNameNode(MethodInvocationByNameNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeNormalAnnotationNode(NormalAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeNormalMetaAnnotationNode(NormalMetaAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executePackageNode(PackageNode node, ParseMapperEnvironment env)
	{
		// Requesting the parse map for an entire package doesn't make a lot of sense. This wouldn't specify if we
		// wanted on-demand loading or not and would be quite expensive. Return a dummy value instead.
		return Collections.emptyMap();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeParenthesizedExpressionNode(ParenthesizedExpressionNode node,
			ParseMapperEnvironment env)
	{
		return node.getExpression().executeOperation(this, env);
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeQualifiedClassInstantiationNode(
			QualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeRawCodeLiteralNode(RawCodeLiteralNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeReturnNode(ReturnNode node, ParseMapperEnvironment env)
	{
		if (node.getExpression() != null)
		{
			return node.getExpression().executeOperation(this,
					env.deriveForExpectedType(env.getCodeLiteralExpectedReturnType()));
		} else
		{
			return Collections.emptyMap();
		}
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeSingleElementAnnotationNode(SingleElementAnnotationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeSingleElementMetaAnnotationNode(
			SingleElementMetaAnnotationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeSuperFieldAccessNode(SuperFieldAccessNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeSuperMethodInvocationNode(SuperMethodInvocationNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeSuperclassConstructorInvocationNode(
			SuperclassConstructorInvocationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeTypeCastNode(TypeCastNode node, ParseMapperEnvironment env)
	{
		BsjType type = this.manager.getToolkit().getTypeBuilder().makeType(node.getType());
		return node.getExpression().executeOperation(this, env.deriveForExpectedType(type));
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeTypeDeclarationMetaprogramAnchorNode(
			TypeDeclarationMetaprogramAnchorNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeUnqualifiedClassInstantiationNode(
			UnqualifiedClassInstantiationNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeVariableAccessByExpressionNode(
			VariableAccessByExpressionNode node, ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeVariableAccessByNameNode(VariableAccessByNameNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeVariableDeclaratorListNode(VariableDeclaratorListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeVariableDeclaratorNode(VariableDeclaratorNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}

	@Override
	public Map<RawCodeLiteralNode, ParseMapEntry<?>> executeVariableInitializerListNode(VariableInitializerListNode node,
			ParseMapperEnvironment env)
	{
		// TODO Auto-generated method stub
		throw new NotImplementedYetException();
	}
}
