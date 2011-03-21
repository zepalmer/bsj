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
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateVariableDeclaratorNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long identifier;
    private final int arrayLevels;
    private final Long initializer;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateVariableDeclaratorNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long identifier,
            int arrayLevels,
            Long initializer,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.identifier = identifier;
        this.arrayLevels = arrayLevels;
        this.initializer = initializer;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
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
        final int arrayLevels = this.arrayLevels;
        final VariableInitializerNode initializerNode = 
                (VariableInitializerNode)patchState.getNode(this.initializer);
        final NodeUnion<? extends VariableInitializerNode> initializer;
        {
            final NodeUnion<? extends VariableInitializerNode> union;
            if (initializerNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableInitializerNode>((SpliceNode)initializerNode);
            } else 
            {
                union = new NormalNodeUnion<VariableInitializerNode>((VariableInitializerNode)initializerNode);
            }
            initializer = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        VariableDeclaratorNode createdNode = patchState.getNodeFactory().makeVariableDeclaratorNodeWithUnions(identifier,
                arrayLevels,
                initializer,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<VariableDeclaratorNode> getCreateType()
    {
        return VariableDeclaratorNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":VariableDeclaratorNode(" + "identifier=" + "#" + identifier + "," + "arrayLevels=" + "{" + arrayLevels + "}" + "," + "initializer=" + "#" + initializer + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateVariableDeclaratorNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.identifier),
                this.arrayLevels,
                translateUid(translationState, this.initializer),
                this.startLocation,
                this.stopLocation);
    }
    
}
