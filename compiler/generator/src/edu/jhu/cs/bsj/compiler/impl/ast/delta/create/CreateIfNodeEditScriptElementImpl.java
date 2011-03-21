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
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateIfNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long condition;
    private final Long thenStatement;
    private final Long elseStatement;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateIfNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long condition,
            Long thenStatement,
            Long elseStatement,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
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
        final StatementNode thenStatementNode = 
                (StatementNode)patchState.getNode(this.thenStatement);
        final NodeUnion<? extends StatementNode> thenStatement;
        {
            final NodeUnion<? extends StatementNode> union;
            if (thenStatementNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<StatementNode>((SpliceNode)thenStatementNode);
            } else 
            {
                union = new NormalNodeUnion<StatementNode>((StatementNode)thenStatementNode);
            }
            thenStatement = union;
        }
        final StatementNode elseStatementNode = 
                (StatementNode)patchState.getNode(this.elseStatement);
        final NodeUnion<? extends StatementNode> elseStatement;
        {
            final NodeUnion<? extends StatementNode> union;
            if (elseStatementNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<StatementNode>((SpliceNode)elseStatementNode);
            } else 
            {
                union = new NormalNodeUnion<StatementNode>((StatementNode)elseStatementNode);
            }
            elseStatement = union;
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
        IfNode createdNode = patchState.getNodeFactory().makeIfNodeWithUnions(condition,
                thenStatement,
                elseStatement,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<IfNode> getCreateType()
    {
        return IfNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":IfNode(" + "condition=" + "#" + condition + "," + "thenStatement=" + "#" + thenStatement + "," + "elseStatement=" + "#" + elseStatement + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateIfNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.condition),
                translateUid(translationState, this.thenStatement),
                translateUid(translationState, this.elseStatement),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
