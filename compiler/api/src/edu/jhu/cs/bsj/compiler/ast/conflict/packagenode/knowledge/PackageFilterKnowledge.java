package edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

/**
 * Represents knowledge of a node filter used to filter the contents of a package.
 * @author Zachary Palmer
 */
public interface PackageFilterKnowledge extends PackageMetaprogramKnowledge
{
    /**
     * Retrieves the node filter used to filter the package.
     */
    public NodeFilter<? super CompilationUnitNode> getFilter();
    
    /**
     * Retrieves the names of all compilation units successfully loaded by the metaprogram before this filtering operation
     * occurred.
     */
    public Set<String> getLoadedCompilationUnitNames();
}
