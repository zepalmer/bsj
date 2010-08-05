package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element;

import java.util.Collections;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

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

	/**
	 * Returns the type of variable declared by this element.
	 * <p/>
	 * Note that the interface specifies that this method returns the type which was declared by this element (which is,
	 * strictly speaking, no type at all).  In practice, however, this method is used to represent the type of the
	 * variable which was declared in both the Sun JDK and OpenJDK implementations.
	 */
	@Override
	public abstract TypeMirror asType();

	@Override
	public List<? extends Element> getEnclosedElements()
	{
		return Collections.emptyList();
	}
}
