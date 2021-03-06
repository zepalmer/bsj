package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NonePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjTypeArgument;

public class DeclaredInterfaceTypeElementImpl extends DeclaredTypeElementImpl<InterfaceDeclarationNode>
{
	public DeclaredInterfaceTypeElementImpl(TypecheckerManager manager, InterfaceDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = super.getAccessModifierSet();
		InterfaceModifiersNode modifiers = getBackingNode().getModifiers();
		if (modifiers.getStaticFlag())
		{
			set.add(Modifier.STATIC);
		}
		if (modifiers.getStrictfpFlag())
		{
			set.add(Modifier.STRICTFP);
		}
		return set;
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.INTERFACE;
	}

	@Override
	public TypeMirror getSuperclass()
	{
		return new NonePseudoTypeImpl(getManager());
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (DeclaredTypeNode declaredTypeNode : getBackingNode().getExtendsClause())
		{
			list.add(getTypeBuilder().makeArgumentType(declaredTypeNode));
		}
		return list;
	}
	
	@Override
	public List<? extends BsjTypeParameterElement> getTypeParameters()
	{
		List<BsjTypeParameterElement> list = new ArrayList<BsjTypeParameterElement>();
		for (TypeParameterNode typeParameterNode : getBackingNode().getTypeParameters())
		{
			list.add((BsjTypeParameterElement) makeElement(typeParameterNode));
		}
		return list;
	}

	@Override
	public List<? extends BsjTypeArgument> getPrototypicalTypeArgumentList()
	{
		return makeTypeMirrorsFromTypeParameters(getBackingNode().getTypeParameters());
	}
}
