package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypeBuilder;

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
	 * @see TypecheckerToolkit#makeElement(Node)
	 */
	protected BsjElement makeElement(Node node)
	{
		return getManager().getToolkit().makeElement(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeElement(NamedTypeDeclarationNode)
	 */
	protected BsjTypeElement makeElement(NamedTypeDeclarationNode<?> node)
	{
		return getManager().getToolkit().makeElement(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#getTypeBuilder()
	 */
	protected TypeBuilder getTypeBuilder()
	{
		return getManager().getToolkit().getTypeBuilder();
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#getTypeElementByName(String...)
	 */
	public Element getElementByName(String... name)
	{
		return getManager().getToolkit().getTypeElementByName(name);
	}
}
