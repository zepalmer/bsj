package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import javax.lang.model.element.VariableElement;

import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * An interface representing a variable element in the BSJ language.
 */
public interface BsjVariableElement extends BsjElement, VariableElement
{
	/**
	 * Retrieves the declaration backing this element. As all elements in the BSJ language correspond to some
	 * declaration, this method obtains for the caller the AST node representing that declaration.
	 */
	public VariableNameBindingNode getDeclarationNode();

	/**
	 * Returns the type of variable declared by this element.
	 * <p/>
	 * Note that the {@link VariableElement} interface specifies that this method returns the type which was declared by
	 * this element (which is, strictly speaking, no type at all). In practice, however, this method is used to
	 * represent the type of the variable which was declared in both the Sun JDK and OpenJDK implementations.
	 */
	public BsjType asType();
}
