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
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateTryNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long body;
    private final Long catches;
    private final Long finallyBlock;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateTryNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long body,
            Long catches,
            Long finallyBlock,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.body = body;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
        this.metaAnnotations = metaAnnotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final BlockStatementListNode bodyNode = 
                (BlockStatementListNode)patchState.getNode(this.body);
        final NodeUnion<? extends BlockStatementListNode> body;
        {
            final NodeUnion<? extends BlockStatementListNode> union;
            if (bodyNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<BlockStatementListNode>((SpliceNode)bodyNode);
            } else 
            {
                union = new NormalNodeUnion<BlockStatementListNode>((BlockStatementListNode)bodyNode);
            }
            body = union;
        }
        final CatchListNode catchesNode = 
                (CatchListNode)patchState.getNode(this.catches);
        final NodeUnion<? extends CatchListNode> catches;
        {
            final NodeUnion<? extends CatchListNode> union;
            if (catchesNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<CatchListNode>((SpliceNode)catchesNode);
            } else 
            {
                union = new NormalNodeUnion<CatchListNode>((CatchListNode)catchesNode);
            }
            catches = union;
        }
        final BlockStatementListNode finallyBlockNode = 
                (BlockStatementListNode)patchState.getNode(this.finallyBlock);
        final NodeUnion<? extends BlockStatementListNode> finallyBlock;
        {
            final NodeUnion<? extends BlockStatementListNode> union;
            if (finallyBlockNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<BlockStatementListNode>((SpliceNode)finallyBlockNode);
            } else 
            {
                union = new NormalNodeUnion<BlockStatementListNode>((BlockStatementListNode)finallyBlockNode);
            }
            finallyBlock = union;
        }
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
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        TryNode createdNode = patchState.getNodeFactory().makeTryNodeWithUnions(body,
                catches,
                finallyBlock,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<TryNode> getCreateType()
    {
        return TryNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":TryNode(" + "body=" + "#" + body + "," + "catches=" + "#" + catches + "," + "finallyBlock=" + "#" + finallyBlock + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateTryNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.body),
                translateUid(translationState, this.catches),
                translateUid(translationState, this.finallyBlock),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
