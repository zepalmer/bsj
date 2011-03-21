package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import java.util.Locale;

import javax.tools.Diagnostic.Kind;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.UserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnostic;

public class UserDiagnosticTest extends AbstractBsjCompilerTest
{
	@Test
	public void testCyclicDependency() throws Exception
	{
	    performTest("UserDiagnosticTest", UserDiagnostic.class);
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
