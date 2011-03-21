package edu.jhu.cs.bsj.compiler.impl.ast.delta;

public abstract class AbstractEditScriptElementImpl implements EditScriptElement
{
    private int metaprogramId;
    private long targetId;

    public AbstractEditScriptElementImpl(int metaprogramId, long targetId)
    {
        super();
        this.metaprogramId = metaprogramId;
        this.targetId = targetId;
    }

    @Override
    public int getMetaprogramId()
    {
        return metaprogramId;
    }

    @Override
    public long getTargetId()
    {
        return targetId;
    }

    @Override
    public abstract String toString();

    protected Long translateUid(TranslationState translationState, Long uid)
    {
        if (uid == null)
        {
            return uid;
        } else if (translationState.getUidMap().containsKey(uid))
        {
            return translationState.getUidMap().get(uid);
        } else if (translationState.getInstantiations().contains(uid))
        {
            return uid;
        } else
        {
            throw new IllegalArgumentException("Unrecognized UID " + uid
                    + " is not in translation map and not instantiated.");
        }
    }
}
