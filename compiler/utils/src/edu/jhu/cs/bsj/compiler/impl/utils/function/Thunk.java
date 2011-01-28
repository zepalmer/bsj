package edu.jhu.cs.bsj.compiler.impl.utils.function;

/**
 * Represents a thunk.  In addition to the usual semantics of {@link Function}, this interface guarantees that the same
 * value will be returned every time.
 * @author Zachary Palmer
 */
public interface Thunk<R> extends Function<Void,R>
{
    /**
     * Evaluates this thunk.
     * @return The thunk value.
     */
    public R evaluate();
}
