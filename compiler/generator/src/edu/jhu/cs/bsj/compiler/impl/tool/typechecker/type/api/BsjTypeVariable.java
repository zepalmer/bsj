package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeVariable;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;

/**
 * Represents a type variable in the BSJ type checker.
 * @author Zachary Palmer
 */
public interface BsjTypeVariable extends TypeVariable, BsjNamedReferenceType
{
	/**
	 * Retrieves the type parameter element which defined this type variable.
	 * @see DeclaredType#asElement()
	 * @see TypeVariable#asElement()
	 */
	public BsjTypeParameterElement asElement();
	
	public BsjTypeArgument getUpperBound();
	
	public BsjTypeArgument getLowerBound();
}
