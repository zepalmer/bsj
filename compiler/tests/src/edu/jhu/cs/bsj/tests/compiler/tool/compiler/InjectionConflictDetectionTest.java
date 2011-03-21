package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InjectionConfictDiagnostic;

public class InjectionConflictDetectionTest extends AbstractBsjCompilerTest
{
	@Test
	public void testSimpleInjectionConflict() throws Exception
	{
	    performTest("SimpleInjectionConflict", InjectionConfictDiagnostic.class);
	}

	@Test
	public void testSimpleInjectionConflictFix() throws Exception
	{
		performTest("SimpleInjectionConflictFix");
	}
}
