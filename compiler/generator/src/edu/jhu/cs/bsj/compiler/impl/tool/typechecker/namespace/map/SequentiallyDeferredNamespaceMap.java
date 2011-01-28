package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This implementation of {@link NamespaceMap} allows multiple namespace maps to be queried in sequence. The purpose of
 * doing so is to permit such maps to be layered. The {@link AbstractNamespaceMap} class provides a mechanism for
 * layering, but that mechanism requires that a given namespace map always have knowledge of the map to which it will
 * defer; this makes it inappropriate for caching maps which defer to different maps each time. For instance, consider
 * the case of two compilation units containing classes which both extend the same base class. The same inheritance map
 * cannot be used by the class body without use of the {@link SequentiallyDeferredNamespaceMap} proxy because each
 * instance would have to defer to a different set of imports.
 * <p/>
 * When created, this proxy receives a list of deference maps. Each map is checked in ascending order until one of them
 * returns a value of importance, which is then returned. If none of them return a value, a standard non-value is
 * returned (such as an empty collection).  In effect, this model is similar to that of {@link AbstractNamespaceMap}
 * when <tt>prohibitsOverlap</tt> is <tt>false</tt>.
 * 
 * @author Zachary Palmer
 * 
 * @param <K> The type for names in the namespace.
 * @param <V> The type for elements named in this namespace.
 */
public class SequentiallyDeferredNamespaceMap<K, V extends BsjElement> implements NamespaceMap<K, V>
{
    private List<? extends NamespaceMap<K, V>> deferenceMaps;

    public SequentiallyDeferredNamespaceMap(List<? extends NamespaceMap<K, V>> deferenceMaps)
    {
        super();
        this.deferenceMaps = deferenceMaps;
    }

    @Override
    public Collection<K> getKeys()
    {
        Set<K> ret = new HashSet<K>();
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getKeys());
        }
        return ret;
    }

    @Override
    public Collection<K> getKeysBySimpleName(String name)
    {
        Set<K> ret = new HashSet<K>();
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getKeysBySimpleName(name));
        }
        return ret;
    }

    @Override
    public Collection<K> getPopulatedKeys()
    {
        Set<K> ret = new HashSet<K>();
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getPopulatedKeys());
        }
        return ret;
    }

    @Override
    public Collection<V> getValues(K key)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            Collection<V> values = deferenceMap.getValues(key);
            if (values.size() > 0)
                return values;
        }
        return Collections.emptySet();
    }

    @Override
    public Collection<Pair<V, Node>> getIndicatedValues(K key)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            Collection<Pair<V,Node>> values = deferenceMap.getIndicatedValues(key);
            if (values.size() > 0)
                return values;
        }
        return Collections.emptySet();
    }

    @Override
    public Collection<V> getValuesBySimpleName(String name)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            Collection<V> values = deferenceMap.getValuesBySimpleName(name);
            if (values.size() > 0)
                return values;
        }
        return Collections.emptySet();
    }

    @Override
    public Collection<Pair<V, Node>> getIndicatedValuesBySimpleName(String name)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            Collection<Pair<V,Node>> values = deferenceMap.getIndicatedValuesBySimpleName(name);
            if (values.size() > 0)
                return values;
        }
        return Collections.emptySet();
    }

    @Override
    public void checkAmbiguities()
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            deferenceMap.checkAmbiguities();
        }
    }

    @Override
    public boolean contains(K key)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            if (deferenceMap.contains(key))
                return true;
        }
        return false;
    }

    @Override
    public V lookup(K key, BsjSourceLocation sourceLocation)
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            V v = deferenceMap.lookup(key, sourceLocation);
            if (v != null)
                return v;
        }
        return null;
    }

    @Override
    public String toString()
    {
        return NamespaceUtilities.namespaceToString(this);
    }

    @Override
    public boolean isFullyPopulated()
    {
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            if (!deferenceMap.isFullyPopulated())
                return false;
        }        
        return true;
    }

    @Override
    public boolean prohibitsOverlap()
    {
        return false;
    }
}
