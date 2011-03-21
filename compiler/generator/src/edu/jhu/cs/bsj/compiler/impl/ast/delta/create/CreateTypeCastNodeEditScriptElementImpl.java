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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeCastNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateTypeCastNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long expression;
    private final Long type;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateTypeCastNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long expression,
            Long type,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.expression = expression;
        this.type = type;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
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
        final TypeNode typeNode = 
                (TypeNode)patchState.getNode(this.type);
        final NodeUnion<? extends TypeNode> type;
        {
            final NodeUnion<? extends TypeNode> union;
            if (typeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeNode>((SpliceNode)typeNode);
            } else 
            {
                union = new NormalNodeUnion<TypeNode>((TypeNode)typeNode);
            }
            type = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        TypeCastNode createdNode = patchState.getNodeFactory().makeTypeCastNodeWithUnions(expression,
                type,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<TypeCastNode> getCreateType()
    {
        return TypeCastNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":TypeCastNode(" + "expression=" + "#" + expression + "," + "type=" + "#" + type + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateTypeCastNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.expression),
                translateUid(translationState, this.type),
                this.startLocation,
                this.stopLocation);
    }
    
}
