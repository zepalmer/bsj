package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;

public class PermissionViolationCapturingTest extends AbstractBsjCompilerTest
{
	@Test(expected=InsufficientPermissionException.class)
	public void testPermissionViolation() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "PermissionViolation");
	}
	
	@Test
	public void testPermissionRequest() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "PermissionRequest");
	}
}
