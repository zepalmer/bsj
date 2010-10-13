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
 * Represents a {@link NodeUnion} containing a splice value.
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SpliceNodeUnion<T extends Node> implements NodeUnion<T>
{
    private SpliceNode node;
    
    public SpliceNodeUnion(SpliceNode node)
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
        throw new ClassCastException("Attempted to retrieve splice node value as a normal node value.");
    }
    
    @Override
    public SpliceNode getSpliceNode() throws ClassCastException
    {
        return this.node;
    }
    
    public <E extends Node> NodeUnion<E> castNodeType(BsjNodeFactory factory, Class<E> type)
    {
        return factory.<E>makeSpliceNodeUnion(this.getSpliceNode());
    }
    
    @Override
    public Type getType()
    {
        return Type.SPLICE;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof SpliceNodeUnion<?>)
        {
            SpliceNodeUnion<?> other = (SpliceNodeUnion<?>)o;
            return (this.getSpliceNode().equals(other.getSpliceNode()));
        } else
        {
            return false;
        }
    }
    
    @Override
    public int hashCode()
    {
        Node n = this.getSpliceNode();
        return (n == null ? 0 : n.hashCode()) * 4 + 1;
    }
    
}
