package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

/**
 * Tests some sources that make use of meta-annotation memoization metaprograms.
 * @author Joseph Riley
 */
public class MetaAnnotationMemoizedMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
				+ "metaannotation-test"), "MemoizedMain", "MemoizedClass");
	}
}