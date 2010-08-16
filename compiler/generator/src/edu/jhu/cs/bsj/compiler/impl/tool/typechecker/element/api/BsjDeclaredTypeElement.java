package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import javax.lang.model.element.TypeElement;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;

/**
 * This extension to the underlying modeling system guarantees that the prototypical type it produces is a declared type.
 * @author Zachary Palmer
 */
public interface BsjDeclaredTypeElement extends BsjTypeElement
{
	/**
	 * Retrieves a prototypical type for this element.
	 * @see TypeElement#asType()
	 */
	public BsjExplicitlyDeclaredType asType();
}