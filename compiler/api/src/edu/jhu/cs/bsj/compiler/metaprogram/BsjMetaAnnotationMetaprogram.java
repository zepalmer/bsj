package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;

/**
 * This extension of the {@link BsjMetaAnnotation} interface represents annotations which imply the existence of a
 * metaprogram.
 * 
 * @author Zachary Palmer
 */
public interface BsjMetaAnnotationMetaprogram extends BsjMetaAnnotation
{
	/**
	 * Retrieves the metaprogram represented by this meta-annotation.
	 * @return The metaprorgam represented by this meta-annotation.
	 */
	public BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode> getMetaprogram();
}
