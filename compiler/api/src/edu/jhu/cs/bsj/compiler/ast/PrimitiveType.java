package edu.jhu.cs.bsj.compiler.ast;

/**
 * An enumeration of the primitive types in the Java language.
 * @author Zachary Palmer
 */
public enum PrimitiveType
{
    BOOLEAN(Boolean.class, null),
    DOUBLE(Double.class, null),
    FLOAT(Float.class, DOUBLE),
    LONG(Long.class, FLOAT),
    INT(Integer.class, LONG),
    SHORT(Short.class, INT),
    CHAR(Character.class, INT),
    BYTE(Byte.class, SHORT),
    
    ;
    
    private Class<?> wrapper;
    private PrimitiveType directSupertype;
    
    private PrimitiveType(Class<?> wrapper, PrimitiveType directSupertype)
	{
		this.wrapper = wrapper;
		this.directSupertype = directSupertype;
	}

	/**
     * Retrieves the wrapper class for this primitive type (or <code>null</code> if no wrapper class applies).
     */
    public Class<?> getWrapperClass()
    {
    	return this.wrapper;
    }

    /**
     * Determines the direct primitive supertype of this primitive type.
     * @return The supertype of this primitive type or <code>null</code> if no such supertype exists.
     */
	public PrimitiveType getDirectSupertype()
	{
		return directSupertype;
	}
    
    /**
     * Determines whether or not the provided primitive is a supertype of this one.
     * @param primitiveType The other primitive type.
     * @return <code>true</code> if the provided primitive type is a supertype of this one; <code>false</code> otherwise.
     */
	public boolean isSubtypeOf(PrimitiveType primitiveType)
	{
		PrimitiveType current = this;
		while (current != null)
		{
			if (current == primitiveType)
			{
				return true;
			}
			current = current.getDirectSupertype();
		}
		return false;
	}
}
