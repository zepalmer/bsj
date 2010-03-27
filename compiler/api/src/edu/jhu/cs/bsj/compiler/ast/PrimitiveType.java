package edu.jhu.cs.bsj.compiler.ast;

/**
 * An enumeration of the primitive types in the Java language.
 * @author Zachary Palmer
 */
public enum PrimitiveType
{
    BOOLEAN(Boolean.class),
    BYTE(Byte.class),
    CHAR(Character.class),
    DOUBLE(Double.class),
    FLOAT(Float.class),
    INT(Integer.class),
    LONG(Long.class),
    SHORT(Short.class),
    VOID(null);
    
    private Class<?> wrapper;
    
    private PrimitiveType(Class<?> wrapper)
	{
		this.wrapper = wrapper;
	}

	/**
     * Retrieves the wrapper class for this primitive type (or <code>null</code> if no wrapper class applies).
     */
    public Class<?> getWrapperClass()
    {
    	return this.wrapper;
    }
}
