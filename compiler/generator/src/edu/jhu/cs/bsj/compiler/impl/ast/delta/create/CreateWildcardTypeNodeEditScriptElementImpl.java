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
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateWildcardTypeNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long bound;
    private final boolean upperBound;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateWildcardTypeNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.bound = bound;
        this.upperBound = upperBound;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ReferenceTypeNode boundNode = 
                (ReferenceTypeNode)patchState.getNode(this.bound);
        final NodeUnion<? extends ReferenceTypeNode> bound;
        {
            final NodeUnion<? extends ReferenceTypeNode> union;
            if (boundNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ReferenceTypeNode>((SpliceNode)boundNode);
            } else 
            {
                union = new NormalNodeUnion<ReferenceTypeNode>((ReferenceTypeNode)boundNode);
            }
            bound = union;
        }
        final boolean upperBound = this.upperBound;
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        WildcardTypeNode createdNode = patchState.getNodeFactory().makeWildcardTypeNodeWithUnions(bound,
                upperBound,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<WildcardTypeNode> getCreateType()
    {
        return WildcardTypeNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":WildcardTypeNode(" + "bound=" + "#" + bound + "," + "upperBound=" + "{" + upperBound + "}" + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateWildcardTypeNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.bound),
                this.upperBound,
                this.startLocation,
                this.stopLocation);
    }
    
}
