package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConstructorBodyNodeImpl extends NodeImpl implements ConstructorBodyNode
{
    /** The (nullable) constructor invocation. */
    private NodeUnion<? extends ConstructorInvocationNode> constructorInvocation;
    
    /** The statements contained in this constructor. */
    private NodeUnion<? extends BlockStatementListNode> statements;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ConstructorBodyNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the constructorInvocation property. */
        CONSTRUCTOR_INVOCATION,
        /** Attribute identifier for the statements property. */
        STATEMENTS,
    }
    
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
        setUnionForConstructorInvocation(constructorInvocation, false);
        setUnionForStatements(statements, false);
    }
    
    /**
     * Gets the (nullable) constructor invocation.  This property's value is assumed to be a normal node.
     * @return The (nullable) constructor invocation.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ConstructorInvocationNode getConstructorInvocation()
    {
        getAttribute(LocalAttribute.CONSTRUCTOR_INVOCATION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.CONSTRUCTOR_INVOCATION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setConstructorInvocation(constructorInvocation, true);
            getManager().notifyChange(this);
    }
    
    private void setConstructorInvocation(ConstructorInvocationNode constructorInvocation, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTRUCTOR_INVOCATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.constructorInvocation != null)
        {
            setAsChild(this.constructorInvocation.getNodeValue(), false);
        }
        this.constructorInvocation = new NormalNodeUnion<ConstructorInvocationNode>(constructorInvocation);
        setAsChild(constructorInvocation, true);
    }
    
    /**
     * Changes the (nullable) constructor invocation.
     * @param constructorInvocation The (nullable) constructor invocation.
     */
    public void setUnionForConstructorInvocation(NodeUnion<? extends ConstructorInvocationNode> constructorInvocation)
    {
            setUnionForConstructorInvocation(constructorInvocation, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForConstructorInvocation(NodeUnion<? extends ConstructorInvocationNode> constructorInvocation, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTRUCTOR_INVOCATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (constructorInvocation == null)
        {
            throw new NullPointerException("Node union for property constructorInvocation cannot be null.");
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
        getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setStatements(statements, true);
            getManager().notifyChange(this);
    }
    
    private void setStatements(BlockStatementListNode statements, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.statements != null)
        {
            setAsChild(this.statements.getNodeValue(), false);
        }
        this.statements = new NormalNodeUnion<BlockStatementListNode>(statements);
        setAsChild(statements, true);
    }
    
    /**
     * Changes the statements contained in this constructor.
     * @param statements The statements contained in this constructor.
     */
    public void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements)
    {
            setUnionForStatements(statements, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (statements == null)
        {
            throw new NullPointerException("Node union for property statements cannot be null.");
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
        if (this.constructorInvocation.getNodeValue() != null)
        {
            this.constructorInvocation.getNodeValue().receive(visitor);
        }
        if (this.statements.getNodeValue() != null)
        {
            this.statements.getNodeValue().receive(visitor);
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
        if (this.constructorInvocation.getNodeValue() != null)
        {
            this.constructorInvocation.getNodeValue().receiveTyped(visitor);
        }
        if (this.statements.getNodeValue() != null)
        {
            this.statements.getNodeValue().receiveTyped(visitor);
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
        list.add(getConstructorInvocation());
        list.add(getStatements());
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
        return factory.makeConstructorBodyNode(
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
        
        if (before.equals(this.getConstructorInvocation()) && (after instanceof ConstructorInvocationNode))
        {
            setConstructorInvocation((ConstructorInvocationNode)after);
            return true;
        }
        if (before.equals(this.getStatements()) && (after instanceof BlockStatementListNode))
        {
            setStatements((BlockStatementListNode)after);
            return true;
        }
        return false;
    }
    
}
