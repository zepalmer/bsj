package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjNamedReferenceType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeVariable;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjWildcardType;

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
	 * @see TypecheckerToolkit#makeType(TypeNode)
	 */
	protected BsjType makeType(TypeNode node)
	{
		return getManager().getToolkit().makeType(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeType(TypeParameterNode)
	 */
	protected BsjTypeVariable makeType(TypeParameterNode node)
	{
		return getManager().getToolkit().makeType(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeType(WildcardTypeNode)
	 */
	protected BsjWildcardType makeType(WildcardTypeNode node)
	{
		return getManager().getToolkit().makeType(node);
	}
	
	/**
	 * Delegation method to toolkit.
	 * @see TypecheckerToolkit#makeType(DeclaredTypeNode)
	 */
	protected BsjNamedReferenceType makeType(DeclaredTypeNode node)
	{
		return getManager().getToolkit().makeType(node);
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
