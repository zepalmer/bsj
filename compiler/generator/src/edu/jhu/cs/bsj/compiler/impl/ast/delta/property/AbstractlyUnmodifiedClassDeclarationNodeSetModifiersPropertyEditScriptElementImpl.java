/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.property;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AbstractlyUnmodifiedClassDeclarationNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AbstractlyUnmodifiedClassDeclarationNodeSetModifiersPropertyEditScriptElementImpl extends AbstractNodePropertyEditScriptElementImpl
{
    public AbstractlyUnmodifiedClassDeclarationNodeSetModifiersPropertyEditScriptElementImpl(int metaprogramId, long targetId, Long valueId)
    {
        super(metaprogramId, targetId, valueId);
    }
    
    @Override
    public String getPropertyName()
    {
        return "modifiers";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        this.applyActual(patchState);
    }
    
    private <T extends ModifiersNode> void applyActual(PatchState patchState)
    {
        updateProperty(patchState);
        Node value = (this.getValueId() == null) ? null : patchState.getNode(this.getValueId());
        // This @SupressWarnings is safe as long as the map is coherent.  This is to
        // say that every mapping from an ID to a node need not necessarily map to a
        // node of that ID but it must share the same type as the node of that ID.
        @SuppressWarnings("unchecked")
        AbstractlyUnmodifiedClassDeclarationNode<T> target = (AbstractlyUnmodifiedClassDeclarationNode<T>)patchState.getNode(this.getTargetId());
        final NodeUnion<? extends T> union;
        if (value instanceof SpliceNode)
        {
            union = new SpliceNodeUnion<T>((SpliceNode)value);
        } else 
        {
            // This @SupressWarnings is safe as long as the map is coherent.  This is to
            // say that every mapping from an ID to a node need not necessarily map to a
            // node of that ID but it must share the same type as the node of that ID.
            @SuppressWarnings("unchecked")
            final NodeUnion<? extends T> temp = new NormalNodeUnion<T>((T)value);
            union = temp;
        }
        target.setUnionForModifiers(union);
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".modifiers := " + (getValueId() == null ? "null" : "#" + getValueId());
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return AbstractlyUnmodifiedClassDeclarationNodeProperties.MODIFIERS;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new AbstractlyUnmodifiedClassDeclarationNodeSetModifiersPropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()),
                translateUid(translationState, getValueId()));
    }
    
}
