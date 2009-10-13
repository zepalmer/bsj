package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.ParameterizableType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node representing a type selection, as in:
 * <pre>
 * <i>type</i> . <i>type</i>
 * </pre>
 */
public interface TypeSelectNode extends TypeNode, TypeArgument,  BoundType,  ParameterizableType
{
    /**
     * Gets the base type from which to select.
     * @return The base type from which to select.
     */
    public BoundType getBase();

    /**
     * Changes the base type from which to select.
     * @param base The base type from which to select.
     */
    public void setBase(BoundType base);

    /**
     * Gets the selected type from the base type.
     * @return The selected type from the base type.
     */
    public DeclaredTypeNode getSelect();

    /**
     * Changes the selected type from the base type.
     * @param select The selected type from the base type.
     */
    public void setSelect(DeclaredTypeNode select);

}
