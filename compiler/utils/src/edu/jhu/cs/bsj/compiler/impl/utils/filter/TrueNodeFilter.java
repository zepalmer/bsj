package edu.jhu.cs.bsj.compiler.impl.utils.filter;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A node filter which always returns <code>true</code>.
 * @author Zachary Palmer
 *
 * @param <T> The type of node to filter.
 */
public class TrueNodeFilter<T extends Node> implements NodeFilter<T>
{
    private static final TrueNodeFilter<?> SINGLETON = new TrueNodeFilter<Node>();
    
    public static <T extends Node> TrueNodeFilter<T> instance()
    {
        // This SuppressWarnings is safe because the singleton instance is immutable and doesn't use its type parameter
        // for anything.
        @SuppressWarnings("unchecked")
        TrueNodeFilter<T> ret = (TrueNodeFilter<T>) SINGLETON;
        return ret;
    }

    @Override
    public boolean filter(T node)
    {
        return true;
    }
}
