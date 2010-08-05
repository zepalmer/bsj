package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

/**
 * This class is intended to represent a typechecker model component.  It contains functionality which is useful to
 * the modeling classes for both types and elements.
 * @author Zachary Palmer
 */
public class TypecheckerModelComponentImpl
{
	private TypecheckerModelManager manager;

	public TypecheckerModelComponentImpl(TypecheckerModelManager manager)
	{
		super();
		this.manager = manager;
	}
	
	protected TypecheckerModelManager getManager()
	{
		return this.manager;
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeType(TypeNode)
	 */
	protected Element makeElement(Node node)
	{
		return getManager().getToolkit().makeElement(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeType(TypeNode)
	 */
	protected TypeMirror makeType(TypeNode node)
	{
		return getManager().getToolkit().makeType(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#getElementByName(String...)
	 */
	public Element getElementByName(String... name)
	{
		return getManager().getToolkit().getElementByName(name);
	}
}
