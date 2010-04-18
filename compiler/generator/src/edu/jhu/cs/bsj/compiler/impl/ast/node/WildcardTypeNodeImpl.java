package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.WildcardTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class WildcardTypeNodeImpl extends NodeImpl implements WildcardTypeNode
{
    /** The wildcard's bound. */
    private ReferenceTypeNode bound;
    
    /** Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound. */
    private boolean upperBound;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the bound property. */
        BOUND,
        /** Attribute for the upperBound property. */
        UPPER_BOUND,
    }
    
    /** General constructor. */
    public WildcardTypeNodeImpl(
            ReferenceTypeNode bound,
            boolean upperBound,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setBound(bound, false);
        this.upperBound = upperBound;
    }
    
    /**
     * Gets the wildcard's bound.
     * @return The wildcard's bound.
     */
    public ReferenceTypeNode getBound()
    {
        recordAccess(LocalAttribute.BOUND, Attribute.AccessType.READ);
        return this.bound;
    }
    
    /**
     * Changes the wildcard's bound.
     * @param bound The wildcard's bound.
     */
    public void setBound(ReferenceTypeNode bound)
    {
            setBound(bound, true);
    }
    
    private void setBound(ReferenceTypeNode bound, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.BOUND, Attribute.AccessType.WRITE);
        }
        if (this.bound instanceof NodeImpl)
        {
            ((NodeImpl)this.bound).setParent(null);
        }
        this.bound = bound;
        if (this.bound instanceof NodeImpl)
        {
            ((NodeImpl)this.bound).setParent(this);
        }
    }
    
    /**
     * Gets whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @return Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public boolean getUpperBound()
    {
        recordAccess(LocalAttribute.UPPER_BOUND, Attribute.AccessType.READ);
        return this.upperBound;
    }
    
    /**
     * Changes whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     * @param upperBound Whether or not the wildcard's bound is an upper (<tt>extends</tt>) bound.
     */
    public void setUpperBound(boolean upperBound)
    {
            setUpperBound(upperBound, true);
    }
    
    private void setUpperBound(boolean upperBound, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.UPPER_BOUND, Attribute.AccessType.WRITE);
        }
        this.upperBound = upperBound;
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
        if (this.bound != null)
        {
            this.bound.receive(visitor);
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
        if (this.bound != null)
        {
            this.bound.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitWildcardTypeNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeArgumentNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeArgumentNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitWildcardTypeNodeStop(this, true);
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
        list.add(getBound());
        list.add(getUpperBound());
        return list;
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
        sb.append("bound=");
        sb.append(this.getBound() == null? "null" : this.getBound().getClass().getSimpleName());
        sb.append(',');
        sb.append("upperBound=");
        sb.append(String.valueOf(this.getUpperBound()) + ":" + ("boolean"));
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
        return operation.executeWildcardTypeNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public WildcardTypeNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeWildcardTypeNode(
                getBound()==null?null:getBound().deepCopy(factory),
                getUpperBound(),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
        
        if (before.equals(this.getBound()) && (after instanceof ReferenceTypeNode))
        {
            setBound((ReferenceTypeNode)after);
            return true;
        }
        return false;
    }
    
}
