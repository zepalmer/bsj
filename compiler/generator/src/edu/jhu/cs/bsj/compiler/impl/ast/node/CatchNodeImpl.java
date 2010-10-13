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
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CatchNodeImpl extends NodeImpl implements CatchNode
{
    /** The block statements to try. */
    private NodeUnion<? extends BlockStatementListNode> body;
    
    /** This catch block's exception variable. */
    private NodeUnion<? extends VariableNode> parameter;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(CatchNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the parameter property. */
        PARAMETER,
    }
    
    /** General constructor. */
    public CatchNodeImpl(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends VariableNode> parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForBody(body, false);
        setUnionForParameter(parameter, false);
    }
    
    /**
     * Gets the block statements to try.  This property's value is assumed to be a normal node.
     * @return The block statements to try.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.body == null)
        {
            return null;
        } else
        {
            return this.body.getNormalNode();
        }
    }
    
    /**
     * Gets the block statements to try.
     * @return The block statements to try.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     */
    public void setBody(BlockStatementListNode body)
    {
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(BlockStatementListNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = new NormalNodeUnion<BlockStatementListNode>(body);
        setAsChild(body, true);
    }
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body)
    {
            setUnionForBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (body == null)
        {
            body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
    }
    
    /**
     * Gets this catch block's exception variable.  This property's value is assumed to be a normal node.
     * @return This catch block's exception variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableNode getParameter()
    {
        getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.parameter == null)
        {
            return null;
        } else
        {
            return this.parameter.getNormalNode();
        }
    }
    
    /**
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     */
    public NodeUnion<? extends VariableNode> getUnionForParameter()
    {
        getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.parameter == null)
        {
            this.parameter = new NormalNodeUnion<VariableNode>(null);
        }
        return this.parameter;
    }
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter)
    {
            setParameter(parameter, true);
            getManager().notifyChange(this);
    }
    
    private void setParameter(VariableNode parameter, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.parameter != null)
        {
            setAsChild(this.parameter.getNodeValue(), false);
        }
        this.parameter = new NormalNodeUnion<VariableNode>(parameter);
        setAsChild(parameter, true);
    }
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setUnionForParameter(NodeUnion<? extends VariableNode> parameter)
    {
            setUnionForParameter(parameter, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForParameter(NodeUnion<? extends VariableNode> parameter, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (parameter == null)
        {
            parameter = new NormalNodeUnion<VariableNode>(null);
        }
        if (this.parameter != null)
        {
            setAsChild(this.parameter.getNodeValue(), false);
        }
        this.parameter = parameter;
        setAsChild(parameter.getNodeValue(), true);
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
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
        }
        if (this.parameter.getNodeValue() != null)
        {
            this.parameter.getNodeValue().receive(visitor);
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
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
        }
        if (this.parameter.getNodeValue() != null)
        {
            this.parameter.getNodeValue().receiveTyped(visitor);
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
        list.add(getUnionForBody());
        list.add(getUnionForParameter());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBody().getNodeValue(), getUnionForParameter().getNodeValue()});
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
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("parameter=");
        sb.append(this.getUnionForParameter().getNodeValue() == null? "null" : this.getUnionForParameter().getNodeValue().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeCatchNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CatchNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends BlockStatementListNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        NodeUnion<? extends VariableNode> parameterCopy;
        switch (getUnionForParameter().getType())
        {
            case NORMAL:
                if (getUnionForParameter().getNormalNode() == null)
                {
                    parameterCopy = factory.<VariableNode>makeNormalNodeUnion(null);
                } else
                {
                    parameterCopy = factory.makeNormalNodeUnion(getUnionForParameter().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForParameter().getSpliceNode() == null)
                {
                    parameterCopy = factory.<VariableNode>makeSpliceNodeUnion(null);
                } else
                {
                    parameterCopy = factory.makeSpliceNodeUnion(getUnionForParameter().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForParameter().getType());
        }
        return factory.makeCatchNodeWithUnions(
                bodyCopy,
                parameterCopy,
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
        
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((BlockStatementListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForParameter().getNodeValue()))
        {
            setParameter((VariableNode)after);
            return true;
        }
        return false;
    }
    
}
