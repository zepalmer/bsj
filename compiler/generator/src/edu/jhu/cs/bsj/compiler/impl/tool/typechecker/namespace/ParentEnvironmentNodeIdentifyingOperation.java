package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;

/**
 * This BSJ node operation ascertains for a given node which node dictates its parent environment. The parent
 * environment node is the node whose environment acts as a base for the given node's environment. If no such parent
 * exists, <code>null</code> is returned.
 * 
 * @author Zachary Palmer
 */
public class ParentEnvironmentNodeIdentifyingOperation extends BsjDefaultNodeOperation<Void, Node>
{
	@Override
	public Node executeDefault(Node node, Void p)
	{
		if (node instanceof BlockStatementNode)
		{
			if (node.getParent() instanceof BlockStatementListNode)
			{
				// In this case, the statement appears within a block or similar construct. We want to defer scope to
				// the statement which appears immediately before this one.
				BlockStatementListNode parent = (BlockStatementListNode) node.getParent();
				BlockStatementNode before = parent.getBefore((BlockStatementNode) node);
				if (before == null)
				{
					// In this case, there is no immediately preceeding statement. Defer to the environment of the
					// enclosing list.
					// TODO: for a block list inside of a constructor, we should instead defer to the alternate or
					// super constructor invocation, if any. Other BlockStatementListNode containers may have other
					// rules, too.
					return parent;
				} else
				{
					return before;
				}
			} else if (node.getParent() instanceof BlockStatementNode)
			{
				// In this case, the statement appears in a context such as a do-while loop, for loop, or if statement.
				// Just use that parent as the scope.
				return node.getParent();
			} else if (node.getParent() instanceof ForInitializerNode)
			{
				// Likewise, just use the scope of the parent for loop
				return node.getParent();
			} else
			{
				throw new NotImplementedYetException("Haven't made a decision how to handle this.  Node is a block statement and parent is of type " + node.getParent().getClass());
			}
		} else if (node instanceof PackageNode)
		{
			return null;
		} else
		{
			return node.getParent();
		}
	}
}
