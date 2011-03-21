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
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateConstructorBodyNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long constructorInvocation;
    private final Long statements;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateConstructorBodyNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long constructorInvocation,
            Long statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.constructorInvocation = constructorInvocation;
        this.statements = statements;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ConstructorInvocationNode constructorInvocationNode = 
                (ConstructorInvocationNode)patchState.getNode(this.constructorInvocation);
        final NodeUnion<? extends ConstructorInvocationNode> constructorInvocation;
        {
            final NodeUnion<? extends ConstructorInvocationNode> union;
            if (constructorInvocationNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ConstructorInvocationNode>((SpliceNode)constructorInvocationNode);
            } else 
            {
                union = new NormalNodeUnion<ConstructorInvocationNode>((ConstructorInvocationNode)constructorInvocationNode);
            }
            constructorInvocation = union;
        }
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
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ConstructorBodyNode createdNode = patchState.getNodeFactory().makeConstructorBodyNodeWithUnions(constructorInvocation,
                statements,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ConstructorBodyNode> getCreateType()
    {
        return ConstructorBodyNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ConstructorBodyNode(" + "constructorInvocation=" + "#" + constructorInvocation + "," + "statements=" + "#" + statements + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateConstructorBodyNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.constructorInvocation),
                translateUid(translationState, this.statements),
                this.startLocation,
                this.stopLocation);
    }
    
}
