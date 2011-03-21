package edu.jhu.cs.bsj.compiler.impl.ast;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;

/**
 * A listener which is used to report events pertaining to package nodes. It also acts as an extension of a diagnostic
 * listener and receives diagnostic messages related to parsing compilation units within packages.
 * 
 * @author Zachary Palmer
 */
public interface PackageNodeListener
{
    /**
     * Invoked when a new compilation unit is added to a package node.
     * 
     * @param packageNode The affected {@link PackageNode}.
     * @param compilationUnitNode The new {@link CompilationUnitNode}.
     * @param canonicalLookupMap The mapping which allows to lookup of canonical node IDs for the children of the
     *            compilation unit node. If <code>null</code>, the node is already the canonical representation.
     */
    public void compilationUnitLoaded(PackageNode packageNode, CompilationUnitNode compilationUnitNode,
            BijectiveMap<Long, Long> canonicalLookupMap);
}
