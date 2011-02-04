package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.rule;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.LoadKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PutKnowledge;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.PackageConflictKnowledgeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.RuleKnowledgeSourceImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;

public class LoadAndPutConflictClosureRuleImpl extends AbstractBinaryPackageClosureRuleImpl
{
    public static final LoadAndPutConflictClosureRuleImpl SINGLETON = new LoadAndPutConflictClosureRuleImpl();

    @Override
    public PackageKnowledge evaluate(PackageKnowledge knowledge1, PackageKnowledge knowledge2,
            MetaprogramOrderingRecord metaprogramOrderingRecord)
    {
        if (!(knowledge1 instanceof LoadKnowledge) || !(knowledge2 instanceof PutKnowledge))
            return null;

        LoadKnowledge loadKnowledge = (LoadKnowledge) knowledge1;
        PutKnowledge putKnowledge = (PutKnowledge) knowledge2;

        if (!loadKnowledge.getName().equals(putKnowledge.getName()))
            return null;

        if (metaprogramOrderingRecord.checkOrdering(loadKnowledge.getMetaprogramId(), putKnowledge.getMetaprogramId()))
            return null;

        return new PackageConflictKnowledgeImpl(new RuleKnowledgeSourceImpl<PackageKnowledge>(this,
                CollectionUtilities.<PackageKnowledge> listOf(loadKnowledge, putKnowledge)),
                loadKnowledge.getMetaprogramId(), putKnowledge.getMetaprogramId());
    }

    @Override
    public String getDescription()
    {
        return LOAD_LEFT + SIMPLE_NAME + MAPS_TO + EXPR + LOAD_RIGHT + METAPROG + AND + EFFECT_LEFT + SIMPLE_NAME
                + MAPS_TO + EXPR_PRIME + EFFECT_RIGHT + METAPROG2 + IMPLIES + CONTRADICTION;
    }
}
