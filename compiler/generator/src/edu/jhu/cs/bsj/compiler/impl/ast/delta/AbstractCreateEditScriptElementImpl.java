package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

public abstract class AbstractCreateEditScriptElementImpl extends AbstractEditScriptElementImpl
{
    public AbstractCreateEditScriptElementImpl(int metaprogramId, long targetId)
    {
        super(metaprogramId, targetId);
    }
    
    public abstract Class<? extends Node> getCreateType();
}
