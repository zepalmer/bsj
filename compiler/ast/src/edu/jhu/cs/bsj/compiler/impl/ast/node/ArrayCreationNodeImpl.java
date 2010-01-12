package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayCreationNode;
import edu.jhu.cs.bsj.compiler.ast.tags.BaseType;

public abstract class ArrayCreationNodeImpl extends PrimaryExpressionNodeImpl implements ArrayCreationNode
{
    /** The base type for this array. */
    private BaseType baseType;

    /** The number of uninitialized levels for this array. */
    private int arrayLevels;

    /** General constructor. */
    protected ArrayCreationNodeImpl(
            BaseType baseType,
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
    public BaseType getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseType baseType)
    {
        this.baseType = baseType;
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
    }
}
