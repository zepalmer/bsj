package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import java.util.HashSet;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

public class PackageCompilationUnitsAttribute extends AbstractAttribute<PackageCompilationUnitsAttribute.AccessType>
{
    public PackageCompilationUnitsAttribute(NodeImpl node)
    {
        super(node, new StringName("<compilationUnits>"));
    }
    
    /**
     * Records a get for the specified compilation unit name for the current metaprogram.  If no metaprogram is
     * running, this operation does nothing.
     * @param unitName The compilation unit which was accessed.
     */
    public void recordGetAccess(String unitName)
    {
        if (this.node.getManager().getCurrentMetaprogramId() == null)
            return;
        super.recordAccess(new GetAccessType(unitName, currentMetaprogramHasLoaded(unitName)));
    }
    
    /**
     * Records a load for the specified compilation unit name for the current metaprogram.  If no metaprogram is
     * running, this operation does nothing.
     * @param unitName The compilation unit which was accessed.
     * @param successful <code>true</code> if the load was successful; <code>false</code> if it was not.
     */
    public void recordLoadAccess(String unitName, boolean successful)
    {
        if (this.node.getManager().getCurrentMetaprogramId() == null)
            return;
        super.recordAccess(new LoadAccessType(unitName, successful));
    }

    /**
     * Records a put for the specified compilation unit name for the current metaprogram.  If no metaprogram is
     * running, this operation does nothing.
     * @param unitName The compilation unit which was accessed.
     */
    public void recordPutAccess(String unitName)
    {
        if (this.node.getManager().getCurrentMetaprogramId() == null)
            return;
        super.recordAccess(new PutAccessType(unitName));
    }

    /**
     * Records an iteration for the specified compilation unit name for the current metaprogram.  If no metaprogram is
     * running, this operation does nothing.
     */
    public void recordIteratorAccess()
    {
        if (this.node.getManager().getCurrentMetaprogramId() == null)
            return;
        super.recordAccess(new IteratorAccessType(getCurrentMetaprogramLoads()));
    }

    /**
     * Determines whether or not the current metaprogram has already loaded a compilation unit of the specified name.
     */
    public boolean currentMetaprogramHasLoaded(String unitName)
    {
        int currentMetaprogramID = this.node.getManager().getCurrentMetaprogramId();
        for (AccessRecord<AccessType> record : super.accessRecords)
        {
            if (record.getMetaprogramId() == currentMetaprogramID && record.getType() instanceof LoadAccessType
                    && ((LoadAccessType) record.getType()).getUnitName().equals(unitName))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtains a set of all compilation unit names which have been loaded by the current metaprogram.
     */
    public Set<String> getCurrentMetaprogramLoads()
    {
        Set<String> loads = new HashSet<String>();
        int currentMetaprogramID = this.node.getManager().getCurrentMetaprogramId();
        for (AccessRecord<AccessType> record : super.accessRecords)
        {
            if (record.getMetaprogramId() == currentMetaprogramID && record.getType() instanceof LoadAccessType)
            {
                loads.add(((LoadAccessType) record.getType()).getUnitName());
            }
        }
        return loads;
    }

    /**
     * Represents the access of a compilation unit or set of compilation units through some operation.
     * 
     * @author Zachary Palmer
     */
    public static interface AccessType extends edu.jhu.cs.bsj.compiler.impl.ast.attribute.AccessType<AccessType>
    {
    }

    /**
     * Represents the access of a given compilation unit through a basic operation, such as get, put, or load.
     * 
     * @author Zachary Palmer
     */
    public static abstract class BasicOperationAccessType implements AccessType
    {
        private String unitName;

        public BasicOperationAccessType(String unitName)
        {
            super();
            this.unitName = unitName;
        }

        public String getUnitName()
        {
            return unitName;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
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
            BasicOperationAccessType other = (BasicOperationAccessType) obj;
            if (unitName == null)
            {
                if (other.unitName != null)
                    return false;
            } else if (!unitName.equals(other.unitName))
                return false;
            return true;
        }
    }

    /**
     * Represents a get operation for a specified compilation unit.
     * 
     * @author Zachary Palmer
     */
    public static final class GetAccessType extends BasicOperationAccessType
    {
        private boolean loadedBeforeGet;

        public GetAccessType(String unitName, boolean loadedBeforeGet)
        {
            super(unitName);
            this.loadedBeforeGet = loadedBeforeGet;
        }

        public boolean isLoadedBeforeGet()
        {
            return loadedBeforeGet;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + (loadedBeforeGet ? 1231 : 1237);
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (!super.equals(obj))
                return false;
            if (getClass() != obj.getClass())
                return false;
            GetAccessType other = (GetAccessType) obj;
            if (loadedBeforeGet != other.loadedBeforeGet)
                return false;
            return true;
        }

        @Override
        public boolean conflicts(AccessType other)
        {
            if (other instanceof GetAccessType)
            {
                return false;
            } else
            {
                return other.conflicts(this);
            }
        }

        @Override
        public String toString()
        {
            return (this.loadedBeforeGet ? "getLoaded" : "getUnloaded") + "(" + getUnitName() + ")";
        }
    }

    /**
     * Represents a load operation for a specified compilation unit.
     * 
     * @author Zachary Palmer
     */
    public static final class LoadAccessType extends BasicOperationAccessType
    {
        /** Indicates whether or not the load was successful. */
        private boolean success;
        
        public LoadAccessType(String unitName, boolean success)
        {
            super(unitName);
            this.success = success;
        }

        public boolean isSuccess()
        {
            return success;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = super.hashCode();
            result = prime * result + (success ? 1231 : 1237);
            return result;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (!super.equals(obj))
                return false;
            if (getClass() != obj.getClass())
                return false;
            LoadAccessType other = (LoadAccessType) obj;
            if (success != other.success)
                return false;
            return true;
        }

        @Override
        public boolean conflicts(AccessType other)
        {
            if (other instanceof GetAccessType)
            {
                GetAccessType o = (GetAccessType) other;
                if (!o.getUnitName().equals(this.getUnitName()))
                    return false;
                if (o.isLoadedBeforeGet())
                    return false;
                if (!this.success)
                    return false;
                return true;
            } else if (other instanceof LoadAccessType)
            {
                return false;
            } else
            {
                return other.conflicts(this);
            }
        }

        @Override
        public String toString()
        {
            return "load(" + getUnitName() + ")";
        }
    }

    /**
     * Represents a put operation for a specified compilation unit.
     * 
     * @author Zachary Palmer
     */
    public static final class PutAccessType extends BasicOperationAccessType
    {
        public PutAccessType(String unitName)
        {
            super(unitName);
        }

        @Override
        public boolean conflicts(AccessType other)
        {
            if (other instanceof BasicOperationAccessType)
            {
                BasicOperationAccessType o = (BasicOperationAccessType) other;
                return (o.getUnitName().equals(this.getUnitName()));
            } else
            {
                return other.conflicts(this);
            }
        }

        @Override
        public String toString()
        {
            return "put(" + getUnitName() + ")";
        }
    }

    /**
     * Represents the access of the package's compilation unit iterator.
     * 
     * @author Zachary Palmer
     */
    public static final class IteratorAccessType implements AccessType
    {
        /** The compilation units that this metaprogram had loaded by the time this access occurred. */
        private Set<String> loadedUnits;

        public IteratorAccessType(Set<String> loadedUnits)
        {
            super();
            this.loadedUnits = loadedUnits;
        }

        public Set<String> getLoadedUnits()
        {
            return loadedUnits;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((loadedUnits == null) ? 0 : loadedUnits.hashCode());
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
            IteratorAccessType other = (IteratorAccessType) obj;
            if (loadedUnits == null)
            {
                if (other.loadedUnits != null)
                    return false;
            } else if (!loadedUnits.equals(other.loadedUnits))
                return false;
            return true;
        }

        @Override
        public boolean conflicts(AccessType other)
        {
            if (other instanceof GetAccessType)
            {
                return false;
            } else if (other instanceof LoadAccessType)
            {
                LoadAccessType o = (LoadAccessType) other;
                return o.isSuccess() && !this.loadedUnits.contains(o.getUnitName());
            } else if (other instanceof PutAccessType)
            {
                return true;
            } else if (other instanceof IteratorAccessType)
            {
                return false;
            } else
            {
                throw new IllegalStateException("Don't know how to calculate conflict with type "
                        + other.getClass().getName());
            }
        }

        @Override
        public String toString()
        {
            return "iterator(" + StringUtilities.join(this.loadedUnits, ",") + ")";
        }
    }
}
