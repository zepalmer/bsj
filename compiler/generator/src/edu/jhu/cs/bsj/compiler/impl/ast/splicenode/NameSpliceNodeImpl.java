package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class NameSpliceNodeImpl extends SpliceNodeImpl implements NameSpliceNode
{
    /** General constructor. */
    public NameSpliceNodeImpl(
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
    public NameSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeNameSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
    /** Raises an exception. */
    public NameCategory getCategory(CompilationUnitLoader loader)
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
    /** Raises an exception. */
    public String getNameString()
    {
        throw new SpliceNodeAccessException("Attempting to invoke node method on a splice node.");
    }
    
}
