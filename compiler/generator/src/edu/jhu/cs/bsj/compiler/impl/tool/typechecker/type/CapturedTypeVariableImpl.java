package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class CapturedTypeVariableImpl extends AbstractTypeVariableImpl<Integer>
{
	private static AtomicInteger nextId;

	public CapturedTypeVariableImpl(TypecheckerManager manager, BsjType lowerBound, BsjType upperBound)
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
}
