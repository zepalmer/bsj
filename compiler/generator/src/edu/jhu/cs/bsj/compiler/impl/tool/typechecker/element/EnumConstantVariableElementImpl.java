package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.EnumConstantDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public class EnumConstantVariableElementImpl extends AbstractVariableElementImpl<EnumConstantDeclarationNode>
{
	public EnumConstantVariableElementImpl(TypecheckerModelManager manager, EnumConstantDeclarationNode backingNode,
			Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.ENUM_CONSTANT;
	}

	@Override
	public Object getConstantValue()
	{
		return null;
	}

	@Override
	public TypeMirror asType()
	{
		return makeElement(getBackingNode().getNearestAncestorOfType(EnumDeclarationNode.class)).asType();
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		return EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
	}

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(getBackingNode().getIdentifier().getIdentifier());
	}

}