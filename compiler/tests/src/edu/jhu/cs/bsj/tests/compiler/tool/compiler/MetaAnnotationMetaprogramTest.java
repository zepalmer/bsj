package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

/**
 * Tests some sources that make simplistic use of meta-annotation metaprograms.
 * @author Zachary Palmer
 */
public class MetaAnnotationMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBsjCompiler() throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
				+ "metaannotation-test"), "Main", "Point");
	}
}
