package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a single metaprogram dependency in a dependency declaration, as in
 * <pre>
 * com.example.Foo.target
 * </pre>
 * or
 * <pre>
 * #weak com.example.Foo.target
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramDependencyNode extends Node, BsjSpecificNode
{
    /**
     * Gets the name of the metaprogram target on which to depend.
     * @return The name of the metaprogram target on which to depend.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getTargetName() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the metaprogram target on which to depend.
     * @return A union object representing The name of the metaprogram target on which to depend.
     */
    public NodeUnion<? extends NameNode> getUnionForTargetName();
    
    /**
     * Changes the name of the metaprogram target on which to depend.
     * @param targetName The name of the metaprogram target on which to depend.
     */
    public void setTargetName(NameNode targetName);
    
    /**
     * Changes the name of the metaprogram target on which to depend.
     * @param targetName The name of the metaprogram target on which to depend.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTargetName(NodeUnion<? extends NameNode> targetName) throws NullPointerException;
    
    /**
     * Gets whether or not this dependency is weak.
     * @return Whether or not this dependency is weak.
     */
    public boolean getWeak();
    
    /**
     * Changes whether or not this dependency is weak.
     * @param weak Whether or not this dependency is weak.
     */
    public void setWeak(boolean weak);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyNode deepCopy(BsjNodeFactory factory);
    
}
