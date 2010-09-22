package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.lang.element.BsjElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

public abstract class AbstractVariableElementImpl<T extends VariableNameBindingNode> extends AbstractElementImpl<T> implements
		BsjVariableElement
{
	public AbstractVariableElementImpl(TypecheckerManager manager, T backingNode, BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitVariable(this, p);
	}

	@Override
	public abstract BsjType asType();

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}

	@Override
	public VariableNameBindingNode getDeclarationNode()
	{
		return getBackingNode();
	}
}
