package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api;

import java.util.List;

import javax.lang.model.element.TypeElement;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjTypeArgument;

/**
 * An interface representing a type element in the BSJ language.
 * @author Zachary Palmer
 */
public interface BsjTypeElement extends BsjTypeLikeElement, TypeElement
{
	/**
	 * Retrieves the declaration backing this element.  As all elements in the BSJ language correspond to some
	 * declaration, this method obtains for the caller the AST node representing that declaration.
	 */
	public NamedTypeDeclarationNode<?> getDeclarationNode();
	
	public BsjTypeArgument asType();
	
	public List<? extends BsjTypeParameterElement> getTypeParameters();
}
