package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;

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
public class DeclaredTypeImpl extends EnumerableDirectSupertypeTypeImpl implements BsjExplicitlyDeclaredType
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
	protected Collection<? extends BsjType> getDirectSupertypes()
	{
		Collection<BsjType> supertypes = new ArrayList<BsjType>();
		NamedTypeDeclarationNode<?> namedTypeDeclarationNode = this.asElement().getDeclarationNode();
		if (namedTypeDeclarationNode instanceof ClassDeclarationNode)
		{
			ClassDeclarationNode decl = (ClassDeclarationNode) namedTypeDeclarationNode;
			if (decl.getExtendsClause() != null)
			{
				supertypes.add(getManager().getToolkit().getTypeBuilder().makeType(decl.getExtendsClause()));
			} else
			{
				supertypes.add(getManager().getToolkit().getObjectElement().asType());
			}
			for (TypeNode typeNode : decl.getImplementsClause())
			{
				supertypes.add(getManager().getToolkit().getTypeBuilder().makeType(typeNode));
			}
			if (decl.getTypeParameters().size() != 0)
			{
				supertypes.add(new DeclaredTypeImpl(getManager(), asElement(),
						Collections.<BsjTypeArgument> emptyList(), getEnclosingType()));
			}
		} else if (namedTypeDeclarationNode instanceof InterfaceDeclarationNode)
		{
			InterfaceDeclarationNode decl = (InterfaceDeclarationNode) namedTypeDeclarationNode;
			if (decl.getExtendsClause().size() == 0)
			{
				supertypes.add(getManager().getToolkit().getObjectElement().asType());
			} else
			{
				for (TypeNode typeNode : decl.getExtendsClause())
				{
					supertypes.add(getManager().getToolkit().getTypeBuilder().makeType(typeNode));
				}
			}
			if (decl.getTypeParameters().size() != 0)
			{
				supertypes.add(new DeclaredTypeImpl(getManager(), asElement(),
						Collections.<BsjTypeArgument> emptyList(), getEnclosingType()));
			}
		} else if (namedTypeDeclarationNode instanceof EnumDeclarationNode)
		{
			supertypes.add(new DeclaredTypeImpl(getManager(), getManager().getToolkit().getEnumElement(),
					Collections.singletonList(this), null));
		} else if (namedTypeDeclarationNode instanceof AnnotationDeclarationNode)
		{
			supertypes.add(getManager().getToolkit().getAnnotationElement().asType());
		} else
		{
			throw new IllegalStateException("Unknown named type declaration node type: "
					+ namedTypeDeclarationNode.getClass());
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BsjType captureConvert()
	{
		List<BsjTypeArgument> captureConversionArguments = new ArrayList<BsjTypeArgument>();
		// for each type argument, perform the argument capture
		// TODO: what if we're capture-converting a raw type?
		Iterator<? extends BsjTypeArgument> typeArgIt = getTypeArguments().iterator();
		Iterator<? extends BsjTypeParameterElement> paramIt = asElement().getTypeParameters().iterator();
		while (typeArgIt.hasNext() && paramIt.hasNext())
		{
			BsjTypeArgument typeArgument = typeArgIt.next();
			BsjTypeParameterElement parameterElement = paramIt.next();

			if (typeArgument instanceof BsjWildcardType)
			{
				BsjWildcardType wildcardType = (BsjWildcardType) typeArgument;
				if (wildcardType.getSuperBound() == null)
				{
					if (wildcardType.getExtendsBound() == null)
					{
						// handle: ?
						// the argument to add to the list is a fresh type variable bounded from above by the
						// bound of the corresponding type parameter
						captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(), null,
								getParameterBoundAsType(parameterElement)));
					} else
					{
						// handle: ? extends Foo
						// the argument to add to the list is a fresh type variable bounded from above by the
						// intersection between the corresponding type parameter and the wildcard bound
						List<BsjTypeArgument> bounds = new ArrayList<BsjTypeArgument>(parameterElement.getBounds());
						bounds.add(wildcardType.getExtendsBound());
						captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(), null,
								getBoundListAsType(bounds)));
					}
				} else
				{
					// then extends bound, by definition of WildcardTypeNode, must be null
					// handle: ? super Foo
					// the argument to add to the list is a fresh type variable bounded from above by the
					// bound of the corresponding type parameter and from below by the wildcard bound
					captureConversionArguments.add(new CapturedTypeVariableImpl(getManager(),
							wildcardType.getSuperBound(), getParameterBoundAsType(parameterElement)));
				}
			} else
			{
				captureConversionArguments.add(typeArgument);
			}
		}
		return new DeclaredTypeImpl(getManager(), asElement(), captureConversionArguments, getEnclosingType());
	}

	/**
	 * Calculates, given a specified type parameter element, a single type representing that type parameter's bound.
	 * 
	 * @param typeParameterElement The element in question.
	 * @return The upper bound of the type parameter represented by that element.
	 */
	private BsjTypeArgument getParameterBoundAsType(BsjTypeParameterElement parameter)
	{
		List<? extends BsjTypeArgument> bounds = parameter.getBounds();
		return getBoundListAsType(bounds);
	}

	private BsjTypeArgument getBoundListAsType(List<? extends BsjTypeArgument> bounds)
	{
		if (bounds.size() == 0)
		{
			return getManager().getToolkit().getObjectElement().asType();
		} else if (bounds.size() == 1)
		{
			return bounds.iterator().next();
		} else
		{
			return new IntersectionTypeImpl(getManager(), bounds);
		}
	}

	@Override
	public BsjType unboxConvert()
	{
		TypecheckerToolkit toolkit = getManager().getToolkit();
		if (this.equals(toolkit.getByteWrapperType()))
			return toolkit.getByteType();
		if (this.equals(toolkit.getCharacterWrapperType()))
			return toolkit.getCharType();
		if (this.equals(toolkit.getIntegerWrapperType()))
			return toolkit.getIntType();
		if (this.equals(toolkit.getLongWrapperType()))
			return toolkit.getLongType();
		if (this.equals(toolkit.getShortWrapperType()))
			return toolkit.getShortType();
		if (this.equals(toolkit.getDoubleWrapperType()))
			return toolkit.getDoubleType();
		if (this.equals(toolkit.getFloatWrapperType()))
			return toolkit.getFloatType();
		if (this.equals(toolkit.getBooleanWrapperType()))
			return toolkit.getBooleanType();
		return this;
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
