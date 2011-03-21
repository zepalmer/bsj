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
import edu.jhu.cs.bsj.compiler.ast.node.ArrayAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.RestrictedPrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateArrayAccessNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long arrayExpression;
    private final Long indexExpression;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateArrayAccessNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long arrayExpression,
            Long indexExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.arrayExpression = arrayExpression;
        this.indexExpression = indexExpression;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final RestrictedPrimaryExpressionNode arrayExpressionNode = 
                (RestrictedPrimaryExpressionNode)patchState.getNode(this.arrayExpression);
        final NodeUnion<? extends RestrictedPrimaryExpressionNode> arrayExpression;
        {
            final NodeUnion<? extends RestrictedPrimaryExpressionNode> union;
            if (arrayExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<RestrictedPrimaryExpressionNode>((SpliceNode)arrayExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<RestrictedPrimaryExpressionNode>((RestrictedPrimaryExpressionNode)arrayExpressionNode);
            }
            arrayExpression = union;
        }
        final ExpressionNode indexExpressionNode = 
                (ExpressionNode)patchState.getNode(this.indexExpression);
        final NodeUnion<? extends ExpressionNode> indexExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (indexExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)indexExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)indexExpressionNode);
            }
            indexExpression = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ArrayAccessNode createdNode = patchState.getNodeFactory().makeArrayAccessNodeWithUnions(arrayExpression,
                indexExpression,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ArrayAccessNode> getCreateType()
    {
        return ArrayAccessNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ArrayAccessNode(" + "arrayExpression=" + "#" + arrayExpression + "," + "indexExpression=" + "#" + indexExpression + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateArrayAccessNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.arrayExpression),
                translateUid(translationState, this.indexExpression),
                this.startLocation,
                this.stopLocation);
    }
    
}
