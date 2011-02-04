package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Collections;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;

public class ListNodeFilterChangeConflictTest extends AbstractBsjCompilerTest
{
	@Test
	public void testListNodeFilterChangeConflict() throws Exception
	{
	    performTest(new String[]{"projects","bsj-tests","ListNodeFilterChangeConflict"}, new String[]{"ListNodeFilterChangeConflict"},
	            Collections.singletonList(MetaprogramListConflictDiagnostic.class));
	}
}
