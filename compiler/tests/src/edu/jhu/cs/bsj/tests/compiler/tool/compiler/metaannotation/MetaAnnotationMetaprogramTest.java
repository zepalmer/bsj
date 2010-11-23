package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make simplistic use of meta-annotation metaprograms.
 * @author Zachary Palmer
 */
public class MetaAnnotationMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testPointClass() throws Exception
	{
	    performTest(new String[]{"projects","bsj-tests","Point"}, "Main", "Point");
	}
}
