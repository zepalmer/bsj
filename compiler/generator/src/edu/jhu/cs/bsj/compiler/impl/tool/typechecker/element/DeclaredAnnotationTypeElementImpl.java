package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeParameterElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NonePseudoTypeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;

public class DeclaredAnnotationTypeElementImpl extends DeclaredTypeElementImpl<AnnotationDeclarationNode>
{
	public DeclaredAnnotationTypeElementImpl(TypecheckerManager manager, AnnotationDeclarationNode backingNode,
			BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		EnumSet<Modifier> set = super.getAccessModifierSet();
		AnnotationModifiersNode modifiers = getBackingNode().getModifiers();
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
		return ElementKind.ANNOTATION_TYPE;
	}

	@Override
	public TypeMirror getSuperclass()
	{
		return new NonePseudoTypeImpl(getManager());
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		return Collections.singletonList(getManager().getToolkit().getAnnotationElement().asType());
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
