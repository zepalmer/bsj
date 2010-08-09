package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class LocalVariableElementImpl extends VariableDeclaratorOwnerElementImpl<LocalVariableDeclarationNode>
{
	public LocalVariableElementImpl(TypecheckerModelManager manager, LocalVariableDeclarationNode backingNode,
			BsjElement enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public TypeMirror asType()
	{
		return makeType(getBackingNode().getType());
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getBackingNode().getModifiers().getAnnotations());
	}

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.LOCAL_VARIABLE;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		if (this.getBackingNode().getModifiers().getFinalFlag())
		{
			return EnumSet.of(Modifier.FINAL);
		} else
		{
			return EnumSet.noneOf(Modifier.class);
		}
	}
}
