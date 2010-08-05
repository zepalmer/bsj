package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.DeclaredTypeElementImpl;

/**
 * This class represents a single entry in the type namespace. On the happy path, this entry contains a single type
 * declaration. In other cases, this entry may contain more than one type declaration; this indicates that the entry is
 * ambiguous and an appropriate diagnostic should be raised. In order to support proper diagnostic messaging, the
 * indicators of each type declaration are preserved here.
 * 
 * @author Zachary Palmer
 */
public class TypeNamespaceEntry
{
	/** The first type which was provided to this entry. */
	private DeclaredTypeElementImpl<?> firstType;
	/** The first indicator node. */
	private Node firstIndicator;
	/** The types which are mapped to the specified name. */
	private Set<DeclaredTypeElementImpl<?>> types;
	/** A mapping from nodes which brought types into scope to the type declarations that they indicated. */
	private Map<Node, DeclaredTypeElementImpl<?>> indicatorNodeMap;

	public TypeNamespaceEntry(TypeNamespaceEntry other)
	{
		this.types = new HashSet<DeclaredTypeElementImpl<?>>(other.types);
		this.indicatorNodeMap = new HashMap<Node, DeclaredTypeElementImpl<?>>(other.indicatorNodeMap);
		this.firstType = other.firstType;
		this.firstIndicator = other.firstIndicator;
	}
	
	public TypeNamespaceEntry(DeclaredTypeElementImpl<?> type, Node indicator)
	{
		this.types = new HashSet<DeclaredTypeElementImpl<?>>();
		this.indicatorNodeMap = new HashMap<Node, DeclaredTypeElementImpl<?>>();
		add(type, indicator);
	}

	public void add(DeclaredTypeElementImpl<?> type, Node indicator)
	{
		if (this.types.size() == 0)
		{
			firstType = type;
			firstIndicator = indicator;
		}
		this.types.add(type);
		this.indicatorNodeMap.put(indicator, type);
	}

	public Set<DeclaredTypeElementImpl<?>> getTypes()
	{
		return types;
	}

	public Map<Node, DeclaredTypeElementImpl<?>> getIndicatorNodeMap()
	{
		return indicatorNodeMap;
	}

	public DeclaredTypeElementImpl<?> getFirstType()
	{
		return firstType;
	}

	public Node getFirstIndicator()
	{
		return firstIndicator;
	}
}
