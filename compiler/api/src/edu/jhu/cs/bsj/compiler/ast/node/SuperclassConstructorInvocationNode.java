package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents an alternate constructor invocation, as in
 * <pre>
 * super("foo")
 * </pre>
 * or in the rarer syntax
 * <pre>
 * (new Foo()).super(0)
 * </pre>
 * .  Note that this only applies to <i>superclass</i> constructor invocations (those using the <tt>super</tt>
 * keyword).  For alternate constructor invocations, see {@link AlternateConstructorInvocationNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SuperclassConstructorInvocationNode extends ConstructorInvocationNode
{
    /**
     * Gets the qualifying expression for the enclosing object.
     * @return The qualifying expression for the enclosing object.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public PrimaryExpressionNode getQualifyingExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the qualifying expression for the enclosing object.
     * @return A union object representing The qualifying expression for the enclosing object.
     */
    public NodeUnion<? extends PrimaryExpressionNode> getUnionForQualifyingExpression();
    
    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     */
    public void setQualifyingExpression(PrimaryExpressionNode qualifyingExpression);
    
    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForQualifyingExpression(NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperclassConstructorInvocationNode deepCopy(BsjNodeFactory factory);
    
}
