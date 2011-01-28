package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerToolkit;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.MethodNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.TypeNamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.VariableNamespaceMap;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;

/**
 * This class manages the calculation and storage of environments in the type checker. An environment represents
 * namespace mappings on a per-node basis. This manager serves the function of a symbol table generator.
 * 
 * @author Zachary Palmer
 */
public class NamespaceBuilder
{
    /** The node operation which calculates the type namespace for a node. */
    private BsjNodeOperation<Void, NamespaceMap<String, BsjTypeLikeElement>> typeNamespaceCalculatingOperation;
    /** The node operation which calculates the method namespace for a node. */
    private BsjNodeOperation<Void, NamespaceMap<ErasedMethodSignature, BsjExecutableElement>> methodNamespaceCalculatingOperation;
    /** The node operation which calculates the type namespace for a node. */
    private BsjNodeOperation<Void, NamespaceMap<String, BsjVariableElement>> variableNamespaceCalculatingOperation;

    /**
     * Creates a new environment manager.
     * 
     * @param rootPackage The root package in the AST.
     * @param listener The listener to which lookup and declaration errors should be reported.
     * @param toolkit The typechecker toolkit to use to build elements.
     */
    public NamespaceBuilder(PackageNode rootPackage, final DiagnosticListener<BsjSourceLocation> listener,
            CompilationUnitLoader loader, TypecheckerToolkit toolkit)
    {
        super();

        this.typeNamespaceCalculatingOperation = new NamespaceCalculatingOperation<String, BsjTypeLikeElement>(
                new TypeNamespaceModifyingOperation(toolkit, loader, listener));

        this.methodNamespaceCalculatingOperation = new NamespaceCalculatingOperation<ErasedMethodSignature, BsjExecutableElement>(
                new MethodNamespaceModifyingOperation(toolkit, loader, listener));

        this.variableNamespaceCalculatingOperation = new NamespaceCalculatingOperation<String, BsjVariableElement>(
                new VariableNamespaceModifyingOperation(toolkit, loader, listener));
    }

    /**
     * Retrieves a type namespace corresponding to the specified node. Package nodes will never have a corresponding
     * namespace. If the namespace for this node has not yet been calculated, this method will lazily construct it.
     * 
     * @param node The node in question.
     * @return The namespace to use (or <code>null</code> if the node is a package node).
     */
    public NamespaceMap<String, BsjTypeLikeElement> getTypeNamespace(Node node)
    {
        return node.executeOperation(this.typeNamespaceCalculatingOperation, null);
    }

    /**
     * Retrieves a method namespace corresponding to the specified node. Package nodes will never have a corresponding
     * namespace. If the namespace for this node has not yet been calculated, this method will lazily construct it.
     * 
     * @param node The node in question.
     * @return The namespace to use (or <code>null</code> if the node is a package node).
     */
    public NamespaceMap<ErasedMethodSignature, BsjExecutableElement> getMethodNamespace(Node node)
    {
        return node.executeOperation(this.methodNamespaceCalculatingOperation, null);
    }

    /**
     * Retrieves a variable namespace corresponding to the specified node. Package nodes will never have a corresponding
     * namespace. If the namespace for this node has not yet been calculated, this method will lazily construct it.
     * 
     * @param node The node in question.
     * @return The namespace to use (or <code>null</code> if the node is a package node).
     */
    public NamespaceMap<String, BsjVariableElement> getVariableNamespace(Node node)
    {
        return node.executeOperation(this.variableNamespaceCalculatingOperation, null);
    }
}
