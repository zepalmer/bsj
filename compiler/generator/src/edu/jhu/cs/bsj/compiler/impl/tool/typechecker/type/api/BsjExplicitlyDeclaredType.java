package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import java.util.Map;

import javax.lang.model.type.DeclaredType;

import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.element.api.BsjTypeElement;

/**
 * Represents an explicitly declared type in the BSJ type checker. This interface also provides an extension to the
 * {@link DeclaredType} interface which allows the caller to determine if the declared type was implicitly defined.
 * Unlike {@link DeclaredTypeNode}s, a syntax element which cannot distinguish between truly declared types and type
 * variables, this construct represents only truly declared types: classes, interfaces, enums, and annotations.
 * 
 * @author Zachary Palmer
 */
public interface BsjExplicitlyDeclaredType extends BsjDeclaredType, BsjNamedReferenceType
{
	/**
	 * Retrieves the enclosing type for this type.
	 * 
	 * @see DeclaredType#getEnclosingType()
	 */
	public BsjExplicitlyDeclaredType getEnclosingType();

	/**
	 * Retrieves an element for this declared type.
	 * 
	 * @see DeclaredType#asElement()
	 */
	public BsjTypeElement asElement();
	
	/**
	 * Creates an erasure for this declared type which is guaranteed to be another declared type.
	 * @see BsjType#calculateErasure()
	 */
	public BsjExplicitlyDeclaredType calculateErasure();
	
	/**
	 * Determines whether or not this type is raw. Note that a type with no arguments is not raw unless the
	 * corresponding element has at least one parameter.
	 * 
	 * @return <code>true</code> if this type is raw; <code>false</code> if it is not.
	 */
	public boolean isRaw();

	/**
	 * Creates a mapping which represents how this type's arguments replace the underlying element's parameters. The
	 * resulting mapping is keyed by type parameters which appear on this type's element or on some enclosing element of
	 * this type; the corresponding values are those type arguments which were used for the parameters. The resulting
	 * map is suitable as a parameter for {@link BsjType#performTypeSubstitution(Map)}.
	 * <p/>
	 * If this type is a raw type, an {@link IllegalStateException} will be thrown. Raw types do not execute type
	 * substitution; instead, dereferencing a raw type for a non-static member always results in the erasure of the
	 * resulting type.
	 */
	public Map<BsjTypeVariable, BsjTypeArgument> calculateSubstitutionMap();
}
