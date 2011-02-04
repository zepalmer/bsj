package edu.jhu.cs.bsj.compiler.impl.ast.conflict.rule;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;


/**
 * Represents a knowledge closure rule which takes a single piece of knowledge as input.
 * @author Zachary Palmer
 *
 * @param <K> The result type of knowledge on which this closure rule operates.
 */
public interface UnaryKnowledgeClosureRule<K extends Knowledge> extends KnowledgeClosureRule<K>
{
    /**
     * Evaluates a given piece of knowledge.
     * @param knowledge The input knowledge.
     * @param metaprogramOrderingRecord The ordering record deciding whether or not metaprograms are ordered.
     * @return The resulting knowledge or <code>null</code> if no conclusions can be reached.
     */
    public K evaluate(K knowledge, MetaprogramOrderingRecord metaprogramOrderingRecord);
}
