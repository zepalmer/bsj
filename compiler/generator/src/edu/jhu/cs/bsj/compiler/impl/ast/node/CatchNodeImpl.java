package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CatchNodeImpl extends NodeImpl implements CatchNode
{
    /** The block to execute when this catch occurs. */
    private BlockNode block;
    
    /** This catch block's exception variable. */
    private VariableNode parameter;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the block property. */
        BLOCK,
        /** Attribute for the parameter property. */
        PARAMETER,
    }
    
    /** General constructor. */
    public CatchNodeImpl(
            BlockNode block,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        setBlock(block);
        setParameter(parameter);
    }
    
    /**
     * Gets the block to execute when this catch occurs.
     * @return The block to execute when this catch occurs.
     */
    public BlockNode getBlock()
    {
        recordAccess(LocalAttribute.BLOCK, Attribute.AccessType.READ);
        return this.block;
    }
    
    /**
     * Changes the block to execute when this catch occurs.
     * @param block The block to execute when this catch occurs.
     */
    public void setBlock(BlockNode block)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.BLOCK, Attribute.AccessType.STRONG_WRITE);
        if (this.block instanceof NodeImpl)
        {
            ((NodeImpl)this.block).setParent(null);
        }
        this.block = block;
        if (this.block instanceof NodeImpl)
        {
            ((NodeImpl)this.block).setParent(this);
        }
    }
    
    /**
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     */
    public VariableNode getParameter()
    {
        recordAccess(LocalAttribute.PARAMETER, Attribute.AccessType.READ);
        return this.parameter;
    }
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter)
    {
        getManager().assertMutatable(this);
        recordAccess(LocalAttribute.PARAMETER, Attribute.AccessType.STRONG_WRITE);
        if (this.parameter instanceof NodeImpl)
        {
            ((NodeImpl)this.parameter).setParent(null);
        }
        this.parameter = parameter;
        if (this.parameter instanceof NodeImpl)
        {
            ((NodeImpl)this.parameter).setParent(this);
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        if (this.block != null)
        {
            this.block.receive(visitor);
        }
        if (this.parameter != null)
        {
            this.parameter.receive(visitor);
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.block != null)
        {
            this.block.receiveTyped(visitor);
        }
        if (this.parameter != null)
        {
            this.parameter.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitCatchNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitCatchNodeStop(this, true);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getBlock());
        list.add(getParameter());
        return list;
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("block=");
        sb.append(this.getBlock() == null? "null" : this.getBlock().getClass().getSimpleName());
        sb.append(',');
        sb.append("parameter=");
        sb.append(this.getParameter() == null? "null" : this.getParameter().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeCatchNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CatchNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeCatchNode(
                getBlock().deepCopy(factory),
                getParameter().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getBlock()) && (after instanceof BlockNode))
        {
            setBlock((BlockNode)after);
            return true;
        }
        if (before.equals(this.getParameter()) && (after instanceof VariableNode))
        {
            setParameter((VariableNode)after);
            return true;
        }
        return false;
    }
    
}
