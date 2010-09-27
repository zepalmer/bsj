package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ConstructorInvocationNode getConstructorInvocation() throws ClassCastException;
    
    /**
     * Gets the union object for the (nullable) constructor invocation.
     * @return A union object representing The (nullable) constructor invocation.
     */
    public NodeUnion<? extends ConstructorInvocationNode> getUnionForConstructorInvocation();
    
    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setConstructorInvocation(ConstructorInvocationNode constructorInvocation);
    
    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForConstructorInvocation(NodeUnion<? extends ConstructorInvocationNode> constructorInvocation) throws NullPointerException;
    
    /**
     * Gets the statements contained in this constructor.
     * @return The statements contained in this constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getStatements() throws ClassCastException;
    
    /**
     * Gets the union object for the statements contained in this constructor.
     * @return A union object representing The statements contained in this constructor.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForStatements();
    
    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setStatements(BlockStatementListNode statements);
    
    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstructorBodyNode deepCopy(BsjNodeFactory factory);
    
}
