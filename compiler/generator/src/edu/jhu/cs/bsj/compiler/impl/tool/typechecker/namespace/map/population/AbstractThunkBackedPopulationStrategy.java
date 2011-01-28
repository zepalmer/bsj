package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.population;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Thunk;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

/**
 * Represents a type of population strategy which is backed by a thunk of some kind.
 * @author Zachary Palmer
 *
 * @param <K> The key type for this population strategy.
 * @param <V> The value type for this population strategy.
 * @param <T> The type of data returned from the thunk.
 */
public abstract class AbstractThunkBackedPopulationStrategy<K, V extends BsjElement, T> implements PopulationStrategy<K, V>
{
    /** The thunk or <code>null</code> if the thunk has already been pulled. */
    private Thunk<T> thunk;
    /** The value obtained from the thunk. */
    private T thunkValue;
    
    public AbstractThunkBackedPopulationStrategy(Thunk<T> thunk)
    {
        this.thunk = thunk;
    }
    
    protected T think()
    {
        if (this.thunk != null)
        {
            this.thunkValue = this.thunk.execute(null);
        }
        return this.thunkValue;
    }
}
