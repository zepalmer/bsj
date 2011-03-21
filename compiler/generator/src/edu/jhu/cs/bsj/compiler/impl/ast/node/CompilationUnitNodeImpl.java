package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.CompilationUnitNodeSetImportsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.CompilationUnitNodeSetMetaimportsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.CompilationUnitNodeSetPackageDeclarationPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.CompilationUnitNodeSetTypeDeclsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.CompilationUnitNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CompilationUnitNodeImpl extends NodeImpl implements CompilationUnitNode
{
    /** The name of the compilation unit. */
    private String name;
    
    /** The package declaration for this unit. */
    private NodeUnion<? extends PackageDeclarationNode> packageDeclaration;
    
    /** The global metaprogram imports used in this unit. */
    private NodeUnion<? extends MetaprogramImportListNode> metaimports;
    
    /** The imports used in this unit. */
    private NodeUnion<? extends ImportListNode> imports;
    
    /** The type declarations of this unit. */
    private NodeUnion<? extends TypeDeclarationListNode> typeDecls;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<CompilationUnitNodeProperties> populatedProperties;
    
    /** General constructor. */
    public CompilationUnitNodeImpl(
            String name,
            NodeUnion<? extends PackageDeclarationNode> packageDeclaration,
            NodeUnion<? extends MetaprogramImportListNode> metaimports,
            NodeUnion<? extends ImportListNode> imports,
            NodeUnion<? extends TypeDeclarationListNode> typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetName(name);
        doSetPackageDeclaration(packageDeclaration);
        doSetMetaimports(metaimports);
        doSetImports(imports);
        doSetTypeDecls(typeDecls);
    }
    
    /** Proxy constructor. */
    public CompilationUnitNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, CompilationUnitNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(CompilationUnitNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected CompilationUnitNode getBackingNode()
    {
        return (CompilationUnitNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the name value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkNameWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                CompilationUnitNodeProperties.NAME))
            return;
        this.populatedProperties.add(CompilationUnitNodeProperties.NAME);
        this.name = this.getBackingNode().getName();
    }
    
    /**
     * Ensures that the packageDeclaration value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkPackageDeclarationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                CompilationUnitNodeProperties.PACKAGE_DECLARATION))
            return;
        this.populatedProperties.add(CompilationUnitNodeProperties.PACKAGE_DECLARATION);
        NodeUnion<? extends PackageDeclarationNode> union = this.getBackingNode().getUnionForPackageDeclaration();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makePackageDeclarationNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.packageDeclaration = union;
    }
    
    /**
     * Ensures that the metaimports value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMetaimportsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                CompilationUnitNodeProperties.METAIMPORTS))
            return;
        this.populatedProperties.add(CompilationUnitNodeProperties.METAIMPORTS);
        NodeUnion<? extends MetaprogramImportListNode> union = this.getBackingNode().getUnionForMetaimports();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaprogramImportListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.metaimports = union;
    }
    
    /**
     * Ensures that the imports value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkImportsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                CompilationUnitNodeProperties.IMPORTS))
            return;
        this.populatedProperties.add(CompilationUnitNodeProperties.IMPORTS);
        NodeUnion<? extends ImportListNode> union = this.getBackingNode().getUnionForImports();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeImportListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.imports = union;
    }
    
    /**
     * Ensures that the typeDecls value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeDeclsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                CompilationUnitNodeProperties.TYPE_DECLS))
            return;
        this.populatedProperties.add(CompilationUnitNodeProperties.TYPE_DECLS);
        NodeUnion<? extends TypeDeclarationListNode> union = this.getBackingNode().getUnionForTypeDecls();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeDeclarationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.typeDecls = union;
    }
    
    /**
     * Gets the name of the compilation unit.
     * @return The name of the compilation unit.
     */
    public String getName()
    {
        checkNameWrapped();
        return this.name;
    }
    
    private void doSetName(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets the package declaration for this unit.  This property's value is assumed to be a normal node.
     * @return The package declaration for this unit.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public PackageDeclarationNode getPackageDeclaration()
    {
        checkPackageDeclarationWrapped();
        if (this.packageDeclaration == null)
        {
            return null;
        } else
        {
            return this.packageDeclaration.getNormalNode();
        }
    }
    
    /**
     * Gets the package declaration for this unit.
     * @return The package declaration for this unit.
     */
    public NodeUnion<? extends PackageDeclarationNode> getUnionForPackageDeclaration()
    {
        checkPackageDeclarationWrapped();
        if (this.packageDeclaration == null)
        {
            this.packageDeclaration = new NormalNodeUnion<PackageDeclarationNode>(null);
        }
        return this.packageDeclaration;
    }
    
    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setPackageDeclaration(PackageDeclarationNode packageDeclaration)
    {
        checkPackageDeclarationWrapped();
        this.setUnionForPackageDeclaration(new NormalNodeUnion<PackageDeclarationNode>(packageDeclaration));
    }
    
    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setUnionForPackageDeclaration(NodeUnion<? extends PackageDeclarationNode> packageDeclaration)
    {
        checkPackageDeclarationWrapped();
        this.getManager().assertMutatable(this);
        this.doSetPackageDeclaration(packageDeclaration);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new CompilationUnitNodeSetPackageDeclarationPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), packageDeclaration.getNodeValue() == null ? null : packageDeclaration.getNodeValue().getUid()));
    }
    
    private void doSetPackageDeclaration(NodeUnion<? extends PackageDeclarationNode> packageDeclaration)
    {
        if (packageDeclaration == null)
        {
            packageDeclaration = new NormalNodeUnion<PackageDeclarationNode>(null);
        }
        if (this.packageDeclaration != null)
        {
            setAsChild(this.packageDeclaration.getNodeValue(), false);
        }
        this.packageDeclaration = packageDeclaration;
        setAsChild(packageDeclaration.getNodeValue(), true);
    }
    
    /**
     * Gets the global metaprogram imports used in this unit.  This property's value is assumed to be a normal node.
     * @return The global metaprogram imports used in this unit.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramImportListNode getMetaimports()
    {
        checkMetaimportsWrapped();
        if (this.metaimports == null)
        {
            return null;
        } else
        {
            return this.metaimports.getNormalNode();
        }
    }
    
    /**
     * Gets the global metaprogram imports used in this unit.
     * @return The global metaprogram imports used in this unit.
     */
    public NodeUnion<? extends MetaprogramImportListNode> getUnionForMetaimports()
    {
        checkMetaimportsWrapped();
        if (this.metaimports == null)
        {
            this.metaimports = new NormalNodeUnion<MetaprogramImportListNode>(null);
        }
        return this.metaimports;
    }
    
    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     */
    public void setMetaimports(MetaprogramImportListNode metaimports)
    {
        checkMetaimportsWrapped();
        this.setUnionForMetaimports(new NormalNodeUnion<MetaprogramImportListNode>(metaimports));
    }
    
    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     */
    public void setUnionForMetaimports(NodeUnion<? extends MetaprogramImportListNode> metaimports)
    {
        checkMetaimportsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMetaimports(metaimports);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new CompilationUnitNodeSetMetaimportsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), metaimports.getNodeValue() == null ? null : metaimports.getNodeValue().getUid()));
    }
    
    private void doSetMetaimports(NodeUnion<? extends MetaprogramImportListNode> metaimports)
    {
        if (metaimports == null)
        {
            metaimports = new NormalNodeUnion<MetaprogramImportListNode>(null);
        }
        if (this.metaimports != null)
        {
            setAsChild(this.metaimports.getNodeValue(), false);
        }
        this.metaimports = metaimports;
        setAsChild(metaimports.getNodeValue(), true);
    }
    
    /**
     * Gets the imports used in this unit.  This property's value is assumed to be a normal node.
     * @return The imports used in this unit.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ImportListNode getImports()
    {
        checkImportsWrapped();
        if (this.imports == null)
        {
            return null;
        } else
        {
            return this.imports.getNormalNode();
        }
    }
    
    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     */
    public NodeUnion<? extends ImportListNode> getUnionForImports()
    {
        checkImportsWrapped();
        if (this.imports == null)
        {
            this.imports = new NormalNodeUnion<ImportListNode>(null);
        }
        return this.imports;
    }
    
    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ImportListNode imports)
    {
        checkImportsWrapped();
        this.setUnionForImports(new NormalNodeUnion<ImportListNode>(imports));
    }
    
    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setUnionForImports(NodeUnion<? extends ImportListNode> imports)
    {
        checkImportsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetImports(imports);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new CompilationUnitNodeSetImportsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()));
    }
    
    private void doSetImports(NodeUnion<? extends ImportListNode> imports)
    {
        if (imports == null)
        {
            imports = new NormalNodeUnion<ImportListNode>(null);
        }
        if (this.imports != null)
        {
            setAsChild(this.imports.getNodeValue(), false);
        }
        this.imports = imports;
        setAsChild(imports.getNodeValue(), true);
    }
    
    /**
     * Gets the type declarations of this unit.  This property's value is assumed to be a normal node.
     * @return The type declarations of this unit.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeDeclarationListNode getTypeDecls()
    {
        checkTypeDeclsWrapped();
        if (this.typeDecls == null)
        {
            return null;
        } else
        {
            return this.typeDecls.getNormalNode();
        }
    }
    
    /**
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public NodeUnion<? extends TypeDeclarationListNode> getUnionForTypeDecls()
    {
        checkTypeDeclsWrapped();
        if (this.typeDecls == null)
        {
            this.typeDecls = new NormalNodeUnion<TypeDeclarationListNode>(null);
        }
        return this.typeDecls;
    }
    
    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(TypeDeclarationListNode typeDecls)
    {
        checkTypeDeclsWrapped();
        this.setUnionForTypeDecls(new NormalNodeUnion<TypeDeclarationListNode>(typeDecls));
    }
    
    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setUnionForTypeDecls(NodeUnion<? extends TypeDeclarationListNode> typeDecls)
    {
        checkTypeDeclsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeDecls(typeDecls);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new CompilationUnitNodeSetTypeDeclsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeDecls.getNodeValue() == null ? null : typeDecls.getNodeValue().getUid()));
    }
    
    private void doSetTypeDecls(NodeUnion<? extends TypeDeclarationListNode> typeDecls)
    {
        if (typeDecls == null)
        {
            typeDecls = new NormalNodeUnion<TypeDeclarationListNode>(null);
        }
        if (this.typeDecls != null)
        {
            setAsChild(this.typeDecls.getNodeValue(), false);
        }
        this.typeDecls = typeDecls;
        setAsChild(typeDecls.getNodeValue(), true);
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
        if (this.getUnionForPackageDeclaration().getNodeValue() != null)
        {
            this.getUnionForPackageDeclaration().getNodeValue().receive(visitor);
        }
        if (this.getUnionForMetaimports().getNodeValue() != null)
        {
            this.getUnionForMetaimports().getNodeValue().receive(visitor);
        }
        if (this.getUnionForImports().getNodeValue() != null)
        {
            this.getUnionForImports().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTypeDecls().getNodeValue() != null)
        {
            this.getUnionForTypeDecls().getNodeValue().receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.getUnionForPackageDeclaration().getNodeValue() != null)
        {
            this.getUnionForPackageDeclaration().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForMetaimports().getNodeValue() != null)
        {
            this.getUnionForMetaimports().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForImports().getNodeValue() != null)
        {
            this.getUnionForImports().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTypeDecls().getNodeValue() != null)
        {
            this.getUnionForTypeDecls().getNodeValue().receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitCompilationUnitNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitCompilationUnitNodeStop(this, true);
        visitor.visitStopEnd(this);
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
        list.add(getName());
        list.add(getUnionForPackageDeclaration());
        list.add(getUnionForMetaimports());
        list.add(getUnionForImports());
        list.add(getUnionForTypeDecls());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForPackageDeclaration().getNodeValue(), getUnionForMetaimports().getNodeValue(), getUnionForImports().getNodeValue(), getUnionForTypeDecls().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("name=");
        sb.append(String.valueOf(this.getName()) + ":" + (this.getName() != null ? this.getName().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("packageDeclaration=");
        sb.append(this.getUnionForPackageDeclaration().getNodeValue() == null? "null" : this.getUnionForPackageDeclaration().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaimports=");
        sb.append(this.getUnionForMetaimports().getNodeValue() == null? "null" : this.getUnionForMetaimports().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("imports=");
        sb.append(this.getUnionForImports().getNodeValue() == null? "null" : this.getUnionForImports().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeDecls=");
        sb.append(this.getUnionForTypeDecls().getNodeValue() == null? "null" : this.getUnionForTypeDecls().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeCompilationUnitNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
    {
        return operation.executeCompilationUnitNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CompilationUnitNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends PackageDeclarationNode> packageDeclarationCopy;
        switch (getUnionForPackageDeclaration().getType())
        {
            case NORMAL:
                if (getUnionForPackageDeclaration().getNormalNode() == null)
                {
                    packageDeclarationCopy = factory.<PackageDeclarationNode>makeNormalNodeUnion(null);
                } else
                {
                    packageDeclarationCopy = factory.makeNormalNodeUnion(getUnionForPackageDeclaration().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForPackageDeclaration().getSpliceNode() == null)
                {
                    packageDeclarationCopy = factory.<PackageDeclarationNode>makeSpliceNodeUnion(null);
                } else
                {
                    packageDeclarationCopy = factory.makeSpliceNodeUnion(getUnionForPackageDeclaration().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForPackageDeclaration().getType());
        }
        NodeUnion<? extends MetaprogramImportListNode> metaimportsCopy;
        switch (getUnionForMetaimports().getType())
        {
            case NORMAL:
                if (getUnionForMetaimports().getNormalNode() == null)
                {
                    metaimportsCopy = factory.<MetaprogramImportListNode>makeNormalNodeUnion(null);
                } else
                {
                    metaimportsCopy = factory.makeNormalNodeUnion(getUnionForMetaimports().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMetaimports().getSpliceNode() == null)
                {
                    metaimportsCopy = factory.<MetaprogramImportListNode>makeSpliceNodeUnion(null);
                } else
                {
                    metaimportsCopy = factory.makeSpliceNodeUnion(getUnionForMetaimports().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMetaimports().getType());
        }
        NodeUnion<? extends ImportListNode> importsCopy;
        switch (getUnionForImports().getType())
        {
            case NORMAL:
                if (getUnionForImports().getNormalNode() == null)
                {
                    importsCopy = factory.<ImportListNode>makeNormalNodeUnion(null);
                } else
                {
                    importsCopy = factory.makeNormalNodeUnion(getUnionForImports().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForImports().getSpliceNode() == null)
                {
                    importsCopy = factory.<ImportListNode>makeSpliceNodeUnion(null);
                } else
                {
                    importsCopy = factory.makeSpliceNodeUnion(getUnionForImports().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForImports().getType());
        }
        NodeUnion<? extends TypeDeclarationListNode> typeDeclsCopy;
        switch (getUnionForTypeDecls().getType())
        {
            case NORMAL:
                if (getUnionForTypeDecls().getNormalNode() == null)
                {
                    typeDeclsCopy = factory.<TypeDeclarationListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeDeclsCopy = factory.makeNormalNodeUnion(getUnionForTypeDecls().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeDecls().getSpliceNode() == null)
                {
                    typeDeclsCopy = factory.<TypeDeclarationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeDeclsCopy = factory.makeSpliceNodeUnion(getUnionForTypeDecls().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeDecls().getType());
        }
        return factory.makeCompilationUnitNodeWithUnions(
                getName(),
                packageDeclarationCopy,
                metaimportsCopy,
                importsCopy,
                typeDeclsCopy,
                getStartLocation(),
                getStopLocation());
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getUnionForPackageDeclaration().getNodeValue()))
        {
            setPackageDeclaration((PackageDeclarationNode)after);
            return true;
        }
        if (before.equals(this.getUnionForMetaimports().getNodeValue()))
        {
            setMetaimports((MetaprogramImportListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForImports().getNodeValue()))
        {
            setImports((ImportListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeDecls().getNodeValue()))
        {
            setTypeDecls((TypeDeclarationListNode)after);
            return true;
        }
        return false;
    }
    
}
