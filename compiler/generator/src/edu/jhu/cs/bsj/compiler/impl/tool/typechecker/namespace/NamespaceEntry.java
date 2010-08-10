package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This class represents a single entry in the type namespace. On the happy path, this entry contains a single type
 * declaration. In other cases, this entry may contain more than one type declaration; this indicates that the entry is
 * ambiguous and an appropriate diagnostic should be raised. In order to support proper diagnostic messaging, the
 * indicators of each type declaration are preserved here.
 * 
 * @author Zachary Palmer
 */
public class NamespaceEntry<T extends Element>
{
	/** The first type which was provided to this entry. */
	private T firstValue;
	/** The first indicator node. */
	private Node firstIndicator;
	/** The types which are mapped to the specified name. */
	private Set<T> values;
	/** A mapping from nodes which brought types into scope to the type declarations that they indicated. */
	private Map<Node, T> indicatorNodeMap;

	public NamespaceEntry(T value, Node indicator)
	{
		this.values = new HashSet<T>();
		this.indicatorNodeMap = new HashMap<Node, T>();
		add(value, indicator);
	}

	public void add(T value, Node indicator)
	{
		if (this.values.size() == 0)
		{
			firstValue = value;
			firstIndicator = indicator;
		}
		this.values.add(value);
		this.indicatorNodeMap.put(indicator, value);
	}

	public Set<T> getValues()
	{
		return values;
	}

	public Map<Node, T> getIndicatorNodeMap()
	{
		return indicatorNodeMap;
	}

	public T getFirstValue()
	{
		return firstValue;
	}

	public Node getFirstIndicator()
	{
		return firstIndicator;
	}
}
