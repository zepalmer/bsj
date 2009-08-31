package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;

public class CompilationUnitNodeImpl extends NodeImpl implements CompilationUnitNode
{
    /** The imports used in this unit. */
    private ListNode<? extends ImportNode> imports;

    /** The annotations on the package declaration of this unit. */
    private ListNode<? extends AnnotationNode> packageAnnotations;

    /** The name of the package for this unit. */
    private ExpressionNode packageName;

    /** The type declarations of this unit. */
    private ListNode<? extends TypeDeclarationNode> typeDecls;

    /** General constructor. */
    public CompilationUnitNodeImpl(
            ListNode<? extends ImportNode> imports,
            ListNode<? extends AnnotationNode> packageAnnotations,
            ExpressionNode packageName,
            ListNode<? extends TypeDeclarationNode> typeDecls)
    {
        super();
        this.imports = imports;
        this.packageAnnotations = packageAnnotations;
        this.packageName = packageName;
        this.typeDecls = typeDecls;
    }

    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     */
    public ListNode<? extends ImportNode> getImports()
    {
        return this.imports;
    }

    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ListNode<? extends ImportNode> imports)
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
     * Gets the annotations on the package declaration of this unit.
     * @return The annotations on the package declaration of this unit.
     */
    public ListNode<? extends AnnotationNode> getPackageAnnotations()
    {
        return this.packageAnnotations;
    }

    /**
     * Changes the annotations on the package declaration of this unit.
     * @param packageAnnotations The annotations on the package declaration of this unit.
     */
    public void setPackageAnnotations(ListNode<? extends AnnotationNode> packageAnnotations)
    {
        if (this.packageAnnotations instanceof NodeImpl)
        {
            ((NodeImpl)this.packageAnnotations).setParent(null);
        }
        this.packageAnnotations = packageAnnotations;
        if (this.packageAnnotations instanceof NodeImpl)
        {
            ((NodeImpl)this.packageAnnotations).setParent(this);
        }
    }

    /**
     * Gets the name of the package for this unit.
     * @return The name of the package for this unit.
     */
    public ExpressionNode getPackageName()
    {
        return this.packageName;
    }

    /**
     * Changes the name of the package for this unit.
     * @param packageName The name of the package for this unit.
     */
    public void setPackageName(ExpressionNode packageName)
    {
        if (this.packageName instanceof NodeImpl)
        {
            ((NodeImpl)this.packageName).setParent(null);
        }
        this.packageName = packageName;
        if (this.packageName instanceof NodeImpl)
        {
            ((NodeImpl)this.packageName).setParent(this);
        }
    }

    /**
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public ListNode<? extends TypeDeclarationNode> getTypeDecls()
    {
        return this.typeDecls;
    }

    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(ListNode<? extends TypeDeclarationNode> typeDecls)
    {
        if (this.typeDecls instanceof NodeImpl)
        {
            ((NodeImpl)this.typeDecls).setParent(null);
        }
        this.typeDecls = typeDecls;
        if (this.typeDecls instanceof NodeImpl)
        {
            ((NodeImpl)this.typeDecls).setParent(this);
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
        this.imports.receive(visitor);
        this.packageAnnotations.receive(visitor);
        this.packageName.receive(visitor);
        this.typeDecls.receive(visitor);
    }
}
