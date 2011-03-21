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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateQualifiedClassInstantiationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long enclosingExpression;
    private final Long identifier;
    private final Long typeArguments;
    private final Long constructorTypeArguments;
    private final Long arguments;
    private final Long body;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateQualifiedClassInstantiationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long enclosingExpression,
            Long identifier,
            Long typeArguments,
            Long constructorTypeArguments,
            Long arguments,
            Long body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.enclosingExpression = enclosingExpression;
        this.identifier = identifier;
        this.typeArguments = typeArguments;
        this.constructorTypeArguments = constructorTypeArguments;
        this.arguments = arguments;
        this.body = body;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionNode enclosingExpressionNode = 
                (ExpressionNode)patchState.getNode(this.enclosingExpression);
        final NodeUnion<? extends ExpressionNode> enclosingExpression;
        {
            final NodeUnion<? extends ExpressionNode> union;
            if (enclosingExpressionNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionNode>((SpliceNode)enclosingExpressionNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionNode>((ExpressionNode)enclosingExpressionNode);
            }
            enclosingExpression = union;
        }
        final IdentifierNode identifierNode = 
                (IdentifierNode)patchState.getNode(this.identifier);
        final NodeUnion<? extends IdentifierNode> identifier;
        {
            final NodeUnion<? extends IdentifierNode> union;
            if (identifierNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<IdentifierNode>((SpliceNode)identifierNode);
            } else 
            {
                union = new NormalNodeUnion<IdentifierNode>((IdentifierNode)identifierNode);
            }
            identifier = union;
        }
        final TypeArgumentListNode typeArgumentsNode = 
                (TypeArgumentListNode)patchState.getNode(this.typeArguments);
        final NodeUnion<? extends TypeArgumentListNode> typeArguments;
        {
            final NodeUnion<? extends TypeArgumentListNode> union;
            if (typeArgumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeArgumentListNode>((SpliceNode)typeArgumentsNode);
            } else 
            {
                union = new NormalNodeUnion<TypeArgumentListNode>((TypeArgumentListNode)typeArgumentsNode);
            }
            typeArguments = union;
        }
        final TypeArgumentListNode constructorTypeArgumentsNode = 
                (TypeArgumentListNode)patchState.getNode(this.constructorTypeArguments);
        final NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments;
        {
            final NodeUnion<? extends TypeArgumentListNode> union;
            if (constructorTypeArgumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeArgumentListNode>((SpliceNode)constructorTypeArgumentsNode);
            } else 
            {
                union = new NormalNodeUnion<TypeArgumentListNode>((TypeArgumentListNode)constructorTypeArgumentsNode);
            }
            constructorTypeArguments = union;
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
        final AnonymousClassBodyNode bodyNode = 
                (AnonymousClassBodyNode)patchState.getNode(this.body);
        final NodeUnion<? extends AnonymousClassBodyNode> body;
        {
            final NodeUnion<? extends AnonymousClassBodyNode> union;
            if (bodyNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<AnonymousClassBodyNode>((SpliceNode)bodyNode);
            } else 
            {
                union = new NormalNodeUnion<AnonymousClassBodyNode>((AnonymousClassBodyNode)bodyNode);
            }
            body = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        QualifiedClassInstantiationNode createdNode = patchState.getNodeFactory().makeQualifiedClassInstantiationNodeWithUnions(enclosingExpression,
                identifier,
                typeArguments,
                constructorTypeArguments,
                arguments,
                body,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<QualifiedClassInstantiationNode> getCreateType()
    {
        return QualifiedClassInstantiationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":QualifiedClassInstantiationNode(" + "enclosingExpression=" + "#" + enclosingExpression + "," + "identifier=" + "#" + identifier + "," + "typeArguments=" + "#" + typeArguments + "," + "constructorTypeArguments=" + "#" + constructorTypeArguments + "," + "arguments=" + "#" + arguments + "," + "body=" + "#" + body + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateQualifiedClassInstantiationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.enclosingExpression),
                translateUid(translationState, this.identifier),
                translateUid(translationState, this.typeArguments),
                translateUid(translationState, this.constructorTypeArguments),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.body),
                this.startLocation,
                this.stopLocation);
    }
    
}
