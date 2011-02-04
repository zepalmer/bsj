package edu.jhu.cs.bsj.compiler.ast.conflict.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.KnowledgeBase;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;

/**
 * Represents knowledge used by a {@link KnowledgeBase}.
 * @author Zachary Palmer
 */
public interface Knowledge
{
    /**
     * Retrieves a string representation of this knowledge.
     * @return A human-readable description of this knowledge.
     */
    public String toString();

    /**
     * Retrieves a string representation of this knowledge.
     * @return A human-readable description of this knowledge.
     */
    public String getDescription();

    /**
     * Describes the source of this knowledge.
     */
    public KnowledgeSource getSource();
}
