package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents an unparameterized type.  Examples of unparameterized types in Java include most of the API: String,
 * InputStream, and so on.  Parameterized types, such as Set<String>, are not represented in this way.
 * Unparameterized types also represent type parameters, such as the <tt>T</tt> in <tt>Set<T></tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UnparameterizedTypeNode extends Node, DeclaredTypeNode, LiteralizableTypeNode
{
    /**
     * Gets the name of the type.
     * @return The name of the type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getName() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the type.
     * @return A union object representing The name of the type.
     */
    public NodeUnion<? extends NameNode> getUnionForName();
    
    /**
     * Changes the name of the type.
     * @param name The name of the type.
     */
    public void setName(NameNode name);
    
    /**
     * Changes the name of the type.
     * @param name The name of the type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnparameterizedTypeNode deepCopy(BsjNodeFactory factory);
    
}
