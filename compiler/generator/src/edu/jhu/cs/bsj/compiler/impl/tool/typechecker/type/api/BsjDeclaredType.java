package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import java.util.List;

import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;

/**
 * Represents declared types in the BSJ typechecker.  Declared types include explicitly declared types (such as
 * classes, interfaces, annotations, and enums) as well as implicitly declared intersection types (such as in the
 * bound of the type variable declaration <tt>T extends A &amp; B</tt>).
 * 
 * @author Zachary Palmer
 */
public interface BsjDeclaredType extends DeclaredType, BsjBoundingType
{
	/**
	 * Determines whether or not this declared type is implicit. The only implicitly declared types in the Java language
	 * are those formed by multiple type parameter bounds, such as in the class declaration header
	 * <tt>public class MyClass&lt;T extends Foo &amp; Bar&gt;</tt>.
	 * 
	 * @return <code>true</code> if this type is implicit; <code>false</code> if it is not.
	 */
	public boolean isImplicit();

	/**
	 * Retrieves the enclosing type for this type.
	 * 
	 * @see DeclaredType#getEnclosingType()
	 */
	public BsjDeclaredType getEnclosingType();

	/**
	 * Retrieves the type arguments for this declared type.
	 * 
	 * @see DeclaredType#getTypeArguments()
	 */
	public List<? extends BsjType> getTypeArguments();

	/**
	 * Retrieves an element for this declared type.
	 * 
	 * @see DeclaredType#asElement()
	 */
	public BsjTypeLikeElement asElement();
	
	/**
	 * Creates an erasure for this declared type which is guaranteed to be another declared type.
	 * @see BsjType#calculateErasure()
	 */
	public BsjDeclaredType calculateErasure();
}
