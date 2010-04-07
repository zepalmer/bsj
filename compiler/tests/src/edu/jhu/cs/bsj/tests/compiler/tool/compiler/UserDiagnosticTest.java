package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import javax.tools.Diagnostic.Kind;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.UserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;

public class UserDiagnosticTest extends AbstractBsjCompilerTest
{
	protected void testFile(String name) throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, name);
	}
	
	protected void testFile(String name, Class<? extends BsjDiagnostic> expected) throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, Arrays.asList(name),
				Collections.singletonList(expected));
	}

	@Test
	public void testCyclicDependency() throws Exception
	{
		testFile("UserDiagnosticTest", UserDiagnostic.class);
	}
	
	public static class TestDiagnostic implements BsjUserDiagnostic
	{
		@Override
		public Kind getKind()
		{
			return Kind.ERROR;
		}
		
		@Override
		public String getCode()
		{
			return "bsj.test.diagnostic.TestDiagnostic";
		}

		@Override
		public String getMessage(Locale locale)
		{
			return "User Diagnostic Test Message";
		}
	}
}
