package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
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
	 * Performs a BSJ compilation operation test.  This method compiles and runs a BSJ program.
	 * 
	 * @param sourcePath The root directory containing the sources.
	 * @param paths The paths of the source files to compile.  The first file is assumed to be the main class.
	 * @throws Exception If anything goes wrong.
	 */
	protected void performTest(File sourcePath, String... paths) throws Exception
	{
		log4jConfigure("trace", "edu.jhu.cs.bsj.compiler.impl.tool.filemanager/debug",
				"edu.jhu.cs.bsj.compiler.tool.parser.antlr/debug");

		BsjFileManager bfm = getFileManager(sourcePath);

		List<BsjFileObject> files = new ArrayList<BsjFileObject>();
		for (String path : paths)
		{
			String packageString;
			String filename;
			if (path.indexOf('/') != -1)
			{
				packageString = path.substring(0, path.lastIndexOf('/')).replaceAll("/", ".");
				filename = path.substring(path.lastIndexOf('/')+1);
			} else
			{
				packageString = "";
				filename = path;
			}
			filename = filename + ".bsj";
			BsjFileObject bfo = bfm.getFileForInput(BsjCompilerLocation.SOURCE_PATH, packageString, filename);
			files.add(bfo);
		}
		
		BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
		toolkitFactory.setFileManager(bfm);
		BsjToolkit toolkit = toolkitFactory.newToolkit();

		BsjCompiler compiler = toolkit.getCompiler();
		compiler.compile(files, null);

		Object o = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass(paths[0].replaceAll("/",".")).newInstance();
		Method mainMethod = o.getClass().getMethod("main", String[].class);
		mainMethod.invoke(null, new Object[]{new String[0]});
	}
}
