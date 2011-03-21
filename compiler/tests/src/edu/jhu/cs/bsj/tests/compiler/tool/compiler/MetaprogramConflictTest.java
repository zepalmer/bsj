package edu.jhu.cs.bsj.tests.compiler.tool.compiler;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPropertyConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjCompilerLocation;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;

public class MetaprogramConflictTest extends AbstractBsjCompilerTest
{
    @Test
    public void testPropertyConflict() throws Exception
    {
        performTest("PropertyConflict", MetaprogramPropertyConflictDiagnostic.class);
    }
    
    @Test
    public void testPropertyDependence() throws Exception
    {
        performTest("PropertyDependence");
    }
    
    @Test
    public void testPropertyReadWriteOkay() throws Exception
    {
        performTest("ReadWriteOkay");
    }
    
    @Test
    public void testOrderedListConflict() throws Exception
    {
        performTest("OrderedListConflict", MetaprogramListConflictDiagnostic.class);
    }
    
    @Test
    public void testUnorderedListOkay() throws Exception
    {
        BsjFileManager fileManager = performTest("UnorderedListOkay");
        ClassLoader loader = fileManager.getLocationManager(BsjCompilerLocation.CLASS_OUTPUT).getClassLoader();
        DynamicClass c = new DynamicClass(loader, "UnorderedListOkay");
        DynamicObject o = c.newInstance();
        o.call("foo");
        o.call("bar");
        o.call("baz");
    }
}
