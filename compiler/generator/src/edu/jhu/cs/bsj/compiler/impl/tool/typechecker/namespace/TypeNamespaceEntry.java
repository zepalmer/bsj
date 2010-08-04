package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

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
	private NamedTypeDeclarationNode<?> firstType;
	/** The first indicator node. */
	private Node firstIndicator;
	/** The types which are mapped to the specified name. */
	private Set<NamedTypeDeclarationNode<?>> types;
	/** A mapping from nodes which brought types into scope to the type declarations that they indicated. */
	private Map<Node, NamedTypeDeclarationNode<?>> indicatorNodeMap;

	public TypeNamespaceEntry(TypeNamespaceEntry other)
	{
		this.types = new HashSet<NamedTypeDeclarationNode<?>>(other.types);
		this.indicatorNodeMap = new HashMap<Node, NamedTypeDeclarationNode<?>>(other.indicatorNodeMap);
		this.firstType = other.firstType;
		this.firstIndicator = other.firstIndicator;
	}
	
	public TypeNamespaceEntry(NamedTypeDeclarationNode<?> type, Node indicator)
	{
		this.types = new HashSet<NamedTypeDeclarationNode<?>>();
		this.indicatorNodeMap = new HashMap<Node, NamedTypeDeclarationNode<?>>();
		add(type, indicator);
	}

	public void add(NamedTypeDeclarationNode<?> type, Node indicator)
	{
		if (this.types.size() == 0)
		{
			firstType = type;
			firstIndicator = indicator;
		}
		this.types.add(type);
		this.indicatorNodeMap.put(indicator, type);
	}

	public Set<NamedTypeDeclarationNode<?>> getTypes()
	{
		return types;
	}

	public Map<Node, NamedTypeDeclarationNode<?>> getIndicatorNodeMap()
	{
		return indicatorNodeMap;
	}

	public NamedTypeDeclarationNode<?> getFirstType()
	{
		return firstType;
	}

	public Node getFirstIndicator()
	{
		return firstIndicator;
	}
}
