package edu.jhu.cs.bsj.compiler.impl.ast.splicenode;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberSpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.meta.SpliceNodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InterfaceMemberSpliceNodeImpl extends SpliceNodeImpl implements InterfaceMemberSpliceNode
{
    /** General constructor. */
    public InterfaceMemberSpliceNodeImpl(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(spliceExpression, startLocation, stopLocation, manager, binary);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceMemberSpliceNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeInterfaceMemberSpliceNode(
                getSpliceExpression()==null?null:getSpliceExpression().deepCopy(factory),
                getStartLocation(),
                getStopLocation());
    }
    
}
