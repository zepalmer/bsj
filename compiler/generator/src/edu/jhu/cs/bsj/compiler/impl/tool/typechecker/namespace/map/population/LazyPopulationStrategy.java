package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * This population strategy uses a backing thunk to lazily evaluate another population strategy. This is partiuclarly
 * useful when the evaluation of the population strategy itself requires some node evaluation which should be deferred.
 * If the thunk produces a <code>null</code> value, this population strategy will produce no values.
 * 
 * @author Zachary Palmer
 */
public class LazyPopulationStrategy<K, V extends BsjElement> extends
        AbstractThunkBackedPopulationStrategy<K, V, PopulationStrategy<K, V>>
{
    public LazyPopulationStrategy(Thunk<PopulationStrategy<K, V>> thunk)
    {
        super(thunk);
    }

    @Override
    public Collection<PopulationRecord<K, V>> get(K key)
    {
        PopulationStrategy<K, V> strategy = think();
        if (strategy != null)
            return strategy.get(key);
        else
            return Collections.emptySet();
    }

    @Override
    public Collection<PopulationRecord<K, V>> getBySimpleName(String name)
    {
        PopulationStrategy<K, V> strategy = think();
        if (strategy != null)
            return strategy.getBySimpleName(name);
        else
            return Collections.emptySet();
    }

    @Override
    public Collection<PopulationRecord<K, V>> getAll()
    {
        PopulationStrategy<K, V> strategy = think();
        if (strategy != null)
            return strategy.getAll();
        else
            return Collections.emptySet();
    }
}
