package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class ErrorTypeImpl extends TypeMirrorImpl implements ErrorType
{
	public ErrorTypeImpl(TypecheckerModelManager manager)
	{
		super(manager);
	}

	@Override
	public Element asElement()
	{
		return null;
	}

	@Override
	public TypeMirror getEnclosingType()
	{
		return null;
	}

	@Override
	public List<? extends TypeMirror> getTypeArguments()
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
}
