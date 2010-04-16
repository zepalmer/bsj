package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class TryNodeImpl extends NodeImpl implements TryNode
{
    /** The block in which to try. */
    private BlockNode block;
    
    /** The catch conditions. */
    private CatchListNode catches;
    
    /** The finally block. */
    private BlockNode finallyBlock;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the block property. */
        BLOCK,
        /** Attribute for the catches property. */
        CATCHES,
        /** Attribute for the finallyBlock property. */
        FINALLY_BLOCK,
    }
    
    /** General constructor. */
    public TryNodeImpl(
            BlockNode block,
            CatchListNode catches,
            BlockNode finallyBlock,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBlock(block, false);
        setCatches(catches, false);
        setFinallyBlock(finallyBlock, false);
    }
    
    /**
     * Gets the block in which to try.
     * @return The block in which to try.
     */
    public BlockNode getBlock()
    {
        recordAccess(LocalAttribute.BLOCK, Attribute.AccessType.READ);
        return this.block;
    }
    
    /**
     * Changes the block in which to try.
     * @param block The block in which to try.
     */
    public void setBlock(BlockNode block)
    {
            setBlock(block, true);
    }
    
    private void setBlock(BlockNode block, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.BLOCK, Attribute.AccessType.WRITE);
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
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public CatchListNode getCatches()
    {
        recordAccess(LocalAttribute.CATCHES, Attribute.AccessType.READ);
        return this.catches;
    }
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(CatchListNode catches)
    {
            setCatches(catches, true);
    }
    
    private void setCatches(CatchListNode catches, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.CATCHES, Attribute.AccessType.WRITE);
        if (this.catches instanceof NodeImpl)
        {
            ((NodeImpl)this.catches).setParent(null);
        }
        this.catches = catches;
        if (this.catches instanceof NodeImpl)
        {
            ((NodeImpl)this.catches).setParent(this);
        }
    }
    
    /**
     * Gets the finally block.
     * @return The finally block.
     */
    public BlockNode getFinallyBlock()
    {
        recordAccess(LocalAttribute.FINALLY_BLOCK, Attribute.AccessType.READ);
        return this.finallyBlock;
    }
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockNode finallyBlock)
    {
            setFinallyBlock(finallyBlock, true);
    }
    
    private void setFinallyBlock(BlockNode finallyBlock, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.FINALLY_BLOCK, Attribute.AccessType.WRITE);
        if (this.finallyBlock instanceof NodeImpl)
        {
            ((NodeImpl)this.finallyBlock).setParent(null);
        }
        this.finallyBlock = finallyBlock;
        if (this.finallyBlock instanceof NodeImpl)
        {
            ((NodeImpl)this.finallyBlock).setParent(this);
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
        if (this.catches != null)
        {
            this.catches.receive(visitor);
        }
        if (this.finallyBlock != null)
        {
            this.finallyBlock.receive(visitor);
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
        if (this.catches != null)
        {
            this.catches.receiveTyped(visitor);
        }
        if (this.finallyBlock != null)
        {
            this.finallyBlock.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitTryNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitTryNodeStop(this, true);
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
        list.add(getCatches());
        list.add(getFinallyBlock());
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
        sb.append("catches=");
        sb.append(this.getCatches() == null? "null" : this.getCatches().getClass().getSimpleName());
        sb.append(',');
        sb.append("finallyBlock=");
        sb.append(this.getFinallyBlock() == null? "null" : this.getFinallyBlock().getClass().getSimpleName());
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
        return operation.executeTryNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TryNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeTryNode(
                getBlock()==null?null:getBlock().deepCopy(factory),
                getCatches()==null?null:getCatches().deepCopy(factory),
                getFinallyBlock()==null?null:getFinallyBlock().deepCopy(factory),
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
        if (before.equals(this.getCatches()) && (after instanceof CatchListNode))
        {
            setCatches((CatchListNode)after);
            return true;
        }
        if (before.equals(this.getFinallyBlock()) && (after instanceof BlockNode))
        {
            setFinallyBlock((BlockNode)after);
            return true;
        }
        return false;
    }
    
}
