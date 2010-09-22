package edu.jhu.cs.bsj.compiler.lang.type;

import java.util.List;
import java.util.Map;

import javax.lang.model.type.ExecutableType;

/**
 * Represents an executable type as seen by the BSJ typechecker.
 * 
 * @author Zachary Palmer
 */
public interface BsjExecutableType extends ExecutableType, BsjActualType
{
	public List<? extends BsjType> getParameterTypes();

	public BsjType getReturnType();

	public List<? extends BsjType> getThrownTypes();

	public List<? extends BsjTypeVariable> getTypeVariables();

	public BsjExecutableType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap);
	
	public boolean isVarargs();
}
