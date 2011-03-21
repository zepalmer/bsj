/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.RawCodeLiteralNodeProperties;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class RawCodeLiteralNodeSetValuePropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<BsjRawCodeLiteralPayload>
{
    public RawCodeLiteralNodeSetValuePropertyEditScriptElementImpl(int metaprogramId, long targetId, BsjRawCodeLiteralPayload value)
    {
        super(metaprogramId, targetId, value);
    }
    
    @Override
    public String getPropertyName()
    {
        return "value";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        RawCodeLiteralNode target = (RawCodeLiteralNode)patchState.getNode(this.getTargetId());
        target.setValue(this.getValue());
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".value := " + getValue();
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return RawCodeLiteralNodeProperties.VALUE;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new RawCodeLiteralNodeSetValuePropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
