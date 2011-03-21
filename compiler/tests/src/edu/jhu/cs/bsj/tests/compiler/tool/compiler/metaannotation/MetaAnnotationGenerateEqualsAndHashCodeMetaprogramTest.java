package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests the behavior of the BSJ <tt>@@GenerateEqualsAndHashCode</tt> meta-annotation.
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationGenerateEqualsAndHashCodeMetaprogramTest extends AbstractBsjCompilerTest
{
    @Test
    public void testGenerateEqualsAndHashCode() throws Exception
    {
        BsjFileManager manager = performTest("GenerateEqualsAndHashCode");
        ClassLoader loader = manager.getClassLoader(BsjCompilerLocation.CLASS_OUTPUT);

        DynamicObject o1, o1copy, o2, o3;

        DynamicClass inheritsFromObject = new DynamicClass(loader, "InheritsFromObjectWithEquals");
        o1 = inheritsFromObject.newInstance(5);
        o1copy = inheritsFromObject.newInstance(5);
        o2 = inheritsFromObject.newInstance(4);
        Assert.assertEquals(o1.unwrap(), o1copy.unwrap());
        Assert.assertNotSame(o1.unwrap(), o2.unwrap());

        DynamicClass inheritsFromObjectWithoutEquals = new DynamicClass(loader, "InheritsFromObjectWithoutEquals");
        o1 = inheritsFromObjectWithoutEquals.newInstance(5);
        o1copy = inheritsFromObjectWithoutEquals.newInstance(5);
        Assert.assertNotSame(o1.unwrap(), o1copy.unwrap());

        DynamicClass inheritsFromClass = new DynamicClass(loader, "InheritsFromClass");
        o1 = inheritsFromClass.newInstance(5, 4);
        o1copy = inheritsFromClass.newInstance(5, 4);
        o2 = inheritsFromClass.newInstance(5, 3);
        o3 = inheritsFromClass.newInstance(4, 4);
        Assert.assertEquals(o1.unwrap(), o1copy.unwrap());
        Assert.assertNotSame(o1.unwrap(), o2.unwrap());
        Assert.assertNotSame(o1.unwrap(), o3.unwrap());
        Assert.assertNotSame(o2.unwrap(), o3.unwrap());

        DynamicClass inheritsFromClassWithoutEquals = new DynamicClass(loader, "InheritsFromClassWithoutEquals");
        o1 = inheritsFromClassWithoutEquals.newInstance(5, 4);
        o1copy = inheritsFromClassWithoutEquals.newInstance(5, 4);
        o2 = inheritsFromClassWithoutEquals.newInstance(5, 3);
        o3 = inheritsFromClassWithoutEquals.newInstance(4, 4);
        Assert.assertEquals(o1.unwrap(), o1copy.unwrap());
        Assert.assertNotSame(o1.unwrap(), o2.unwrap());
        Assert.assertEquals(o1.unwrap(), o3.unwrap());
        Assert.assertNotSame(o2.unwrap(), o3.unwrap());
    }
}
