package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.JavaFileManagerUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.javacompiler.ByteArrayJavaFileObject;

/**
 * Provides a memory-based file system wrapper for a specific location.
 * @author Joseph Riley
 */
public class InMemoryLocationManager extends AbstractLocationManager
{
	/**
	 * Contains the in-memory regular files.
	 */
    private Map<FileObjectPair, BsjFileObject> fileObjectMap;

	/**
	 * Contains the in-memory Java files.
	 */
    private Map<JavaFileObjectPair, BsjFileObject> javaFileObjectMap;		

    /**
     * Constructor.
     * @param encodingName name of encoding for this location, null if default.
     */
	public InMemoryLocationManager(String encodingName)
	{
		super(encodingName);
        fileObjectMap = new HashMap<FileObjectPair, BsjFileObject>();
        javaFileObjectMap = new HashMap<JavaFileObjectPair, BsjFileObject>();
	}

	/**
	 * Retrieves a file object for this location, or creates one if the specified file does not exist.
	 * 
	 * @param packageName The package in which the file object should exist.
	 * @param relativeName The relative name of the file object. This must be a path-rootless relative name.
	 * @param writable A hint indicating whether or not the caller expects to be able to write to the resulting file
	 *            object. This is ignored in this particular case.
	 * @return The resulting file object. Note that, unlike {@link JavaFileManager}, this method will always return a
	 *         non-<code>null</code> object regardless of whether or not the specified file exists.
	 * @throws IOException If an I/O error occurs.
	 */
	@Override
	public BsjFileObject getFile(String packageName, String relativeName,
			boolean writable) throws IOException
	{
		FileObjectPair key = new FileObjectPair(packageName, relativeName);
		
		// return the file if it already exists
		if (fileObjectMap.get(key) != null)
		{
			return fileObjectMap.get(key);
		}
		
		// create the file if it does not already exist
        ByteArrayJavaFileObject fileObject = null;
        try
        {
            fileObject = new ByteArrayJavaFileObject(
            		null,
                    relativeName, 
                    JavaFileManagerUtilities.getKindFor(relativeName));
            fileObjectMap.put(key, fileObject);
        } 
        catch (URISyntaxException e)
        {
            throw new IOException(e.getMessage(), e);
        }

        // return the newly created file
        return fileObject;
	}

	/**
	 * Retrieves a Java file object for this location, or creates one if the specified file does not exist.
	 * 
	 * @param className The name of the Java file.
	 * @param kind The Kind of the Java file.
	 * @param writable A hint indicating whether or not the caller expects to be able to write to the resulting file
	 *            object. This is ignored in this particular case.
	 * @return The resulting file object. Note that, unlike {@link JavaFileManager}, this method will always return a
	 *         non-<code>null</code> object regardless of whether or not the specified file exists.
	 * @throws IOException If an I/O error occurs.
	 */
	@Override
	public BsjFileObject getJavaFile(String className, Kind kind,
			boolean writable) throws IOException
	{
		JavaFileObjectPair key = new JavaFileObjectPair(className, kind);
		
		// return the Java file if it already exists
		if (javaFileObjectMap.get(key) != null)
		{
			return javaFileObjectMap.get(key);
		}
		
		// create the Java file if it does not already exist
        ByteArrayJavaFileObject javaFileObject = null;
        try
        {
            javaFileObject = new ByteArrayJavaFileObject(
            		null, 
            		className + kind.extension, 
            		kind);
            javaFileObjectMap.put(key, javaFileObject);
        } 
        catch (URISyntaxException e)
        {
            throw new IOException(e.getMessage(), e);
        }

        // return the newly created Java file
        return javaFileObject;

	}

	/**
	 * Returns a list of BsjFileObjects with the given criteria.
	 * @param packageName the package name to search for.
	 * @param kinds the kinds of files to look for.
	 * @param recurse if true, search subpackages.
	 * @return list of files in this location that meet the given criteria.
	 * @throws IOException on error.
	 */
	@Override
	public Iterable<? extends BsjFileObject> listFiles(String packageName,
			Collection<Kind> kinds, boolean recurse) throws IOException
	{
        List<BsjFileObject> list = new ArrayList<BsjFileObject>();        
        
        for (JavaFileObjectPair key : javaFileObjectMap.keySet())
        {
        	// examine file objects of the proper kind
			if (kinds.contains(key.getKind()))
			{
				BsjFileObject bfo = javaFileObjectMap.get(key);
				if (bfo.getName().startsWith(packageName))
				{
					// if recurse is on we select this file even if it is in a subpackage,
					// otherwise we only want files in the given package
					if (recurse || 
							(!(bfo.getName().replaceFirst(packageName, "").contains("."))))
					{
						list.add(bfo);
					}
				}
			}
        }
                
        return list;
	}
}
