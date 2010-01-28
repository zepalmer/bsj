package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;
import javax.tools.JavaFileObject.Kind;

/**
 * TODO
 * @author Joseph Riley
 */
public class BsjJavaCompiler
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        JavaFileManager sjfm = jc.getStandardFileManager(null, null, null);
        
        
        String codeStr =
            "public class JoeClass {" +
                "public void foo(){" +
                    "System.out.println(\"Hello Joe!\");" +
                "}" +
            "}";
        List<Location> locations = new ArrayList<Location>();
        locations.add(StandardLocation.CLASS_OUTPUT);
        
        
        InMemoryFileManager jfm = new InMemoryFileManager(sjfm, locations);


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
        
        //File javaFile = new File("/home/jriley/test/com/ToBeCompiled.java");
        //Iterable<? extends JavaFileObject> fileObjects = sjfm.getJavaFileObjects(javaFile);
        List<JavaFileObject> fileObjects = new ArrayList<JavaFileObject>();
        fileObjects.add(sourceFile);


        String[] options = new String[]{"-d", "/home/jriley/test"};

        //The next step is to compile Iterable collection of java files and close file manager:

        jc.getTask(null, jfm, null, Arrays.asList(options), null, fileObjects).call();
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
