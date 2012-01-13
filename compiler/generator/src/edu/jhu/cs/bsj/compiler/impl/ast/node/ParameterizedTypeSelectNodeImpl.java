package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ParameterizedTypeSelectNodeSetBasePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ParameterizedTypeSelectNodeSetSelectPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ParameterizedTypeSelectNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeSelectNodeImpl extends NodeImpl implements ParameterizedTypeSelectNode
{
    /** The parameterized type from which a type is selected. */
    private NodeUnion<? extends ParameterizedTypeNode> base;
    
    /** The type which is selected from the base. */
    private NodeUnion<? extends DeclaredTypeNode> select;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ParameterizedTypeSelectNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ParameterizedTypeSelectNodeImpl(
            NodeUnion<? extends ParameterizedTypeNode> base,
            NodeUnion<? extends DeclaredTypeNode> select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetBase(base);
        doSetSelect(select);
    }
    
    /** Proxy constructor. */
    public ParameterizedTypeSelectNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ParameterizedTypeSelectNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ParameterizedTypeSelectNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ParameterizedTypeSelectNode getBackingNode()
    {
        return (ParameterizedTypeSelectNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the base value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBaseWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ParameterizedTypeSelectNodeProperties.BASE))
            return;
        this.populatedProperties.add(ParameterizedTypeSelectNodeProperties.BASE);
        NodeUnion<? extends ParameterizedTypeNode> union = this.getBackingNode().getUnionForBase();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeParameterizedTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.base = union;
    }
    
    /**
     * Ensures that the select value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkSelectWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ParameterizedTypeSelectNodeProperties.SELECT))
            return;
        this.populatedProperties.add(ParameterizedTypeSelectNodeProperties.SELECT);
        NodeUnion<? extends DeclaredTypeNode> union = this.getBackingNode().getUnionForSelect();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeDeclaredTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.select = union;
    }
    
    /**
     * Gets the parameterized type from which a type is selected.  This property's value is assumed to be a normal node.
     * @return The parameterized type from which a type is selected.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ParameterizedTypeNode getBase()
    {
        checkBaseWrapped();
        if (this.base == null)
        {
            return null;
        } else
        {
            return this.base.getNormalNode();
        }
    }
    
    /**
     * Gets the parameterized type from which a type is selected.
     * @return The parameterized type from which a type is selected.
     */
    public NodeUnion<? extends ParameterizedTypeNode> getUnionForBase()
    {
        checkBaseWrapped();
        if (this.base == null)
        {
            this.base = new NormalNodeUnion<ParameterizedTypeNode>(null);
        }
        return this.base;
    }
    
    /**
     * Changes the parameterized type from which a type is selected.
     * @param base The parameterized type from which a type is selected.
     */
    public void setBase(ParameterizedTypeNode base)
    {
        checkBaseWrapped();
        this.setUnionForBase(new NormalNodeUnion<ParameterizedTypeNode>(base));
    }
    
    /**
     * Changes the parameterized type from which a type is selected.
     * @param base The parameterized type from which a type is selected.
     */
    public void setUnionForBase(NodeUnion<? extends ParameterizedTypeNode> base)
    {
        checkBaseWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBase(base);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ParameterizedTypeSelectNodeSetBasePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), base.getNodeValue() == null ? null : base.getNodeValue().getUid()));
    }
    
    private void doSetBase(NodeUnion<? extends ParameterizedTypeNode> base)
    {
        if (base == null)
        {
            base = new NormalNodeUnion<ParameterizedTypeNode>(null);
        }
        if (this.base != null)
        {
            setAsChild(this.base.getNodeValue(), false);
        }
        this.base = base;
        setAsChild(base.getNodeValue(), true);
    }
    
    /**
     * Gets the type which is selected from the base.  This property's value is assumed to be a normal node.
     * @return The type which is selected from the base.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeNode getSelect()
    {
        checkSelectWrapped();
        if (this.select == null)
        {
            return null;
        } else
        {
            return this.select.getNormalNode();
        }
    }
    
    /**
     * Gets the type which is selected from the base.
     * @return The type which is selected from the base.
     */
    public NodeUnion<? extends DeclaredTypeNode> getUnionForSelect()
    {
        checkSelectWrapped();
        if (this.select == null)
        {
            this.select = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        return this.select;
    }
    
    /**
     * Changes the type which is selected from the base.
     * @param select The type which is selected from the base.
     */
    public void setSelect(DeclaredTypeNode select)
    {
        checkSelectWrapped();
        this.setUnionForSelect(new NormalNodeUnion<DeclaredTypeNode>(select));
    }
    
    /**
     * Changes the type which is selected from the base.
     * @param select The type which is selected from the base.
     */
    public void setUnionForSelect(NodeUnion<? extends DeclaredTypeNode> select)
    {
        checkSelectWrapped();
        this.getManager().assertMutatable(this);
        this.doSetSelect(select);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ParameterizedTypeSelectNodeSetSelectPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), select.getNodeValue() == null ? null : select.getNodeValue().getUid()));
    }
    
    private void doSetSelect(NodeUnion<? extends DeclaredTypeNode> select)
    {
        if (select == null)
        {
            select = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        if (this.select != null)
        {
            setAsChild(this.select.getNodeValue(), false);
        }
        this.select = select;
        setAsChild(select.getNodeValue(), true);
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
        if (this.getUnionForBase().getNodeValue() != null)
        {
            this.getUnionForBase().getNodeValue().receive(visitor);
        }
        if (this.getUnionForSelect().getNodeValue() != null)
        {
            this.getUnionForSelect().getNodeValue().receive(visitor);
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
        if (this.getUnionForBase().getNodeValue() != null)
        {
            this.getUnionForBase().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForSelect().getNodeValue() != null)
        {
            this.getUnionForSelect().getNodeValue().receiveTyped(visitor);
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
        visitor.visitParameterizedTypeSelectNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitDeclaredTypeNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitDeclaredTypeNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitParameterizedTypeSelectNodeStop(this, true);
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
        list.add(getUnionForBase());
        list.add(getUnionForSelect());
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
        map.put("base", getUnionForBase());
        map.put("select", getUnionForSelect());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBase().getNodeValue(), getUnionForSelect().getNodeValue()});
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
        sb.append("base=");
        sb.append(this.getUnionForBase().getNodeValue() == null? "null" : this.getUnionForBase().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("select=");
        sb.append(this.getUnionForSelect().getNodeValue() == null? "null" : this.getUnionForSelect().getNodeValue().getClass().getSimpleName());
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
        return operation.executeParameterizedTypeSelectNode(this, p);
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
        return operation.executeParameterizedTypeSelectNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeSelectNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ParameterizedTypeNode> baseCopy;
        switch (getUnionForBase().getType())
        {
            case NORMAL:
                if (getUnionForBase().getNormalNode() == null)
                {
                    baseCopy = factory.<ParameterizedTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    baseCopy = factory.makeNormalNodeUnion(getUnionForBase().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBase().getSpliceNode() == null)
                {
                    baseCopy = factory.<ParameterizedTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    baseCopy = factory.makeSpliceNodeUnion(getUnionForBase().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBase().getType());
        }
        NodeUnion<? extends DeclaredTypeNode> selectCopy;
        switch (getUnionForSelect().getType())
        {
            case NORMAL:
                if (getUnionForSelect().getNormalNode() == null)
                {
                    selectCopy = factory.<DeclaredTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    selectCopy = factory.makeNormalNodeUnion(getUnionForSelect().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForSelect().getSpliceNode() == null)
                {
                    selectCopy = factory.<DeclaredTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    selectCopy = factory.makeSpliceNodeUnion(getUnionForSelect().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForSelect().getType());
        }
        return factory.makeParameterizedTypeSelectNodeWithUnions(
                baseCopy,
                selectCopy,
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
        
        if (before.equals(this.getUnionForBase().getNodeValue()))
        {
            setBase((ParameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForSelect().getNodeValue()))
        {
            setSelect((DeclaredTypeNode)after);
            return true;
        }
        return false;
    }
    
    @Override
    public Collection<? extends TypeNameBindingNode> getDeclarations()
    {
        throw new NotImplementedYetException();
    }
}
