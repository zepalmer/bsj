package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing a static on-demand import statement, such as "<tt>import static java.util.Arrays.*</tt>".
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface StaticImportOnDemandNode extends Node, ImportNode
{
    /**
     * Gets the name of the package to import.
     * @return The name of the package to import.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getName()throws ClassCastException;
    
    /**
     * Gets the union object for the name of the package to import.
     * @return A union object representing The name of the package to import.
     */
    public NodeUnion<? extends NameNode> getUnionForName();
    
    /**
     * Changes the name of the package to import.
     * @param name The name of the package to import.
     */
    public void setName(NameNode name);
    
    /**
     * Changes the name of the package to import.
     * @param name The name of the package to import.
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
    public StaticImportOnDemandNode deepCopy(BsjNodeFactory factory);
    
}
