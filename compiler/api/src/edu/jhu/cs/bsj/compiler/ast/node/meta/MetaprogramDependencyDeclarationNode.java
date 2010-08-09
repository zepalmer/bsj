package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public MetaprogramDependencyListNode getTargets();
    
    /**
     * Changes the names of the metaprogram targets on which to depend.
     * @param targets The names of the metaprogram targets on which to depend.
     */
    public void setTargets(MetaprogramDependencyListNode targets);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
