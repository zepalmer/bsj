package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation builder metaprograms.
 * @author Joseph Riley
 */
public class MetaAnnotationBuilderMetaprogramTest extends AbstractBsjCompilerTest
{
	@Test
	public void testBuilder() throws Exception
	{
	    performTest(new String[]{"projects","bsj-tests","Builder"}, "BuilderMain", "BuilderClass", "BuilderClassOther");
	}
}
