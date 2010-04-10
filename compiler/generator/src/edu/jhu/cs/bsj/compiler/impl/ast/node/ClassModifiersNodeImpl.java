package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ClassModifiersNodeImpl extends ModifiersNodeImpl implements ClassModifiersNode
{
    /** The access for the associated class. */
    private AccessModifier access;
    
    /** Whether or not the associated class is abstract. */
    private boolean abstractFlag;
    
    /** Whether or not the associated class is static. */
    private boolean staticFlag;
    
    /** Whether or not the associated class is final. */
    private boolean finalFlag;
    
    /** Whether or not the associated class uses strict floating-point. */
    private boolean strictfpFlag;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the access property. */
        ACCESS,
        /** Attribute for the abstractFlag property. */
        ABSTRACT_FLAG,
        /** Attribute for the staticFlag property. */
        STATIC_FLAG,
        /** Attribute for the finalFlag property. */
        FINAL_FLAG,
        /** Attribute for the strictfpFlag property. */
        STRICTFP_FLAG,
    }
    
    /** General constructor. */
    public ClassModifiersNodeImpl(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            MetaAnnotationListNode metaAnnotations,
            AnnotationListNode annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(metaAnnotations, annotations, startLocation, stopLocation, manager, binary);
        this.access = access;
        this.abstractFlag = abstractFlag;
        this.staticFlag = staticFlag;
        this.finalFlag = finalFlag;
        this.strictfpFlag = strictfpFlag;
    }
    
    /**
     * Gets the access for the associated class.
     * @return The access for the associated class.
     */
    public AccessModifier getAccess()
    {
        recordAccess(LocalAttribute.ACCESS, Attribute.AccessType.READ);
        return this.access;
    }
    
    /**
     * Changes the access for the associated class.
     * @param access The access for the associated class.
     */
    public void setAccess(AccessModifier access)
    {
            setAccess(access, true);
    }
    
    private void setAccess(AccessModifier access, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.ACCESS, Attribute.AccessType.STRONG_WRITE);
        this.access = access;
    }
    
    /**
     * Gets whether or not the associated class is abstract.
     * @return Whether or not the associated class is abstract.
     */
    public boolean getAbstractFlag()
    {
        recordAccess(LocalAttribute.ABSTRACT_FLAG, Attribute.AccessType.READ);
        return this.abstractFlag;
    }
    
    /**
     * Changes whether or not the associated class is abstract.
     * @param abstractFlag Whether or not the associated class is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag)
    {
            setAbstractFlag(abstractFlag, true);
    }
    
    private void setAbstractFlag(boolean abstractFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.ABSTRACT_FLAG, Attribute.AccessType.STRONG_WRITE);
        this.abstractFlag = abstractFlag;
    }
    
    /**
     * Gets whether or not the associated class is static.
     * @return Whether or not the associated class is static.
     */
    public boolean getStaticFlag()
    {
        recordAccess(LocalAttribute.STATIC_FLAG, Attribute.AccessType.READ);
        return this.staticFlag;
    }
    
    /**
     * Changes whether or not the associated class is static.
     * @param staticFlag Whether or not the associated class is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
            setStaticFlag(staticFlag, true);
    }
    
    private void setStaticFlag(boolean staticFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.STATIC_FLAG, Attribute.AccessType.STRONG_WRITE);
        this.staticFlag = staticFlag;
    }
    
    /**
     * Gets whether or not the associated class is final.
     * @return Whether or not the associated class is final.
     */
    public boolean getFinalFlag()
    {
        recordAccess(LocalAttribute.FINAL_FLAG, Attribute.AccessType.READ);
        return this.finalFlag;
    }
    
    /**
     * Changes whether or not the associated class is final.
     * @param finalFlag Whether or not the associated class is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
            setFinalFlag(finalFlag, true);
    }
    
    private void setFinalFlag(boolean finalFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.FINAL_FLAG, Attribute.AccessType.STRONG_WRITE);
        this.finalFlag = finalFlag;
    }
    
    /**
     * Gets whether or not the associated class uses strict floating-point.
     * @return Whether or not the associated class uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        recordAccess(LocalAttribute.STRICTFP_FLAG, Attribute.AccessType.READ);
        return this.strictfpFlag;
    }
    
    /**
     * Changes whether or not the associated class uses strict floating-point.
     * @param strictfpFlag Whether or not the associated class uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag)
    {
            setStrictfpFlag(strictfpFlag, true);
    }
    
    private void setStrictfpFlag(boolean strictfpFlag, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.STRICTFP_FLAG, Attribute.AccessType.STRONG_WRITE);
        this.strictfpFlag = strictfpFlag;
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
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitClassModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitModifiersNodeStop(this);
        visitor.visitClassModifiersNodeStop(this, true);
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
        list.add(getAccess());
        list.add(getAbstractFlag());
        list.add(getStaticFlag());
        list.add(getFinalFlag());
        list.add(getStrictfpFlag());
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
        sb.append("access=");
        sb.append(String.valueOf(this.getAccess()) + ":" + (this.getAccess() != null ? this.getAccess().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("abstractFlag=");
        sb.append(String.valueOf(this.getAbstractFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(String.valueOf(this.getStaticFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.getFinalFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("strictfpFlag=");
        sb.append(String.valueOf(this.getStrictfpFlag()) + ":" + ("boolean"));
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
        return operation.executeClassModifiersNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassModifiersNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeClassModifiersNode(
                getAccess(),
                getAbstractFlag(),
                getStaticFlag(),
                getFinalFlag(),
                getStrictfpFlag(),
                getMetaAnnotations()==null?null:getMetaAnnotations().deepCopy(factory),
                getAnnotations()==null?null:getAnnotations().deepCopy(factory),
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
