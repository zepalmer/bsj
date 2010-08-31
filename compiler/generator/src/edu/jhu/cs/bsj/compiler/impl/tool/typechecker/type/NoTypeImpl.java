package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class NoTypeImpl extends TypeMirrorImpl implements BsjNoType
{
	private TypeKind kind;

	public NoTypeImpl(TypecheckerManager manager, TypeKind kind)
	{
		super(manager);
		this.kind = kind;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitNoType(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return kind;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return this.equals(type);
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}
}
