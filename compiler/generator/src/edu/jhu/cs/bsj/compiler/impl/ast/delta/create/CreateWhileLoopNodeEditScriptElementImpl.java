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
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.WhileLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateWhileLoopNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long condition;
    private final Long statement;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateWhileLoopNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long condition,
            Long statement,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.condition = condition;
        this.statement = statement;
        this.metaAnnotations = metaAnnotations;
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
        final StatementNode statementNode = 
                (StatementNode)patchState.getNode(this.statement);
        final NodeUnion<? extends StatementNode> statement;
        {
            final NodeUnion<? extends StatementNode> union;
            if (statementNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<StatementNode>((SpliceNode)statementNode);
            } else 
            {
                union = new NormalNodeUnion<StatementNode>((StatementNode)statementNode);
            }
            statement = union;
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
        WhileLoopNode createdNode = patchState.getNodeFactory().makeWhileLoopNodeWithUnions(condition,
                statement,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<WhileLoopNode> getCreateType()
    {
        return WhileLoopNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":WhileLoopNode(" + "condition=" + "#" + condition + "," + "statement=" + "#" + statement + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateWhileLoopNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.condition),
                translateUid(translationState, this.statement),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
