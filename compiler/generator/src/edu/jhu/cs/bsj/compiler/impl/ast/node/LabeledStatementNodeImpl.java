package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LabeledStatementNodeImpl extends NodeImpl implements LabeledStatementNode
{
    /** The statement's label. */
    private NodeUnion<? extends IdentifierNode> label;
    
    /** The statement being labeled. */
    private NodeUnion<? extends StatementNode> statement;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(LabeledStatementNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the label property. */
        LABEL,
        /** Attribute identifier for the statement property. */
        STATEMENT,
        /** Attribute identifier for the metaAnnotations property. */
        META_ANNOTATIONS,
    }
    
    /** General constructor. */
    public LabeledStatementNodeImpl(
            NodeUnion<? extends IdentifierNode> label,
            NodeUnion<? extends StatementNode> statement,
            NodeUnion<? extends MetaAnnotationListNode> metaAnnotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForLabel(label, false);
        setUnionForStatement(statement, false);
        setUnionForMetaAnnotations(metaAnnotations, false);
    }
    
    /**
     * Gets the statement's label.  This property's value is assumed to be a normal node.
     * @return The statement's label.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getLabel()
    {
        getAttribute(LocalAttribute.LABEL).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.label == null)
        {
            return null;
        } else
        {
            return this.label.getNormalNode();
        }
    }
    
    /**
     * Gets the statement's label.
     * @return The statement's label.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForLabel()
    {
        getAttribute(LocalAttribute.LABEL).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.label == null)
        {
            this.label = new NormalNodeUnion<IdentifierNode>(null);
        }
        return this.label;
    }
    
    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setLabel(IdentifierNode label)
    {
            setLabel(label, true);
            getManager().notifyChange(this);
    }
    
    private void setLabel(IdentifierNode label, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.LABEL).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.label != null)
        {
            setAsChild(this.label.getNodeValue(), false);
        }
        this.label = new NormalNodeUnion<IdentifierNode>(label);
        setAsChild(label, true);
    }
    
    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setUnionForLabel(NodeUnion<? extends IdentifierNode> label)
    {
            setUnionForLabel(label, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForLabel(NodeUnion<? extends IdentifierNode> label, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.LABEL).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (label == null)
        {
            label = new NormalNodeUnion<IdentifierNode>(null);
        }
        if (this.label != null)
        {
            setAsChild(this.label.getNodeValue(), false);
        }
        this.label = label;
        setAsChild(label.getNodeValue(), true);
    }
    
    /**
     * Gets the statement being labeled.  This property's value is assumed to be a normal node.
     * @return The statement being labeled.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public StatementNode getStatement()
    {
        getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.statement == null)
        {
            return null;
        } else
        {
            return this.statement.getNormalNode();
        }
    }
    
    /**
     * Gets the statement being labeled.
     * @return The statement being labeled.
     */
    public NodeUnion<? extends StatementNode> getUnionForStatement()
    {
        getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.statement == null)
        {
            this.statement = new NormalNodeUnion<StatementNode>(null);
        }
        return this.statement;
    }
    
    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setStatement(StatementNode statement)
    {
            setStatement(statement, true);
            getManager().notifyChange(this);
    }
    
    private void setStatement(StatementNode statement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.statement != null)
        {
            setAsChild(this.statement.getNodeValue(), false);
        }
        this.statement = new NormalNodeUnion<StatementNode>(statement);
        setAsChild(statement, true);
    }
    
    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement)
    {
            setUnionForStatement(statement, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForStatement(NodeUnion<? extends StatementNode> statement, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.STATEMENT).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (statement == null)
        {
            statement = new NormalNodeUnion<StatementNode>(null);
        }
        if (this.statement != null)
        {
            setAsChild(this.statement.getNodeValue(), false);
        }
        this.statement = statement;
        setAsChild(statement.getNodeValue(), true);
    }
    
    /**
     * Gets the meta-annotations associated with this node.  This property's value is assumed to be a normal node.
     * @return The meta-annotations associated with this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.metaAnnotations == null)
        {
            return null;
        } else
        {
            return this.metaAnnotations.getNormalNode();
        }
    }
    
    /**
     * Gets the meta-annotations associated with this node.
     * @return The meta-annotations associated with this node.
     */
    public NodeUnion<? extends MetaAnnotationListNode> getUnionForMetaAnnotations()
    {
        getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.metaAnnotations == null)
        {
            this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations);
        setAsChild(metaAnnotations, true);
    }
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
            setUnionForMetaAnnotations(metaAnnotations, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.META_ANNOTATIONS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (metaAnnotations == null)
        {
            metaAnnotations = new NormalNodeUnion<MetaAnnotationListNode>(null);
        }
        if (this.metaAnnotations != null)
        {
            setAsChild(this.metaAnnotations.getNodeValue(), false);
        }
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations.getNodeValue(), true);
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
        if (this.label.getNodeValue() != null)
        {
            this.label.getNodeValue().receive(visitor);
        }
        if (this.statement.getNodeValue() != null)
        {
            this.statement.getNodeValue().receive(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receive(visitor);
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
        if (this.label.getNodeValue() != null)
        {
            this.label.getNodeValue().receiveTyped(visitor);
        }
        if (this.statement.getNodeValue() != null)
        {
            this.statement.getNodeValue().receiveTyped(visitor);
        }
        if (this.metaAnnotations.getNodeValue() != null)
        {
            this.metaAnnotations.getNodeValue().receiveTyped(visitor);
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
        visitor.visitLabeledStatementNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitLabeledStatementNodeStop(this, true);
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
        list.add(getUnionForLabel());
        list.add(getUnionForStatement());
        list.add(getUnionForMetaAnnotations());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForLabel().getNodeValue(), getUnionForStatement().getNodeValue(), getUnionForMetaAnnotations().getNodeValue()});
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
        sb.append("label=");
        sb.append(this.getUnionForLabel().getNodeValue() == null? "null" : this.getUnionForLabel().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("statement=");
        sb.append(this.getUnionForStatement().getNodeValue() == null? "null" : this.getUnionForStatement().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaAnnotations=");
        sb.append(this.getUnionForMetaAnnotations().getNodeValue() == null? "null" : this.getUnionForMetaAnnotations().getNodeValue().getClass().getSimpleName());
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
        return operation.executeLabeledStatementNode(this, p);
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
        return operation.executeLabeledStatementNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LabeledStatementNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends IdentifierNode> labelCopy;
        switch (getUnionForLabel().getType())
        {
            case NORMAL:
                if (getUnionForLabel().getNormalNode() == null)
                {
                    labelCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    labelCopy = factory.makeNormalNodeUnion(getUnionForLabel().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForLabel().getSpliceNode() == null)
                {
                    labelCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    labelCopy = factory.makeSpliceNodeUnion(getUnionForLabel().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForLabel().getType());
        }
        NodeUnion<? extends StatementNode> statementCopy;
        switch (getUnionForStatement().getType())
        {
            case NORMAL:
                if (getUnionForStatement().getNormalNode() == null)
                {
                    statementCopy = factory.<StatementNode>makeNormalNodeUnion(null);
                } else
                {
                    statementCopy = factory.makeNormalNodeUnion(getUnionForStatement().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForStatement().getSpliceNode() == null)
                {
                    statementCopy = factory.<StatementNode>makeSpliceNodeUnion(null);
                } else
                {
                    statementCopy = factory.makeSpliceNodeUnion(getUnionForStatement().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForStatement().getType());
        }
        NodeUnion<? extends MetaAnnotationListNode> metaAnnotationsCopy;
        switch (getUnionForMetaAnnotations().getType())
        {
            case NORMAL:
                if (getUnionForMetaAnnotations().getNormalNode() == null)
                {
                    metaAnnotationsCopy = factory.<MetaAnnotationListNode>makeNormalNodeUnion(null);
                } else
                {
                    metaAnnotationsCopy = factory.makeNormalNodeUnion(getUnionForMetaAnnotations().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMetaAnnotations().getSpliceNode() == null)
                {
                    metaAnnotationsCopy = factory.<MetaAnnotationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    metaAnnotationsCopy = factory.makeSpliceNodeUnion(getUnionForMetaAnnotations().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMetaAnnotations().getType());
        }
        return factory.makeLabeledStatementNodeWithUnions(
                labelCopy,
                statementCopy,
                metaAnnotationsCopy,
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
        
        if (before.equals(this.getUnionForLabel().getNodeValue()))
        {
            setLabel((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForStatement().getNodeValue()))
        {
            setStatement((StatementNode)after);
            return true;
        }
        if (before.equals(this.getUnionForMetaAnnotations().getNodeValue()))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
