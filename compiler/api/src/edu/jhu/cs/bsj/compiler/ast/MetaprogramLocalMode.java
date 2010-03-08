package edu.jhu.cs.bsj.compiler.ast;

/**
 * An enumeration of the legal metaprogram local modes.
 * @author Zachary Palmer
 */
public enum MetaprogramLocalMode
{
	READ_ONLY("readOnly"),
	INSERT("insert"),
	MUTATE("mutate"),
	FULL_MUTATE("fullMutate"),
	;
	
	private String string;

	private MetaprogramLocalMode(String string)
	{
		this.string = string;
	}
	
	public String toString()
	{
		return string;
	}
}
