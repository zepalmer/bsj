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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramImportNodeImpl extends NodeImpl implements MetaprogramImportNode
{
    /** The import for the metaprogram. */
    private NodeUnion<? extends ImportNode> importNode;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaprogramImportNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the importNode property. */
        IMPORT_NODE,
    }
    
    /** General constructor. */
    public MetaprogramImportNodeImpl(
            NodeUnion<? extends ImportNode> importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForImportNode(importNode, false);
    }
    
    /**
     * Gets the import for the metaprogram.  This property's value is assumed to be a normal node.
     * @return The import for the metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ImportNode getImportNode()
    {
        getAttribute(LocalAttribute.IMPORT_NODE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.importNode == null)
        {
            return null;
        } else
        {
            return this.importNode.getNormalNode();
        }
    }
    
    /**
     * Gets the import for the metaprogram.
     * @return The import for the metaprogram.
     */
    public NodeUnion<? extends ImportNode> getUnionForImportNode()
    {
        getAttribute(LocalAttribute.IMPORT_NODE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.importNode == null)
        {
            this.importNode = new NormalNodeUnion<ImportNode>(null);
        }
        return this.importNode;
    }
    
    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     */
    public void setImportNode(ImportNode importNode)
    {
            setImportNode(importNode, true);
            getManager().notifyChange(this);
    }
    
    private void setImportNode(ImportNode importNode, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IMPORT_NODE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.importNode != null)
        {
            setAsChild(this.importNode.getNodeValue(), false);
        }
        this.importNode = new NormalNodeUnion<ImportNode>(importNode);
        setAsChild(importNode, true);
    }
    
    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     */
    public void setUnionForImportNode(NodeUnion<? extends ImportNode> importNode)
    {
            setUnionForImportNode(importNode, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForImportNode(NodeUnion<? extends ImportNode> importNode, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IMPORT_NODE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (importNode == null)
        {
            importNode = new NormalNodeUnion<ImportNode>(null);
        }
        if (this.importNode != null)
        {
            setAsChild(this.importNode.getNodeValue(), false);
        }
        this.importNode = importNode;
        setAsChild(importNode.getNodeValue(), true);
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
        if (this.importNode.getNodeValue() != null)
        {
            this.importNode.getNodeValue().receive(visitor);
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
        if (this.importNode.getNodeValue() != null)
        {
            this.importNode.getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramImportNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramImportNodeStop(this, true);
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
        list.add(getUnionForImportNode());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForImportNode().getNodeValue()});
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
        sb.append("importNode=");
        sb.append(this.getUnionForImportNode().getNodeValue() == null? "null" : this.getUnionForImportNode().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMetaprogramImportNode(this, p);
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
        return operation.executeMetaprogramImportNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramImportNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ImportNode> importNodeCopy;
        switch (getUnionForImportNode().getType())
        {
            case NORMAL:
                if (getUnionForImportNode().getNormalNode() == null)
                {
                    importNodeCopy = factory.<ImportNode>makeNormalNodeUnion(null);
                } else
                {
                    importNodeCopy = factory.makeNormalNodeUnion(getUnionForImportNode().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForImportNode().getSpliceNode() == null)
                {
                    importNodeCopy = factory.<ImportNode>makeSpliceNodeUnion(null);
                } else
                {
                    importNodeCopy = factory.makeSpliceNodeUnion(getUnionForImportNode().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForImportNode().getType());
        }
        return factory.makeMetaprogramImportNodeWithUnions(
                importNodeCopy,
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
        
        if (before.equals(this.getUnionForImportNode().getNodeValue()))
        {
            setImportNode((ImportNode)after);
            return true;
        }
        return false;
    }
    
}
