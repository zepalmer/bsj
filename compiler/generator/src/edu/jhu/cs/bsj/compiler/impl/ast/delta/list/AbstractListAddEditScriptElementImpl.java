package edu.jhu.cs.bsj.compiler.impl.ast.delta.list;

/**
 * Indicates that a node should be added before another node in the list.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractListAddEditScriptElementImpl extends AbstractListEditScriptElementImpl
{
    private long newId;
    private boolean ordered;
    private int newOccurrenceCount;
    private Long memberId;
    private int memberOccurrenceCount;

    public AbstractListAddEditScriptElementImpl(int metaprogramId, long targetId, long newId, boolean ordered,
            int newOccurrenceCount, Long memberId, int memberOccurrenceCount)
    {
        super(metaprogramId, targetId);
        this.newId = newId;
        this.ordered = ordered;
        this.newOccurrenceCount = newOccurrenceCount;
        this.memberId = memberId;
        this.memberOccurrenceCount = memberOccurrenceCount;
    }

    public long getNewId()
    {
        return newId;
    }

    public boolean isOrdered()
    {
        return ordered;
    }

    public int getNewOccurrenceCount()
    {
        return newOccurrenceCount;
    }

    public Long getMemberId()
    {
        return memberId;
    }

    public int getMemberOccurrenceCount()
    {
        return memberOccurrenceCount;
    }

    protected abstract String directionString();

    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + "+" + (isOrdered() ? "@" : "")
                + describeElement(getNewId(), getNewOccurrenceCount()) + directionString()
                + describeElement(getMemberId(), getMemberOccurrenceCount()) + "]";
    }
}
