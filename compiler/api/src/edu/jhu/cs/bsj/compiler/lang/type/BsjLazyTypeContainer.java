package edu.jhu.cs.bsj.compiler.lang.type;

/**
 * <p>
 * This interface is implemented by proxy objects which represent lazily-calculated type values. Such types typically
 * proxy the interface for their given type (such as the fashion in which {@link BsjLazyTypeArgumentContainer}
 * implementations forward messages to their corresponding type values); however, these types do not respond correctly
 * to <tt>instanceof</tt> evaluations. This interface is provided to permit the recognition of a lazy type container
 * while type-casing and to permit the "real" type to be extracted.
 * </p>
 * <p>
 * A number of subinterfaces exist which effectively provide an argument to this interface's type parameter. This is
 * necessary to ensure that type casing will work in the presence of erasure.
 * </p>
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of {@link BsjType} that this container contains.
 */
public interface BsjLazyTypeContainer<T extends BsjType> extends BsjType
{
    /**
     * Forces the evaluation of this object's contents, producing a suitable type representation. Calculation is only
     * performed once; thus, this method may simply return a pre-existing value.
     * 
     * @return The resulting type.
     */
    public T evaluate();
}
