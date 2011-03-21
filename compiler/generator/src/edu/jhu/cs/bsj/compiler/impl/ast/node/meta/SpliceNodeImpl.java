package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SpliceNodeSetSpliceExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.SpliceNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SpliceNodeImpl extends NodeImpl implements SpliceNode
{
    /** The expression which will replace this splice upon lifting. */
    private ExpressionNode spliceExpression;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<SpliceNodeProperties> populatedProperties;
    
    /** General constructor. */
    public SpliceNodeImpl(
            ExpressionNode spliceExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetSpliceExpression(spliceExpression);
    }
    
    /** Proxy constructor. */
    public SpliceNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, SpliceNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(SpliceNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected SpliceNode getBackingNode()
    {
        return (SpliceNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the spliceExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkSpliceExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SpliceNodeProperties.SPLICE_EXPRESSION))
            return;
        this.populatedProperties.add(SpliceNodeProperties.SPLICE_EXPRESSION);
        this.spliceExpression = this.getProxyFactory().makeExpressionNode(
                this.getBackingNode().getSpliceExpression());
    }
    
    /**
     * Gets the expression which will replace this splice upon lifting.
     * @return The expression which will replace this splice upon lifting.
     */
    public ExpressionNode getSpliceExpression()
    {
        checkSpliceExpressionWrapped();
        return this.spliceExpression;
    }
    
    /**
     * Changes the expression which will replace this splice upon lifting.
     * @param spliceExpression The expression which will replace this splice upon lifting.
     */
    public void setSpliceExpression(ExpressionNode spliceExpression)
    {
        checkSpliceExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetSpliceExpression(spliceExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SpliceNodeSetSpliceExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), spliceExpression.getUid()));
    }
    
    private void doSetSpliceExpression(ExpressionNode spliceExpression)
    {
        if (this.spliceExpression != null)
            setAsChild(this.spliceExpression, false);
        this.spliceExpression = spliceExpression;
        if (this.spliceExpression != null)
            setAsChild(this.spliceExpression, true);
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
        if (this.getSpliceExpression() != null)
        {
            this.getSpliceExpression().receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
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
        if (this.getSpliceExpression() != null)
        {
            this.getSpliceExpression().receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitSpliceNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitSpliceNodeStop(this, true);
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
        list.add(getSpliceExpression());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getSpliceExpression()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("spliceExpression=");
        sb.append(this.getSpliceExpression() == null? "null" : this.getSpliceExpression().getClass().getSimpleName());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeSpliceNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
    {
        return operation.executeSpliceNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SpliceNode deepCopy(BsjNodeFactory factory)
    {
        ExpressionNode spliceExpressionCopy = getSpliceExpression();
        if (spliceExpressionCopy != null)
            spliceExpressionCopy = spliceExpressionCopy.deepCopy(factory);
        return factory.makeSpliceNode(
                spliceExpressionCopy,
                getStartLocation(),
                getStopLocation());
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
        
        if (before.equals(this.getSpliceExpression()))
        {
            setSpliceExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
