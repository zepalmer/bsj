package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;

public class DeclaredEnumTypeElementImpl extends DeclaredTypeElementImpl<EnumDeclarationNode>
{
	public DeclaredEnumTypeElementImpl(TypecheckerManager manager, EnumDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = super.getAccessModifierSet();
		EnumModifiersNode modifiers = getBackingNode().getModifiers();
		if (modifiers.getStrictfpFlag())
		{
			set.add(Modifier.STRICTFP);
		}
		if (getNestingKind() == NestingKind.MEMBER)
		{
			set.add(Modifier.STATIC);
		}
		return set;
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.ENUM;
	}

	@Override
	public TypeMirror getSuperclass()
	{
		BsjTypeElement enumElement = getManager().getToolkit().getEnumElement();
		NamedTypeDeclarationNode<?> enclosingTypeDeclaration = this.getBackingNode().getNearestAncestorOfType(
				NamedTypeDeclarationNode.class);
		BsjTypeElement enclosingTypeElement = makeElement(enclosingTypeDeclaration);
		BsjExplicitlyDeclaredType enclosingTypeMirror = (BsjExplicitlyDeclaredType) enclosingTypeElement.asType();
		BsjTypeArgument selfType = getManager().getTypeFactory().makeExplicitlyDeclaredType(this,
				Collections.<BsjTypeArgument> emptyList(), enclosingTypeMirror);
		BsjType enumType = getManager().getTypeFactory().makeExplicitlyDeclaredType(enumElement,
				Collections.singletonList(selfType), null);
		return enumType;
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
	public List<? extends BsjTypeParameterElement> getTypeParameters()
	{
		return Collections.emptyList();
	}

	@Override
	protected List<? extends BsjTypeArgument> getPrototypicalTypeArgumentList()
	{
		return Collections.emptyList();
	}
}
