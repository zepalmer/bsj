package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependsNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramPreambleNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
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
    private MetaprogramTargetNode target;
    
    /** The dependencies for this metaprogram. */
    private MetaprogramDependsNode depends;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the imports property. */
        IMPORTS,
        /** Attribute for the localMode property. */
        LOCAL_MODE,
        /** Attribute for the packageMode property. */
        PACKAGE_MODE,
        /** Attribute for the target property. */
        TARGET,
        /** Attribute for the depends property. */
        DEPENDS,
    }
    
    /** General constructor. */
    public MetaprogramPreambleNodeImpl(
            MetaprogramImportListNode imports,
            MetaprogramLocalMode localMode,
            MetaprogramPackageMode packageMode,
            MetaprogramTargetNode target,
            MetaprogramDependsNode depends,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setImports(imports, false);
        this.localMode = localMode;
        this.packageMode = packageMode;
        setTarget(target, false);
        setDepends(depends, false);
    }
    
    /**
     * Gets the imports for this metaprogram.
     * @return The imports for this metaprogram.
     */
    public MetaprogramImportListNode getImports()
    {
        recordAccess(LocalAttribute.IMPORTS, Attribute.AccessType.READ);
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
            recordAccess(LocalAttribute.IMPORTS, Attribute.AccessType.WRITE);
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
        recordAccess(LocalAttribute.LOCAL_MODE, Attribute.AccessType.READ);
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
            recordAccess(LocalAttribute.LOCAL_MODE, Attribute.AccessType.WRITE);
        }
        this.localMode = localMode;
    }
    
    /**
     * Gets the metaprogram package mode.
     * @return The metaprogram package mode.
     */
    public MetaprogramPackageMode getPackageMode()
    {
        recordAccess(LocalAttribute.PACKAGE_MODE, Attribute.AccessType.READ);
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
            recordAccess(LocalAttribute.PACKAGE_MODE, Attribute.AccessType.WRITE);
        }
        this.packageMode = packageMode;
    }
    
    /**
     * Gets the targets for this metaprogram.
     * @return The targets for this metaprogram.
     */
    public MetaprogramTargetNode getTarget()
    {
        recordAccess(LocalAttribute.TARGET, Attribute.AccessType.READ);
        return this.target;
    }
    
    /**
     * Changes the targets for this metaprogram.
     * @param target The targets for this metaprogram.
     */
    public void setTarget(MetaprogramTargetNode target)
    {
            setTarget(target, true);
    }
    
    private void setTarget(MetaprogramTargetNode target, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.TARGET, Attribute.AccessType.WRITE);
        }
        setAsChild(target, false);
        this.target = target;
        setAsChild(target, true);
    }
    
    /**
     * Gets the dependencies for this metaprogram.
     * @return The dependencies for this metaprogram.
     */
    public MetaprogramDependsNode getDepends()
    {
        recordAccess(LocalAttribute.DEPENDS, Attribute.AccessType.READ);
        return this.depends;
    }
    
    /**
     * Changes the dependencies for this metaprogram.
     * @param depends The dependencies for this metaprogram.
     */
    public void setDepends(MetaprogramDependsNode depends)
    {
            setDepends(depends, true);
    }
    
    private void setDepends(MetaprogramDependsNode depends, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.DEPENDS, Attribute.AccessType.WRITE);
        }
        setAsChild(depends, false);
        this.depends = depends;
        setAsChild(depends, true);
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
        if (this.target != null)
        {
            this.target.receive(visitor);
        }
        if (this.depends != null)
        {
            this.depends.receive(visitor);
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
        if (this.target != null)
        {
            this.target.receiveTyped(visitor);
        }
        if (this.depends != null)
        {
            this.depends.receiveTyped(visitor);
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
        list.add(getTarget());
        list.add(getDepends());
        return list;
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
        sb.append("target=");
        sb.append(this.getTarget() == null? "null" : this.getTarget().getClass().getSimpleName());
        sb.append(',');
        sb.append("depends=");
        sb.append(this.getDepends() == null? "null" : this.getDepends().getClass().getSimpleName());
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
                getTarget()==null?null:getTarget().deepCopy(factory),
                getDepends()==null?null:getDepends().deepCopy(factory),
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
        if (before.equals(this.getTarget()) && (after instanceof MetaprogramTargetNode))
        {
            setTarget((MetaprogramTargetNode)after);
            return true;
        }
        if (before.equals(this.getDepends()) && (after instanceof MetaprogramDependsNode))
        {
            setDepends((MetaprogramDependsNode)after);
            return true;
        }
        return false;
    }
    
}
