package edu.jhu.cs.bsj.tests.compiler.tool.compiler.metaannotation;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.tests.compiler.tool.compiler.AbstractBsjCompilerTest;

/**
 * Tests some sources that make simplistic use of meta-annotation metaprograms.
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationMetaprogramTest extends AbstractBsjCompilerTest
{
    @Test
    public void testPointClass() throws Exception
    {
        BsjFileManager fileManager = performTest("Point");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass pointClass = new DynamicClass(loader, "Point");
        DynamicObject p1 = pointClass.newInstance(0,0);
        DynamicObject p2 = pointClass.newInstance(3,4);
        DynamicObject p3 = pointClass.newInstance(0,0);
        Set<Object> set = new HashSet<Object>();
        set.add(p1.unwrap());
        set.add(p2.unwrap());
        set.add(p3.unwrap());
        
        Assert.assertEquals(2, set.size());
        Assert.assertEquals(p1.unwrap(), p3.unwrap());
        Assert.assertEquals(5.0, p1.call("getDistance", p2.unwrap()).unwrap());
    }

    @Test
    public void testCardClass() throws Exception
    {
        // TODO: add some tests to ensure that the Card class behaves the way it should
        performTest("Card");
    }
}
