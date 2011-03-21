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
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateSuperclassConstructorInvocationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long qualifyingExpression;
    private final Long arguments;
    private final Long typeArguments;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long qualifyingExpression,
            Long arguments,
            Long typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.qualifyingExpression = qualifyingExpression;
        this.arguments = arguments;
        this.typeArguments = typeArguments;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final PrimaryExpressionNode qualifyingExpressionNode = 
                (PrimaryExpressionNode)patchState.getNode(this.qualifyingExpression);
        final NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression;
        {
            final NodeUnion<? extends PrimaryExpressionNode> union;
            if (qualifyingExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<PrimaryExpressionNode>((SpliceNode)qualifyingExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<PrimaryExpressionNode>((PrimaryExpressionNode)qualifyingExpressionNode);
            }
            qualifyingExpression = union;
        }
        final ExpressionListNode argumentsNode = 
                (ExpressionListNode)patchState.getNode(this.arguments);
        final NodeUnion<? extends ExpressionListNode> arguments;
        {
            final NodeUnion<? extends ExpressionListNode> union;
            if (argumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionListNode>((SpliceNode)argumentsNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionListNode>((ExpressionListNode)argumentsNode);
            }
            arguments = union;
        }
        final ReferenceTypeListNode typeArgumentsNode = 
                (ReferenceTypeListNode)patchState.getNode(this.typeArguments);
        final NodeUnion<? extends ReferenceTypeListNode> typeArguments;
        {
            final NodeUnion<? extends ReferenceTypeListNode> union;
            if (typeArgumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ReferenceTypeListNode>((SpliceNode)typeArgumentsNode);
            } else 
            {
                union = new NormalNodeUnion<ReferenceTypeListNode>((ReferenceTypeListNode)typeArgumentsNode);
            }
            typeArguments = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        SuperclassConstructorInvocationNode createdNode = patchState.getNodeFactory().makeSuperclassConstructorInvocationNodeWithUnions(qualifyingExpression,
                arguments,
                typeArguments,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<SuperclassConstructorInvocationNode> getCreateType()
    {
        return SuperclassConstructorInvocationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":SuperclassConstructorInvocationNode(" + "qualifyingExpression=" + "#" + qualifyingExpression + "," + "arguments=" + "#" + arguments + "," + "typeArguments=" + "#" + typeArguments + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateSuperclassConstructorInvocationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.qualifyingExpression),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.typeArguments),
                this.startLocation,
                this.stopLocation);
    }
    
}
