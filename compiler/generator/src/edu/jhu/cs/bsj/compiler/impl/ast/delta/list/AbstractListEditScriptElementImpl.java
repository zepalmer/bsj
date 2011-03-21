package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;

public abstract class AbstractListEditScriptElementImpl extends AbstractEditScriptElementImpl
{
    public AbstractListEditScriptElementImpl(int metaprogramId, long targetId)
    {
        super(metaprogramId, targetId);
    }

    @Override
    public void apply(PatchState patchState)
    {
        // doing this to convince the Java type system that we actually know what type of element is in the list
        // as long as the map is coherent, this is sound
        ListNode<?> listNode = (ListNode<?>) patchState.getNode(this.getTargetId());
        applyActual(listNode, patchState);
    }

    protected abstract <T extends Node> void applyActual(ListNode<T> listNode, PatchState patchState);

    protected static String describeElement(Long uid, int occurrence)
    {
        if (uid==null)
        {
            if (occurrence == ShadowList.HEAD_OCCURRENCE)
            {
                return "\u25b9"; // ▹
            } else if (occurrence == ShadowList.TAIL_OCCURRENCE)
            {
                return "\u25c3"; // ◃
            } else
            {
                return "??" + occurrence + "??";
            }
        } else
        {
            return "#" + ((occurrence == 1) ? String.valueOf(uid) : (String.valueOf(uid) + ":" + occurrence));
        }
    }
}
