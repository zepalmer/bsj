package edu.jhu.cs.bsj.compiler.impl.ast.node;

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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConstructorBodyNodeSetConstructorInvocationPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConstructorBodyNodeSetStatementsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ConstructorBodyNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConstructorBodyNodeImpl extends NodeImpl implements ConstructorBodyNode
{
    /** The (nullable) constructor invocation. */
    private NodeUnion<? extends ConstructorInvocationNode> constructorInvocation;
    
    /** The statements contained in this constructor. */
    private NodeUnion<? extends BlockStatementListNode> statements;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ConstructorBodyNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ConstructorBodyNodeImpl(
            NodeUnion<? extends ConstructorInvocationNode> constructorInvocation,
            NodeUnion<? extends BlockStatementListNode> statements,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetConstructorInvocation(constructorInvocation);
        doSetStatements(statements);
    }
    
    /** Proxy constructor. */
    public ConstructorBodyNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ConstructorBodyNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ConstructorBodyNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ConstructorBodyNode getBackingNode()
    {
        return (ConstructorBodyNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the constructorInvocation value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConstructorInvocationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConstructorBodyNodeProperties.CONSTRUCTOR_INVOCATION))
            return;
        this.populatedProperties.add(ConstructorBodyNodeProperties.CONSTRUCTOR_INVOCATION);
        NodeUnion<? extends ConstructorInvocationNode> union = this.getBackingNode().getUnionForConstructorInvocation();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeConstructorInvocationNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.constructorInvocation = union;
    }
    
    /**
     * Ensures that the statements value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStatementsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConstructorBodyNodeProperties.STATEMENTS))
            return;
        this.populatedProperties.add(ConstructorBodyNodeProperties.STATEMENTS);
        NodeUnion<? extends BlockStatementListNode> union = this.getBackingNode().getUnionForStatements();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeBlockStatementListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.statements = union;
    }
    
    /**
     * Gets the (nullable) constructor invocation.  This property's value is assumed to be a normal node.
     * @return The (nullable) constructor invocation.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ConstructorInvocationNode getConstructorInvocation()
    {
        checkConstructorInvocationWrapped();
        if (this.constructorInvocation == null)
        {
            return null;
        } else
        {
            return this.constructorInvocation.getNormalNode();
        }
    }
    
    /**
     * Gets the (nullable) constructor invocation.
     * @return The (nullable) constructor invocation.
     */
    public NodeUnion<? extends ConstructorInvocationNode> getUnionForConstructorInvocation()
    {
        checkConstructorInvocationWrapped();
        if (this.constructorInvocation == null)
        {
            this.constructorInvocation = new NormalNodeUnion<ConstructorInvocationNode>(null);
        }
        return this.constructorInvocation;
    }
    
    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setConstructorInvocation(ConstructorInvocationNode constructorInvocation)
    {
        checkConstructorInvocationWrapped();
        this.setUnionForConstructorInvocation(new NormalNodeUnion<ConstructorInvocationNode>(constructorInvocation));
    }
    
    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setUnionForConstructorInvocation(NodeUnion<? extends ConstructorInvocationNode> constructorInvocation)
    {
        checkConstructorInvocationWrapped();
        this.getManager().assertMutatable(this);
        this.doSetConstructorInvocation(constructorInvocation);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ConstructorBodyNodeSetConstructorInvocationPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), constructorInvocation.getNodeValue() == null ? null : constructorInvocation.getNodeValue().getUid()));
    }
    
    private void doSetConstructorInvocation(NodeUnion<? extends ConstructorInvocationNode> constructorInvocation)
    {
        if (constructorInvocation == null)
        {
            constructorInvocation = new NormalNodeUnion<ConstructorInvocationNode>(null);
        }
        if (this.constructorInvocation != null)
        {
            setAsChild(this.constructorInvocation.getNodeValue(), false);
        }
        this.constructorInvocation = constructorInvocation;
        setAsChild(constructorInvocation.getNodeValue(), true);
    }
    
    /**
     * Gets the statements contained in this constructor.  This property's value is assumed to be a normal node.
     * @return The statements contained in this constructor.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getStatements()
    {
        checkStatementsWrapped();
        if (this.statements == null)
        {
            return null;
        } else
        {
            return this.statements.getNormalNode();
        }
    }
    
    /**
     * Gets the statements contained in this constructor.
     * @return The statements contained in this constructor.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForStatements()
    {
        checkStatementsWrapped();
        if (this.statements == null)
        {
            this.statements = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.statements;
    }
    
    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setStatements(BlockStatementListNode statements)
    {
        checkStatementsWrapped();
        this.setUnionForStatements(new NormalNodeUnion<BlockStatementListNode>(statements));
    }
    
    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements)
    {
        checkStatementsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStatements(statements);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ConstructorBodyNodeSetStatementsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), statements.getNodeValue() == null ? null : statements.getNodeValue().getUid()));
    }
    
    private void doSetStatements(NodeUnion<? extends BlockStatementListNode> statements)
    {
        if (statements == null)
        {
            statements = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.statements != null)
        {
            setAsChild(this.statements.getNodeValue(), false);
        }
        this.statements = statements;
        setAsChild(statements.getNodeValue(), true);
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
        if (this.getUnionForConstructorInvocation().getNodeValue() != null)
        {
            this.getUnionForConstructorInvocation().getNodeValue().receive(visitor);
        }
        if (this.getUnionForStatements().getNodeValue() != null)
        {
            this.getUnionForStatements().getNodeValue().receive(visitor);
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
        if (this.getUnionForConstructorInvocation().getNodeValue() != null)
        {
            this.getUnionForConstructorInvocation().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForStatements().getNodeValue() != null)
        {
            this.getUnionForStatements().getNodeValue().receiveTyped(visitor);
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
        visitor.visitConstructorBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitConstructorBodyNodeStop(this, true);
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
        list.add(getUnionForConstructorInvocation());
        list.add(getUnionForStatements());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForConstructorInvocation().getNodeValue(), getUnionForStatements().getNodeValue()});
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
        sb.append("constructorInvocation=");
        sb.append(this.getUnionForConstructorInvocation().getNodeValue() == null? "null" : this.getUnionForConstructorInvocation().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("statements=");
        sb.append(this.getUnionForStatements().getNodeValue() == null? "null" : this.getUnionForStatements().getNodeValue().getClass().getSimpleName());
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
        return operation.executeConstructorBodyNode(this, p);
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
        return operation.executeConstructorBodyNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstructorBodyNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ConstructorInvocationNode> constructorInvocationCopy;
        switch (getUnionForConstructorInvocation().getType())
        {
            case NORMAL:
                if (getUnionForConstructorInvocation().getNormalNode() == null)
                {
                    constructorInvocationCopy = factory.<ConstructorInvocationNode>makeNormalNodeUnion(null);
                } else
                {
                    constructorInvocationCopy = factory.makeNormalNodeUnion(getUnionForConstructorInvocation().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForConstructorInvocation().getSpliceNode() == null)
                {
                    constructorInvocationCopy = factory.<ConstructorInvocationNode>makeSpliceNodeUnion(null);
                } else
                {
                    constructorInvocationCopy = factory.makeSpliceNodeUnion(getUnionForConstructorInvocation().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForConstructorInvocation().getType());
        }
        NodeUnion<? extends BlockStatementListNode> statementsCopy;
        switch (getUnionForStatements().getType())
        {
            case NORMAL:
                if (getUnionForStatements().getNormalNode() == null)
                {
                    statementsCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    statementsCopy = factory.makeNormalNodeUnion(getUnionForStatements().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForStatements().getSpliceNode() == null)
                {
                    statementsCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    statementsCopy = factory.makeSpliceNodeUnion(getUnionForStatements().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForStatements().getType());
        }
        return factory.makeConstructorBodyNodeWithUnions(
                constructorInvocationCopy,
                statementsCopy,
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
        
        if (before.equals(this.getUnionForConstructorInvocation().getNodeValue()))
        {
            setConstructorInvocation((ConstructorInvocationNode)after);
            return true;
        }
        if (before.equals(this.getUnionForStatements().getNodeValue()))
        {
            setStatements((BlockStatementListNode)after);
            return true;
        }
        return false;
    }
    
}
