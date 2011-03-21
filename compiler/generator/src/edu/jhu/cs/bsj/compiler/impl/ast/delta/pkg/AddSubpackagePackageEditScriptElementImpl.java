package edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState.SubpackageRelationship;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState.SubpackageRelationship.Type;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

public class AddSubpackagePackageEditScriptElementImpl extends AbstractPackageEditScriptElementImpl
{
    private long subpackageId;

    public AddSubpackagePackageEditScriptElementImpl(int metaprogramId, long targetId, long subpackageId)
    {
        super(metaprogramId, targetId);
        this.subpackageId = subpackageId;
    }

    @Override
    public void apply(PatchState patchState)
    {
        long targetId = this.getTargetId();
        if (patchState.getImplicitPackageEquivalenceMap().containsKey(targetId))
        {
            targetId = patchState.getImplicitPackageEquivalenceMap().get(targetId);
        }
        PackageNode pkg = (PackageNode) patchState.getNode(targetId);
        PackageNode spkg = (PackageNode) patchState.getNode(this.getSubpackageId());
        pkg.addPackage(spkg);

        // Record the relationship for conflict detection
        final String subpackageName = spkg.getName().getIdentifier();
        SubpackageRelationship relationship = patchState.getSubpackageRelationshipMap().get(
                new Pair<Long, String>(this.getTargetId(), subpackageName));
        if (relationship != null)
        {
            // TODO: raise an appropriate conflict diagnostic exception
            throw new NotImplementedYetException();
        }
        relationship = new SubpackageRelationship(getTargetId(), subpackageName, Type.EXPLICIT);
        patchState.getSubpackageRelationshipMap().put(new Pair<Long, String>(getTargetId(), subpackageName),
                relationship);
        relationship.getMetaprogramIds().add(getMetaprogramId());
    }

    public long getSubpackageId()
    {
        return this.subpackageId;
    }

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "+pkg=#" + getSubpackageId();
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new AddSubpackagePackageEditScriptElementImpl(getMetaprogramId(), translateUid(translationState,
                getTargetId()), translateUid(translationState, getSubpackageId()));
    }
}
