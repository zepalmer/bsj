package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker.AmbiguousSymbolNameDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.NamespaceUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * A mapping which is used to represent a namespace. This is a mapping from names to the declarations to which they
 * refer. In other words, instances of this class represent the symbol tables in a given scope.
 * <p/>
 * The namespace map is lazily populated, preventing it from learning more about the AST than is strictly necessary for
 * the queries that it answers. Forcing a population of all values can be performed by invoking the {@link #populate()}
 * method or indirectly by calling a method that requires a fully-populated map (such as the {@link #getKeys()} method).
 * <p/>
 * It is possible for a single key to be mapped to multiple declarations. In this case, the mapping itself is ambiguous
 * and a diagnostic message may be generated. If this occurs, an arbitrary but consistent value is always returned in
 * order to permit type-checking to continue. If this map is constructed as an "active error" map, such a retrieval will
 * cause a diagnostic to be produced. A user may also call the {@link #checkAmbiguities()} method to force the
 * generation of diagnostics.
 * <p/>
 * A namespace map is capable of being constructed based on the contents of other namespace maps. This can be used to
 * support cascading namespaces, allowing the declarations imported by single-type imports to override those imported by
 * on-demand imports. For the purposes of supporting inheritance, multiple backing namespace maps can be used.
 * 
 * @author Zachary Palmer
 */
public class AbstractNamespaceMap<K, V extends BsjElement> implements NamespaceMap<K, V>
{
    /** The symbol type that this map will use when reporting errors. */
    private SymbolType symbolType;
    /** The underlying maps which are being used. */
    private List<NamespaceMap<K, V>> deferenceMaps;
    /** The backing data structure which overlays the old map to represent this map's changes. */
    private Map<K, Entry<V>> backingMap;
    /** The diagnostic listener to which this namespace map reports errors. */
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;
    /** Indicates whether or not ambiguity analysis is performed eagerly in this map. */
    private boolean passiveError;
    /**
     * Indicates whether or not this map prohibits overrides - that is, if additions should be prevented from hiding
     * previous values. A <code>true</code> value indicates that the deference maps' values are included as well (such
     * as in local variable scope where an inner local variable cannot shadow an outer one); a <code>false</code> value
     * indicates that new mappings shadow old mappings (such as in a member type scope where fields can shadow the
     * enclosing type's fields).
     */
    private boolean prohibitsOverlap;
    /**
     * A set containing those keys which this namespace map has erased. These keys may be mapped in the deference maps;
     * however, this namespace map acts as if they are not present.
     */
    private Set<K> blockedKeySet;
    /**
     * The population strategies to use for this namespace map. These strategies are used to lazily populate the map.
     */
    private Collection<? extends PopulationStrategy<K, V>> populationStrategies;
    /**
     * A structure representing the population history of this map or <code>null</code> if this map has been fully
     * populated.
     */
    private PopulationHistory populationHistory;
    /**
     * A function which can identify the name of a given key.
     */
    private Function<K, String> keyNameExtractor;

    /**
     * Creates a new namespace map.
     */
    public AbstractNamespaceMap(SymbolType symbolType, Collection<? extends NamespaceMap<K, V>> deferenceMaps,
            DiagnosticListener<BsjSourceLocation> diagnosticListener, boolean passiveError, boolean prohibitsOverlap,
            Collection<? extends PopulationStrategy<K, V>> populationStrategies, Function<K, String> keyNameExtractor)
    {
        this.symbolType = symbolType;
        this.diagnosticListener = diagnosticListener;
        this.passiveError = passiveError;
        this.prohibitsOverlap = prohibitsOverlap;
        this.populationStrategies = populationStrategies;
        this.keyNameExtractor = keyNameExtractor;

        this.deferenceMaps = new ArrayList<NamespaceMap<K, V>>(deferenceMaps);
        this.backingMap = new HashMap<K, Entry<V>>();
        this.blockedKeySet = new HashSet<K>(0);
        this.populationHistory = new PopulationHistory();
    }

    /**
     * Populates this namespace map for a specific key. This operation is not recursive.
     * 
     * @param key The key in question.
     */
    private void populate(K key)
    {
        if (this.populationHistory == null)
            return;

        // If this key's name has already been populated, bail out.
        if (this.populationHistory.getPopulatedNames().contains(this.keyNameExtractor.execute(key)))
            return;

        // If this key has already been populated, bail out.
        if (this.populationHistory.getPopulatedKeys().contains(key))
            return;

        // Record this key
        this.populationHistory.getPopulatedKeys().add(key);

        // Do population
        for (PopulationStrategy<K, V> strategy : this.populationStrategies)
        {
            Collection<PopulationStrategy.PopulationRecord<K, V>> results = strategy.get(key);
            for (PopulationStrategy.PopulationRecord<K, V> result : results)
            {
                this.add(result.getKey(), result.getValue(), result.getIndicator());
            }
        }
    }

    /**
     * Populates this namespace map for a specific name. This operation is not recursive.
     * 
     * @param name The name in question.
     */
    private void populateBySimpleName(String name)
    {
        if (this.populationHistory == null)
            return;

        // If this mame has already been populated, bail out.
        if (this.populationHistory.getPopulatedNames().contains(name))
            return;

        // Record this key
        this.populationHistory.getPopulatedNames().add(name);

        // Do population
        for (PopulationStrategy<K, V> strategy : this.populationStrategies)
        {
            Collection<PopulationStrategy.PopulationRecord<K, V>> results = strategy.getBySimpleName(name);
            for (PopulationStrategy.PopulationRecord<K, V> result : results)
            {
                this.add(result.getKey(), result.getValue(), result.getIndicator());
            }
        }
    }

    /**
     * Fully populates this namespace map. If this namespace map is already fully populated, this method has no effect.
     * This operation is not recursive.
     */
    private void populate()
    {
        if (this.populationHistory == null)
            return;

        this.populationHistory = null;

        for (PopulationStrategy<K, V> strategy : this.populationStrategies)
        {
            Collection<PopulationStrategy.PopulationRecord<K, V>> results = strategy.getAll();
            for (PopulationStrategy.PopulationRecord<K, V> result : results)
            {
                this.add(result.getKey(), result.getValue(), result.getIndicator());
            }
        }
    }

    /**
     * Retrieves a collection of all keys in this namespace map which are mapped to a value.
     * 
     * @return The keys for this namespace map.
     */
    @Override
    public Collection<K> getKeys()
    {
        populate();
        Set<K> ret = new HashSet<K>();
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getKeys());
        }
        ret.addAll(this.backingMap.keySet());
        ret.removeAll(this.blockedKeySet);
        return Collections.unmodifiableSet(ret);
    }

    @Override
    public Collection<K> getKeysBySimpleName(String name)
    {
        populateBySimpleName(name);
        Set<K> ret = new HashSet<K>();
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getKeysBySimpleName(name));
        }
        for (K key : this.backingMap.keySet())
        {
            if (this.keyNameExtractor.execute(key).equals(name))
            {
                ret.add(key);
            }
        }
        ret.removeAll(this.blockedKeySet);
        return Collections.unmodifiableSet(ret);
    }

    @Override
    public Collection<K> getPopulatedKeys()
    {
        Set<K> ret = new HashSet<K>();
        ret.addAll(this.backingMap.keySet());
        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            ret.addAll(deferenceMap.getPopulatedKeys());
        }
        ret.removeAll(this.blockedKeySet);
        return ret;
    }

    /**
     * Utility function for generalizing the behavior of {@link #getValues(Object)} and
     * {@link #getIndicatedValues(Object)}.
     * 
     * @param key The key to use.
     * @param entryFunction The extraction function to use on entries.
     * @param deferenceExtractor The extraction function to use on deference maps.
     * @return The resulting set.
     */
    private <T> Collection<T> extractValues(K key, Function<Entry<V>, Set<T>> entryFunction,
            MapValueExtractor<K, V, T> deferenceExtractor)
    {
        populate(key);
        if (this.backingMap.containsKey(key))
        {
            if (!this.prohibitsOverlap || this.deferenceMaps.size() == 0)
            {
                return Collections.unmodifiableSet(entryFunction.execute(this.backingMap.get(key)));
            } else
            {
                Set<T> ret = new LinkedHashSet<T>();
                ret.addAll(entryFunction.execute(this.backingMap.get(key)));
                for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
                {
                    if (deferenceMap.prohibitsOverlap())
                    {
                        ret.addAll(deferenceExtractor.extract(deferenceMap, key));
                    }
                }
                return Collections.unmodifiableSet(ret);
            }
        } else if (this.blockedKeySet.contains(key))
        {
            return Collections.emptySet();
        } else if (this.deferenceMaps.size() == 0)
        {
            return Collections.emptySet();
        } else if (this.deferenceMaps.size() == 1)
        {
            return deferenceExtractor.extract(this.deferenceMaps.iterator().next(), key);
        } else
        {
            Set<T> ret = new LinkedHashSet<T>();
            for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
            {
                ret.addAll(deferenceExtractor.extract(deferenceMap, key));
            }
            return Collections.unmodifiableSet(ret);
        }
    }

    /**
     * Retrieves all values mapped to a given key in this namespace map.
     * 
     * @param key The key to use.
     * @return The values for the key.
     */
    @Override
    public Collection<V> getValues(K key)
    {
        return extractValues(key, valueEntryExtractor, valueMapExtractor);
    }

    /**
     * Retrieves all values and their indicators mapped to a given key in this namespace map.
     * 
     * @param key The key to use.
     * @return The values for the key.
     */
    @Override
    public Collection<Pair<V, Node>> getIndicatedValues(K key)
    {
        return extractValues(key, indicatedValueEntryExtractor, indicatedValueMapExtractor);
    }

    private <T> Collection<T> extractNamedValues(String name, MapValueExtractor<K, V, T> mapValueExtractor)
    {
        Set<T> ret = new HashSet<T>();
        for (K key : getKeysBySimpleName(name))
        {
            ret.addAll(mapValueExtractor.extract(this, key));
        }
        return ret;
    }

    @Override
    public Collection<V> getValuesBySimpleName(String name)
    {
        return extractNamedValues(name, valueMapExtractor);
    }

    @Override
    public Collection<Pair<V, Node>> getIndicatedValuesBySimpleName(String name)
    {
        return extractNamedValues(name, indicatedValueMapExtractor);
    }

    /**
     * Checks this namespace for ambiguities and produces appropriate diagnostics if they exist. This routine will fully
     * populate the namespace map.
     */
    @Override
    public void checkAmbiguities()
    {
        populate();
        // Only concern ourselves with ambiguities which are locally mapped. Everything else has already been
        // checked by one of our deference maps.
        for (Map.Entry<K, Entry<V>> entry : this.backingMap.entrySet())
        {
            considerAmbiguity(entry.getKey(), entry.getValue().getFirstIndicator().getStartLocation());
        }
    }

    /**
     * Adds a new name to this namespace map.
     * 
     * @param name The name to add.
     * @param element The type element to which the name corresponds.
     * @param indicator The node which was responsible for indicating this mapping.
     * @throws IllegalStateException If this environment has been locked.
     */
    private void add(K name, V element, Node indicator)
    {
        if (name == null)
            throw new IllegalStateException("Attempted to store null key in namespace map");
        if (element == null)
            throw new IllegalStateException("Attempted to store null value in namespace map");
        if (indicator == null)
            throw new IllegalStateException("Attempted to store null indicator in namespace map");

        Entry<V> entry = this.backingMap.get(name);
        if (entry == null)
        {
            entry = new Entry<V>(element, indicator);
            this.backingMap.put(name, entry);
            notifyNewKey(name);
        } else
        {
            entry.add(element, indicator);
        }

    }

    public boolean prohibitsOverlap()
    {
        return prohibitsOverlap;
    }

    /**
     * Used to notify subclasses of the presence of a new key. This method is called to permit the subclass the
     * opportunity to make changes to the backing map, which is provided as an argument. The default implementation
     * takes no action.
     * 
     * @param key The key of the element that was added.
     * @param backingMap The backing map that this method may modify.
     */
    protected void notifyNewKey(K key)
    {
    }

    /**
     * Determines whether or not an entry for the given name exists in this map.
     * 
     * @param key The name of the entry.
     * @return <code>true</code> if that entry exists; <code>false</code> if it does not.
     */
    @Override
    public boolean contains(K key)
    {
        populate(key);

        if (this.backingMap.containsKey(key))
            return true;

        if (this.blockedKeySet.contains(key))
            return false;

        for (NamespaceMap<K, V> deferenceMap : this.deferenceMaps)
        {
            if (deferenceMap.contains(key))
                return true;
        }

        return false;
    }

    /**
     * Retrieves a type element based on a name in this namespace.
     * 
     * @param key The name to use.
     * @param sourceLocation The source location of the node which indicates this name.
     * @return The corresponding type element or <code>null</code> if the specified key is not mapped.
     */
    @Override
    public V lookup(K key, BsjSourceLocation sourceLocation)
    {
        if (!this.passiveError)
        {
            considerAmbiguity(key, sourceLocation);
        }

        return doLookup(key);
    }

    /**
     * Performs the lookup of a given key; this method does not perform ambiguity checking. It is therefore suitable to
     * recurse on itself, as it will not generate redundant diagnostics.
     * 
     * @param key The key to look up.
     * @return The appropriate value.
     */
    protected V doLookup(K key)
    {
        Collection<V> collection = getValues(key);
        if (collection.size() == 0)
        {
            return null;
        } else
        {
            return collection.iterator().next();
        }
    }

    /**
     * Considers ambiguity for the provided name entry. If ambiguity exists, an appropriate diagnostic should be
     * produced.
     * 
     * @param key The name of the entry.
     * @param sourceLocation The location to use in diagnostics. This is typically the location where the name was used.
     */
    private void considerAmbiguity(K key, BsjSourceLocation sourceLocation)
    {
        Collection<Pair<V, Node>> all = getIndicatedValues(key);
        if (isAmbiguous(key, all))
        {
            List<Node> nodes = new ArrayList<Node>(all.size());
            for (Pair<V, Node> p : all)
            {
                nodes.add(p.getSecond());
            }
            this.diagnosticListener.report(new AmbiguousSymbolNameDiagnosticImpl(sourceLocation, key.toString(),
                    this.symbolType, nodes));
        }
    }

    /**
     * Considers ambiguity for an entry's contents.
     * 
     * @param key The name of the entry.
     * @param values The values in this entry.
     * @return <code>true</code> if this entry is ambiguous; <code>false</code> if it is not.
     */
    protected boolean isAmbiguous(K key, Collection<Pair<V, Node>> all)
    {
        return all.size() > 1;
    }

    /**
     * Creates a string representation of this namespace.
     */
    public String toString()
    {
        return NamespaceUtilities.namespaceToString(this);
    }

    @Override
    public boolean isFullyPopulated()
    {
        return this.populationHistory == null;
    }

    /**
     * Creates a string for an element collection.
     * 
     * @param elements The collection in question.
     * @return The generated string.
     */
    private static String stringOfElements(Collection<? extends BsjElement> elements)
    {
        if (elements.size() == 0)
        {
            return "{}";
        } else if (elements.size() == 1)
        {
            return elements.iterator().next().getDeclarationNode().getStartLocation().toString();
        } else
        {
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (BsjElement element : elements)
            {
                if (!first)
                    sb.append(", ");
                sb.append(element.getDeclarationNode().getStartLocation().toString());
                first = false;
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /**
     * The type of an entry in a namespace map. An entry is capable of storing multiple values and recording the first
     * value which was stored with it.
     */
    private static class Entry<V extends BsjElement>
    {
        /** The types which are mapped to the specified name. */
        private Set<V> values;
        /** A set of pairings between the values and their indicators. */
        private Set<Pair<V, Node>> indicatedValues;

        public Entry()
        {
            this.values = new LinkedHashSet<V>();
            this.indicatedValues = new LinkedHashSet<Pair<V, Node>>();
        }

        public Entry(V value, Node indicator)
        {
            this();
            add(value, indicator);
        }

        public void add(V value, Node indicator)
        {
            this.values.add(value);
            this.indicatedValues.add(new Pair<V, Node>(value, indicator));
        }

        public Set<V> getValues()
        {
            return values;
        }

        public Set<Pair<V, Node>> getIndicatedValues()
        {
            return indicatedValues;
        }

        public Node getFirstIndicator()
        {
            if (indicatedValues.size() > 0)
                return indicatedValues.iterator().next().getSecond();
            else
                return null;
        }

        public String toString()
        {
            return stringOfElements(getValues());
        }
    }

    /**
     * A data structure for tracking those keys and names which have been populated.
     */
    private class PopulationHistory
    {
        private Set<K> populatedKeys = new HashSet<K>();
        private Set<String> populatedNames = new HashSet<String>();

        public Set<K> getPopulatedKeys()
        {
            return populatedKeys;
        }

        public Set<String> getPopulatedNames()
        {
            return populatedNames;
        }
    }

    /**
     * An interface for use by {@link AbstractNamespaceMap#extractValues(Object, Function, MapValueExtractor)}.
     */
    private static interface MapValueExtractor<K, V extends BsjElement, T>
    {
        public Collection<T> extract(NamespaceMap<K, V> map, K key);
    }

    private final MapValueExtractor<K, V, V> valueMapExtractor = new MapValueExtractor<K, V, V>()
    {
        @Override
        public Collection<V> extract(NamespaceMap<K, V> map, K key)
        {
            return map.getValues(key);
        }
    };

    private final MapValueExtractor<K, V, Pair<V, Node>> indicatedValueMapExtractor = new MapValueExtractor<K, V, Pair<V, Node>>()
    {
        @Override
        public Collection<Pair<V, Node>> extract(NamespaceMap<K, V> map, K key)
        {
            return map.getIndicatedValues(key);
        }
    };

    private final Function<Entry<V>, Set<V>> valueEntryExtractor = new Function<Entry<V>, Set<V>>()
    {
        @Override
        public Set<V> execute(Entry<V> argument)
        {
            return argument.getValues();
        }
    };

    private final Function<Entry<V>, Set<Pair<V, Node>>> indicatedValueEntryExtractor = new Function<Entry<V>, Set<Pair<V, Node>>>()
    {
        @Override
        public Set<Pair<V, Node>> execute(Entry<V> argument)
        {
            return argument.getIndicatedValues();
        }
    };
}
