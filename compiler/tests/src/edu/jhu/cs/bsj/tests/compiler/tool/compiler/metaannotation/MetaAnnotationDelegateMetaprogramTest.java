package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

public class MetaAnnotationDelegateMetaprogramTest extends AbstractBsjCompilerTest
{
    @Test
    public void testDelegate() throws Exception
    {
        BsjFileManager fileManager = performTest("Delegates");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass delegateClass = new DynamicClass(loader, "mypackage.DelegateClass");
        DynamicObject obj = delegateClass.newInstance();

        obj.call("increment");
        Assert.assertEquals(1, obj.call("current").unwrap());
        obj.call("increment");
        Assert.assertEquals(2, obj.call("current").unwrap());

        Assert.assertEquals(0, obj.call("nameCount").unwrap());
        obj.call("addName", "name1");
        obj.call("addName", "name2");
        obj.call("addName", "name2");
        Assert.assertEquals(2, obj.call("nameCount").unwrap());
        Assert.assertEquals(true, obj.call("contains", "name2").unwrap());
        Assert.assertEquals(false, obj.call("contains", "angrymonkey").unwrap());
    }
}
