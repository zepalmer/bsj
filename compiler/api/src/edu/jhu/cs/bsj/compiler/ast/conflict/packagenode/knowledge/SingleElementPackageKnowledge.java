package edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

/**
 * Represents package knowledge learned about a single element in the package.
 * @author Zachary Palmer
 */
public interface SingleElementPackageKnowledge extends PackageMetaprogramKnowledge
{
    /**
     * Retrieves the name of the compilation unit concerned.
     */
    public String getName();
    
    /**
     * Retrieves the value associated with that name.  The semantics of this value vary based on what type of knowledge
     * this is.  If it is get knowledge, for example, it is the value retrieved; if it is put knowledge, it is the
     * value stored.
     */
    public CompilationUnitNode getValue();
}
