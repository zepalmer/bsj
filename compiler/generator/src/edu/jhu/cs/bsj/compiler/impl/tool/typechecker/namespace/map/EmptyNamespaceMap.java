package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.Collection;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Represents an empty namespace map.
 * @author Zachary Palmer
 *
 * @param <K> The key type of the namespace.
 * @param <V> The value type of the namespace.
 */
public class EmptyNamespaceMap<K, V extends BsjElement> implements NamespaceMap<K, V>
{
    private static EmptyNamespaceMap<?, ?> INSTANCE = new EmptyNamespaceMap<Object, BsjElement>();
    
    public static <K,V extends BsjElement> NamespaceMap<K,V> instance()
    {
        // The following cast is safe because EmptyNamespaceMap is immutable, ignores input, and returns only immutable
        // values.  This allows us to make sure everyone is using the same object, conserving heap space.
        @SuppressWarnings("unchecked")
        NamespaceMap<K,V> instance = (NamespaceMap<K, V>)INSTANCE;
        return instance;
    }

    @Override
    public Collection<K> getKeys()
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<K> getKeysBySimpleName(String name)
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<K> getPopulatedKeys()
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<V> getValues(K key)
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<Pair<V, Node>> getIndicatedValues(K key)
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<V> getValuesBySimpleName(String name)
    {
        return Collections.emptySet();
    }

    @Override
    public Collection<Pair<V, Node>> getIndicatedValuesBySimpleName(String name)
    {
        return Collections.emptySet();
    }

    @Override
    public void checkAmbiguities()
    {
    }

    @Override
    public boolean contains(K key)
    {
        return false;
    }

    @Override
    public V lookup(K key, BsjSourceLocation sourceLocation)
    {
        return null;
    }

    @Override
    public boolean prohibitsOverlap()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return NamespaceUtilities.namespaceToString(this);
    }

    @Override
    public boolean isFullyPopulated()
    {
        return true;
    }
}
