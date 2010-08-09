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
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;

public class ActualVariableElementImpl extends AbstractVariableElementImpl<VariableNode>
{
	private boolean varArgs;
	
	public ActualVariableElementImpl(TypecheckerModelManager manager, VariableNode backingNode, BsjElement enclosingElement,
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
	public TypeMirror asType()
	{
		// TODO Auto-generated method stub
		return null;
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
