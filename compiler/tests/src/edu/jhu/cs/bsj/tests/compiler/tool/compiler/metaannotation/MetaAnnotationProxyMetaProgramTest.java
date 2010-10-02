package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation proxy metaprograms.
 * @author Uday Garikipati
 */
public class MetaAnnotationProxyMetaProgramTest  extends AbstractBsjCompilerTest{

	@Test
	public void testBsjCompiler() throws Exception
	{
					
		performTest(new File(EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
				+ "metaannotation-test"), "com/bar/FooImpl","ProxyClass");
			
	}

}
