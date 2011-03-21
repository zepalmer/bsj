/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.UnaryOperator;
import edu.jhu.cs.bsj.compiler.ast.node.UnaryExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.UnaryExpressionNodeProperties;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnaryExpressionNodeSetOperatorPropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<UnaryOperator>
{
    public UnaryExpressionNodeSetOperatorPropertyEditScriptElementImpl(int metaprogramId, long targetId, UnaryOperator value)
    {
        super(metaprogramId, targetId, value);
    }
    
    @Override
    public String getPropertyName()
    {
        return "operator";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        UnaryExpressionNode target = (UnaryExpressionNode)patchState.getNode(this.getTargetId());
        target.setOperator(this.getValue());
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".operator := " + getValue();
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return UnaryExpressionNodeProperties.OPERATOR;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new UnaryExpressionNodeSetOperatorPropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
