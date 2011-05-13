package edu.jhu.cs.bsj.compiler.lang.type;

import java.util.List;
import java.util.Map;

import javax.lang.model.type.ExecutableType;

import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;

/**
 * Represents an executable type as seen by the BSJ typechecker.
 * 
 * @author Zachary Palmer
 */
public interface BsjExecutableType extends ExecutableType, BsjActualType
{
	public List<? extends BsjType> getParameterTypes();
	
	public List<String> getParameterNames();

	public BsjType getReturnType();

	public List<? extends BsjType> getThrownTypes();

	public List<? extends BsjTypeVariable> getTypeVariables();

	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap);
	
	public boolean isVarargs();
	
	public BsjExecutableElement asElement();
	
    /**
     * @see BsjType#evaluate()
     */
    public BsjExecutableType evaluate();

}
