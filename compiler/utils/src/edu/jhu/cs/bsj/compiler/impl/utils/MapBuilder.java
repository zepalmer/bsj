package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Uses the builder pattern for terse construction of a multi-element map.  By default, a hash map is constructed.
 * @author Zachary Palmer
 */
public class MapBuilder<K,V>
{
	private Map<K,V> map;
	
	public MapBuilder()
	{
		this.map = new HashMap<K, V>();
	}
	
	public MapBuilder(Map<K, V> map)
	{
		super();
		this.map = map;
	}

	public MapBuilder<K,V> add(K key, V value)
	{
		this.map.put(key, value);
		return this;
	}
	
	public Map<K,V> getMap()
	{
		return this.map;
	}
}
