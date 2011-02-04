package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.rule.KnowledgeClosureRule;

public abstract class AbstractPackageClosureRuleImpl implements KnowledgeClosureRule<PackageKnowledge>
{
    public abstract String getDescription();

    @Override
    public String toString()
    {
        return this.getDescription();
    }
}
