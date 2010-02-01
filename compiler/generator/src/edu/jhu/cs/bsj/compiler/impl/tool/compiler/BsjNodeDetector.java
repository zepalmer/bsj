package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;

/**
 * This node visitor determines whether or not BSJ-specific nodes appear in the visited tree.
 * @author Zachary Palmer
 */
public class BsjNodeDetector extends BsjTypedNodeNoOpVisitor
{
	/** Indicates whether or not this visitor has ever seen a BSJ-specific node. */
	private boolean seenBsjSpecificNode;
	
	/**
	 * Creates a fresh BSJ node detector.
	 */
	public BsjNodeDetector()
	{
		this.seenBsjSpecificNode = false;
	}

	/**
	 * Determines whether or not this detector has seen a BSJ-specific node.
	 * @return <code>true</code> if this detector has seen a BSJ-specific node; <code>false</code> otherwise.
	 */
	public boolean hasSeenBsjSpecificNode()
	{
		return seenBsjSpecificNode;
	}
	
	private void visitBsjSpecificNode(Node node)
	{
		this.seenBsjSpecificNode = true;
	}

	@Override
	public void visitMetaprogramAnchorNodeStart(MetaprogramAnchorNode<?> node)
	{
		visitBsjSpecificNode(node);
	}

	@Override
	public void visitMetaprogramNodeStart(MetaprogramNode node, boolean mostSpecific)
	{
		visitBsjSpecificNode(node);
	}
}
