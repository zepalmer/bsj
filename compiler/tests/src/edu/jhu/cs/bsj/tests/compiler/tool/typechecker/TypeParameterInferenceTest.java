package edu.jhu.cs.bsj.tests.compiler.tool.typechecker;

import org.junit.Test;

public class TypeParameterInferenceTest extends AbstractTypecheckerTest
{
    @Test
    public void testTypeParameterInference() throws Exception
    {
        performTest("TypeParameterInference");
    }
}
