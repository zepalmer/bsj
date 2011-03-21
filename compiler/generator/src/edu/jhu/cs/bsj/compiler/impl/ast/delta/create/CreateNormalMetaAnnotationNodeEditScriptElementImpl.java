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
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.NormalMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateNormalMetaAnnotationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long arguments;
    private final Long annotationType;
    private final Long metaprogramAnchor;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateNormalMetaAnnotationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long arguments,
            Long annotationType,
            Long metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.arguments = arguments;
        this.annotationType = annotationType;
        this.metaprogramAnchor = metaprogramAnchor;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaAnnotationElementListNode argumentsNode = 
                (MetaAnnotationElementListNode)patchState.getNode(this.arguments);
        final NodeUnion<? extends MetaAnnotationElementListNode> arguments;
        {
            final NodeUnion<? extends MetaAnnotationElementListNode> union;
            if (argumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaAnnotationElementListNode>((SpliceNode)argumentsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaAnnotationElementListNode>((MetaAnnotationElementListNode)argumentsNode);
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
        final MetaAnnotationMetaprogramAnchorNode metaprogramAnchorNode = 
                (MetaAnnotationMetaprogramAnchorNode)patchState.getNode(this.metaprogramAnchor);
        final MetaAnnotationMetaprogramAnchorNode metaprogramAnchor = metaprogramAnchorNode;
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        NormalMetaAnnotationNode createdNode = patchState.getNodeFactory().makeNormalMetaAnnotationNodeWithUnions(arguments,
                annotationType,
                metaprogramAnchor,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<NormalMetaAnnotationNode> getCreateType()
    {
        return NormalMetaAnnotationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":NormalMetaAnnotationNode(" + "arguments=" + "#" + arguments + "," + "annotationType=" + "#" + annotationType + "," + "metaprogramAnchor=" + "#" + metaprogramAnchor + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateNormalMetaAnnotationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.annotationType),
                translateUid(translationState, this.metaprogramAnchor),
                this.startLocation,
                this.stopLocation);
    }
    
}
