package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This {@link Map} subtype represents a one-to-one mapping. All key-value pairings contain unique keys and unique
 * values. As with {@link Map}s, this interface maintains the behavior that if a mapping <i>K &#x2192; V</i> exists and
 * a mapping <i>K &#x2192; V'</i> is added, the original mapping is removed. In addition, this interface maintains the
 * same behavior for <i>K &#x2192; V</i> and <i>K' &#x2192; V</i> (respectively).
 * </p>
 * 
 * @author Zachary Palmer
 * 
 * @param <K> The key type in this map.
 * @param <V> The value type in this map.
 */
public interface BijectiveMap<K, V> extends Map<K, V>
{
    /**
     * Obtains a reversed version of this map. For all entries <i>E = K &#x2192; V</i> in this map, the resulting map
     * will contain an entry <i>E = V &#x2192; K</i>. Changes in the returned map will be reflected in this map.
     * 
     * @return The inversion of this map.
     */
    public BijectiveMap<V, K> invert();
    
    /**
     * Obtains a set of values for this bijective map.
     * @return The values contained in this bijective map.
     */
    public Set<V> values();
}
