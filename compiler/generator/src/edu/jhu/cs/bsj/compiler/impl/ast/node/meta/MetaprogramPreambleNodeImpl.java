package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramPreambleNodeSetDependenciesPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramPreambleNodeSetImportsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramPreambleNodeSetLocalModePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramPreambleNodeSetPackageModePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramPreambleNodeSetTargetsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaprogramPreambleNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPreambleNodeImpl extends NodeImpl implements MetaprogramPreambleNode
{
    /** The imports for this metaprogram. */
    private NodeUnion<? extends MetaprogramImportListNode> imports;
    
    /** The metaprogram local mode. */
    private MetaprogramLocalMode localMode;
    
    /** The metaprogram package mode. */
    private MetaprogramPackageMode packageMode;
    
    /** The targets for this metaprogram. */
    private NodeUnion<? extends MetaprogramTargetListNode> targets;
    
    /** The dependencies for this metaprogram. */
    private NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaprogramPreambleNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MetaprogramPreambleNodeImpl(
            NodeUnion<? extends MetaprogramImportListNode> imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            NodeUnion<? extends MetaprogramTargetListNode> targets,
            NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetImports(imports);
        doSetLocalMode(localMode);
        doSetPackageMode(packageMode);
        doSetTargets(targets);
        doSetDependencies(dependencies);
    }
    
    /** Proxy constructor. */
    public MetaprogramPreambleNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaprogramPreambleNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaprogramPreambleNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaprogramPreambleNode getBackingNode()
    {
        return (MetaprogramPreambleNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the imports value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkImportsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramPreambleNodeProperties.IMPORTS))
            return;
        this.populatedProperties.add(MetaprogramPreambleNodeProperties.IMPORTS);
        NodeUnion<? extends MetaprogramImportListNode> union = this.getBackingNode().getUnionForImports();
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
        this.imports = union;
    }
    
    /**
     * Ensures that the localMode value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkLocalModeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramPreambleNodeProperties.LOCAL_MODE))
            return;
        this.populatedProperties.add(MetaprogramPreambleNodeProperties.LOCAL_MODE);
        this.localMode = this.getBackingNode().getLocalMode();
    }
    
    /**
     * Ensures that the packageMode value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkPackageModeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramPreambleNodeProperties.PACKAGE_MODE))
            return;
        this.populatedProperties.add(MetaprogramPreambleNodeProperties.PACKAGE_MODE);
        this.packageMode = this.getBackingNode().getPackageMode();
    }
    
    /**
     * Ensures that the targets value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTargetsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramPreambleNodeProperties.TARGETS))
            return;
        this.populatedProperties.add(MetaprogramPreambleNodeProperties.TARGETS);
        NodeUnion<? extends MetaprogramTargetListNode> union = this.getBackingNode().getUnionForTargets();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaprogramTargetListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.targets = union;
    }
    
    /**
     * Ensures that the dependencies value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkDependenciesWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramPreambleNodeProperties.DEPENDENCIES))
            return;
        this.populatedProperties.add(MetaprogramPreambleNodeProperties.DEPENDENCIES);
        NodeUnion<? extends MetaprogramDependencyDeclarationListNode> union = this.getBackingNode().getUnionForDependencies();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaprogramDependencyDeclarationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.dependencies = union;
    }
    
    /**
     * Gets the imports for this metaprogram.  This property's value is assumed to be a normal node.
     * @return The imports for this metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramImportListNode getImports()
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
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramImportListNode> getUnionForImports()
    {
        checkImportsWrapped();
        if (this.imports == null)
        {
            this.imports = new NormalNodeUnion<MetaprogramImportListNode>(null);
        }
        return this.imports;
    }
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports)
    {
        checkImportsWrapped();
        this.setUnionForImports(new NormalNodeUnion<MetaprogramImportListNode>(imports));
    }
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setUnionForImports(NodeUnion<? extends MetaprogramImportListNode> imports)
    {
        checkImportsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetImports(imports);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramPreambleNodeSetImportsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), imports.getNodeValue() == null ? null : imports.getNodeValue().getUid()));
    }
    
    private void doSetImports(NodeUnion<? extends MetaprogramImportListNode> imports)
    {
        if (imports == null)
        {
            imports = new NormalNodeUnion<MetaprogramImportListNode>(null);
        }
        if (this.imports != null)
        {
            setAsChild(this.imports.getNodeValue(), false);
        }
        this.imports = imports;
        setAsChild(imports.getNodeValue(), true);
    }
    
    /**
     * Gets the metaprogram local mode.
     * @return The metaprogram local mode.
     */
    public MetaprogramLocalMode getLocalMode()
    {
        checkLocalModeWrapped();
        return this.localMode;
    }
    
    /**
     * Changes the metaprogram local mode.
     * @param localMode The metaprogram local mode.
     */
    public void setLocalMode(MetaprogramLocalMode localMode)
    {
        checkLocalModeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetLocalMode(localMode);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramPreambleNodeSetLocalModePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), localMode));
    }
    
    private void doSetLocalMode(MetaprogramLocalMode localMode)
    {
        this.localMode = localMode;
    }
    
    /**
     * Gets the metaprogram package mode.
     * @return The metaprogram package mode.
     */
    public MetaprogramPackageMode getPackageMode()
    {
        checkPackageModeWrapped();
        return this.packageMode;
    }
    
    /**
     * Changes the metaprogram package mode.
     * @param packageMode The metaprogram package mode.
     */
    public void setPackageMode(MetaprogramPackageMode packageMode)
    {
        checkPackageModeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetPackageMode(packageMode);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramPreambleNodeSetPackageModePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), packageMode));
    }
    
    private void doSetPackageMode(MetaprogramPackageMode packageMode)
    {
        this.packageMode = packageMode;
    }
    
    /**
     * Gets the targets for this metaprogram.  This property's value is assumed to be a normal node.
     * @return The targets for this metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramTargetListNode getTargets()
    {
        checkTargetsWrapped();
        if (this.targets == null)
        {
            return null;
        } else
        {
            return this.targets.getNormalNode();
        }
    }
    
    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramTargetListNode> getUnionForTargets()
    {
        checkTargetsWrapped();
        if (this.targets == null)
        {
            this.targets = new NormalNodeUnion<MetaprogramTargetListNode>(null);
        }
        return this.targets;
    }
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     */
    public void setTargets(MetaprogramTargetListNode targets)
    {
        checkTargetsWrapped();
        this.setUnionForTargets(new NormalNodeUnion<MetaprogramTargetListNode>(targets));
    }
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     */
    public void setUnionForTargets(NodeUnion<? extends MetaprogramTargetListNode> targets)
    {
        checkTargetsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTargets(targets);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramPreambleNodeSetTargetsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()));
    }
    
    private void doSetTargets(NodeUnion<? extends MetaprogramTargetListNode> targets)
    {
        if (targets == null)
        {
            targets = new NormalNodeUnion<MetaprogramTargetListNode>(null);
        }
        if (this.targets != null)
        {
            setAsChild(this.targets.getNodeValue(), false);
        }
        this.targets = targets;
        setAsChild(targets.getNodeValue(), true);
    }
    
    /**
     * Gets the dependencies for this metaprogram.  This property's value is assumed to be a normal node.
     * @return The dependencies for this metaprogram.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaprogramDependencyDeclarationListNode getDependencies()
    {
        checkDependenciesWrapped();
        if (this.dependencies == null)
        {
            return null;
        } else
        {
            return this.dependencies.getNormalNode();
        }
    }
    
    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramDependencyDeclarationListNode> getUnionForDependencies()
    {
        checkDependenciesWrapped();
        if (this.dependencies == null)
        {
            this.dependencies = new NormalNodeUnion<MetaprogramDependencyDeclarationListNode>(null);
        }
        return this.dependencies;
    }
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     */
    public void setDependencies(MetaprogramDependencyDeclarationListNode dependencies)
    {
        checkDependenciesWrapped();
        this.setUnionForDependencies(new NormalNodeUnion<MetaprogramDependencyDeclarationListNode>(dependencies));
    }
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     */
    public void setUnionForDependencies(NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies)
    {
        checkDependenciesWrapped();
        this.getManager().assertMutatable(this);
        this.doSetDependencies(dependencies);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramPreambleNodeSetDependenciesPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), dependencies.getNodeValue() == null ? null : dependencies.getNodeValue().getUid()));
    }
    
    private void doSetDependencies(NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependencies)
    {
        if (dependencies == null)
        {
            dependencies = new NormalNodeUnion<MetaprogramDependencyDeclarationListNode>(null);
        }
        if (this.dependencies != null)
        {
            setAsChild(this.dependencies.getNodeValue(), false);
        }
        this.dependencies = dependencies;
        setAsChild(dependencies.getNodeValue(), true);
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
        if (this.getUnionForImports().getNodeValue() != null)
        {
            this.getUnionForImports().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTargets().getNodeValue() != null)
        {
            this.getUnionForTargets().getNodeValue().receive(visitor);
        }
        if (this.getUnionForDependencies().getNodeValue() != null)
        {
            this.getUnionForDependencies().getNodeValue().receive(visitor);
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
        if (this.getUnionForImports().getNodeValue() != null)
        {
            this.getUnionForImports().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTargets().getNodeValue() != null)
        {
            this.getUnionForTargets().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForDependencies().getNodeValue() != null)
        {
            this.getUnionForDependencies().getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramPreambleNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramPreambleNodeStop(this, true);
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
        list.add(getUnionForImports());
        list.add(getLocalMode());
        list.add(getPackageMode());
        list.add(getUnionForTargets());
        list.add(getUnionForDependencies());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForImports().getNodeValue(), getUnionForTargets().getNodeValue(), getUnionForDependencies().getNodeValue()});
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
        sb.append("imports=");
        sb.append(this.getUnionForImports().getNodeValue() == null? "null" : this.getUnionForImports().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("localMode=");
        sb.append(String.valueOf(this.getLocalMode()) + ":" + (this.getLocalMode() != null ? this.getLocalMode().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("packageMode=");
        sb.append(String.valueOf(this.getPackageMode()) + ":" + (this.getPackageMode() != null ? this.getPackageMode().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("targets=");
        sb.append(this.getUnionForTargets().getNodeValue() == null? "null" : this.getUnionForTargets().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("dependencies=");
        sb.append(this.getUnionForDependencies().getNodeValue() == null? "null" : this.getUnionForDependencies().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMetaprogramPreambleNode(this, p);
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
        return operation.executeMetaprogramPreambleNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends MetaprogramImportListNode> importsCopy;
        switch (getUnionForImports().getType())
        {
            case NORMAL:
                if (getUnionForImports().getNormalNode() == null)
                {
                    importsCopy = factory.<MetaprogramImportListNode>makeNormalNodeUnion(null);
                } else
                {
                    importsCopy = factory.makeNormalNodeUnion(getUnionForImports().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForImports().getSpliceNode() == null)
                {
                    importsCopy = factory.<MetaprogramImportListNode>makeSpliceNodeUnion(null);
                } else
                {
                    importsCopy = factory.makeSpliceNodeUnion(getUnionForImports().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForImports().getType());
        }
        NodeUnion<? extends MetaprogramTargetListNode> targetsCopy;
        switch (getUnionForTargets().getType())
        {
            case NORMAL:
                if (getUnionForTargets().getNormalNode() == null)
                {
                    targetsCopy = factory.<MetaprogramTargetListNode>makeNormalNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeNormalNodeUnion(getUnionForTargets().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTargets().getSpliceNode() == null)
                {
                    targetsCopy = factory.<MetaprogramTargetListNode>makeSpliceNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeSpliceNodeUnion(getUnionForTargets().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTargets().getType());
        }
        NodeUnion<? extends MetaprogramDependencyDeclarationListNode> dependenciesCopy;
        switch (getUnionForDependencies().getType())
        {
            case NORMAL:
                if (getUnionForDependencies().getNormalNode() == null)
                {
                    dependenciesCopy = factory.<MetaprogramDependencyDeclarationListNode>makeNormalNodeUnion(null);
                } else
                {
                    dependenciesCopy = factory.makeNormalNodeUnion(getUnionForDependencies().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForDependencies().getSpliceNode() == null)
                {
                    dependenciesCopy = factory.<MetaprogramDependencyDeclarationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    dependenciesCopy = factory.makeSpliceNodeUnion(getUnionForDependencies().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForDependencies().getType());
        }
        return factory.makeMetaprogramPreambleNodeWithUnions(
                importsCopy,
                getLocalMode(),
                getPackageMode(),
                targetsCopy,
                dependenciesCopy,
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
        
        if (before.equals(this.getUnionForImports().getNodeValue()))
        {
            setImports((MetaprogramImportListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTargets().getNodeValue()))
        {
            setTargets((MetaprogramTargetListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForDependencies().getNodeValue()))
        {
            setDependencies((MetaprogramDependencyDeclarationListNode)after);
            return true;
        }
        return false;
    }
    
}
