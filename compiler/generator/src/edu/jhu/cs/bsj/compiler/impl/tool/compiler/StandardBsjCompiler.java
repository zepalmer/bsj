package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.PackageNodeCallback;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
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
	 * The package callback module used in package nodes.
	 */
	private PackageNodeCallback packageNodeCallback;
	/**
	 * The node manager which is managing nodes which are passed to this compiler.
	 */
	private BsjNodeManager manager;

	/*  *** The following fields are used in compilation. They are not valid unless compilation is in progress. */

	/**
	 * Tracks the progress of compilation units through the compilation process. This data structure performs the
	 * accounting of source files and source file-specific data structures.
	 */
	private MetacompilationManager metacompilationManager;

	/**
	 * Creates a new standard BSJ compiler.
	 * 
	 * @param toolkit The toolkit used to satisfy resource requirements.
	 * @param packageNodeCallback The {@link PackageNodeCallback} to manipulate when compilation starts.
	 * @param manager The manager which is managing all of the nodes provided to this compiler.
	 */
	public StandardBsjCompiler(BsjToolkit toolkit, PackageNodeCallback packageNodeCallback, BsjNodeManager manager)
	{
		super();
		this.toolkit = toolkit;
		this.packageNodeCallback = packageNodeCallback;
		this.manager = manager;
	}

	// TODO: add annotation processing classes and annotation processor objects
	// see JSR-199's JavaCompiler.getTask for more info

	/**
	 * Compiles the specified compilation units. These units must exist on the {@link BsjFileManager} provided to this
	 * compiler at construction. If this method terminates normally, compilation was successful.
	 * 
	 * @param units The compilation units to compile.
	 * @param listener The diagnostic listener to which events should be reported. If <code>null</code>, a default
	 *            listener is used which reports diagnostic messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public void compile(Iterable<BsjFileObject> units, DiagnosticListener<? super JavaFileObject> listener)
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
			listener = new DiagnosticPrintingListener<JavaFileObject>(System.err);
		}

		// Start compilation
		initialize(listener);

		// Initialize the compilation unit manager with the names of the files it must compile
		for (BsjFileObject file : units)
		{
			this.metacompilationManager.addCompilationUnit(file);
		}

		// Allow the compilation unit manager to handle the work in the sense of a work queue
		while (!this.metacompilationManager.isFinished())
		{
			this.metacompilationManager.doWork();
		}

		// Now compile everything in the generated source directory
		compileGeneratedSources();

		// Clean up
		// TODO: should we ensure that terminate is called even when an exception is thrown?
		terminate();
		
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Compilation finished.");
		}
	}

	private void compileGeneratedSources() throws IOException
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
		// TODO: trap writer output and diagnostics and interpret them accordingly
		JavaCompiler.CompilationTask task = compiler.getTask(null, objectProgramFileManager, null,
				Collections.<String> emptyList(), Collections.<String> emptyList(), files);
		if (!task.call())
		{
			LOGGER.error("Compilation of generated sources failed!");
			// TODO: something a teensy bit more elegant
			throw new IllegalStateException("Error during compilation!");
		}
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Finished compilation of generated sources");
		}
	}

	/**
	 * Initializes the data structures used by the compiler.
	 */
	private void initialize(DiagnosticListener<? super JavaFileObject> listener)
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Initializing compiler data structures.");
		}
		this.metacompilationManager = new MetacompilationManager(this.toolkit, this.manager, listener);
		this.packageNodeCallback.setMetacompilationManager(metacompilationManager);
	}

	/**
	 * Clears all temporary data structures.
	 */
	private void terminate()
	{
		this.metacompilationManager = null;
		this.packageNodeCallback.setMetacompilationManager(null);
	}
}
