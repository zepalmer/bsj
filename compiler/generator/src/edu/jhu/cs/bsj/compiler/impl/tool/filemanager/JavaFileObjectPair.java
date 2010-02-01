package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import javax.tools.JavaFileObject.Kind;

public class JavaFileObjectPair
{
	private String className;
	
	private Kind kind;

	public JavaFileObjectPair(String className, Kind kind)
	{
		super();
		this.className = className;
		this.kind = kind;
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
		result = prime * result
				+ ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
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
		JavaFileObjectPair other = (JavaFileObjectPair) obj;
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
		return true;
	}
}
