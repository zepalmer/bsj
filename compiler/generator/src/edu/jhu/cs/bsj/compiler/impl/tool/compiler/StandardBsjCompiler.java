package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.JavaToBsjAdaptiveDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This class is a standard implementation of the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public class StandardBsjCompiler implements BsjCompiler
{
	/**
	 * The logging for this compiler.
	 */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/**
	 * The toolkit used to satisfy tool requirements.
	 */
	private BsjToolkit toolkit;
	/**
	 * The node manager which is managing nodes which are passed to this compiler.
	 */
	private BsjNodeManager manager;

	/* *** The following fields are used in compilation. They are not valid unless compilation is in progress. */

	/**
	 * The root package to use.
	 */
	private PackageNode rootPackage;
	/**
	 * Tracks the progress of compilation units through the compilation process. This data structure performs the
	 * accounting of source files and source file-specific data structures.
	 */
	private MetacompilationManager metacompilationManager;

	/**
	 * Creates a new standard BSJ compiler.
	 * 
	 * @param toolkit The toolkit used to satisfy resource requirements.
	 * @param manager The manager which is managing all of the nodes provided to this compiler.
	 */
	public StandardBsjCompiler(BsjToolkit toolkit, BsjNodeManager manager)
	{
		super();
		this.toolkit = toolkit;
		this.manager = manager;
	}

	// TODO: add annotation processing classes and annotation processor objects
	// see JSR-199's JavaCompiler.getTask for more info

	/**
	 * {@inheritDoc}
	 */
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<BsjSourceLocation> listener)
			throws IOException
	{
		compile(units, listener, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<BsjSourceLocation> listener, Random random)
			throws IOException
	{
		if (LOGGER.isDebugEnabled())
		{
			StringBuilder sb = new StringBuilder();
			sb.append("Compilation started: ");
			boolean first = true;
			for (BsjFileObject file : units)
			{
				if (first)
				{
					first = false;
				} else
				{
					sb.append(", ");
				}
				sb.append(file.getName());
			}
			LOGGER.debug(sb.toString());
		}

		// Ensure listener is sane
		if (listener == null)
		{
			listener = new DiagnosticPrintingListener<BsjSourceLocation>(System.err);
		}
		final CountingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener = new CountingDiagnosticProxyListener<BsjSourceLocation>(listener); 

		// Start compilation
		initialize(diagnosticListener, random);

		try
		{
			// Initialize the compilation unit manager with the names of the files it must compile
			CompilationUnitLoader loader = this.toolkit.getCompilationUnitLoaderFactory().makeLoader(diagnosticListener);
			for (BsjFileObject file : units)
			{
				String binaryName = file.inferBinaryName();
				String compilationUnitName = StringUtilities.getSuffix(binaryName, '.');
				PackageNode packageNode;
				if (binaryName.indexOf('.') == -1)
				{
					packageNode = this.rootPackage;
				} else
				{
					String packageName = StringUtilities.removeSuffix(binaryName, '.');
					packageNode = this.rootPackage.getSubpackage(packageName);
				}
				loader.load(packageNode, compilationUnitName);
			}
			
			// If there were no errors in parsing, attempt metacompilation
			if (diagnosticListener.getCount(Kind.ERROR) != 0)
			{
				LOGGER.info(diagnosticListener.getCount(Kind.ERROR) + " errors during initial parsing of source units");
				return;				
			}
			
			// Allow the compilation unit manager to handle the work in the sense of a work queue
			while (!this.metacompilationManager.isFinished())
			{
				this.metacompilationManager.doWork();
			}

			// If errors occurred during metacompilation, bail out.
			if (this.metacompilationManager.getErrorCount() != 0)
			{
				LOGGER.info(this.metacompilationManager.getErrorCount() + " errors during metacompilation");
				return;
			}

			// Now compile everything in the generated source directory
			compileGeneratedSources(diagnosticListener);
			
		} finally
		{
			// Clean up
			terminate();
		}

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Compilation finished.");
		}
	}

	/**
	 * Compiles the generated sources for this compiler.
	 * 
	 * @param listener The listener to which to report diagnostic messages.
	 * @return <code>true</code> on success; <code>false</code> on failure.
	 * @throws IOException If an I/O error occurs.
	 */
	private boolean compileGeneratedSources(DiagnosticListener<BsjSourceLocation> listener) throws IOException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Started compilation of generated sources");
		}
		BsjFileManager bsjFileManager = this.toolkit.getFileManager();
		// Build file manager for the compiler
		Map<StandardLocation, LocationManager> objectProgramLocationMap = new HashMap<StandardLocation, LocationManager>();
		objectProgramLocationMap.put(StandardLocation.SOURCE_PATH,
				bsjFileManager.getLocationManager(BsjCompilerLocation.GENERATED_SOURCE_PATH));
		// TODO: add annotation processing support
		objectProgramLocationMap.put(StandardLocation.SOURCE_OUTPUT, new InMemoryLocationManager(null));
		// TODO: add annotation processing support
		objectProgramLocationMap.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
		objectProgramLocationMap.put(StandardLocation.CLASS_OUTPUT,
				bsjFileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT));
		objectProgramLocationMap.put(StandardLocation.CLASS_PATH,
				bsjFileManager.getLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH));
		objectProgramLocationMap.put(StandardLocation.PLATFORM_CLASS_PATH,
				bsjFileManager.getLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH));

		JavaFileManager objectProgramFileManager = new LocationMappedFileManager(objectProgramLocationMap);

		// Retrieve generated source files
		Iterable<? extends BsjFileObject> files = this.metacompilationManager.getSerializedFiles();
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Generated sources are the following: ");
			for (BsjFileObject file : files)
			{
				LOGGER.trace(" - " + file.getName());
			}
		}

		// Perform compilation
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		CountingDiagnosticProxyListener<JavaFileObject> wrapperListener = new CountingDiagnosticProxyListener<JavaFileObject>(
				new JavaToBsjAdaptiveDiagnosticListener(listener));
		// TODO: trap writer output and diagnostics and interpret them accordingly
		JavaCompiler.CompilationTask task = compiler.getTask(null, objectProgramFileManager, wrapperListener,
				Collections.<String> emptyList(), Collections.<String> emptyList(), files);
		if (!task.call() || wrapperListener.getCount(Kind.ERROR) > 0)
		{
			LOGGER.debug("Compilation of generated sources failed!");
			return false;
		}
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Finished compilation of generated sources");
		}

		return true;
	}

	/**
	 * Initializes the data structures used by the compiler.
	 */
	private void initialize(DiagnosticListener<BsjSourceLocation> listener, Random random)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Initializing compiler data structures.");
		}
		this.rootPackage = toolkit.getNodeFactory().makePackageNode((IdentifierNode)null);
		this.metacompilationManager = new MetacompilationManager(this.toolkit, this.manager, this.rootPackage,
				listener, random);
	}

	/**
	 * Clears all temporary data structures.
	 */
	private void terminate()
	{
		this.metacompilationManager.cleanup();
		this.metacompilationManager = null;
		this.rootPackage = null;
	}
}
