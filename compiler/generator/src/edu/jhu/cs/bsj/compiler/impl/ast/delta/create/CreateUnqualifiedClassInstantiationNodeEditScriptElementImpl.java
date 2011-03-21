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
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnqualifiedClassInstantiationNode;
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
public class CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long type;
    private final Long constructorTypeArguments;
    private final Long arguments;
    private final Long body;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long type,
            Long constructorTypeArguments,
            Long arguments,
            Long body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.type = type;
        this.constructorTypeArguments = constructorTypeArguments;
        this.arguments = arguments;
        this.body = body;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final DeclaredTypeNode typeNode = 
                (DeclaredTypeNode)patchState.getNode(this.type);
        final NodeUnion<? extends DeclaredTypeNode> type;
        {
            final NodeUnion<? extends DeclaredTypeNode> union;
            if (typeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<DeclaredTypeNode>((SpliceNode)typeNode);
            } else 
            {
                union = new NormalNodeUnion<DeclaredTypeNode>((DeclaredTypeNode)typeNode);
            }
            type = union;
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
        UnqualifiedClassInstantiationNode createdNode = patchState.getNodeFactory().makeUnqualifiedClassInstantiationNodeWithUnions(type,
                constructorTypeArguments,
                arguments,
                body,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<UnqualifiedClassInstantiationNode> getCreateType()
    {
        return UnqualifiedClassInstantiationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":UnqualifiedClassInstantiationNode(" + "type=" + "#" + type + "," + "constructorTypeArguments=" + "#" + constructorTypeArguments + "," + "arguments=" + "#" + arguments + "," + "body=" + "#" + body + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateUnqualifiedClassInstantiationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.type),
                translateUid(translationState, this.constructorTypeArguments),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.body),
                this.startLocation,
                this.stopLocation);
    }
    
}
