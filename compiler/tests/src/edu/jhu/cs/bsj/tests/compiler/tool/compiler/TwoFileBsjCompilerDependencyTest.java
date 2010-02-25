package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

public class TwoFileBsjCompilerDependencyTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
				+ "two-file-bsj-compiler-dependency-test"), "A", "B");
	}
}
