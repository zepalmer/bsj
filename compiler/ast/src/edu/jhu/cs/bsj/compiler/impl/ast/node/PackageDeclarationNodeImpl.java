package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;

public class PackageDeclarationNodeImpl extends NodeImpl implements PackageDeclarationNode
{
    /** The qualified name indicating the package. */
    private QualifiedNameNode name;

    /** The annotations on the package declaration. */
    private ListNode<? extends AnnotationNode> annotations;

    /** General constructor. */
    public PackageDeclarationNodeImpl(
            QualifiedNameNode name,
            ListNode<? extends AnnotationNode> annotations)
    {
        super();
        this.name = name;
        this.annotations = annotations;
    }

    /**
     * Gets the qualified name indicating the package.
     * @return The qualified name indicating the package.
     */
    public QualifiedNameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the qualified name indicating the package.
     * @param name The qualified name indicating the package.
     */
    public void setName(QualifiedNameNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
        }
    }

    /**
     * Gets the annotations on the package declaration.
     * @return The annotations on the package declaration.
     */
    public ListNode<? extends AnnotationNode> getAnnotations()
    {
        return this.annotations;
    }

    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(ListNode<? extends AnnotationNode> annotations)
    {
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(null);
        }
        this.annotations = annotations;
        if (this.annotations instanceof NodeImpl)
        {
            ((NodeImpl)this.annotations).setParent(this);
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
        this.name.receive(visitor);
        this.annotations.receive(visitor);
    }
}
