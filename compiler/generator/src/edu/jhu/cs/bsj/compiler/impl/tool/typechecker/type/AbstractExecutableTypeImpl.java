package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExecutableType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class AbstractExecutableTypeImpl<T extends Node> extends ReferenceTypeImpl implements
		BsjExecutableType
{
	private T backingNode;

	public AbstractExecutableTypeImpl(TypecheckerManager manager, T backingNode)
	{
		super(manager);
		this.backingNode = backingNode;
	}

	protected T getBackingNode()
	{
		return this.backingNode;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitExecutable(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.EXECUTABLE;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backingNode == null) ? 0 : backingNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		AbstractExecutableTypeImpl<?> other = (AbstractExecutableTypeImpl<?>) obj;
		if (this.getBackingNode().getUid() != other.getBackingNode().getUid())
			return false;
		return true;
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		boolean first = true;
		for (BsjType paramType : getParameterTypes())
		{
			if (!first)
				sb.append(',');
			sb.append(paramType.toString());
			first = false;
		}
		sb.append(")->");
		sb.append(getReturnType().toString());
		return sb.toString();
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		// There is no specification in the JLS which permits subtyping of executable elements.
		return this.equals(type);
	}
}
