package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramImportNodeImpl extends NodeImpl implements MetaprogramImportNode
{
    /** The import for the metaprogram. */
    private ImportNode importNode;

    /** General constructor. */
    public MetaprogramImportNodeImpl(
            ImportNode importNode,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setImportNode(importNode);
    }

    /**
     * Gets the import for the metaprogram.
     * @return The import for the metaprogram.
     */
    public ImportNode getImportNode()
    {
        return this.importNode;
    }

    /**
     * Changes the import for the metaprogram.
     * @param importNode The import for the metaprogram.
     */
    public void setImportNode(ImportNode importNode)
    {
        if (this.importNode instanceof NodeImpl)
        {
            ((NodeImpl)this.importNode).setParent(null);
        }
        this.importNode = importNode;
        if (this.importNode instanceof NodeImpl)
        {
            ((NodeImpl)this.importNode).setParent(this);
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
        if (this.importNode != null)
        {
            this.importNode.receive(visitor);
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
        if (this.importNode != null)
        {
            this.importNode.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitMetaprogramImportNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramImportNodeStop(this, true);
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
        list.add(getImportNode());
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
        sb.append("importNode=");
        sb.append(this.getImportNode() == null? "null" : this.getImportNode().getClass().getSimpleName());
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
        return operation.executeMetaprogramImportNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramImportNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaprogramImportNode(
                getImportNode().deepCopy(factory));
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

        if (before.equals(this.importNode) && (after instanceof ImportNode))
        {
            setImportNode((ImportNode)after);
            return true;
        }
        return false;
    }

}
