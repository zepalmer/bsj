package edu.jhu.cs.bsj.compiler.impl.ast.delta;

import java.util.Set;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramPropertyConflictExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;

/**
 * Represents an edit script element which sets the value of a specific property.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractPropertyEditScriptElementImpl extends AbstractEditScriptElementImpl
{
    private static Logger LOGGER = Logger.getLogger(AbstractPropertyEditScriptElementImpl.class);

    public AbstractPropertyEditScriptElementImpl(int metaprogramId, long targetId)
    {
        super(metaprogramId, targetId);
    }

    public abstract String getPropertyName();

    public abstract NodeProperty getProperty();

    protected void updateProperty(PatchState patchState)
    {
        // First, assert that we are ordered with respect to every metaprogram that has made a change
        Set<Integer> otherMetaprogramIds = patchState.getPropertyUpdatesFor(this.getTargetId(), this.getProperty());
        for (Integer otherMetaprogramId : otherMetaprogramIds)
        {
            if (!patchState.getDependencyManager().checkOrdering(this.getMetaprogramId(), otherMetaprogramId))
            {
                if (LOGGER.isDebugEnabled())
                {
                    LOGGER.debug("Attempted to assert ordering between " + this.getMetaprogramId() + " and "
                            + otherMetaprogramId + " over node " + this.getTargetId() + " and failed.");
                }
                throw new MetaprogramPropertyConflictExceptionImpl(
                        patchState.getDependencyManager().getMetaprogramProfileByID(this.getMetaprogramId()).getAnchor(),
                        patchState.getDependencyManager().getMetaprogramProfileByID(otherMetaprogramId).getAnchor(),
                        patchState.getNode(this.getTargetId()), this.getPropertyName());

            }
        }
        // Then, record our update.
        patchState.addPropertyUpdate(this.getTargetId(), this.getProperty(), this.getMetaprogramId());
    }
}
