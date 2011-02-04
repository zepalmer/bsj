package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.SuccessfulLoadKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.UnloadedGetKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class UnloadedGetAndSuccessfulLoadConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final UnloadedGetAndSuccessfulLoadConflictClosureRuleImpl SINGLETON = new UnloadedGetAndSuccessfulLoadConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof UnloadedGetKnowledge) || !(knowledge2 instanceof SuccessfulLoadKnowledge))
            return null;

        UnloadedGetKnowledge unloadedGetKnowledge = (UnloadedGetKnowledge) knowledge1;
        SuccessfulLoadKnowledge successfulLoadKnowledge = (SuccessfulLoadKnowledge) knowledge2;

        if (!unloadedGetKnowledge.getName().equals(successfulLoadKnowledge.getName()))
            return null;

        if (metaprogramOrderingRecord.checkOrdering(unloadedGetKnowledge.getMetaprogramId(),
                successfulLoadKnowledge.getMetaprogramId()))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(unloadedGetKnowledge, successfulLoadKnowledge)),
                unloadedGetKnowledge.getMetaprogramId(), successfulLoadKnowledge.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return INVARIANT_LEFT + SIMPLE_NAME + GET_UNLOADED + MAPS_TO + EXPR + INVARIANT_RIGHT + METAPROG + AND
                + LOAD_LEFT + SIMPLE_NAME + LOAD_SUCCESS + MAPS_TO + EXPR_PRIME + LOAD_RIGHT + IMPLIES + CONTRADICTION;
    }
}
