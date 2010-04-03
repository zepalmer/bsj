package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

public class SingleFileBsjCompilerTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "BsjClass");
	}
}
