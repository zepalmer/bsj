package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;

public class SingleElementAnnotationNodeImpl extends AnnotationNodeImpl implements SingleElementAnnotationNode
{
    /** The value of the "value" element. */
    private AnnotationValueNode value;

    /** General constructor. */
    public SingleElementAnnotationNodeImpl(
            AnnotationValueNode value,
            RawTypeNode annotationType)
    {
        super(annotationType);
        this.value = value;
    }

    /**
     * Gets the value of the "value" element.
     * @return The value of the "value" element.
     */
    public AnnotationValueNode getValue()
    {
        return this.value;
    }

    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(AnnotationValueNode value)
    {
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(null);
        }
        this.value = value;
        if (this.value instanceof NodeImpl)
        {
            ((NodeImpl)this.value).setParent(this);
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
        this.value.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.value);
        return list;
    }
}
