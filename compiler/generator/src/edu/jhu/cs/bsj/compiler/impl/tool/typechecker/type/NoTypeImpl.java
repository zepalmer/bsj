package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.NoType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class NoTypeImpl extends TypeMirrorImpl implements NoType
{
	private TypeKind kind;

	public NoTypeImpl(TypecheckerModelManager manager, TypeKind kind)
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
	public boolean equals(Object obj)
	{
		return obj instanceof NoTypeImpl;
	}

	@Override
	public int hashCode()
	{
		return 51787898;
	}

	@Override
	public String toString()
	{
		return "(no type)";
	}

	public static NoTypeImpl makeNone(TypecheckerModelManager manager)
	{
		return new NoTypeImpl(manager, TypeKind.NONE);
	}

	public static NoTypeImpl makePackage(TypecheckerModelManager manager)
	{
		return new NoTypeImpl(manager, TypeKind.PACKAGE);
	}

	public static NoTypeImpl makeVoid(TypecheckerModelManager manager)
	{
		return new NoTypeImpl(manager, TypeKind.VOID);
	}
}
