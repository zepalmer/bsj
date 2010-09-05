package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeUtilities;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.NonConflictingReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.PackageCompilationUnitAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.BsjBinaryNodeLoader;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

public class CompilationUnitLoaderImpl implements CompilationUnitLoader
{
	private static final Logger LOGGER = Logger.getLogger(CompilationUnitLoaderImpl.class);

	/** The toolkit to back the requested operations. */
	private BsjToolkit toolkit;
	/** The node manager which controls the nodes. */
	private BsjNodeManager nodeManager;
	/** The diagnostic listener to which errors will be reported. */
	private DiagnosticListener<BsjSourceLocation> diagnosticListener;

	public CompilationUnitLoaderImpl(BsjToolkit toolkit, BsjNodeManager nodeManager,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		super();
		this.toolkit = toolkit;
		this.nodeManager = nodeManager;
		this.diagnosticListener = diagnosticListener;
	}

	private static class LoadCacheKey
	{
		private PackageNode packageNode;
		private String name;

		public LoadCacheKey(PackageNode packageNode, String name)
		{
			super();
			this.packageNode = packageNode;
			this.name = name;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((packageNode == null) ? 0 : packageNode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LoadCacheKey other = (LoadCacheKey) obj;
			if (name == null)
			{
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (packageNode == null)
			{
				if (other.packageNode != null)
					return false;
			} else if (!packageNode.equals(other.packageNode))
				return false;
			return true;
		}
	}

	private Set<LoadCacheKey> alreadyFailedToLoad = new HashSet<LoadCacheKey>();

	@Override
	public CompilationUnitNode load(PackageNode packageNode, String name)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Loading compilation unit " + name + " in package node \""
					+ packageNode.getFullyQualifiedName() + "\"");
		}

		// First, record this access
		// TODO: clean this up - it's sloppy. It's based on a true invariant - that the package is compatible - but
		// it's still quite sloppy.
		PackageNodeImpl packageNodeImpl = (PackageNodeImpl) packageNode;
		packageNodeImpl.getPackageCompilationUnitAttribute(name).recordAccess(
				PackageCompilationUnitAttribute.AccessType.LOAD);
		packageNodeImpl.getIteratorAttribute().recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);

		// If we already have such a compilation unit, just use that one
		CompilationUnitNode compilationUnitNode = packageNode.getCompilationUnit(name);
		if (compilationUnitNode != null)
		{
			// Then this has already been loaded or otherwise overridden
			return compilationUnitNode;
		}

		LoadCacheKey key = new LoadCacheKey(packageNode, name);
		if (!this.alreadyFailedToLoad.contains(key))
		{
			// Otherwise, we have to go searching
			String pname = packageNode.getFullyQualifiedName();
			if (pname != null)
			{
				for (BsjFileObject file : PackageNodeUtilities.findCompilationUnits(this.toolkit.getFileManager(),
						pname, false))
				{
					if (PackageNodeUtilities.getCompilationUnitName(file).equals(name))
					{
						compilationUnitNode = actualLoad(packageNode, name, this.diagnosticListener, file);
						break;
					}
				}
			}
		}

		if (compilationUnitNode == null)
		{
			this.alreadyFailedToLoad.add(key);
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace("No such compilation unit " + name + " exists in package node \""
						+ packageNode.getFullyQualifiedName() + "\"");
			}
		} else
		{
			if (LOGGER.isTraceEnabled())
			{
				LOGGER.trace("Completed load of compilation unit " + name + " in package node "
						+ packageNode.getFullyQualifiedName());
			}
		}

		return compilationUnitNode;
	}

	@Override
	public void loadAll(PackageNode packageNode)
	{
		for (String name : listCompilationUnitNames(packageNode, false))
		{
			load(packageNode, name);
		}
	}

	/**
	 * Requests the load of a single compilation unit.
	 * 
	 * @param packageNode The package into which the compilation unit will be loaded.
	 * @param name The name of the compilation unit.
	 * @param diagnosticListener The listener to which errors will be reported.
	 * @param file The file from which to load the compilation unit.
	 * @return The compilation unit if it was loaded; <code>null</code> if it could not be loaded.
	 */
	private CompilationUnitNode actualLoad(PackageNode packageNode, String name,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, BsjFileObject file)
	{
		// Try to load the compilation unit.
		try
		{
			this.nodeManager.pushNull();
			CompilationUnitNode compilationUnitNode;
			if (file.getKind() == Kind.CLASS)
			{
				BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(this.toolkit.getNodeFactory());
				compilationUnitNode = loader.loadNodesFromBinary(file);
			} else
			{
				compilationUnitNode = this.toolkit.getParser().parse(name, file.openReader(true), diagnosticListener);
			}

			if (compilationUnitNode == null)
			{
				return null;
			}

			// TODO: this is sort of sloppy; can we clean it up at all?
			// it's based on the invariant that nodes must be compatible, so it's correct... just nasty
			PackageNodeImpl packageNodeImpl = (PackageNodeImpl) packageNode;

			// 1. add the compilation unit
			packageNodeImpl.addCompilationUnit(compilationUnitNode, false);

			// 2. fire the injector report
			this.nodeManager.getPackageNodeManager().fireRegisterAsInjector(compilationUnitNode);

			return compilationUnitNode;
		} catch (IOException e)
		{
			// TODO: how to handle this?
			throw new NotImplementedYetException(e);
		} finally
		{
			this.nodeManager.popAll();
		}
	}

	/**
	 * Lists all of the compilation units which appear to be in the specified package.
	 * 
	 * @param packageNode The package node making the request.
	 * @param binaryOnly <code>true</code> if only binaries should be listed; <code>false</code> if sources should be
	 *            listed as well.
	 * @return An iterator over the names of the compilation units in the package.
	 */
	public List<String> listCompilationUnitNames(PackageNode packageNode, boolean binaryOnly)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return Collections.<String> emptyList();
		}

		List<String> names = new ArrayList<String>();
		for (BsjFileObject file : PackageNodeUtilities.findCompilationUnits(toolkit.getFileManager(), pname, binaryOnly))
		{
			names.add(PackageNodeUtilities.getCompilationUnitName(file));
		}
		return names;
	}
}
