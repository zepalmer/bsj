package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CaseListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

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
					// If the node before is a local variable declaration, we want to be in the scope of it's last
					// initializer.
					if (before instanceof LocalVariableDeclarationNode)
					{
						return ((LocalVariableDeclarationNode)before).getDeclarators().getLast();
					} else
					{
						return before;
					}
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
		} else if (node instanceof BlockStatementListNode && node.getParent() instanceof CaseNode)
		{
			// If this is not the first case node in the list, then this case node bestows onto its children an
			// environment based on the most recent statement contained in a preceeding case node.
			CaseNode caseNode = (CaseNode)node.getParent();
			CaseListNode parent = (CaseListNode)caseNode.getParent();
			CaseNode previousCaseNode = (CaseNode)caseNode;
			// iterate until we run out of options or we find a preceeding case node with at least one statement
			do
			{
				previousCaseNode = parent.getBefore(previousCaseNode);
			} while (previousCaseNode != null && previousCaseNode.getStatements().size() == 0);
			if (previousCaseNode != null)
			{
				// Use the previous case node's last statement.
				return previousCaseNode.getStatements().getLast();
			} else
			{
				// In this case, there is no candidate.  Just go with the structural parent.
				return node.getParent();
			}
		} else if (node instanceof VariableDeclaratorNode)
		{
			// The environment parent of a variable declarator is always the preceeding declarator in the list.
			VariableDeclaratorListNode parent = (VariableDeclaratorListNode)node.getParent();
			VariableDeclaratorNode envParent = parent.getBefore((VariableDeclaratorNode)node);
			if (envParent == null)
			{
				return parent;
			} else
			{
				return envParent;
			}
		} else
		{
			return node.getParent();
		}
	}
}
