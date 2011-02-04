package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageFilterKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PutKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class PutAndFilterConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final PutAndFilterConflictClosureRuleImpl SINGLETON = new PutAndFilterConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof PutKnowledge) || !(knowledge2 instanceof PackageFilterKnowledge))
            return null;

        PutKnowledge putKnowledge = (PutKnowledge) knowledge1;
        PackageFilterKnowledge filterKnowledge = (PackageFilterKnowledge) knowledge2;

        if (metaprogramOrderingRecord.checkOrdering(putKnowledge.getMetaprogramId(), filterKnowledge.getMetaprogramId()))
            return null;

        // TODO: this filtering operation should be attributing the associated read operations to the metaprogram that
        // introduced the filter
        if (!(filterKnowledge.getFilter().filter(putKnowledge.getValue())))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(putKnowledge, filterKnowledge)),
                putKnowledge.getMetaprogramId(), filterKnowledge.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return EFFECT_LEFT + SIMPLE_NAME + MAPS_TO + EXPR + EFFECT_RIGHT + METAPROG + AND + INVARIANT_LEFT + PREDICATE
                + TUPLER + SIMPLE_NAME_SET + INVARIANT_RIGHT + METAPROG2 + AND + PREDICATE + "(" + EXPR + ")" + IMPLIES
                + CONTRADICTION;
    }
}
