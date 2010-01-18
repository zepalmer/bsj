package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a simple name, as in
 * <pre>
 * <i>name</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SimpleNameNode extends NameNode
{
    /**
     * Gets the identifier used as a simple name.
     * @return The identifier used as a simple name.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier used as a simple name.
     * @param identifier The identifier used as a simple name.
     */
    public void setIdentifier(IdentifierNode identifier);

}
