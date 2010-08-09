import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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

/* GEN:headerstop */
public class PackageNodeImpl
{
	/* GEN:start */
	/** The subpackages we are currently maintaining. */
	private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
	/** The compilation units we are currently maintaining. */
	private Map<String, CompilationUnitNode> compilationUnitNodes = new HashMap<String, CompilationUnitNode>();
	/**
	 * The compilation units which cannot be loaded.  Requests to load these compilation units will result in
	 * <code>null</code> returns.  This set is used primarily to cache failed loads but is also used to prevent the
	 * call to {@link #addPackageNode(PackageNode)} which is caused by {@link #load(String)} from causing a loop.
	 */
	private Set<String> unloadableCompilationUnitNames = new HashSet<String>();
	/**
	 * The attributes which are tracking access to compilation units.
	 */
	private Map<String, PackageCompilationUnitAttribute> compilationUnitAttributes =
			new HashMap<String, PackageCompilationUnitAttribute>();
	/**
	 * An attribute to track the iterator for this node.
	 */
	private NonConflictingReadWriteAttribute iteratorAttribute = new NonConflictingReadWriteAttribute(this);
	
	/**
	 * Lazily creates compilation unit attributes.
	 */
	private PackageCompilationUnitAttribute getPackageCompilationUnitAttribute(String compilationUnitName)
	{
		PackageCompilationUnitAttribute ret = this.compilationUnitAttributes.get(compilationUnitName);
		if (ret==null)
		{
			ret = new PackageCompilationUnitAttribute(this);
			this.compilationUnitAttributes.put(compilationUnitName, ret);
		}
		return ret;
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
	}

	/**
	 * {@inheritDoc}
	 */
	public PackageNode getSubpackage(String name)
	{
		PackageNode packageNode = this.packageNodes.get(name);
		if (packageNode == null)
		{
			BsjNodeFactory factory = packageNodeCallback.getFactory();
			packageNode = factory.makePackageNode(factory.makeIdentifierNode(name));
			setAsChild(packageNode, true);
			this.packageNodes.put(name, packageNode);
		}
		return packageNode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addCompilationUnit(CompilationUnitNode compilationUnit)
	{
		getManager().assertInsertable(this);
		getPackageCompilationUnitAttribute(compilationUnit.getName()).recordAccess(
				PackageCompilationUnitAttribute.AccessType.WRITE);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);
		if (this.load(compilationUnit.getName()) != null)
		{
			throw new DuplicatePackageMemberExceptionImpl(this, compilationUnit, compilationUnit.getName());
		}
		this.compilationUnitNodes.put(compilationUnit.getName(), compilationUnit);
		setAsChild(compilationUnit, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompilationUnitNode getCompilationUnit(String name)
	{
		loadAllBinary();
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.READ);
		return this.compilationUnitNodes.get(name);
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<CompilationUnitNode> getCompilationUnitIterator()
	{
		loadAllBinary();
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.READ);
		return Collections.unmodifiableMap(compilationUnitNodes).values().iterator();
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
	public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name)
	{
		CompilationUnitNode compilationUnitNode = getCompilationUnit(name);
		if (compilationUnitNode != null)
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode, name);
			if (namedTypeDeclarationNode != null)
			{
				return namedTypeDeclarationNode;
			}
		}

		// If we couldn't find it in its own compilation unit node, let's go find it by searching the package
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
	 * {@inheritDoc}
	 */
	public boolean contains(String name)
	{
		loadAllBinary();
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.READ);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.READ);
		if (compilationUnitNodes.get(name) != null)
		{
			return true;
		}
		return this.packageNodeCallback.contains(this, name);
	}

	/**
	 * {@inheritDoc}
	 */
	public CompilationUnitNode load(String name)
	{
		getPackageCompilationUnitAttribute(name).recordAccess(PackageCompilationUnitAttribute.AccessType.LOAD);
		this.iteratorAttribute.recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);
		
		CompilationUnitNode compilationUnitNode;

		if (compilationUnitNodes.get(name) != null)
		{
			compilationUnitNode = compilationUnitNodes.get(name);
		} else if (unloadableCompilationUnitNames.contains(name))
		{
			return null;
		} else
		{
			// Try to load the compilation unit.  Temporarily add it to the unloadable names set to prevent a loop.
			unloadableCompilationUnitNames.add(name);
			compilationUnitNode = this.packageNodeCallback.load(this, name);
			unloadableCompilationUnitNames.remove(name);
			
			if (compilationUnitNode == null)
			{
				unloadableCompilationUnitNames.add(name);
				return null;
			}
			this.compilationUnitNodes.put(compilationUnitNode.getName(), compilationUnitNode);
		}

		this.packageNodeCallback.registerAsInjectorOf(compilationUnitNode);

		return compilationUnitNode;
	}
	
	
	private boolean loadedAllBinary = false;
	/**
	 * Loads just the binary files for this package.  This is necessary to ensure that introspectors looking at things
	 * like java.io.* will be able to see the contents without inadvertently seeing their own sources that they hadn't
	 * loaded (like some kind of garbage test file in java.io.*).
	 */
	private void loadAllBinary()
	{
		if (this.loadedAllBinary)
			return;
		
		this.loadedAllBinary = true;
		
		for (String name : packageNodeCallback.listCompilationUnitNames(this, true))
		{
			load(name);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void loadAll()
	{
		for (String name : packageNodeCallback.listCompilationUnitNames(this, false))
		{
			load(name);
		}
	}
	/* GEN:stop */
}