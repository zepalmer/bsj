package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuildingNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public class DeclaredInterfaceTypeElementImpl extends DeclaredTypeElementImpl<InterfaceDeclarationNode>
{
	public DeclaredInterfaceTypeElementImpl(TypecheckerModelManager manager, InterfaceDeclarationNode backingNode,
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
		return NoTypeImpl.makeNone(getManager());
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (DeclaredTypeNode declaredTypeNode : getBackingNode().getExtendsClause())
		{
			list.add(declaredTypeNode.executeOperation(new TypeBuildingNodeOperation(getManager()),null));
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
