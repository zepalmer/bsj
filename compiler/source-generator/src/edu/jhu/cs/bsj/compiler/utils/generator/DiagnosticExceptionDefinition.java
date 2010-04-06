package edu.jhu.cs.bsj.compiler.utils.generator;

/**
 * Represents the definition of a diagnostic exception.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticExceptionDefinition
{
	/** The doc string associated with this exception. */
	private String docString;
	/** The name of the property on the diagnostic in which the corresponding exception is stored. */
	private String property;

	public DiagnosticExceptionDefinition(String docString, String property)
	{
		super();
		this.docString = docString;
		this.property = property;
	}

	public String getDocString()
	{
		return docString;
	}

	public String getProperty()
	{
		return property;
	}
}
