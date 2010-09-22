package edu.jhu.cs.bsj.compiler.lang;

import java.util.List;

import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

/**
 * This factory is capable of producing objects which model the BSJ language. TODO: more complete interface
 * 
 * @author Zachary Palmer
 */
public interface BsjModelingFactory
{
	/**
	 * Creates an explicitly declared type using the specified arguments.
	 * 
	 * @param typeElement The type element defining this type.
	 * @param typeArguments The type arguments to that element. If this list is empty, a raw type is created.
	 * @param enclosingType The type which encloses this type.
	 * @return The resulting type.
	 * @throws IllegalArgumentException If the type arguments list is of a size incompatible with the specified element
	 *             or if the provided enclosing type is backed by an element which does not lexically enclose this
	 *             type's element.
	 */
	public BsjExplicitlyDeclaredType makeExplicitlyDeclaredType(BsjTypeElement typeElement,
			List<? extends BsjTypeArgument> typeArguments, BsjExplicitlyDeclaredType enclosingType)
			throws IllegalArgumentException;
	
	/**
	 * Creates a {@link BsjExplicitlyDeclaredType} representation of a class currently on the runtime's classpath.
	 * 
	 * @param clazz The class to use.
	 * @return The type representing that class. If the class has type parameters, the returned type is raw.
	 * @throws IllegalArgumentException If the specified class is not on the metaprogram classpath.
	 */
	public BsjActualType makeMetaprogramClasspathType(Class<?> clazz) throws IllegalArgumentException;
}
