package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;

public class CyclicDependencyTest extends AbstractBsjCompilerTest
{
	protected void testFile(String name) throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, name);
	}
	
	protected void testFile(String name, Class<? extends BsjDiagnostic> expected) throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, Arrays.asList(name),
				Collections.singletonList(expected));
	}

	@Test
	public void testCyclicDependency() throws Exception
	{
		testFile("CyclicDependency", DependencyCycleDiagnostic.class);
	}
}
