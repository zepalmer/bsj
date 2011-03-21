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
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMetaprogramNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long preamble;
    private final Long body;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMetaprogramNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long preamble,
            Long body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.preamble = preamble;
        this.body = body;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaprogramPreambleNode preambleNode = 
                (MetaprogramPreambleNode)patchState.getNode(this.preamble);
        final NodeUnion<? extends MetaprogramPreambleNode> preamble;
        {
            final NodeUnion<? extends MetaprogramPreambleNode> union;
            if (preambleNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramPreambleNode>((SpliceNode)preambleNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramPreambleNode>((MetaprogramPreambleNode)preambleNode);
            }
            preamble = union;
        }
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
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MetaprogramNode createdNode = patchState.getNodeFactory().makeMetaprogramNodeWithUnions(preamble,
                body,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MetaprogramNode> getCreateType()
    {
        return MetaprogramNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MetaprogramNode(" + "preamble=" + "#" + preamble + "," + "body=" + "#" + body + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMetaprogramNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.preamble),
                translateUid(translationState, this.body),
                this.startLocation,
                this.stopLocation);
    }
    
}
