package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation memoization metaprograms.
 * @author Joseph Riley
 */
public class MetaAnnotationMemoizedMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testMemoization() throws Exception
	{
	    performTest(new String[]{"projects","bsj-tests","Memoized"}, "MemoizedMain", "MemoizedClass");
	}
}
