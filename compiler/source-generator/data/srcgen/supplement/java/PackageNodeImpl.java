import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterator;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.impl.ast.exception.*;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.TrueNodeFilter;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.*;

/* GEN:headerstop */
public class PackageNodeImpl
{
    /* GEN:start */
    /** The subpackages we are currently maintaining. */
    private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
    /**
     * The compilation units which were added via loading. Values are <code>null</code> when a load was performed but
     * did not succeed.
     */
    private Map<String, CompilationUnitNode> loadedCompilationUnits = new HashMap<String, CompilationUnitNode>();
    /** The compilation units which were added via addition. */
    private Map<String, CompilationUnitNode> storedCompilationUnits = new HashMap<String, CompilationUnitNode>();

    // TODO: create a somewhat more performant version of lazy population than this beast
    private boolean isPopulated = false;

    private void checkPopulated()
    {
        if (this.isPopulated || getBackingNode() == null)
        {
            this.isPopulated = true;
            return;
        }
        // This approach is not pretty, but it relies on the true invariant that all nodes in this tree were prouced
        // by the BsjNodeFactoryImpl that we know.  It also allows us to avoid exposing to the user through the API
        // the information about which specific subpackages are present and whether a given compilation unit is loaded
        // or stored. 
        PackageNodeImpl impl = (PackageNodeImpl) (this.getBackingNode());
        for (Map.Entry<String, CompilationUnitNode> entry : impl.loadedCompilationUnits.entrySet())
        {
            this.loadedCompilationUnits.put(entry.getKey(), getProxyFactory().makeCompilationUnitNode(entry.getValue()));
        }
        for (Map.Entry<String, CompilationUnitNode> entry : impl.storedCompilationUnits.entrySet())
        {
            this.storedCompilationUnits.put(entry.getKey(), getProxyFactory().makeCompilationUnitNode(entry.getValue()));
        }
        for (Map.Entry<String, PackageNode> entry : impl.packageNodes.entrySet())
        {
            this.packageNodes.put(entry.getKey(), getProxyFactory().makePackageNode(entry.getValue()));
        }
        this.isPopulated = true;
    }

    /**
     * {@inheritDoc}
     */
    public void addPackage(PackageNode packageNode)
    {
        checkPopulated();
        if (this.packageNodes.containsKey(packageNode.getName().getIdentifier()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, packageNode, packageNode.getName().getIdentifier());
        }
        getManager().assertInsertable(this);
        setAsChild(packageNode, true);
        this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new AddSubpackagePackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), packageNode.getUid()));
        }
        getManager().notifyChange(this);
    }
   
    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackage(String name)
    {
        if (name.length() == 0)
            return this;
        checkPopulated();
        String[] nameComponents = name.split("\\.");
        PackageNodeImpl p = this;
        for (String component : nameComponents)
        {
            // True invariant: all recursive children of this node must be created by the BsjNodeFactoryImpl
            p = (PackageNodeImpl)p.getSimpleSubpackage(component);
            if (p == null)
            {
                break;
            }
        }
        return p;
    }
    
    private PackageNode getSimpleSubpackage(String name)
    {
        checkPopulated();
        PackageNode packageNode = this.packageNodes.get(name);
        if (packageNode == null)
        {
            BsjNodeFactory factory = this.getManager().getPackageNodeManager().getFactory();
            packageNode = factory.makePackageNode(factory.makeIdentifierNode(name));
            setAsChild(packageNode, true);
            this.packageNodes.put(name, packageNode);
            if (getManager().isRecordingEdits())
            {
                getManager().recordEdit(new AddImplicitSubpackagePackageEditScriptElementImpl(
                        getManager().getCurrentMetaprogramId(), getUid(), packageNode.getUid(), name));
            }
            getManager().notifyChange(this);
        }
        return packageNode;
    }
    
    public PackageNode getSubpackage(List<String> name)
    {
        checkPopulated();
        PackageNodeImpl p = this;
        for (String nameComponent : name)
        {
            if (nameComponent.contains("."))
                throw new IllegalArgumentException("name component " + nameComponent + " is not simple");
            // True invariant: all recursive children of this node must be created by the BsjNodeFactoryImpl
            p = (PackageNodeImpl)p.getSimpleSubpackage(nameComponent);
            if (p == null)
            {
                break;
            }            
        }
        return p;
    }

    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackage(NameNode name)
    {
        checkPopulated();
        if (name instanceof QualifiedNameNode)
        {
            QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
            PackageNode packageNode = getSubpackage(qualifiedNameNode.getBase());
            return packageNode.getSubpackage(name.getIdentifier().getIdentifier());
        } else if (name instanceof SimpleNameNode)
        {
            return getSubpackage(name.getIdentifier().getIdentifier());
        } else
        {
            throw new IllegalStateException("Unrecognized name node type " + name.getClass().getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addCompilationUnit(CompilationUnitNode compilationUnit)
    {
        checkPopulated();
        if (compilationUnit == null)
            throw new NullPointerException("Cannot add null compilation unit to a package");
        if (this.loadedCompilationUnits.containsKey(compilationUnit.getName())
                || this.storedCompilationUnits.containsKey(compilationUnit.getName()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, compilationUnit, compilationUnit.getName());
        }
        getManager().assertInsertable(this);
        setAsChild(compilationUnit, true);
        this.storedCompilationUnits.put(compilationUnit.getName(), compilationUnit);
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new AddCompilationUnitPackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), compilationUnit.getUid()));
        }
        getManager().notifyChange(this);
    }

    public boolean loadCompilationUnit(String name, CompilationUnitLoadingInfo info)
    {
        checkPopulated();
        CompilationUnitNode node;
        if (this.loadedCompilationUnits.containsKey(name))
        {
            node = this.loadedCompilationUnits.get(name);
        } else
        {
            node = getManager().getCompilationUnitLoader().load(this.getFullyQualifiedName(), name, info);
            if (this.getManager().getProxyFactory() != null)
            {
                node = this.getManager().getProxyFactory().makeCompilationUnitNode(node);
            }
            if (this.storedCompilationUnits.containsKey(name))
            {
                throw new DuplicatePackageMemberExceptionImpl(this, node, name);
            }
            this.loadedCompilationUnits.put(name, node);
            if (node != null)
            {
                setAsChild(node, true);
                getManager().getPackageNodeManager().fireCompilationUnitAdded(this, node,
                        this.getManager().getProxyFactory() == null ? null : this.getManager().getProxyFactory().getProxyIdMapping());
                getManager().notifyChange(this);
            }
        }
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new LoadCompilationUnitPackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), (node == null ? null : node.getUid()), name));
        }
        return node != null;
    }

    public void loadAllCompilationUnits(CompilationUnitLoadingInfo info)
    {
        for (String name : getManager().getCompilationUnitLoader().listCompilationUnitNames(this, false))
        {
            this.loadCompilationUnit(name, info);
        }
    }

    /**
     * {@inheritDoc}
     */
    public CompilationUnitNode getCompilationUnit(String name)
    {
        checkPopulated();
        CompilationUnitNode node;
        if (this.loadedCompilationUnits.containsKey(name))
        {
            node = this.loadedCompilationUnits.get(name);
        } else
        {
            node = this.storedCompilationUnits.get(name);
        }
        return node;
    }
    
    public Map<String, CompilationUnitNode> filterCompilationUnits(NodeFilter<? super CompilationUnitNode> filter)
    {
        checkPopulated();
        Map<String, CompilationUnitNode> ret = new HashMap<String, CompilationUnitNode>();
        for (Map<String, CompilationUnitNode> map : CollectionUtilities.listOf(this.loadedCompilationUnits, this.storedCompilationUnits))
        {
            for (Map.Entry<String, CompilationUnitNode> entry : map.entrySet())
            {
                if (entry.getValue() != null && filter.filter(entry.getValue()))
                {
                    ret.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return ret;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<CompilationUnitNode> getCompilationUnitIterator()
    {
        checkPopulated();
        return filterCompilationUnits(TrueNodeFilter.<CompilationUnitNode>instance()).values().iterator();
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<CompilationUnitNode> getRecursiveCompilationUnitIterator()
    {
        checkPopulated();
        List<Iterator<? extends CompilationUnitNode>> iterators = new ArrayList<Iterator<? extends CompilationUnitNode>>();
        iterators.add(getCompilationUnitIterator());
        for (PackageNode p : packageNodes.values())
        {
            iterators.add(p.getRecursiveCompilationUnitIterator());
        }
        return new CompoundIterator<CompilationUnitNode>(iterators.iterator());
    }

    /**
     * Used to allow visitation over the children of this package.
     * 
     * @return An iterator which iterates over the compilation units in this package and all of its subpackages.
     */
    protected Iterator<? extends Node> getHiddenVisitorChildren()
    {
        checkPopulated();
        List<Iterator<? extends Node>> iterators = new ArrayList<Iterator<? extends Node>>();
        iterators.add(super.getHiddenVisitorChildren());
        iterators.add(getRecursiveCompilationUnitIterator());
        return new CompoundIterator<Node>(iterators.iterator());
    }

    /**
     * {@inheritDoc}
     */
    public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name, CompilationUnitLoadingInfo info)
    {
        checkPopulated();
        this.loadCompilationUnit(name, info);
        CompilationUnitNode compilationUnitNode = this.getCompilationUnit(name);
        if (compilationUnitNode != null)
        {
            NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode, name);
            if (namedTypeDeclarationNode != null)
            {
                return namedTypeDeclarationNode;
            }
        }

        // If we couldn't find it in its own compilation unit node, let's go find it by searching the package
        this.loadAllCompilationUnits(info);
        Iterator<CompilationUnitNode> it = getCompilationUnitIterator();
        while (it.hasNext())
        {
            NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(it.next(), name);
            if (namedTypeDeclarationNode != null)
            {
                return namedTypeDeclarationNode;
            }
        }

        return null;
    }

    // TODO: consider generalizing this to a public function of CompilationUnitNode
    /**
     * Searches the specified child for a top-level type declaration of the specified name.
     * 
     * @param compilationUnitNode The child in question.
     * @param name The name of the type declaration.
     * @return The resulting top-level type declaration.
     */
    private static NamedTypeDeclarationNode<?> tryCompilationUnitNode(CompilationUnitNode compilationUnitNode,
            String name)
    {
        for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
        {
            if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
            {
                NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
                if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(name))
                {
                    return namedTypeDeclarationNode;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String getFullyQualifiedName()
    {
        StringBuilder sb = new StringBuilder();
        PackageNode node = this;
        while (true)
        {
            if (node.getName() == null)
            {
                return sb.toString();
            }
            if (sb.length() > 0)
            {
                sb.insert(0, '.');
            }
            sb.insert(0, node.getName().getIdentifier());
            if (node.getParent() instanceof PackageNode)
            {
                node = (PackageNode) node.getParent();
            } else
            {
                return null;
            }
        }
    }

    /**
     * This function provides a recursive iterator over all subpackages of this node.  This is necessary for the
     * {@link edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BuildIdMapTask}.  This method only exists on the backing
     * class implementation and not on the interface because this information should not be provided to metaprogrammers
     * through the API.
     */
    public Iterator<PackageNode> getRecursivePackageIterator()
    {
        checkPopulated();
        List<Iterator<? extends PackageNode>> iterators = new ArrayList<Iterator<? extends PackageNode>>();
        iterators.add(this.packageNodes.values().iterator());
        for (PackageNode p : packageNodes.values())
        {
            iterators.add(((PackageNodeImpl)p).getRecursivePackageIterator());
        }
        return new CompoundIterator<PackageNode>(iterators.iterator());
    }
    
    /* GEN:stop */
}