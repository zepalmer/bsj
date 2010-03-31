/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.metaannotation.*;
import edu.jhu.cs.bsj.compiler.metaprogram.*;
import javax.tools.*;
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
	public void instantiateMetaAnnotationObject(DiagnosticListener<BsjSourceLocation> listener)
		throws MetaAnnotationInstantiationFailureException
	{
		if (this.metaAnnotationObject == null)
		{
			this.metaAnnotationObject = getManager().instantiateMetaAnnotationObject(this, listener);
			if (this.metaAnnotationObject instanceof BsjMetaAnnotationMetaprogram)
			{
				this.metaprogramAnchor = getManager().instantiateMetaAnnotationMetaprogramAnchor(this);
				if (this.metaprogramAnchor instanceof NodeImpl)
				{
					((NodeImpl)this.metaprogramAnchor).setParent(this);
				}
			}
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