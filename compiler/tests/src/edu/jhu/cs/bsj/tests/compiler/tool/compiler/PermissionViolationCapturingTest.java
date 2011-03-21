package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InsufficientPermissionDiagnostic;

public class PermissionViolationCapturingTest extends AbstractBsjCompilerTest
{
    @Test
    public void testPermissionViolation() throws Exception
    {
        performTest("PermissionViolation", InsufficientPermissionDiagnostic.class);
    }

    @Test
    public void testListPermissionViolation() throws Exception
    {
        performTest("ListPermissionViolation", InsufficientPermissionDiagnostic.class);
    }

	@Test
	public void testPermissionRequest() throws Exception
	{
	    performTest("PermissionRequest");
	}
}
