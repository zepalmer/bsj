package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BigIntegersTypecheckTest extends AbstractBsjCompilerTest
{
    @Test
    public void testBigIntegerTypechecking() throws Exception
    {
        performTest("BigIntegersTypechecking");
    }
}
