package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class MetaAnnotationDelegateMetaprogramTest extends AbstractBsjCompilerTest {
		@Test
		public void testDelegate() throws Exception
		{
			String s = EXAMPLES + File.separator + "projects" + File.separator + "bsj-tests" + File.separator
			+ "Delegates";
			performTest(new File(s), "mypackage/DelegateClass", "mypackage/Test");
		}
}
