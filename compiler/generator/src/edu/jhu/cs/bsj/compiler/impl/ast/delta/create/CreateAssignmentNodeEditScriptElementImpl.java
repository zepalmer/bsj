/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateAssignmentNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long variable;
    private final AssignmentOperator operator;
    private final Long expression;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateAssignmentNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long variable,
            AssignmentOperator operator,
            Long expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.variable = variable;
        this.operator = operator;
        this.expression = expression;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionNode variableNode = 
                (ExpressionNode)patchState.getNode(this.variable);
        final NodeUnion<? extends ExpressionNode> variable;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (variableNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)variableNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)variableNode);
            }
            variable = union;
        }
        final AssignmentOperator operator = this.operator;
        final ExpressionNode expressionNode = 
                (ExpressionNode)patchState.getNode(this.expression);
        final NodeUnion<? extends ExpressionNode> expression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (expressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)expressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)expressionNode);
            }
            expression = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        AssignmentNode createdNode = patchState.getNodeFactory().makeAssignmentNodeWithUnions(variable,
                operator,
                expression,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<AssignmentNode> getCreateType()
    {
        return AssignmentNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":AssignmentNode(" + "variable=" + "#" + variable + "," + "operator=" + "{" + operator + "}" + "," + "expression=" + "#" + expression + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateAssignmentNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.variable),
                this.operator,
                translateUid(translationState, this.expression),
                this.startLocation,
                this.stopLocation);
    }
    
}
