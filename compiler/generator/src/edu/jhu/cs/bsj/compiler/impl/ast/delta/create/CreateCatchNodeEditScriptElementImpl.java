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
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateCatchNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long body;
    private final Long parameter;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateCatchNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long body,
            Long parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.body = body;
        this.parameter = parameter;
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
        final VariableNode parameterNode = 
                (VariableNode)patchState.getNode(this.parameter);
        final NodeUnion<? extends VariableNode> parameter;
        {
            final NodeUnion<? extends VariableNode> union;
            if (parameterNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableNode>((SpliceNode)parameterNode);
            } else 
            {
                union = new NormalNodeUnion<VariableNode>((VariableNode)parameterNode);
            }
            parameter = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        CatchNode createdNode = patchState.getNodeFactory().makeCatchNodeWithUnions(body,
                parameter,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<CatchNode> getCreateType()
    {
        return CatchNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":CatchNode(" + "body=" + "#" + body + "," + "parameter=" + "#" + parameter + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateCatchNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.body),
                translateUid(translationState, this.parameter),
                this.startLocation,
                this.stopLocation);
    }
    
}
