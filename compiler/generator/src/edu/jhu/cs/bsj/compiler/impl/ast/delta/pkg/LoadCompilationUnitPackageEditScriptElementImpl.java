package edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;

public class LoadCompilationUnitPackageEditScriptElementImpl extends AbstractPackageEditScriptElementImpl
{
    private Long loadedId;
    private String name;

    public LoadCompilationUnitPackageEditScriptElementImpl(int metaprogramId, long targetId, Long loadedId, String name)
    {
        super(metaprogramId, targetId);
        this.loadedId = loadedId;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Long getLoadedId()
    {
        return loadedId;
    }

    @Override
    public void apply(PatchState patchState)
    {
        // TODO: in case of a conflict, an exception is thrown here - catch it and give it more semantic value
        // either that or just detect it independently :-P
        PackageNode pkg = (PackageNode) patchState.getNode(this.getTargetId());
        pkg.loadCompilationUnit(getName(), patchState.getCompilationUnitLoadingInfo());
    }

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "+cu=" + getName();
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        // Add the UID of the loaded node here to prevent confusion if it is later modified.
        translationState.getInstantiations().add(this.loadedId);
        return new LoadCompilationUnitPackageEditScriptElementImpl(getMetaprogramId(), translateUid(translationState,
                getTargetId()), translateUid(translationState, this.loadedId), getName());

    }
}
