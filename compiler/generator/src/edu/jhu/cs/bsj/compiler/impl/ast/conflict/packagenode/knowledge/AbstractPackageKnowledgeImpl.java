package edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.PackageKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.knowledge.AbstractKnowledgeImpl;

public abstract class AbstractPackageKnowledgeImpl extends AbstractKnowledgeImpl implements PackageKnowledge
{
    public AbstractPackageKnowledgeImpl(KnowledgeSource source)
    {
        super(source);
    }
}
