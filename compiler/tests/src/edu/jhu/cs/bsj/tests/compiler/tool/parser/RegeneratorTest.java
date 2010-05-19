package edu.jhu.cs.bsj.tests.compiler.tool.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;
import edu.jhu.cs.bsj.tests.AbstractPerFileTest;

public class RegeneratorTest extends AbstractPerFileTest
{
	@Test
	public void testRegeneratorOnExamples()
	{
		findAndTestJavaFiles(EXAMPLES);
	}

	@Override
	protected boolean doFileTest(File file) throws Exception
	{
		if (file.getName().endsWith(".bsj") || file.getName().endsWith(".java"))
		{
			return regenerateJavaFile(file);
		} else
		{
			return true;
		}
	}

	/**
	 * Regenerate a Java file once, then again using the regenerated source as input. Verify the two regenerated copies
	 * of the source are the same.
	 * 
	 * @param file the Java file to test.
	 * @return true on success, false on failure.
	 * @throws Exception on error.
	 */
	private boolean regenerateJavaFile(File file) throws Exception
	{
		BsjToolkit toolkit = BsjServiceRegistry.newToolkitFactory().newToolkit();

		// read the java file in
		FileInputStream input = new FileInputStream(file);

		// parse it to an AST
		Node ast = toolkit.getParser().parse(StringUtilities.removeSuffix(file.getName(), '.'),
				new InputStreamReader(input), null);

		// regenerate it once
		String regen1 = ast.executeOperation(toolkit.getSerializer(), null);

		// use the regenerated version to create another AST
		Node newAst = toolkit.getParser().parse(StringUtilities.removeSuffix(file.getName(), '.'),
				new InputStreamReader(new ByteArrayInputStream(regen1.getBytes())), null);

		// regenerate it again from the new AST
		String regen2 = newAst.executeOperation(toolkit.getSerializer(), null);

		// the twice regenerated source should equal the once regenerated source
		return regen1.equals(regen2);
	}
}
