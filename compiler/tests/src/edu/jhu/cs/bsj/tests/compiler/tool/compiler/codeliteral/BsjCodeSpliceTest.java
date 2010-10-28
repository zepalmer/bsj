package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BsjCodeSpliceTest extends AbstractBsjCompilerTest
{
    @Test
    public void testCodeSpliceParsing() throws Exception
    {
        performTest(SPECIFIC_SOURCE_DIR, "CodeSpliceClass");
    }

    @Test
    public void testCodeSpliceParsingForLists() throws Exception
    {
        performTest(SPECIFIC_SOURCE_DIR, "CodeListSpliceClass");
    }
}
