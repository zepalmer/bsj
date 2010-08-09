package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.DeclaredTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuildingNodeOperation;

public class DeclaredEnumTypeElementImpl extends DeclaredTypeElementImpl<EnumDeclarationNode>
{
	public DeclaredEnumTypeElementImpl(TypecheckerModelManager manager, EnumDeclarationNode backingNode,
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
		TypeElement enumElement = (TypeElement) getElementByName("java", "lang", "Enum");
		NamedTypeDeclarationNode<?> enclosingTypeDeclaration = this.getBackingNode().getNearestAncestorOfType(
				NamedTypeDeclarationNode.class);
		TypeElement enclosingTypeElement = (TypeElement) makeElement(enclosingTypeDeclaration);
		TypeMirror enclosingTypeMirror = enclosingTypeElement.asType();
		TypeMirror selfType = new DeclaredTypeImpl(getManager(), this, Collections.<TypeMirror> emptyList(),
				enclosingTypeMirror);
		TypeMirror enumType = new DeclaredTypeImpl(getManager(), enumElement, Collections.singletonList(selfType), null);
		return enumType;
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		List<TypeMirror> list = new ArrayList<TypeMirror>();
		for (DeclaredTypeNode declaredTypeNode : getBackingNode().getImplementsClause())
		{
			list.add(declaredTypeNode.executeOperation(new TypeBuildingNodeOperation(getManager()), null));
		}
		return list;
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		return Collections.emptyList();
	}

}
