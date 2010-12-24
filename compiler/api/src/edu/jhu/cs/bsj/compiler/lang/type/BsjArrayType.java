package edu.jhu.cs.bsj.compiler.lang.type;

import javax.lang.model.type.ArrayType;

/**
 * Represents an array type in the BSJ type checker.
 * @author Zachary Palmer
 */
public interface BsjArrayType extends ArrayType, BsjReferenceType
{
	public BsjType getComponentType();
	
    /**
     * @see BsjType#evaluate()
     */
    public BsjArrayType evaluate();

}
