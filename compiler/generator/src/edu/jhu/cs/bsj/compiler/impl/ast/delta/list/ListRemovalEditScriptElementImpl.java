package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;

/**
 * Indicates that a node should be removed from the list.
 * 
 * @author Zachary Palmer
 */
public class ListRemovalEditScriptElementImpl extends AbstractListEditScriptElementImpl
{
    private long removalId;
    private int occurrenceCount;

    public ListRemovalEditScriptElementImpl(int metaprogramId, long targetId, long removalId, int occurrenceCount)
    {
        super(metaprogramId, targetId);
        this.removalId = removalId;
        this.occurrenceCount = occurrenceCount;
    }

    public long getRemovalId()
    {
        return removalId;
    }

    public int getOccurrenceCount()
    {
        return occurrenceCount;
    }

    @Override
    protected <T extends Node> void applyActual(ListNode<T> listNode, PatchState patchState)
    {
        ShadowList shadowList = patchState.getShadowListFor(this.getTargetId());
        shadowList.remove(getMetaprogramId(), getRemovalId(), getOccurrenceCount());

        // This @SuppressWarnings is sound as long as the map is coherent. See EditScriptElement for more details.
        @SuppressWarnings("unchecked")
        T element = (T) patchState.getNode(getRemovalId());
        Iterator<NodeUnion<? extends T>> it = listNode.getUnionForChildren().iterator();
        boolean removed = false;
        while (it.hasNext())
        {
            NodeUnion<? extends T> union = it.next();
            if (element.equals(union.getNodeValue()))
            {
                it.remove();
                removed = true;
                break;
            }
        }
        if (!removed)
            throw new IllegalStateException("Element was not present!");
    }

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "-"
                + describeElement(getRemovalId(), getOccurrenceCount());
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new ListRemovalEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()),
                translateUid(translationState, getRemovalId()), getOccurrenceCount());
    }
}
