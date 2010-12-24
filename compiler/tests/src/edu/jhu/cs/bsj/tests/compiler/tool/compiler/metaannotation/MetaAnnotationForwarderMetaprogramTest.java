package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Test;

import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class MetaAnnotationForwarderMetaprogramTest extends AbstractBsjCompilerTest
{
    @Test
    public void testForwarder() throws Exception
    {
        performTest(new String[] { "projects", "bsj-tests", "Forwarder" }, "mypackage/MyForwarder", "mypackage/Test");
    }
}
