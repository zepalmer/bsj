package edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge;

/**
 * Represents package knowledge obtained through the actions of a specific metaprogram.
 * @author Zachary Palmer
 */
public interface PackageMetaprogramKnowledge extends PackageKnowledge
{
    /**
     * Retrieves a unique ID for the metaprogram that produced this knowledge.
     */
    public int getMetaprogramId();
}
