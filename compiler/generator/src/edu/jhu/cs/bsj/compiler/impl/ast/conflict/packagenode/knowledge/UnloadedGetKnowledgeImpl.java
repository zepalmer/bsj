package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.UnloadedGetKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities;

public class UnloadedGetKnowledgeImpl extends AbstractGetKnowledgeImpl implements UnloadedGetKnowledge
{
    public UnloadedGetKnowledgeImpl(KnowledgeSource source, int id, String name, CompilationUnitNode value)
    {
        super(source, id, name, value);
    }

    @Override
    protected String getLeftDelimiterString()
    {
        return KnowledgeBaseUtilities.INVARIANT_LEFT;
    }

    @Override
    protected String getRightDelimiterString()
    {
        return KnowledgeBaseUtilities.INVARIANT_RIGHT;
    }

    @Override
    protected String getOperatorString()
    {
        return KnowledgeBaseUtilities.GET_UNLOADED + KnowledgeBaseUtilities.MAPS_TO;
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
