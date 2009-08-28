package edu.jhu.cs.bsj.compiler.ast;

/**
 * A common interface for AST node visitors.
 * 
 * Unlike a traditional visitor pattern, this visitor does not contain a method distinguishing between each type of
 * node.  Use of the <tt>instanceof</tt> operator should be sufficient for most uses and makes for a more readable
 * visitor implementation.  Nevertheless, there are cases when a unique method for each node type may be desired (such
 * as when regenerating the original source from an AST, when every node type has a different visit implementation).
 * In that case, a {@link BsjTypedNodeVisitor} should be used.
 */
public interface BsjNodeVisitor
{
	/**
	 * Called whenever a node is entered.
	 * @param node The node being entered.
	 */
	public void visitStart(Node node);
	
	/**
	 * Called whenever a node is exited.
	 * @param node The node being exited.
	 */
	public void visitStop(Node node);
}