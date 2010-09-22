package edu.jhu.cs.bsj.compiler.lang.element;

import javax.lang.model.element.Element;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;

/**
 * This interface represents a BSJ language element.  It is meant to be used with the Java language modeling API in the
 * javax.lang.model packages as per JSR-199.  It adds additional functionality useful to the BSJ compiler.
 * @author Zachary Palmer
 */
public interface BsjElement extends Element
{
	/**
	 * Retrieves a prototypical type for this element.
	 * @see Element#asType()
	 */
	public BsjType asType();
	
	/**
	 * Retrieves the enclosing element for this element.
	 * @see Element#getEnclosingElement()
	 */
	public BsjElement getEnclosingElement();
	
	/**
	 * Retrieves the declaration backing this element.  As all elements in the BSJ language correspond to some
	 * declaration, this method obtains for the caller the AST node representing that declaration.
	 */
	public Node getDeclarationNode();
}
