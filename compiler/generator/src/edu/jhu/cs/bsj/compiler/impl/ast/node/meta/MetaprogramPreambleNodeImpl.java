package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependsNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPreambleNodeImpl extends NodeImpl implements MetaprogramPreambleNode
{
    /** The imports for this metaprogram. */
    private MetaprogramImportListNode imports;

    /** The targets for this metaprogram. */
    private MetaprogramTargetNode target;

    /** The dependencies for this metaprogram. */
    private MetaprogramDependsNode depends;

    /** General constructor. */
    public MetaprogramPreambleNodeImpl(
            MetaprogramImportListNode imports,
            MetaprogramTargetNode target,
            MetaprogramDependsNode depends,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setImports(imports);
        setTarget(target);
        setDepends(depends);
    }

    /**
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public MetaprogramImportListNode getImports()
    {
        return this.imports;
    }

    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports)
    {
        if (this.imports instanceof NodeImpl)
        {
            ((NodeImpl)this.imports).setParent(null);
        }
        this.imports = imports;
        if (this.imports instanceof NodeImpl)
        {
            ((NodeImpl)this.imports).setParent(this);
        }
    }

    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public MetaprogramTargetNode getTarget()
    {
        return this.target;
    }

    /**
     * Changes the targets for this metaprogram.
     * @param target The targets for this metaprogram.
     */
    public void setTarget(MetaprogramTargetNode target)
    {
        if (this.target instanceof NodeImpl)
        {
            ((NodeImpl)this.target).setParent(null);
        }
        this.target = target;
        if (this.target instanceof NodeImpl)
        {
            ((NodeImpl)this.target).setParent(this);
        }
    }

    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public MetaprogramDependsNode getDepends()
    {
        return this.depends;
    }

    /**
     * Changes the dependencies for this metaprogram.
     * @param depends The dependencies for this metaprogram.
     */
    public void setDepends(MetaprogramDependsNode depends)
    {
        if (this.depends instanceof NodeImpl)
        {
            ((NodeImpl)this.depends).setParent(null);
        }
        this.depends = depends;
        if (this.depends instanceof NodeImpl)
        {
            ((NodeImpl)this.depends).setParent(this);
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
        if (this.imports != null)
        {
            this.imports.receive(visitor);
        }
        if (this.target != null)
        {
            this.target.receive(visitor);
        }
        if (this.depends != null)
        {
            this.depends.receive(visitor);
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
        if (this.imports != null)
        {
            this.imports.receiveTyped(visitor);
        }
        if (this.target != null)
        {
            this.target.receiveTyped(visitor);
        }
        if (this.depends != null)
        {
            this.depends.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitMetaprogramPreambleNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramPreambleNodeStop(this, true);
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
        list.add(getImports());
        list.add(getTarget());
        list.add(getDepends());
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
        sb.append("imports=");
        sb.append(this.getImports() == null? "null" : this.getImports().getClass().getSimpleName());
        sb.append(',');
        sb.append("target=");
        sb.append(this.getTarget() == null? "null" : this.getTarget().getClass().getSimpleName());
        sb.append(',');
        sb.append("depends=");
        sb.append(this.getDepends() == null? "null" : this.getDepends().getClass().getSimpleName());
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
        return operation.executeMetaprogramPreambleNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaprogramPreambleNode(
                getImports().deepCopy(factory),
                getTarget().deepCopy(factory),
                getDepends().deepCopy(factory),
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
        
        if (before.equals(this.getImports()) && (after instanceof MetaprogramImportListNode))
        {
            setImports((MetaprogramImportListNode)after);
            return true;
        }
        if (before.equals(this.getTarget()) && (after instanceof MetaprogramTargetNode))
        {
            setTarget((MetaprogramTargetNode)after);
            return true;
        }
        if (before.equals(this.getDepends()) && (after instanceof MetaprogramDependsNode))
        {
            setDepends((MetaprogramDependsNode)after);
            return true;
        }
        return false;
    }
    
}
