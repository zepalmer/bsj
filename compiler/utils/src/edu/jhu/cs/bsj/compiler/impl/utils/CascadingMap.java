package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This {@link Map} implementation uses a cascading approach to key lookup.  It contains two backing maps.  When a
 * lookup occurs, the first map is checked.  If that map does not contain any such value, the second map is then
 * checked.  Values added to this map are added to the first backing map.
 * @param <K> The key type.
 * @param <V> The value type.
 * @author Zachary Palmer
 */
public class CascadingMap<K,V> extends AbstractMap<K,V> implements Map<K,V>
{
	/** The first backing map. */
	private Map<K,V> first;
	/** The second backing map. */
	private Map<K,V> second;
	
	/**
	 * Creates a cascading map using the specified backing maps.
	 * @param first The first backing map.
	 * @param second The second backing map.
	 */
	public CascadingMap(Map<K, V> first, Map<K, V> second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
		Set<java.util.Map.Entry<K, V>> backing = new HashSet<java.util.Map.Entry<K, V>>();
		backing.addAll(this.first.entrySet());
		for (Map.Entry<K,V> entry : this.second.entrySet())
		{
			if (!this.first.containsKey(entry.getKey()))
			{
				backing.add(entry);
			}
		}
		return new ProxySet<Entry<K,V>>(backing)
		{
			@Override
			protected void elementAdded(java.util.Map.Entry<K, V> element)
			{
			}

			@Override
			protected void elementRemoved(java.util.Map.Entry<K, V> element)
			{
				CascadingMap.this.first.remove(element.getKey());
				CascadingMap.this.second.remove(element.getKey());
			}

			@Override
			public boolean add(java.util.Map.Entry<K, V> e)
			{
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public V put(K key, V value)
	{
		if (this.first.containsKey(key))
		{
			return this.first.put(key, value);
		} else
		{
			this.first.put(key, value);
			return this.second.get(key);
		}
	}
}
