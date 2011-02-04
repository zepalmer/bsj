package edu.jhu.cs.bsj.compiler.impl.ast.conflict.knowledge;

import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.Knowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.KnowledgeSource;

public abstract class AbstractKnowledgeImpl implements Knowledge
{
    private KnowledgeSource source;
    
    public AbstractKnowledgeImpl(KnowledgeSource source)
    {
        super();
        this.source = source;
    }

    @Override
    public KnowledgeSource getSource()
    {
        return this.source;
    }

    @Override
    public abstract String getDescription();

    @Override
    public String toString()
    {
        return getDescription();
    }
    
    @Override
    public abstract boolean equals(Object o);
    
    @Override
    public abstract int hashCode();
    
    /**
     * Implements part of the equals routine for this type.  Abstract subtypes are encouraged to override this method,
     * calling this supertype implementation and then adding their own logic.  Concrete types should call this method
     * from their equals implementations.
     * @param o The object to check for equality.
     * @return <code>true</code> if the objects are equal; <code>false</code> if they are not.
     */
    protected boolean equalsPart(Object o)
    {
        if (!(o instanceof AbstractKnowledgeImpl))
            return false;
       
        return true;
    }
    
    /**
     * Implements part of the hashCode routine for this type.  Abstract subtypes are encouraged to override this method,
     * calling this supertype implementation and then adding their own logic.  Concrete types should call this method
     * from their hashCode implementations.
     * @return A partial hash code for this object.
     */
    protected int hashCodePart()
    {
        return 0;
    }
}
