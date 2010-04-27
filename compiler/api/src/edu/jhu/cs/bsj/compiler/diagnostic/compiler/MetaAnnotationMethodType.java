package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

/**
 * Enumerates the types of methods on a meta-annotation about which diagnostics are reported.
 * @author Zachary Palmer
 */
public enum MetaAnnotationMethodType
{	
	GETTER("bsj.string.MetaAnnotationMethodType.GETTER"),
	SETTER("bsj.string.MetaAnnotationMethodType.SETTER");
	
	private String code;
	
	private MetaAnnotationMethodType(String code)
	{
		this.code = code;
	}

	/**
	 * Retrieves the code for the string describing this object.
	 */
	public String getCode()
	{
		return code;
	}
}
