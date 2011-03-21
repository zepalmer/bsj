package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import org.junit.Test;

public class TypeParameterCaptureTest extends AbstractTypecheckerTest
{
    @Test
    public void testCaptureTypechecking() throws Exception
    {
        performTest("Capture");
    }
}
