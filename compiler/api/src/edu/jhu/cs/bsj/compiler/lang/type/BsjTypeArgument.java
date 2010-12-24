package edu.jhu.cs.bsj.compiler.lang.type;

import java.util.Map;

/**
 * This tagging interface identifies a type as suitable for use as a type argument.
 * @author Zachary Palmer
 */
public interface BsjTypeArgument extends BsjActualType
{
	/**
	 * Implements a check for containment as specified in JLSv3 §4.5.1.1.
	 * @param argument The other type argument.
	 * @return <code>true</code> if this type argument contains the provided type argument; <code>false</code> if it
	 * does not.
	 */
	public boolean contains(BsjTypeArgument argument);
	
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap);
	
	public BsjTypeArgument calculateErasure();
	
    /**
     * @see BsjType#evaluate()
     */
    public BsjTypeArgument evaluate();

}
