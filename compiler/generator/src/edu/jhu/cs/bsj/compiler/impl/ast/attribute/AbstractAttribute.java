package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.list.knowledge.KnowledgeUtilities;

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
                // TODO: this is a bug - we're assuming that the other metaprogram ID is the currently-running
                // metaprogram even though we were passed a metaprogramId.  Doesn't currently break anything, but needs
                // fixed.
                this.node.getManager().assertOrdering(record.getMetaprogramId(), this.node, this, type,
                        record.getType());
            }
        }
        
        List<StackTraceElement> trace = new ArrayList<StackTraceElement>(KnowledgeUtilities.getStackTrace());
        // delete elements as long as they refer to this class
        while (trace.size() > 0 && trace.get(0).getFileName().endsWith("AbstractAttribute.java"))
        {
            trace.remove(0);
        }
        this.accessRecords.add(new AccessRecord<T>(type, metaprogramId, Collections.unmodifiableList(trace)));
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
        /** The stack trace indicating the source of this record. */
        private List<StackTraceElement> trace;

        public AccessRecord(T type, Integer metaprogramId, List<StackTraceElement> trace)
        {
            super();
            this.type = type;
            this.metaprogramId = metaprogramId;
            this.trace = trace;
        }

        public T getType()
        {
            return type;
        }

        public Integer getMetaprogramId()
        {
            return metaprogramId;
        }

        public List<StackTraceElement> getTrace()
        {
            return trace;
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
