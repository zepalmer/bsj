package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.knowledge.AbstractConflictKnowledgeImpl;

public class PackageConflictKnowledgeImpl extends AbstractConflictKnowledgeImpl implements PackageConflictKnowledge
{
    public PackageConflictKnowledgeImpl(KnowledgeSource source, int firstMetaprogramId, int secondMetaprogramId)
    {
        super(source, firstMetaprogramId, secondMetaprogramId);
    }

    @Override
    public boolean equals(Object o)
    {
        return equalsPart(o);
    }

    @Override
    public int hashCode()
    {
        return hashCodePart();
    }
}
