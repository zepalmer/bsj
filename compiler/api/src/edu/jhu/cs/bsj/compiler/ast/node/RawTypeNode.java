package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.ParameterizableType;

/**
 * Represents a raw type.  Examples of raw types in Java include most of the API: String, InputStream, and so on.
 * Parameterized types, such as Set<String>, are not represented in this way.  Raw types also represent type
 * parameters.
 */
public interface RawTypeNode extends DeclaredTypeNode, ParameterizableType
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