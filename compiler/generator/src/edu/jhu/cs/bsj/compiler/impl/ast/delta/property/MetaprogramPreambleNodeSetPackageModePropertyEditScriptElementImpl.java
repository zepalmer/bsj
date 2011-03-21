/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNonNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaprogramPreambleNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPreambleNodeSetPackageModePropertyEditScriptElementImpl extends AbstractNonNodePropertyEditScriptElementImpl<MetaprogramPackageMode>
{
    public MetaprogramPreambleNodeSetPackageModePropertyEditScriptElementImpl(int metaprogramId, long targetId, MetaprogramPackageMode value)
    {
        super(metaprogramId, targetId, value);
    }
    
    @Override
    public String getPropertyName()
    {
        return "packageMode";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        MetaprogramPreambleNode target = (MetaprogramPreambleNode)patchState.getNode(this.getTargetId());
        target.setPackageMode(this.getValue());
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".packageMode := " + getValue();
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return MetaprogramPreambleNodeProperties.PACKAGE_MODE;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new MetaprogramPreambleNodeSetPackageModePropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()), getValue());
    }
    
}
