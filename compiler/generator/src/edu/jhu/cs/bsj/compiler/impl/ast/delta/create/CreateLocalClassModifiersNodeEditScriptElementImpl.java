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
import edu.jhu.cs.bsj.compiler.ast.node.LocalClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateLocalClassModifiersNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final boolean abstractFlag;
    private final boolean finalFlag;
    private final boolean strictfpFlag;
    private final Long metaAnnotations;
    private final Long annotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateLocalClassModifiersNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            boolean abstractFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            Long metaAnnotations,
            Long annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.abstractFlag = abstractFlag;
        this.finalFlag = finalFlag;
        this.strictfpFlag = strictfpFlag;
        this.metaAnnotations = metaAnnotations;
        this.annotations = annotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final boolean abstractFlag = this.abstractFlag;
        final boolean finalFlag = this.finalFlag;
        final boolean strictfpFlag = this.strictfpFlag;
        final MetaAnnotationListNode metaAnnotationsNode = 
                (MetaAnnotationListNode)patchState.getNode(this.metaAnnotations);
        final NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
        {
            final NodeUnion<? extends MetaAnnotationListNode> union;
            if (metaAnnotationsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaAnnotationListNode>((SpliceNode)metaAnnotationsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaAnnotationListNode>((MetaAnnotationListNode)metaAnnotationsNode);
            }
            metaAnnotations = union;
        }
        final AnnotationListNode annotationsNode = 
                (AnnotationListNode)patchState.getNode(this.annotations);
        final NodeUnion<? extends AnnotationListNode> annotations;
        {
            final NodeUnion<? extends AnnotationListNode> union;
            if (annotationsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnnotationListNode>((SpliceNode)annotationsNode);
            } else 
            {
                union = new NormalNodeUnion<AnnotationListNode>((AnnotationListNode)annotationsNode);
            }
            annotations = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        LocalClassModifiersNode createdNode = patchState.getNodeFactory().makeLocalClassModifiersNodeWithUnions(abstractFlag,
                finalFlag,
                strictfpFlag,
                metaAnnotations,
                annotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<LocalClassModifiersNode> getCreateType()
    {
        return LocalClassModifiersNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":LocalClassModifiersNode(" + "abstractFlag=" + "{" + abstractFlag + "}" + "," + "finalFlag=" + "{" + finalFlag + "}" + "," + "strictfpFlag=" + "{" + strictfpFlag + "}" + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "annotations=" + "#" + annotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateLocalClassModifiersNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                this.abstractFlag,
                this.finalFlag,
                this.strictfpFlag,
                translateUid(translationState, this.metaAnnotations),
                translateUid(translationState, this.annotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
