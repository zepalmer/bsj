package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjErrorType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class ErrorTypeImpl extends TypeMirrorImpl implements BsjErrorType
{
	public ErrorTypeImpl(TypecheckerManager manager)
	{
		super(manager);
	}

	@Override
	public BsjTypeElement asElement()
	{
		return null;
	}

	@Override
	public BsjDeclaredType getEnclosingType()
	{
		return null;
	}

	@Override
	public List<? extends BsjType> getTypeArguments()
	{
		return Collections.emptyList();
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitError(this, p);
	}

	@Override
	public boolean equals(Object obj)
	{
		return (this.getClass() == obj.getClass());
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.ERROR;
	}

	@Override
	public int hashCode()
	{
		return 2358129;
	}

	@Override
	public String toString()
	{
		return "<error>";
	}

	@Override
	public boolean isImplicit()
	{
		return false;
	}

	@Override
	public BsjDeclaredType calculateErasure()
	{
		return this;
	}
}
