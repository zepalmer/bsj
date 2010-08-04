package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

/**
 * Represents a primitive type in the BSJ type checker.
 * 
 * @author Zachary Palmer
 */
public class PrimitiveTypeImpl extends TypeMirrorImpl implements javax.lang.model.type.PrimitiveType
{
	private PrimitiveType primitiveType;
	
	public PrimitiveTypeImpl(TypecheckerModelManager manager, PrimitiveType primitiveType)
	{
		super(manager);
		this.primitiveType = primitiveType;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitPrimitive(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		switch (this.primitiveType)
		{
			case BOOLEAN:
				return TypeKind.BOOLEAN;
			case BYTE:
				return TypeKind.BYTE;
			case CHAR:
				return TypeKind.CHAR;
			case DOUBLE:
				return TypeKind.DOUBLE;
			case FLOAT:
				return TypeKind.FLOAT;
			case INT:
				return TypeKind.INT;
			case LONG:
				return TypeKind.LONG;
			case SHORT:
				return TypeKind.SHORT;
			case VOID:
				return TypeKind.VOID;
		}
		throw new IllegalStateException("Unknown mapping from PrimitiveType " + this.primitiveType + " to TypeKind");
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((primitiveType == null) ? 0 : primitiveType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		PrimitiveTypeImpl other = (PrimitiveTypeImpl) obj;
		if (primitiveType == null)
		{
			if (other.primitiveType != null)
				return false;
		} else if (!primitiveType.equals(other.primitiveType))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return this.primitiveType.toString().toLowerCase();
	}
}
