package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an unparameterized type.  Examples of unparameterized types in Java include most of the API: String,
 * InputStream, and so on.  Parameterized types, such as Set<String>, are not represented in this way.
 * Unparameterized types also represent type parameters, such as the <tt>T</tt> in <tt>Set<T></tt>.
 */
public interface UnparameterizedTypeNode extends Node, DeclaredTypeNode,  LiteralizableTypeNode
{
    /**
     * Gets the name of the type.
     * @return The name of the type.
     */
    public NameNode getName();

    /**
     * Changes the name of the type.
     * @param name The name of the type.
     */
    public void setName(NameNode name);

}
