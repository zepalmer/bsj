package edu.jhu.cs.bsj.compiler.lang.type;

import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;

/**
 * Represents a named type as a pseudo-type.  This type is similar to the {@link BsjPackagePseudoType} in that it
 * represents a static access of a named entity without instantiation.  For instance, the method invocation
 * <tt>java.util.Arrays.asList()</tt> contains the qualifying expression <tt>java.util.Arrays</tt> and the identifier
 * <tt>asList</tt>; the qualifying expression's type is a <tt>BsjTypePseudoType</tt> indicating the <tt>Arrays</tt>
 * type declaration.
 * @author Zachary Palmer
 */
public interface BsjTypePseudoType extends BsjNoType
{
	/**
	 * Retrieves the declaration of the type which was named to create this pseudo-type.
	 * @return The declaration in question.
	 */
	public NamedTypeDeclarationNode<?> getDeclaration();
	
    /**
     * @see BsjType#evaluate()
     */
    public BsjTypePseudoType evaluate();
}
