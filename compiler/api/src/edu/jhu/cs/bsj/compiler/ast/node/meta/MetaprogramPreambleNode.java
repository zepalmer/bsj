package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramImportListNode getImports() throws ClassCastException;
    
    /**
     * Gets the union object for the imports for this metaprogram.
     * @return A union object representing The imports for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramImportListNode> getUnionForImports();
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports);
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForImports(NodeUnion<? extends MetaprogramImportListNode> imports) throws NullPointerException;
    
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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramTargetListNode getTargets() throws ClassCastException;
    
    /**
     * Gets the union object for the targets for this metaprogram.
     * @return A union object representing The targets for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramTargetListNode> getUnionForTargets();
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     */
    public void setTargets(MetaprogramTargetListNode targets);
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTargets(NodeUnion<? extends MetaprogramTargetListNode> targets) throws NullPointerException;
    
    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramDependencyDeclarationListNode getDependencies() throws ClassCastException;
    
    /**
     * Gets the union object for the dependencies for this metaprogram.
     * @return A union object representing The dependencies for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramDependencyDeclarationListNode> getUnionForDependencies();
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     */
    public void setDependencies(MetaprogramDependencyDeclarationListNode dependencies);
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForDependencies(NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory);
    
}
