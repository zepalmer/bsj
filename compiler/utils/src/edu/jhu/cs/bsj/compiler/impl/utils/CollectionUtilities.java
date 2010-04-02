package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A utilities class for collection operations in the BSJ compiler.
 * @author Zachary Palmer
 */
public class CollectionUtilities
{
	/**
	 * Prevent instantiation of utilities class.
	 */
	private CollectionUtilities()
	{
	}
	
	/**
	 * Creates a set containing pairs representing the key-value pairs in the provided map.
	 * @param map The map containing the key-value pairs.
	 * @return The collection of pairs to use.
	 */
	public static <K,V> Set<Pair<K,V>> getPairSet(Map<K,V> map)
	{
		Set<Pair<K,V>> set = new HashSet<Pair<K,V>>();
		for (Map.Entry<K,V> entry : map.entrySet())
		{
			set.add(new Pair<K, V>(entry.getKey(), entry.getValue()));
		}
		return set;
	}
}
