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
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateAssertStatementNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long testExpression;
    private final Long messageExpression;
    private final Long metaAnnotations;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateAssertStatementNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long testExpression,
            Long messageExpression,
            Long metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.testExpression = testExpression;
        this.messageExpression = messageExpression;
        this.metaAnnotations = metaAnnotations;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionNode testExpressionNode = 
                (ExpressionNode)patchState.getNode(this.testExpression);
        final NodeUnion<? extends ExpressionNode> testExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (testExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)testExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)testExpressionNode);
            }
            testExpression = union;
        }
        final ExpressionNode messageExpressionNode = 
                (ExpressionNode)patchState.getNode(this.messageExpression);
        final NodeUnion<? extends ExpressionNode> messageExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (messageExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)messageExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)messageExpressionNode);
            }
            messageExpression = union;
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
        AssertStatementNode createdNode = patchState.getNodeFactory().makeAssertStatementNodeWithUnions(testExpression,
                messageExpression,
                metaAnnotations,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<AssertStatementNode> getCreateType()
    {
        return AssertStatementNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":AssertStatementNode(" + "testExpression=" + "#" + testExpression + "," + "messageExpression=" + "#" + messageExpression + "," + "metaAnnotations=" + "#" + metaAnnotations + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateAssertStatementNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.testExpression),
                translateUid(translationState, this.messageExpression),
                translateUid(translationState, this.metaAnnotations),
                this.startLocation,
                this.stopLocation);
    }
    
}
