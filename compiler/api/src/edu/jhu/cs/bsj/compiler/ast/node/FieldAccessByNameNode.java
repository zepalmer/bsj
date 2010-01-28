package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a field access, as in
 * <pre>
 * <i>name</i>
 * </pre>
 * For example, this node would allow the access of a local variable <tt>x</tt> using the code
 * <pre>
 * x
 * </pre>
 * and allow the access of a <tt>bar</tt> field on a class <tt>Foo</tt> using the code
 * <pre>
 * Foo.bar
 * </pre>
 * This node is not used to represent field access from the evaluation result of a subexpression (such as in the
 * code <tt>foo().bar</tt>).  For that form of access, see {@link FieldAccessByExpressionNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FieldAccessByNameNode extends Node, FieldAccessNode
{
    /**
     * Gets the name of the field to access.
     * @return The name of the field to access.
     */
    public NameNode getName();

    /**
     * Changes the name of the field to access.
     * @param name The name of the field to access.
     */
    public void setName(NameNode name);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldAccessByNameNode deepCopy(BsjNodeFactory factory);
}
