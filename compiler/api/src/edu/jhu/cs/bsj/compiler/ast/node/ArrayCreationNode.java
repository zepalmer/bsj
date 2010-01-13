package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the creation of an array, including both instantiation and initialization.
 */
public interface ArrayCreationNode extends Node, PrimaryExpressionNode
{
    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     */
    public BaseTypeNode getBaseType();

    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType);

    /**
     * Gets the number of uninitialized levels for this array.
     * @return The number of uninitialized levels for this array.
     */
    public int getArrayLevels();

    /**
     * Changes the number of uninitialized levels for this array.
     * @param arrayLevels The number of uninitialized levels for this array.
     */
    public void setArrayLevels(int arrayLevels);

}
