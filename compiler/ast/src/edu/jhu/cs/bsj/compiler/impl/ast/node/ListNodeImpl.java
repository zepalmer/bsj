package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<T> children;

    /** General constructor. */
/* // stopGen=cons
    public ListNodeImpl(
            List<T> children)
    {
        super();
        this.children = children;
    }
*/
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren()
    {
        return this.children;
    }

    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
    }
	/** General constructor */
    public ListNodeImpl(List<? extends T> children)
    {
        super();
        this.children = new ArrayList<T>(children);
    }

	// TODO: implement the List<T> interface
}
