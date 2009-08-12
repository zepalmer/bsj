package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * Interface for meta-program preambles.
 */
public interface MetaPreambleNode extends Node
{
    /**
     * Gets all of the meta-programs on which the current on depends.
     * @return list of dependencies.
     */
    List<? extends MetaDependNode> getDependencies();
    
    /**
     * Gets an identifier for this meta-program.
     * @return the name of the target for this meta-program.
     */
    MetaTargetNode getTarget();
    
    /**
     * Gets all of the imports this meta-program requires.
     * @return list of imports.
     */
    List<? extends MetaImportNode> getImports();
}
