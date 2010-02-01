package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This data structure is a multimap backed by {@link HashSet} and {@link HashMap} objects.  Each key in the multimap
 * represents a {@link HashSet} of values.
 *
 * @author Zachary Palmer
 */
public class HashMultiMap<K,V> implements Serializable, Cloneable, MultiMap<K, V>
{
// STATIC FIELDS /////////////////////////////////////////////////////////////////

	private static final long serialVersionUID = 1L;

// CONSTANTS /////////////////////////////////////////////////////////////////////

// NON-STATIC FIELDS /////////////////////////////////////////////////////////////

	/**
     * The {@link HashMap} of key {@link Object}s to value {@link HashSet}s.  The values that are mapped to a given key
     * are stored in a {@link HashSet} in this map and keyed by that value.
     */
    protected HashMap<K, Set<V>> map;

// CONSTRUCTORS //////////////////////////////////////////////////////////////////

    /**
     * General constructor.
     */
    public HashMultiMap()
    {
        super();
        map = new HashMap<K, Set<V>>();
    }

    /**
     * Private constructor.  Used for cloning.
     *
     * @param map The clone of the {@link HashMap} that the original multimap is using to create the clone.
     */
    private HashMultiMap(HashMap<K, Set<V>> map)
    {
        super();
        this.map = new HashMap<K, Set<V>>();
        for (K key : map.keySet())
        {
        	this.map.put(key, new HashSet<V>(map.get(key)));
        }
    }

// NON-STATIC METHODS ////////////////////////////////////////////////////////////

    /**
     * Clears all mappings for this multimap.
     */
    public void clear()
    {
        map.clear();
    }

    /**
     * Creates and returns a shallow copy of this multimap.  The keys and values themselves are not cloned.
     *
     * @return A clone of this multimap.
     */
    protected Object clone()
            throws CloneNotSupportedException
    {
        return new HashMultiMap<K, V>(map);
    }

    /**
     * Determines whether or not a mapping for the specified key is contained in this multimap.  The value of this call
     * is equivalent to the expression <UL> {@link HashMultiMap#getMappingsForKey(Object)
     * HashMultiMap.getMappingsForKey(key)}<code>&gt;0</code> </UL>
     *
     * @param key The key for which mappings should be checked.
     * @return <code>true</code> if a mapping for the specified key exists in this multimap; <code>false</code>
     *         otherwise.
     */
    public boolean containsKey(K key)
    {
        return (getMappingsForKey(key) > 0);
    }

    /**
     * Determines whether or not a mapping to the specified value exists in this multimap.  This operation does a linear
     * search of the values in the multimap; therefore, if the value exists in the multimap, search time averages
     * <code>O(n/2)</code> and, if the value does not exist in the multimap, search time is <code>O(n)</code>.
     *
     * @param value The value to be found in the multimap.
     * @return <code>true</code> if the value exists in the multimap; <code>false</code> otherwise.
     */
    public boolean containsValue(V value)
    {
        for (Set<V> vs : map.values())
        {
            for (V o : vs)
            {
                if (o.equals(value)) return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all of the values mapped to the specified key in this multimap.  If there are no values mapped to the
     * specified key, an empty set is returned.  In either case, this set is <i>unmodifiable</i>.
     *
     * @param key The key for which the number of values should be retrieved.
     * @return A {@link Set} containing all of the values that are mapped to that key in this multimap.
     */
    public Set<V> getAll(K key)
    {
        Set<V> set = map.get(key);
        if (set == null)
        {
            set = new HashSet<V>();
        } else
        {
            set = Collections.unmodifiableSet(set);
        }
        return set;
    }

    /**
     * Returns the number of keys in this map.
     *
     * @return The number of keys in this map.
     */
    public int getKeyCount()
    {
        return map.size();
    }

    /**
     * Retrieves the key for a specific value.  The execution time of this method is roughly <code>O(n)</code>, since
     * this method has to perform a linear search.  If multiple keys are found, the first is returned.
     *
     * @param value The value for which to find a key.
     * @return A key to which the specified value is mapped, or <code>null</code> if that value is not found in this
     *         multimap.
     */
    public K getKeyFor(V value)
    {
        for (K key : map.keySet())
        {
            if (map.get(key).contains(value)) return key;
        }
        return null;
    }

    /**
     * Returns the number of values in this map.
     *
     * @return The number of values in this map.
     */
    public int getValuesCount()
    {
        int count = 0;
        for (Set<V> vs : map.values())
        {
            count += vs.size();
        }
        return count;
    }

    /**
     * Determines the number of mappings this multimap contains for the specified key.
     *
     * @param key The key for which mappings need to be determined.
     * @return The number of mappings this multimap contains for the specified key, or <code>0</code> if there are
     *         none.
     */
    public int getMappingsForKey(K key)
    {
        return getAll(key).size();
    }

    /**
     * Determines whether or not this multimap is empty.
     *
     * @return <code>true</code> if this multimap is empty; <code>false</code> if it is not.
     */
    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    /**
     * Retrieves the set of keys that are currently mapped in this multimap.
     *
     * @return A {@link Set} containing all of the keys for which mappings exist in this multimap.
     */
    public Set<K> keySet()
    {
        return map.keySet();
    }

    /**
     * Adds a key-value pair to this multimap.
     *
     * @param key   The key to add to this map.
     * @param value The value to map to the specified key.
     */
    public void put(K key, V value)
    {
        Set<V> set = map.get(key);
        if (set == null)
        {
            set = new HashSet<V>();
            map.put(key, set);
        }
        set.add(value);
    }

    /**
     * Removes a key-value pair from this multimap.
     *
     * @param key   The key of the value to remove from this multimap.
     * @param value The value to remove from that key.
     * @return <code>true</code> if that value was mapped to the specified key; <code>false</code> otherwise.
     */
    public boolean remove(K key, V value)
    {
        Set<V> set = map.get(key);
        if (set == null) return false;
        return set.remove(value);
    }

    /**
     * Removes all values which are mapped to a specific key from this multimap.
     *
     * @param key The key to remove from this multimap, along with all of its mappings.
     * @return The {@link Set} of values mapped to that value.  Changes to this set do not affect the multimap.
     */
    public Set<V> removeAll(K key)
    {
        Set<V> set = map.remove(key);
        if (set == null)
        {
            set = new HashSet<V>();
        }
        return set;
    }

    /**
     * Returns a {@link Collection} of the values contained in this map.  If the same value is mapped to multiple
     * different keys, it will appear multiple times in this {@link Collection}.  The collection that is provided is
     * modifiable.
     *
     * @return A {@link Collection} that contains the values in this map.
     */
    public Collection<V> values()
    {
        ArrayList<V> ret = new ArrayList<V>();
        for (Set<V> set : map.values())
        {
            ret.addAll(set);
        }
        return ret;
    }

    /**
     * Creates a duplicate of this {@link HashMultiMap}.
     *
     * @return A duplicate of this {@link HashMultiMap}.
     */
    public MultiMap<K, V> duplicate()
    {
        MultiMap<K, V> ret = new HashMultiMap<K, V>();
        for (K key : keySet())
        {
            ret.put(key, getAll(key));
        }
        return ret;
    }

    /**
     * Adds a set of key-value pairs to this multimap.  Each value in the set is added to this {@link HashMultiMap} as a
     * value mapped by the specified key.
     *
     * @param key    The key to add to this map.
     * @param values The {@link Set} of values to map to the specified key.
     */
    public void put(K key, Set<V> values)
    {
        Set<V> set = map.get(key);
        if (set == null)
        {
            set = new HashSet<V>();
            map.put(key, set);
        }
        set.addAll(values);
    }

// STATIC METHODS ////////////////////////////////////////////////////////////////

}