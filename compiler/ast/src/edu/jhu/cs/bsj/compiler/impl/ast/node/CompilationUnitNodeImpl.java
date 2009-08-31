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
        this.imports = imports;
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
        this.packageAnnotations = packageAnnotations;
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
        this.packageName = packageName;
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
        this.typeDecls = typeDecls;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
