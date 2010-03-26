package edu.jhu.cs.bsj.compiler.metaannotation;

/**
 * This exception is thrown by a meta-annotation object when it is improperly configured.
 * @author Zachary Palmer
 */
public class InvalidMetaAnnotationConfigurationException extends Exception
{
	// TODO: introduce a way in which the message produced by the diagnostic that this exception triggers could be
	// specified by the thrower
	
	private static final long serialVersionUID = 1L;
	
	/** The object which was improperly configured. */
	private BsjMetaAnnotation annotation;

	public InvalidMetaAnnotationConfigurationException(BsjMetaAnnotation annotation)
	{
		super();
		this.init(annotation);
	}

	public InvalidMetaAnnotationConfigurationException(BsjMetaAnnotation annotation, String message, Throwable cause)
	{
		super(message, cause);
		this.init(annotation);
	}

	public InvalidMetaAnnotationConfigurationException(BsjMetaAnnotation annotation, String message)
	{
		super(message);
		this.init(annotation);
	}

	public InvalidMetaAnnotationConfigurationException(BsjMetaAnnotation annotation, Throwable cause)
	{
		super(cause);
		this.init(annotation);
	}
	
	private void init(BsjMetaAnnotation annotation)
	{
		this.annotation = annotation;
	}

	public BsjMetaAnnotation getAnnotation()
	{
		return annotation;
	}
}
