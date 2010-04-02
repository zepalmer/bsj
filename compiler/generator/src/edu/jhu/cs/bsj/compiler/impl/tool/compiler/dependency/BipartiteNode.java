package edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/**
 * A class representing a node in a directed bipartite graph.
 * 
 * @author Zachary Palmer
 * 
 * @param T The type of information stored at this node.
 * @param U The type of information stored at nodes adjacent to this one.
 * @param TE The type of information stored on each edge leaving this type of node.
 * @param UE The type of information stored on each edge entering this type of node.
 */
public class BipartiteNode<T, U, TE, UE>
{
	/** A set containing the nodes which are connected by edges leaving this node. */
	private Map<BipartiteNode<U, T, UE, TE>, TE> children;
	/** A set containing the nodes which are connected by edges entering this node. */
	private Map<BipartiteNode<U, T, UE, TE>, UE> parents;
	/** The data stored in this node. */
	private T data;

	/**
	 * Creates a new bipartite node with no edges.
	 * @param data The data to store in this node.
	 */
	public BipartiteNode(T data)
	{
		this.children = new HashMap<BipartiteNode<U, T, UE, TE>, TE>();
		this.parents = new HashMap<BipartiteNode<U, T, UE, TE>, UE>();
		this.data = data;
	}
	
	/**
	 * Retrieves the data stored in this node.
	 * @return The data stored in this node.
	 */
	public T getData()
	{
		return data;
	}

	/**
	 * Retrieves the children of this node.  Changing this set will have no effect on the connectivity of the graph.
	 * 
	 * @return The children of this node paired with their edge data.
	 */
	public Set<Pair<BipartiteNode<U, T, UE, TE>, TE>> getChildren()
	{
		return CollectionUtilities.getPairSet(this.children);
	}

	/**
	 * Retrieves the parents of this node. Changing this set will have no effect on the connectivity of the graph.
	 * 
	 * @return The parents of this node paired with their edge data.
	 */
	public Set<Pair<BipartiteNode<U, T, UE, TE>, UE>> getParents()
	{
		return CollectionUtilities.getPairSet(this.parents);
	}
	
	/**
	 * Retrieves all of the second level children of this node. Changing this set will have no effect on the connectivity of the graph.
	 * @return The grandchildren of this node.  
	 */
	public Set<BipartiteNode<T, U, TE, UE>> getGrandchildren()
	{
		Set<BipartiteNode<T, U, TE, UE>> set = new HashSet<BipartiteNode<T,U,TE,UE>>();
		for (BipartiteNode<U, T, UE, TE> child : this.children.keySet())
		{
			set.addAll(child.children.keySet());
		}
		return set;
	}
	
	/**
	 * Retrieves all of the second level parents of this node. Changing this set will have no effect on the connectivity of the graph.
	 * @return The grandparents of this node.  
	 */
	public Set<BipartiteNode<T, U, TE, UE>> getGrandparents()
	{
		Set<BipartiteNode<T, U, TE, UE>> set = new HashSet<BipartiteNode<T,U,TE,UE>>();
		for (BipartiteNode<U, T, UE, TE> parent : this.parents.keySet())
		{
			set.addAll(parent.parents.keySet());
		}
		return set;
	}
	
	/**
	 * Adds a new element to one of this node's maps.  Optionally, adds this node to one of the adjacent node's maps.
	 * This method is used internally to ensure bidirectional consistency.
	 * @param ourMap The map on this node we are modifying.
	 * @param other The node we are adding to the map.
	 * @param edge The data to associate with the added edge.
	 * @param otherMap The map on the other node to which to add this node or <code>null</code> if no such add should
	 * occur.
	 */
	private <E> void add(Map<BipartiteNode<U, T, UE, TE>, E> ourMap, BipartiteNode<U, T, UE, TE> other, E edge,
			Map<BipartiteNode<T, U, TE, UE>, E> otherMap)
	{
		ourMap.put(other, edge);
		if (otherMap != null)
		{
			other.add(otherMap, this, edge, null);
		}
	}

	/**
	 * Adds a new child to this node.
	 * @param child The child to add.
	 * @param edge The data to associate with this edge.
	 */
	public void addChild(BipartiteNode<U, T, UE, TE> child, TE edge)
	{
		add(this.children, child, edge, child.parents);
	}

	/**
	 * Adds a new parent to this node.
	 * @param parent The parent to add.
	 * @param edge The data to associate with this edge.
	 */
	public void addParent(BipartiteNode<U, T, UE, TE> parent, UE edge)
	{
		add(this.parents, parent, edge, parent.children);
	}
}
