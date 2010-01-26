package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a constructor body.  For example, in
 * <pre>
 * public MyClass()
 * {
 *     super();
 *     this.foo = 0;
 * }
 * </pre>
 * this node would represent all but the first line.  Observe that this structure enforces the Java language rule
 * that there be exactly one explicit constructor invocation and that it appears at the top of the constructor
 * body.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstructorBodyNode extends Node
{
    /**
     * Gets the (nullable) constructor invocation.
     * @return The (nullable) constructor invocation.
     */
    public ConstructorInvocationNode getConstructorInvocation();

    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setConstructorInvocation(ConstructorInvocationNode constructorInvocation);

    /**
     * Gets the statements contained in this constructor.
     * @return The statements contained in this constructor.
     */
    public ListNode<BlockStatementNode> getStatements();

    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setStatements(ListNode<BlockStatementNode> statements);

}
