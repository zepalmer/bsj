package edu.jhu.cs.bsj.compiler.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

public class HashBijectiveMap<K, V> implements BijectiveMap<K, V>
{
    private HashMap<K, V> forwardMap;
    private HashMap<V, K> backwardMap;
    private HashBijectiveMap<V, K> inverted;

    private HashBijectiveMap(HashMap<K, V> forwardMap, HashMap<V, K> backwardMap, HashBijectiveMap<V, K> inverted)
    {
        this.forwardMap = forwardMap;
        this.backwardMap = backwardMap;
        if (inverted == null)
        {
            this.inverted = new HashBijectiveMap<V, K>(this.backwardMap, this.forwardMap, this);
        } else
        {
            this.inverted = inverted;
        }
    }

    public HashBijectiveMap()
    {
        this(new HashMap<K, V>(), new HashMap<V, K>(), null);
    }

    public HashBijectiveMap(BijectiveMap<K, V> initialMap)
    {
        this(new HashMap<K, V>(initialMap), new HashMap<V, K>(initialMap.invert()), null);
    }

    @Override
    public int size()
    {
        return this.forwardMap.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.forwardMap.size() == 0;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return this.forwardMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value)
    {
        return this.backwardMap.containsKey(value);
    }

    @Override
    public V get(Object key)
    {
        return this.forwardMap.get(key);
    }

    @Override
    public V put(K key, V value)
    {
        V ret = null;
        if (this.forwardMap.containsKey(key))
        {
            ret = this.forwardMap.get(key);
            this.backwardMap.remove(ret);
        }
        if (this.backwardMap.containsKey(value))
        {
            this.forwardMap.remove(this.backwardMap.get(value));
        }
        this.forwardMap.put(key, value);
        this.backwardMap.put(value, key);
        return ret;
    }

    @Override
    public V remove(Object key)
    {
        if (this.forwardMap.containsKey(key))
        {
            V v = this.forwardMap.remove(key);
            this.backwardMap.remove(v);
            return v;
        } else
        {
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        this.innerPutAll(m);
    }

    private <KT extends K, VT extends V> void innerPutAll(Map<KT, VT> m)
    {
        for (Map.Entry<KT, VT> entry : m.entrySet())
        {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear()
    {
        this.forwardMap.clear();
        this.backwardMap.clear();
    }

    @Override
    public Set<K> keySet()
    {
        return new ForwardingSet<K, Map.Entry<K, V>>(this.entrySet(), new Function<Map.Entry<K, V>, K>()
        {
            public K execute(Map.Entry<K, V> entry)
            {
                return entry.getKey();
            }
        })
        {
            @Override
            public boolean contains(Object o)
            {
                return HashBijectiveMap.this.containsKey(o);
            }

            @Override
            public boolean remove(Object o)
            {
                boolean ret = HashBijectiveMap.this.containsKey(o);
                if (ret)
                {
                    HashBijectiveMap.this.remove(o);
                }
                return ret;
            }
        };
    }

    @Override
    public Set<V> values()
    {
        return new ForwardingSet<V, Map.Entry<K, V>>(this.entrySet(), new Function<Map.Entry<K, V>, V>()
        {
            public V execute(Map.Entry<K, V> entry)
            {
                return entry.getValue();
            }
        })
        {
            @Override
            public boolean contains(Object o)
            {
                return HashBijectiveMap.this.containsValue(o);
            }

            @Override
            public boolean remove(Object o)
            {
                boolean ret = HashBijectiveMap.this.containsValue(o);
                if (ret)
                {
                    K k = HashBijectiveMap.this.backwardMap.get(o);
                    HashBijectiveMap.this.remove(k);
                }
                return ret;
            }
        };
    }

    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet()
    {
        return new BaseSet<Map.Entry<K, V>>()
        {
            @Override
            public boolean contains(Object o)
            {
                if (o instanceof Map.Entry<?, ?>)
                {
                    Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) o;
                    if (HashBijectiveMap.this.forwardMap.containsKey(entry.getKey()))
                    {
                        V v = HashBijectiveMap.this.forwardMap.get(entry.getKey());
                        if ((v == null && entry.getValue() == null) || (v != null && v.equals(entry.getValue())))
                        {
                            return true;
                        } else
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }

            @Override
            public Iterator<java.util.Map.Entry<K, V>> iterator()
            {
                final List<K> keys = new ArrayList<K>(HashBijectiveMap.this.forwardMap.keySet());
                return new Iterator<Map.Entry<K, V>>()
                {
                    private int index = 0;
                    private boolean removeOkay = false;

                    private void skipStaleEntries()
                    {
                        // It's possible that, by modifying a Map.Entry, the user has destroyed one of the keys we have
                        // not yet reached. We therefore use this technique to ensure each time that we are not
                        // reporting an entry which does not exist.
                        while (this.index < keys.size() && !HashBijectiveMap.this.containsKey(keys.get(this.index)))
                            this.index++;
                    }

                    @Override
                    public boolean hasNext()
                    {
                        skipStaleEntries();
                        return this.index < keys.size();
                    }

                    @Override
                    public java.util.Map.Entry<K, V> next()
                    {
                        skipStaleEntries();
                        if (this.index < keys.size())
                        {
                            this.removeOkay = true;
                            return new Map.Entry<K, V>()
                            {
                                private K key = keys.get(index++);
                                private V value = HashBijectiveMap.this.get(this.key);

                                @Override
                                public K getKey()
                                {
                                    return this.key;
                                }

                                @Override
                                public V getValue()
                                {
                                    return this.value;
                                }

                                @Override
                                public V setValue(V value)
                                {
                                    V old = this.value;
                                    this.value = value;
                                    HashBijectiveMap.this.put(this.key, this.value);
                                    return old;
                                }
                            };
                        } else
                        {
                            throw new NoSuchElementException();
                        }
                    }

                    @Override
                    public void remove()
                    {
                        if (!this.removeOkay)
                            throw new IllegalStateException();

                        this.removeOkay = false;
                        HashBijectiveMap.this.remove(keys.get(this.index - 1));
                    }
                };
            }

            @Override
            public boolean remove(Object o)
            {
                if (o instanceof Map.Entry<?, ?>)
                {
                    Map.Entry<?, ?> entry = (java.util.Map.Entry<?, ?>) o;
                    if (HashBijectiveMap.this.forwardMap.containsKey(entry.getKey()))
                    {
                        V v = HashBijectiveMap.this.forwardMap.get(entry.getKey());
                        if ((v == null && entry.getValue() == null) || (v != null && v.equals(entry.getValue())))
                        {
                            HashBijectiveMap.this.remove(entry.getKey());
                            return true;
                        } else
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
        };
    }

    @Override
    public BijectiveMap<V, K> invert()
    {
        return this.inverted;
    }

    /**
     * A partial implementation of set. This contains common implementation features in a fashion similar to
     * {@link AbstractSet} but leaves more methods undefined and is intended for constrainted writable use.
     */
    private abstract class BaseSet<T> implements Set<T>
    {
        @Override
        public int size()
        {
            return HashBijectiveMap.this.forwardMap.size();
        }

        @Override
        public boolean isEmpty()
        {
            return this.size() == 0;
        }

        @Override
        public Object[] toArray()
        {
            Object[] o = new Object[this.size()];
            int i = 0;
            for (Object object : this)
            {
                o[i++] = object;
            }
            return o;
        }

        @Override
        public <E> E[] toArray(E[] a)
        {
            // The following @SuppressWarnings is safe because, by contract, the class of an array returns a
            // component type which is compatible with its element type.
            @SuppressWarnings("unchecked")
            Class<E> componentType = (Class<E>) a.getClass().getComponentType();
            if (a.length < this.size())
            {
                // The following @SuppressWarnings is safe because the array has been instantiated with the correct
                // component type.
                @SuppressWarnings("unchecked")
                E[] temp = (E[]) Array.newInstance(componentType, this.size());
                a = temp;
            }
            int i = 0;
            for (Object o : this)
            {
                a[i++] = componentType.cast(o);
            }
            return a;
        }

        @Override
        public boolean add(T e)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c)
        {
            for (Object o : c)
            {
                if (!this.contains(o))
                {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> c)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c)
        {
            boolean ret = false;
            Iterator<T> it = this.iterator();
            while (it.hasNext())
            {
                if (!c.contains(it.next()))
                {
                    ret = true;
                    it.remove();
                }
            }
            return ret;
        }

        @Override
        public boolean removeAll(Collection<?> c)
        {
            boolean ret = false;
            for (Object o : c)
            {
                ret |= this.remove(o);
            }
            return ret;
        }

        @Override
        public void clear()
        {
            HashBijectiveMap.this.clear();
        }

        @Override
        public int hashCode()
        {
            int hash = 0;
            for (Object o : this)
            {
                if (o != null)
                    hash ^= o.hashCode();
            }
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof Set<?>)
            {
                Set<?> other = (Set<?>) obj;
                return this.containsAll(other) && other.size() == this.size();
            } else
            {
                return false;
            }
        }
    }

    private abstract class ForwardingSet<T, U> extends BaseSet<T> implements Set<T>
    {
        private Set<U> backingSet;
        private Function<U, T> conversionFunction;

        public ForwardingSet(Set<U> backingSet, Function<U, T> conversionFunction)
        {
            super();
            this.backingSet = backingSet;
            this.conversionFunction = conversionFunction;
        }

        @Override
        public Iterator<T> iterator()
        {
            return new Iterator<T>()
            {
                private Iterator<U> backingIterator = ForwardingSet.this.backingSet.iterator();

                @Override
                public boolean hasNext()
                {
                    return this.backingIterator.hasNext();
                }

                @Override
                public T next()
                {
                    return ForwardingSet.this.conversionFunction.execute(this.backingIterator.next());
                }

                @Override
                public void remove()
                {
                    this.backingIterator.remove();
                }
            };
        }
    }

    @Override
    public String toString()
    {
        return this.forwardMap.toString();
    }

    @Override
    public int hashCode()
    {
        return this.forwardMap.entrySet().hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Map<?, ?>)
        {
            Map<?, ?> map = (Map<?, ?>) obj;
            return this.forwardMap.entrySet().equals(map.entrySet());
        } else
        {
            return false;
        }
    }
}
