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
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateParameterizedTypeNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long baseType;
    private final Long typeArguments;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateParameterizedTypeNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long baseType,
            Long typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.baseType = baseType;
        this.typeArguments = typeArguments;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final UnparameterizedTypeNode baseTypeNode = 
                (UnparameterizedTypeNode)patchState.getNode(this.baseType);
        final NodeUnion<? extends UnparameterizedTypeNode> baseType;
        {
            final NodeUnion<? extends UnparameterizedTypeNode> union;
            if (baseTypeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<UnparameterizedTypeNode>((SpliceNode)baseTypeNode);
            } else 
            {
                union = new NormalNodeUnion<UnparameterizedTypeNode>((UnparameterizedTypeNode)baseTypeNode);
            }
            baseType = union;
        }
        final TypeArgumentListNode typeArgumentsNode = 
                (TypeArgumentListNode)patchState.getNode(this.typeArguments);
        final NodeUnion<? extends TypeArgumentListNode> typeArguments;
        {
            final NodeUnion<? extends TypeArgumentListNode> union;
            if (typeArgumentsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeArgumentListNode>((SpliceNode)typeArgumentsNode);
            } else 
            {
                union = new NormalNodeUnion<TypeArgumentListNode>((TypeArgumentListNode)typeArgumentsNode);
            }
            typeArguments = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ParameterizedTypeNode createdNode = patchState.getNodeFactory().makeParameterizedTypeNodeWithUnions(baseType,
                typeArguments,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ParameterizedTypeNode> getCreateType()
    {
        return ParameterizedTypeNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ParameterizedTypeNode(" + "baseType=" + "#" + baseType + "," + "typeArguments=" + "#" + typeArguments + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateParameterizedTypeNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.baseType),
                translateUid(translationState, this.typeArguments),
                this.startLocation,
                this.stopLocation);
    }
    
}
