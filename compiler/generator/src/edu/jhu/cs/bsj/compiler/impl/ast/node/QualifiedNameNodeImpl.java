package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedNameNodeImpl extends NameNodeImpl implements QualifiedNameNode
{
    /** The name being qualified. */
    private NameNode base;

    /** The identifier used to qualify the base name. */
    private IdentifierNode identifier;

    /** General constructor. */
    public QualifiedNameNodeImpl(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(category, startLocation, stopLocation);
        setBase(base);
        setIdentifier(identifier);
    }

    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NameNode getBase()
    {
        return this.base;
    }

    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base)
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
     * Gets the identifier used to qualify the base name.
     * @return The identifier used to qualify the base name.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier used to qualify the base name.
     * @param identifier The identifier used to qualify the base name.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
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
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
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
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitQualifiedNameNodeStart(this, true);
        visitor.visitNameNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitNameNodeStop(this);
        visitor.visitQualifiedNameNodeStop(this, true);
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
        list.add(getIdentifier());
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (base == null)
        {
        sb.append("[null]");
        } else
        {
        sb.append(this.base.toString());
        }
        sb.append('.');
        if (identifier == null)
        {
        sb.append("[null]");
        } else
        {
        sb.append(identifier.getIdentifier());
        sb.append('[');
        sb.append(this.getCategory());
        sb.append(']');
        }
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
        return operation.executeQualifiedNameNode(this, p);
    }

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedNameNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeQualifiedNameNode(
                getBase().deepCopy(factory),
                getIdentifier().deepCopy(factory),
                getCategory());
    }
}
