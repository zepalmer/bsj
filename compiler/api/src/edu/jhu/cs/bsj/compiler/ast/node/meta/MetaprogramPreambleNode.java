package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This node represents a metaprogram's preamble.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPreambleNode extends Node, BsjSpecificNode
{
    /**
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public MetaprogramImportListNode getImports();
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports);
    
    /**
     * Gets the metaprogram local mode.
     * @return The metaprogram local mode.
     */
    public MetaprogramLocalMode getLocalMode();
    
    /**
     * Changes the metaprogram local mode.
     * @param localMode The metaprogram local mode.
     */
    public void setLocalMode(MetaprogramLocalMode localMode);
    
    /**
     * Gets the metaprogram package mode.
     * @return The metaprogram package mode.
     */
    public MetaprogramPackageMode getPackageMode();
    
    /**
     * Changes the metaprogram package mode.
     * @param packageMode The metaprogram package mode.
     */
    public void setPackageMode(MetaprogramPackageMode packageMode);
    
    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public MetaprogramTargetListNode getTargets();
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     */
    public void setTargets(MetaprogramTargetListNode targets);
    
    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public MetaprogramDependencyDeclarationListNode getDependencies();
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     */
    public void setDependencies(MetaprogramDependencyDeclarationListNode dependencies);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory);
    
}
