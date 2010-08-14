package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.AmbiguousSymbolNameDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

/**
 * A mapping which is used to represent a namespace. This is a mapping from simple names to the declarations to which
 * they refer. In other words, instances of this class represent the symbol tables in a given scope.
 * <p/>
 * It is possible for a single key to be mapped to multiple declarations. In this case, the mapping itself is ambiguous
 * and a diagnostic message may be generated. Each map reports errors in either an <i>eager</i> map or a <i>lazy</i>
 * fashion; eager error reporting causes ambiguities to be raised when the map is completed while lazy reporting causes
 * them to be raised whenever the corresponding key is accessed. In either event, an arbitrary but consistent value is
 * always returned in order to permit type-checking to continue.
 * <p/>
 * A namespace map is capable of being constructed based on the contents of other namespace maps. This can be used to
 * support cascading namespaces, allowing the declarations imported by single-type imports to override those imported by
 * on-demand imports. For the purposes of supporting inheritance, multiple backing namespace maps can be used.
 * 
 * @author Zachary Palmer
 */
public class NamespaceMap<K, V extends BsjElement>
{
	/** The symbol type that this map will use when reporting errors. */
	private SymbolType symbolType;
	/** The backing data structure which maintains an image of this map's original state. */
	private Map<K, Entry<V>> oldMap;
	/** The backing data structure which overlays the old map to represent this map's changes. */
	private Map<K, Entry<V>> newMap;
	/** The diagnostic listener to which this namespace map reports errors. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	/** Indicates whether or not ambiguity analysis is performed eagerly in this map. */
	private boolean eager;
	/**
	 * Indicates whether or not this map prohibits overrides - that is, if additions should be prevented from hiding
	 * previous values.
	 */
	private boolean prohibitsOverlap;
	/** Determines whether or not this namespace map is locked. */
	private boolean locked;

	/**
	 * Contains the single deference map from which this map was constructed or <code>null</code> if this map was not
	 * created from exactly one underlying map.
	 */
	private NamespaceMap<K, V> singleDeferenceMap;

	/**
	 * Creates a new namespace map.
	 */
	public NamespaceMap(SymbolType symbolType, Collection<? extends NamespaceMap<K, V>> deferenceMaps,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean eager, boolean prohibitsOverlap)
	{
		this.symbolType = symbolType;
		this.diagnosticListener = diagnosticListener;
		this.eager = eager;
		this.prohibitsOverlap = prohibitsOverlap;
		this.locked = false;
		this.singleDeferenceMap = null;

		if (deferenceMaps.size() == 0)
		{
			this.oldMap = Collections.emptyMap();
		} else if (deferenceMaps.size() == 1)
		{
			this.singleDeferenceMap = deferenceMaps.iterator().next();
			this.oldMap = this.singleDeferenceMap.getMapView();
		} else
		{
			this.oldMap = new HashMap<K, NamespaceMap.Entry<V>>();
			for (NamespaceMap<K, V> deferenceMap : deferenceMaps)
			{
				for (Map.Entry<K, Entry<V>> mapEntry : deferenceMap.getMapView().entrySet())
				{
					if (this.oldMap.containsKey(mapEntry.getKey()))
					{
						for (Map.Entry<Node, V> entryEntry : mapEntry.getValue().getIndicatorNodeMap().entrySet())
						{
							this.oldMap.get(mapEntry.getKey()).add(entryEntry.getValue(), entryEntry.getKey());
						}
					} else
					{
						this.oldMap.put(mapEntry.getKey(), mapEntry.getValue().duplicate());
					}
				}
			}
		}

		this.newMap = new HashMap<K, NamespaceMap.Entry<V>>();
	}

	private Map<K, Entry<V>> getMapView()
	{
		Map<K, Entry<V>> ret = new HashMap<K, Entry<V>>();
		ret.putAll(this.oldMap);
		for (K name : this.newMap.keySet())
		{
			ret.remove(name);
			ret.put(name, this.newMap.get(name));
		}
		return ret;
	}

	/**
	 * Locks this namespace. A locked namespace cannot be modified; any attempts to do so produce a runtime error.
	 */
	public void lock()
	{
		this.locked = true;
	}

	/**
	 * Checks this namespace for ambiguities and produces appropriate diagnostics if they exist. This method should be
	 * called at least once on each eager mapping after it is created. This method does nothing if the mapping is lazy.
	 */
	public void checkAmbiguities()
	{
		// TODO: this is producing the same diagnostic over and over because inherited maps notice the problem - fix
		// could we only report ambiguities on things in the new map?
		if (this.eager)
		{
			for (K key : getNames())
			{
				Entry<V> e = getRelevantEntry(key);
				considerAmbiguity(key, e.getFirstIndicator().getStartLocation());
			}
		}
	}

	/**
	 * Adds a new name to this namespace map.
	 * 
	 * @param name The name to add.
	 * @param element The type element to which the name corresponds.
	 * @param indicator The node which was responsible for indicating this mapping.
	 * @throws IllegalStateException If this environment has been locked.
	 */
	public void add(K name, V element, Node indicator)
	{
		if (this.locked)
			throw new IllegalStateException("Attempted to modify locked namespace map");
		if (element == null)
			throw new IllegalStateException("Attempted to store null value in namespace map");
		if (indicator == null)
			throw new IllegalStateException("Attempted to store null indicator in namespace map");

		Entry<V> entry = this.newMap.get(name);
		if (entry == null)
		{
			if (this.prohibitsOverlap && this.oldMap.containsKey(name))
			{
				entry = this.oldMap.get(name).duplicate();
			} else
			{
				entry = new Entry<V>(element, indicator);
			}
			this.newMap.put(name, entry);
			// Get rid of any entry in the old map as it is no longer relevant
			removeOld(name, this.oldMap);
		}

		entry.add(element, indicator);

	}

	/**
	 * Removes old entries from the underlying old entry map.  This method is called when new entries are added to the
	 * map.  The default implementation of this method simply removes any entry associated with the specified key from
	 * the map.  Subclasses may choose to override this functionality as necessary.
	 * @param name The name of the element that was just added.
	 * @param oldMap The map containing this object's old values.
	 */
	protected void removeOld(K name, Map<K, Entry<V>> oldMap)
	{
		if (oldMap.containsKey(name))
		{
			oldMap.remove(name);
		}
	}

	/**
	 * Determines whether or not an entry for the given name exists in this map.
	 * 
	 * @param name The name of the entry.
	 * @return <code>true</code> if that entry exists; <code>false</code> if it does not.
	 */
	public boolean contains(K name)
	{
		return this.newMap.containsKey(name) || this.oldMap.containsKey(name);
	}

	/**
	 * Retrieves the currently relevant entry for a given name, if any.
	 * 
	 * @param name The name.
	 * @return The current entry or <code>null</code> if no entry exists.
	 */
	private Entry<V> getRelevantEntry(K name)
	{
		Entry<V> ret = this.newMap.get(name);
		if (ret == null)
		{
			ret = this.oldMap.get(name);
		}
		return ret;
	}

	/**
	 * Retrieves a type element based on a name in this namespace.
	 * 
	 * @param name The name to use.
	 * @param sourceLocation The source location of the node which indicates this name.
	 * @return The corresponding type element.
	 */
	public V lookup(K name, BsjSourceLocation sourceLocation)
	{
		Entry<V> entry = getRelevantEntry(name);
		if (entry == null)
		{
			return null;
		}

		if (!this.eager)
		{
			considerAmbiguity(name, sourceLocation);
		}
		return entry.getFirstValue();
	}

	/**
	 * Considers ambiguity for the provided name entry. If ambiguity exists, an appropriate diagnostic should be
	 * produced. The default implementation considers any entry with more than one value to be ambiguous.
	 * 
	 * @param name The name of the entry.
	 * @param sourceLocation The location to use in diagnostics. This is typically the location where the name was used.
	 */
	protected void considerAmbiguity(K name, BsjSourceLocation sourceLocation)
	{
		Collection<? extends V> all = getAll(name);
		if (all.size() > 1)
		{
			Collection<? extends Node> nodes = getIndicatorMapFor(name).keySet();
			this.diagnosticListener.report(new AmbiguousSymbolNameDiagnosticImpl(sourceLocation, name.toString(),
					this.symbolType, nodes));
		}
	}

	/**
	 * Retrieves all of the names mapped in this namespace map.
	 * 
	 * @return The names mapped in this namespace map.
	 */
	public Collection<? extends K> getNames()
	{
		Set<K> ret = new HashSet<K>();
		ret.addAll(this.newMap.keySet());
		ret.addAll(this.oldMap.keySet());
		return ret;
	}

	/**
	 * Retrieves all of the values which are mapped to the specified name in this namespace map.
	 * 
	 * @param name The name to look up.
	 * @return The entries which are mapped to that name in the namespace map.
	 */
	public Collection<? extends V> getAll(K name)
	{
		Entry<V> entry = getRelevantEntry(name);
		if (entry == null)
		{
			return Collections.emptySet();
		} else
		{
			return entry.getValues();
		}
	}

	/**
	 * Retrieves a mapping from indicator nodes to the values which are mapped to a given name in the namespace map.
	 * This method is used for error reporting.
	 * 
	 * @param name The name to look up.
	 * @return The mapping.
	 */
	protected Map<? extends Node, ? extends V> getIndicatorMapFor(K name)
	{
		Entry<V> entry = getRelevantEntry(name);
		if (entry == null)
		{
			return Collections.emptyMap();
		} else
		{
			return entry.getIndicatorNodeMap();
		}
	}

	/**
	 * Determines whether or not this type namespace is transparent. A transparent type namespace does not add any
	 * information over its backing namespace. This is a relatively trivial property which indicates that no name
	 * mappings have been added. This may happen if, for example, the body of a method does not declare any local
	 * classes; in that case, the type namespace created for the method body would be transparent (and thus
	 * discardable).
	 * 
	 * @return <code>true</code> if this namespace is transparent; <code>false</code> if it is not.
	 */
	public boolean isTransparent()
	{
		return this.newMap.size() == 0;
	}

	/**
	 * This method implements a high-performance, low-assurance check to determine whether or not this map and the
	 * provided map are equivalent. If this method returns <code>true</code>, such an action is always legal; if this
	 * method returns <code>false</code>, such an action <i>might</i> not be. That is, this method does not define an
	 * equivalence relation because it may return <code>false</code> for equivalent values. It is not necessarily
	 * transitive or symmetric. It is written to execute using few CPU resources by capturing the most common cases of
	 * equivalence in this type checker.
	 */
	public boolean definitelyReplacableBy(NamespaceMap<K, V> other)
	{
		if (this.singleDeferenceMap == other && other != null && this.isTransparent() && this.singleDeferenceMap.locked
				&& this.locked)
			return true;

		return false;
	}
	
	/**
	 * Creates a string representation of this namespace.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("{");
		boolean first = true;
		for (Map.Entry<K, Entry<V>> mapEntry : getMapView().entrySet())
		{
			if (!first)
				sb.append(", ");
			sb.append(mapEntry.getKey());
			sb.append(" -> ");
			sb.append(mapEntry.getValue().toString());
			first = false;
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * The type of an entry in a namespace map. An entry is capable of storing multiple values and recording the first
	 * value which was stored with it.
	 */
	protected static class Entry<T extends BsjElement>
	{
		/** The first type which was provided to this entry. */
		private T firstValue;
		/** The first indicator which was provied to this entry. */
		private Node firstIndicator;
		/** The types which are mapped to the specified name. */
		private Set<T> values;
		/** A mapping from nodes which brought types into scope to the type declarations that they indicated. */
		private Map<Node, T> indicatorNodeMap;

		public Entry()
		{
			this.values = new HashSet<T>();
			this.indicatorNodeMap = new HashMap<Node, T>();
		}

		public Entry(T value, Node indicator)
		{
			this();
			add(value, indicator);
		}

		public Entry(Entry<T> entry)
		{
			this.values = new HashSet<T>(entry.values);
			this.indicatorNodeMap = new HashMap<Node, T>(entry.indicatorNodeMap);
			this.firstIndicator = entry.firstIndicator;
			this.firstValue = entry.firstValue;
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

		public Entry<T> duplicate()
		{
			return new Entry<T>(this);
		}

		public String toString()
		{
			if (this.values.size() == 0)
			{
				return "{}";
			} else if (this.values.size() == 1)
			{
				return this.values.iterator().next().getDeclarationNode().getStartLocation().toString();
			} else
			{
				StringBuilder sb = new StringBuilder("{");
				boolean first = true;
				for (T t : this.values)
				{
					if (!first)
						sb.append(", ");
					sb.append(t.getDeclarationNode().getStartLocation().toString());
				}
				sb.append("}");
				return sb.toString();
			}
		}
	}
}
