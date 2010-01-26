package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInitializerCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInitializerCreationNode
{
    /** The initializer for this array. */
    private ArrayInitializerNode initializer;

    /** General constructor. */
    public ArrayInitializerCreationNodeImpl(
            ArrayInitializerNode initializer,
            BaseTypeNode baseType,
            int arrayLevels,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(baseType, arrayLevels, startLocation, stopLocation);
        this.initializer = initializer;
    }

    /**
     * Gets the initializer for this array.
     * @return The initializer for this array.
     */
    public ArrayInitializerNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer for this array.
     * @param initializer The initializer for this array.
     */
    public void setInitializer(ArrayInitializerNode initializer)
    {
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
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
        this.initializer.receive(visitor);
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
        this.initializer.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitArrayInitializerCreationNodeStart(this, true);
        visitor.visitArrayCreationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitArrayCreationNodeStart(this);
        visitor.visitArrayInitializerCreationNodeStart(this, true);
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
        list.add(getInitializer());
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
        sb.append("initializer=");
        sb.append(this.getInitializer() == null? "null" : this.getInitializer().getClass().getSimpleName());
        sb.append(',');
        sb.append("baseType=");
        sb.append(this.getBaseType() == null? "null" : this.getBaseType().getClass().getSimpleName());
        sb.append(',');
        sb.append("arrayLevels=");
        sb.append(String.valueOf(this.getArrayLevels()) + ":" + "int");
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + this.getStartLocation() == null ? this.getStartLocation().getClass().getSimpleName() : "null");
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + this.getStopLocation() == null ? this.getStopLocation().getClass().getSimpleName() : "null");
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
        return operation.executeArrayInitializerCreationNode(this, p);
    }
}
