package edu.jhu.cs.bsj.compiler.lang.type;

/**
 * This subtype is implemented only by reference types which are named. This includes explicitly declared types as well
 * as type variables.
 * 
 * @author Zachary Palmer
 */
public interface BsjNamedReferenceType extends BsjReferenceType
{
	public BsjTypeArgument calculateErasure();
}
