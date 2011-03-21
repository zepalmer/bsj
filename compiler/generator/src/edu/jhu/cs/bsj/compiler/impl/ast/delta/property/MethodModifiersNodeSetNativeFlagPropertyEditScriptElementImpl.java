/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MethodModifiersNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodModifiersNodeSetNativeFlagPropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<Boolean>
{
    public MethodModifiersNodeSetNativeFlagPropertyEditScriptElementImpl(int metaprogramId, long targetId, Boolean value)
    {
        super(metaprogramId, targetId, value);
    }
    
    @Override
    public String getPropertyName()
    {
        return "nativeFlag";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        MethodModifiersNode target = (MethodModifiersNode)patchState.getNode(this.getTargetId());
        target.setNativeFlag(this.getValue());
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".nativeFlag := " + getValue();
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return MethodModifiersNodeProperties.NATIVE_FLAG;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new MethodModifiersNodeSetNativeFlagPropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
