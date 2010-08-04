package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

/**
 * Represents a declared type in the BSJ type checker.
 * 
 * @author Zachary Palmer
 */
public class DeclaredTypeImpl extends TypeMirrorImpl implements DeclaredType
{
	private TypeElement typeElement;
	private List<? extends TypeMirror> typeArguments;
	private TypeMirror enclosingType;
	
	public DeclaredTypeImpl(TypecheckerModelManager manager, TypeElement typeElement,
			List<? extends TypeMirror> typeArguments, TypeMirror enclosingType)
	{
		super(manager);
		this.typeElement = typeElement;
		this.typeArguments = typeArguments;
		this.enclosingType = enclosingType;
	}

	@Override
	public Element asElement()
	{
		return this.typeElement;
	}

	@Override
	public TypeMirror getEnclosingType()
	{
		return this.enclosingType;
	}

	@Override
	public List<? extends TypeMirror> getTypeArguments()
	{
		return this.typeArguments;
	}

	@Override
	public <R, P> R accept(TypeVisitor<R, P> v, P p)
	{
		return v.visitDeclared(this, p);
	}

	@Override
	public TypeKind getKind()
	{
		return TypeKind.DECLARED;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (this.enclosingType!=null)
		{
			sb.append(this.enclosingType.toString());
			sb.append('.');
		}
		sb.append(this.typeElement.toString());
		if (this.typeArguments.size() > 0)
		{
			sb.append('<');
			boolean first = true;
			for (TypeMirror arg : this.typeArguments)
			{
				if (!first)
					sb.append(", ");
				sb.append(arg.toString());
				first = false;
			}
			sb.append('>');
		}
		return sb.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enclosingType == null) ? 0 : enclosingType.hashCode());
		result = prime * result + ((typeArguments == null) ? 0 : typeArguments.hashCode());
		result = prime * result + ((typeElement == null) ? 0 : typeElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		DeclaredTypeImpl other = (DeclaredTypeImpl) obj;
		if (enclosingType == null)
		{
			if (other.enclosingType != null)
				return false;
		} else if (!enclosingType.equals(other.enclosingType))
			return false;
		if (typeArguments == null)
		{
			if (other.typeArguments != null)
				return false;
		} else if (!typeArguments.equals(other.typeArguments))
			return false;
		if (typeElement == null)
		{
			if (other.typeElement != null)
				return false;
		} else if (!typeElement.equals(other.typeElement))
			return false;
		return true;
	}
}
