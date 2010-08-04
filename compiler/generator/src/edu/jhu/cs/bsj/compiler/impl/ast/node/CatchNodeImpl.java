package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CatchNodeImpl extends NodeImpl implements CatchNode
{
    /** The block statements to try. */
    private BlockStatementListNode body;
    
    /** This catch block's exception variable. */
    private VariableNode parameter;
    
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
            BlockStatementListNode body,
            VariableNode parameter,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBody(body, false);
        setParameter(parameter, false);
    }
    
    /**
     * Gets the block statements to try.
     * @return The block statements to try.
     */
    public BlockStatementListNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     */
    public void setBody(BlockStatementListNode body)
    {
            setBody(body, true);
    }
    
    private void setBody(BlockStatementListNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(body, false);
        this.body = body;
        setAsChild(body, true);
    }
    
    /**
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     */
    public VariableNode getParameter()
    {
        getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.parameter;
    }
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter)
    {
            setParameter(parameter, true);
    }
    
    private void setParameter(VariableNode parameter, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PARAMETER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(parameter, false);
        this.parameter = parameter;
        setAsChild(parameter, true);
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
        if (this.body != null)
        {
            this.body.receive(visitor);
        }
        if (this.parameter != null)
        {
            this.parameter.receive(visitor);
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
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
        }
        if (this.parameter != null)
        {
            this.parameter.receiveTyped(visitor);
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
        list.add(getBody());
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
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
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
                getBody()==null?null:getBody().deepCopy(factory),
                getParameter()==null?null:getParameter().deepCopy(factory),
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
        
        if (before.equals(this.getBody()) && (after instanceof BlockStatementListNode))
        {
            setBody((BlockStatementListNode)after);
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
