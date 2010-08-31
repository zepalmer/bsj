package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.NestingKind;

import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

/**
 * This class is a utility which is used in the construction of type objects.
 * 
 * @author Zachary Palmer
 */
public class TypeBuilder
{
	// TODO: the methods in this class do not react well to the requested type being unbound
	
	private TypecheckerManager manager;

	public TypeBuilder(TypecheckerManager manager)
	{
		super();
		this.manager = manager;
	}

	private TypeNamespaceMap getTypeNamespaceMap(Node node)
	{
		return this.manager.getNamespaceBuilder().getTypeNamespace(node);
	}

	public BsjTypeArgument makeArgumentType(TypeArgumentNode node)
	{
		if (node instanceof ReferenceTypeNode)
		{
			return makeReferenceType((ReferenceTypeNode) node);
		} else if (node instanceof WildcardTypeNode)
		{
			return makeWildcardType((WildcardTypeNode) node);
		} else
		{
			throw new IllegalStateException("Can't create a type for node of type " + node.getClass());
		}
	}

	public BsjType makeType(TypeNode node)
	{
		if (node instanceof PrimitiveTypeNode)
		{
			return makePrimitiveType((PrimitiveTypeNode) node);
		} else if (node instanceof VoidTypeNode)
		{
			return makeVoidType((VoidTypeNode) node);
		} else if (node instanceof WildcardTypeNode)
		{
			return makeWildcardType((WildcardTypeNode) node);
		} else if (node instanceof ReferenceTypeNode)
		{
			return makeReferenceType((ReferenceTypeNode) node);
		} else
		{
			throw new IllegalStateException("Can't create a type for node of type " + node.getClass());
		}
	}

	public BsjReferenceType makeReferenceType(ReferenceTypeNode node)
	{
		if (node instanceof ArrayTypeNode)
		{
			return makeArrayType((ArrayTypeNode) node);
		} else if (node instanceof ParameterizedTypeNode)
		{
			return makeParameterizedType((ParameterizedTypeNode) node);
		} else if (node instanceof ParameterizedTypeSelectNode)
		{
			return makeParameterizedTypeSelect((ParameterizedTypeSelectNode) node);
		} else if (node instanceof TypeParameterNode)
		{
			return makeTypeVariable((TypeParameterNode) node);
		} else if (node instanceof UnparameterizedTypeNode)
		{
			return makeUnparameterizedType((UnparameterizedTypeNode) node);
		} else
		{
			throw new IllegalStateException("Can't create a type for node of type " + node.getClass());
		}
	}

	public BsjArrayType makeArrayType(ArrayTypeNode node)
	{
		return new ArrayTypeImpl(this.manager, this.makeType(node.getType()));
	}

	public BsjNamedReferenceType makeDeclaredType(DeclaredTypeNode node)
	{
		if (node instanceof ParameterizedTypeNode)
		{
			return makeParameterizedType((ParameterizedTypeNode) node);
		} else if (node instanceof UnparameterizedTypeNode)
		{
			return makeUnparameterizedType((UnparameterizedTypeNode) node);
		} else if (node instanceof ParameterizedTypeSelectNode)
		{
			return makeParameterizedTypeSelect((ParameterizedTypeSelectNode) node);
		} else
		{
			throw new IllegalStateException("Can't create a type for node of type " + node.getClass());
		}
	}

	public BsjExplicitlyDeclaredType makeParameterizedType(ParameterizedTypeNode node)
	{
		BsjTypeLikeElement baseElement = this.manager.getToolkit().getAccessibleTypeFromName(
				node.getBaseType().getName(), getTypeNamespaceMap(node));
		if (baseElement instanceof BsjTypeElement)
		{
			NamedTypeDeclarationNode<?> typeDeclaration = ((BsjTypeElement) baseElement).getDeclarationNode();
			return makeDeclarationTypeFromDeclaration(typeDeclaration, node.getTypeArguments(), null);
		} else if (baseElement instanceof BsjTypeParameterElement)
		{
			// Can't parameterize a parameterized type (as in T<U>).
			// TODO: handle this error (with an exception, not a diagnostic)
			throw new NotImplementedYetException();
		} else
		{
			// Which type is this?
			throw new IllegalStateException("Didn't expect type " + baseElement.getClass());
		}
	}

	public BsjExplicitlyDeclaredType makeParameterizedTypeSelect(ParameterizedTypeSelectNode node)
	{
		BsjExplicitlyDeclaredType accumulatedType = null;
		DeclaredTypeNode iterativeNode = node;

		// Each iteration of this loop will handle the left-hand branch and then descend recursively into the right
		// branch
		while (iterativeNode instanceof ParameterizedTypeSelectNode)
		{
			// Add the current iterator value onto our accumulator
			ParameterizedTypeSelectNode parameterizedSelectNode = (ParameterizedTypeSelectNode) iterativeNode;
			BsjTypeLikeElement element = this.manager.getToolkit().getAccessibleTypeFromName(
					parameterizedSelectNode.getBase().getBaseType().getName(), getTypeNamespaceMap(node));
			NamedTypeDeclarationNode<?> typeDeclaration = coerceElementToNamedTypeDeclaration(element);
			accumulatedType = makeDeclarationTypeFromDeclaration(typeDeclaration,
					parameterizedSelectNode.getBase().getTypeArguments(), accumulatedType);

			// Move iteration forward
			iterativeNode = parameterizedSelectNode.getSelect();
		}

		// At this point, we know the selectNode is not a ParameterizedSelectNode because we have exited the loop. We
		// just need to handle the last selection and we're done.
		if (iterativeNode instanceof UnparameterizedTypeNode)
		{
			UnparameterizedTypeNode nextSelect = (UnparameterizedTypeNode) iterativeNode;
			BsjTypeLikeElement element = this.manager.getToolkit().getAccessibleTypeFromName(nextSelect.getName(),
					getTypeNamespaceMap(node));
			NamedTypeDeclarationNode<?> nextTypeDeclaration = coerceElementToNamedTypeDeclaration(element);
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration,
					Collections.<TypeArgumentNode> emptySet(), accumulatedType);
		} else if (iterativeNode instanceof ParameterizedTypeNode)
		{
			ParameterizedTypeNode nextSelect = (ParameterizedTypeNode) iterativeNode;
			BsjTypeLikeElement element = this.manager.getToolkit().getAccessibleTypeFromName(
					nextSelect.getBaseType().getName(), getTypeNamespaceMap(node));
			NamedTypeDeclarationNode<?> nextTypeDeclaration = coerceElementToNamedTypeDeclaration(element);
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration, nextSelect.getTypeArguments(),
					accumulatedType);
		} else
		{
			throw new IllegalStateException("Don't know how to handle select type of " + iterativeNode.getClass());
		}

		return accumulatedType;
	}

	/**
	 * Used to coerce a type-like element into a named type declaration if at all possible. If this fails (because, for
	 * example, the type-like element is a type variable), an appropriate exception is thrown
	 * 
	 * @param element The element to coerce.
	 * @return The resulting type declaration.
	 */
	private NamedTypeDeclarationNode<?> coerceElementToNamedTypeDeclaration(BsjTypeLikeElement element)
	{
		if (element instanceof BsjTypeElement)
		{
			return ((BsjTypeElement) element).getDeclarationNode();
		} else if (element instanceof BsjTypeParameterElement)
		{
			// *Seriously?* This is something like B<Y>.A<X>.X where X is not a member type of A. They're just being
			// vicious now.
			// TODO: raise an appropriate exception
			throw new NotImplementedYetException();
		} else
		{
			// Which type is this?
			throw new IllegalStateException("Didn't expect type " + element.getClass());
		}
	}

	public BsjPrimitiveType makePrimitiveType(PrimitiveTypeNode node)
	{
		return new PrimitiveTypeImpl(this.manager, node.getPrimitiveType());
	}
	
	public BsjTypeVariable makeTypeVariable(TypeParameterNode node)
	{
		BsjTypeArgument upperBound;
		if (node.getBounds().size() == 0)
		{
			upperBound = null;
		} else if (node.getBounds().size() == 1)
		{
			upperBound = this.makeArgumentType(node.getBounds().get(0));
		} else
		{
			/*
			 * note: we are assuming that implicitly-defined types never have an enclosing type. rationale: assume the
			 * following declarations: class Foo { class Bar<T extends A & B> { } } class Baz<T extends A & B> { } both
			 * Bar and Baz should have the same type bound for their respective type parameters
			 */
			/*
			 * note: we are assuming that the type arguments for an implicitly-defined type are the union of the type
			 * arguments for all of the inherited types rationale: the type bound <T extends A<X> & B<Y>> implicitly
			 * represents the following: (1) the type bound <T extends Z>, (2) the declaration of a type Z which extends
			 * or implements A<X> and implements B<Y>, and (3) the declaration that every member which extends or
			 * implements A<X> and implements B<Y> is a subtype of Z. If this is true, then Z must provide arguments for
			 * X and Y to be a fully instantiated type... and since it doesn't get them on its own, it must obtain them
			 * from its implicit subtypes. For instance, if we have: class Sub extends A<String> implements B<Integer>
			 * then we implicitly have class Sub extends Z<String,Integer>
			 */
			List<BsjTypeArgument> typeArgs = new ArrayList<BsjTypeArgument>();
			for (DeclaredTypeNode boundType : node.getBounds())
			{
				BsjNamedReferenceType boundTypeMirror = this.makeDeclaredType(boundType);
				if (boundTypeMirror instanceof BsjExplicitlyDeclaredType)
				{
					typeArgs.addAll(((BsjExplicitlyDeclaredType) boundTypeMirror).getTypeArguments());
				} else
				{
					// Okay, now this is just ridiculous. But it's always bad.
					// If this is the first bound type, it's illegal because additional bounds are not allowed when the
					// first bound is a type parameter. If this is not the first bound type, it's illegal because
					// type parameters are not necessarily interfaces and the latter bound types must be interfaces.
					// Regardless, this is a type error.
					// TODO: report the error by raising an appropriate exception
					throw new NotImplementedYetException();
				}
			}
			upperBound = new IntersectionTypeImpl(this.manager, typeArgs);
		}
		return new ExplicitTypeVariableImpl(this.manager, node, null, upperBound);
	}

	public BsjNamedReferenceType makeUnparameterizedType(UnparameterizedTypeNode node)
	{
		BsjTypeLikeElement element = this.manager.getToolkit().getAccessibleTypeFromName(node.getName(),
				getTypeNamespaceMap(node));
		
		if (element instanceof BsjTypeElement)
		{
			NamedTypeDeclarationNode<?> typeDeclaration = ((BsjTypeElement) element).getDeclarationNode();
			return makeDeclarationTypeFromDeclaration(typeDeclaration, Collections.<TypeArgumentNode> emptySet(), null);
		} else if (element instanceof BsjTypeParameterElement)
		{
			BsjTypeParameterElement typeParameterElement = (BsjTypeParameterElement) element;
			return typeParameterElement.asType();
		} else
		{
			// what is it, then?
			throw new IllegalStateException("Don't know what to do with BsjTypeLikeElement of type "
					+ element.getClass());
		}
	}

	public BsjNoType makeVoidType(VoidTypeNode node)
	{
		return new VoidPseudoTypeImpl(this.manager);
	}

	public BsjWildcardType makeWildcardType(WildcardTypeNode node)
	{
		return new WildcardTypeImpl(this.manager, node);
	}

	private BsjExplicitlyDeclaredType makeDeclarationTypeFromDeclaration(NamedTypeDeclarationNode<?> typeDeclaration,
			Collection<? extends TypeArgumentNode> typeArgumentNodes, BsjExplicitlyDeclaredType providedEnclosingType)
	{
		BsjDeclaredTypeElement typeElement = this.manager.getToolkit().makeElement(typeDeclaration);
		BsjExplicitlyDeclaredType enclosingType;
		if (providedEnclosingType != null)
		{
			enclosingType = providedEnclosingType;
		} else if (typeElement.getNestingKind() == NestingKind.MEMBER)
		{
			enclosingType = this.manager.getToolkit().makeElement(
					typeDeclaration.getNearestAncestorOfType(NamedTypeDeclarationNode.class)).asType();
		} else
		{
			enclosingType = null;
		}

		List<BsjTypeArgument> typeArguments;
		if (typeArgumentNodes.size() > 0)
		{
			typeArguments = new ArrayList<BsjTypeArgument>();
			for (TypeArgumentNode argument : typeArgumentNodes)
			{
				typeArguments.add(this.makeArgumentType(argument));
			}
		} else
		{
			typeArguments = Collections.<BsjTypeArgument> emptyList();
		}

		return new DeclaredTypeImpl(this.manager, typeElement, typeArguments, enclosingType);
	}

}
