package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeVariableImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

public class TypeParameterElementImpl extends AbstractElementImpl<TypeParameterNode> implements BsjTypeParameterElement
{
	public TypeParameterElementImpl(TypecheckerManager manager, TypeParameterNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public TypeParameterNode getBackingNode()
	{
		return (TypeParameterNode) super.getBackingNode();
	}

	@Override
	public List<? extends BsjType> getBounds()
	{
		List<BsjType> list = new ArrayList<BsjType>();
		for (DeclaredTypeNode typeNode : getBackingNode().getBounds())
		{
			list.add(getTypeBuilder().makeArgumentType(typeNode));
		}
		return list;
	}

	@Override
	public Element getGenericElement()
	{
		// Because of the structure of the BSJ AST API, the generic element is always a parent of this one in the tree
		return super.getEnclosingElement();
	}

	@Override
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitTypeParameter(this, p);
	}

	@Override
	public BsjType asType()
	{
		List<? extends BsjType> bounds = getBounds();
		if (bounds.size() == 0)
		{
			return new TypeVariableImpl(getManager(), null, null);
		} else if (bounds.size() == 1)
		{
			return new TypeVariableImpl(getManager(), null, bounds.get(0));
		} else
		{
			// TODO: does an intersection type have an enclosing type?
			/*
			BsjIntersectionType bound = new ImplicitlyDeclaredTypeImpl(getManager(), this, bounds);
			return new TypeVariableImpl(getManager(), null, bound);
			*/
			throw new NotImplementedYetException();
		}
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return Collections.emptyList();
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.TYPE_PARAMETER;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return Collections.emptySet();
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getIdentifier().getIdentifier());
	}
}
