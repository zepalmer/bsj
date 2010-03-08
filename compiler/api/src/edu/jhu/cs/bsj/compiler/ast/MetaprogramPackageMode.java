package edu.jhu.cs.bsj.compiler.ast;

/**
 * An enumeration of legal metaprogram package modes.
 * @author Zachary Palmer
 */
public enum MetaprogramPackageMode
{
	READ_ONLY("packageRead"),
	INSERT("packageInsert"),
	;
	
	private String string;

	private MetaprogramPackageMode(String string)
	{
		this.string = string;
	}
	
	public String toString()
	{
		return string;
	}
}
