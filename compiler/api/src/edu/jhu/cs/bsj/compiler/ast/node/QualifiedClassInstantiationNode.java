package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;

/**
 * A node representing the qualified instantiation of a class, as in:
 * <pre>
 * <i>expr</i>.new <i>type</i>(<i>arg...</i>)
 * </pre>
 * For example, consider the following code:
 * <pre>
 * public class Example
 * {
 *     class A
 *     {
 *         class B
 *         {
 *         }
 *     }
 *     &nbsp;
 *     public void foo()
 *     {
 *         A a = new A();
 *         A.B b = a.new B(); // qualified instantiation
 *     }
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface QualifiedClassInstantiationNode extends ClassInstantiationNode
{
    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     */
    public ExpressionNode getEnclosingExpression();
    
    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression);
    
    /**
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     */
    public TypeArgumentListNode getTypeArguments();
    
    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedClassInstantiationNode deepCopy(BsjNodeFactory factory);
}
