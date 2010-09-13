package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public class ExplicitTypeVariableImpl extends AbstractTypeVariableImpl<TypeParameterNode>
{
	public ExplicitTypeVariableImpl(TypecheckerManager manager, TypeParameterNode id, BsjTypeArgument lowerBound,
			BsjTypeArgument upperBound)
	{
		super(manager, id, lowerBound, upperBound);
	}

	@Override
	public BsjTypeParameterElement asElement()
	{
		return new ElementBuildingNodeOperation(getManager()).executeTypeParameterNode(getId(), null);
	}

	@Override
	public String toString()
	{
		return getId().toSourceCode();
	}

	@Override
	public BsjTypeArgument performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		if (substitutionMap.containsKey(this))
		{
			return substitutionMap.get(this);
		} else
		{
			return new ExplicitTypeVariableImpl(getManager(), getId(), getLowerBound().performTypeSubstitution(
					substitutionMap), getUpperBound().performTypeSubstitution(substitutionMap));
		}
	}
}
