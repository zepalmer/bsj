/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateReferenceTypeListNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final List<Long> children;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateReferenceTypeListNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            List<Long> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.children = children;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final List<NodeUnion<? extends ReferenceTypeNode>> children = new ArrayList<NodeUnion<? extends ReferenceTypeNode>>();
        for (long uid : this.children)
        {
            final ReferenceTypeNode elementNode = 
                    (ReferenceTypeNode)patchState.getNode(uid);
            final NodeUnion<? extends ReferenceTypeNode> element;
            {
                final NodeUnion<? extends ReferenceTypeNode> union;
                if (elementNode instanceof SpliceNode)
                {
                    union = new SpliceNodeUnion<ReferenceTypeNode>((SpliceNode)elementNode);
                } else 
                {
                    union = new NormalNodeUnion<ReferenceTypeNode>((ReferenceTypeNode)elementNode);
                }
                element = union;
            }
            children.add(element);
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ReferenceTypeListNode createdNode = patchState.getNodeFactory().makeReferenceTypeListNodeWithUnions(children,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ReferenceTypeListNode> getCreateType()
    {
        return ReferenceTypeListNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ReferenceTypeListNode(" + "children=" + "[" + StringUtilities.join(children, ",", "#", "") + "]" + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateReferenceTypeListNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                this.children,
                this.startLocation,
                this.stopLocation);
    }
    
}
