package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public ImportNode getImportNode();
    
    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     */
    public void setImportNode(ImportNode importNode);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramImportNode deepCopy(BsjNodeFactory factory);
    
}
