package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramConflictDiagnostic;

public class MetaprogramConflictTest extends AbstractBsjCompilerTest
{
	private static final File SOURCE_DIR = new File(SPECIFIC_SOURCE_DIR + File.separator + "conflicts");

    @Test
    public void testPermissionViolation() throws Exception
    {
        performTest(SOURCE_DIR, Arrays.asList("MetaprogramConflict"),
                Collections.singletonList(MetaprogramConflictDiagnostic.class));
    }

    @Test
    public void testTopLevelPermissionViolation() throws Exception
    {
        performTest(SOURCE_DIR, Arrays.asList("MetaprogramTopLevelConflict"),
                Collections.singletonList(MetaprogramConflictDiagnostic.class));
    }

	@Test
	public void testPermissionsWithExplicitOrder() throws Exception
	{
		performTest(SOURCE_DIR, "MetaprogramCooperation");
	}

	@Test
	public void testPermissionsWithOrderIndependentWrites() throws Exception
	{
		performTest(SOURCE_DIR, "MetaprogramDualWriteCooperation");
	}
}
