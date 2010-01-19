package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class NormalAnnotationNodeImpl extends AnnotationNodeImpl implements NormalAnnotationNode
{
    /** The arguments. */
    private ListNode<AnnotationElementNode> arguments;

    /** General constructor. */
    public NormalAnnotationNodeImpl(
            ListNode<AnnotationElementNode> arguments,
            UnparameterizedTypeNode annotationType)
    {
        super(annotationType);
        this.arguments = arguments;
    }

    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public ListNode<AnnotationElementNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(ListNode<AnnotationElementNode> arguments)
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
        this.arguments.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitNormalAnnotationNodeStart(this, true);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNormalAnnotationNodeStart(this, true);
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
        list.add(getArguments());
        list.add(getAnnotationType());
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
        sb.append("arguments=");
        sb.append(this.arguments == null? "null" : this.arguments.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
