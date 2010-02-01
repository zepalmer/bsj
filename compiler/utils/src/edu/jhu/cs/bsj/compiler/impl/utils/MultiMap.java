package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collection;
import java.util.Set;

/**
 * This data structure is a multimap, which is a one-to-many mapping; that is, each key can be mapped to many values.
 * This interface does not extend the {@link java.util.Map} interface because the documentation for {@link
 * java.util.Map} (in the J2SDK v1.4.1 API specification) states that "each key can map to at most one value" in a
 * {@link java.util.Map}.
 * <p/>
 * Despite this, many of the functions and functionality found on {@link java.util.Map} are provided here, albeit
 * modified to accomodate the different needs and behaviors of the multimap.
 *
 * @author Zachary Palmer
 */
public interface MultiMap<K,V>
{
// CONSTANTS /////////////////////////////////////////////////////////////////////

// NON-STATIC FIELDS /////////////////////////////////////////////////////////////

// NON-STATIC METHODS ////////////////////////////////////////////////////////////

    /**
     * Clears all mappings for this multimap.
     */
    public void clear();

    /**
     * Determines whether or not a mapping for the specified key is contained in this multimap.  The value of this call
     * is equivalent to the expression <ul> {@link MultiMap#getMappingsForKey(Object)
     * MultiMap.getMappingsForKey(key)}<code> &gt; 0</code> </ul>
     *
     * @param key The key for which mappings should be checked.
     * @return <code>true</code> if a mapping for the specified key exists in this multimap; <code>false</code>
     *         otherwise.
     */
    public boolean containsKey(K key);

    /**
     * Determines whether or not a mapping to the specified value exists in this multimap.
     *
     * @param value The value to be found in the multimap.
     * @return <code>true</code> if the value exists in the multimap; <code>false</code> otherwise.
     */
    public boolean containsValue(V value);

    /**
     * Retrieves all of the values mapped to the specified key in this multimap.  If there are no values mapped to the
     * specified key, an empty set is returned.  In either case, this set is <i>unmodifiable</i>.
     *
     * @param key The key for which the number of values should be retrieved.
     * @return A {@link Set} containing all of the values that are mapped to that key in this multimap.
     */
    public Set<V> getAll(K key);

    /**
     * Returns the number of keys in this map.
     *
     * @return The number of keys in this map.
     */
    public int getKeyCount();

    /**
     * Retrieves the key for a specific value.  If multiple keys are found, an arbitrary key which maps to that value is
     * returned.
     *
     * @param value The value for which to find a key.
     * @return A key to which the specified value is mapped, or <code>null</code> if that value is not found in this
     *         multimap.
     */
    public K getKeyFor(V value);

    /**
     * Returns the number of values in this map.
     *
     * @return The number of values in this map.
     */
    public int getValuesCount();

    /**
     * Determines the number of mappings this multimap contains for the specified key.
     *
     * @param key The key for which mappings need to be determined.
     * @return The number of mappings this multimap contains for the specified key, or <code>0</code> if there are
     *         none.
     */
    public int getMappingsForKey(K key);

    /**
     * Determines whether or not this multimap is empty.
     *
     * @return <code>true</code> if this multimap is empty; <code>false</code> if it is not.
     */
    public boolean isEmpty();

    /**
     * Retrieves the set of keys that are currently mapped in this multimap.
     *
     * @return A {@link Set} containing all of the keys for which mappings exist in this multimap.
     */
    public Set<K> keySet();

    /**
     * Adds a key-value pair to this multimap.
     *
     * @param key   The key to add to this map.
     * @param value The value to map to the specified key.
     */
    public void put(K key, V value);

    /**
     * Adds a set of key-value pairs to this multimap.  Each value in the set is added to this {@link MultiMap}
     * as a value mapped by the specified key.
     * @param key The key to add to this map.
     * @param values The {@link Set} of values to map to the specified key.
     */
    public void put(K key, Set<V> values);

    /**
     * Removes a key-value pair from this multimap.
     *
     * @param key   The key of the value to remove from this multimap.
     * @param value The value to remove from that key.
     * @return <code>true</code> if that value was mapped to the specified key; <code>false</code> otherwise.
     */
    public boolean remove(K key, V value);

    /**
     * Removes all values which are mapped to a specific key from this multimap.
     *
     * @param key The key to remove from this multimap, along with all of its mappings.
     * @return The {@link java.util.Set} of values mapped to that value.  Changes to this set do not affect the
     *         multimap.
     */
    public Set<V> removeAll(K key);

    /**
     * Returns a {@link java.util.Collection} of the values contained in this map.  If the same value is mapped to
     * multiple different keys, it will appear multiple times in this {@link java.util.Collection}.  The collection that
     * is provided is modifiable.
     *
     * @return A {@link java.util.Collection} that contains the values in this map.
     */
    public Collection<V> values();

    /**
     * Creates a duplicate of this {@link MultiMap}.  This method is similar to {@link Object#clone()} except in that
     * it returns a typed value.
     * @return A copy of this {@link MultiMap}.
     */
    public MultiMap<K,V> duplicate();
}
