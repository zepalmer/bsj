package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents the creation of an array, including both instantiation and initialization.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayCreationNode extends Node, PrimaryExpressionNode
{
    /**
     * Gets the base type for this array.
     * @return The base type for this array.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BaseTypeNode getBaseType() throws ClassCastException;
    
    /**
     * Gets the union object for the base type for this array.
     * @return A union object representing The base type for this array.
     */
    public NodeUnion<? extends BaseTypeNode> getUnionForBaseType();
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     */
    public void setBaseType(BaseTypeNode baseType);
    
    /**
     * Changes the base type for this array.
     * @param baseType The base type for this array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBaseType(NodeUnion<? extends BaseTypeNode> baseType) throws NullPointerException;
    
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
