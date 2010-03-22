package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;

public class MetaprogramConflictTest extends AbstractBsjCompilerTest
{
	protected void testFile(String name) throws Exception
	{
		performTest(new File(EXAMPLES + File.separator + "individual-files" + File.separator + "hand-written" +
				File.separator + "conflicts"), name);
	}
	
	@Test(expected=MetaprogramConflictException.class)
	public void testPermissionViolation() throws Exception
	{
		testFile("MetaprogramConflict");
	}
	
	@Test
	public void testPermissionsWithExplicitOrder() throws Exception
	{
		testFile("MetaprogramCooperation");
	}
	
	@Test
	public void testPermissionsWithOrderIndependentWrites() throws Exception
	{
		testFile("MetaprogramDualWriteCooperation");
	}
}
