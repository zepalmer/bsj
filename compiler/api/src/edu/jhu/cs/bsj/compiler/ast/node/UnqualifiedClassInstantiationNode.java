package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing the instantiation of a class, as in:
 * <pre>
 * new <i>type</i>(<i>arg...</i>)
 * </pre>
 * If this class is not anonymous, the <tt>body</tt> field is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnqualifiedClassInstantiationNode extends ClassInstantiationNode
{
    /**
     * Gets the type being instantiated.
     * @return The type being instantiated.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeNode getType() throws ClassCastException;
    
    /**
     * Gets the union object for the type being instantiated.
     * @return A union object representing The type being instantiated.
     */
    public NodeUnion<? extends DeclaredTypeNode> getUnionForType();
    
    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     */
    public void setType(DeclaredTypeNode type);
    
    /**
     * Changes the type being instantiated.
     * @param type The type being instantiated.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends DeclaredTypeNode> type) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnqualifiedClassInstantiationNode deepCopy(BsjNodeFactory factory);
    
}
