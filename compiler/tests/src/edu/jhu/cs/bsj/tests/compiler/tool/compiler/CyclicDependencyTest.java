package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;

public class CyclicDependencyTest extends AbstractBsjCompilerTest
{
	@Test
	public void testCyclicDependency() throws Exception
	{
	    performTest("CyclicDependency", DependencyCycleDiagnostic.class);
	}
}
