package edu.jhu.cs.bsj.compiler.metaannotation;

/**
 * Classes implementing this interface can be used as meta-annotations in the BSJ language.
 * 
 * @author Zachary Palmer
 */
public interface BsjMetaAnnotation
{
	/**
	 * Indicates to the meta-annotation object that configuration is complete. This method can be used to validate the
	 * elements that have been declared on this meta-annotation reference.
	 * 
	 * @throws InvalidMetaAnnotationConfigurationException If the configuration of this meta-annotation object is
	 *             invalid.  The definition of "invalid" in this context is dependent upon the meta-annotation.
	 */
	public void complete() throws InvalidMetaAnnotationConfigurationException;
}
