package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.lang.model.element.NestingKind;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.ArrayTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.PrimitiveTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VoidTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjDefaultNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjArrayType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNoType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjPrimitiveType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;

public class TypeBuildingNodeOperation extends BsjDefaultNodeOperation<Void, BsjType>
{
	private TypecheckerModelManager manager;

	public TypeBuildingNodeOperation(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}

	@Override
	public BsjArrayType executeArrayTypeNode(ArrayTypeNode node, Void p)
	{
		return new ArrayTypeImpl(this.manager, node.getType().executeOperation(this, p));
	}

	@Override
	public BsjType executeDefault(Node node, Void p)
	{
		return null;
	}

	@Override
	public BsjDeclaredType executeParameterizedTypeNode(ParameterizedTypeNode node, Void p)
	{
		NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
				node.getBaseType().getName(),
				this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
		return makeDeclarationTypeFromDeclaration(typeDeclaration, node.getTypeArguments(), null);
	}

	@Override
	public BsjDeclaredType executeParameterizedTypeSelectNode(ParameterizedTypeSelectNode node, Void p)
	{
		BsjDeclaredType accumulatedType = null;
		DeclaredTypeNode iterativeNode = node;

		// Each iteration of this loop will handle the left-hand branch and then descend recursively into the right
		// branch
		while (iterativeNode instanceof ParameterizedTypeSelectNode)
		{
			// Add the current iterator value onto our accumulator
			ParameterizedTypeSelectNode parameterizedSelectNode = (ParameterizedTypeSelectNode) iterativeNode;
			NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					parameterizedSelectNode.getBase().getBaseType().getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
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
			NamedTypeDeclarationNode<?> nextTypeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					nextSelect.getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration,
					Collections.<TypeArgumentNode> emptySet(), accumulatedType);
		} else if (iterativeNode instanceof ParameterizedTypeNode)
		{
			ParameterizedTypeNode nextSelect = (ParameterizedTypeNode) iterativeNode;
			NamedTypeDeclarationNode<?> nextTypeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
					nextSelect.getBaseType().getName(),
					this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
			accumulatedType = makeDeclarationTypeFromDeclaration(nextTypeDeclaration, nextSelect.getTypeArguments(),
					accumulatedType);
		} else
		{
			throw new IllegalStateException("Don't know how to handle select type of " + iterativeNode.getClass());
		}

		return accumulatedType;
	}

	@Override
	public BsjPrimitiveType executePrimitiveTypeNode(PrimitiveTypeNode node, Void p)
	{
		return new PrimitiveTypeImpl(this.manager, node.getPrimitiveType());
	}

	@Override
	public BsjTypeVariable executeTypeParameterNode(TypeParameterNode node, Void p)
	{
		TypeMirror upperBound;
		if (node.getBounds().size() == 0)
		{
			upperBound = null;
		} else if (node.getBounds().size() == 1)
		{
			upperBound = node.getBounds().get(0).executeOperation(this, null);
		} else
		{
			/*
			 * note: we are assuming that implicitly-defined types never have an enclosing type rationale: assume the
			 * following declarations: class Foo { class Bar<T extends A & B> { } } class Baz<T extends A & B> { } both
			 * Bar and Baz should have the same type bound for their respective type parameters
			 */
			/*
			 * note: we are assuming that the type arguments for an implicitly-defined type are the union of the type
			 * arguments for all of the inherited types rationale: the type bound <T extends A<X> & B<Y>> implicitly
			 * represents the following: * the type bound <T extends Z> * the declaration of a type Z which extends or
			 * implements A<X> and implements B<Y> * the declaration that every member which extends or implements A<X>
			 * and implements B<Y> is a subtype of Z If this is true, then Z must provide arguments for X and Y to be a
			 * fully instantiated type... and since it doesn't get them on its own, it must obtain them from its
			 * implicit subtypes. For instance, if we have: class Sub extends A<String> implements B<Integer> then we
			 * implicitly have class Sub extends Z<String,Integer>
			 */
			List<BsjType> typeArgs = new ArrayList<BsjType>();
			for (DeclaredTypeNode boundType : node.getBounds())
			{
				BsjDeclaredType boundTypeMirror = (BsjDeclaredType) boundType.executeOperation(this, null);
				typeArgs.addAll(boundTypeMirror.getTypeArguments());
			}
			upperBound = new ImplicitlyDeclaredTypeImpl(this.manager,
					(BsjTypeParameterElement) this.manager.getToolkit().makeElement(node), typeArgs, null);
		}
		return new TypeVariableImpl(this.manager, null, upperBound);
	}

	@Override
	public BsjDeclaredType executeUnparameterizedTypeNode(UnparameterizedTypeNode node, Void p)
	{
		NamedTypeDeclarationNode<?> typeDeclaration = this.manager.getToolkit().getAccessibleTypeFromName(
				node.getName(), this.manager.getEnvironmentManager().getEnvironment(node).getTypeNamespaceMap());
		return makeDeclarationTypeFromDeclaration(typeDeclaration, Collections.<TypeArgumentNode> emptySet(), null);
	}

	@Override
	public BsjNoType executeVoidTypeNode(VoidTypeNode node, Void p)
	{
		return NoTypeImpl.makeVoid(this.manager);
	}

	@Override
	public BsjWildcardType executeWildcardTypeNode(WildcardTypeNode node, Void p)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private BsjDeclaredType makeDeclarationTypeFromDeclaration(NamedTypeDeclarationNode<?> typeDeclaration,
			Collection<? extends TypeArgumentNode> typeArgumentNodes, BsjDeclaredType providedEnclosingType)
	{
		BsjDeclaredTypeElement typeElement = this.manager.getToolkit().makeElement(typeDeclaration);
		BsjDeclaredType enclosingType;
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

		List<BsjType> typeArguments;
		if (typeArgumentNodes.size() > 0)
		{
			typeArguments = new ArrayList<BsjType>();
			for (TypeArgumentNode argument : typeArgumentNodes)
			{
				typeArguments.add(argument.executeOperation(this, null));
			}
		} else
		{
			typeArguments = Collections.<BsjType> emptyList();
		}

		return new ExplicitlyDeclaredTypeImpl(this.manager, typeElement, typeArguments, enclosingType);
	}
}
