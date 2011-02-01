package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

/**
 * A base class for attributes containing common functionality.
 * 
 * @param <T> The type of access which is recorded.
 * @author Zachary Palmer
 */
public abstract class AbstractAttribute<T extends AccessType<T>> implements Attribute<T>
{
    /** The record of accesses for this attribute. */
    protected Set<AccessRecord<T>> accessRecords;
    /** The node for which this attribute is being tracked. */
    protected NodeImpl node;
    /** The name for which this attribute was created. */
    protected AttributeName name;

    public AbstractAttribute(NodeImpl node, AttributeName name)
    {
        super();
        this.accessRecords = new HashSet<AccessRecord<T>>(0);
        this.node = node;
        this.name = name;
    }

    @Override
    public void recordAccess(T type) throws MetaprogramAttributeConflictException
    {
        recordAccess(type, this.node.getManager().getCurrentMetaprogramId());
    }

    @Override
    public void recordAccess(T type, Integer metaprogramId) throws MetaprogramAttributeConflictException
    {
        if (metaprogramId == null)
        {
            return;
        }
        for (AccessRecord<T> record : this.accessRecords)
        {
            if (type.conflicts(record.getType()))
            {
                this.node.getManager().assertOrdering(record.getMetaprogramId(), this.node, this, type,
                        record.getType());
            }
        }
        this.accessRecords.add(new AccessRecord<T>(type, metaprogramId));
    }

    /**
     * A container for access records.
     * 
     * @param <T> The type of access recorded.
     */
    protected static class AccessRecord<T extends AccessType<T>>
    {
        /** The type of access. */
        private T type;
        /** The metaprogram performing the access. */
        private Integer metaprogramId;

        public AccessRecord(T type, Integer metaprogramId)
        {
            super();
            this.type = type;
            this.metaprogramId = metaprogramId;
        }

        public T getType()
        {
            return type;
        }

        public Integer getMetaprogramId()
        {
            return metaprogramId;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((metaprogramId == null) ? 0 : metaprogramId.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AccessRecord<?> other = (AccessRecord<?>) obj;
            if (metaprogramId == null)
            {
                if (other.metaprogramId != null)
                    return false;
            } else if (!metaprogramId.equals(other.metaprogramId))
                return false;
            if (type == null)
            {
                if (other.type != null)
                    return false;
            } else if (!type.equals(other.type))
                return false;
            return true;
        }

        @Override
        public String toString()
        {
            return "AccessRecord [type=" + type + ", metaprogramId=" + metaprogramId + "]";
        }

    }

    @Override
    public String getName()
    {
        return this.name.toString();
    }
}
