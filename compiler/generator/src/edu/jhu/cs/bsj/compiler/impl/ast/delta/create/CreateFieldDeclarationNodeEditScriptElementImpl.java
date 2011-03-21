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
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateFieldDeclarationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long modifiers;
    private final Long type;
    private final Long declarators;
    private final Long javadoc;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateFieldDeclarationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long modifiers,
            Long type,
            Long declarators,
            Long javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.modifiers = modifiers;
        this.type = type;
        this.declarators = declarators;
        this.javadoc = javadoc;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final FieldModifiersNode modifiersNode = 
                (FieldModifiersNode)patchState.getNode(this.modifiers);
        final NodeUnion<? extends FieldModifiersNode> modifiers;
        {
            final NodeUnion<? extends FieldModifiersNode> union;
            if (modifiersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<FieldModifiersNode>((SpliceNode)modifiersNode);
            } else 
            {
                union = new NormalNodeUnion<FieldModifiersNode>((FieldModifiersNode)modifiersNode);
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
        final VariableDeclaratorListNode declaratorsNode = 
                (VariableDeclaratorListNode)patchState.getNode(this.declarators);
        final NodeUnion<? extends VariableDeclaratorListNode> declarators;
        {
            final NodeUnion<? extends VariableDeclaratorListNode> union;
            if (declaratorsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<VariableDeclaratorListNode>((SpliceNode)declaratorsNode);
            } else 
            {
                union = new NormalNodeUnion<VariableDeclaratorListNode>((VariableDeclaratorListNode)declaratorsNode);
            }
            declarators = union;
        }
        final JavadocNode javadocNode = 
                (JavadocNode)patchState.getNode(this.javadoc);
        final NodeUnion<? extends JavadocNode> javadoc;
        {
            final NodeUnion<? extends JavadocNode> union;
            if (javadocNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<JavadocNode>((SpliceNode)javadocNode);
            } else 
            {
                union = new NormalNodeUnion<JavadocNode>((JavadocNode)javadocNode);
            }
            javadoc = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        FieldDeclarationNode createdNode = patchState.getNodeFactory().makeFieldDeclarationNodeWithUnions(modifiers,
                type,
                declarators,
                javadoc,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<FieldDeclarationNode> getCreateType()
    {
        return FieldDeclarationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":FieldDeclarationNode(" + "modifiers=" + "#" + modifiers + "," + "type=" + "#" + type + "," + "declarators=" + "#" + declarators + "," + "javadoc=" + "#" + javadoc + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateFieldDeclarationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.modifiers),
                translateUid(translationState, this.type),
                translateUid(translationState, this.declarators),
                translateUid(translationState, this.javadoc),
                this.startLocation,
                this.stopLocation);
    }
    
}
