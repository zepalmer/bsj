package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A note representing a class literal, such as <tt>String.class</tt>.  Note that the BSJ compiler API includes a
 * {@link VoidTypeNode}.  This is technically a violation (as Java does not treat <tt>void</tt> as a type) but
 * allows this node to represent <tt>void.class</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassLiteralNode extends Node, LiteralNode<LiteralizableTypeNode>
{
    /**
     * Gets the type for this literal.
     * @return The type for this literal.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public LiteralizableTypeNode getValue() throws ClassCastException;
    
    /**
     * Gets the union object for the type for this literal.
     * @return A union object representing The type for this literal.
     */
    public NodeUnion<? extends LiteralizableTypeNode> getUnionForValue();
    
    /**
     * Changes the type for this literal.
     * @param value The type for this literal.
     */
    public void setValue(LiteralizableTypeNode value);
    
    /**
     * Changes the type for this literal.
     * @param value The type for this literal.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForValue(NodeUnion<? extends LiteralizableTypeNode> value) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassLiteralNode deepCopy(BsjNodeFactory factory);
    
}
