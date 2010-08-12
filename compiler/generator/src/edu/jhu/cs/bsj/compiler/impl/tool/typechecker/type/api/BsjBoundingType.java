package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeVariable;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;


/**
 * Represents a type in the BSJ typechecker that can act as a type bound.  This includes type variables, explicitly
 * declared types, and implicitly declared intersection types.
 * @author Zachary Palmer
 */
public interface BsjBoundingType extends BsjReferenceType
{
	/**
	 * Represents the common element conversion between declared types and type variables.
	 * @see DeclaredType#asElement()
	 * @see TypeVariable#asElement()
	 */
	public BsjElement asElement();
}
