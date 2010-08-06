package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
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
import edu.jhu.cs.bsj.compiler.ast.node.AssertStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssertStatementNodeImpl extends NodeImpl implements AssertStatementNode
{
    /** The assertion's test expression. */
    private ExpressionNode testExpression;
    
    /** The assertion's message expression. */
    private ExpressionNode messageExpression;
    
    /** The meta-annotations associated with this node. */
    private MetaAnnotationListNode metaAnnotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(AssertStatementNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the testExpression property. */
        TEST_EXPRESSION,
        /** Attribute identifier for the messageExpression property. */
        MESSAGE_EXPRESSION,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
    /** General constructor. */
    public AssertStatementNodeImpl(
            ExpressionNode testExpression,
            ExpressionNode messageExpression,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setTestExpression(testExpression, false);
        setMessageExpression(messageExpression, false);
        setMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     */
    public ExpressionNode getTestExpression()
    {
        getAttribute(LocalAttribute.TEST_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.testExpression;
    }
    
    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression)
    {
            setTestExpression(testExpression, true);
    }
    
    private void setTestExpression(ExpressionNode testExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TEST_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(testExpression, false);
        this.testExpression = testExpression;
        setAsChild(testExpression, true);
    }
    
    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     */
    public ExpressionNode getMessageExpression()
    {
        getAttribute(LocalAttribute.MESSAGE_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.messageExpression;
    }
    
    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression)
    {
            setMessageExpression(messageExpression, true);
    }
    
    private void setMessageExpression(ExpressionNode messageExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MESSAGE_EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(messageExpression, false);
        this.messageExpression = messageExpression;
        setAsChild(messageExpression, true);
    }
    
    /**
     * Gets the meta-annotations associated with this node.
     * @return The meta-annotations associated with this node.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(metaAnnotations, false);
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations, true);
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
        if (this.testExpression != null)
        {
            this.testExpression.receive(visitor);
        }
        if (this.messageExpression != null)
        {
            this.messageExpression.receive(visitor);
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
        if (this.testExpression != null)
        {
            this.testExpression.receiveTyped(visitor);
        }
        if (this.messageExpression != null)
        {
            this.messageExpression.receiveTyped(visitor);
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
        visitor.visitAssertStatementNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAssertStatementNodeStop(this, true);
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
        list.add(getTestExpression());
        list.add(getMessageExpression());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getTestExpression(), getMessageExpression(), getMetaAnnotations()});
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
        sb.append("testExpression=");
        sb.append(this.getTestExpression() == null? "null" : this.getTestExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("messageExpression=");
        sb.append(this.getMessageExpression() == null? "null" : this.getMessageExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaAnnotations=");
        sb.append(this.getMetaAnnotations() == null? "null" : this.getMetaAnnotations().getClass().getSimpleName());
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
        return operation.executeAssertStatementNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssertStatementNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeAssertStatementNode(
                getTestExpression()==null?null:getTestExpression().deepCopy(factory),
                getMessageExpression()==null?null:getMessageExpression().deepCopy(factory),
                getMetaAnnotations()==null?null:getMetaAnnotations().deepCopy(factory),
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
        
        if (before.equals(this.getTestExpression()) && (after instanceof ExpressionNode))
        {
            setTestExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getMessageExpression()) && (after instanceof ExpressionNode))
        {
            setMessageExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getMetaAnnotations()) && (after instanceof MetaAnnotationListNode))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
