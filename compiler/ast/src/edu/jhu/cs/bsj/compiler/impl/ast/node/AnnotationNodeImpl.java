package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class AnnotationNodeImpl extends ExpressionNodeImpl implements AnnotationNode
{
    /** The annotation type. */
    private DeclaredTypeNode annotationType;

    /** The arguments. */
    private ListNode<? extends ExpressionNode> arguments;

    /** General constructor. */
    public AnnotationNodeImpl(
            DeclaredTypeNode annotationType,
            ListNode<? extends ExpressionNode> arguments)
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
        this.annotationType = annotationType;
    }

    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<? extends ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments)
    {
        this.arguments = arguments;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
