package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class UnmodifiableBijectiveMap<K,V> implements BijectiveMap<K, V>
{
    private BijectiveMap<K, V> backingMap;
    private BijectiveMap<V, K> inverse;
    
    public UnmodifiableBijectiveMap(BijectiveMap<K, V> backingMap)
    {
        this(backingMap,null);
    }
    
    private UnmodifiableBijectiveMap(BijectiveMap<K, V> backingMap, BijectiveMap<V, K> inverse)
    {
        this.backingMap = backingMap;
        if (inverse == null)
        {
            this.inverse = new UnmodifiableBijectiveMap<V, K>(backingMap.invert(), this);
        } else
        {
            this.inverse = inverse;
        }
    }

    @Override
    public int size()
    {
        return this.backingMap.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.backingMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key)
    {
        return this.backingMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return this.backingMap.containsValue(value);
    }

    @Override
    public V get(Object key)
    {
        return this.backingMap.get(key);
    }

    @Override
    public V put(K key, V value)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(Object key)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet()
    {
        return Collections.unmodifiableSet(this.backingMap.keySet());
    }

    @Override
    public Set<V> values()
    {
        return Collections.unmodifiableSet(this.backingMap.values());
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet()
    {
        return Collections.unmodifiableMap(this.backingMap).entrySet();
    }

    @Override
    public BijectiveMap<V, K> invert()
    {
        return this.inverse;
    }
    
    @Override
    public String toString()
    {
        return this.backingMap.toString();
    }
}
