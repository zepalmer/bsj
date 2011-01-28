package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import java.util.Collection;
import java.util.Collections;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population.PopulationStrategy.PopulationRecord;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * A convenience class for a population strategy which is responsible for at most one value. This value is populated by
 * a single thunk. If the thunk returns <code>null</code>, this strategy produces no values. This is particularly useful
 * in cases where analysis for a single node representing a single population value must be deferred to avoid learning
 * unnecessary information.
 * 
 * @author Zachary Palmer
 */
public class SingleValuePopulationStrategy<K, V extends BsjElement> extends
        AbstractThunkBackedPopulationStrategy<K, V, PopulationRecord<K, V>>
{
    private Function<K,String> keyNameExtractor;
    
    /**
     * Creates a population strategy for a single value.
     * 
     * @param thunk The thunk containing that value.
     * @param keyNameExtractor A function which can ascertain the name froma given key.
     */
    public SingleValuePopulationStrategy(Thunk<PopulationRecord<K, V>> thunk, Function<K,String> keyNameExtractor)
    {
        super(thunk);
        this.keyNameExtractor = keyNameExtractor;
    }

    @Override
    public Collection<PopulationRecord<K, V>> get(K key)
    {
        PopulationRecord<K, V> record = think();
        if (record != null && record.getKey().equals(key))
            return Collections.singleton(think());
        else
            return Collections.emptySet();
    }

    @Override
    public Collection<PopulationRecord<K, V>> getBySimpleName(String name)
    {
        PopulationRecord<K, V> record = think();
        if (record != null && this.keyNameExtractor.execute(record.getKey()).equals(name))
            return Collections.singleton(think());
        else
            return Collections.emptySet();
    }

    @Override
    public Collection<PopulationRecord<K, V>> getAll()
    {
        PopulationRecord<K, V> record = think();
        if (record != null)
            return Collections.singleton(think());
        else
            return Collections.emptySet();
    }
}
