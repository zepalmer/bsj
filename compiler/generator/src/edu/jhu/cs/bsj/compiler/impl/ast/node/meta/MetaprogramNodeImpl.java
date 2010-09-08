package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramNodeImpl extends NodeImpl implements MetaprogramNode
{
    /** The preamble for this metaprogram. */
    private MetaprogramPreambleNode preamble;
    
    /** The list of statements in the metaprogram's body. */
    private BlockStatementListNode body;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaprogramNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the preamble property. */
        PREAMBLE,
        /** Attribute identifier for the body property. */
        BODY,
    }
    
    /** General constructor. */
    public MetaprogramNodeImpl(
            MetaprogramPreambleNode preamble,
            BlockStatementListNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setPreamble(preamble, false);
        setBody(body, false);
    }
    
    /**
     * Gets the preamble for this metaprogram.
     * @return The preamble for this metaprogram.
     */
    public MetaprogramPreambleNode getPreamble()
    {
        getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.preamble;
    }
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     */
    public void setPreamble(MetaprogramPreambleNode preamble)
    {
            setPreamble(preamble, true);
            getManager().notifyChange(this);
    }
    
    private void setPreamble(MetaprogramPreambleNode preamble, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PREAMBLE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(this.preamble, false);
        this.preamble = preamble;
        setAsChild(preamble, true);
    }
    
    /**
     * Gets the list of statements in the metaprogram's body.
     * @return The list of statements in the metaprogram's body.
     */
    public BlockStatementListNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.body;
    }
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
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
        setAsChild(this.body, false);
        this.body = body;
        setAsChild(body, true);
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
        if (this.preamble != null)
        {
            this.preamble.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
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
        if (this.preamble != null)
        {
            this.preamble.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
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
        visitor.visitMetaprogramNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramNodeStop(this, true);
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
        list.add(getPreamble());
        list.add(getBody());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getPreamble(), getBody()});
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
        sb.append("preamble=");
        sb.append(this.getPreamble() == null? "null" : this.getPreamble().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
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
        return operation.executeMetaprogramNode(this, p);
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
        return operation.executeMetaprogramNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaprogramNode(
                getPreamble()==null?null:getPreamble().deepCopy(factory),
                getBody()==null?null:getBody().deepCopy(factory),
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
        
        if (before.equals(this.getPreamble()) && (after instanceof MetaprogramPreambleNode))
        {
            setPreamble((MetaprogramPreambleNode)after);
            return true;
        }
        if (before.equals(this.getBody()) && (after instanceof BlockStatementListNode))
        {
            setBody((BlockStatementListNode)after);
            return true;
        }
        return false;
    }
    
}
