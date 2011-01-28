package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This interface represents a strategy for populating a namespace map lazily.
 * 
 * @author Zachary Palmer
 * @param <K> The key type for the map that this strategy can populate.
 * @param <V> The value type produced by this strategy.
 */
public interface PopulationStrategy<K, V extends BsjElement>
{
    /**
     * Obtains values for this population strategy from a specific input key.
     * 
     * @param key The key to use.
     * @return The values to populate.
     */
    public Collection<PopulationRecord<K,V>> get(K key);
    
    /**
     * Obtains values for this population strategy from a specific simple name.
     * @param name The name to use.
     * @return The values to populate.
     */
    public Collection<PopulationRecord<K, V>> getBySimpleName(String name);

    /**
     * Obtains all values for this population strategy. This method will return a map that contains every value which
     * could have been obtained through {@link #get(Object)}.
     * 
     * @return The values to populate.
     */
    public Collection<PopulationRecord<K,V>> getAll();

    public interface PopulationRecord<K,V>
    {
        public K getKey();
        public V getValue();
        public Node getIndicator();
    }
}
