package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.ElementBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class ExplicitTypeVariableImpl extends AbstractTypeVariableImpl<TypeParameterNode>
{
	public ExplicitTypeVariableImpl(TypecheckerManager manager, TypeParameterNode id, BsjType lowerBound,
			BsjType upperBound)
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
		return getId().getIdentifier().getIdentifier();
	}
	
}
