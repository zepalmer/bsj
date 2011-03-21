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
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateArrayInstantiatorCreationNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long dimExpressions;
    private final Long baseType;
    private final int arrayLevels;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateArrayInstantiatorCreationNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long dimExpressions,
            Long baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.dimExpressions = dimExpressions;
        this.baseType = baseType;
        this.arrayLevels = arrayLevels;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final ExpressionListNode dimExpressionsNode = 
                (ExpressionListNode)patchState.getNode(this.dimExpressions);
        final NodeUnion<? extends ExpressionListNode> dimExpressions;
        {
            final NodeUnion<? extends ExpressionListNode> union;
            if (dimExpressionsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ExpressionListNode>((SpliceNode)dimExpressionsNode);
            } else 
            {
                union = new NormalNodeUnion<ExpressionListNode>((ExpressionListNode)dimExpressionsNode);
            }
            dimExpressions = union;
        }
        final BaseTypeNode baseTypeNode = 
                (BaseTypeNode)patchState.getNode(this.baseType);
        final NodeUnion<? extends BaseTypeNode> baseType;
        {
            final NodeUnion<? extends BaseTypeNode> union;
            if (baseTypeNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<BaseTypeNode>((SpliceNode)baseTypeNode);
            } else 
            {
                union = new NormalNodeUnion<BaseTypeNode>((BaseTypeNode)baseTypeNode);
            }
            baseType = union;
        }
        final int arrayLevels = this.arrayLevels;
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        ArrayInstantiatorCreationNode createdNode = patchState.getNodeFactory().makeArrayInstantiatorCreationNodeWithUnions(dimExpressions,
                baseType,
                arrayLevels,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<ArrayInstantiatorCreationNode> getCreateType()
    {
        return ArrayInstantiatorCreationNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":ArrayInstantiatorCreationNode(" + "dimExpressions=" + "#" + dimExpressions + "," + "baseType=" + "#" + baseType + "," + "arrayLevels=" + "{" + arrayLevels + "}" + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateArrayInstantiatorCreationNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.dimExpressions),
                translateUid(translationState, this.baseType),
                this.arrayLevels,
                this.startLocation,
                this.stopLocation);
    }
    
}
