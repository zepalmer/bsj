/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long annotation;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.annotation = annotation;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaAnnotationNode annotationNode = 
                (MetaAnnotationNode)patchState.getNode(this.annotation);
        final NodeUnion<? extends MetaAnnotationNode> annotation;
        {
            final NodeUnion<? extends MetaAnnotationNode> union;
            if (annotationNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaAnnotationNode>((SpliceNode)annotationNode);
            } else 
            {
                union = new NormalNodeUnion<MetaAnnotationNode>((MetaAnnotationNode)annotationNode);
            }
            annotation = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MetaAnnotationMetaAnnotationValueNode createdNode = patchState.getNodeFactory().makeMetaAnnotationMetaAnnotationValueNodeWithUnions(annotation,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MetaAnnotationMetaAnnotationValueNode> getCreateType()
    {
        return MetaAnnotationMetaAnnotationValueNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MetaAnnotationMetaAnnotationValueNode(" + "annotation=" + "#" + annotation + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMetaAnnotationMetaAnnotationValueNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.annotation),
                this.startLocation,
                this.stopLocation);
    }
    
}
