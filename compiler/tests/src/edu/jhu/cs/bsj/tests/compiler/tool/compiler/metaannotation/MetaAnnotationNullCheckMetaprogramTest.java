package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import org.junit.Assert;
import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make use of meta-annotation null check metaprograms.
 * 
 * @author Joseph Riley
 */
public class MetaAnnotationNullCheckMetaprogramTest extends AbstractBsjCompilerTest
{
    @Test
    public void testBsjCompiler() throws Exception
    {
        BsjFileManager fileManager = performTest("NullCheck");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicObject obj = new DynamicClass(loader, "NullCheck").newInstance();

        // Expected NOT to throw an exception
        obj.call("foo", 2, new Object(), "test", new int[] { 1, 2, 3 });

        try
        {
            // Expected to throw an exception
            obj.call("foo", 2, null, "test", new int[] { 1, 2, 3 });
            Assert.fail("Failed to raise IllegalArgumentException for null value");
        } catch (IllegalArgumentException e)
        {
        }

        try
        {
            // Expected to throw an exception
            obj.call("foo", 2, new Object(), null, new int[] { 1, 2, 3 });
            Assert.fail("Failed to raise IllegalArgumentException for null value");
        } catch (IllegalArgumentException e)
        {
        }

        try
        {
            // Expected to throw an exception
            obj.call("bar", 2, null, "test", new int[] { 1, 2, 3 });
            Assert.fail("Failed to raise IllegalArgumentException for null value");
        } catch (IllegalArgumentException e)
        {
        }

        // Expected NOT to throw an exception
        obj.call("bar", 2, new Object(), null, new int[] { 1, 2, 3 });
    }
}
