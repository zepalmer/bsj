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
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateConditionalExpressionNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long condition;
    private final Long trueExpression;
    private final Long falseExpression;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateConditionalExpressionNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long condition,
            Long trueExpression,
            Long falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.condition = condition;
        this.trueExpression = trueExpression;
        this.falseExpression = falseExpression;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionNode conditionNode = 
                (ExpressionNode)patchState.getNode(this.condition);
        final NodeUnion<? extends ExpressionNode> condition;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (conditionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)conditionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)conditionNode);
            }
            condition = union;
        }
        final ExpressionNode trueExpressionNode = 
                (ExpressionNode)patchState.getNode(this.trueExpression);
        final NodeUnion<? extends ExpressionNode> trueExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (trueExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)trueExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)trueExpressionNode);
            }
            trueExpression = union;
        }
        final ExpressionNode falseExpressionNode = 
                (ExpressionNode)patchState.getNode(this.falseExpression);
        final NodeUnion<? extends ExpressionNode> falseExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (falseExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)falseExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)falseExpressionNode);
            }
            falseExpression = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ConditionalExpressionNode createdNode = patchState.getNodeFactory().makeConditionalExpressionNodeWithUnions(condition,
                trueExpression,
                falseExpression,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ConditionalExpressionNode> getCreateType()
    {
        return ConditionalExpressionNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ConditionalExpressionNode(" + "condition=" + "#" + condition + "," + "trueExpression=" + "#" + trueExpression + "," + "falseExpression=" + "#" + falseExpression + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateConditionalExpressionNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.condition),
                translateUid(translationState, this.trueExpression),
                translateUid(translationState, this.falseExpression),
                this.startLocation,
                this.stopLocation);
    }
    
}
