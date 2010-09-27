package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;

/**
 * Represents a BSJ compilation unit.  The name of the compilation unit is the name of the source file or
 * binary file that represents it (without the extension).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface CompilationUnitNode extends Node
{
    /**
     * Gets the name of the compilation unit.
     * @return The name of the compilation unit.
     */
    public String getName();
    
    /**
     * Gets the package declaration for this unit.
     * @return The package declaration for this unit.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public PackageDeclarationNode getPackageDeclaration() throws ClassCastException;
    
    /**
     * Gets the union object for the package declaration for this unit.
     * @return A union object representing The package declaration for this unit.
     */
    public NodeUnion<? extends PackageDeclarationNode> getUnionForPackageDeclaration();
    
    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setPackageDeclaration(PackageDeclarationNode packageDeclaration);
    
    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForPackageDeclaration(NodeUnion<? extends PackageDeclarationNode> packageDeclaration) throws NullPointerException;
    
    /**
     * Gets the global metaprogram imports used in this unit.
     * @return The global metaprogram imports used in this unit.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramImportListNode getMetaimports() throws ClassCastException;
    
    /**
     * Gets the union object for the global metaprogram imports used in this unit.
     * @return A union object representing The global metaprogram imports used in this unit.
     */
    public NodeUnion<? extends MetaprogramImportListNode> getUnionForMetaimports();
    
    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     */
    public void setMetaimports(MetaprogramImportListNode metaimports);
    
    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMetaimports(NodeUnion<? extends MetaprogramImportListNode> metaimports) throws NullPointerException;
    
    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ImportListNode getImports() throws ClassCastException;
    
    /**
     * Gets the union object for the imports used in this unit.
     * @return A union object representing The imports used in this unit.
     */
    public NodeUnion<? extends ImportListNode> getUnionForImports();
    
    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ImportListNode imports);
    
    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForImports(NodeUnion<? extends ImportListNode> imports) throws NullPointerException;
    
    /**
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeDeclarationListNode getTypeDecls() throws ClassCastException;
    
    /**
     * Gets the union object for the type declarations of this unit.
     * @return A union object representing The type declarations of this unit.
     */
    public NodeUnion<? extends TypeDeclarationListNode> getUnionForTypeDecls();
    
    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(TypeDeclarationListNode typeDecls);
    
    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeDecls(NodeUnion<? extends TypeDeclarationListNode> typeDecls) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CompilationUnitNode deepCopy(BsjNodeFactory factory);
    
}
