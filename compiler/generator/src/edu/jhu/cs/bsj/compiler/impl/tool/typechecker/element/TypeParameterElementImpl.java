package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

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
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ExplicitTypeVariableImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.IntersectionTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.thunk.BsjTypeArgumentThunk;
import edu.jhu.cs.bsj.compiler.impl.utils.Converter;
import edu.jhu.cs.bsj.compiler.impl.utils.UnmodifiableLazyList;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeVariable;

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
	public TypeNameBindingNode getDeclarationNode()
	{
		return getBackingNode();
	}

	@Override
	public List<? extends BsjTypeArgument> getBounds()
	{
		List<BsjTypeArgument> list = new UnmodifiableLazyList<BsjTypeArgument, DeclaredTypeNode>(
				getBackingNode().getBounds(), new Converter<DeclaredTypeNode, BsjTypeArgument>()
				{
					@Override
					public BsjTypeArgument convert(final DeclaredTypeNode t)
					{
						return new BsjTypeArgumentThunk(new Function<Void, BsjTypeArgument>()
						{
							@Override
							public BsjTypeArgument execute(Void argument)
							{
								return getTypeBuilder().makeArgumentType(t);
							}
						});
					}
				});
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
	public BsjTypeVariable asType()
	{
		List<? extends BsjTypeArgument> bounds = getBounds();
		BsjTypeArgument upperBound;
		if (bounds.size() == 0)
		{
			upperBound = null;
		} else if (bounds.size() == 1)
		{
			upperBound = bounds.get(0);
		} else
		{
			upperBound = new IntersectionTypeImpl(getManager(), bounds);
		}

		return new ExplicitTypeVariableImpl(getManager(), getBackingNode(), null, upperBound);
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

	@Override
	public BsjTypeArgument createUpperBoundType()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
