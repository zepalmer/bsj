package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnnotationArrayValueNodeImpl extends AnnotationValueNodeImpl implements AnnotationArrayValueNode
{
    /** The array values. */
    private ListNode<? extends AnnotationValueNode> values;

    /** General constructor. */
    public AnnotationArrayValueNodeImpl(
            ListNode<? extends AnnotationValueNode> values)
    {
        super();
        this.values = values;
    }

    /**
     * Gets the array values.
     * @return The array values.
     */
    public ListNode<? extends AnnotationValueNode> getValues()
    {
        return this.values;
    }

    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(ListNode<? extends AnnotationValueNode> values)
    {
        if (this.values instanceof NodeImpl)
        {
            ((NodeImpl)this.values).setParent(null);
        }
        this.values = values;
        if (this.values instanceof NodeImpl)
        {
            ((NodeImpl)this.values).setParent(this);
        }
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
        this.values.receive(visitor);
    }
}
