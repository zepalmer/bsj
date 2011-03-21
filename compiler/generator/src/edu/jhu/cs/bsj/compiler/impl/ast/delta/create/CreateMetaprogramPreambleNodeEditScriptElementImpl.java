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
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SpliceNode;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.SpliceNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;


@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CreateMetaprogramPreambleNodeEditScriptElementImpl extends AbstractCreateEditScriptElementImpl
{
    private final Long imports;
    private final MetaprogramLocalMode localMode;
    private final MetaprogramPackageMode packageMode;
    private final Long targets;
    private final Long dependencies;
    private final BsjSourceLocation startLocation;
    private final BsjSourceLocation stopLocation;
    
    public CreateMetaprogramPreambleNodeEditScriptElementImpl(
            int metaprogramId,
            long targetId,
            Long imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            Long targets,
            Long dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(metaprogramId, targetId);
        this.imports = imports;
        this.localMode = localMode;
        this.packageMode = packageMode;
        this.targets = targets;
        this.dependencies = dependencies;
        this.startLocation = startLocation;
        this.stopLocation = stopLocation;
        
    }
    
    @Override
    public void apply(PatchState patchState)
    {
        final MetaprogramImportListNode importsNode = 
                (MetaprogramImportListNode)patchState.getNode(this.imports);
        final NodeUnion<? extends MetaprogramImportListNode> imports;
        {
            final NodeUnion<? extends MetaprogramImportListNode> union;
            if (importsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramImportListNode>((SpliceNode)importsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramImportListNode>((MetaprogramImportListNode)importsNode);
            }
            imports = union;
        }
        final MetaprogramLocalMode localMode = this.localMode;
        final MetaprogramPackageMode packageMode = this.packageMode;
        final MetaprogramTargetListNode targetsNode = 
                (MetaprogramTargetListNode)patchState.getNode(this.targets);
        final NodeUnion<? extends MetaprogramTargetListNode> targets;
        {
            final NodeUnion<? extends MetaprogramTargetListNode> union;
            if (targetsNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramTargetListNode>((SpliceNode)targetsNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramTargetListNode>((MetaprogramTargetListNode)targetsNode);
            }
            targets = union;
        }
        final MetaprogramDependencyDeclarationListNode dependenciesNode = 
                (MetaprogramDependencyDeclarationListNode)patchState.getNode(this.dependencies);
        final NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies;
        {
            final NodeUnion<? extends MetaprogramDependencyDeclarationListNode> union;
            if (dependenciesNode instanceof SpliceNode)
            {
                union = new SpliceNodeUnion<MetaprogramDependencyDeclarationListNode>((SpliceNode)dependenciesNode);
            } else 
            {
                union = new NormalNodeUnion<MetaprogramDependencyDeclarationListNode>((MetaprogramDependencyDeclarationListNode)dependenciesNode);
            }
            dependencies = union;
        }
        final BsjSourceLocation startLocation = this.startLocation;
        final BsjSourceLocation stopLocation = this.stopLocation;
        MetaprogramPreambleNode createdNode = patchState.getNodeFactory().makeMetaprogramPreambleNodeWithUnions(imports,
                localMode,
                packageMode,
                targets,
                dependencies,
                startLocation,
                stopLocation);
        patchState.addNode(getTargetId(), createdNode);
    }
    
    @Override
    public Class<MetaprogramPreambleNode> getCreateType()
    {
        return MetaprogramPreambleNode.class;
    }
    
    @Override
    public String toString()
    {
        return "[" + getMetaprogramId() + "]+#" + getTargetId() + ":MetaprogramPreambleNode(" + "imports=" + "#" + imports + "," + "localMode=" + "{" + localMode + "}" + "," + "packageMode=" + "{" + packageMode + "}" + "," + "targets=" + "#" + targets + "," + "dependencies=" + "#" + dependencies + "," + "startLocation=" + "{" + startLocation + "}" + "," + "stopLocation=" + "{" + stopLocation + "}" + ")";
    }
    
    public EditScriptElement translate(TranslationState translationState) throws IllegalArgumentException
    {
        translationState.getInstantiations().add(getTargetId());
        return new CreateMetaprogramPreambleNodeEditScriptElementImpl(
                getMetaprogramId(),
                getTargetId(),
                translateUid(translationState, this.imports),
                this.localMode,
                this.packageMode,
                translateUid(translationState, this.targets),
                translateUid(translationState, this.dependencies),
                this.startLocation,
                this.stopLocation);
    }
    
}
