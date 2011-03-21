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
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateSingleElementAnnotationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long value;
    private final Long annotationType;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateSingleElementAnnotationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long value,
            Long annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.value = value;
        this.annotationType = annotationType;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final AnnotationValueNode valueNode = 
                (AnnotationValueNode)patchState.getNode(this.value);
        final NodeUnion<? extends AnnotationValueNode> value;
        {
            final NodeUnion<? extends AnnotationValueNode> union;
            if (valueNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnnotationValueNode>((SpliceNode)valueNode);
            } else 
            {
                union = new NormalNodeUnion<AnnotationValueNode>((AnnotationValueNode)valueNode);
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
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        SingleElementAnnotationNode createdNode = patchState.getNodeFactory().makeSingleElementAnnotationNodeWithUnions(value,
                annotationType,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<SingleElementAnnotationNode> getCreateType()
    {
        return SingleElementAnnotationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":SingleElementAnnotationNode(" + "value=" + "#" + value + "," + "annotationType=" + "#" + annotationType + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateSingleElementAnnotationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.value),
                translateUid(translationState, this.annotationType),
                this.startLocation,
                this.stopLocation);
    }
    
}
