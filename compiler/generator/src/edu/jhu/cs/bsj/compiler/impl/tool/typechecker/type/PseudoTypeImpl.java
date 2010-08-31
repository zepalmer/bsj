package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Map;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;

public abstract class PseudoTypeImpl extends TypeMirrorImpl implements BsjNoType
{
	private TypeKind kind;

	public PseudoTypeImpl(TypecheckerManager manager, TypeKind kind)
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

	@Override
	public BsjType performTypeSubstitution(Map<BsjTypeVariable, BsjTypeArgument> substitutionMap)
	{
		return this;
	}
}
