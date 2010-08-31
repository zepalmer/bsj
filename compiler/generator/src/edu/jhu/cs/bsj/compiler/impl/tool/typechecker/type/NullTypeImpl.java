package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNullType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class NullTypeImpl extends ReferenceTypeImpl implements BsjNullType
{
	public NullTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitNull(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.NULL;
	}

	@Override
	public String toString()
	{
		return "null";
	}

	@Override
	public boolean equals(Object obj)
	{
		return getClass() == obj.getClass();
	}

	@Override
	public int hashCode()
	{
		return 1665993391;
	}

	@Override
	public BsjType calculateErasure()
	{
		return this;
	}

	@Override
	public boolean isSubtypeOf(BsjType type)
	{
		return (type instanceof BsjReferenceType);
	}
}
