package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Element;
import javax.lang.model.element.Name;

import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class VariableDeclaratorOwnerElementImpl<T extends VariableDeclaratorOwnerNode> extends
		AbstractVariableElementImpl<T>
{
	private int index;

	public VariableDeclaratorOwnerElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
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
