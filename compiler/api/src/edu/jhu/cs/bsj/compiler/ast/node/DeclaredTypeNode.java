package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.ParameterizableType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node expressing a declared type.  Declared types encompass classes, interfaces, enums, and annotations.
 * Anonymous classes and other such constructs are included as well.
 */
public interface DeclaredTypeNode extends TypeNode, TypeArgument,  BoundType,  ParameterizableType
{
    /**
     * Gets the identifier naming this type.
     * @return The identifier naming this type.
     */
    public IdentifierNode getName();

    /**
     * Changes the identifier naming this type.
     * @param name The identifier naming this type.
     */
    public void setName(IdentifierNode name);

}
