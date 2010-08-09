package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the creation of an array, including both instantiation and initialization.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayCreationNode deepCopy(BsjNodeFactory factory);
    
}
