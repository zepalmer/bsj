package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnnotationNodeImpl extends ExpressionNodeImpl implements AnnotationNode
{
    /** The annotation type. */
    private DeclaredTypeNode annotationType;

    /** The arguments. */
    private ListNode<? extends AnnotationValueNode> arguments;

    /** General constructor. */
    public AnnotationNodeImpl(
            DeclaredTypeNode annotationType,
            ListNode<? extends AnnotationValueNode> arguments)
    {
        super();
        this.annotationType = annotationType;
        this.arguments = arguments;
    }

    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public DeclaredTypeNode getAnnotationType()
    {
        return this.annotationType;
    }

    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(DeclaredTypeNode annotationType)
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
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<? extends AnnotationValueNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends AnnotationValueNode> arguments)
    {
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(null);
        }
        this.arguments = arguments;
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(this);
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
        this.arguments.receive(visitor);
    }
}
