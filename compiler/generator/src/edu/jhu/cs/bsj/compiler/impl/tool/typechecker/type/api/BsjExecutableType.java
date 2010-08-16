package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import java.util.List;

import javax.lang.model.type.ExecutableType;

/**
 * Represents an executable type as seen by the BSJ typechecker.
 * @author Zachary Palmer
 */
public interface BsjExecutableType extends ExecutableType, BsjType
{
	public List<? extends BsjType> getParameterTypes();
	public BsjType getReturnType();
	public List<? extends BsjType> getThrownTypes();
	public List<? extends BsjTypeVariable> getTypeVariables();
}
