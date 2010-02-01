package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

public class FileObjectPair
{
	private String packageName;
	
	private String relativeName;

	public FileObjectPair(String packageName, String relativeName)
	{
		super();
		this.packageName = packageName;
		this.relativeName = relativeName;
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
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result
				+ ((relativeName == null) ? 0 : relativeName.hashCode());
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
		FileObjectPair other = (FileObjectPair) obj;
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
