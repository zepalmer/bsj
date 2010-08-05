package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.AnnotationDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationModifiersNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.NoTypeImpl;

public class DeclaredAnnotationTypeElementImpl extends DeclaredTypeElementImpl<AnnotationDeclarationNode>
{
	public DeclaredAnnotationTypeElementImpl(TypecheckerModelManager manager, AnnotationDeclarationNode backingNode,
			Element enclosingElement)
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
		return NoTypeImpl.makeNone(getManager());
	}

	@Override
	public List<? extends TypeMirror> getInterfaces()
	{
		return Collections.singletonList(getElementByName("java", "lang", "annotation", "Annotation").asType());
	}

	@Override
	public List<? extends TypeParameterElement> getTypeParameters()
	{
		return Collections.emptyList();
	}
}
