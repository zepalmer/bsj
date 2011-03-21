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
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateEnumBodyNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long constants;
    private final Long members;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateEnumBodyNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long constants,
            Long members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.constants = constants;
        this.members = members;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final EnumConstantDeclarationListNode constantsNode = 
                (EnumConstantDeclarationListNode)patchState.getNode(this.constants);
        final NodeUnion<? extends EnumConstantDeclarationListNode> constants;
        {
            final NodeUnion<? extends EnumConstantDeclarationListNode> union;
            if (constantsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<EnumConstantDeclarationListNode>((SpliceNode)constantsNode);
            } else 
            {
                union = new NormalNodeUnion<EnumConstantDeclarationListNode>((EnumConstantDeclarationListNode)constantsNode);
            }
            constants = union;
        }
        final ClassMemberListNode membersNode = 
                (ClassMemberListNode)patchState.getNode(this.members);
        final NodeUnion<? extends ClassMemberListNode> members;
        {
            final NodeUnion<? extends ClassMemberListNode> union;
            if (membersNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ClassMemberListNode>((SpliceNode)membersNode);
            } else 
            {
                union = new NormalNodeUnion<ClassMemberListNode>((ClassMemberListNode)membersNode);
            }
            members = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        EnumBodyNode createdNode = patchState.getNodeFactory().makeEnumBodyNodeWithUnions(constants,
                members,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<EnumBodyNode> getCreateType()
    {
        return EnumBodyNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":EnumBodyNode(" + "constants=" + "#" + constants + "," + "members=" + "#" + members + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateEnumBodyNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.constants),
                translateUid(translationState, this.members),
                this.startLocation,
                this.stopLocation);
    }
    
}
