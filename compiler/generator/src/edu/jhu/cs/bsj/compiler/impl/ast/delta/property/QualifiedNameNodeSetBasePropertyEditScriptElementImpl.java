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
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractNodePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperty;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.QualifiedNameNodeProperties;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedNameNodeSetBasePropertyEditScriptElementImpl extends AbstractNodePropertyEditScriptElementImpl
{
    public QualifiedNameNodeSetBasePropertyEditScriptElementImpl(int metaprogramId, long targetId, Long valueId)
    {
        super(metaprogramId, targetId, valueId);
    }
    
    @Override
    public String getPropertyName()
    {
        return "base";
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        updateProperty(patchState);
        Node value = (this.getValueId() == null) ? null : patchState.getNode(this.getValueId());
        QualifiedNameNode target = (QualifiedNameNode)patchState.getNode(this.getTargetId());
        final NodeUnion<? extends NameNode> union;
        if (value instanceof SpliceNode)
        {
            union = new SpliceNodeUnion<NameNode>((SpliceNode)value);
        } else 
        {
            union = new NormalNodeUnion<NameNode>((NameNode)value);
        }
        target.setUnionForBase(union);
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]#" + getTargetId() + ".base := " + (getValueId() == null ? "null" : "#" + getValueId());
    }
    
    @Override
    public NodeProperty getProperty()
    {
        return QualifiedNameNodeProperties.BASE;
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        return new QualifiedNameNodeSetBasePropertyEditScriptElementImpl(getMetaprogramId(), translateUid(translationState, getTargetId()),
                translateUid(translationState, getValueId()));
    }
    
}
