/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
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
public class CreateMethodModifiersNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final AccessModifier access;
    private final boolean abstractFlag;
    private final boolean staticFlag;
    private final boolean finalFlag;
    private final boolean synchronizedFlag;
    private final boolean nativeFlag;
    private final boolean strictfpFlag;
    private final Long metaAnnotations;
    private final Long annotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMethodModifiersNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            Long metaAnnotations,
            Long annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.access = access;
        this.abstractFlag = abstractFlag;
        this.staticFlag = staticFlag;
        this.finalFlag = finalFlag;
        this.synchronizedFlag = synchronizedFlag;
        this.nativeFlag = nativeFlag;
        this.strictfpFlag = strictfpFlag;
        this.metaAnnotations = metaAnnotations;
        this.annotations = annotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final AccessModifier access = this.access;
        final boolean abstractFlag = this.abstractFlag;
        final boolean staticFlag = this.staticFlag;
        final boolean finalFlag = this.finalFlag;
        final boolean synchronizedFlag = this.synchronizedFlag;
        final boolean nativeFlag = this.nativeFlag;
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
        MethodModifiersNode createdNode = patchState.getNodeFactory().makeMethodModifiersNodeWithUnions(access,
                abstractFlag,
                staticFlag,
                finalFlag,
                synchronizedFlag,
                nativeFlag,
                strictfpFlag,
                metaAnnotations,
                annotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MethodModifiersNode> getCreateType()
    {
        return MethodModifiersNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MethodModifiersNode(" + "access=" + "{" + access + "}" + "," + "abstractFlag=" + "{" + abstractFlag + "}" + "," + "staticFlag=" + "{" + staticFlag + "}" + "," + "finalFlag=" + "{" + finalFlag + "}" + "," + "synchronizedFlag=" + "{" + synchronizedFlag + "}" + "," + "nativeFlag=" + "{" + nativeFlag + "}" + "," + "strictfpFlag=" + "{" + strictfpFlag + "}" + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "annotations=" + "#" + annotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMethodModifiersNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                this.access,
                this.abstractFlag,
                this.staticFlag,
                this.finalFlag,
                this.synchronizedFlag,
                this.nativeFlag,
                this.strictfpFlag,
                translateUid(translationState, this.metaAnnotations),
                translateUid(translationState, this.annotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
