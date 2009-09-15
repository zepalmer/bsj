package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralNode;

public abstract class LiteralNodeImpl<T> extends ExpressionNodeImpl implements LiteralNode<T>
{
    /** The literal value for this node. */
    private T value;

    /** General constructor. */
    protected LiteralNodeImpl(
            T value)
    {
        super();
        this.value = value;
    }

    /**
     * Gets the literal value for this node.
     * @return The literal value for this node.
     */
    public T getValue()
    {
        return this.value;
    }

    /**
     * Changes the literal value for this node.
     * @param value The literal value for this node.
     */
    public void setValue(T value)
    {
        this.value = value;
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
}