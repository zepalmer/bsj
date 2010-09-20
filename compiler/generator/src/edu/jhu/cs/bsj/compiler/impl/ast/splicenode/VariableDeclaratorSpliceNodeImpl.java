package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorSpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableDeclaratorSpliceNodeImpl extends SpliceNodeImpl implements VariableDeclaratorSpliceNode
{
    /** General constructor. */
    public VariableDeclaratorSpliceNodeImpl(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(spliceExpression, startLocation, stopLocation, manager, binary);
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public int getArrayLevels()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"arrayLevels\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setArrayLevels(int arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"arrayLevels\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public VariableInitializerNode getInitializer()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"initializer\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setInitializer(VariableInitializerNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"initializer\" from a splice node.");
    }
    
    /**
     * Implements the underlying property getter method by raising an exception.
     * @returns Nothing; an exception is always raised.
     * @throws SpliceNodeAccessException Always.
     */
    public IdentifierNode getIdentifier()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"identifier\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setIdentifier(IdentifierNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"identifier\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeVariableDeclaratorSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
    /** Raises an exception. */
    public TypeNode getEffectiveType(BsjNodeFactory factory)
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
