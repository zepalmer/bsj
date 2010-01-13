package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseType;

public class ArrayInitializerCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInitializerCreationNode
{
    /** The initializer for this array. */
    private ArrayInitializerNode initializer;

    /** General constructor. */
    public ArrayInitializerCreationNodeImpl(
            ArrayInitializerNode initializer,
            BaseType baseType,
            int arrayLevels)
    {
        super(baseType, arrayLevels);
        this.initializer = initializer;
    }

    /**
     * Gets the initializer for this array.
     * @return The initializer for this array.
     */
    public ArrayInitializerNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer)
    {
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
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
        this.initializer.receive(visitor);
    }
}
