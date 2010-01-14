package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;

public abstract class AnnotationNodeImpl extends NodeImpl implements AnnotationNode
{
    /** The annotation type. */
    private RawTypeNode annotationType;

    /** General constructor. */
    protected AnnotationNodeImpl(
            RawTypeNode annotationType)
    {
        super();
        this.annotationType = annotationType;
    }

    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public RawTypeNode getAnnotationType()
    {
        return this.annotationType;
    }

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(RawTypeNode annotationType)
    {
        if (this.annotationType instanceof NodeImpl)
        {
            ((NodeImpl)this.annotationType).setParent(null);
        }
        this.annotationType = annotationType;
        if (this.annotationType instanceof NodeImpl)
        {
            ((NodeImpl)this.annotationType).setParent(this);
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
        this.annotationType.receive(visitor);
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
        list.add(this.annotationType);
        return list;
    }
}
