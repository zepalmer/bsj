package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BaseType;

/**
 * Represents the creation of an array, including both instantiation and initialization.
 */
public interface ArrayCreationNode extends ExpressionNode
{
    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public BaseType getBaseType();

    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseType baseType);

    /**
     * Gets the number of levels for this array.
     * @return The number of levels for this array.
     */
    public int getArrayLevels();

    /**
     * Changes the number of levels for this array.
     * @param arrayLevels The number of levels for this array.
     */
    public void setArrayLevels(int arrayLevels);

}
