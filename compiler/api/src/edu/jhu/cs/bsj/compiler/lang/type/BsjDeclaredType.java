package edu.jhu.cs.bsj.compiler.lang.type;

import java.util.List;

import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;

/**
 * Represents declared types in the BSJ typechecker.  Declared types include explicitly declared types (such as
 * classes, interfaces, annotations, and enums) as well as implicitly declared intersection types (such as in the
 * bound of the type variable declaration <tt>T extends A &amp; B</tt>).
 * 
 * @author Zachary Palmer
 */
public interface BsjDeclaredType extends DeclaredType, BsjReferenceType
{
	/**
	 * Retrieves the type arguments for this declared type.
	 * 
	 * @see DeclaredType#getTypeArguments()
	 */
	public List<? extends BsjTypeArgument> getTypeArguments();
	
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
