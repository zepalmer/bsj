package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramDependencyNodeImpl extends NodeImpl implements MetaprogramDependencyNode
{
    /** The name of the metaprogram target on which to depend. */
    private NameNode targetName;
    
    /** Whether or not this dependency is weak. */
    private boolean weak;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the targetName property. */
        TARGET_NAME,
        /** Attribute for the weak property. */
        WEAK,
    }
    
    /** General constructor. */
    public MetaprogramDependencyNodeImpl(
            NameNode targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setTargetName(targetName, false);
        this.weak = weak;
    }
    
    /**
     * Gets the name of the metaprogram target on which to depend.
     * @return The name of the metaprogram target on which to depend.
     */
    public NameNode getTargetName()
    {
        recordAccess(LocalAttribute.TARGET_NAME, Attribute.AccessType.READ);
        return this.targetName;
    }
    
    /**
     * Changes the name of the metaprogram target on which to depend.
     * @param targetName The name of the metaprogram target on which to depend.
     */
    public void setTargetName(NameNode targetName)
    {
            setTargetName(targetName, true);
    }
    
    private void setTargetName(NameNode targetName, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.TARGET_NAME, Attribute.AccessType.STRONG_WRITE);
        }
        setAsChild(targetName, false);
        this.targetName = targetName;
        setAsChild(targetName, true);
    }
    
    /**
     * Gets whether or not this dependency is weak.
     * @return Whether or not this dependency is weak.
     */
    public boolean getWeak()
    {
        recordAccess(LocalAttribute.WEAK, Attribute.AccessType.READ);
        return this.weak;
    }
    
    /**
     * Changes whether or not this dependency is weak.
     * @param weak Whether or not this dependency is weak.
     */
    public void setWeak(boolean weak)
    {
            setWeak(weak, true);
    }
    
    private void setWeak(boolean weak, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.WEAK, Attribute.AccessType.STRONG_WRITE);
        }
        this.weak = weak;
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
        if (this.targetName != null)
        {
            this.targetName.receive(visitor);
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
        if (this.targetName != null)
        {
            this.targetName.receiveTyped(visitor);
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
        visitor.visitMetaprogramDependencyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramDependencyNodeStop(this, true);
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
        list.add(getTargetName());
        list.add(getWeak());
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
        sb.append("targetName=");
        sb.append(this.getTargetName() == null? "null" : this.getTargetName().getClass().getSimpleName());
        sb.append(',');
        sb.append("weak=");
        sb.append(String.valueOf(this.getWeak()) + ":" + ("boolean"));
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
        return operation.executeMetaprogramDependencyNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaprogramDependencyNode(
                getTargetName()==null?null:getTargetName().deepCopy(factory),
                getWeak(),
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
        
        if (before.equals(this.getTargetName()) && (after instanceof NameNode))
        {
            setTargetName((NameNode)after);
            return true;
        }
        return false;
    }
    
}
