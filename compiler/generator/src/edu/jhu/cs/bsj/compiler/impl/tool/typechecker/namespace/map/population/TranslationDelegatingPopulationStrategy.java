package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.function.AbstractThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Represents a population strategy which processes an iterable of nodes. Each node reflects a sub-strategy which is
 * produced via a function provided on construction. These strategies are then consulted in a multiplexing fashion on
 * all calls.
 * 
 * @author Zachary Palmer
 * 
 * @param <K> The key type for this population strategy.
 * @param <V> The value type for this population strategy.
 * @param <N> The type of node being processed.
 */
public class TranslationDelegatingPopulationStrategy<K, V extends BsjElement, N extends Node> extends
        AbstractThunkBackedPopulationStrategy<K, V, Iterable<PopulationStrategy<K, V>>>
{
    public TranslationDelegatingPopulationStrategy(final Thunk<Iterable<N>> thunk,
            final Function<N, PopulationStrategy<K, V>> translator)
    {
        super(new AbstractThunk<Iterable<PopulationStrategy<K, V>>>()
        {
            @Override
            protected Iterable<PopulationStrategy<K, V>> calculate()
            {
                Iterable<N> it = thunk.execute(null);
                List<PopulationStrategy<K, V>> list = new ArrayList<PopulationStrategy<K, V>>();
                for (N node : it)
                {
                    list.add(translator.execute(node));
                }
                return list;
            }
        });
    }

    @Override
    public Collection<PopulationRecord<K, V>> get(K key)
    {
        List<PopulationRecord<K, V>> list = new ArrayList<PopulationRecord<K,V>>();
        for (PopulationStrategy<K, V> strategy : think())
        {
            list.addAll(strategy.get(key));
        }
        return list;
    }

    @Override
    public Collection<PopulationRecord<K, V>> getBySimpleName(String name)
    {
        List<PopulationRecord<K, V>> list = new ArrayList<PopulationRecord<K,V>>();
        for (PopulationStrategy<K, V> strategy : think())
        {
            list.addAll(strategy.getBySimpleName(name));
        }
        return list;
    }

    @Override
    public Collection<PopulationRecord<K, V>> getAll()
    {
        List<PopulationRecord<K, V>> list = new ArrayList<PopulationRecord<K,V>>();
        for (PopulationStrategy<K, V> strategy : think())
        {
            list.addAll(strategy.getAll());
        }
        return list;
    }

}
