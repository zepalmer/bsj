/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AssignmentNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssignmentNodeSetOperatorPropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<AssignmentOperator>
{
    public AssignmentNodeSetOperatorPropertyEditScriptElementImpl(int metaprogramId, long targetId, AssignmentOperator value)
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
        AssignmentNode target = (AssignmentNode)patchState.getNode(this.getTargetId());
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
        return AssignmentNodeProperties.OPERATOR;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new AssignmentNodeSetOperatorPropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
