package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaprogram;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;

/**
 * This class acts as an adapter between the user-specifiable metaprogram interface ({@link BsjMetaprogram}) and the
 * internal compiler representation of metaprograms ({@link Metaprogram}).
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationMetaprogramWrapper extends
        AbstractMetaprogram<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode>
{
    /** The user metaprogram object. */
    private BsjMetaAnnotationMetaprogram metaprogram;

    public MetaAnnotationMetaprogramWrapper(BsjMetaAnnotationMetaprogram metaprogram)
    {
        super();
        this.metaprogram = metaprogram;
    }

    @Override
    public void execute(Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> context)
    {
        this.metaprogram.execute(new MetaAnnotationContextDecorator(context));
    }
}
