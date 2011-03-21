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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateExpressionStatementNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long expression;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateExpressionStatementNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long expression,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.expression = expression;
        this.metaAnnotations = metaAnnotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final StatementExpressionNode expressionNode = 
                (StatementExpressionNode)patchState.getNode(this.expression);
        final NodeUnion<? extends StatementExpressionNode> expression;
        {
            final NodeUnion<? extends StatementExpressionNode> union;
            if (expressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<StatementExpressionNode>((SpliceNode)expressionNode);
            } else 
            {
                union = new NormalNodeUnion<StatementExpressionNode>((StatementExpressionNode)expressionNode);
            }
            expression = union;
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
        ExpressionStatementNode createdNode = patchState.getNodeFactory().makeExpressionStatementNodeWithUnions(expression,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ExpressionStatementNode> getCreateType()
    {
        return ExpressionStatementNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ExpressionStatementNode(" + "expression=" + "#" + expression + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateExpressionStatementNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.expression),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
