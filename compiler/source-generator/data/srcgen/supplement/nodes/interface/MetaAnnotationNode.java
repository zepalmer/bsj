/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.metaannotation.*;
/* GEN:headerstop */

public interface MetaAnnotationNode
{
	/* GEN:start */
	/**
	 * This method instantiates the meta-annotation object represented by this node.  If this call terminates normally,
	 * the {@link #getMetaAnnotationObject()} method will return a valid object of the appropriate type.  If this
	 * node already has an associated meta-annotation object, a call to this method will do nothing and terminate
	 * normally.
	 */
	public void instantiateMetaAnnotationObject();
	
	/**
	 * Retrieves the meta-annotation object for this node.
	 * @throws IllegalStateException If the annotation object has not yet been instantiated.
	 */
	public BsjMetaAnnotation getMetaAnnotationObject();
	/* GEN:stop */
}