package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExecutableType;

public abstract class AbstractExecutableTypeImpl<T extends Node> extends TypeMirrorImpl implements BsjExecutableType
{
	private T backingNode;

	public AbstractExecutableTypeImpl(TypecheckerModelManager manager, T backingNode)
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
}
