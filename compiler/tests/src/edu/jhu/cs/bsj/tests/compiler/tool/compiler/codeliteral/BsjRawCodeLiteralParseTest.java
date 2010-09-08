package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BsjRawCodeLiteralParseTest extends AbstractBsjCompilerTest
{
	@Test
	public void testRawCodeLiteralParsing() throws Exception
	{
		performTest(SPECIFIC_SOURCE_DIR, "RawCodeLiteralClass");
	}
}
