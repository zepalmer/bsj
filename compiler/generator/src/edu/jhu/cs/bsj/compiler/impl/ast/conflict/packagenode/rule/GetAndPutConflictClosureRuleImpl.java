package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.GetKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PutKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class GetAndPutConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final GetAndPutConflictClosureRuleImpl SINGLETON = new GetAndPutConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof GetKnowledge) || !(knowledge2 instanceof PutKnowledge))
            return null;

        GetKnowledge getKnowledge = (GetKnowledge) knowledge1;
        PutKnowledge putKnowledge = (PutKnowledge) knowledge2;

        if (!getKnowledge.getName().equals(putKnowledge.getName()))
            return null;

        if (metaprogramOrderingRecord.checkOrdering(getKnowledge.getMetaprogramId(), putKnowledge.getMetaprogramId()))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(getKnowledge, putKnowledge)),
                getKnowledge.getMetaprogramId(), putKnowledge.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return INVARIANT_LEFT + SIMPLE_NAME + MAPS_TO + EXPR + INVARIANT_RIGHT + METAPROG + AND + EFFECT_LEFT
                + SIMPLE_NAME + MAPS_TO + EXPR_PRIME + EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION;
    }
}
