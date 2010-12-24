package edu.jhu.cs.bsj.compiler.lang.type;

import javax.lang.model.type.PrimitiveType;

/**
 * Represents a primitive type as seen by the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjPrimitiveType extends PrimitiveType, BsjActualType
{
	public edu.jhu.cs.bsj.compiler.ast.PrimitiveType getPrimitiveType();
	
    /**
     * @see BsjType#evaluate()
     */
    public BsjPrimitiveType evaluate();

}
