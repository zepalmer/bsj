package edu.jhu.cs.bsj.tests.compiler.tool.compiler.codeliteral;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class BsjCodeSpliceTest extends AbstractBsjCompilerTest
{
    @Test
    public void testCodeSpliceParsing() throws Exception
    {
        BsjFileManager fileManager = performTest("CodeSplice");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        new DynamicClass(loader, "CodeSpliceClass$E").field("A");
        new DynamicClass(loader, "CodeSpliceClass$E").field("B");
        Assert.assertEquals("I", loader.loadClass("CodeSpliceClass$C1").getInterfaces()[0].getSimpleName());
        Assert.assertEquals("I", loader.loadClass("CodeSpliceClass$C2").getInterfaces()[0].getSimpleName());
    }

    @Test
    public void testCodeSpliceParsingForLists() throws Exception
    {
        BsjFileManager fileManager = performTest("CodeListSplice");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass codeListSpliceClass = new DynamicClass(loader, "CodeListSpliceClass");
        Assert.assertEquals(7, codeListSpliceClass.call("foo", 5).unwrap());
    }
}
