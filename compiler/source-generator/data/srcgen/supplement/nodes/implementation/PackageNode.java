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
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.impl.ast.exception.*;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.*;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.packagenode.knowledge.*;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.source.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.conflict.packagenode.knowledge.*;
import edu.jhu.cs.bsj.compiler.ast.conflict.source.*;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.TrueNodeFilter;

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
    /** The knowledge base which tracks conflict detection logic for this package. */
    private KnowledgeBase<PackageKnowledge> knowledgeBase = KnowledgeBaseUtilities.createPackageKnowledgeBase(getManager());
    /** A cached set of all names which have been successfully loaded by this package. */
    private Set<String> successfullyLoadedNames = new HashSet<String>();

    protected void fireCompilationUnitAdded(CompilationUnitNode compilationUnitNode, boolean purelyInjected)
    {
        this.getManager().getPackageNodeManager().fireCompilationUnitAdded(this, compilationUnitNode, purelyInjected);
    }

    protected void fireSubpackageAdded(PackageNode subPackageNode)
    {
        this.getManager().getPackageNodeManager().fireSubpackageAdded(this, subPackageNode);
    }

    protected void fireRegisterAsInjector(CompilationUnitNode compilationUnitNode)
    {
        this.getManager().getPackageNodeManager().fireRegisterAsInjector(compilationUnitNode);
    }

    private void learn(PackageKnowledge packageKnowledge)
    {
        Set<ConflictKnowledge> conflicts = this.knowledgeBase.addKnowledge(packageKnowledge);
        if (!conflicts.isEmpty())
        {
            ConflictKnowledge conflict = conflicts.iterator().next();
            throw new MetaprogramPackageConflictExceptionImpl(getManager().getAnchorByID(
                    conflict.getFirstMetaprogramId()), getManager().getAnchorByID(conflict.getSecondMetaprogramId()),
                    this, conflicts);
        }
    }
    
    private void learnGet(String name, CompilationUnitNode compilationUnit)
    {
        if (getManager().getCurrentMetaprogramId() != null)
        {
            if (this.successfullyLoadedNames.contains(name))
            {
                learn(new LoadedGetKnowledgeImpl(new OperationKnowledgeSourceImpl(1),
                        getManager().getCurrentMetaprogramId(), name, compilationUnit));
            } else
            {
                learn(new UnloadedGetKnowledgeImpl(new OperationKnowledgeSourceImpl(1),
                        getManager().getCurrentMetaprogramId(), name, compilationUnit));
            }
        }
    }
    
    private void learnLoad(String name, CompilationUnitNode compilationUnit)
    {
        if (getManager().getCurrentMetaprogramId() != null)
        {
            if (compilationUnit != null)
            {
                this.successfullyLoadedNames.add(name);
                learn(new SuccessfulLoadKnowledgeImpl(new OperationKnowledgeSourceImpl(1),
                        getManager().getCurrentMetaprogramId(), name, compilationUnit));
            } else
            {
                learn(new UnsuccessfulLoadKnowledgeImpl(new OperationKnowledgeSourceImpl(1),
                        getManager().getCurrentMetaprogramId(), name, compilationUnit));
            }
        }
    }
    
    private void learnPut(CompilationUnitNode compilationUnit)
    {
        if (getManager().getCurrentMetaprogramId() != null)
        {
            learn(new PutKnowledgeImpl(new OperationKnowledgeSourceImpl(1), getManager().getCurrentMetaprogramId(),
                    compilationUnit.getName(), compilationUnit));
        }        
    }
    
    private void learnFilter(NodeFilter<? super CompilationUnitNode> filter)
    {
        if (getManager().getCurrentMetaprogramId() != null)
        {
            learn(new PackageFilterKnowledgeImpl(new OperationKnowledgeSourceImpl(1), 
                    getManager().getCurrentMetaprogramId(), filter, new HashSet<String>(this.successfullyLoadedNames)));
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addPackage(PackageNode packageNode)
    {
        if (this.packageNodes.containsKey(packageNode.getName().getIdentifier()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, packageNode, packageNode.getName().getIdentifier());
        }
        getManager().assertInsertable(this);
        this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
        setAsChild(packageNode, true);
        fireSubpackageAdded(packageNode);
    }

    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackage(String name)
    {
        PackageNode packageNode = this.packageNodes.get(name);
        if (packageNode == null)
        {
            BsjNodeFactory factory = this.getManager().getPackageNodeManager().getFactory();
            packageNode = factory.makePackageNode(factory.makeIdentifierNode(name));
            setAsChild(packageNode, true);
            this.packageNodes.put(name, packageNode);
            fireSubpackageAdded(packageNode);
        }
        return packageNode;
    }

    /**
     * {@inheritDoc}
     */
    public void addCompilationUnit(CompilationUnitNode compilationUnit)
    {
        if (compilationUnit == null)
            throw new NullPointerException("Cannot add null compilation unit to a package");
        getManager().assertInsertable(this);
        learnPut(compilationUnit);
        if (this.loadedCompilationUnits.containsKey(compilationUnit.getName())
                || this.storedCompilationUnits.containsKey(compilationUnit.getName()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, compilationUnit, compilationUnit.getName());
        }
        this.storedCompilationUnits.put(compilationUnit.getName(), compilationUnit);
        setAsChild(compilationUnit, true);
        fireCompilationUnitAdded(compilationUnit, true);
    }

    public boolean loadCompilationUnit(String name, CompilationUnitLoadingInfo info)
    {
        if (this.loadedCompilationUnits.containsKey(name))
        {
            CompilationUnitNode compilationUnit = this.loadedCompilationUnits.get(name);
            learnLoad(name, compilationUnit); 
            return compilationUnit != null;
        }

        CompilationUnitNode node = getManager().getCompilationUnitLoader().load(this.getFullyQualifiedName(), name,
                info);
        this.loadedCompilationUnits.put(name, node);
        learnLoad(name, node);
        if (node != null)
        {
            setAsChild(node, true);
            fireCompilationUnitAdded(node, false);
            fireRegisterAsInjector(node);
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
        CompilationUnitNode node;
        if (this.loadedCompilationUnits.containsKey(name))
        {
            node = this.loadedCompilationUnits.get(name);
        } else
        {
            node = this.storedCompilationUnits.get(name);
        }
        learnGet(name, node);
        return node;
    }
    
    public Map<String, CompilationUnitNode> filterCompilationUnits(NodeFilter<? super CompilationUnitNode> filter)
    {
        learnFilter(filter);
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
        return filterCompilationUnits(TrueNodeFilter.<CompilationUnitNode>instance()).values().iterator();
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<CompilationUnitNode> getRecursiveCompilationUnitIterator()
    {
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
        List<Iterator<? extends Node>> iterators = new ArrayList<Iterator<? extends Node>>();
        iterators.add(super.getHiddenVisitorChildren());
        iterators.add(getRecursiveCompilationUnitIterator());
        return new CompoundIterator<Node>(iterators.iterator());
    }

    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackageByQualifiedName(String name)
    {
        String[] nameComponents = name.split("\\.");
        PackageNode p = this;
        for (String component : nameComponents)
        {
            p = p.getSubpackage(component);
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
    public PackageNode getSubpackageByQualifiedName(NameNode name)
    {
        if (name instanceof QualifiedNameNode)
        {
            QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
            PackageNode packageNode = getSubpackageByQualifiedName(qualifiedNameNode.getBase());
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
    public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name, CompilationUnitLoadingInfo info)
    {
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

    /* GEN:stop */
}