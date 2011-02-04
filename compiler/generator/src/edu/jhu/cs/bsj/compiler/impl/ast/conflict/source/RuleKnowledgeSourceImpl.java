package edu.jhu.cs.bsj.compiler.impl.ast.conflict.source;

import java.util.Collections;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.RuleKnowledgeSource;

public class RuleKnowledgeSourceImpl<K extends Knowledge> extends AbstractKnowledgeSourceImpl implements RuleKnowledgeSource<K>
{
    private KnowledgeClosureRule<K> rule;
    private List<K> knowledge;
    
    public RuleKnowledgeSourceImpl(KnowledgeClosureRule<K> rule, List<K> knowledge)
    {
        super();
        this.rule = rule;
        this.knowledge = Collections.unmodifiableList(knowledge);
    }

    @Override
    public KnowledgeClosureRule<K> getRule()
    {
        return this.rule;
    }

    @Override
    public List<K> getKnowledge()
    {
        return this.knowledge;
    }
}
