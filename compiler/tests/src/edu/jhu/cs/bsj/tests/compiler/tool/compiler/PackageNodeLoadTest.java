package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

public class PackageNodeLoadTest extends AbstractBsjCompilerTest
{
	private static final File sourceDir = new File(EXAMPLES + File.separator + "projects" + File.separator
			+ "bsj-tests" + File.separator + "package-load-test");

	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(sourceDir, "Main");
	}
}
