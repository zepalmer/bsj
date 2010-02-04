package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodModifiersNodeImpl extends ModifiersNodeImpl implements MethodModifiersNode
{
    /** The access for the associated method. */
    private AccessModifier access;

    /** Whether or not the associated method is abstract. */
    private boolean abstractFlag;

    /** Whether or not the associated method is static. */
    private boolean staticFlag;

    /** Whether or not the associated method is final. */
    private boolean finalFlag;

    /** Whether or not the associated method is synchronized. */
    private boolean synchronizedFlag;

    /** Whether or not the associated method is native. */
    private boolean nativeFlag;

    /** Whether or not the associated method uses strict floating-point. */
    private boolean strictfpFlag;

    /** General constructor. */
    public MethodModifiersNodeImpl(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean synchronizedFlag,
            boolean nativeFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(annotations, startLocation, stopLocation);
        this.access = access;
        this.abstractFlag = abstractFlag;
        this.staticFlag = staticFlag;
        this.finalFlag = finalFlag;
        this.synchronizedFlag = synchronizedFlag;
        this.nativeFlag = nativeFlag;
        this.strictfpFlag = strictfpFlag;
    }

    /**
     * Gets the access for the associated method.
     * @return The access for the associated method.
     */
    public AccessModifier getAccess()
    {
        return this.access;
    }

    /**
     * Changes the access for the associated method.
     * @param access The access for the associated method.
     */
    public void setAccess(AccessModifier access)
    {
        this.access = access;
    }

    /**
     * Gets whether or not the associated method is abstract.
     * @return Whether or not the associated method is abstract.
     */
    public boolean getAbstractFlag()
    {
        return this.abstractFlag;
    }

    /**
     * Changes whether or not the associated method is abstract.
     * @param abstractFlag Whether or not the associated method is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag)
    {
        this.abstractFlag = abstractFlag;
    }

    /**
     * Gets whether or not the associated method is static.
     * @return Whether or not the associated method is static.
     */
    public boolean getStaticFlag()
    {
        return this.staticFlag;
    }

    /**
     * Changes whether or not the associated method is static.
     * @param staticFlag Whether or not the associated method is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }

    /**
     * Gets whether or not the associated method is final.
     * @return Whether or not the associated method is final.
     */
    public boolean getFinalFlag()
    {
        return this.finalFlag;
    }

    /**
     * Changes whether or not the associated method is final.
     * @param finalFlag Whether or not the associated method is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }

    /**
     * Gets whether or not the associated method is synchronized.
     * @return Whether or not the associated method is synchronized.
     */
    public boolean getSynchronizedFlag()
    {
        return this.synchronizedFlag;
    }

    /**
     * Changes whether or not the associated method is synchronized.
     * @param synchronizedFlag Whether or not the associated method is synchronized.
     */
    public void setSynchronizedFlag(boolean synchronizedFlag)
    {
        this.synchronizedFlag = synchronizedFlag;
    }

    /**
     * Gets whether or not the associated method is native.
     * @return Whether or not the associated method is native.
     */
    public boolean getNativeFlag()
    {
        return this.nativeFlag;
    }

    /**
     * Changes whether or not the associated method is native.
     * @param nativeFlag Whether or not the associated method is native.
     */
    public void setNativeFlag(boolean nativeFlag)
    {
        this.nativeFlag = nativeFlag;
    }

    /**
     * Gets whether or not the associated method uses strict floating-point.
     * @return Whether or not the associated method uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        return this.strictfpFlag;
    }

    /**
     * Changes whether or not the associated method uses strict floating-point.
     * @param strictfpFlag Whether or not the associated method uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag)
    {
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
        visitor.visitMethodModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitModifiersNodeStop(this);
        visitor.visitMethodModifiersNodeStop(this, true);
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
        list.add(getSynchronizedFlag());
        list.add(getNativeFlag());
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
        sb.append("synchronizedFlag=");
        sb.append(String.valueOf(this.getSynchronizedFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("nativeFlag=");
        sb.append(String.valueOf(this.getNativeFlag()) + ":" + ("boolean"));
        sb.append(',');
        sb.append("strictfpFlag=");
        sb.append(String.valueOf(this.getStrictfpFlag()) + ":" + ("boolean"));
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
        return operation.executeMethodModifiersNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodModifiersNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMethodModifiersNode(
                getAccess(),
                getAbstractFlag(),
                getStaticFlag(),
                getFinalFlag(),
                getSynchronizedFlag(),
                getNativeFlag(),
                getStrictfpFlag(),
                getAnnotations().deepCopy(factory));
    }
}
