package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;

public class MetaprogramConflictTest extends AbstractBsjCompilerTest
{
	@Test(expected=MetaprogramConflictException.class)
	public void testPermissionViolation() throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "individual-files" + File.separator + "hand-written"), "MetaprogramConflict");
	}
}
