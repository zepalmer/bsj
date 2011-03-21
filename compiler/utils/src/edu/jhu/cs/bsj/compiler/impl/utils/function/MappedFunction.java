package edu.jhu.cs.bsj.compiler.impl.utils.function;

import java.util.Map;

/**
 * Represents a function backed by a {@link Map}.
 * @author Zachary Palmer
 *
 * @param <K> The key type of the map.
 * @param <V> The value type of the map.
 */
public class MappedFunction<K,V> implements Function<K,V>
{
    private Map<K,V> map;

    public MappedFunction(Map<K, V> map)
    {
        super();
        this.map = map;
    }

    @Override
    public V execute(K argument)
    {
        return this.map.get(argument);
    }

}
