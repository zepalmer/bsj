package edu.jhu.cs.bsj.compiler.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;

/**
 * The type of context used for metaprograms driven by meta-annotations.
 * @author Zachary Palmer
 */
public interface MetaAnnotationContext extends Context<MetaAnnotationMetaprogramAnchorNode,MetaAnnotationMetaprogramAnchorNode>
{
}
