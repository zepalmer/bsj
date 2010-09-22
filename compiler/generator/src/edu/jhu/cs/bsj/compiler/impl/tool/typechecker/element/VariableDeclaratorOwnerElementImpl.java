package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Name;

import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorOwnerNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

public abstract class VariableDeclaratorOwnerElementImpl<T extends VariableDeclaratorOwnerNode> extends
		AbstractVariableElementImpl<VariableDeclaratorNode>
{
	private int index;
	private T owner;

	public VariableDeclaratorOwnerElementImpl(TypecheckerManager manager, T owner,
			BsjElement enclosingElement, int index)
	{
		super(manager, owner.getDeclarators().get(index), enclosingElement);
		this.index = index;
		this.owner = owner;
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
		return getTypeBuilder().makeType(getOwner().getType());
	}
	
	protected T getOwner()
	{
		return this.owner;
	}

	protected VariableDeclaratorNode getDeclarator()
	{
		return getBackingNode();
	}

	@Override
	public Object getConstantValue()
	{
		throw new NotImplementedYetException();
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getDeclarator().getIdentifier().getIdentifier());
	}
}
