package edu.jhu.cs.bsj.compiler.impl.tool.compiler.operations;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;

/**
 * Executes a given operation against each of the ancestors of the node on which we are operating.  This operation is
 * not executed on the node itself.  If any of the executions of the provided operation return a non-<code>null</code>
 * result, it is returned immediately and the other nodes are not executed.  If none of the executions return a
 * non-<code>null</code> result, <code>null</code> is the result of the operation.  The provided operation must accept
 * as its parameter a list of the nodes between the original node and the ancestor on which it is operating (left-inclusive).
 * @author Zachary Palmer
 *
 * @param <R> The return type of the provided operation.
 */
public class AncestryExecutingNodeOperation<R> extends BsjDefaultNodeOperation<Void, R>
{
	/** The operation to execute. */
	private BsjNodeOperation<List<Node>, R> operation;
	
	/**
	 * Creates an ancestry-executing node operation.
	 * @param operation The operation to execute on the ancestors of the node on which we are asked to operate.
	 */
	public AncestryExecutingNodeOperation(BsjNodeOperation<List<Node>, R> operation)
	{
		super();
		this.operation = operation;
	}

	@Override
	public R executeDefault(Node node, Void p)
	{
		// First, we'll get the ancestry of the node
		List<Node> ancestry = new ArrayList<Node>();
		for (Node iNode = node; iNode != null; iNode = iNode.getParent())
		{
			ancestry.add(iNode);
		}

		// Now we look at each node in turn as we scale the hierarchy and deal with it. (Skip the node itself, as it is
		// not in scope of its own declarations.)
		for (int i = 1; i < ancestry.size(); i++)
		{
			Node ancestor = ancestry.get(i);
			R result = ancestor.executeOperation(operation, ancestry.subList(0, i));
			if (result != null) // sublist does not include this ancestor
			{
				return result;
			}
		}

		// We didn't find an appropriately-scoped expression name declaration.
		return null;
	}
}
