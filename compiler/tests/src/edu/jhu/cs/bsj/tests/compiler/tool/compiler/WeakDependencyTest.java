package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramEmptyDependencyDiagnostic;

/**
 * Tests some sources that make simplistic use of meta-annotation metaprograms.
 * 
 * @author Zachary Palmer
 */
public class WeakDependencyTest extends AbstractBsjCompilerTest
{
	@Test
	public void testWeakDependencySuccess() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "WeakDependencySuccess");
	}

	@Test
	public void testStrongDependencyFailure() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, Arrays.asList("StrongDependencyFailure"),
				Collections.singletonList(MetaprogramEmptyDependencyDiagnostic.class));
	}
}
