package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.JavaFileManagerUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * Provides a memory-based file system wrapper for a specific location.
 * 
 * @author Joseph Riley
 */
public class InMemoryLocationManager extends AbstractLocationManager
{
	/**
	 * Contains the in-memory files.
	 */
	private Map<String, InMemoryFileObject> fileObjectMap;

	/**
	 * Constructor.
	 * 
	 * @param encodingName name of encoding for this location, null if default.
	 */
	public InMemoryLocationManager(String encodingName)
	{
		super(encodingName);
		fileObjectMap = new HashMap<String, InMemoryFileObject>();
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
	public BsjFileObject getFile(String packageName, String relativeName, boolean writable) throws IOException
	{
		// construct the filename
		String filename;
		if (packageName.length() > 0)
		{
			filename = packageName.replace('.', '/') + '/' + relativeName;
		} else
		{
			filename = relativeName;
		}

		// retrieve object
		InMemoryFileObject fileObject = fileObjectMap.get(filename);
		if (fileObject == null)
		{
			// create object
			fileObject = new InMemoryFileObject(this, null, filename, JavaFileManagerUtilities.getKindFor(relativeName));
			fileObjectMap.put(filename, fileObject);
		}

		// return
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
	public BsjFileObject getJavaFile(String className, Kind kind, boolean writable) throws IOException
	{
		// construct the filename
		String filename = className.replace('.', '/') + kind.extension;
		
		// retrieve the object
		InMemoryFileObject fileObject = this.fileObjectMap.get(filename);
		if (fileObject == null)
		{
			// create the object
			fileObject = new InMemoryFileObject(this, null, filename, kind);
			this.fileObjectMap.put(filename, fileObject);
		}
		
		// return
		return fileObject;
	}

	/**
	 * Returns a list of BsjFileObjects with the given criteria.
	 * 
	 * @param packageName the package name to search for.
	 * @param kinds the kinds of files to look for.
	 * @param recurse if true, search subpackages.
	 * @return list of files in this location that meet the given criteria.
	 * @throws IOException on error.
	 */
	@Override
	public Iterable<? extends BsjFileObject> listFiles(String packageName, Collection<Kind> kinds, boolean recurse)
			throws IOException
	{
		List<BsjFileObject> list = new ArrayList<BsjFileObject>();
		String path = packageName.replace('.', '/');

		for (Map.Entry<String,InMemoryFileObject> entry : this.fileObjectMap.entrySet())
		{
			// examine file objects of the proper kind
			for (Kind kind : kinds)
			{
				if (entry.getKey().endsWith(kind.extension))
				{
					// If recursing, we add this if it starts with our path
					// If not recursing, it must be exactly in our path
					if ((recurse && entry.getKey().startsWith(path)) ||
							((!recurse &&
									(path.length()==0 || StringUtilities.removeSuffix(entry.getKey(), '/').equals(path)))))
					{
						list.add(entry.getValue());
					}
					break;
				}
			}
		}

		return list;
	}
}
