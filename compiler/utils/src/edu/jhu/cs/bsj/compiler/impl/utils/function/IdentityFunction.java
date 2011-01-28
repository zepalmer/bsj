package edu.jhu.cs.bsj.compiler.impl.utils.function;

/**
 * An implementation of the identity function.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of the function.
 */
public class IdentityFunction<T> implements Function<T, T>
{
    private static final IdentityFunction<?> SINGLETON = new IdentityFunction<Object>();

    private IdentityFunction()
    {
    }

    /**
     * A factory method for creating identity function representations.
     * 
     * @param <T> The type of identity function input/output.
     * @return The resulting identity function.
     */
    public static <T> IdentityFunction<T> instance()
    {
        // The following cast is safe because this class has no state nor any logical restrictions based on the type
        // parameter; thus, a single object will always work.
        @SuppressWarnings("unchecked")
        IdentityFunction<T> ret = (IdentityFunction<T>) SINGLETON;
        return ret;
    }

    @Override
    public T execute(T argument)
    {
        return argument;
    }
}
