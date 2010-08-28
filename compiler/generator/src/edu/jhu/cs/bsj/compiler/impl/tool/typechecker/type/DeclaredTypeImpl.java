package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.Collections;
import java.util.List;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;

/**
 * TODO: fix
 * 
 * Represents a declared type in the BSJ type checker. Declared types include explicitly declared types (such as named
 * type declarations) as well as implicitly declared intersection types. The latter are declared in type parameter
 * bounds, such as the following:
 * 
 * <pre>
 * public class MyClass&lt;T extends Foo &amp; Bar&gt;
 * {
 * }
 * </pre>
 * 
 * The type parameter <tt>T</tt> implicitly declares an intersection type which extends the <tt>Foo</tt> class and
 * implements the <tt>Bar</tt> interface. Implicit intersection types are unusual in Java in that any type which meets
 * these criteria (extending <tt>Foo</tt> and implementing <tt>Bar</tt>) is considered to be a member of the
 * intersection type even though it did not explicitly state as much.
 * 
 * @author Zachary Palmer
 */
public class DeclaredTypeImpl extends TypeMirrorImpl implements BsjExplicitlyDeclaredType
{
	/**
	 * The type element which acts as the backing element for this type.
	 */
	private BsjTypeElement typeElement;
	/**
	 * The type arguments applied to the underlying type element to form this type.
	 */
	private List<? extends BsjTypeArgument> typeArguments;
	/**
	 * The type which encloses this type.
	 */
	private BsjDeclaredType enclosingType;

	public DeclaredTypeImpl(TypecheckerManager manager, BsjTypeElement typeElement,
			List<? extends BsjTypeArgument> typeArguments, BsjDeclaredType enclosingType)
	{
		super(manager);
		this.typeElement = typeElement;
		this.typeArguments = Collections.unmodifiableList(typeArguments);
		this.enclosingType = enclosingType;
	}

	@Override
	public BsjTypeElement asElement()
	{
		return this.typeElement;
	}

	@Override
	public BsjDeclaredType calculateErasure()
	{
		BsjDeclaredType erasedEnclosingType = enclosingType == null ? null : enclosingType.calculateErasure();
		return new DeclaredTypeImpl(getManager(), this.typeElement, Collections.<BsjTypeArgument> emptyList(),
				erasedEnclosingType);
	}

	@Override
	public BsjDeclaredType getEnclosingType()
	{
		return this.enclosingType;
	}

	@Override
	public List<? extends BsjTypeArgument> getTypeArguments()
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
		if (this.enclosingType != null)
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
