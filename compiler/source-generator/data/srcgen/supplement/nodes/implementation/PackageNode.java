import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;

/* GEN:headerstart */

/* GEN:headerstop */
public class PackageNodeImpl
{
	/* GEN:start */
	/** The subpackages we are currently maintaining. */
	private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
	/** The compilation units we are currently maintaining. */
	private Map<String, CompilationUnitNode> compilationUnitNodes = new HashMap<String, CompilationUnitNode>();

	/**
	 * Adds a new subpackage to this node. This subpackage cannot already be a member of another package.
	 * 
	 * @param packageNode The package node to add.
	 */
	// TODO: exception if the package already exists
	public void addPackageNode(PackageNode packageNode)
	{
		getManager().assertInsertable(this);
		this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
		if (packageNode instanceof PackageNodeImpl)
		{
			// TODO: exception if the node in question already has a parent
			((PackageNodeImpl)packageNode).setParent(this);
		}
	}

	/**
	 * Retrieves a subpackage of this package.
	 * 
	 * @param name The simple name of the subpackage to retrieve.
	 * @return The subpackage. If it does not exist, <code>null</code> is returned.
	 */
	public PackageNode getSubpackage(String name)
	{
		return packageNodes.get(name);
	}

	/**
	 * Adds a new compilation unit to this node. This compilation unit cannot already be a member of another package.
	 * 
	 * @param compilationUnit The compilation unit to add.
	 */
	// TODO: exception if the compilation unit already exists
	public void addCompilationUnitNode(CompilationUnitNode compilationUnit)
	{
		getManager().assertInsertable(this);
		this.compilationUnitNodes.put(compilationUnit.getName(), compilationUnit);
		if (compilationUnit instanceof CompilationUnitNodeImpl)
		{
			// TODO: exception if the node in question already has a parent
			((CompilationUnitNodeImpl)compilationUnit).setParent(this);
		}
	}

	/**
	 * Retrieves a compilation unit in this package.
	 * 
	 * @param name The simple name of the compilation unit to retrieve.
	 * @return The compilation unit. If it does not exist or has not yet been loaded, <code>null</code> is returned.
	 */
	public CompilationUnitNode getCompilationUnit(String name)
	{
		return this.compilationUnitNodes.get(name);
	}

	/**
	 * Retrieves an iterator over all loaded compilation units in this package.
	 * 
	 * @return An iterator over all loaded compilation units.
	 */
	public Iterator<CompilationUnitNode> getCompilationUnitIterator()
	{
		return Collections.unmodifiableMap(compilationUnitNodes).values().iterator();
	}

	/**
	 * Retrieves an iterator over all loaded compilation units in this package and its known subpackages.
	 * 
	 * @return A recursive iterator over all loaded compilation units.
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
	 * Retrieves a subpackage of this package by qualified name. This method is provided for convenience and is
	 * equivalent to calling {@link #getSubpackage} compositionally.
	 * 
	 * @param name The qualified name of the subpackage to retrieve. The name components are separated by '.'
	 *            characters.
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
	 * Retrieves a subpackage of this package by qualified name. This method is provided for convenience and is
	 * equivalent to calling {@link #getSubpackage} compositionally.
	 * 
	 * @param name The qualified name of the subpackage to retrieve.
	 * @return The resulting package node or <code>null</code> if no such node exists.
	 */
	public PackageNode getSubpackageByQualifiedName(NameNode name)
	{
		if (name instanceof QualifiedNameNode)
		{
			QualifiedNameNode qualifiedNameNode = (QualifiedNameNode)name;
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
	 * Retrieves a type declaration for a top level type in this package.
	 * @param name The simple name of the top level type.
	 * @return The type's declaration or <code>null</code> if no such declaration exists.
	 */
	public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name)
	{
		CompilationUnitNode compilationUnitNode = getCompilationUnit(name);
		if (compilationUnitNode != null)
		{
			NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode,
					name);
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
	 * Retrieves the full name of this package node. This method only returns a valid result if the package is attached
	 * to the root package.
	 * 
	 * @return The fully-qualified name of this package node or <code>null</code> if the name could not be determined.
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
	 * Determines whether or not this package node contains a compilation unit which has the specified simple name. This
	 * may be the case under any of the following three circumstances:
	 * <ul>
	 * <li>When a precompiled binary exists on the object program's classpath which represents the compilation unit.</li>
	 * <li>When a source file exists on the source path which defines the compilation unit.</li>
	 * <li>When a node created by a metaprogram has been explicitly added to this package.</li>
	 * </ul>
	 * 
	 * @param name The name of the compilation unit to check.
	 * @return <code>true</code> if the compilation unit exists; <code>false</code> otherwise.
	 */
	public boolean contains(String name)
	{
		if (compilationUnitNodes.get(name) != null)
		{
			return true;
		}
		return this.packageNodeCallback.contains(this, name);
	}

	/**
	 * Starts to load the specified compilation unit in this package. A compilation unit must be loaded before it is
	 * visible in the package hierarchy. Typically, compilation units are loaded by explicit mention when compilation is
	 * started or by dependency inference (such as when a metaprorgam mentions a dependency on a target which is in a
	 * different file or when a type reference is found in an on-demand import). It is possible for metaprograms to
	 * explicitly load compilation units which are not possible to infer, such as when the name of a compilation unit is
	 * mentioned in metaprogram code but no object program code causes a direct reference.
	 * 
	 * @param name The simple name of the compilation unit to load. No file extension should be provided.
	 * @return The loaded compilation unit.
	 */
	public CompilationUnitNode load(String name)
	{
		// TODO: if a compilation unit was explicitly added to this package node and overrides a source file, we should
		// scream.
		// If we've already loaded this compilation unit, bail out.
		if (compilationUnitNodes.get(name) != null)
		{
			return compilationUnitNodes.get(name);
		}
		return this.packageNodeCallback.load(this, name);
	}

	/**
	 * Performs the load of every compilation unit available in this package.
	 */
	public void loadAll()
	{
		for (String name : packageNodeCallback.listCompilationUnitNames(this))
		{
			load(name);
		}
	}
	/* GEN:stop */
}