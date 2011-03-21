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
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long targets;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.targets = targets;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaprogramDependencyListNode targetsNode = 
                (MetaprogramDependencyListNode)patchState.getNode(this.targets);
        final NodeUnion<? extends MetaprogramDependencyListNode> targets;
        {
            final NodeUnion<? extends MetaprogramDependencyListNode> union;
            if (targetsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramDependencyListNode>((SpliceNode)targetsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramDependencyListNode>((MetaprogramDependencyListNode)targetsNode);
            }
            targets = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MetaprogramDependencyDeclarationNode createdNode = patchState.getNodeFactory().makeMetaprogramDependencyDeclarationNodeWithUnions(targets,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MetaprogramDependencyDeclarationNode> getCreateType()
    {
        return MetaprogramDependencyDeclarationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MetaprogramDependencyDeclarationNode(" + "targets=" + "#" + targets + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMetaprogramDependencyDeclarationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.targets),
                this.startLocation,
                this.stopLocation);
    }
    
}
