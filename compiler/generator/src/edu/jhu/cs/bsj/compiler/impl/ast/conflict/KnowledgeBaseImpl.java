package edu.jhu.cs.bsj.compiler.impl.ast.conflict;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.conflict.KnowledgeBase;
import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.rule.BinaryKnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.rule.UnaryKnowledgeClosureRule;

/**
 * Represents an implementation of a knowledge base.
 * 
 * @author Zachary Palmer
 * 
 * @param <K> The type of knowledge used by this knowledge base.
 */
public class KnowledgeBaseImpl<K extends Knowledge> implements KnowledgeBase<K>
{
    private Set<? extends KnowledgeClosureRule<K>> rules;
    private Set<K> knowledge;
    private Set<ConflictKnowledge> conflictKnowledge;
    private MetaprogramOrderingRecord metaprogramOrderingRecord;

    public KnowledgeBaseImpl(Set<? extends KnowledgeClosureRule<K>> rules,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        super();
        this.knowledge = new HashSet<K>();
        this.conflictKnowledge = new HashSet<ConflictKnowledge>();
        this.rules = rules;
        this.metaprogramOrderingRecord = metaprogramOrderingRecord;
    }
    
    private Set<ConflictKnowledge> getCurrentConflictKnowledge()
    {
        if (this.conflictKnowledge.isEmpty())
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(this.conflictKnowledge);
        }
    }

    @Override
    public Set<ConflictKnowledge> addKnowledge(K knowledge)
    {
        if (this.knowledge.contains(knowledge))
        {
            return getCurrentConflictKnowledge();
        }

        Set<K> newKnowledgeSet = new HashSet<K>();

        for (KnowledgeClosureRule<K> rule : this.rules)
        {
            if (rule instanceof UnaryKnowledgeClosureRule<?>)
            {
                UnaryKnowledgeClosureRule<K> unaryRule = (UnaryKnowledgeClosureRule<K>) rule;
                K newKnowledge = unaryRule.evaluate(knowledge, metaprogramOrderingRecord);
                if (newKnowledge != null)
                {
                    newKnowledgeSet.add(newKnowledge);
                }
            } else if (rule instanceof BinaryKnowledgeClosureRule<?>)
            {
                BinaryKnowledgeClosureRule<K> binaryRule = (BinaryKnowledgeClosureRule<K>) rule;
                for (K k : this.knowledge)
                {
                    K newKnowledge = binaryRule.evaluate(knowledge, k, metaprogramOrderingRecord);
                    if (newKnowledge != null)
                    {
                        newKnowledgeSet.add(newKnowledge);
                    }
                    newKnowledge = binaryRule.evaluate(k, knowledge, metaprogramOrderingRecord);
                    if (newKnowledge != null)
                    {
                        newKnowledgeSet.add(newKnowledge);
                    }
                }
            }
        }

        this.knowledge.add(knowledge);

        for (K k : newKnowledgeSet)
        {
            this.addKnowledge(k);
        }
        
        if (knowledge instanceof ConflictKnowledge)
        {
            this.conflictKnowledge.add((ConflictKnowledge)knowledge);
        }

        return getCurrentConflictKnowledge();
    }

    @Override
    public Set<K> getKnowledge()
    {
        return Collections.unmodifiableSet(this.knowledge);
    }
}
