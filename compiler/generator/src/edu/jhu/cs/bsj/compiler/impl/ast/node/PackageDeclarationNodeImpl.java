package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageDeclarationNodeImpl extends NodeImpl implements PackageDeclarationNode
{
    /** The name of the package. */
    private NameNode name;
    
    /** The meta-annotations on the package declaration. */
    private MetaAnnotationListNode metaAnnotations;
    
    /** The annotations on the package declaration. */
    private AnnotationListNode annotations;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the name property. */
        NAME,
        /** Attribute for the metaAnnotations property. */
        META_ANNOTATIONS,
        /** Attribute for the annotations property. */
        ANNOTATIONS,
    }
    
    /** General constructor. */
    public PackageDeclarationNodeImpl(
            NameNode name,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setName(name, false);
        setMetaAnnotations(metaAnnotations, false);
        setAnnotations(annotations, false);
    }
    
    /**
     * Gets the name of the package.
     * @return The name of the package.
     */
    public NameNode getName()
    {
        recordAccess(LocalAttribute.NAME, Attribute.AccessType.READ);
        return this.name;
    }
    
    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name)
    {
            setName(name, true);
    }
    
    private void setName(NameNode name, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.NAME, Attribute.AccessType.WRITE);
        }
        setAsChild(name, false);
        this.name = name;
        setAsChild(name, true);
    }
    
    /**
     * Gets the meta-annotations on the package declaration.
     * @return The meta-annotations on the package declaration.
     */
    public MetaAnnotationListNode getMetaAnnotations()
    {
        recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.READ);
        return this.metaAnnotations;
    }
    
    /**
     * Changes the meta-annotations on the package declaration.
     * @param metaAnnotations The meta-annotations on the package declaration.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations)
    {
            setMetaAnnotations(metaAnnotations, true);
    }
    
    private void setMetaAnnotations(MetaAnnotationListNode metaAnnotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.META_ANNOTATIONS, Attribute.AccessType.WRITE);
        }
        setAsChild(metaAnnotations, false);
        this.metaAnnotations = metaAnnotations;
        setAsChild(metaAnnotations, true);
    }
    
    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public AnnotationListNode getAnnotations()
    {
        recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.READ);
        return this.annotations;
    }
    
    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(AnnotationListNode annotations)
    {
            setAnnotations(annotations, true);
    }
    
    private void setAnnotations(AnnotationListNode annotations, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.ANNOTATIONS, Attribute.AccessType.WRITE);
        }
        setAsChild(annotations, false);
        this.annotations = annotations;
        setAsChild(annotations, true);
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
        if (this.name != null)
        {
            this.name.receive(visitor);
        }
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receive(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receive(visitor);
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
        if (this.name != null)
        {
            this.name.receiveTyped(visitor);
        }
        if (this.metaAnnotations != null)
        {
            this.metaAnnotations.receiveTyped(visitor);
        }
        if (this.annotations != null)
        {
            this.annotations.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitPackageDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitPackageDeclarationNodeStop(this, true);
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
        list.add(getName());
        list.add(getMetaAnnotations());
        list.add(getAnnotations());
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
        sb.append("name=");
        sb.append(this.getName() == null? "null" : this.getName().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaAnnotations=");
        sb.append(this.getMetaAnnotations() == null? "null" : this.getMetaAnnotations().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotations=");
        sb.append(this.getAnnotations() == null? "null" : this.getAnnotations().getClass().getSimpleName());
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
        return operation.executePackageDeclarationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makePackageDeclarationNode(
                getName()==null?null:getName().deepCopy(factory),
                getMetaAnnotations()==null?null:getMetaAnnotations().deepCopy(factory),
                getAnnotations()==null?null:getAnnotations().deepCopy(factory),
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
        
        if (before.equals(this.getName()) && (after instanceof NameNode))
        {
            setName((NameNode)after);
            return true;
        }
        if (before.equals(this.getMetaAnnotations()) && (after instanceof MetaAnnotationListNode))
        {
            setMetaAnnotations((MetaAnnotationListNode)after);
            return true;
        }
        if (before.equals(this.getAnnotations()) && (after instanceof AnnotationListNode))
        {
            setAnnotations((AnnotationListNode)after);
            return true;
        }
        return false;
    }
    
}
