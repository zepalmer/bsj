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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ForInitializerDeclarationNodeImpl extends NodeImpl implements ForInitializerDeclarationNode
{
    /** The variables declared in this initializer. */
    private NodeUnion<? extends LocalVariableDeclarationNode> declaration;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ForInitializerDeclarationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the declaration property. */
        DECLARATION,
    }
    
    /** General constructor. */
    public ForInitializerDeclarationNodeImpl(
            NodeUnion<? extends LocalVariableDeclarationNode> declaration,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForDeclaration(declaration, false);
    }
    
    /**
     * Gets the variables declared in this initializer.  This property's value is assumed to be a normal node.
     * @return The variables declared in this initializer.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public LocalVariableDeclarationNode getDeclaration()
    {
        getAttribute(LocalAttribute.DECLARATION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.DECLARATION).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setDeclaration(declaration, true);
            getManager().notifyChange(this);
    }
    
    private void setDeclaration(LocalVariableDeclarationNode declaration, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DECLARATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.declaration != null)
        {
            setAsChild(this.declaration.getNodeValue(), false);
        }
        this.declaration = new NormalNodeUnion<LocalVariableDeclarationNode>(declaration);
        setAsChild(declaration, true);
    }
    
    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setUnionForDeclaration(NodeUnion<? extends LocalVariableDeclarationNode> declaration)
    {
            setUnionForDeclaration(declaration, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForDeclaration(NodeUnion<? extends LocalVariableDeclarationNode> declaration, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DECLARATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.declaration.getNodeValue() != null)
        {
            this.declaration.getNodeValue().receive(visitor);
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
        if (this.declaration.getNodeValue() != null)
        {
            this.declaration.getNodeValue().receiveTyped(visitor);
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
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
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
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
