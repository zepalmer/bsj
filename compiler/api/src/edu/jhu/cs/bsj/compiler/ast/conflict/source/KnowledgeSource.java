package edu.jhu.cs.bsj.compiler.ast.conflict.source;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;


/**
 * Represents the source of a given {@link Knowledge} object.
 * @author Zachary Palmer
 */
public interface KnowledgeSource
{
    /**
     * Retrieves a string representation of this knowledge.
     * @return A human-readable description of this knowledge.
     */
    public String toString();
}
