package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

/**
 * Tests that metaprograms are able to use the nodes that other metaprograms have created as long as they are dependent
 * upon those other metaprograms.
 * 
 * @author Zachary Palmer
 */
public class MetaprogramUseDependenceTest extends AbstractBsjCompilerTest
{
    @Test
    public void testMetaprogramUseDependence() throws Exception
    {
        BsjFileManager manager = performTest("MetaprogramUseDependence");
        ClassLoader loader = manager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass c = new DynamicClass(loader, "MetaprogramUseDependence");
        DynamicObject o = c.newInstance();
        Assert.assertEquals(1, o.call("foo").unwrap());
    }
}
