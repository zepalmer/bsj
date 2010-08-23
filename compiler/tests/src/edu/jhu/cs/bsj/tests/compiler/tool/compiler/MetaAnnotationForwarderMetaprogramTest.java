package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

public class MetaAnnotationForwarderMetaprogramTest extends AbstractBsjCompilerTest {
		@Test
		public void testBsjCompiler() throws Exception
		{
			String s = EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
			+ "Forwarder";
			performTest(new File(s), "mypackage/MyForwarder", "mypackage/Test");
		}
}
