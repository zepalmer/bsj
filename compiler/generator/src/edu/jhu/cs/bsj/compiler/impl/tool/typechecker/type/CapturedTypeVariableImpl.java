package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

public class CapturedTypeVariableImpl extends AbstractTypeVariableImpl<Integer>
{
	private static AtomicInteger nextId = new AtomicInteger(0);

	public CapturedTypeVariableImpl(TypecheckerManager manager, BsjTypeArgument lowerBound, BsjTypeArgument upperBound)
	{
		super(manager, nextId.getAndIncrement(), lowerBound, upperBound);
	}

	@Override
	public BsjTypeParameterElement asElement()
	{
		return null;
	}

	@Override
	public String toString()
	{
		return "capture-#" + getId() + "-of-?";
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		throw new NotImplementedYetException();
	}
}
