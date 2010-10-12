package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents a qualified name, as in
 * <pre>
 * <i>name.ident</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface QualifiedNameNode extends NameNode
{
    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getBase()throws ClassCastException;
    
    /**
     * Gets the union object for the name being qualified.
     * @return A union object representing The name being qualified.
     */
    public NodeUnion<? extends NameNode> getUnionForBase();
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base);
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBase(NodeUnion<? extends NameNode> base) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedNameNode deepCopy(BsjNodeFactory factory);
    
}
