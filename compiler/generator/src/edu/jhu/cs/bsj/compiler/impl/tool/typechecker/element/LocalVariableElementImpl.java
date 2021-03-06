package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;

public class LocalVariableElementImpl extends VariableDeclaratorOwnerElementImpl<LocalVariableDeclarationNode>
{
	public LocalVariableElementImpl(TypecheckerManager manager, LocalVariableDeclarationNode backingNode,
			BsjElement enclosingElement, int index)
	{
		super(manager, backingNode, enclosingElement, index);
	}

	@Override
	public List<? extends AnnotationMirror> getAnnotationMirrors()
	{
		return makeAnnotationMirrors(getOwner().getModifiers().getAnnotations());
	}

	@Override
	public ElementKind getKind()
	{
		return ElementKind.LOCAL_VARIABLE;
	}

	@Override
	public Set<Modifier> getModifiers()
	{
		if (this.getOwner().getModifiers().getFinalFlag())
		{
			return EnumSet.of(Modifier.FINAL);
		} else
		{
			return EnumSet.noneOf(Modifier.class);
		}
	}
}
