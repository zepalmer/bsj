package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.INVARIANT_LEFT;
import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.INVARIANT_RIGHT;
import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.METAPROG_PREFIX;
import static edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities.TUPLER;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageFilterKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

public class PackageFilterKnowledgeImpl extends AbstractPackageMetaprogramKnowledgeImpl implements
        PackageFilterKnowledge
{
    private NodeFilter<? super CompilationUnitNode> filter;
    private Set<String> loadedCompilationUnitNames;

    public PackageFilterKnowledgeImpl(KnowledgeSource source, int id, NodeFilter<? super CompilationUnitNode> filter,
            Set<String> loadedCompilationUnitNames)
    {
        super(source, id);
        this.filter = filter;
        this.loadedCompilationUnitNames = loadedCompilationUnitNames;
    }

    @Override
    public NodeFilter<? super CompilationUnitNode> getFilter()
    {
        return this.filter;
    }

    @Override
    public Set<String> getLoadedCompilationUnitNames()
    {
        return this.loadedCompilationUnitNames;
    }

    @Override
    public String getDescription()
    {
        return INVARIANT_LEFT + getFilter() + TUPLER + getLoadedCompilationUnitNames() + INVARIANT_RIGHT
                + METAPROG_PREFIX + getMetaprogramId();
    }

    @Override
    protected boolean equalsPart(Object o)
    {
        if (!super.equalsPart(o))
            return false;
        if (!(o instanceof PackageFilterKnowledgeImpl))
            return false;
        PackageFilterKnowledgeImpl other = (PackageFilterKnowledgeImpl) o;
        if (!this.loadedCompilationUnitNames.equals(other.loadedCompilationUnitNames))
            return false;
        if (!this.filter.equals(other.filter))
            return false;
        return true;
    }

    @Override
    protected int hashCodePart()
    {
        return super.hashCodePart() ^ this.loadedCompilationUnitNames.hashCode();
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
