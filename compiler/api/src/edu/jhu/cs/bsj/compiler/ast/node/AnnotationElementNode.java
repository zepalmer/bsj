package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents an annotation element, as in
 * <pre>
 * <i>ident</i>=<i>value</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationElementNode extends Node
{
    /**
     * Gets the identifier.
     * @return The identifier.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the identifier.
     * @return A union object representing The identifier.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier.
     * @param identifier The identifier.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier.
     * @param identifier The identifier.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the element's value.
     * @return The element's value.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationValueNode getValue()throws ClassCastException;
    
    /**
     * Gets the union object for the element's value.
     * @return A union object representing The element's value.
     */
    public NodeUnion<? extends AnnotationValueNode> getUnionForValue();
    
    /**
     * Changes the element's value.
     * @param value The element's value.
     */
    public void setValue(AnnotationValueNode value);
    
    /**
     * Changes the element's value.
     * @param value The element's value.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValue(NodeUnion<? extends AnnotationValueNode> value) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationElementNode deepCopy(BsjNodeFactory factory);
    
}
