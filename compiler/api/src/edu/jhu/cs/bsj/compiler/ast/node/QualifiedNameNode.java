package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a name qualification, as in
 * <pre>
 * <i>name<i> . <i>identifier</i>
 * </pre>
 * QualifiedNameNodes are used to identify classes in package imports and other identifier chains.  They are not
 * used to select members from expressions.  See {@link MemberSelectNode}.
 */
public interface QualifiedNameNode extends NameNode
{
    /**
     * Gets the name to qualify.
     * @return The name to qualify.
     */
    public NameNode getName();

    /**
     * Changes the name to qualify.
     * @param name The name to qualify.
     */
    public void setName(NameNode name);

    /**
     * Gets the identifier to use.
     * @return The identifier to use.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier to use.
     * @param identifier The identifier to use.
     */
    public void setIdentifier(IdentifierNode identifier);

}
