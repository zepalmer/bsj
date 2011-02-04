package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageFilterKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.SuccessfulLoadKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class FilterAndMatchingSuccessfulLoadConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final FilterAndMatchingSuccessfulLoadConflictClosureRuleImpl SINGLETON = new FilterAndMatchingSuccessfulLoadConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof SuccessfulLoadKnowledge) || !(knowledge2 instanceof PackageFilterKnowledge))
            return null;

        SuccessfulLoadKnowledge successfulLoadKnowledge = (SuccessfulLoadKnowledge) knowledge1;
        PackageFilterKnowledge filterKnowledge = (PackageFilterKnowledge) knowledge2;

        if (filterKnowledge.getLoadedCompilationUnitNames().contains(successfulLoadKnowledge.getName()))
            return null;

        if (metaprogramOrderingRecord.checkOrdering(successfulLoadKnowledge.getMetaprogramId(),
                filterKnowledge.getMetaprogramId()))
            return null;

        // TODO: this filtering operation should be attributing the associated read operations to the metaprogram that
        // introduced the filter
        if (!(filterKnowledge.getFilter().filter(successfulLoadKnowledge.getValue())))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(successfulLoadKnowledge, filterKnowledge)),
                successfulLoadKnowledge.getMetaprogramId(), filterKnowledge.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return LOAD_LEFT + SIMPLE_NAME + LOAD_SUCCESS + MAPS_TO + EXPR + LOAD_RIGHT + METAPROG + AND + INVARIANT_LEFT
                + PREDICATE + TUPLER + SIMPLE_NAME_SET + INVARIANT_RIGHT + METAPROG2 + AND + PREDICATE + "(" + EXPR
                + ")" + AND + SIMPLE_NAME_SET + SET_NONCONTAINMENT + SIMPLE_NAME + IMPLIES + CONTRADICTION;
    }
}
