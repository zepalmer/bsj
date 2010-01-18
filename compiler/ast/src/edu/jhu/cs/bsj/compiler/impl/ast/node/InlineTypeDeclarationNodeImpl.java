package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InlineTypeDeclarableNode;
import edu.jhu.cs.bsj.compiler.ast.node.InlineTypeDeclarationNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InlineTypeDeclarationNodeImpl extends NodeImpl implements InlineTypeDeclarationNode
{
    /** The type declaration. */
    private InlineTypeDeclarableNode declaration;

    /** General constructor. */
    public InlineTypeDeclarationNodeImpl(
            InlineTypeDeclarableNode declaration)
    {
        super();
        this.declaration = declaration;
    }

    /**
     * Gets the type declaration.
     * @return The type declaration.
     */
    public InlineTypeDeclarableNode getDeclaration()
    {
        return this.declaration;
    }

    /**
     * Changes the type declaration.
     * @param declaration The type declaration.
     */
    public void setDeclaration(InlineTypeDeclarableNode declaration)
    {
        if (this.declaration instanceof NodeImpl)
        {
            ((NodeImpl)this.declaration).setParent(null);
        }
        this.declaration = declaration;
        if (this.declaration instanceof NodeImpl)
        {
            ((NodeImpl)this.declaration).setParent(this);
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
        this.declaration.receive(visitor);
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
        this.declaration.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitInlineTypeDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitInlineTypeDeclarationNodeStart(this, true);
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
        list.add(this.declaration);
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
        sb.append("declaration=");
        sb.append(this.declaration == null? "null" : this.declaration.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
