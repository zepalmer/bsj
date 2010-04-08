package edu.jhu.cs.bsj.compiler.impl.ast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationManager;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * A callback module for package nodes. This allows package nodes to request the load of specific compilation units into
 * the compiler.
 * 
 * @author Zachary Palmer
 */
public class PackageNodeCallback
{
	/** The logger for this class. */
	private static final Logger LOGGER = Logger.getLogger(PackageNodeCallback.class);

	/** The factory to use when creating nodes. */
	private BsjNodeFactory factory;
	/** The file manager to use in this callback. */
	private BsjFileManager fileManager;
	/** The metacompilation manager to notify of new file additions. */
	private MetacompilationManager metacompilationManager;

	public void setFileManager(BsjFileManager fileManager)
	{
		this.fileManager = fileManager;
	}

	public void setMetacompilationManager(MetacompilationManager metacompilationManager)
	{
		this.metacompilationManager = metacompilationManager;
	}

	public void setFactory(BsjNodeFactory factory)
	{
		this.factory = factory;
	}

	/**
	 * Determines the compilation unit name of the specified BSJ file object.
	 * 
	 * @param bsjFileObject The object to process.
	 * @return The compilation unit name of that object.
	 */
	protected String getCompilationUnitName(BsjFileObject bsjFileObject)
	{
		return StringUtilities.getSuffix(bsjFileObject.inferBinaryName(), '.');
	}

	/**
	 * Creates an iterable object which moves over {@link BsjFileObject}s which represent compilation units in the
	 * current package.
	 */
	protected List<BsjFileObject> findCompilationUnits(String pname)
	{
		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		Set<String> names = new HashSet<String>();
		try
		{
			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
					Arrays.asList(Kind.OTHER), false))
			{
				if (StringUtilities.getSuffix(file.getName(), '.').equals("bsj"))
				{
					if (names.add(getCompilationUnitName(file)))
					{
						files.add(file);
					}
				}
			}

			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.SOURCE_PATH, pname,
					Arrays.asList(Kind.SOURCE), false))
			{
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}

			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, pname,
					Arrays.asList(Kind.CLASS), false))
			{
				// TODO: exclude class files which represent inner classes, etc.
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}

			for (BsjFileObject file : this.fileManager.listFiles(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH,
					pname, Arrays.asList(Kind.CLASS), false))
			{
				// TODO: exclude class files which represent inner classes, etc.
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}
		} catch (IOException ioe)
		{
			// TODO: how do we handle this?
			throw new IllegalStateException(ioe);
		}

		return files;
	}

	/**
	 * Asks whether or not a compilation unit of the specified name exists.
	 * 
	 * @param packageNode The package node making the request.
	 * @param name The name of the compilation unit.
	 * @return <code>true</code> if the compilation unit exists; <code>false</code> otherwise.
	 */
	public boolean contains(PackageNode packageNode, String name)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return false;
		}

		for (BsjFileObject file : findCompilationUnits(pname))
		{
			if (StringUtilities.getSuffix(file.inferBinaryName(), '.').equals(name))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Requests the load of a single compilation unit.
	 * 
	 * @param packageNode The package node making the request.
	 * @param name The name of the compilation unit.
	 * @return The {@link CompilationUnitNode} which was found or <code>null</code> if no such compilation unit exists.
	 * @throws IllegalStateException If no compilation is currently under way.
	 */
	public CompilationUnitNode load(PackageNode packageNode, String name)
	{
		// TODO: is this really the right behavior?
		// Examine runtime non-compilation use cases of the factory and see if this makes sense
		if (this.metacompilationManager == null)
			throw new IllegalStateException("Request to load source when no compilation is under way.");

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Loading compilation unit " + name + " in package node \""
					+ packageNode.getFullyQualifiedName() + "\"");
		}

		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return null;
		}

		for (BsjFileObject file : findCompilationUnits(pname))
		{
			if (getCompilationUnitName(file).equals(name))
			{
				return this.metacompilationManager.addCompilationUnitNow(file);
			}
		}

		return null;
	}

	/**
	 * Lists all of the compilation units which appear to be in the specified package.
	 * 
	 * @param packageNode The package node making the request.
	 * @return An iterator over the names of the compilation units in the package.
	 */
	public List<String> listCompilationUnitNames(PackageNode packageNode)
	{
		String pname = packageNode.getFullyQualifiedName();
		if (pname == null)
		{
			return Collections.<String> emptyList();
		}

		List<String> names = new ArrayList<String>();
		for (BsjFileObject file : findCompilationUnits(pname))
		{
			names.add(getCompilationUnitName(file));
		}
		return names;
	}

	/**
	 * Retrieves a factory to use to create nodes.
	 */
	public BsjNodeFactory getFactory()
	{
		return factory;
	}

	/**
	 * Registers the currently-running metaprogram as an injector of the specified compilation unit node. This operation
	 * is used to ensure that metaprograms which were extracted when the specified compilation unit node was loaded will
	 * be dependent upon the currently running metaprogram (because it would've been one of potentially many
	 * metaprograms which could load that compilation unit).
	 * 
	 * @param node The compilation unit for which to register as an injector.
	 */
	public void registerAsInjectorOf(CompilationUnitNode node)
	{
		Integer id = this.metacompilationManager.getNodeManager().getCurrentMetaprogramId();
		if (id == null)
		{
			return;
		}
		this.metacompilationManager.getDependencyManager().registerAsInjectorOf(
				this.metacompilationManager.getDependencyManager().getMetaprogramProfileByID(id), node,
				this.metacompilationManager.getDiagnosticListener());
	}
}
