package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a compilation unit import statement.
 */
public interface ImportNode extends Node
{
    /**
     * Gets the identifier to import.
     * @return The identifier to import.
     */
    public NameNode getQualifiedIdentifier();

    /**
     * Changes the identifier to import.
     * @param qualifiedIdentifier The identifier to import.
     */
    public void setQualifiedIdentifier(NameNode qualifiedIdentifier);

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
