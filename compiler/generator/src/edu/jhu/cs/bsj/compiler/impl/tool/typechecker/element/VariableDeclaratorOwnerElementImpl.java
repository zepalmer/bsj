package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Name;

import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class VariableDeclaratorOwnerElementImpl<T extends VariableDeclaratorOwnerNode> extends
		AbstractVariableElementImpl<T>
{
	private int index;

	public VariableDeclaratorOwnerElementImpl(TypecheckerModelManager manager, T backingNode, BsjElement enclosingElement,
			int index)
	{
		super(manager, backingNode, enclosingElement);
		this.index = index;
	}

	public int getIndex()
	{
		return index;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VariableDeclaratorOwnerElementImpl<?> other = (VariableDeclaratorOwnerElementImpl<?>) obj;
		if (index != other.index)
			return false;
		return true;
	}

	@Override
	public BsjType asType()
	{
		// TODO: what about array levels?
		return getTypeBuilder().makeType(getBackingNode().getType());
	}

	protected VariableDeclaratorNode getDeclarator()
	{
		return getBackingNode().getDeclarators().get(getIndex());
	}

	@Override
	public Object getConstantValue()
	{
		throw new NotImplementedYetException();
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getDeclarator().getName().getIdentifier());
	}
}
