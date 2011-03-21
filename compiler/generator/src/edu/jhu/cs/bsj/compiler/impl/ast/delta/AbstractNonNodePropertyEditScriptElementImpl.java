package edu.jhu.cs.bsj.compiler.impl.ast.delta;


/**
 * Represents an edit script element which sets the value of a specific non-node property.  The type of the property
 * is represented as a type parameter; primitives are promoted to boxes as necessary.
 * @author Zachary Palmer
 * @param <T> The type of property being set.
 */
public abstract class AbstractNonNodePropertyEditScriptElementImpl<T> extends AbstractPropertyEditScriptElementImpl
{
    private T value;

    public AbstractNonNodePropertyEditScriptElementImpl(int metaprogramId, long targetId, T value)
    {
        super(metaprogramId, targetId);
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }
}
