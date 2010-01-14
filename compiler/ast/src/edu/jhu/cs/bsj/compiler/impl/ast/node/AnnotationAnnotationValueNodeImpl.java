package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;

public class AnnotationAnnotationValueNodeImpl extends NodeImpl implements AnnotationAnnotationValueNode
{
    /** The annotation. */
    private AnnotationNode annotation;

    /** General constructor. */
    public AnnotationAnnotationValueNodeImpl(
            AnnotationNode annotation)
    {
        super();
        this.annotation = annotation;
    }

    /**
     * Gets the annotation.
     * @return The annotation.
     */
    public AnnotationNode getAnnotation()
    {
        return this.annotation;
    }

    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(AnnotationNode annotation)
    {
        if (this.annotation instanceof NodeImpl)
        {
            ((NodeImpl)this.annotation).setParent(null);
        }
        this.annotation = annotation;
        if (this.annotation instanceof NodeImpl)
        {
            ((NodeImpl)this.annotation).setParent(this);
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
        this.annotation.receive(visitor);
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
        list.add(this.annotation);
        return list;
    }
}
