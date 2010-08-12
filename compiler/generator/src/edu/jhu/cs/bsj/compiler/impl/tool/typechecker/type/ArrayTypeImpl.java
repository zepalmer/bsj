package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;

public class ArrayTypeImpl extends TypeMirrorImpl implements BsjArrayType
{
	private TypeMirror componentType;
	
	public ArrayTypeImpl(TypecheckerModelManager manager, TypeMirror componentType)
	{
		super(manager);
		this.componentType = componentType;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitArray(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.ARRAY;
	}

	@Override
	public String toString()
	{
		return this.componentType.toString() + "[]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ArrayTypeImpl other = (ArrayTypeImpl) obj;
		if (componentType == null)
		{
			if (other.componentType != null)
				return false;
		} else if (!componentType.equals(other.componentType))
			return false;
		return true;
	}

	@Override
	public TypeMirror getComponentType()
	{
		return this.componentType;
	}
}
