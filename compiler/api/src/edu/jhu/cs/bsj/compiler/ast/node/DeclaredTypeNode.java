package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node expressing a declared type.  Declared types encompass classes, interfaces, enums, and annotations.
 * Anonymous classes and other such constructs are included as well.
 */
public interface DeclaredTypeNode extends TypeNode, TypeArgument,  BoundType
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
