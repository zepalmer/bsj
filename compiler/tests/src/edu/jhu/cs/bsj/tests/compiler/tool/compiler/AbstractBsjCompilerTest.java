package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;

import org.junit.Assert;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.BsjCompiler;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.tests.AbstractTest;

public abstract class AbstractBsjCompilerTest extends AbstractTest
{
	/**
	 * Performs a BSJ compilation operation test. This method compiles and runs a BSJ program.
	 * 
	 * @param sourcePath The root directory containing the sources.
	 * @param paths The paths of the source files to compile. The first file is assumed to be the main class.
	 * @throws Exception If anything goes wrong.
	 */
	protected void performTest(File sourcePath, String... paths) throws Exception
	{
		BsjFileManager bfm = getFileManager(sourcePath);
		List<Diagnostic<? extends BsjSourceLocation>> diagnostics = performTest(bfm, Arrays.asList(paths));
		for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
		{
			if (diagnostic.getKind() == Kind.ERROR)
			{
				throw new IllegalStateException("Error during compilation: " + diagnostic.getMessage(null));
			}
		}
		Object o = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass(paths[0].replaceAll("/", ".")).newInstance();
		Method mainMethod = o.getClass().getMethod("main", String[].class);
		mainMethod.invoke(null, new Object[] { new String[0] });
	}

	/**
	 * Performs a BSJ compilation operation test. This method compiles a BSJ program and expects a failure.
	 * 
	 * @param sourcePath The root directory containing the sources.
	 * @param paths The paths of the source files to compile. The first file is assumed to be the main class.
	 * @throws Exception If anything goes "wrong". This includes cases in which the expected diagnostics do not occur.
	 */
	protected <T extends BsjDiagnostic> void performTest(File sourcePath, List<String> paths,
			List<Class<T>> diagnosticTypes) throws Exception
	{
		BsjFileManager bfm = getFileManager(sourcePath);
		List<Diagnostic<? extends BsjSourceLocation>> diagnostics = performTest(bfm, paths);

		for (Class<? extends BsjDiagnostic> type : diagnosticTypes)
		{
			boolean found = false;
			for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
			{
				if (type.isInstance(diagnostic))
				{
					found = true;
				}
			}
			if (!found)
			{
				Assert.fail("Diagnostic type " + type + " was not observed!");
			}
		}
	}

	/**
	 * Performs a compilation test.
	 * 
	 * @param fileManager The file manager to use.
	 * @param paths The paths of the files to compile.
	 * @return The diagnostics which were observed.
	 * @throws Exception If anything goes wrong.
	 */
	private List<Diagnostic<? extends BsjSourceLocation>> performTest(BsjFileManager fileManager, List<String> paths)
			throws Exception
	{
		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		for (String path : paths)
		{
			String packageString;
			String filename;
			if (path.indexOf('/') != -1)
			{
				packageString = path.substring(0, path.lastIndexOf('/')).replaceAll("/", ".");
				filename = path.substring(path.lastIndexOf('/') + 1);
			} else
			{
				packageString = "";
				filename = path;
			}
			filename = filename + ".bsj";
			BsjFileObject bfo = fileManager.getFileForInput(BsjCompilerLocation.SOURCE_PATH, packageString, filename);
			files.add(bfo);
		}

		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		RecordingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
				new DiagnosticPrintingListener<BsjSourceLocation>(System.err));
		compiler.compile(files, diagnosticListener);

		return diagnosticListener.getDiagnostics();
	}
}
