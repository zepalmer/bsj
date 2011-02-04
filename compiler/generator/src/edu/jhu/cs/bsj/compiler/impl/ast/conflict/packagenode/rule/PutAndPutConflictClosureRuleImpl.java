package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PutKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class PutAndPutConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final PutAndPutConflictClosureRuleImpl SINGLETON = new PutAndPutConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof PutKnowledge) || !(knowledge2 instanceof PutKnowledge))
            return null;

        PutKnowledge putKnowledge1 = (PutKnowledge) knowledge1;
        PutKnowledge putKnowledge2 = (PutKnowledge) knowledge2;

        if (!putKnowledge1.getName().equals(putKnowledge2.getName()))
            return null;

        if (metaprogramOrderingRecord.checkOrdering(putKnowledge1.getMetaprogramId(), putKnowledge2.getMetaprogramId()))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(putKnowledge1, putKnowledge2)),
                putKnowledge1.getMetaprogramId(), putKnowledge2.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return EFFECT_LEFT + SIMPLE_NAME + MAPS_TO + EXPR + EFFECT_RIGHT + METAPROG + AND + EFFECT_LEFT + SIMPLE_NAME
                + MAPS_TO + EXPR_PRIME + EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION;
    }
}
