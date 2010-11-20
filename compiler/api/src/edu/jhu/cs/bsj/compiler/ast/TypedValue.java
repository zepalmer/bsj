package edu.jhu.cs.bsj.compiler.ast;

import edu.jhu.cs.bsj.compiler.lang.BsjModelingFactory;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;

/**
 * This class represents a pairing between a value and a type. It is used for the construction of modeling data
 * structures such as the {@link SelectionBag} in the {@link BsjModelingFactory}.
 * 
 * @param <T> A bound on this value which is its statically-known type.
 * @author Zachary Palmer
 */
public class TypedValue<T>
{
    private T value;
    private BsjActualType type;

    public TypedValue(T value, BsjActualType type)
    {
        super();
        this.value = value;
        this.type = type;
    }

    public T getValue()
    {
        return value;
    }

    public BsjActualType getType()
    {
        return type;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypedValue<?> other = (TypedValue<?>) obj;
        if (type == null)
        {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (value == null)
        {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
