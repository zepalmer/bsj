/* GEN:headerstart */
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.metaannotation.*;
/* GEN:headerstop */

public interface MetaAnnotationNode
{
	/* GEN:start */
	/**
	 * This method instantiates the meta-annotation object represented by this node.  If this call terminates normally,
	 * the {@link #getMetaAnnotationObject()} method will return a valid object of the appropriate type.  If this
	 * node already has an associated meta-annotation object, a call to this method will do nothing and terminate
	 * normally.  This method is typically used by the BSJ compiler to instantiate meta-annotation objects; normal
	 * metaprogram execution has no reason to invoke this method.
	 * @param listener The listener to which diagnostics should be reported.
	 * @throws MetaAnnotationInstantiationFailureException If instantiation of the meta-annotation object fails.
	 */
	public void instantiateMetaAnnotationObject(DiagnosticListener<BsjSourceLocation> listener)
		throws MetaAnnotationInstantiationFailureException;
	
	/**
	 * Retrieves the meta-annotation object for this node.
	 * @throws IllegalStateException If the annotation object has not yet been instantiated.
	 */
	public BsjMetaAnnotation getMetaAnnotationObject();
	/* GEN:stop */
}