package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

public class MetaAnnotationForwarderMetaprogramTest extends AbstractBsjCompilerTest {
		@Test
		public void testBsjCompiler() throws Exception
		{
			String s = EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
			+ "metaannotation-test";
			performTest(new File(s), "MyForwarder", "Test");
		}
}
