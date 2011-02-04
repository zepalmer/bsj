package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageMetaprogramKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;

public abstract class AbstractPackageMetaprogramKnowledgeImpl extends AbstractPackageKnowledgeImpl implements PackageMetaprogramKnowledge
{
    private int id;
    
    public AbstractPackageMetaprogramKnowledgeImpl(KnowledgeSource source, int id)
    {
        super(source);
        this.id = id;
    }

    @Override
    public int getMetaprogramId()
    {
        return this.id;
    }

    @Override
    protected boolean equalsPart(Object o)
    {
        if (!super.equalsPart(o))
            return false;
        if (!(o instanceof AbstractPackageMetaprogramKnowledgeImpl))
            return false;
        AbstractPackageMetaprogramKnowledgeImpl other = (AbstractPackageMetaprogramKnowledgeImpl)o;
        if (this.id != other.id)
            return false;
        return true;
    }

    @Override
    protected int hashCodePart()
    {
        return super.hashCodePart() ^ this.id;
    }
    
    
}
