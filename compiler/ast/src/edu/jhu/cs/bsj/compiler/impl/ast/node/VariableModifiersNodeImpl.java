package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableModifiersNodeImpl extends ModifiersNodeImpl implements VariableModifiersNode
{
    /** Whether or not the associated variable is final. */
    private boolean finalFlag;

    /** General constructor. */
    public VariableModifiersNodeImpl(
            boolean finalFlag,
            ListNode<AnnotationNode> annotations,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(annotations, startLocation, stopLocation);
        this.finalFlag = finalFlag;
    }

    /**
     * Gets whether or not the associated variable is final.
     * @return Whether or not the associated variable is final.
     */
    public boolean getFinalFlag()
    {
        return this.finalFlag;
    }

    /**
     * Changes whether or not the associated variable is final.
     * @param finalFlag Whether or not the associated variable is final.
     */
    public void setFinalFlag(boolean finalFlag)
    {
        this.finalFlag = finalFlag;
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
        visitor.visitVariableModifiersNodeStart(this, true);
        visitor.visitModifiersNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitModifiersNodeStart(this);
        visitor.visitVariableModifiersNodeStart(this, true);
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
        list.add(getFinalFlag());
        list.add(getAnnotations());
        list.add(getStartLocation());
        list.add(getStopLocation());
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
        sb.append("finalFlag=");
        sb.append(String.valueOf(this.finalFlag) + ":" + "boolean");
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
        return operation.executeVariableModifiersNode(this, p);
    }
}
