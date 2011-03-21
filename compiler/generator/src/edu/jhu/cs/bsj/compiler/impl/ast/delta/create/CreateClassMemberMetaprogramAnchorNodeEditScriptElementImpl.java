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
import edu.jhu.cs.bsj.compiler.ast.node.meta.ClassMemberMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long metaprogram;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long metaprogram,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.metaprogram = metaprogram;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaprogramNode metaprogramNode = 
                (MetaprogramNode)patchState.getNode(this.metaprogram);
        final NodeUnion<? extends MetaprogramNode> metaprogram;
        {
            final NodeUnion<? extends MetaprogramNode> union;
            if (metaprogramNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramNode>((SpliceNode)metaprogramNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramNode>((MetaprogramNode)metaprogramNode);
            }
            metaprogram = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ClassMemberMetaprogramAnchorNode createdNode = patchState.getNodeFactory().makeClassMemberMetaprogramAnchorNodeWithUnions(metaprogram,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ClassMemberMetaprogramAnchorNode> getCreateType()
    {
        return ClassMemberMetaprogramAnchorNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ClassMemberMetaprogramAnchorNode(" + "metaprogram=" + "#" + metaprogram + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateClassMemberMetaprogramAnchorNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.metaprogram),
                this.startLocation,
                this.stopLocation);
    }
    
}
