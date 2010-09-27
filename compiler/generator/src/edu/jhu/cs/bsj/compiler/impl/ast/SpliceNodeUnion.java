package edu.jhu.cs.bsj.compiler.impl.ast;

import javax.annotation.Generated;

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
    
    @Override
    public Type getType()
    {
        return Type.SPLICE;
    }
    
}
