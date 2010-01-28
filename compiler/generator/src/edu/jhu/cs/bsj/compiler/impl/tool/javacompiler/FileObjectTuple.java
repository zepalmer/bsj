package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import javax.tools.JavaFileManager.Location;

public class FileObjectTuple
{
    private Location location; 
    private String packageName; 
    private String relativeName;
    
    public FileObjectTuple(Location location, String packageName, String relativeName)
    {
        this.location = location;
        this.packageName = packageName;
        this.relativeName = relativeName;
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
     * @return the packageName
     */
    public String getPackageName()
    {
        return packageName;
    }

    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    /**
     * @return the relativeName
     */
    public String getRelativeName()
    {
        return relativeName;
    }

    /**
     * @param relativeName the relativeName to set
     */
    public void setRelativeName(String relativeName)
    {
        this.relativeName = relativeName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
        result = prime * result + ((relativeName == null) ? 0 : relativeName.hashCode());
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
        FileObjectTuple other = (FileObjectTuple) obj;
        if (location == null)
        {
            if (other.location != null)
                return false;
        } else if (!location.equals(other.location))
            return false;
        if (packageName == null)
        {
            if (other.packageName != null)
                return false;
        } else if (!packageName.equals(other.packageName))
            return false;
        if (relativeName == null)
        {
            if (other.relativeName != null)
                return false;
        } else if (!relativeName.equals(other.relativeName))
            return false;
        return true;
    }
    
    
}
