package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a qualified name, as in
 * <pre>
 * <i>name.ident</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface QualifiedNameNode extends NameNode
{
    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NameNode getBase();

    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base);

    /**
     * Gets the identifier used to qualify the base name.
     * @return The identifier used to qualify the base name.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier used to qualify the base name.
     * @param identifier The identifier used to qualify the base name.
     */
    public void setIdentifier(IdentifierNode identifier);

}
