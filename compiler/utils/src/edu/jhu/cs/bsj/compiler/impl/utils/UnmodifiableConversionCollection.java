package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * This collection proxy class allows a collection of type <tt>U</tt> to be viewed as a collection of type <tt>T</tt>.
 * Because it is unmodifiable, only a single direction of conversion is required.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type that this list appears to contain.
 * @param <U> The type contained by the backinglist.
 */
public class UnmodifiableConversionCollection<T, U> extends AbstractCollection<T>
{
    private Collection<U> collection;
    private Converter<U, T> converter;

    public UnmodifiableConversionCollection(Collection<U> collection, Converter<U, T> converter)
    {
        super();
        this.collection = collection;
        this.converter = converter;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ConversionIterator<T, U>(this.collection.iterator(), this.converter);
    }

    @Override
    public int size()
    {
        return this.collection.size();
    }
}
