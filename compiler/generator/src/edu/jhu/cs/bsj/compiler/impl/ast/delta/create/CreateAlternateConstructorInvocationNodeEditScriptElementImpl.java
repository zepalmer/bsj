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
import edu.jhu.cs.bsj.compiler.ast.node.AlternateConstructorInvocationNode;
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
public class CreateAlternateConstructorInvocationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long arguments;
    private final Long typeArguments;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateAlternateConstructorInvocationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long arguments,
            Long typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.arguments = arguments;
        this.typeArguments = typeArguments;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
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
        AlternateConstructorInvocationNode createdNode = patchState.getNodeFactory().makeAlternateConstructorInvocationNodeWithUnions(arguments,
                typeArguments,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<AlternateConstructorInvocationNode> getCreateType()
    {
        return AlternateConstructorInvocationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":AlternateConstructorInvocationNode(" + "arguments=" + "#" + arguments + "," + "typeArguments=" + "#" + typeArguments + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateAlternateConstructorInvocationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.arguments),
                translateUid(translationState, this.typeArguments),
                this.startLocation,
                this.stopLocation);
    }
    
}
