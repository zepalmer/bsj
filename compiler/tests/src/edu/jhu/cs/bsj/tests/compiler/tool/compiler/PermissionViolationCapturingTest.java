package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InsufficientPermissionDiagnostic;

public class PermissionViolationCapturingTest extends AbstractBsjCompilerTest
{
	@Test
	public void testPermissionViolation() throws Exception
	{
		super.performTest(SPECIFIC_SOURCE_DIR, Arrays.asList("PermissionViolation"),
				Collections.singletonList(InsufficientPermissionDiagnostic.class));
	}

	@Test
	public void testPermissionRequest() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "PermissionRequest");
	}
}
