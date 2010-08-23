package edu.jhu.cs.bsj.compiler.impl.utils.filter;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This node filter will return all nodes which match a specified set of types.  The specified types must all be legal subtypes of
 * the type of node in the list.
 * @author Zachary Palmer
 *
 * @param <T> The base type of nodes in the list.
 * @param <U> The type of node to return; this should be a common supertype of all returned types.
 */
public class FilterByNodeTypes<T extends Node, U extends T> implements NodeFilter<T>
{
	private Iterable<? extends Class<? extends U>> subtypes;
	
	public FilterByNodeTypes(Iterable<? extends Class<? extends U>> subtypes)
	{
		super();
		this.subtypes = subtypes;
	}

	@Override
	public boolean filter(T node)
	{
		for (Class<? extends U> clazz : this.subtypes)
		{
			if (clazz.isInstance(node))
			{
				return true;
			}
		}
		return false;
	}

}
