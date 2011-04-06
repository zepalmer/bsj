package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class ExplicitContextFeaturesTest extends AbstractBsjCompilerTest
{
    @Test
    public void testExplicitContextFeatures() throws Exception
    {
        BsjFileManager fileManager = performTest("ExplicitContextFeatures");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass bsjClass = new DynamicClass(loader, "ExplicitContextFeatures");
        DynamicObject bsjObject = bsjClass.newInstance();
        Assert.assertEquals(16, bsjObject.call("getX").unwrap());
    }
}
