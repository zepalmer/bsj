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
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateNormalAnnotationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long arguments;
    private final Long annotationType;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateNormalAnnotationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long arguments,
            Long annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.arguments = arguments;
        this.annotationType = annotationType;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final AnnotationElementListNode argumentsNode = 
                (AnnotationElementListNode)patchState.getNode(this.arguments);
        final NodeUnion<? extends AnnotationElementListNode> arguments;
        {
            final NodeUnion<? extends AnnotationElementListNode> union;
            if (argumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnnotationElementListNode>((SpliceNode)argumentsNode);
            } else 
            {
                union = new NormalNodeUnion<AnnotationElementListNode>((AnnotationElementListNode)argumentsNode);
            }
            arguments = union;
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
        NormalAnnotationNode createdNode = patchState.getNodeFactory().makeNormalAnnotationNodeWithUnions(arguments,
                annotationType,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<NormalAnnotationNode> getCreateType()
    {
        return NormalAnnotationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":NormalAnnotationNode(" + "arguments=" + "#" + arguments + "," + "annotationType=" + "#" + annotationType + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateNormalAnnotationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.annotationType),
                this.startLocation,
                this.stopLocation);
    }
    
}
