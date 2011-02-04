package edu.jhu.cs.bsj.compiler.ast.conflict.source;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;

/**
 * Represents a knowledge source wherein the knowledge is obtained from a closure rule.
 * @author Zachary Palmer
 *
 * @param <K> The type of knowledge handled by the rule.
 */
public interface RuleKnowledgeSource<K extends Knowledge> extends KnowledgeSource
{
    /**
     * Retrieves the rule in question.
     * @return The rule which represents this knowledge source.
     */
    public KnowledgeClosureRule<K> getRule();
    
    /**
     * The inputs to the rule which produced its result.
     * @return The knowledge which was input to the rule.
     */
    public List<K> getKnowledge();
}
