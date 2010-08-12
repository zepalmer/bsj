package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerModelManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

public abstract class AbstractVariableElementImpl<T extends Node> extends AbstractElementImpl<T> implements
		BsjVariableElement
{
	public AbstractVariableElementImpl(TypecheckerModelManager manager, T backingNode, BsjElement enclosingElement)
	{
		super(manager, backingNode, enclosingElement);
	}

	@Override
	public <R, P> R accept(ElementVisitor<R, P> v, P p)
	{
		return v.visitVariable(this, p);
	}

	/**
	 * Returns the type of variable declared by this element.
	 * <p/>
	 * Note that the interface specifies that this method returns the type which was declared by this element (which is,
	 * strictly speaking, no type at all).  In practice, however, this method is used to represent the type of the
	 * variable which was declared in both the Sun JDK and OpenJDK implementations.
	 */
	@Override
	public abstract BsjType asType();

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}
}
