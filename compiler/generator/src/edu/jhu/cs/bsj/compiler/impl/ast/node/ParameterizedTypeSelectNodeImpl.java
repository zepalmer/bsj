package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeSelectNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ParameterizedTypeSelectNodeImpl extends NodeImpl implements ParameterizedTypeSelectNode
{
    /** The parameterized type from which a type is selected. */
    private ParameterizedTypeNode base;

    /** The type which is selected from the base. */
    private DeclaredTypeNode select;

    /** General constructor. */
    public ParameterizedTypeSelectNodeImpl(
            ParameterizedTypeNode base,
            DeclaredTypeNode select,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setBase(base);
        setSelect(select);
    }

    /**
     * Gets the parameterized type from which a type is selected.
     * @return The parameterized type from which a type is selected.
     */
    public ParameterizedTypeNode getBase()
    {
        return this.base;
    }

    /**
     * Changes the parameterized type from which a type is selected.
     * @param base The parameterized type from which a type is selected.
     */
    public void setBase(ParameterizedTypeNode base)
    {
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(null);
        }
        this.base = base;
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(this);
        }
    }

    /**
     * Gets the type which is selected from the base.
     * @return The type which is selected from the base.
     */
    public DeclaredTypeNode getSelect()
    {
        return this.select;
    }

    /**
     * Changes the type which is selected from the base.
     * @param select The type which is selected from the base.
     */
    public void setSelect(DeclaredTypeNode select)
    {
        if (this.select instanceof NodeImpl)
        {
            ((NodeImpl)this.select).setParent(null);
        }
        this.select = select;
        if (this.select instanceof NodeImpl)
        {
            ((NodeImpl)this.select).setParent(this);
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
        if (this.base != null)
        {
            this.base.receive(visitor);
        }
        if (this.select != null)
        {
            this.select.receive(visitor);
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
        if (this.base != null)
        {
            this.base.receiveTyped(visitor);
        }
        if (this.select != null)
        {
            this.select.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitParameterizedTypeSelectNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitDeclaredTypeNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitDeclaredTypeNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitParameterizedTypeSelectNodeStop(this, true);
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
        list.add(getBase());
        list.add(getSelect());
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
        sb.append("base=");
        sb.append(this.getBase() == null? "null" : this.getBase().getClass().getSimpleName());
        sb.append(',');
        sb.append("select=");
        sb.append(this.getSelect() == null? "null" : this.getSelect().getClass().getSimpleName());
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
        return operation.executeParameterizedTypeSelectNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizedTypeSelectNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeParameterizedTypeSelectNode(
                getBase().deepCopy(factory),
                getSelect().deepCopy(factory));
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public <N extends Node> boolean replace(N before, N after)
    {
        if (super.replace(before,after))
            return true;

        if (before.equals(this.base) && (after instanceof ParameterizedTypeNode))
        {
            setBase((ParameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.select) && (after instanceof DeclaredTypeNode))
        {
            setSelect((DeclaredTypeNode)after);
            return true;
        }
        return false;
    }

}
