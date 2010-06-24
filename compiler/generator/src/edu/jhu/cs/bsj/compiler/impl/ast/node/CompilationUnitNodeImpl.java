package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ImportListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramImportListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class CompilationUnitNodeImpl extends NodeImpl implements CompilationUnitNode
{
    /** The name of the compilation unit. */
    private String name;
    
    /** The package declaration for this unit. */
    private PackageDeclarationNode packageDeclaration;
    
    /** The global metaprogram imports used in this unit. */
    private MetaprogramImportListNode metaimports;
    
    /** The imports used in this unit. */
    private ImportListNode imports;
    
    /** The type declarations of this unit. */
    private TypeDeclarationListNode typeDecls;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new HashMap<LocalAttribute,ReadWriteAttribute>();
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(CompilationUnitNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the name property. */
        NAME,
        /** Attribute identifier for the packageDeclaration property. */
        PACKAGE_DECLARATION,
        /** Attribute identifier for the metaimports property. */
        METAIMPORTS,
        /** Attribute identifier for the imports property. */
        IMPORTS,
        /** Attribute identifier for the typeDecls property. */
        TYPE_DECLS,
    }
    
    /** General constructor. */
    public CompilationUnitNodeImpl(
            String name,
            PackageDeclarationNode packageDeclaration,
            MetaprogramImportListNode metaimports,
            ImportListNode imports,
            TypeDeclarationListNode typeDecls,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.name = name;
        setPackageDeclaration(packageDeclaration, false);
        setMetaimports(metaimports, false);
        setImports(imports, false);
        setTypeDecls(typeDecls, false);
    }
    
    /**
     * Gets the name of the compilation unit.
     * @return The name of the compilation unit.
     */
    public String getName()
    {
        getAttribute(LocalAttribute.NAME).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.name;
    }
    
    /**
     * Gets the package declaration for this unit.
     * @return The package declaration for this unit.
     */
    public PackageDeclarationNode getPackageDeclaration()
    {
        getAttribute(LocalAttribute.PACKAGE_DECLARATION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.packageDeclaration;
    }
    
    /**
     * Changes the package declaration for this unit.
     * @param packageDeclaration The package declaration for this unit.
     */
    public void setPackageDeclaration(PackageDeclarationNode packageDeclaration)
    {
            setPackageDeclaration(packageDeclaration, true);
    }
    
    private void setPackageDeclaration(PackageDeclarationNode packageDeclaration, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.PACKAGE_DECLARATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(packageDeclaration, false);
        this.packageDeclaration = packageDeclaration;
        setAsChild(packageDeclaration, true);
    }
    
    /**
     * Gets the global metaprogram imports used in this unit.
     * @return The global metaprogram imports used in this unit.
     */
    public MetaprogramImportListNode getMetaimports()
    {
        getAttribute(LocalAttribute.METAIMPORTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.metaimports;
    }
    
    /**
     * Changes the global metaprogram imports used in this unit.
     * @param metaimports The global metaprogram imports used in this unit.
     */
    public void setMetaimports(MetaprogramImportListNode metaimports)
    {
            setMetaimports(metaimports, true);
    }
    
    private void setMetaimports(MetaprogramImportListNode metaimports, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.METAIMPORTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(metaimports, false);
        this.metaimports = metaimports;
        setAsChild(metaimports, true);
    }
    
    /**
     * Gets the imports used in this unit.
     * @return The imports used in this unit.
     */
    public ImportListNode getImports()
    {
        getAttribute(LocalAttribute.IMPORTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.imports;
    }
    
    /**
     * Changes the imports used in this unit.
     * @param imports The imports used in this unit.
     */
    public void setImports(ImportListNode imports)
    {
            setImports(imports, true);
    }
    
    private void setImports(ImportListNode imports, boolean checkPermissions)
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
     * Gets the type declarations of this unit.
     * @return The type declarations of this unit.
     */
    public TypeDeclarationListNode getTypeDecls()
    {
        getAttribute(LocalAttribute.TYPE_DECLS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.typeDecls;
    }
    
    /**
     * Changes the type declarations of this unit.
     * @param typeDecls The type declarations of this unit.
     */
    public void setTypeDecls(TypeDeclarationListNode typeDecls)
    {
            setTypeDecls(typeDecls, true);
    }
    
    private void setTypeDecls(TypeDeclarationListNode typeDecls, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_DECLS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(typeDecls, false);
        this.typeDecls = typeDecls;
        setAsChild(typeDecls, true);
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
        if (this.packageDeclaration != null)
        {
            this.packageDeclaration.receive(visitor);
        }
        if (this.metaimports != null)
        {
            this.metaimports.receive(visitor);
        }
        if (this.imports != null)
        {
            this.imports.receive(visitor);
        }
        if (this.typeDecls != null)
        {
            this.typeDecls.receive(visitor);
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
        if (this.packageDeclaration != null)
        {
            this.packageDeclaration.receiveTyped(visitor);
        }
        if (this.metaimports != null)
        {
            this.metaimports.receiveTyped(visitor);
        }
        if (this.imports != null)
        {
            this.imports.receiveTyped(visitor);
        }
        if (this.typeDecls != null)
        {
            this.typeDecls.receiveTyped(visitor);
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
        list.add(getPackageDeclaration());
        list.add(getMetaimports());
        list.add(getImports());
        list.add(getTypeDecls());
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
        sb.append("name=");
        sb.append(String.valueOf(this.getName()) + ":" + (this.getName() != null ? this.getName().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("packageDeclaration=");
        sb.append(this.getPackageDeclaration() == null? "null" : this.getPackageDeclaration().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaimports=");
        sb.append(this.getMetaimports() == null? "null" : this.getMetaimports().getClass().getSimpleName());
        sb.append(',');
        sb.append("imports=");
        sb.append(this.getImports() == null? "null" : this.getImports().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeDecls=");
        sb.append(this.getTypeDecls() == null? "null" : this.getTypeDecls().getClass().getSimpleName());
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
        return operation.executeCompilationUnitNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CompilationUnitNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeCompilationUnitNode(
                getName(),
                getPackageDeclaration()==null?null:getPackageDeclaration().deepCopy(factory),
                getMetaimports()==null?null:getMetaimports().deepCopy(factory),
                getImports()==null?null:getImports().deepCopy(factory),
                getTypeDecls()==null?null:getTypeDecls().deepCopy(factory),
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
        
        if (before.equals(this.getPackageDeclaration()) && (after instanceof PackageDeclarationNode))
        {
            setPackageDeclaration((PackageDeclarationNode)after);
            return true;
        }
        if (before.equals(this.getMetaimports()) && (after instanceof MetaprogramImportListNode))
        {
            setMetaimports((MetaprogramImportListNode)after);
            return true;
        }
        if (before.equals(this.getImports()) && (after instanceof ImportListNode))
        {
            setImports((ImportListNode)after);
            return true;
        }
        if (before.equals(this.getTypeDecls()) && (after instanceof TypeDeclarationListNode))
        {
            setTypeDecls((TypeDeclarationListNode)after);
            return true;
        }
        return false;
    }
    
}
