package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;

public class ListAddBeforeEditScriptElementImpl extends AbstractListAddEditScriptElementImpl
{
    public ListAddBeforeEditScriptElementImpl(int metaprogramId, long targetId, long newId, boolean ordered,
            int newOccurrenceCount, Long memberId, int memberOccurrenceCount)
    {
        super(metaprogramId, targetId, newId, ordered, newOccurrenceCount, memberId, memberOccurrenceCount);
    }

    @Override
    protected String directionString()
    {
        return "<";
    }

    @Override
    protected <T extends Node> void applyActual(ListNode<T> listNode, PatchState patchState)
    {
        ShadowList shadowList = patchState.getShadowListFor(this.getTargetId());
        Long uid = shadowList.addBefore(getMetaprogramId(), getNewId(), isOrdered(), getNewOccurrenceCount(),
                getMemberId(), getMemberOccurrenceCount());

        // This @SuppressWarnings is sound as long as the map is coherent. See EditScriptElement for more details.
        @SuppressWarnings("unchecked")
        T element = (T) patchState.getNode(getNewId());
        if (uid == null)
        {
            listNode.addFirst(element);
        } else
        {
            // This @SuppressWarnings is sound as long as the map is coherent. See EditScriptElement for more details.
            @SuppressWarnings("unchecked")
            T member = (T) patchState.getNode(uid);
            listNode.addAfter(member, element);
        }
    }

    @Override
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new ListAddBeforeEditScriptElementImpl(getMetaprogramId(),
                translateUid(translationState, getTargetId()), translateUid(translationState, getNewId()), isOrdered(),
                getNewOccurrenceCount(), translateUid(translationState, getMemberId()), getMemberOccurrenceCount());
    }
}
