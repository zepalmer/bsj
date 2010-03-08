package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;

public class PermissionViolationCapturingTest extends AbstractBsjCompilerTest
{
	@Test(expected=InsufficientPermissionException.class)
	public void testBsjCompiler() throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "individual-files" + File.separator + "hand-written"), "PermissionViolation");
	}
}
