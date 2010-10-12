package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a metaprogram dependency declaration, as in
 * <pre>
 * #depends com.example.Foo.target;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramDependencyDeclarationNode extends Node, BsjSpecificNode
{
    /**
     * Gets the names of the metaprogram targets on which to depend.
     * @return The names of the metaprogram targets on which to depend.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramDependencyListNode getTargets()throws ClassCastException;
    
    /**
     * Gets the union object for the names of the metaprogram targets on which to depend.
     * @return A union object representing The names of the metaprogram targets on which to depend.
     */
    public NodeUnion<? extends MetaprogramDependencyListNode> getUnionForTargets();
    
    /**
     * Changes the names of the metaprogram targets on which to depend.
     * @param targets The names of the metaprogram targets on which to depend.
     */
    public void setTargets(MetaprogramDependencyListNode targets);
    
    /**
     * Changes the names of the metaprogram targets on which to depend.
     * @param targets The names of the metaprogram targets on which to depend.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTargets(NodeUnion<? extends MetaprogramDependencyListNode> targets) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
