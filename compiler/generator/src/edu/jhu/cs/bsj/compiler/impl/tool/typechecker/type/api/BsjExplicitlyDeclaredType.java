package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;

/**
 * Represents an explicitly declared type in the BSJ type checker. This interface also provides an extension to the
 * {@link DeclaredType} interface which allows the caller to determine if the declared type was implicitly defined.
 * Unlike {@link DeclaredTypeNode}s, a syntax element which cannot distinguish between truly declared types and type
 * variables, this construct represents only truly declared types: classes, interfaces, enums, and annotations.
 * @author Zachary Palmer
 */
public interface BsjExplicitlyDeclaredType extends BsjDeclaredType, BsjNamedReferenceType
{
	/**
	 * Retrieves an element for this declared type.
	 * 
	 * @see DeclaredType#asElement()
	 */
	public BsjTypeElement asElement();
}
