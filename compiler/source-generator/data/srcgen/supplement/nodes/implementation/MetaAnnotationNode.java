/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.metaannotation.*;
/* GEN:headerstop */

public class MetaAnnotationNodeImpl implements MetaAnnotationNode
{
	/* GEN:start */
	/**
	 * The meta-annotation object represented by this AST node.
	 */
	private BsjMetaAnnotation metaAnnotationObject = null;
	
	/**
	 * {@inheritDoc}
	 */
	public void instantiateMetaAnnotationObject()
	{
		if (this.metaAnnotationObject == null)
		{
			this.metaAnnotationObject = getManager().instantiateMetaAnnotationObject(this);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BsjMetaAnnotation getMetaAnnotationObject()
	{
		return this.metaAnnotationObject;
	}
	/* GEN:stop */
}