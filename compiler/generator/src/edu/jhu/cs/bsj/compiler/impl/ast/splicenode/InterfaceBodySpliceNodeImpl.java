package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.SpliceNodeAccessException;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodySpliceNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.InterfaceMemberListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InterfaceBodySpliceNodeImpl extends SpliceNodeImpl implements InterfaceBodySpliceNode
{
    /** General constructor. */
    public InterfaceBodySpliceNodeImpl(
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
    public InterfaceMemberListNode getMembers()
    {
        throw new SpliceNodeAccessException("Attempted to get property \"members\" from a splice node.");
    }
    
    /**
     * Implements the underlying property settter method by raising an exception.
     * @param arg Ignored.
     * @throws SpliceNodeAccessException Always.
     */
    public void setMembers(InterfaceMemberListNode arg)
    {
        throw new SpliceNodeAccessException("Attempted to set property \"members\" from a splice node.");
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceBodySpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeInterfaceBodySpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
}
