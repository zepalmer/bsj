package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;

public class ListAddAfterEditScriptElementImpl extends AbstractListAddEditScriptElementImpl
{
    public ListAddAfterEditScriptElementImpl(int metaprogramId, long targetId, long newId, boolean ordered, int newOccurrenceCount,
            Long memberId, int memberOccurrenceCount)
    {
        super(metaprogramId, targetId, newId, ordered, newOccurrenceCount, memberId, memberOccurrenceCount);
    }

    @Override
    protected String directionString()
    {
        return ">";
    }

    @Override
    protected <T extends Node> void applyActual(ListNode<T> listNode, PatchState patchState)
    {
        ShadowList shadowList = patchState.getShadowListFor(this.getTargetId());
        Long uid = shadowList.addAfter(getMetaprogramId(), getNewId(), isOrdered(), getNewOccurrenceCount(), getMemberId(),
                getMemberOccurrenceCount());

        // This @SuppressWarnings is sound as long as the map is coherent. See EditScriptElement for more details.
        @SuppressWarnings("unchecked")
        T element = (T) patchState.getNode(getNewId());
        if (element == null)
        {
            throw new IllegalStateException("Could not find node UID " + getNewId() + " in node map.");
        }
        if (uid == null)
        {
            listNode.addFirst(element);
        } else
        {
            // This @SuppressWarnings is sound as long as the map is coherent. See EditScriptElement for more details.
            @SuppressWarnings("unchecked")
            T member = (T) patchState.getNode(uid);
            if (member == null)
            {
                throw new IllegalStateException("Could not find node UID " + uid + " in node map.");
            }
            listNode.addAfter(member, element);
        }
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new ListAddAfterEditScriptElementImpl(
                getMetaprogramId(), translateUid(translationState, getTargetId()),
                translateUid(translationState, getNewId()), isOrdered(), getNewOccurrenceCount(),
                translateUid(translationState, getMemberId()), getMemberOccurrenceCount());
    }
}
