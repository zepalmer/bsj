package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class AnnotationNodeImpl extends NodeImpl implements AnnotationNode
{
    /** The annotation type. */
    private UnparameterizedTypeNode annotationType;

    /** General constructor. */
    protected AnnotationNodeImpl(
            UnparameterizedTypeNode annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        this.annotationType = annotationType;
    }

    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public UnparameterizedTypeNode getAnnotationType()
    {
        return this.annotationType;
    }

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType)
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
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        this.annotationType.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitStopEnd(this);
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
        list.add(getAnnotationType());
        list.add(getStartLocation());
        list.add(getStopLocation());
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("annotationType=");
        sb.append(this.annotationType == null? "null" : this.annotationType.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }

}
