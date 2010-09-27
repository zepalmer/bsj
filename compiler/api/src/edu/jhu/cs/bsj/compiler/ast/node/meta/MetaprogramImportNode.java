package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a metaprogram import, as in
 * <pre>
 * #import com.example.*;
 * </pre>
 * or
 * <pre>
 * #import static com.example.Utilities.foo;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramImportNode extends Node, BsjSpecificNode
{
    /**
     * Gets the import for the metaprogram.
     * @return The import for the metaprogram.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ImportNode getImportNode() throws ClassCastException;
    
    /**
     * Gets the union object for the import for the metaprogram.
     * @return A union object representing The import for the metaprogram.
     */
    public NodeUnion<? extends ImportNode> getUnionForImportNode();
    
    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     */
    public void setImportNode(ImportNode importNode);
    
    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForImportNode(NodeUnion<? extends ImportNode> importNode) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramImportNode deepCopy(BsjNodeFactory factory);
    
}
