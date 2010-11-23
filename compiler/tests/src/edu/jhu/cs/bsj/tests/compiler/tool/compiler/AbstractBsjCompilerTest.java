package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.tools.Diagnostic;
import javax.tools.Diagnostic.Kind;
import javax.tools.DiagnosticListener;

import org.junit.Assert;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDetectedErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramExceptionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.RecordingDiagnosticProxyListener;
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
     * Convenience method which performs a compilation operation test using the provided array of pathnames as
     * subdirectories of the examples directory.
     */
    protected void performTest(String[] sourcePathElements, String... paths) throws Exception
    {
        File dir = EXAMPLES;
        for (String element : sourcePathElements)
        {
            dir = new File(dir.getPath() + File.separator + element);
        }
        performTest(dir, paths);
    }
    
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
				Throwable cause = (diagnostic instanceof MetaprogramExceptionDiagnostic) ? ((MetaprogramExceptionDiagnostic) diagnostic).getException()
						: null;
				throw new IllegalStateException("Error during compilation: " + diagnostic.getMessage(null), cause);
			}
		}
		Class<?> c = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass(paths[0].replaceAll("/", "."));
		Method mainMethod = c.getMethod("main", String[].class);
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
				for (Diagnostic<? extends BsjSourceLocation> diagnostic : diagnostics)
				{
					LOGGER.debug(diagnostic);
				}
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
	protected List<Diagnostic<? extends BsjSourceLocation>> performTest(BsjFileManager fileManager, List<String> paths)
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
			// TODO: condition on whether or not the file already has an extension?
			filename = filename + ".bsj";
			BsjFileObject bfo = fileManager.getFileForInput(BsjCompilerLocation.SOURCE_PATH, packageString, filename);
			files.add(bfo);
		}

		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(fileManager);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		RecordingDiagnosticProxyListener<BsjSourceLocation> diagnosticListener = new RecordingDiagnosticProxyListener<BsjSourceLocation>(
				new DiagnosticListener<BsjSourceLocation>()
				{
					@Override
					public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
					{
						System.err.println(diagnostic.getMessage(null));
						if (diagnostic instanceof MetaprogramDetectedErrorDiagnostic<?>)
						{
							MetaprogramDetectedErrorDiagnostic<?> d = (MetaprogramDetectedErrorDiagnostic<?>) diagnostic;
							System.err.println("Exception is: ");
							d.getException().printStackTrace();
						}
					}
				});
		Random random;
		if (System.getProperty("bsj.tests.seed") == null)
		{
			random = null;
		} else
		{
			random = new Random(Integer.parseInt(System.getProperty("bsj.tests.seed")));
		}
		compiler.compile(files, diagnosticListener, random);

		return diagnosticListener.getDiagnostics();
	}
}
