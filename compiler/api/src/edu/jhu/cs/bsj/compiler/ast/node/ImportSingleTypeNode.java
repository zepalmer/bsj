package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a single type import statement, such as "<tt>import java.util.Set</tt>".
 */
public interface ImportSingleTypeNode extends ImportNode
{
    /**
     * Gets the name of the type to import.
     * @return The name of the type to import.
     */
    public NameNode getName();

    /**
     * Changes the name of the type to import.
     * @param name The name of the type to import.
     */
    public void setName(NameNode name);

    /**
     * Gets the static-ness of the import.
     * @return The static-ness of the import.
     */
    public boolean getStaticImport();

    /**
     * Changes the static-ness of the import.
     * @param staticImport The static-ness of the import.
     */
    public void setStaticImport(boolean staticImport);

}
