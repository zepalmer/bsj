/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.delta.create;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateCompilationUnitNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final String name;
    private final Long packageDeclaration;
    private final Long metaimports;
    private final Long imports;
    private final Long typeDecls;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateCompilationUnitNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            String name,
            Long packageDeclaration,
            Long metaimports,
            Long imports,
            Long typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.name = name;
        this.packageDeclaration = packageDeclaration;
        this.metaimports = metaimports;
        this.imports = imports;
        this.typeDecls = typeDecls;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final String name = this.name;
        final PackageDeclarationNode packageDeclarationNode = 
                (PackageDeclarationNode)patchState.getNode(this.packageDeclaration);
        final NodeUnion<? extends PackageDeclarationNode> packageDeclaration;
        {
            final NodeUnion<? extends PackageDeclarationNode> union;
            if (packageDeclarationNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<PackageDeclarationNode>((SpliceNode)packageDeclarationNode);
            } else 
            {
                union = new NormalNodeUnion<PackageDeclarationNode>((PackageDeclarationNode)packageDeclarationNode);
            }
            packageDeclaration = union;
        }
        final MetaprogramImportListNode metaimportsNode = 
                (MetaprogramImportListNode)patchState.getNode(this.metaimports);
        final NodeUnion<? extends MetaprogramImportListNode> metaimports;
        {
            final NodeUnion<? extends MetaprogramImportListNode> union;
            if (metaimportsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramImportListNode>((SpliceNode)metaimportsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramImportListNode>((MetaprogramImportListNode)metaimportsNode);
            }
            metaimports = union;
        }
        final ImportListNode importsNode = 
                (ImportListNode)patchState.getNode(this.imports);
        final NodeUnion<? extends ImportListNode> imports;
        {
            final NodeUnion<? extends ImportListNode> union;
            if (importsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<ImportListNode>((SpliceNode)importsNode);
            } else 
            {
                union = new NormalNodeUnion<ImportListNode>((ImportListNode)importsNode);
            }
            imports = union;
        }
        final TypeDeclarationListNode typeDeclsNode = 
                (TypeDeclarationListNode)patchState.getNode(this.typeDecls);
        final NodeUnion<? extends TypeDeclarationListNode> typeDecls;
        {
            final NodeUnion<? extends TypeDeclarationListNode> union;
            if (typeDeclsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<TypeDeclarationListNode>((SpliceNode)typeDeclsNode);
            } else 
            {
                union = new NormalNodeUnion<TypeDeclarationListNode>((TypeDeclarationListNode)typeDeclsNode);
            }
            typeDecls = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        CompilationUnitNode createdNode = patchState.getNodeFactory().makeCompilationUnitNodeWithUnions(name,
                packageDeclaration,
                metaimports,
                imports,
                typeDecls,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<CompilationUnitNode> getCreateType()
    {
        return CompilationUnitNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":CompilationUnitNode(" + "name=" + "{" + name + "}" + "," + "packageDeclaration=" + "#" + packageDeclaration + "," + "metaimports=" + "#" + metaimports + "," + "imports=" + "#" + imports + "," + "typeDecls=" + "#" + typeDecls + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateCompilationUnitNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                this.name,
                translateUid(translationState, this.packageDeclaration),
                translateUid(translationState, this.metaimports),
                translateUid(translationState, this.imports),
                translateUid(translationState, this.typeDecls),
                this.startLocation,
                this.stopLocation);
    }
    
}
