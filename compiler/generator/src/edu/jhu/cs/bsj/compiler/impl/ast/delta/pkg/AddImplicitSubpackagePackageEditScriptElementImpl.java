package edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg;

import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState.SubpackageRelationship;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState.SubpackageRelationship.Type;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/**
 * Used to represent the subpackage addition which occurs when a user calls {@link PackageNode#getSubpackage(String)}
 * using a subpackage which does not exist. This is distinct because two metaprograms doing this can be merged since we
 * know that both of the subpackages were empty when they were created.
 * 
 * @author Zachary Palmer
 */
public class AddImplicitSubpackagePackageEditScriptElementImpl extends AbstractPackageEditScriptElementImpl
{
    private long subpackageId;
    private String subpackageName;

    public AddImplicitSubpackagePackageEditScriptElementImpl(int metaprogramId, long targetId, long subpackageId,
            String subpackageName)
    {
        super(metaprogramId, targetId);
        this.subpackageId = subpackageId;
        this.subpackageName = subpackageName;
    }

    @Override
    public void apply(PatchState patchState)
    {
        PackageNode pkg = (PackageNode) patchState.getNode(this.getTargetId());
        PackageNode spkg = pkg.getSubpackage(this.subpackageName);

        // Record the relationship for conflict detection
        SubpackageRelationship relationship = patchState.getSubpackageRelationshipMap().get(
                new Pair<Long, String>(this.getTargetId(), this.subpackageName));
        if (relationship != null)
        {
            if (relationship.getType() == Type.EXPLICIT)
            {
                // TODO: raise an appropriate conflict diagnostic exception
                throw new NotImplementedYetException();
            }
        } else
        {
            relationship = new SubpackageRelationship(getTargetId(), getSubpackageName(), Type.IMPLICIT);
            patchState.getSubpackageRelationshipMap().put(new Pair<Long, String>(getTargetId(), getSubpackageName()),
                    relationship);
        }
        relationship.getMetaprogramIds().add(getMetaprogramId());
        
        // If this is the first implicit add to be processed against this package-subpackage pair, record the subpackage
        // node as the authorative representation.  If it is not, relate the UID from this element to the UID of the
        // element that got here first so that future operations against this element's UID will translate properly.
        Long equivalentUid = patchState.getRepresentedUid(spkg);
        if (equivalentUid != null)
        {
            patchState.getImplicitPackageEquivalenceMap().put(this.getSubpackageId(), equivalentUid);
        } else
        {
            patchState.addNode(this.getSubpackageId(), spkg);
        }
    }

    public long getSubpackageId()
    {
        return this.subpackageId;
    }

    public String getSubpackageName()
    {
        return subpackageName;
    }

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "+(pkg)=#" + getSubpackageId();
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getSubpackageId());
        return new AddImplicitSubpackagePackageEditScriptElementImpl(getMetaprogramId(), translateUid(translationState,
                getTargetId()), translateUid(translationState, getSubpackageId()), getSubpackageName());
    }
}
