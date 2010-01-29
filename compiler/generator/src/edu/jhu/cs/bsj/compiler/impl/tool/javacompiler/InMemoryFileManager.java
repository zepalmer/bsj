package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.JavaFileManagerUtilities;

/**
 * Provides a memory-based file system wrapper for certain locations, passes
 * others through to a JavaFileManager passed in from constructor.
 * @author Joseph Riley
 */
public class InMemoryFileManager implements JavaFileManager
{
    private Map<FileObjectTuple, ByteArrayJavaFileObject> fileObjectMap;
    private Map<JavaFileObjectTuple, ByteArrayJavaFileObject> javaFileObjectMap;
    private List<Location> locations;
    private JavaFileManager fileManager;

    public InMemoryFileManager(JavaFileManager fileManager, List<Location> locations)
    {
        fileObjectMap = new HashMap<FileObjectTuple, ByteArrayJavaFileObject>();
        javaFileObjectMap = new HashMap<JavaFileObjectTuple, ByteArrayJavaFileObject>();
        this.locations = locations;
        this.fileManager = fileManager;
    }

    @Override
    public void close() throws IOException
    {
        fileManager.close();        
    }

    @Override
    public void flush() throws IOException
    {
       fileManager.flush();        
    }

    @Override
    public ClassLoader getClassLoader(final Location location)
    {
        if (!locations.contains(location))
        {
            return fileManager.getClassLoader(location);       
        }
        
        ClassLoader classLoader = new ClassLoader(getClass().getClassLoader())
        {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException
            {
                JavaFileObjectTuple key = new JavaFileObjectTuple(
                        location, name, Kind.CLASS);
                ByteArrayJavaFileObject file = javaFileObjectMap.get(key);
                return super.defineClass(name, file.getBytes(), 0, file.getBytes().length);
            }
        };
        
        return classLoader;
    }

    @Override
    public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException
    {
        if (!locations.contains(location))
        {
            return fileManager.getFileForInput(location, packageName, relativeName);
        }
        
        return fileObjectMap.get(new FileObjectTuple(location, packageName, relativeName));
    }

    @Override
    public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling)
            throws IOException
    {
        if (!locations.contains(location))
        {
            return fileManager.getFileForOutput(location, packageName, relativeName, sibling);         
        }
        
        ByteArrayJavaFileObject fileObject = null;
        try
        {
            fileObject = new ByteArrayJavaFileObject(
                    relativeName, 
                    JavaFileManagerUtilities.getKindFor(relativeName));
            fileObjectMap.put(
                    new FileObjectTuple(location, packageName, relativeName), fileObject);
        } 
        catch (URISyntaxException e)
        {
            throw new IOException(e.getMessage(), e);
        }

        return fileObject;
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException
    {
        if (!locations.contains(location))
        {
            return fileManager.getJavaFileForInput(location, className, kind);
        }
        
        return javaFileObjectMap.get(new JavaFileObjectTuple(location, className, kind));
    }

    /**
     * Returns a ByteArrayJavaFileObject for writing the bytecode to memory.
     */
    @Override
    public JavaFileObject getJavaFileForOutput(
            Location location, String className, Kind kind, FileObject sibling)
            throws IOException
    {
        if (!locations.contains(location))
        {
            return fileManager.getJavaFileForOutput(location, className, kind, sibling);            
        }
        
        ByteArrayJavaFileObject javaFileObject = null;
        try
        {
            javaFileObject = new ByteArrayJavaFileObject(className + kind.extension, kind);
            javaFileObjectMap.put(new JavaFileObjectTuple(location, className, kind), javaFileObject);
        } 
        catch (URISyntaxException e)
        {
            throw new IOException(e.getMessage(), e);
        }

        return javaFileObject;
    }
    
    @Override
    public boolean handleOption(String current, Iterator<String> remaining)
    {
        return fileManager.handleOption(current, remaining);
    }

    @Override
    public boolean hasLocation(Location location)
    {
        if (!locations.contains(location))
        {
            return fileManager.hasLocation(location);
        }
        
        return true;
    }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file)
    {
        // TODO Auto-generated method stub
        return fileManager.inferBinaryName(location, file);
    }

    @Override
    public boolean isSameFile(FileObject a, FileObject b)
    {
        if (a instanceof ByteArrayJavaFileObject)
        {
            if (b instanceof ByteArrayJavaFileObject)
            {
                return a.toUri().equals(b.toUri());
            }
            else
            {
                return false;
            }
        }
        
        return fileManager.isSameFile(a, b);
    }

    @Override
    public Iterable<JavaFileObject> list(
            Location location, String packageName, 
            Set<Kind> kinds, boolean recurse)
            throws IOException
    {
        if (!locations.contains(location))
        {
            return fileManager.list(location, packageName, kinds, recurse);
        }
        
        List<JavaFileObject> list = new ArrayList<JavaFileObject>();        
        
        for (JavaFileObjectTuple key : javaFileObjectMap.keySet())
        {
        	// examine file objects of the proper location and kind
			if (key.getLocation().equals(location)
					&& kinds.contains(key.getKind()))
			{
				JavaFileObject jfo = javaFileObjectMap.get(key);
				if (jfo.getName().startsWith(packageName))
				{
					// if recurse is on we select this file even if it is in a subpackage,
					// otherwise we only want files in the given package
					if (recurse || 
							(!(jfo.getName().replaceFirst(packageName, "").contains("."))))
					{
						list.add(jfo);
					}
				}
			}
        }
                
        return list;
    }

    @Override
    public int isSupportedOption(String option)
    {
        return fileManager.isSupportedOption(option);
    }
}
