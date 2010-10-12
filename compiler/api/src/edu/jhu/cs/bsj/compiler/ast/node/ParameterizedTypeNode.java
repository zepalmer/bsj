package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;

/**
 * A node representing parameterized types.  This node represents the use of a type which has type arguments, such
 * as Set<String> (which would be represented by the unparameterized type Set and the single-element argument list
 * containing the unparameterized type for String).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ParameterizedTypeNode extends Node, DeclaredTypeNode
{
    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeNode getBaseType()throws ClassCastException;
    
    /**
     * Gets the union object for the base type being parameterized.
     * @return A union object representing The base type being parameterized.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForBaseType();
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType);
    
    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBaseType(NodeUnion<? extends UnparameterizedTypeNode> baseType) throws NullPointerException;
    
    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeArgumentListNode getTypeArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the type arguments for this node.
     * @return A union object representing The type arguments for this node.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForTypeArguments();
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments);
    
    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeNode deepCopy(BsjNodeFactory factory);
    
}
