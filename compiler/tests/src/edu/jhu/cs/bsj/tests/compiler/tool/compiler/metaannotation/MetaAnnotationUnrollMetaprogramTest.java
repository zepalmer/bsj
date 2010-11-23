package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation unroll metaprograms.
 * @author Uday Garikipati
 */
public class MetaAnnotationUnrollMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(new String[]{"projects","bsj-tests","Unroll"}, "UnrollClass");
	}
}
