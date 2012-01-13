package edu.jhu.cs.bsj.compiler.impl.ast.node.list;

import java.util.ArrayList;
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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnparameterizedTypeListNodeImpl extends ListNodeImpl<UnparameterizedTypeNode> implements UnparameterizedTypeListNode
{
    /** General constructor. */
    public UnparameterizedTypeListNodeImpl(
            List<NodeUnion<? extends UnparameterizedTypeNode>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(children, startLocation, stopLocation, manager, binary);
    }
    
    /** Proxy constructor. */
    public UnparameterizedTypeListNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, UnparameterizedTypeListNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected UnparameterizedTypeListNode getBackingNode()
    {
        return (UnparameterizedTypeListNode)super.getBackingNode();
    }
    
    /**
     * Gets whether or not this list's contents are always order-dependent.
     * @return Whether or not this list's contents are always order-dependent.
     */
    public boolean getAlwaysOrdered()
    {
        return false;
    }
    
    protected Class<UnparameterizedTypeNode> getChildrenElementType()
    {
        return UnparameterizedTypeNode.class;
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
        visitor.visitUnparameterizedTypeListNodeStart(this, true);
        visitor.visitListNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitListNodeStop(this);
        visitor.visitUnparameterizedTypeListNodeStop(this, true);
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
        return list;
    }
    
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        List<Node> ret = new ArrayList<Node>();
        ret.addAll(getChildren());
        return ret;
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
        sb.append("children=");
        sb.append(this.getUnionForChildren() == null? "null" : this.getUnionForChildren().getClass().getSimpleName());
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
        return operation.executeUnparameterizedTypeListNode(this, p);
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
        return operation.executeUnparameterizedTypeListNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public UnparameterizedTypeListNode deepCopy(BsjNodeFactory factory)
    {
        List<NodeUnion<? extends UnparameterizedTypeNode>> childrenCopy = new ArrayList<NodeUnion<? extends UnparameterizedTypeNode>>(getChildren().size());
        for (NodeUnion<? extends UnparameterizedTypeNode> element : getUnionForChildren())
        {
            NodeUnion<? extends UnparameterizedTypeNode> elementCopy;
            if (element.getType().equals(NodeUnion.Type.NORMAL))
                elementCopy = factory.makeNormalNodeUnion(element.getNormalNode().deepCopy(factory));
            else if (element.getType().equals(NodeUnion.Type.SPLICE))
                elementCopy = factory.makeSpliceNodeUnion(element.getSpliceNode().deepCopy(factory));
            else throw new IllegalStateException("Unrecognized union type: " + element.getType());
            childrenCopy.add(elementCopy);
        }
        
        return factory.makeUnparameterizedTypeListNodeWithUnions(
                childrenCopy,
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
        
        if (after instanceof UnparameterizedTypeNode)
        {
            int index = getChildren().indexOf(before);
            if (index != -1)
                getChildren().set(index, (UnparameterizedTypeNode)after);
        }
        return false;
    }
    
    /**
     * Retrieves a class object representing the element type of this node.
     * @return The element type of this list node.
     */
    public Class<UnparameterizedTypeNode> getElementType()
    {
        return UnparameterizedTypeNode.class;
    }
    
    /**
     * Wraps an element of this list's type.
     */
    protected UnparameterizedTypeNode wrapElement(UnparameterizedTypeNode element)
    {
        return getProxyFactory().makeUnparameterizedTypeNode(element);
    }
    
}
