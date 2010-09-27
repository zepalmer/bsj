package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing a single static import statement, such as "<tt>import static java.util.Arrays.asList</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SingleStaticImportNode extends Node, ImportNode
{
    /**
     * Gets the name of the type from which to import.
     * @return The name of the type from which to import.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getName() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the type from which to import.
     * @return A union object representing The name of the type from which to import.
     */
    public NodeUnion<? extends NameNode> getUnionForName();
    
    /**
     * Changes the name of the type from which to import.
     * @param name The name of the type from which to import.
     */
    public void setName(NameNode name);
    
    /**
     * Changes the name of the type from which to import.
     * @param name The name of the type from which to import.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name) throws NullPointerException;
    
    /**
     * Gets the identifier to import from that type.
     * @return The identifier to import from that type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the identifier to import from that type.
     * @return A union object representing The identifier to import from that type.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier to import from that type.
     * @param identifier The identifier to import from that type.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier to import from that type.
     * @param identifier The identifier to import from that type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleStaticImportNode deepCopy(BsjNodeFactory factory);
    
}
