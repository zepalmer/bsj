package edu.jhu.cs.bsj.compiler.impl.utils.function;

/**
 * Provides a lambda-like function interface.  This interface permits a simple approximation of first-order functions
 * in Java, albeit with <i>horrible</i> syntax.
 * @author Zachary Palmer
 * @param <P> The parameter type of this function.
 * @param <R> The return type of this function.
 */
public interface Function<P,R>
{
	/**
	 * Executes this function.
	 * @param argument The argument to this function invocation.
	 * @return The result of this function invocation.
	 */
	public R execute(P argument);
}
