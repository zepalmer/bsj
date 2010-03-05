package edu.jhu.cs.bsj.tests.compiler.tool.bcel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileObject.Kind;

import junit.framework.Assert;

import org.junit.Test;

import edu.jhu.cs.bsj.compiler.BsjServiceRegistry;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.BsjBinaryNodeLoader;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.InMemoryLocationManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.LocationMappedFileManager;
import edu.jhu.cs.bsj.compiler.impl.tool.filemanager.UnionLocationManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileManager;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;
import edu.jhu.cs.bsj.tests.AbstractTest;


public class BsjBinaryNodeLoaderTest extends AbstractTest
{
    @Test
    public void testJavaCompilerWithInMemoryLocationManager() throws Exception
    {
        log4jConfigure("trace");

        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();

        Map<StandardLocation, LocationManager> map = new HashMap<StandardLocation, LocationManager>();
        map.put(StandardLocation.SOURCE_PATH, new InMemoryLocationManager(null));
        map.put(StandardLocation.SOURCE_OUTPUT, new InMemoryLocationManager(null));
        map.put(StandardLocation.PLATFORM_CLASS_PATH, new UnionLocationManager(null,
                System.getProperty("sun.boot.class.path")));
        map.put(StandardLocation.CLASS_PATH, new UnionLocationManager(null, 
                System.getProperty("java.class.path")));
        map.put(StandardLocation.CLASS_OUTPUT, new InMemoryLocationManager(null));
        map.put(StandardLocation.ANNOTATION_PROCESSOR_PATH, new InMemoryLocationManager(null));
        BsjFileManager bfm = new LocationMappedFileManager(map);

        String codeStr = "package joe.foo.bar;\nimport java.util.List;" 
            + "public class JoeClass <T extends SmallClass & Iface,V> {" 
            + "private boolean x = true;\n"
            + "private List<String> list;\n"
            + "public String toString(){"
            + "return(\"Hello Joe!\");" + "}" + "}";
        String codeStr2 = "package joe.foo.bar; public interface SmallClass extends Iface{}";
        String codeStr3 = "package joe.foo.bar; public interface Iface {}";

        BsjFileObject bfo2 = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "joe.foo.bar.JoeClass", Kind.SOURCE, null);
        bfo2.setCharContent(codeStr);
        
        BsjFileObject bfo = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "joe.foo.bar.SmallClass", Kind.SOURCE, null);
        bfo.setCharContent(codeStr2);
        
        BsjFileObject bfo3 = bfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "joe.foo.bar.Iface", Kind.SOURCE, null);
        bfo3.setCharContent(codeStr3);

        List<JavaFileObject> fileObjects = Arrays.<JavaFileObject> asList(bfo, bfo2, bfo3);

        // The next step is to compile Iterable collection of java files and close file manager:

        if (!(jc.getTask(null, bfm, null, null, null, fileObjects).call()))
        {
            Assert.fail("Compilation failure.");
        }
        bfm.close();

        BsjNodeFactory factory = BsjServiceRegistry.newToolkitFactory().newToolkit().getNodeFactory();

        BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(factory);
        CompilationUnitNode joe = loader.loadNodesFromBinary("joe.foo.bar.JoeClass", map.get(StandardLocation.CLASS_OUTPUT));
        loader.loadNodesFromBinary("joe.foo.bar.SmallClass", map.get(StandardLocation.CLASS_OUTPUT));
        
        System.out.println(joe.executeOperation(
                BsjServiceRegistry.newToolkitFactory().newToolkit().getSerializer(), null));
        
        //TODO assert the proper form of the loaded AST
        
//        Object o = bfm.getClassLoader(StandardLocation.CLASS_OUTPUT).loadClass("JoeClass").newInstance();
//        Assert.assertEquals("Hello Joe!", o.toString());
    }
}
