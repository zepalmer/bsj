package edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg;

import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractEditScriptElementImpl;

public abstract class AbstractPackageEditScriptElementImpl extends AbstractEditScriptElementImpl
{
    public AbstractPackageEditScriptElementImpl(int metaprogramId, long targetId)
    {
        super(metaprogramId, targetId);
    }
}
