package edu.jhu.cs.bsj.compiler.impl.tool.javacompiler;

import java.io.IOException;
import java.net.URISyntaxException;
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
    private Map<FileObjectTuple, FileObject> fileObjectMap;
    private Map<JavaFileObjectTuple, JavaFileObject> javaFileObjectMap;
    private List<Location> locations;
    private JavaFileManager fileManager;

    public InMemoryFileManager(JavaFileManager fileManager, List<Location> locations)
    {
        fileObjectMap = new HashMap<FileObjectTuple, FileObject>();
        javaFileObjectMap = new HashMap<JavaFileObjectTuple, JavaFileObject>();
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
    public ClassLoader getClassLoader(Location location)
    {
        // TODO Auto-generated method stub
        if (!locations.contains(location))
        {
            return fileManager.getClassLoader(location);       
        }
        
        return null;
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
        
        FileObject fileObject = null;
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
            throw new IOException(e.getMessage());
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
        
        JavaFileObject javaFileObject = null;
        try
        {
            javaFileObject = new ByteArrayJavaFileObject(className + kind.extension, kind);
            javaFileObjectMap.put(new JavaFileObjectTuple(location, className, kind), javaFileObject);
        } 
        catch (URISyntaxException e)
        {
            throw new IOException(e.getMessage());
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
        // TODO Auto-generated method stub
        return fileManager.isSameFile(a, b);
    }

    @Override
    public Iterable<JavaFileObject> list(
            Location location, String packageName, 
            Set<Kind> kinds, boolean recurse)
            throws IOException
    {
        // TODO Auto-generated method stub
        if (!locations.contains(location))
        {
            return fileManager.list(location, packageName, kinds, recurse);
        }
                
        return fileManager.list(location, packageName, kinds, recurse);
    }

    @Override
    public int isSupportedOption(String option)
    {
        return fileManager.isSupportedOption(option);
    }
}
