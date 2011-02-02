package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;

public class ListNodeFilterConflictTest extends AbstractBsjCompilerTest
{
	@Test
	public void testListNodeFilterConflict() throws Exception
	{
	    performTest(new String[]{"projects","bsj-tests","ListNodeFilterConflict"}, new String[]{"ListNodeFilterConflict"},
	            Collections.singletonList(MetaprogramListConflictDiagnostic.class));
	}
}
