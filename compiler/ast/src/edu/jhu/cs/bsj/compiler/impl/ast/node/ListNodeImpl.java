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
/* // stopGen=cons,children
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
/* // stopGen=cons,children
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.children);
        return list;
    }
*/	/** General constructor */
    public ListNodeImpl(List<? extends T> children)
    {
        super();
        this.children = new ArrayList<T>(children);
    }
    
    /**
     * Creates a list of this node's child objects.  Modifying the list has no effect on this node.
     * @return A mutable list of this node's child objects.
     */
    public List<Object> getChildObjects()
    {
    	List<Object> list = super.getChildObjects();
    	list.addAll(this.children);
    	return list;
    }

	// TODO: implement the List<T> interface
}
