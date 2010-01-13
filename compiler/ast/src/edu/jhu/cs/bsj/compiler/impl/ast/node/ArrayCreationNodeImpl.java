package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;

public abstract class ArrayCreationNodeImpl extends NodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private BaseTypeNode baseType;

    /** The number of uninitialized levels for this array. */
    private int arrayLevels;

    /** General constructor. */
    protected ArrayCreationNodeImpl(
            BaseTypeNode baseType,
            int arrayLevels)
    {
        super();
        this.baseType = baseType;
        this.arrayLevels = arrayLevels;
    }

    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public BaseTypeNode getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType)
    {
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(null);
        }
        this.baseType = baseType;
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(this);
        }
    }

    /**
     * Gets the number of uninitialized levels for this array.
     * @return The number of uninitialized levels for this array.
     */
    public int getArrayLevels()
    {
        return this.arrayLevels;
    }

    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels)
    {
        this.arrayLevels = arrayLevels;
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
        this.baseType.receive(visitor);
    }
}
