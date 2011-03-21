package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class SingleFileBsjCompilerTest extends AbstractBsjCompilerTest
{
    @Test
    public void testBsjCompiler() throws Exception
    {
        BsjFileManager fileManager = performTest("SingleFileBsjCompilerTest");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass bsjClass = new DynamicClass(loader, "BsjClass");
        DynamicObject bsjObject = bsjClass.newInstance();
        DynamicObject str = bsjObject.call("toString");
        Assert.assertEquals("A,B", str.unwrap());
    }
}
