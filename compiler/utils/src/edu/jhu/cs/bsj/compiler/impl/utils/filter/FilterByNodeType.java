package edu.jhu.cs.bsj.compiler.impl.utils.filter;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This node filter will return all nodes which match a specified type.  The specified type must be a legal subtype of
 * the type of node in the list.
 * @author Zachary Palmer
 *
 * @param <T> The base type of nodes in the list.
 * @param <U> The type of node to return.
 */
public class FilterByNodeType<T extends Node, U extends T> implements NodeFilter<T>
{
	private Class<U> nodeClass;
	
	public FilterByNodeType(Class<U> nodeClass)
	{
		super();
		this.nodeClass = nodeClass;
	}

	@Override
	public boolean filter(T node)
	{
		return this.nodeClass.isInstance(node);
	}

}
