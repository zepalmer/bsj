import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

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
	public void addPackageNode(PackageNode packageNode)
	{
		this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
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
		this.compilationUnitNodes.put(compilationUnit.getName(), compilationUnit);
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
	 * <p/>
	 * It should be noted that this method will return without completing the compilation unit loading operation. Due to
	 * the fact that parsing, name analysis, and other such steps are required before the compilation unit becomes
	 * visible in the tree, the compilation unit will not become available until the next metaprogram starts. For that
	 * reason, an asynchronous programming approach to loading compilation units is recommended. Consider the following
	 * example:
	 * 
	 * <pre>
	 * [:
	 *     #target load;
	 *     ...
	 *     packageNode.load(compilationUnitName);
	 * :]
	 * [:
	 *     #depends load;
	 *     // operations which depend on the loaded compilation unit
	 *     ...
	 * :]
	 * </pre>
	 * 
	 * @param name The simple name of the compilation unit to load. No file extension should be provided.
	 * @return <code>true</code> if the compilation unit was located and will be loaded; <code>false</code> if it has
	 *         already been loaded.
	 * @throws FileNotFoundException If the specified compilation unit does not exist.
	 */
	public boolean load(String name) throws FileNotFoundException
	{
		// TODO: if a compilation unit was explicitly added to this package node and overrides a source file, we should
		// scream.
		// If we've already loaded this compilation unit, bail out.
		if (compilationUnitNodes.get(name) != null)
		{
			return false;
		}
		if (this.packageNodeCallback.load(this, name))
		{
			return true;
		} else
		{
			String pname = getFullyQualifiedName();
			if (pname == null)
				pname = getName().getIdentifier();
			throw new FileNotFoundException("Could not find compilation unit named " + name + " in package " + pname);
		}
	}

	/**
	 * Performs the load of every compilation unit available in this package.
	 * 
	 * @return <code>true</code> if at least one new compilation unit will be loaded; <code>false</code> if the entire
	 *         package has already been loaded.
	 */
	public boolean loadAll()
	{
		boolean ret = false;
		for (String name : packageNodeCallback.listCompilationUnitNames(this))
		{
			try
			{
				ret |= load(name);
			} catch (FileNotFoundException fnfe)
			{
				// This only happens if a file was deleted from the file system.
				// Current policy: ignore that.
				// TODO: this indicates some kind of inconsistency of the file system during compilation. Scream?
			}
		}
		return ret;
	}
	/* GEN:stop */
}