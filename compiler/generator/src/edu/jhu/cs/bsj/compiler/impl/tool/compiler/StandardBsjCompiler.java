package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;

/**
 * This class is a standard implementation of the BSJ compiler.
 * 
 * @author Zachary Palmer
 */
public class StandardBsjCompiler implements BsjCompiler
{
	// TODO: export some of these functions to the BsjCompiler interface.
	// TODO: consider factory for construction
	/**
	 * The {@link BsjFileManager} used for the filesystem abstraction.
	 */
	private BsjFileManager bsjFileManager;

	/**
	 * The logging for this compiler.
	 */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/*        *** The following fields are used in compilation. They are not valid unless compilation is in progress. */

	/**
	 * Tracks the progress of compilation units through the compilation process. This data structure performs the
	 * accounting of source files and source file-specific data structures.
	 */
	private MetacompilationManager compilationUnitManager;

	// TODO: allow factory to be specified by user?
	/**
	 * The factory used to create AST nodes.
	 */
	private BsjNodeFactory factory;

	/**
	 * Creates a new standard BSJ compiler.
	 * 
	 * @param bsjFileManager The file management abstraction to use during compilation. This file manager must be able
	 *            to handle all locations in {@link BsjCompilerLocation}.
	 */
	public StandardBsjCompiler(BsjFileManager bsjFileManager)
	{
		super();
		this.bsjFileManager = bsjFileManager;
		this.factory = new BsjNodeFactoryImpl(); // TODO: get default factory through SPI
	}

	// TODO: allow the caller to specify a listener to receive exceptions in real time (as opposed to in batch)
	// The Java Compiler API provides DiagnosticListener, for instance.

	// TODO: add annotation processing classes and annotation processor objects
	// see JSR-199's JavaCompiler.getTask for more info

	/**
	 * Compiles the specified compilation units. These units must exist on the {@link BsjFileManager} provided to this
	 * compiler at construction. If this method terminates normally, compilation was successful.
	 * 
	 * @param units The compilation units to compile.
	 * @throws BsjCompilerException If compilation fails.
	 * @throws IOException If an I/O error occurs.
	 */
	public void compile(Iterable<BsjFileObject> units) throws BsjCompilerException, IOException
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

		// Start compilation
		initialize();

		// Initialize the compilation unit manager with the names of the files it must compile
		for (BsjFileObject file : units)
		{
			this.compilationUnitManager.addTarget(file);
		}

		// Allow the compilation unit manager to handle the work in the sense of a work queue
		while (!this.compilationUnitManager.isFinished())
		{
			this.compilationUnitManager.doWork();
		}

		// Now compile everything in the generated source directory
		compileGeneratedSources();

		// TODO: rest of compilation (or is this it?)

		// Clean up
		// TODO: should we ensure that terminate is called even when an exception is thrown?
		terminate();
	}

	private void compileGeneratedSources() throws BsjCompilerException, IOException
	{
		// Build file manager for the compiler
		Map<StandardLocation, LocationManager> objectProgramLocationMap = new HashMap<StandardLocation, LocationManager>();
		objectProgramLocationMap.put(StandardLocation.SOURCE_PATH,
				this.bsjFileManager.getLocationManager(BsjCompilerLocation.GENERATED_SOURCE_PATH));
		// TODO: add annotation processing support
		objectProgramLocationMap.put(StandardLocation.SOURCE_OUTPUT, new InMemoryLocationManager(null));
		// TODO: add annotation processing support
		objectProgramLocationMap.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
		objectProgramLocationMap.put(StandardLocation.CLASS_OUTPUT,
				this.bsjFileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT));
		objectProgramLocationMap.put(StandardLocation.CLASS_PATH,
				this.bsjFileManager.getLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_CLASSPATH));
		objectProgramLocationMap.put(StandardLocation.PLATFORM_CLASS_PATH,
				this.bsjFileManager.getLocationManager(BsjCompilerLocation.OBJECT_PROGRAM_SYSTEM_CLASSPATH));
		
		JavaFileManager objectProgramFileManager = new LocationMappedFileManager(objectProgramLocationMap);

		// Retrieve generated source files
		Iterable<? extends BsjFileObject> files = this.bsjFileManager.listFiles(
				BsjCompilerLocation.GENERATED_SOURCE_PATH, "", Arrays.asList(Kind.SOURCE), true);

		// Perform compilation
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// TODO: trap writer output and diagnostics and throw them as exceptions
		JavaCompiler.CompilationTask task = compiler.getTask(null, objectProgramFileManager, null,
				Collections.<String> emptyList(), Collections.<String> emptyList(), files);
		if (!task.call())
		{
			// TODO: something a teensy bit more elegant
			throw new IllegalStateException("Error during compilation!");
		}
	}

	/**
	 * Initializes the data structures used by the compiler.
	 */
	private void initialize()
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Initializing compiler data structures.");
		}
		this.compilationUnitManager = new MetacompilationManager(this.factory, this.bsjFileManager);
	}

	/**
	 * Clears all temporary data structures.
	 */
	private void terminate()
	{
		this.compilationUnitManager = null;
	}
}
