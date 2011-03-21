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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LabeledStatementNodeSetLabelPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LabeledStatementNodeSetMetaAnnotationsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LabeledStatementNodeSetStatementPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.LabeledStatementNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LabeledStatementNodeImpl extends NodeImpl implements LabeledStatementNode
{
    /** The statement's label. */
    private NodeUnion<? extends IdentifierNode> label;
    
    /** The statement being labeled. */
    private NodeUnion<? extends StatementNode> statement;
    
    /** The meta-annotations associated with this node. */
    private NodeUnion<? extends MetaAnnotationListNode> metaAnnotations;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<LabeledStatementNodeProperties> populatedProperties;
    
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
        this.populatedProperties = null;
        doSetLabel(label);
        doSetStatement(statement);
        doSetMetaAnnotations(metaAnnotations);
    }
    
    /** Proxy constructor. */
    public LabeledStatementNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, LabeledStatementNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(LabeledStatementNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected LabeledStatementNode getBackingNode()
    {
        return (LabeledStatementNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the label value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkLabelWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LabeledStatementNodeProperties.LABEL))
            return;
        this.populatedProperties.add(LabeledStatementNodeProperties.LABEL);
        NodeUnion<? extends IdentifierNode> union = this.getBackingNode().getUnionForLabel();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeIdentifierNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.label = union;
    }
    
    /**
     * Ensures that the statement value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStatementWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LabeledStatementNodeProperties.STATEMENT))
            return;
        this.populatedProperties.add(LabeledStatementNodeProperties.STATEMENT);
        NodeUnion<? extends StatementNode> union = this.getBackingNode().getUnionForStatement();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeStatementNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.statement = union;
    }
    
    /**
     * Ensures that the metaAnnotations value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaAnnotationsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LabeledStatementNodeProperties.META_ANNOTATIONS))
            return;
        this.populatedProperties.add(LabeledStatementNodeProperties.META_ANNOTATIONS);
        NodeUnion<? extends MetaAnnotationListNode> union = this.getBackingNode().getUnionForMetaAnnotations();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaAnnotationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.metaAnnotations = union;
    }
    
    /**
     * Gets the statement's label.  This property's value is assumed to be a normal node.
     * @return The statement's label.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getLabel()
    {
        checkLabelWrapped();
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
        checkLabelWrapped();
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
        checkLabelWrapped();
        this.setUnionForLabel(new NormalNodeUnion<IdentifierNode>(label));
    }
    
    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setUnionForLabel(NodeUnion<? extends IdentifierNode> label)
    {
        checkLabelWrapped();
        this.getManager().assertMutatable(this);
        this.doSetLabel(label);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LabeledStatementNodeSetLabelPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), label.getNodeValue() == null ? null : label.getNodeValue().getUid()));
    }
    
    private void doSetLabel(NodeUnion<? extends IdentifierNode> label)
    {
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
        checkStatementWrapped();
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
        checkStatementWrapped();
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
        checkStatementWrapped();
        this.setUnionForStatement(new NormalNodeUnion<StatementNode>(statement));
    }
    
    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement)
    {
        checkStatementWrapped();
        this.getManager().assertMutatable(this);
        this.doSetStatement(statement);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LabeledStatementNodeSetStatementPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), statement.getNodeValue() == null ? null : statement.getNodeValue().getUid()));
    }
    
    private void doSetStatement(NodeUnion<? extends StatementNode> statement)
    {
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
        checkMetaAnnotationsWrapped();
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
        checkMetaAnnotationsWrapped();
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
        checkMetaAnnotationsWrapped();
        this.setUnionForMetaAnnotations(new NormalNodeUnion<MetaAnnotationListNode>(metaAnnotations));
    }
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
        checkMetaAnnotationsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMetaAnnotations(metaAnnotations);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LabeledStatementNodeSetMetaAnnotationsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaAnnotations.getNodeValue() == null ? null : metaAnnotations.getNodeValue().getUid()));
    }
    
    private void doSetMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations)
    {
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
        if (this.getUnionForLabel().getNodeValue() != null)
        {
            this.getUnionForLabel().getNodeValue().receive(visitor);
        }
        if (this.getUnionForStatement().getNodeValue() != null)
        {
            this.getUnionForStatement().getNodeValue().receive(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receive(visitor);
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
        if (this.getUnionForLabel().getNodeValue() != null)
        {
            this.getUnionForLabel().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForStatement().getNodeValue() != null)
        {
            this.getUnionForStatement().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForMetaAnnotations().getNodeValue() != null)
        {
            this.getUnionForMetaAnnotations().getNodeValue().receiveTyped(visitor);
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
        sb.append('#');
        sb.append(this.getUid());
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
