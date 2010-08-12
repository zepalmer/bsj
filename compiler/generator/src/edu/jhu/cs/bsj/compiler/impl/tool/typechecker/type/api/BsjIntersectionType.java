package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;

/**
 * Represents an implicitly declared intersection type, such as in the bounds of the type parameter declaration
 * <tt>T extends A &amp; B</tt>.
 * @author Zachary Palmer
 *
 */
public interface BsjIntersectionType extends BsjDeclaredType
{
	/**
	 * Retrieves an element for this declared type.
	 * 
	 * @see DeclaredType#asElement()
	 */
	public BsjTypeParameterElement asElement();
}
