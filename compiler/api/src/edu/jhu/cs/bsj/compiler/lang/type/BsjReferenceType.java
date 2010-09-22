package edu.jhu.cs.bsj.compiler.lang.type;

import javax.lang.model.type.ReferenceType;

/**
 * Represents a reference type in the BSJ typechecker.
 * 
 * @author Zachary Palmer
 */
public interface BsjReferenceType extends ReferenceType, BsjActualType, BsjTypeArgument
{
}
