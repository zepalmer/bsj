package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

public abstract class AbstractLoadKnowledgeImpl extends AbstractSingleElementPackageKnowledgeImpl
{
    public AbstractLoadKnowledgeImpl(KnowledgeSource source, int id, String name, CompilationUnitNode value)
    {
        super(source, id, name, value);
    }
}
