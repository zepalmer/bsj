package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject.Kind;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.BsjTreeLifter;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkitFactory;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.tests.AbstractPerFileTest;

/**
 * Tests the BsjTreeLifter using the following steps:
 * 
 * 1. Grab an example source file (similar to the RegeneratorTest) 2. Parse it into an AST 3. Pass the AST into the
 * Lifter 4. Embed the block from the Lifter into some wrapper code 5. Compile and run the code from the Lifter using
 * the wrapper code 6. Take the AST generated by the lifted code and pass it through the regenerator, the result should
 * be equal to the original example source (after being passed through the regenerator as well)
 */
public class BsjTreeLifterTest extends AbstractPerFileTest
{
	// private variables used in testing
	private static final String[] META_IMPORTS = { "edu.jhu.cs.bsj.compiler.ast.*",
			"edu.jhu.cs.bsj.compiler.ast.node.*", "edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeFactoryImpl",
			"edu.jhu.cs.bsj.compiler.ast.node.list.*", "edu.jhu.cs.bsj.compiler.ast.node.meta.*", "java.util.*" };
	private BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();
	private String factoryName = "factory";

	/**
	 * Test the BsjTreeLifter on files in the examples directory.
	 */
	@Test
	public void testLifterOnExamples()
	{
		System.out.println("STARTING TESTS WITH " + ((double) (Runtime.getRuntime().maxMemory())) / 1024 / 1024 + "Mb");
		findAndTestJavaFiles(EXAMPLES);
	}

	@Override
	protected boolean doFileTest(File file)
	{
		System.out.println("TESTING " + file);
		return liftJavaFile(file);
	}

	/**
	 * Attempt to lift, recompile, and regenerate a Java file, then compare to the original source.
	 * 
	 * @param file the file to manipulate.
	 * @return true if the lifted, recompiled, and regenerated file is equal to the original (regenerated).
	 */
	public boolean liftJavaFile(File file)
	{
		BsjNodeFactory factory = this.toolkit.getNodeFactory();

		// parse the original source
		Node ast = null;
		try
		{
			ast = toolkit.getParser().parse(StringUtilities.removeSuffix(file.getName(), '.'),
					new InputStreamReader(new FileInputStream(file)), null);
		} catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}

		// regenerate and save the original source
		String originalProgram = ast.executeOperation(toolkit.getSerializer(), null);

		// create a metaFactory for use in the lifted code
		ExpressionNode metaFactory = factory.makeVariableAccessNode(null, factory.makeIdentifierNode(factoryName));

		// get the lifted code
		ExpressionNode metaAst = ast.executeOperation(new BsjTreeLifter(factory), metaFactory);

		// replace expressions w/ methods
		List<MethodDeclarationNode> methods = divideLiftIntoMethods(metaAst, factory);

		// compile the lifted code and get the result
		String liftedProgram = null;
		try
		{
			liftedProgram = compileMeta(metaAst, factoryName, methods).executeOperation(toolkit.getSerializer(), null);
		} catch (Exception e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}

		// compare the original (regenerated) to the lifted, recompiled and regenerated
		if (!originalProgram.equals(liftedProgram))
		{
			LOGGER.error("Original program does not match lifted program!\n" + originalProgram + "\n\n" + liftedProgram);
			return false;
		} else
		{
			return true;
		}
	}

	/**
	 * Mutates metaAst by removing expressions down to a certain depth and replacing them with method invocations.
	 * 
	 * @param metaAst the lifted AST to be divided.
	 * @return the list of method declarations corresponding to the mutated AST.
	 */
	private List<MethodDeclarationNode> divideLiftIntoMethods(ExpressionNode metaAst, BsjNodeFactory factory)
	{
		List<MethodDeclarationNode> methods = new ArrayList<MethodDeclarationNode>();
		metaAst.receiveTyped(new BsjLiftedCodeVisitor(methods, factory));
		return methods;
	}

	/**
	 * Compiles and runs a block of code which generates a lifted AST.
	 * 
	 * @param code the AST for generating the lifted AST.
	 * @param factoryName the name of the meta factory referenced in the lifted AST.
	 * @param methods list of method declarations for methods used in meta code
	 * @return the lifted AST.
	 */
	public CompilationUnitNode compileMeta(ExpressionNode code, String factoryName, List<MethodDeclarationNode> methods)
			throws Exception
	{
		// build the source for the wrapper that runs the lifted code
		StringBuilder sb = new StringBuilder();
		for (String s : META_IMPORTS)
		{
			sb.append("import ").append(s).append(";\n");
		}
		sb.append("public class WrapperClass\n{\n");
		sb.append("private BsjNodeFactory " + factoryName + ";\n");
		sb.append("public WrapperClass(BsjNodeFactory " + factoryName + ")\n");
		sb.append("{\n");
		sb.append("    this." + factoryName + " = " + factoryName + ";\n");
		sb.append("}\n");
		sb.append("public Node runLiftedCode()\n{\n\nreturn ");
		sb.append(code.executeOperation(toolkit.getSerializer(), null));
		sb.append(";\n}\n");
		for (MethodDeclarationNode method : methods)
		{
			sb.append(method.executeOperation(toolkit.getSerializer(), null));
			sb.append("\n");
		}
		sb.append("\n}");
		String wrapperCode = sb.toString();

		// setup the compilation environment
		BsjFileManager bfm = getFileManager(null);

		// get our wrapper source file
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Generated wrapper code: " + wrapperCode);
		}
		BsjFileObject bfo = bfm.getJavaFileForOutput(BsjCompilerLocation.SOURCE_PATH, "WrapperClass", Kind.SOURCE, null);
		bfo.setCharContent(wrapperCode);
		try
		{
			List<BsjFileObject> fileObjects = Arrays.asList(bfo);

			// create a toolkit
			BsjToolkitFactory toolkitFactory = BsjServiceRegistry.newToolkitFactory();
			toolkitFactory.setFileManager(bfm);
			BsjToolkit toolkit = toolkitFactory.newToolkit();

			// compile
			CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
					new DiagnosticListener<BsjSourceLocation>()
					{
						@Override
						public void report(Diagnostic<? extends BsjSourceLocation> diagnostic)
						{
							System.err.println(diagnostic.getMessage(null));
						}
					});
			toolkit.getCompiler().compile(fileObjects, listener);
			Assert.assertTrue(listener.getCount(Diagnostic.Kind.ERROR) == 0);

			// run the compiled wrapper and return the node created by the lifted code
			Class<?> wrapper = bfm.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT).loadClass("WrapperClass");
			Method method = wrapper.getDeclaredMethod("runLiftedCode", (Class<?>[]) null);
			Object object = wrapper.getConstructor(BsjNodeFactory.class).newInstance(toolkit.getNodeFactory());
			bfm.close();
			return (CompilationUnitNode) method.invoke(object, (Object[]) null);
		} finally
		{
			bfo.delete();
		}
	}
}
