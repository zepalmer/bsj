package edu.jhu.cs.bsj.compiler.ast.conflict.rule;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;


/**
 * Represents a knowledge closure rule.
 * @author Zachary Palmer
 * @param <K> The result type of knowledge on which this closure rule operates.
 */
public interface KnowledgeClosureRule<K extends Knowledge>
{
    /**
     * Retrieves a string representation of this knowledge.
     * @return A human-readable description of this knowledge.
     */
    public String getDescription();
    
    /**
     * Retrieves a string representation of this knowledge.
     * @return A human-readable description of this knowledge.
     */
    public String toString();    
}
