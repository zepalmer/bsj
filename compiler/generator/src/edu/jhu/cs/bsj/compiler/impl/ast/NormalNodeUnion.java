/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;

/**
 * Represents a {@link NodeUnion} containing a normal value.
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class NormalNodeUnion<T extends Node> implements NodeUnion<T>
{
    private T node;
    
    public NormalNodeUnion(T node)
    {
        super();
        this.node = node;
    }
    
    @Override
    public Node getNodeValue()
    {
        return this.node;
    }
    
    @Override
    public T getNormalNode() throws ClassCastException
    {
        return this.node;
    }
    
    @Override
    public SpliceNode getSpliceNode() throws ClassCastException
    {
        throw new ClassCastException("Attempted to retrieve normal node value as a splice node value.");
    }
    
    public <E extends Node> NodeUnion<E> castNodeType(BsjNodeFactory factory, Class<E> type)
    {
        return factory.<E>makeNormalNodeUnion(type.cast(this.getNormalNode()));
    }
    
    @Override
    public Type getType()
    {
        return Type.NORMAL;
    }
    
    @Override
    public String toString()
    {
        return "NormalNodeUnion(" + String.valueOf(getNodeValue()) + ")";
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof NormalNodeUnion<?>)
        {
            NormalNodeUnion<?> other = (NormalNodeUnion<?>)o;
            return (this.getNormalNode().equals(other.getNormalNode()));
        } else
        {
            return false;
        }
    }
    
    @Override
    public int hashCode()
    {
        Node n = this.getNormalNode();
        return (n == null ? 0 : n.hashCode()) * 4;
    }
    
}
