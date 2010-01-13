package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;

public class CompilationUnitNodeImpl extends NodeImpl implements CompilationUnitNode
{
    /** The package declaration for this unit. */
    private PackageDeclarationNode packageDeclaration;

    /** The imports used in this unit. */
    private ListNode<ImportNode> imports;

    /** The type declarations of this unit. */
    private ListNode<TypeDeclarationNode> typeDecls;

    /** General constructor. */
    public CompilationUnitNodeImpl(
            PackageDeclarationNode packageDeclaration,
            ListNode<ImportNode> imports,
            ListNode<TypeDeclarationNode> typeDecls)
    {
        super();
        this.packageDeclaration = packageDeclaration;
        this.imports = imports;
        this.typeDecls = typeDecls;
    }

    /**
     * Gets the package declaration for this unit.
     * @return The package declaration for this unit.
     */
    public PackageDeclarationNode getPackageDeclaration()
    {
        return this.packageDeclaration;
    }

    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setPackageDeclaration(PackageDeclarationNode packageDeclaration)
    {
        if (this.packageDeclaration instanceof NodeImpl)
        {
            ((NodeImpl)this.packageDeclaration).setParent(null);
        }
        this.packageDeclaration = packageDeclaration;
        if (this.packageDeclaration instanceof NodeImpl)
        {
            ((NodeImpl)this.packageDeclaration).setParent(this);
        }
    }

    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     */
    public ListNode<ImportNode> getImports()
    {
        return this.imports;
    }

    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ListNode<ImportNode> imports)
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
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public ListNode<TypeDeclarationNode> getTypeDecls()
    {
        return this.typeDecls;
    }

    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(ListNode<TypeDeclarationNode> typeDecls)
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
        this.packageDeclaration.receive(visitor);
        this.imports.receive(visitor);
        this.typeDecls.receive(visitor);
    }
}
