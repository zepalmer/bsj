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
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateSingleElementMetaAnnotationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long value;
    private final Long annotationType;
    private final Long metaprogramAnchor;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long value,
            Long annotationType,
            Long metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.value = value;
        this.annotationType = annotationType;
        this.metaprogramAnchor = metaprogramAnchor;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaAnnotationValueNode valueNode = 
                (MetaAnnotationValueNode)patchState.getNode(this.value);
        final NodeUnion<? extends MetaAnnotationValueNode> value;
        {
            final NodeUnion<? extends MetaAnnotationValueNode> union;
            if (valueNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaAnnotationValueNode>((SpliceNode)valueNode);
            } else 
            {
                union = new NormalNodeUnion<MetaAnnotationValueNode>((MetaAnnotationValueNode)valueNode);
            }
            value = union;
        }
        final UnparameterizedTypeNode annotationTypeNode = 
                (UnparameterizedTypeNode)patchState.getNode(this.annotationType);
        final NodeUnion<? extends UnparameterizedTypeNode> annotationType;
        {
            final NodeUnion<? extends UnparameterizedTypeNode> union;
            if (annotationTypeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<UnparameterizedTypeNode>((SpliceNode)annotationTypeNode);
            } else 
            {
                union = new NormalNodeUnion<UnparameterizedTypeNode>((UnparameterizedTypeNode)annotationTypeNode);
            }
            annotationType = union;
        }
        final MetaAnnotationMetaprogramAnchorNode metaprogramAnchorNode = 
                (MetaAnnotationMetaprogramAnchorNode)patchState.getNode(this.metaprogramAnchor);
        final MetaAnnotationMetaprogramAnchorNode metaprogramAnchor = metaprogramAnchorNode;
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        SingleElementMetaAnnotationNode createdNode = patchState.getNodeFactory().makeSingleElementMetaAnnotationNodeWithUnions(value,
                annotationType,
                metaprogramAnchor,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<SingleElementMetaAnnotationNode> getCreateType()
    {
        return SingleElementMetaAnnotationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":SingleElementMetaAnnotationNode(" + "value=" + "#" + value + "," + "annotationType=" + "#" + annotationType + "," + "metaprogramAnchor=" + "#" + metaprogramAnchor + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateSingleElementMetaAnnotationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.value),
                translateUid(translationState, this.annotationType),
                translateUid(translationState, this.metaprogramAnchor),
                this.startLocation,
                this.stopLocation);
    }
    
}
