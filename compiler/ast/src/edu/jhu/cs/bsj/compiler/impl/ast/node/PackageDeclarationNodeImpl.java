package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;

public class PackageDeclarationNodeImpl extends NodeImpl implements PackageDeclarationNode
{
    /** The name of the package. */
    private NameNode name;

    /** The annotations on the package declaration. */
    private ListNode<AnnotationNode> annotations;

    /** General constructor. */
    public PackageDeclarationNodeImpl(
            NameNode name,
            ListNode<AnnotationNode> annotations)
    {
        super();
        this.name = name;
        this.annotations = annotations;
    }

    /**
     * Gets the name of the package.
     * @return The name of the package.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the package.
     * @param name The name of the package.
     */
    public void setName(NameNode name)
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
    public ListNode<AnnotationNode> getAnnotations()
    {
        return this.annotations;
    }

    /**
     * Changes the annotations on the package declaration.
     * @param annotations The annotations on the package declaration.
     */
    public void setAnnotations(ListNode<AnnotationNode> annotations)
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.name);
        list.add(this.annotations);
        return list;
    }
}
