/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateBinaryExpressionNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long leftOperand;
    private final Long rightOperand;
    private final BinaryOperator operator;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateBinaryExpressionNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long leftOperand,
            Long rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionNode leftOperandNode = 
                (ExpressionNode)patchState.getNode(this.leftOperand);
        final NodeUnion<? extends ExpressionNode> leftOperand;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (leftOperandNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)leftOperandNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)leftOperandNode);
            }
            leftOperand = union;
        }
        final ExpressionNode rightOperandNode = 
                (ExpressionNode)patchState.getNode(this.rightOperand);
        final NodeUnion<? extends ExpressionNode> rightOperand;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (rightOperandNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)rightOperandNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)rightOperandNode);
            }
            rightOperand = union;
        }
        final BinaryOperator operator = this.operator;
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        BinaryExpressionNode createdNode = patchState.getNodeFactory().makeBinaryExpressionNodeWithUnions(leftOperand,
                rightOperand,
                operator,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<BinaryExpressionNode> getCreateType()
    {
        return BinaryExpressionNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":BinaryExpressionNode(" + "leftOperand=" + "#" + leftOperand + "," + "rightOperand=" + "#" + rightOperand + "," + "operator=" + "{" + operator + "}" + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateBinaryExpressionNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.leftOperand),
                translateUid(translationState, this.rightOperand),
                this.operator,
                this.startLocation,
                this.stopLocation);
    }
    
}
