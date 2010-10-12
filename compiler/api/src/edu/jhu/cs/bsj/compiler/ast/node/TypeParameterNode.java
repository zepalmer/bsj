package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;

/**
 * A node for type parameters, as in:
 * <pre>
 * <i>ident</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i>
 * </pre>
 * or
 * <pre>
 * <i>ident</i> extends <i>type</i> &amp; <i>type...</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeParameterNode extends Node, TypeNameBindingNode
{
    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the base type name for the parameter.
     * @return A union object representing The base type name for the parameter.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeListNode getBounds()throws ClassCastException;
    
    /**
     * Gets the union object for the bounds over the base type.
     * @return A union object representing The bounds over the base type.
     */
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForBounds();
    
    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(DeclaredTypeListNode bounds);
    
    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBounds(NodeUnion<? extends DeclaredTypeListNode> bounds) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeParameterNode deepCopy(BsjNodeFactory factory);
    
}
