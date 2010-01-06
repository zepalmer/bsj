package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;

public class NormalAnnotationNodeImpl extends AnnotationNodeImpl implements NormalAnnotationNode
{
    /** The arguments. */
    private ListNode<? extends AnnotationElementNode> arguments;

    /** General constructor. */
    public NormalAnnotationNodeImpl(
            ListNode<? extends AnnotationElementNode> arguments,
            DeclaredTypeNode annotationType)
    {
        super(annotationType);
        this.arguments = arguments;
    }

    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<? extends AnnotationElementNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<? extends AnnotationElementNode> arguments)
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
        this.arguments.receive(visitor);
    }
}
