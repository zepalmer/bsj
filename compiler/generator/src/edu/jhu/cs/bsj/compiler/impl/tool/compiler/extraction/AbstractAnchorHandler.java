package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.operations.EnclosingNameNodeOperation;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

public abstract class AbstractAnchorHandler<A extends MetaprogramAnchorNode<B>, B extends Node> implements
        AnchorHandler<A, B>
{
    private BsjToolkit toolkit;
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;
    private A targetAnchor;
    private A canonicalAnchor;
    private InjectionInfo injectionInfo;

    public AbstractAnchorHandler(BsjToolkit toolkit, DiagnosticListener<BsjSourceLocation> diagnosticListener,
            A targetAnchor, A canonicalAnchor, InjectionInfo injectionInfo)
    {
        super();
        this.toolkit = toolkit;
        this.diagnosticListener = diagnosticListener;
        this.targetAnchor = targetAnchor;
        this.canonicalAnchor = canonicalAnchor;
        this.injectionInfo = injectionInfo;
    }

    /**
     * Retrieves the name of the type surrounding the metaprogram.
     * 
     * @return The fully-qualified name of the type surrounding the metaprogram.
     */
    protected String getMetaprogramTypeName()
    {
        NameNode nameNode = getTargetAnchor().executeOperation(new EnclosingNameNodeOperation(getFactory()), null);
        if (nameNode == null)
        {
            // TODO: handle anonymous inner classes correctly
            nameNode = getFactory().makeSimpleNameNode(
                    getFactory().makeIdentifierNode(
                            getTargetAnchor().getNearestAncestorOfType(CompilationUnitNode.class).getName()));
        } else
        {
            Node node = getTargetAnchor();
            while (node != null && !(node instanceof CompilationUnitNode) && !(node instanceof TypeDeclarationNode))
            {
                node = node.getParent();
            }
            boolean isTopLevelMetaprogram = (node instanceof CompilationUnitNode);
            if (isTopLevelMetaprogram)
            {
                nameNode = getFactory().makeQualifiedNameNode(
                        nameNode,
                        getFactory().makeIdentifierNode(
                                getTargetAnchor().getNearestAncestorOfType(CompilationUnitNode.class).getName()));
            }
        }
        return nameNode.getNameString();
    }

    protected BsjNodeFactory getFactory()
    {
        return this.toolkit.getNodeFactory();
    }

    protected BsjToolkit getToolkit()
    {
        return toolkit;
    }

    protected DiagnosticListener<BsjSourceLocation> getDiagnosticListener()
    {
        return diagnosticListener;
    }

    public A getTargetAnchor()
    {
        return targetAnchor;
    }

    public A getCanonicalAnchor()
    {
        return canonicalAnchor;
    }

    protected InjectionInfo getInjectionInfo()
    {
        return injectionInfo;
    }
}
