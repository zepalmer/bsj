package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DuplicatePackageMemberDiagnostic;

public class PackageNodeConflictTest extends AbstractBsjCompilerTest
{
	@Test
	public void testPackageConflict() throws Exception
	{
	    performTest("PackageConflict", Arrays.<String>asList("PackageConflict"), Collections.singletonList(DuplicatePackageMemberDiagnostic.class));
	}
}
