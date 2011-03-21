package edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;

public class AddCompilationUnitPackageEditScriptElementImpl extends AbstractPackageEditScriptElementImpl
{
    private long compilationUnitId;

    public AddCompilationUnitPackageEditScriptElementImpl(int metaprogramId, long targetId, long compilationUnitId)
    {
        super(metaprogramId, targetId);
        this.compilationUnitId = compilationUnitId;
    }

    @Override
    public void apply(PatchState patchState)
    {
        // TODO: in case of a conflict, an exception is thrown here - catch it and give it more semantic value
        PackageNode pkg = (PackageNode) patchState.getNode(this.getTargetId());
        CompilationUnitNode compilationUnitNode = (CompilationUnitNode) patchState.getNode(
                this.getCompilationUnitId());
        pkg.addCompilationUnit(compilationUnitNode);
    }

    public long getCompilationUnitId()
    {
        return compilationUnitId;
    }

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "+cu=#" + getCompilationUnitId();
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new AddCompilationUnitPackageEditScriptElementImpl(getMetaprogramId(), translateUid(translationState,
                getTargetId()), translateUid(translationState, getCompilationUnitId()));
    }
}
