package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a compilation unit import statement.
 */
public interface ImportNode extends Node
{
    /**
     * Gets the name of the package to import.
     * @return The name of the package to import.
     */
    public NameNode getQualifiedName();

    /**
     * Changes the name of the package to import.
     * @param qualifiedName The name of the package to import.
     */
    public void setQualifiedName(NameNode qualifiedName);

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
