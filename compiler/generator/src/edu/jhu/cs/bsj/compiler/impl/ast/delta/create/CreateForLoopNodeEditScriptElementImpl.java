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
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateForLoopNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long initializer;
    private final Long condition;
    private final Long update;
    private final Long statement;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateForLoopNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long initializer,
            Long condition,
            Long update,
            Long statement,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.initializer = initializer;
        this.condition = condition;
        this.update = update;
        this.statement = statement;
        this.metaAnnotations = metaAnnotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ForInitializerNode initializerNode = 
                (ForInitializerNode)patchState.getNode(this.initializer);
        final NodeUnion<? extends ForInitializerNode> initializer;
        {
            final NodeUnion<? extends ForInitializerNode> union;
            if (initializerNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ForInitializerNode>((SpliceNode)initializerNode);
            } else 
            {
                union = new NormalNodeUnion<ForInitializerNode>((ForInitializerNode)initializerNode);
            }
            initializer = union;
        }
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
        final StatementExpressionListNode updateNode = 
                (StatementExpressionListNode)patchState.getNode(this.update);
        final NodeUnion<? extends StatementExpressionListNode> update;
        {
            final NodeUnion<? extends StatementExpressionListNode> union;
            if (updateNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<StatementExpressionListNode>((SpliceNode)updateNode);
            } else 
            {
                union = new NormalNodeUnion<StatementExpressionListNode>((StatementExpressionListNode)updateNode);
            }
            update = union;
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
        ForLoopNode createdNode = patchState.getNodeFactory().makeForLoopNodeWithUnions(initializer,
                condition,
                update,
                statement,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ForLoopNode> getCreateType()
    {
        return ForLoopNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ForLoopNode(" + "initializer=" + "#" + initializer + "," + "condition=" + "#" + condition + "," + "update=" + "#" + update + "," + "statement=" + "#" + statement + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateForLoopNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.initializer),
                translateUid(translationState, this.condition),
                translateUid(translationState, this.update),
                translateUid(translationState, this.statement),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
