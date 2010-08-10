package edu.jhu.cs.bsj.compiler.impl.ast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.NonConflictingReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.PackageCompilationUnitAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.PackageNodeImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.MultiplexingDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.BsjBinaryNodeLoader;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * A callback module for package nodes. This allows package nodes to request the load of specific compilation units into
 * the compiler.
 * 
 * @author Zachary Palmer
 */
public class PackageNodeManager
{
	/** The logger for this class. */
	private static final Logger LOGGER = Logger.getLogger(PackageNodeManager.class);

	/** The toolkit to use during callback operations. */
	private BsjToolkit toolkit;

	/** The manager for callbacks (since this module is separated only for organizational reasons. */
	private BsjNodeManager manager;

	/** A set of event listeners. */
	private Set<PackageNodeListener> listeners = new HashSet<PackageNodeListener>(1);

	public PackageNodeManager(BsjToolkit toolkit, BsjNodeManager manager)
	{
		super();
		this.toolkit = toolkit;
		this.manager = manager;
	}

	public void addListener(PackageNodeListener listener)
	{
		this.listeners.add(listener);
	}

	public void removeListener(PackageNodeListener listener)
	{
		this.listeners.remove(listener);
	}

	public void fireCompilationUnitAdded(PackageNode packageNode, CompilationUnitNode compilationUnitNode,
			boolean purelyInjected)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			// TODO-SOON: we have no way of knowing if this was a pure injection or not
			listener.compilationUnitAdded(packageNode, compilationUnitNode, purelyInjected);
		}
	}

	public void fireSubpackageAdded(PackageNode packageNode, PackageNode subPackageNode)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			listener.subpackageAdded(packageNode, subPackageNode);
		}
	}

	public void fireRegisterAsInjector(CompilationUnitNode compilationUnitNode)
	{
		for (PackageNodeListener listener : this.listeners)
		{
			listener.compilationUnitInjected(compilationUnitNode);
		}
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
	 * 
	 * @param pname The name of the package.
	 * @param binaryOnly <code>true</code> if only binaries should be listed; <code>false</code> if sources should be
	 *            listed as well.
	 */
	protected List<BsjFileObject> findCompilationUnits(String pname, boolean binaryOnly)
	{
		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		Set<String> names = new HashSet<String>();
		try
		{
			if (!binaryOnly)
			{
				for (BsjFileObject file : this.toolkit.getFileManager().listFiles(BsjCompilerLocation.SOURCE_PATH,
						pname, Arrays.asList(Kind.OTHER), false))
				{
					if (StringUtilities.getSuffix(file.getName(), '.').equals("bsj"))
					{
						if (names.add(getCompilationUnitName(file)) && !binaryOnly)
						{
							files.add(file);
						}
					}
				}

				for (BsjFileObject file : this.toolkit.getFileManager().listFiles(BsjCompilerLocation.SOURCE_PATH,
						pname, Arrays.asList(Kind.SOURCE), false))
				{
					if (names.add(getCompilationUnitName(file)) && !binaryOnly)
					{
						files.add(file);
					}
				}
			}

			for (BsjFileObject file : this.toolkit.getFileManager().listFiles(
					BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH, pname, Arrays.asList(Kind.CLASS), false))
			{
				// TODO: exclude class files which represent inner classes, etc.
				if (names.add(getCompilationUnitName(file)))
				{
					files.add(file);
				}
			}

			for (BsjFileObject file : this.toolkit.getFileManager().listFiles(
					BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH, pname, Arrays.asList(Kind.CLASS), false))
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
			throw new NotImplementedYetException(ioe);
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

		for (BsjFileObject file : findCompilationUnits(pname, false))
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
	 * @param listener A diagnostic listener to receive any error messages which may occur. If <code>null</code>, the
	 *            provided diagnostic listener is not used. The provided diagnostic listener is not the only listener to
	 *            receive the diagnostics; diagnostics will also be reported through the package node listeners attached
	 *            to this manager.
	 * @return The {@link CompilationUnitNode} which was found or <code>null</code> if no such compilation unit exists.
	 * @throws IllegalStateException If no compilation is currently under way.
	 */
	public CompilationUnitNode load(PackageNode packageNode, String name, DiagnosticListener<BsjSourceLocation> listener)
	{
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

		DiagnosticListener<BsjSourceLocation> diagnosticListener;
		if (listener == null)
		{
			diagnosticListener = new MultiplexingDiagnosticListener(this.listeners);
		} else
		{
			Set<DiagnosticListener<BsjSourceLocation>> listeners = new HashSet<DiagnosticListener<BsjSourceLocation>>(
					this.listeners);
			listeners.add(listener);
			diagnosticListener = new MultiplexingDiagnosticListener(listeners);
		}

		for (BsjFileObject file : findCompilationUnits(pname, false))
		{
			if (getCompilationUnitName(file).equals(name))
			{
				return load(packageNode, name, diagnosticListener, file);
			}
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("No such compilation unit " + name + " exists in package node \""
					+ packageNode.getFullyQualifiedName() + "\"");
		}

		return null;
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
	public CompilationUnitNode load(PackageNode packageNode, String name,
			DiagnosticListener<BsjSourceLocation> diagnosticListener, BsjFileObject file)
	{
		// First, see if we already have this compilation unit.
		// TODO-SOON: doesn't this prevent an indirect injector from getting recognized?
		this.manager.pushNull();
		try
		{
			CompilationUnitNode compilationUnitNode = packageNode.getCompilationUnit(name);
			if (compilationUnitNode != null)
			{
				// Then this has already been loaded or otherwise overridden
				return compilationUnitNode;
			}
		} finally
		{
			this.manager.popAll();
		}

		// Go try to load the compilation unit.
		try
		{
			this.manager.pushNull();
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

			// 2. record the access
			packageNodeImpl.getPackageCompilationUnitAttribute(name).recordAccess(
					PackageCompilationUnitAttribute.AccessType.LOAD);
			packageNodeImpl.getIteratorAttribute().recordAccess(NonConflictingReadWriteAttribute.AccessType.WRITE);

			// 3. fire the injector report
			fireRegisterAsInjector(compilationUnitNode);

			return compilationUnitNode;
		} catch (IOException e)
		{
			// TODO: how to handle this?
			throw new NotImplementedYetException(e);
		} finally
		{
			this.manager.popAll();
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
		for (BsjFileObject file : findCompilationUnits(pname, binaryOnly))
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
		return this.toolkit.getNodeFactory();
	}
}
