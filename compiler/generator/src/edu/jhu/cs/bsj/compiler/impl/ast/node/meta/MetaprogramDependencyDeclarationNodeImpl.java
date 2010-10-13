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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramDependencyDeclarationNodeImpl extends NodeImpl implements MetaprogramDependencyDeclarationNode
{
    /** The names of the metaprogram targets on which to depend. */
    private NodeUnion<? extends MetaprogramDependencyListNode> targets;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaprogramDependencyDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the targets property. */
        TARGETS,
    }
    
    /** General constructor. */
    public MetaprogramDependencyDeclarationNodeImpl(
            NodeUnion<? extends MetaprogramDependencyListNode> targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForTargets(targets, false);
    }
    
    /**
     * Gets the names of the metaprogram targets on which to depend.  This property's value is assumed to be a normal node.
     * @return The names of the metaprogram targets on which to depend.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramDependencyListNode getTargets()
    {
        getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.targets == null)
        {
            return null;
        } else
        {
            return this.targets.getNormalNode();
        }
    }
    
    /**
     * Gets the names of the metaprogram targets on which to depend.
     * @return The names of the metaprogram targets on which to depend.
     */
    public NodeUnion<? extends MetaprogramDependencyListNode> getUnionForTargets()
    {
        getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.targets == null)
        {
            this.targets = new NormalNodeUnion<MetaprogramDependencyListNode>(null);
        }
        return this.targets;
    }
    
    /**
     * Changes the names of the metaprogram targets on which to depend.
     * @param targets The names of the metaprogram targets on which to depend.
     */
    public void setTargets(MetaprogramDependencyListNode targets)
    {
            setTargets(targets, true);
            getManager().notifyChange(this);
    }
    
    private void setTargets(MetaprogramDependencyListNode targets, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.targets != null)
        {
            setAsChild(this.targets.getNodeValue(), false);
        }
        this.targets = new NormalNodeUnion<MetaprogramDependencyListNode>(targets);
        setAsChild(targets, true);
    }
    
    /**
     * Changes the names of the metaprogram targets on which to depend.
     * @param targets The names of the metaprogram targets on which to depend.
     */
    public void setUnionForTargets(NodeUnion<? extends MetaprogramDependencyListNode> targets)
    {
            setUnionForTargets(targets, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForTargets(NodeUnion<? extends MetaprogramDependencyListNode> targets, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (targets == null)
        {
            targets = new NormalNodeUnion<MetaprogramDependencyListNode>(null);
        }
        if (this.targets != null)
        {
            setAsChild(this.targets.getNodeValue(), false);
        }
        this.targets = targets;
        setAsChild(targets.getNodeValue(), true);
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
        if (this.targets.getNodeValue() != null)
        {
            this.targets.getNodeValue().receive(visitor);
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
        if (this.targets.getNodeValue() != null)
        {
            this.targets.getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramDependencyDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramDependencyDeclarationNodeStop(this, true);
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
        list.add(getUnionForTargets());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForTargets().getNodeValue()});
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
        sb.append("targets=");
        sb.append(this.getUnionForTargets().getNodeValue() == null? "null" : this.getUnionForTargets().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMetaprogramDependencyDeclarationNode(this, p);
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
        return operation.executeMetaprogramDependencyDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends MetaprogramDependencyListNode> targetsCopy;
        switch (getUnionForTargets().getType())
        {
            case NORMAL:
                if (getUnionForTargets().getNormalNode() == null)
                {
                    targetsCopy = factory.<MetaprogramDependencyListNode>makeNormalNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeNormalNodeUnion(getUnionForTargets().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTargets().getSpliceNode() == null)
                {
                    targetsCopy = factory.<MetaprogramDependencyListNode>makeSpliceNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeSpliceNodeUnion(getUnionForTargets().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTargets().getType());
        }
        return factory.makeMetaprogramDependencyDeclarationNodeWithUnions(
                targetsCopy,
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
        
        if (before.equals(this.getUnionForTargets().getNodeValue()))
        {
            setTargets((MetaprogramDependencyListNode)after);
            return true;
        }
        return false;
    }
    
}
