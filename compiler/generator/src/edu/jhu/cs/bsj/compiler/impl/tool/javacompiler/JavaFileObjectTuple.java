package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject.Kind;

public class JavaFileObjectTuple
{
    private Location location; 
    private String className;
    private Kind kind;
    
    public JavaFileObjectTuple(Location location, String className, Kind kind)
    {
        super();
        this.location = location;
        this.className = className;
        this.kind = kind;
    }

    /**
     * @return the location
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * @return the className
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return the kind
     */
    public Kind getKind()
    {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(Kind kind)
    {
        this.kind = kind;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((className == null) ? 0 : className.hashCode());
        result = prime * result + ((kind == null) ? 0 : kind.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaFileObjectTuple other = (JavaFileObjectTuple) obj;
        if (className == null)
        {
            if (other.className != null)
                return false;
        } else if (!className.equals(other.className))
            return false;
        if (kind == null)
        {
            if (other.kind != null)
                return false;
        } else if (!kind.equals(other.kind))
            return false;
        if (location == null)
        {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        return true;
    }    
}
