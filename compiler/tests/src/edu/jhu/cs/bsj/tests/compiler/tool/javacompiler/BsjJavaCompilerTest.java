package edu.jhu.cs.bsj.tests.compiler.tool.javacompiler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.tool.javacompiler.ByteArrayJavaFileObject;
import edu.jhu.cs.bsj.compiler.impl.tool.javacompiler.InMemoryFileManager;


public class BsjJavaCompilerTest
{

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception
    {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        JavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
        
        
        String codeStr =
            "public class JoeClass {" +
                "public String toString(){" +
                    "SmallClass sc = new SmallClass(); return(\"Hello Joe!\");" +
                "}" +
            "}";
        String codeStr2 =
            "public class SmallClass {" +
                "public String toString(){" +
                    "return(\"SmallClass!\");" +
                "}" +
            "}";
        
        List<Location> locations = new ArrayList<Location>();
        locations.add(StandardLocation.CLASS_OUTPUT);
        locations.add(StandardLocation.SOURCE_PATH);
        
        
        InMemoryFileManager jfm = new InMemoryFileManager(sjfm, locations);
        ByteArrayJavaFileObject altFile = (ByteArrayJavaFileObject)
        	jfm.getJavaFileForOutput(StandardLocation.SOURCE_PATH, "SmallClass", Kind.SOURCE, null);
        altFile.setBytes(codeStr2.getBytes());
        
        ByteArrayJavaFileObject sourceFile = null;
        try
        {
            sourceFile = new ByteArrayJavaFileObject("JoeClass.java", Kind.SOURCE);
            sourceFile.setBytes(codeStr.getBytes());
        } catch (URISyntaxException e2)
        {
            // TODO Auto-generated catch block
            e2.printStackTrace();
            System.exit(1);
        }
        
        List<JavaFileObject> fileObjects = new ArrayList<JavaFileObject>();
        fileObjects.add(sourceFile);
        fileObjects.add(altFile);

        //The next step is to compile Iterable collection of java files and close file manager:

        if (!(jc.getTask(null, jfm, null, null, null, fileObjects).call()))
        {
        	 System.exit(1); 
        }
        try
        {
            sjfm.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);            
        }
        System.out.println("Class has been successfully compiled");
        
        Object o = jfm.getClassLoader(StandardLocation.CLASS_OUTPUT).loadClass("JoeClass").newInstance();
        System.out.println(o);

//        URL[] urls = null;
//        try
//        {
//            urls = new URL[]{ new URL("file:///home/jriley/test/") };
//        } catch (MalformedURLException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.exit(1);
//        }
//        URLClassLoader ucl = new URLClassLoader(urls);
//
//        Class clazz = null;
//        try
//        {
//            clazz = ucl.loadClass("JoeClass");
//        } catch (ClassNotFoundException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.exit(1);
//        }
//        System.out.println("Class has been successfully loaded");
//
//        //And get the method callMe using reflections:
//
//        Method method = null;
//        try
//        {
//            method = clazz.getDeclaredMethod("callMe", null);
//        } catch (SecurityException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (NoSuchMethodException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //Finally we need to create new instance of the just loaded class and call method callMe on it:
//
//        Object object = null;
//        try
//        {
//            object = clazz.newInstance();
//        } catch (InstantiationException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try
//        {
//            method.invoke(object, null);
//        } catch (IllegalArgumentException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalAccessException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvocationTargetException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
