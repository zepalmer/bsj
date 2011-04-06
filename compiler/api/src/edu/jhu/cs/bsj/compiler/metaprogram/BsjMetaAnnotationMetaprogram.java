package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;

/**
 * The type of metaprogram specified by meta-annotations.
 * 
 * @author Zachary Palmer
 */
public interface BsjMetaAnnotationMetaprogram extends
        BsjMetaprogram<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode, MetaAnnotationContext>
{
}
