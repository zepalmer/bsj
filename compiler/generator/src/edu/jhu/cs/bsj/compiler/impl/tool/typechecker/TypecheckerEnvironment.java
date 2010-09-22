package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

public class TypecheckerEnvironment
{
	/**
	 * The type expected in context from the surrounding nodes.  This is used to check the type of values which are
	 * stored in variable declaration initializers and other such structures.
	 */
	private BsjType expectedType;
	/**
	 * The node to be used in establishing namespaces.  This is used specifically to permit nodes which are detached
	 * from the root package to typecheck using the namespacing assumptions of another node.  For instance, a statement
	 * could be typechecked even if it has not yet been added by using the assumptions for the node immediately
	 * following the position into which the statement will be inserted.  If this value is <code>null</code>, the node
	 * which is currently being typechecked should be used instead.
	 */
	private Node namespaceNode;
	
	/**
	 * Creates a new, empty typechecker environment.
	 */
	public TypecheckerEnvironment()
	{
		super();
		this.expectedType = null;
		this.namespaceNode = null;
	}
	
	/**
	 * Creates a new typechecker environment configured with the provided parameters.
	 * @param expectedType The expected type defined by context.
	 * @param namespaceNode The node to use when ascertaining the namespace of this node.
	 */
	public TypecheckerEnvironment(BsjType expectedType, Node namespaceNode)
	{
		super();
		this.expectedType = expectedType;
		this.namespaceNode = namespaceNode;
	}

	public BsjType getExpectedType()
	{
		return expectedType;
	}
	
	public Node getNamespaceNode()
	{
		return namespaceNode;
	}

	public TypecheckerEnvironment deriveWithExpectedType(BsjType expectedType)
	{
		return new TypecheckerEnvironment(expectedType, this.namespaceNode);
	}
	
	public TypecheckerEnvironment deriveWithNamespaceNode(Node namespaceNode)
	{
		return new TypecheckerEnvironment(this.expectedType, namespaceNode);
	}

	@Override
	public String toString()
	{
		return "TypecheckerEnvironment [expectedType=" + expectedType + ", namespaceNode=" + namespaceNode + "]";
	}
}
