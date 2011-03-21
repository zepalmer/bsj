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
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateParameterizedTypeSelectNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long base;
    private final Long select;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateParameterizedTypeSelectNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long base,
            Long select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.base = base;
        this.select = select;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ParameterizedTypeNode baseNode = 
                (ParameterizedTypeNode)patchState.getNode(this.base);
        final NodeUnion<? extends ParameterizedTypeNode> base;
        {
            final NodeUnion<? extends ParameterizedTypeNode> union;
            if (baseNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ParameterizedTypeNode>((SpliceNode)baseNode);
            } else 
            {
                union = new NormalNodeUnion<ParameterizedTypeNode>((ParameterizedTypeNode)baseNode);
            }
            base = union;
        }
        final DeclaredTypeNode selectNode = 
                (DeclaredTypeNode)patchState.getNode(this.select);
        final NodeUnion<? extends DeclaredTypeNode> select;
        {
            final NodeUnion<? extends DeclaredTypeNode> union;
            if (selectNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<DeclaredTypeNode>((SpliceNode)selectNode);
            } else 
            {
                union = new NormalNodeUnion<DeclaredTypeNode>((DeclaredTypeNode)selectNode);
            }
            select = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ParameterizedTypeSelectNode createdNode = patchState.getNodeFactory().makeParameterizedTypeSelectNodeWithUnions(base,
                select,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ParameterizedTypeSelectNode> getCreateType()
    {
        return ParameterizedTypeSelectNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ParameterizedTypeSelectNode(" + "base=" + "#" + base + "," + "select=" + "#" + select + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateParameterizedTypeSelectNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.base),
                translateUid(translationState, this.select),
                this.startLocation,
                this.stopLocation);
    }
    
}
