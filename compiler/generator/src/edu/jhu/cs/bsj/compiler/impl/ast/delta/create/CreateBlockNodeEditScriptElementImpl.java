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
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateBlockNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long statements;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateBlockNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long statements,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.statements = statements;
        this.metaAnnotations = metaAnnotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final BlockStatementListNode statementsNode = 
                (BlockStatementListNode)patchState.getNode(this.statements);
        final NodeUnion<? extends BlockStatementListNode> statements;
        {
            final NodeUnion<? extends BlockStatementListNode> union;
            if (statementsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<BlockStatementListNode>((SpliceNode)statementsNode);
            } else 
            {
                union = new NormalNodeUnion<BlockStatementListNode>((BlockStatementListNode)statementsNode);
            }
            statements = union;
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
        BlockNode createdNode = patchState.getNodeFactory().makeBlockNodeWithUnions(statements,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<BlockNode> getCreateType()
    {
        return BlockNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":BlockNode(" + "statements=" + "#" + statements + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateBlockNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.statements),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
