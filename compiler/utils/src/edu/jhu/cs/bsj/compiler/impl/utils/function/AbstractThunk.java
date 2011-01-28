package edu.jhu.cs.bsj.compiler.impl.utils.function;

/**
 * Provides a base thunk implementation.  Implementers provide the template method {@link #calculate()}; caching of the
 * value is handled in this class.
 * @author Zachary Palmer
 *
 * @param <R> The type of value represented by this thunk.
 */
public abstract class AbstractThunk<R> implements Thunk<R>
{
    private R value = null;
    private boolean evaluated = false;
    
    protected abstract R calculate();

    @Override
    public R execute(Void argument)
    {
        return evaluate();
    }

    @Override
    public R evaluate()
    {
        if (!evaluated)
        {
            value = calculate();
            evaluated = true;
        }
        return value;
    }
}
