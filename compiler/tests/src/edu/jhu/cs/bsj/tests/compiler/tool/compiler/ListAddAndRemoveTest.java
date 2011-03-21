package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

/**
 * Tests that additions and removals to a given list during the same metaprogram are properly applied when the final
 * patch is made.
 * 
 * @author Zachary Palmer
 */
public class ListAddAndRemoveTest extends AbstractBsjCompilerTest
{
    @Test
    public void testListManipulation() throws Exception
    {
        performTest("ListAddRemove");
    }
}
