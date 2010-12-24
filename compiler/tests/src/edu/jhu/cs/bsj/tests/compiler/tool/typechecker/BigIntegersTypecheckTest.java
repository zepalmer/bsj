package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import java.io.File;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BigIntegersTypecheckTest extends AbstractBsjCompilerTest
{
    @Test
    public void testBigIntegerTypechecking() throws Exception
    {
        performTest(new File(SPECIFIC_SOURCE_DIR.getPath() + File.separator + "typechecking" + File.separator
                + "biginteger"), "BigIntegersCheck");
    }

}
