package edu.jhu.cs.bsj.compiler.lang;

import java.util.Collection;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.TypedValue;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.lang.element.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjActualType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjIntersectionType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.value.SelectionBag;

/**
 * This factory is capable of producing objects which model the BSJ language. TODO: more complete interface
 * 
 * @author Zachary Palmer
 */
public interface BsjModelingFactory
{
    /**
     * Creates a type based on the provided {@link TypeNode}.
     * @param node The node on which to base the type.
     * @return The resulting type.
     */
    public BsjType makeTypeFromNode(TypeNode node);
    
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
    public BsjExplicitlyDeclaredType makeExplicitlyDeclaredType(BsjDeclaredTypeElement typeElement,
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

    /**
     * Creates a {@link BsjIntersectionType} to represent an intersection type (as per JLSv3 &#A7;4.9).
     * 
     * @param supertypes The supertypes of the intersection type.
     * @return The resulting intersection type.
     */
    public BsjIntersectionType makeIntersectionType(List<BsjTypeArgument> supertypes);

    /**
     * Creates a BSJ {@link SelectionBag} value.
     * 
     * @param elements The elements for the selection bag. Each element is tagged with the type it has in the bag, which
     *            may be less specific that its actual type.
     * @return The selection bag representing these elements.
     */
    public <T> SelectionBag<T> makeSelectionBag(Collection<? extends TypedValue<T>> elements);

}
