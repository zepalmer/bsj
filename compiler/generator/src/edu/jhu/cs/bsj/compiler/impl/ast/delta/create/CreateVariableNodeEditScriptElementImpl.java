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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateVariableNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long modifiers;
    private final Long type;
    private final Long identifier;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateVariableNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long modifiers,
            Long type,
            Long identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.modifiers = modifiers;
        this.type = type;
        this.identifier = identifier;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final VariableModifiersNode modifiersNode = 
                (VariableModifiersNode)patchState.getNode(this.modifiers);
        final NodeUnion<? extends VariableModifiersNode> modifiers;
        {
            final NodeUnion<? extends VariableModifiersNode> union;
            if (modifiersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableModifiersNode>((SpliceNode)modifiersNode);
            } else 
            {
                union = new NormalNodeUnion<VariableModifiersNode>((VariableModifiersNode)modifiersNode);
            }
            modifiers = union;
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
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        VariableNode createdNode = patchState.getNodeFactory().makeVariableNodeWithUnions(modifiers,
                type,
                identifier,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<VariableNode> getCreateType()
    {
        return VariableNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":VariableNode(" + "modifiers=" + "#" + modifiers + "," + "type=" + "#" + type + "," + "identifier=" + "#" + identifier + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateVariableNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.modifiers),
                translateUid(translationState, this.type),
                translateUid(translationState, this.identifier),
                this.startLocation,
                this.stopLocation);
    }
    
}
