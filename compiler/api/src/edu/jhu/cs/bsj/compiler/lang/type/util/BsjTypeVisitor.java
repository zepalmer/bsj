package edu.jhu.cs.bsj.compiler.lang.type.util;

/**
 * A convenience implementation of the {@link AbortableBsjTypeVisitor} interface which does not expect that an exception
 * will be thrown.
 * @author Zachary Palmer
 *
 * @param <P> The type of parameter for the visitor to receive.
 * @param <R> The type of return value for the visitor to produce.
 */
public interface BsjTypeVisitor<P,R> extends AbortableBsjTypeVisitor<P, R, RuntimeException>
{
}
