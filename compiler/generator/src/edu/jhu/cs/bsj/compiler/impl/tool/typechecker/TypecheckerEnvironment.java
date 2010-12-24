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
	 * The type expected in context to be used in a return statement.
	 */
	private BsjType expectedReturnType;
	
	/**
	 * Creates a new, empty typechecker environment.
	 */
	public TypecheckerEnvironment()
	{
		super();
		this.expectedType = null;
		this.namespaceNode = null;
		this.expectedReturnType = null;
	}
	
	/**
	 * Creates a new typechecker environment configured with the provided parameters.
	 * @param expectedType The expected type defined by context.
	 * @param namespaceNode The node to use when ascertaining the namespace of this node.
	 * @param expectedReturnType The type expected for return statements.
	 */
	public TypecheckerEnvironment(BsjType expectedType, Node namespaceNode, BsjType expectedReturnType)
	{
		super();
		this.expectedType = expectedType;
		this.namespaceNode = namespaceNode;
		this.expectedReturnType = expectedReturnType;
	}

	public BsjType getExpectedType()
	{
		return expectedType;
	}
	
	public Node getNamespaceNode()
	{
		return namespaceNode;
	}

	public BsjType getExpectedReturnType()
    {
        return expectedReturnType;
    }

    public TypecheckerEnvironment deriveWithExpectedType(BsjType expectedType)
	{
		return new TypecheckerEnvironment(expectedType, this.namespaceNode, this.expectedReturnType);
	}
	
    public TypecheckerEnvironment deriveWithNamespaceNode(Node namespaceNode)
    {
        return new TypecheckerEnvironment(this.expectedType, namespaceNode, this.expectedReturnType);
    }

    public TypecheckerEnvironment deriveWithExpectedReturnType(BsjType expectedReturnType)
    {
        return new TypecheckerEnvironment(this.expectedType, this.namespaceNode, expectedReturnType);
    }

    @Override
    public String toString()
    {
        return "TypecheckerEnvironment [expectedType=" + expectedType + ", namespaceNode=" + namespaceNode
                + ", expectedReturnType=" + expectedReturnType + "]";
    }
}
