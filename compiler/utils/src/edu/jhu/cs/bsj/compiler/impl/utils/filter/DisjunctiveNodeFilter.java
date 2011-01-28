package edu.jhu.cs.bsj.compiler.impl.utils.filter;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

public class DisjunctiveNodeFilter<N extends Node> implements NodeFilter<N>
{
    private Iterable<? extends NodeFilter<? super N>> filters;

    public DisjunctiveNodeFilter(Iterable<? extends NodeFilter<? super N>> filters)
    {
        super();
        this.filters = filters;
    }

    @Override
    public boolean filter(N node)
    {
        for (NodeFilter<? super N> filter : filters)
        {
            if (filter.filter(node))
                return true;
        }
        return false;
    }
}
