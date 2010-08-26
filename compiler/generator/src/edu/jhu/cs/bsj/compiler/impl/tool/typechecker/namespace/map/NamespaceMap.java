package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
	/** The underlying maps which are being used. */
	private List<NamespaceMap<K, V>> deferenceMaps;
	/** The backing data structure which overlays the old map to represent this map's changes. */
	private Map<K, Entry<V>> backingMap;
	/** The diagnostic listener to which this namespace map reports errors. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;
	/** Indicates whether or not ambiguity analysis is performed eagerly in this map. */
	private boolean eager;
	/**
	 * Indicates whether or not this map prohibits overrides - that is, if additions should be prevented from hiding
	 * previous values. A <code>true</code> value indicates that the deference maps' values are included as well (such
	 * as in local variable scope where an inner local variable cannot shadow an outer one); a <code>false</code> value
	 * indicates that new mappings shadow old mappings (such as in a member type scope where fields can shadow the
	 * enclosing type's fields).
	 */
	private boolean prohibitsOverlap;
	/** Determines whether or not this namespace map is locked. */
	private boolean locked;
	/**
	 * A set containing those keys which this namespace map has erased. These keys may be mapped in the deference maps;
	 * however, this namespace map acts as if they are not present.
	 */
	private Set<K> blockedKeySet;

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

		this.deferenceMaps = new ArrayList<NamespaceMap<K, V>>(deferenceMaps);
		this.backingMap = new HashMap<K, Entry<V>>();
		this.blockedKeySet = new HashSet<K>(0);
	}

	/**
	 * Retrieves a collection of all keys in this namespace map which are mapped to a value.
	 * 
	 * @return The keys for this namespace map.
	 */
	public Collection<K> getKeys()
	{
		Set<K> ret = new HashSet<K>();
		for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
		{
			ret.addAll(deferenceMap.getKeys());
		}
		ret.addAll(this.backingMap.keySet());
		ret.removeAll(this.blockedKeySet);
		return Collections.unmodifiableSet(ret);
	}

	/**
	 * Retrieves all values mapped to a given key in this namespace map.
	 * 
	 * @param key The key to use.
	 * @return The values for the key.
	 */
	public Collection<V> getValues(K key)
	{
		if (this.backingMap.containsKey(key))
		{
			if (!this.prohibitsOverlap || this.deferenceMaps.size() == 0)
			{
				return Collections.unmodifiableSet(this.backingMap.get(key).getValues());
			} else
			{
				Set<V> ret = new HashSet<V>();
				ret.addAll(this.backingMap.get(key).getValues());
				for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
				{
					ret.addAll(deferenceMap.getValues(key));
				}
				return Collections.unmodifiableSet(ret);
			}
		} else if (this.blockedKeySet.contains(key))
		{
			return Collections.emptySet();
		} else if (this.deferenceMaps.size() == 0)
		{
			return Collections.emptySet();
		} else if (this.deferenceMaps.size() == 1)
		{
			return this.deferenceMaps.iterator().next().getValues(key);
		} else
		{
			Set<V> ret = new HashSet<V>();
			for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
			{
				ret.addAll(deferenceMap.getValues(key));
			}
			return Collections.unmodifiableSet(ret);
		}
	}

	/**
	 * Locks this namespace. A locked namespace cannot be modified; any attempts to do so produce a runtime error.
	 */
	public void lock()
	{
		if (!this.locked)
		{
			this.locked = true;
			checkAmbiguities();
		}
	}

	/**
	 * Checks this namespace for ambiguities and produces appropriate diagnostics if they exist. This method should be
	 * called at least once on each eager mapping after it is created. This method does nothing if the mapping is lazy.
	 */
	public void checkAmbiguities()
	{
		if (this.eager)
		{
			// Only concern ourselves with ambiguities which are locally mapped. Everything else has already been
			// checked by one of our deference maps.
			for (Map.Entry<K, Entry<V>> entry : this.backingMap.entrySet())
			{
				considerAmbiguity(entry.getKey(), entry.getValue().getFirstIndicator().getStartLocation());
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

		Entry<V> entry = this.backingMap.get(name);
		if (entry == null)
		{
			entry = new Entry<V>(element, indicator);
			this.backingMap.put(name, entry);
			notifyNewKey(name);
		} else
		{
			entry.add(element, indicator);
		}

	}

	protected List<NamespaceMap<K, V>> getDeferenceMaps()
	{
		return deferenceMaps;
	}

	protected Map<K, Entry<V>> getBackingMap()
	{
		return backingMap;
	}

	protected boolean isProhibitsOverlap()
	{
		return prohibitsOverlap;
	}

	protected Set<K> getBlockedKeySet()
	{
		return blockedKeySet;
	}

	/**
	 * Used to notify subclasses of the presence of a new key. This method is called to permit the subclass the
	 * opportunity to make changes to the backing map, which is provided as an argument. The default implementation
	 * takes no action.
	 * 
	 * @param key The key of the element that was added.
	 * @param backingMap The backing map that this method may modify.
	 */
	protected void notifyNewKey(K key)
	{
	}

	/**
	 * Determines whether or not an entry for the given name exists in this map.
	 * 
	 * @param key The name of the entry.
	 * @return <code>true</code> if that entry exists; <code>false</code> if it does not.
	 */
	public boolean contains(K key)
	{
		if (this.backingMap.containsKey(key))
			return true;

		if (this.blockedKeySet.contains(key))
			return false;

		for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
		{
			if (deferenceMap.contains(key))
				return true;
		}

		return false;
	}

	/**
	 * Retrieves a type element based on a name in this namespace.
	 * 
	 * @param key The name to use.
	 * @param sourceLocation The source location of the node which indicates this name.
	 * @return The corresponding type element or <code>null</code> if the specified key is not mapped.
	 */
	public V lookup(K key, BsjSourceLocation sourceLocation)
	{
		if (!this.eager)
		{
			considerAmbiguity(key, sourceLocation);
		}

		return doLookup(key);
	}

	/**
	 * Performs the lookup of a given key; this method does not perform ambiguity checking. It is therefore suitable to
	 * recurse on itself, as it will not generate redundant diagnostics.
	 * 
	 * @param key The key to look up.
	 * @return The appropriate value.
	 */
	protected V doLookup(K key)
	{
		if (this.backingMap.containsKey(key))
		{
			Entry<V> entry = this.backingMap.get(key);
			return entry.getFirstValue();
		} else if (this.blockedKeySet.contains(key))
		{
			return null;
		} else
		{
			for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
			{
				V ret = deferenceMap.doLookup(key);
				if (ret != null)
				{
					return ret;
				}
			}
		}

		return null;
	}

	/**
	 * Considers ambiguity for the provided name entry. If ambiguity exists, an appropriate diagnostic should be
	 * produced. The default implementation considers any entry with more than one value to be ambiguous.
	 * 
	 * @param key The name of the entry.
	 * @param sourceLocation The location to use in diagnostics. This is typically the location where the name was used.
	 */
	protected void considerAmbiguity(K key, BsjSourceLocation sourceLocation)
	{
		Collection<? extends V> all = getValues(key);
		if (all.size() > 1)
		{
			Collection<? extends Node> nodes = getIndicatorMapFor(key).keySet();
			this.diagnosticListener.report(new AmbiguousSymbolNameDiagnosticImpl(sourceLocation, key.toString(),
					this.symbolType, nodes));
		}
	}

	/**
	 * Retrieves a mapping from indicator nodes to the values which are mapped to a given name in the namespace map.
	 * This method is used for error reporting.
	 * 
	 * @param key The name to look up.
	 * @return The mapping.
	 */
	protected Map<? extends Node, ? extends V> getIndicatorMapFor(K key)
	{
		if (this.backingMap.containsKey(key) && (!this.prohibitsOverlap || this.blockedKeySet.contains(key)))
		{
			return Collections.unmodifiableMap(this.backingMap.get(key).getIndicatorNodeMap());
		} else if (this.blockedKeySet.contains(key))
		{
			return Collections.emptyMap();
		} else
		{
			Map<Node, V> ret = new HashMap<Node, V>();
			if (this.backingMap.containsKey(key))
			{
				ret.putAll(this.backingMap.get(key).getIndicatorNodeMap());
			}
			for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
			{
				Map<? extends Node, ? extends V> map = deferenceMap.getIndicatorMapFor(key);
				ret.putAll(map);
			}
			return Collections.unmodifiableMap(ret);
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
		return this.backingMap.size() == 0;
	}

	/**
	 * Determines whether or not this map is locked.
	 * 
	 * @return <code>true</code> if this map is locked; <code>false</code> if it is not.
	 */
	public boolean isLocked()
	{
		return locked;
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
		return this.locked && this.deferenceMaps.size() == 1 && this.deferenceMaps.iterator().next() == other
				&& other.isLocked() && this.isTransparent() && this.blockedKeySet.isEmpty();
	}

	/**
	 * Creates a string representation of this namespace.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder("{");
		boolean first = true;
		for (K key : getKeys())
		{
			if (!first)
				sb.append(", ");
			sb.append(key.toString());
			sb.append(" -> ");
			sb.append(stringOfElements(getValues(key)));
			first = false;
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Creates a string for an element collection.
	 * 
	 * @param elements The collection in question.
	 * @return The generated string.
	 */
	private static String stringOfElements(Collection<? extends BsjElement> elements)
	{
		if (elements.size() == 0)
		{
			return "{}";
		} else if (elements.size() == 1)
		{
			return elements.iterator().next().getDeclarationNode().getStartLocation().toString();
		} else
		{
			StringBuilder sb = new StringBuilder("{");
			boolean first = true;
			for (BsjElement element : elements)
			{
				if (!first)
					sb.append(", ");
				sb.append(element.getDeclarationNode().getStartLocation().toString());
				first = false;
			}
			sb.append("}");
			return sb.toString();
		}
	}

	/**
	 * The type of an entry in a namespace map. An entry is capable of storing multiple values and recording the first
	 * value which was stored with it.
	 */
	protected static class Entry<V extends BsjElement>
	{
		/** The first type which was provided to this entry. */
		private V firstValue;
		/** The first indicator which was provied to this entry. */
		private Node firstIndicator;
		/** The types which are mapped to the specified name. */
		private Set<V> values;
		/** A mapping from nodes which brought types into scope to the type declarations that they indicated. */
		private Map<Node, V> indicatorNodeMap;

		public Entry()
		{
			this.values = new HashSet<V>();
			this.indicatorNodeMap = new HashMap<Node, V>();
		}

		public Entry(V value, Node indicator)
		{
			this();
			add(value, indicator);
		}

		public Entry(Entry<V> entry)
		{
			this.values = new HashSet<V>(entry.values);
			this.indicatorNodeMap = new HashMap<Node, V>(entry.indicatorNodeMap);
			this.firstIndicator = entry.firstIndicator;
			this.firstValue = entry.firstValue;
		}

		public void add(V value, Node indicator)
		{
			if (this.values.size() == 0)
			{
				firstValue = value;
				firstIndicator = indicator;
			}
			this.values.add(value);
			this.indicatorNodeMap.put(indicator, value);
		}

		public Set<V> getValues()
		{
			return values;
		}

		public Map<Node, V> getIndicatorNodeMap()
		{
			return indicatorNodeMap;
		}

		public V getFirstValue()
		{
			return firstValue;
		}

		public Node getFirstIndicator()
		{
			return firstIndicator;
		}

		public Entry<V> duplicate()
		{
			return new Entry<V>(this);
		}

		public String toString()
		{
			return stringOfElements(getValues());
		}
	}
}
