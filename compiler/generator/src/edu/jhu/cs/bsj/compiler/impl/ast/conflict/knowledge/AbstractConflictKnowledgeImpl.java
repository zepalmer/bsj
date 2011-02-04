package edu.jhu.cs.bsj.compiler.impl.ast.conflict.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities;

public abstract class AbstractConflictKnowledgeImpl extends AbstractKnowledgeImpl implements ConflictKnowledge
{
    private int firstMetaprogramId;
    private int secondMetaprogramId;

    public AbstractConflictKnowledgeImpl(KnowledgeSource source, int firstMetaprogramId, int secondMetaprogramId)
    {
        super(source);
        this.firstMetaprogramId = firstMetaprogramId;
        this.secondMetaprogramId = secondMetaprogramId;
    }

    @Override
    public int getFirstMetaprogramId()
    {
        return this.firstMetaprogramId;
    }

    @Override
    public int getSecondMetaprogramId()
    {
        return this.secondMetaprogramId;
    }

    @Override
    public String getDescription()
    {
        return KnowledgeBaseUtilities.CONTRADICTION;
    }

    @Override
    protected boolean equalsPart(Object o)
    {
        if (!super.equalsPart(o))
            return false;

        if (!(o instanceof AbstractConflictKnowledgeImpl))
            return false;

        AbstractConflictKnowledgeImpl other = (AbstractConflictKnowledgeImpl) o;

        if (this.getFirstMetaprogramId() != other.getFirstMetaprogramId())
            return false;

        if (this.getSecondMetaprogramId() != other.getSecondMetaprogramId())
            return false;

        return true;
    }

    @Override
    protected int hashCodePart()
    {
        return super.hashCodePart() ^ -(this.firstMetaprogramId * this.secondMetaprogramId);
    }

}
