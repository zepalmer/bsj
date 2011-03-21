package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramEmptyDependencyDiagnostic;

/**
 * Tests some sources that make simplistic use of meta-annotation metaprograms.
 * 
 * @author Zachary Palmer
 */
public class WeakDependencyTest extends AbstractBsjCompilerTest
{
    @Test
    public void testWeakDependencySuccess() throws Exception
    {
        performTest("WeakDependencySuccess");
    }

    @Test
    public void testStrongDependencyFailure() throws Exception
    {
        performTest("StrongDependencyFailure", MetaprogramEmptyDependencyDiagnostic.class);
    }
}
