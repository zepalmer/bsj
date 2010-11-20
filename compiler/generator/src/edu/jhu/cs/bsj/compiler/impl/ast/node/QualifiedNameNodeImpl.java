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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedNameNodeImpl extends NameNodeImpl implements QualifiedNameNode
{
    /** The name being qualified. */
    private NodeUnion<? extends NameNode> base;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(QualifiedNameNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the base property. */
        BASE,
    }
    
    /** General constructor. */
    public QualifiedNameNodeImpl(
            NodeUnion<? extends NameNode> base,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(identifier, startLocation, stopLocation, manager, binary);
        setUnionForBase(base, false);
    }
    
    /**
     * Gets the name being qualified.  This property's value is assumed to be a normal node.
     * @return The name being qualified.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public NameNode getBase()
    {
        getAttribute(LocalAttribute.BASE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.base == null)
        {
            return null;
        } else
        {
            return this.base.getNormalNode();
        }
    }
    
    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NodeUnion<? extends NameNode> getUnionForBase()
    {
        getAttribute(LocalAttribute.BASE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.base == null)
        {
            this.base = new NormalNodeUnion<NameNode>(null);
        }
        return this.base;
    }
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base)
    {
            setBase(base, true);
            getManager().notifyChange(this);
    }
    
    private void setBase(NameNode base, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.base != null)
        {
            setAsChild(this.base.getNodeValue(), false);
        }
        this.base = new NormalNodeUnion<NameNode>(base);
        setAsChild(base, true);
    }
    
    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setUnionForBase(NodeUnion<? extends NameNode> base)
    {
            setUnionForBase(base, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBase(NodeUnion<? extends NameNode> base, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BASE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (base == null)
        {
            base = new NormalNodeUnion<NameNode>(null);
        }
        if (this.base != null)
        {
            setAsChild(this.base.getNodeValue(), false);
        }
        this.base = base;
        setAsChild(base.getNodeValue(), true);
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
        if (this.base.getNodeValue() != null)
        {
            this.base.getNodeValue().receive(visitor);
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
        if (this.base.getNodeValue() != null)
        {
            this.base.getNodeValue().receiveTyped(visitor);
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
        visitor.visitQualifiedNameNodeStart(this, true);
        visitor.visitNameNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitNameNodeStop(this);
        visitor.visitQualifiedNameNodeStop(this, true);
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
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBase().getNodeValue(), getUnionForIdentifier().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (base == null)
        {
            sb.append("[null]");
        } else
        {
            NodeUnion<? extends NameNode> union = getUnionForBase();
            if (union.getType() == NodeUnion.Type.NORMAL)
            {
                sb.append(union.getNormalNode().toString());
            } else
            {
                sb.append(union.toString());
            }
        }
        sb.append('.');
        NodeUnion<? extends IdentifierNode> union = getUnionForIdentifier();
        if (union.getType() == NodeUnion.Type.NORMAL)
        {
            if (union.getNormalNode() == null)
            {
                sb.append("[null]");
            } else
            {
                sb.append(union.getNormalNode().getIdentifier());
            }
        } else
        {
            sb.append(union.toString());
        }
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
        return operation.executeQualifiedNameNode(this, p);
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
        return operation.executeQualifiedNameNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedNameNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends NameNode> baseCopy;
        switch (getUnionForBase().getType())
        {
            case NORMAL:
                if (getUnionForBase().getNormalNode() == null)
                {
                    baseCopy = factory.<NameNode>makeNormalNodeUnion(null);
                } else
                {
                    baseCopy = factory.makeNormalNodeUnion(getUnionForBase().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBase().getSpliceNode() == null)
                {
                    baseCopy = factory.<NameNode>makeSpliceNodeUnion(null);
                } else
                {
                    baseCopy = factory.makeSpliceNodeUnion(getUnionForBase().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBase().getType());
        }
        NodeUnion<? extends IdentifierNode> identifierCopy;
        switch (getUnionForIdentifier().getType())
        {
            case NORMAL:
                if (getUnionForIdentifier().getNormalNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeNormalNodeUnion(getUnionForIdentifier().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForIdentifier().getSpliceNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeSpliceNodeUnion(getUnionForIdentifier().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForIdentifier().getType());
        }
        return factory.makeQualifiedNameNodeWithUnions(
                baseCopy,
                identifierCopy,
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
            setBase((NameNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        return false;
    }
    
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getBase().getNameString() + "." + getIdentifier().getIdentifier();
	}
}
