package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPreambleNodeImpl extends NodeImpl implements MetaprogramPreambleNode
{
    /** The imports for this metaprogram. */
    private MetaprogramImportListNode imports;
    
    /** The metaprogram local mode. */
    private MetaprogramLocalMode localMode;
    
    /** The metaprogram package mode. */
    private MetaprogramPackageMode packageMode;
    
    /** The targets for this metaprogram. */
    private MetaprogramTargetListNode targets;
    
    /** The dependencies for this metaprogram. */
    private MetaprogramDependencyDeclarationListNode dependencies;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaprogramPreambleNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the imports property. */
        IMPORTS,
        /** Attribute identifier for the localMode property. */
        LOCAL_MODE,
        /** Attribute identifier for the packageMode property. */
        PACKAGE_MODE,
        /** Attribute identifier for the targets property. */
        TARGETS,
        /** Attribute identifier for the dependencies property. */
        DEPENDENCIES,
    }
    
    /** General constructor. */
    public MetaprogramPreambleNodeImpl(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetListNode targets,
            MetaprogramDependencyDeclarationListNode dependencies,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setImports(imports, false);
        this.localMode = localMode;
        this.packageMode = packageMode;
        setTargets(targets, false);
        setDependencies(dependencies, false);
    }
    
    /**
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public MetaprogramImportListNode getImports()
    {
        getAttribute(LocalAttribute.IMPORTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.imports;
    }
    
    /**
     * Changes the imports for this metaprogram.
     * @param imports The imports for this metaprogram.
     */
    public void setImports(MetaprogramImportListNode imports)
    {
            setImports(imports, true);
    }
    
    private void setImports(MetaprogramImportListNode imports, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IMPORTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(imports, false);
        this.imports = imports;
        setAsChild(imports, true);
    }
    
    /**
     * Gets the metaprogram local mode.
     * @return The metaprogram local mode.
     */
    public MetaprogramLocalMode getLocalMode()
    {
        getAttribute(LocalAttribute.LOCAL_MODE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.localMode;
    }
    
    /**
     * Changes the metaprogram local mode.
     * @param localMode The metaprogram local mode.
     */
    public void setLocalMode(MetaprogramLocalMode localMode)
    {
            setLocalMode(localMode, true);
    }
    
    private void setLocalMode(MetaprogramLocalMode localMode, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.LOCAL_MODE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.localMode = localMode;
    }
    
    /**
     * Gets the metaprogram package mode.
     * @return The metaprogram package mode.
     */
    public MetaprogramPackageMode getPackageMode()
    {
        getAttribute(LocalAttribute.PACKAGE_MODE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.packageMode;
    }
    
    /**
     * Changes the metaprogram package mode.
     * @param packageMode The metaprogram package mode.
     */
    public void setPackageMode(MetaprogramPackageMode packageMode)
    {
            setPackageMode(packageMode, true);
    }
    
    private void setPackageMode(MetaprogramPackageMode packageMode, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PACKAGE_MODE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        this.packageMode = packageMode;
    }
    
    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public MetaprogramTargetListNode getTargets()
    {
        getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.targets;
    }
    
    /**
     * Changes the targets for this metaprogram.
     * @param targets The targets for this metaprogram.
     */
    public void setTargets(MetaprogramTargetListNode targets)
    {
            setTargets(targets, true);
    }
    
    private void setTargets(MetaprogramTargetListNode targets, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TARGETS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(targets, false);
        this.targets = targets;
        setAsChild(targets, true);
    }
    
    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public MetaprogramDependencyDeclarationListNode getDependencies()
    {
        getAttribute(LocalAttribute.DEPENDENCIES).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.dependencies;
    }
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param dependencies The dependencies for this metaprogram.
     */
    public void setDependencies(MetaprogramDependencyDeclarationListNode dependencies)
    {
            setDependencies(dependencies, true);
    }
    
    private void setDependencies(MetaprogramDependencyDeclarationListNode dependencies, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DEPENDENCIES).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(dependencies, false);
        this.dependencies = dependencies;
        setAsChild(dependencies, true);
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
        if (this.imports != null)
        {
            this.imports.receive(visitor);
        }
        if (this.targets != null)
        {
            this.targets.receive(visitor);
        }
        if (this.dependencies != null)
        {
            this.dependencies.receive(visitor);
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
        if (this.imports != null)
        {
            this.imports.receiveTyped(visitor);
        }
        if (this.targets != null)
        {
            this.targets.receiveTyped(visitor);
        }
        if (this.dependencies != null)
        {
            this.dependencies.receiveTyped(visitor);
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
        list.add(getImports());
        list.add(getLocalMode());
        list.add(getPackageMode());
        list.add(getTargets());
        list.add(getDependencies());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getImports(), getTargets(), getDependencies()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("imports=");
        sb.append(this.getImports() == null? "null" : this.getImports().getClass().getSimpleName());
        sb.append(',');
        sb.append("localMode=");
        sb.append(String.valueOf(this.getLocalMode()) + ":" + (this.getLocalMode() != null ? this.getLocalMode().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("packageMode=");
        sb.append(String.valueOf(this.getPackageMode()) + ":" + (this.getPackageMode() != null ? this.getPackageMode().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("targets=");
        sb.append(this.getTargets() == null? "null" : this.getTargets().getClass().getSimpleName());
        sb.append(',');
        sb.append("dependencies=");
        sb.append(this.getDependencies() == null? "null" : this.getDependencies().getClass().getSimpleName());
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeMetaprogramPreambleNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramPreambleNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMetaprogramPreambleNode(
                getImports()==null?null:getImports().deepCopy(factory),
                getLocalMode(),
                getPackageMode(),
                getTargets()==null?null:getTargets().deepCopy(factory),
                getDependencies()==null?null:getDependencies().deepCopy(factory),
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
        
        if (before.equals(this.getImports()) && (after instanceof MetaprogramImportListNode))
        {
            setImports((MetaprogramImportListNode)after);
            return true;
        }
        if (before.equals(this.getTargets()) && (after instanceof MetaprogramTargetListNode))
        {
            setTargets((MetaprogramTargetListNode)after);
            return true;
        }
        if (before.equals(this.getDependencies()) && (after instanceof MetaprogramDependencyDeclarationListNode))
        {
            setDependencies((MetaprogramDependencyDeclarationListNode)after);
            return true;
        }
        return false;
    }
    
}
