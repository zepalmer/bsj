package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PutKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.KnowledgeBaseUtilities;

public class PutKnowledgeImpl extends AbstractSingleElementPackageKnowledgeImpl implements PutKnowledge
{
    public PutKnowledgeImpl(KnowledgeSource source, int id, String name, CompilationUnitNode value)
    {
        super(source, id, name, value);
    }

    @Override
    protected String getLeftDelimiterString()
    {
        return KnowledgeBaseUtilities.EFFECT_LEFT;
    }

    @Override
    protected String getRightDelimiterString()
    {
        return KnowledgeBaseUtilities.EFFECT_RIGHT;
    }

    @Override
    protected String getOperatorString()
    {
        return KnowledgeBaseUtilities.MAPS_TO;
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
