package edu.jhu.cs.bsj.compiler.ast.node;


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

}