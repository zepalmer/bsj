package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InjectionConfictDiagnostic;

public class InjectionConflictDetectionTest extends AbstractBsjCompilerTest
{
	protected void testFile(String name) throws Exception
	{
		performTest(new File(SPECIFIC_SOURCE_DIR + File.separator + "conflicts"), name);
	}
	
	protected void testFile(String name, Class<? extends BsjDiagnostic> expected) throws Exception
	{
		performTest(new File(SPECIFIC_SOURCE_DIR + File.separator + "conflicts"), Arrays.asList(name),
				Collections.singletonList(expected));
	}

	@Test
	public void testSimpleInjectionConflict() throws Exception
	{
		testFile("SimpleInjectionConflict", InjectionConfictDiagnostic.class);
	}

	@Test
	public void testSimpleInjectionConflictFix() throws Exception
	{
		testFile("SimpleInjectionConflictFix");
	}
}
