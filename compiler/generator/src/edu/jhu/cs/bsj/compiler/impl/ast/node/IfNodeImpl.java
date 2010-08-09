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
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IfNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class IfNodeImpl extends NodeImpl implements IfNode
{
    /** The condition. */
    private ExpressionNode condition;
    
    /** The then branch's statement. */
    private StatementNode thenStatement;
    
    /** The else branch's statement. */
    private StatementNode elseStatement;
    
    /** The meta-annotations associated with this node. */
    private MetaAnnotationListNode metaAnnotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(IfNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the condition property. */
        CONDITION,
        /** Attribute identifier for the thenStatement property. */
        THEN_STATEMENT,
        /** Attribute identifier for the elseStatement property. */
        ELSE_STATEMENT,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
    /** General constructor. */
    public IfNodeImpl(
            ExpressionNode condition,
            StatementNode thenStatement,
            StatementNode elseStatement,
            MetaAnnotationListNode metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setCondition(condition, false);
        setThenStatement(thenStatement, false);
        setElseStatement(elseStatement, false);
        setMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the condition.
     * @return The condition.
     */
    public ExpressionNode getCondition()
    {
        getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.condition;
    }
    
    /**
     * Changes the condition.
     * @param condition The condition.
     */
    public void setCondition(ExpressionNode condition)
    {
            setCondition(condition, true);
    }
    
    private void setCondition(ExpressionNode condition, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONDITION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(condition, false);
        this.condition = condition;
        setAsChild(condition, true);
    }
    
    /**
     * Gets the then branch's statement.
     * @return The then branch's statement.
     */
    public StatementNode getThenStatement()
    {
        getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.thenStatement;
    }
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setThenStatement(StatementNode thenStatement)
    {
            setThenStatement(thenStatement, true);
    }
    
    private void setThenStatement(StatementNode thenStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.THEN_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(thenStatement, false);
        this.thenStatement = thenStatement;
        setAsChild(thenStatement, true);
    }
    
    /**
     * Gets the else branch's statement.
     * @return The else branch's statement.
     */
    public StatementNode getElseStatement()
    {
        getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.elseStatement;
    }
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setElseStatement(StatementNode elseStatement)
    {
            setElseStatement(elseStatement, true);
    }
    
    private void setElseStatement(StatementNode elseStatement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ELSE_STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(elseStatement, false);
        this.elseStatement = elseStatement;
        setAsChild(elseStatement, true);
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
        if (this.condition != null)
        {
            this.condition.receive(visitor);
        }
        if (this.thenStatement != null)
        {
            this.thenStatement.receive(visitor);
        }
        if (this.elseStatement != null)
        {
            this.elseStatement.receive(visitor);
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
        if (this.condition != null)
        {
            this.condition.receiveTyped(visitor);
        }
        if (this.thenStatement != null)
        {
            this.thenStatement.receiveTyped(visitor);
        }
        if (this.elseStatement != null)
        {
            this.elseStatement.receiveTyped(visitor);
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
        visitor.visitIfNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitIfNodeStop(this, true);
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
        list.add(getCondition());
        list.add(getThenStatement());
        list.add(getElseStatement());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getCondition(), getThenStatement(), getElseStatement(), getMetaAnnotations()});
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
        sb.append("condition=");
        sb.append(this.getCondition() == null? "null" : this.getCondition().getClass().getSimpleName());
        sb.append(',');
        sb.append("thenStatement=");
        sb.append(this.getThenStatement() == null? "null" : this.getThenStatement().getClass().getSimpleName());
        sb.append(',');
        sb.append("elseStatement=");
        sb.append(this.getElseStatement() == null? "null" : this.getElseStatement().getClass().getSimpleName());
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
        return operation.executeIfNode(this, p);
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
        return operation.executeIfNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public IfNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeIfNode(
                getCondition()==null?null:getCondition().deepCopy(factory),
                getThenStatement()==null?null:getThenStatement().deepCopy(factory),
                getElseStatement()==null?null:getElseStatement().deepCopy(factory),
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
        
        if (before.equals(this.getCondition()) && (after instanceof ExpressionNode))
        {
            setCondition((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getThenStatement()) && (after instanceof StatementNode))
        {
            setThenStatement((StatementNode)after);
            return true;
        }
        if (before.equals(this.getElseStatement()) && (after instanceof StatementNode))
        {
            setElseStatement((StatementNode)after);
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
