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
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ForInitializerDeclarationNodeSetDeclarationPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ForInitializerDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ForInitializerDeclarationNodeImpl extends NodeImpl implements ForInitializerDeclarationNode
{
    /** The variables declared in this initializer. */
    private NodeUnion<? extends LocalVariableDeclarationNode> declaration;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ForInitializerDeclarationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ForInitializerDeclarationNodeImpl(
            NodeUnion<? extends LocalVariableDeclarationNode> declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetDeclaration(declaration);
    }
    
    /** Proxy constructor. */
    public ForInitializerDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ForInitializerDeclarationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ForInitializerDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ForInitializerDeclarationNode getBackingNode()
    {
        return (ForInitializerDeclarationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the declaration value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkDeclarationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ForInitializerDeclarationNodeProperties.DECLARATION))
            return;
        this.populatedProperties.add(ForInitializerDeclarationNodeProperties.DECLARATION);
        NodeUnion<? extends LocalVariableDeclarationNode> union = this.getBackingNode().getUnionForDeclaration();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeLocalVariableDeclarationNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.declaration = union;
    }
    
    /**
     * Gets the variables declared in this initializer.  This property's value is assumed to be a normal node.
     * @return The variables declared in this initializer.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public LocalVariableDeclarationNode getDeclaration()
    {
        checkDeclarationWrapped();
        if (this.declaration == null)
        {
            return null;
        } else
        {
            return this.declaration.getNormalNode();
        }
    }
    
    /**
     * Gets the variables declared in this initializer.
     * @return The variables declared in this initializer.
     */
    public NodeUnion<? extends LocalVariableDeclarationNode> getUnionForDeclaration()
    {
        checkDeclarationWrapped();
        if (this.declaration == null)
        {
            this.declaration = new NormalNodeUnion<LocalVariableDeclarationNode>(null);
        }
        return this.declaration;
    }
    
    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setDeclaration(LocalVariableDeclarationNode declaration)
    {
        checkDeclarationWrapped();
        this.setUnionForDeclaration(new NormalNodeUnion<LocalVariableDeclarationNode>(declaration));
    }
    
    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setUnionForDeclaration(NodeUnion<? extends LocalVariableDeclarationNode> declaration)
    {
        checkDeclarationWrapped();
        this.getManager().assertMutatable(this);
        this.doSetDeclaration(declaration);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ForInitializerDeclarationNodeSetDeclarationPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), declaration.getNodeValue() == null ? null : declaration.getNodeValue().getUid()));
    }
    
    private void doSetDeclaration(NodeUnion<? extends LocalVariableDeclarationNode> declaration)
    {
        if (declaration == null)
        {
            declaration = new NormalNodeUnion<LocalVariableDeclarationNode>(null);
        }
        if (this.declaration != null)
        {
            setAsChild(this.declaration.getNodeValue(), false);
        }
        this.declaration = declaration;
        setAsChild(declaration.getNodeValue(), true);
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
        if (this.getUnionForDeclaration().getNodeValue() != null)
        {
            this.getUnionForDeclaration().getNodeValue().receive(visitor);
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
        if (this.getUnionForDeclaration().getNodeValue() != null)
        {
            this.getUnionForDeclaration().getNodeValue().receiveTyped(visitor);
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
        visitor.visitForInitializerDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitForInitializerNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitForInitializerNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitForInitializerDeclarationNodeStop(this, true);
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
        list.add(getUnionForDeclaration());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForDeclaration().getNodeValue()});
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
        sb.append("declaration=");
        sb.append(this.getUnionForDeclaration().getNodeValue() == null? "null" : this.getUnionForDeclaration().getNodeValue().getClass().getSimpleName());
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
        return operation.executeForInitializerDeclarationNode(this, p);
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
        return operation.executeForInitializerDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForInitializerDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends LocalVariableDeclarationNode> declarationCopy;
        switch (getUnionForDeclaration().getType())
        {
            case NORMAL:
                if (getUnionForDeclaration().getNormalNode() == null)
                {
                    declarationCopy = factory.<LocalVariableDeclarationNode>makeNormalNodeUnion(null);
                } else
                {
                    declarationCopy = factory.makeNormalNodeUnion(getUnionForDeclaration().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForDeclaration().getSpliceNode() == null)
                {
                    declarationCopy = factory.<LocalVariableDeclarationNode>makeSpliceNodeUnion(null);
                } else
                {
                    declarationCopy = factory.makeSpliceNodeUnion(getUnionForDeclaration().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForDeclaration().getType());
        }
        return factory.makeForInitializerDeclarationNodeWithUnions(
                declarationCopy,
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
        
        if (before.equals(this.getUnionForDeclaration().getNodeValue()))
        {
            setDeclaration((LocalVariableDeclarationNode)after);
            return true;
        }
        return false;
    }
    
}
