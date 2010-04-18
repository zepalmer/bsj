package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ExplicitMetaprogramAnchorNodeImpl<T extends Node> extends MetaprogramAnchorNodeImpl<T> implements ExplicitMetaprogramAnchorNode<T>
{
    /** The metaprogram on this node. */
    private MetaprogramNode metaprogram;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the metaprogram property. */
        METAPROGRAM,
    }
    
    /** General constructor. */
    protected ExplicitMetaprogramAnchorNodeImpl(
            MetaprogramNode metaprogram,
            T replacement,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(replacement, startLocation, stopLocation, manager, binary);
        setMetaprogram(metaprogram, false);
    }
    
    /**
     * Gets the metaprogram on this node.
     * @return The metaprogram on this node.
     */
    public MetaprogramNode getMetaprogram()
    {
        recordAccess(LocalAttribute.METAPROGRAM, Attribute.AccessType.READ);
        return this.metaprogram;
    }
    
    /**
     * Changes the metaprogram on this node.
     * @param metaprogram The metaprogram on this node.
     */
    public void setMetaprogram(MetaprogramNode metaprogram)
    {
            setMetaprogram(metaprogram, true);
    }
    
    private void setMetaprogram(MetaprogramNode metaprogram, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.METAPROGRAM, Attribute.AccessType.WRITE);
        }
        if (this.metaprogram instanceof NodeImpl)
        {
            ((NodeImpl)this.metaprogram).setParent(null);
        }
        this.metaprogram = metaprogram;
        if (this.metaprogram instanceof NodeImpl)
        {
            ((NodeImpl)this.metaprogram).setParent(this);
        }
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
        if (this.metaprogram != null)
        {
            this.metaprogram.receive(visitor);
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
        if (this.metaprogram != null)
        {
            this.metaprogram.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitExplicitMetaprogramAnchorNodeStart(this);
        visitor.visitMetaprogramAnchorNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramAnchorNodeStop(this);
        visitor.visitExplicitMetaprogramAnchorNodeStop(this);
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
        list.add(getMetaprogram());
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
        sb.append("metaprogram=");
        sb.append(this.getMetaprogram() == null? "null" : this.getMetaprogram().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
}
