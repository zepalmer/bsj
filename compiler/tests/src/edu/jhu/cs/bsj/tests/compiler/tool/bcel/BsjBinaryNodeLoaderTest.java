package edu.jhu.cs.bsj.tests.compiler.tool.bcel;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
    /**
     * Iterates over all the precompiled binaries that Java offers
     * and loads them using the binary node loader.
     * @throws Exception on error.
     */
    @Test
    public void testBinaryLoaderWithJavaClasses() throws Exception
    {
        log4jConfigure("trace");
        
        // setup factory, loader, and location (Java's own class path)
        BsjNodeFactory factory = BsjServiceRegistry.newToolkitFactory().newToolkit().getNodeFactory();
        BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(factory);
        LocationManager javaLocation = new UnionLocationManager(null, System.getProperty("sun.boot.class.path"));

        // get an iterator over all Java language binaries we can
        Iterator<? extends BsjFileObject> iter = 
            javaLocation.listFiles("java",  Arrays.<Kind> asList(Kind.CLASS), true).iterator();
        
        // load and test every binary        
        BsjFileObject file;
        int i = 1;
        while (iter.hasNext())
        {   
            file = iter.next();
            LOGGER.info("Now testing file " + i + ", " + file.inferBinaryName());
            assertNotNull(loader.loadNodesFromBinary(file.inferBinaryName(), javaLocation));
            
          //TODO assert the proper form of the loaded AST
            
            i++;
        }        
    }
        
    /**
     * Compiles handmade test code and loads it using the binary node loader,
     * then verifies that the structure is correct.
     * @throws Exception on error.
     */
    @Test
    public void testBinaryLoaderWithCustomClasses() throws Exception
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

        String codeStr = "package joe.foo.bar;\nimport java.util.*;" 
            + "public class JoeClass <T extends SmallClass & Iface,V extends Iface> extends ArrayList<String>{" 
            + "private boolean x = true;\n"
            + "public <X> JoeClass(int a, java.util.List<String> list){}\n"
            + "public JoeClass(int a, String[][][] b){}\n"
            + "private List<String> list;\n"
            + "public <J> java.util.List<String> foo(int x, String s, java.util.List<String> list){"
            + "return null;" + "}" + "}";
        String codeStr2 = "package joe.foo.bar; public interface SmallClass <T> extends Iface{}";
        String codeStr3 = "package joe.foo.bar; public interface Iface {}";
        String codeStr4 = "package joe.foo.bar; public enum E {ONE(1), TWO(2),THREE(3); private int x; public void foo(){} E(int x) {this.x = x;}}";

        BsjFileObject bfo = bfm.getJavaFileForOutput(
                StandardLocation.SOURCE_PATH, "joe.foo.bar.JoeClass", Kind.SOURCE, null);
        bfo.setCharContent(codeStr);
        
        BsjFileObject bfo2 = bfm.getJavaFileForOutput(
                StandardLocation.SOURCE_PATH, "joe.foo.bar.SmallClass", Kind.SOURCE, null);
        bfo2.setCharContent(codeStr2);
        
        BsjFileObject bfo3 = bfm.getJavaFileForOutput(
                StandardLocation.SOURCE_PATH, "joe.foo.bar.Iface", Kind.SOURCE, null);
        bfo3.setCharContent(codeStr3);
        
        BsjFileObject bfo4 = bfm.getJavaFileForOutput(
                StandardLocation.SOURCE_PATH, "joe.foo.bar.E", Kind.SOURCE, null);
        bfo4.setCharContent(codeStr4);

        List<JavaFileObject> fileObjects = Arrays.<JavaFileObject> asList(bfo, bfo2, bfo3, bfo4);

        // The next step is to compile Iterable collection of java files and close file manager:
        if (!(jc.getTask(null, bfm, null, null, null, fileObjects).call()))
        {
            Assert.fail("Compilation failure.");
        }
        bfm.close();

        BsjNodeFactory factory = BsjServiceRegistry.newToolkitFactory().newToolkit().getNodeFactory();
        BsjBinaryNodeLoader loader = new BsjBinaryNodeLoader(factory);
        
        CompilationUnitNode joe = loader.loadNodesFromBinary("joe.foo.bar.JoeClass", map.get(StandardLocation.CLASS_OUTPUT));
        CompilationUnitNode sc = loader.loadNodesFromBinary("joe.foo.bar.SmallClass", map.get(StandardLocation.CLASS_OUTPUT));
        CompilationUnitNode e = loader.loadNodesFromBinary("joe.foo.bar.E", map.get(StandardLocation.CLASS_OUTPUT));
        
        System.out.println(joe.executeOperation(
                BsjServiceRegistry.newToolkitFactory().newToolkit().getSerializer(), null));
        System.out.println(sc.executeOperation(
                BsjServiceRegistry.newToolkitFactory().newToolkit().getSerializer(), null));
        System.out.println(e.executeOperation(
                BsjServiceRegistry.newToolkitFactory().newToolkit().getSerializer(), null));

        
        //TODO assert the proper form of the loaded AST
    }
}
