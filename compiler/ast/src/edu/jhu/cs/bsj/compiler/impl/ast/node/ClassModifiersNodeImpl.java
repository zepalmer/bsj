package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

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

    /** General constructor. */
    public ClassModifiersNodeImpl(
            AccessModifier access,
            boolean abstractFlag,
            boolean staticFlag,
            boolean finalFlag,
            boolean strictfpFlag,
            ListNode<AnnotationNode> annotations)
    {
        super(annotations);
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
        return this.access;
    }

    /**
     * Changes the access for the associated class.
     * @param access The access for the associated class.
     */
    public void setAccess(AccessModifier access)
    {
        this.access = access;
    }

    /**
     * Gets whether or not the associated class is abstract.
     * @return Whether or not the associated class is abstract.
     */
    public boolean getAbstractFlag()
    {
        return this.abstractFlag;
    }

    /**
     * Changes whether or not the associated class is abstract.
     * @param abstractFlag Whether or not the associated class is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag)
    {
        this.abstractFlag = abstractFlag;
    }

    /**
     * Gets whether or not the associated class is static.
     * @return Whether or not the associated class is static.
     */
    public boolean getStaticFlag()
    {
        return this.staticFlag;
    }

    /**
     * Changes whether or not the associated class is static.
     * @param staticFlag Whether or not the associated class is static.
     */
    public void setStaticFlag(boolean staticFlag)
    {
        this.staticFlag = staticFlag;
    }

    /**
     * Gets whether or not the associated class is final.
     * @return Whether or not the associated class is final.
     */
    public boolean getFinalFlag()
    {
        return this.finalFlag;
    }

    /**
     * Changes whether or not the associated class is final.
     * @param finalFlag Whether or not the associated class is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
    }

    /**
     * Gets whether or not the associated class uses strict floating-point.
     * @return Whether or not the associated class uses strict floating-point.
     */
    public boolean getStrictfpFlag()
    {
        return this.strictfpFlag;
    }

    /**
     * Changes whether or not the associated class uses strict floating-point.
     * @param strictfpFlag Whether or not the associated class uses strict floating-point.
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
        visitor.visitClassModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitModifiersNodeStart(this);
        visitor.visitClassModifiersNodeStart(this, true);
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
        list.add(this.access);
        list.add(this.abstractFlag);
        list.add(this.staticFlag);
        list.add(this.finalFlag);
        list.add(this.strictfpFlag);
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
        sb.append(String.valueOf(this.access) + ":" + this.access.getClass().getSimpleName());
        sb.append(',');
        sb.append("abstractFlag=");
        sb.append(String.valueOf(this.abstractFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("staticFlag=");
        sb.append(String.valueOf(this.staticFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.finalFlag) + ":" + "boolean");
        sb.append(',');
        sb.append("strictfpFlag=");
        sb.append(String.valueOf(this.strictfpFlag) + ":" + "boolean");
        sb.append(']');
        return sb.toString();
    }
}
