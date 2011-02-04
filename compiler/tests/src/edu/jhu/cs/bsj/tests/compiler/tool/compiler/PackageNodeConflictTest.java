package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPackageConflictDiagnostic;

public class PackageNodeConflictTest extends AbstractBsjCompilerTest
{
	private static final File SOURCE_DIR = new File(SPECIFIC_SOURCE_DIR + File.separator + "conflicts" + File.separator);

	@Test
	public void testPackageConflict() throws Exception
	{
		performTest(SOURCE_DIR, Arrays.asList("PackageConflict"),
				Collections.singletonList(MetaprogramPackageConflictDiagnostic.class));
	}
}
