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
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationElementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMetaAnnotationElementNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long identifier;
    private final Long value;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMetaAnnotationElementNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long identifier,
            Long value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.identifier = identifier;
        this.value = value;
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
        final MetaAnnotationValueNode valueNode = 
                (MetaAnnotationValueNode)patchState.getNode(this.value);
        final NodeUnion<? extends MetaAnnotationValueNode> value;
        {
            final NodeUnion<? extends MetaAnnotationValueNode> union;
            if (valueNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaAnnotationValueNode>((SpliceNode)valueNode);
            } else 
            {
                union = new NormalNodeUnion<MetaAnnotationValueNode>((MetaAnnotationValueNode)valueNode);
            }
            value = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MetaAnnotationElementNode createdNode = patchState.getNodeFactory().makeMetaAnnotationElementNodeWithUnions(identifier,
                value,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MetaAnnotationElementNode> getCreateType()
    {
        return MetaAnnotationElementNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MetaAnnotationElementNode(" + "identifier=" + "#" + identifier + "," + "value=" + "#" + value + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMetaAnnotationElementNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.identifier),
                translateUid(translationState, this.value),
                this.startLocation,
                this.stopLocation);
    }
    
}
