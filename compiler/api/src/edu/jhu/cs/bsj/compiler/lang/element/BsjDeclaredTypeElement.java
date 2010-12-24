package edu.jhu.cs.bsj.compiler.lang.element;

import java.util.List;

import javax.lang.model.element.TypeElement;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.lang.type.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

/**
 * This extension to the underlying modeling system guarantees that the prototypical type it produces is a declared
 * type.
 * 
 * @author Zachary Palmer
 */
public interface BsjDeclaredTypeElement extends BsjTypeLikeElement, TypeElement
{
    public NamedTypeDeclarationNode<?> getDeclarationNode();

    /**
     * Retrieves a prototypical type for this element.
     * 
     * @see TypeElement#asType()
     */
    public BsjExplicitlyDeclaredType asType();

    /**
     * Returns the formal type parameters of this type element in declaration order.
     * 
     * @return the formal type parameters, or an empty list if there are none
     */
    public List<? extends BsjTypeParameterElement> getTypeParameters();
    
    /**
     * Obtains a prototypical type argument list for this type element.  This list contains type arguments which
     * represent type variables identifying the type parameters of the type element.  For instance, the type element
     * <tt>Set&lt;T&gt;</tt> would produce a singleton list with a type variable referring to <tt>T</tt>.
     * @return The list of prototypical type arguments.
     */
    public List<? extends BsjTypeArgument> getPrototypicalTypeArgumentList();
}