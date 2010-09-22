package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;

import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.ArrayTypeImpl;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

public class ActualVariableElementImpl extends AbstractVariableElementImpl<VariableNode>
{
	private boolean varArgs;
	
	public ActualVariableElementImpl(TypecheckerManager manager, VariableNode backingNode, BsjElement enclosingElement,
			boolean varArgs)
	{
		super(manager, backingNode, enclosingElement);
		this.varArgs = varArgs;
	}

	public boolean isVarArgs()
	{
		return varArgs;
	}

	@Override
	public Object getConstantValue()
	{
		return null;
	}

	@Override
	public BsjType asType()
	{
		BsjType type = getTypeBuilder().makeType(getBackingNode().getType());
		if (this.isVarArgs())
		{
			// TODO: mark the ArrayTypeImpl so that it knows it represents a varargs type?
			type = new ArrayTypeImpl(getManager(), type);
		}
		return type;
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
		return ElementKind.PARAMETER;
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

	@Override
	public Name getSimpleName()
	{
		return new NameImpl(this.getBackingNode().getIdentifier().getIdentifier());
	}
}
