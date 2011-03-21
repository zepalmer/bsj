/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.EnumModifiersNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumModifiersNodeSetStrictfpFlagPropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<Boolean>
{
    public EnumModifiersNodeSetStrictfpFlagPropertyEditScriptElementImpl(int metaprogramId, long targetId, Boolean value)
    {
        super(metaprogramId, targetId, value);
    }
    
    @Override
    public String getPropertyName()
    {
        return "strictfpFlag";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        EnumModifiersNode target = (EnumModifiersNode)patchState.getNode(this.getTargetId());
        target.setStrictfpFlag(this.getValue());
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".strictfpFlag := " + getValue();
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return EnumModifiersNodeProperties.STRICTFP_FLAG;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new EnumModifiersNodeSetStrictfpFlagPropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
