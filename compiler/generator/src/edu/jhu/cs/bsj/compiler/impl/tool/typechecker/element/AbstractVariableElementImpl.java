package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.VariableElement;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;

public abstract class AbstractVariableElementImpl<T extends Node> extends AbstractElementImpl<T> implements
		VariableElement
{
	public AbstractVariableElementImpl(TypecheckerModelManager manager, T backingNode, Element enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitVariable(this, p);
	}
}
