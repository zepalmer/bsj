package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<? extends T> children;

    /** General constructor. */
/* // stopGen=cons
    public ListNodeImpl(
            List<? extends T> children)
    {
        super();
        this.children = children;
    }
*/
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<? extends T> getChildren()
    {
        return this.children;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
	/** General constructor */
    public ListNodeImpl(List<? extends T> children)
    {
        super();
        this.children = new ArrayList<T>(children);
    }

	// TODO: implement the List<T> interface
}
