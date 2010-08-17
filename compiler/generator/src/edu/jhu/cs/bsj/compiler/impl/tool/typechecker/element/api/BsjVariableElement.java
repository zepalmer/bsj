package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import javax.lang.model.element.VariableElement;

import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;

/**
 * An interface representing a variable element in the BSJ language.
 */
public interface BsjVariableElement extends BsjElement, VariableElement
{
	/**
	 * Retrieves the declaration backing this element.  As all elements in the BSJ language correspond to some
	 * declaration, this method obtains for the caller the AST node representing that declaration.
	 */
	public VariableNameBindingNode getDeclarationNode();
}
