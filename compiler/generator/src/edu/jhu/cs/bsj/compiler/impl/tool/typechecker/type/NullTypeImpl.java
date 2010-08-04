package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.NullType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class NullTypeImpl extends TypeMirrorImpl implements NullType
{
	public NullTypeImpl(TypecheckerModelManager manager)
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
}
