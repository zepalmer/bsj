package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjDeclaredTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class AbstractlyUnmodifiedClassTypeElementImpl<T extends AbstractlyUnmodifiedClassDeclarationNode<?>>
		extends DeclaredTypeElementImpl<T>
{
	public AbstractlyUnmodifiedClassTypeElementImpl(TypecheckerManager manager, T backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.CLASS;
	}

	@Override
	public TypeMirror getSuperclass()
	{
		if (getBackingNode().getExtendsClause() != null)
		{
			return getTypeBuilder().makeArgumentType(getBackingNode().getExtendsClause());
		} else
		{
			BsjDeclaredTypeElement objectElement = getManager().getToolkit().getObjectElement();
			if (this.equals(objectElement))
			{
				return NoTypeImpl.makeNone(getManager());
			} else
			{
				return objectElement.asType();
			}
		}
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (DeclaredTypeNode declaredTypeNode : getBackingNode().getImplementsClause())
		{
			list.add(getTypeBuilder().makeArgumentType(declaredTypeNode));
		}
		return list;
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		List<TypeParameterElement> list = new ArrayList<TypeParameterElement>();
		for (TypeParameterNode typeParameterNode : getBackingNode().getTypeParameters())
		{
			list.add((TypeParameterElement) makeElement(typeParameterNode));
		}
		return list;
	}

	@Override
	protected List<? extends BsjType> getPrototypicalTypeArgumentList()
	{
		return makeTypeMirrorsFromTypeParameters(getBackingNode().getTypeParameters());
	}
}