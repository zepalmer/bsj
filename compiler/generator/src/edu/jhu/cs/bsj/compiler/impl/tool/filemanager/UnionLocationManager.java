package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterable;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This implementation of {@link LocationManager} acts as a unioning system which is backed by multiple other location
 * managers. Upon construction, the location manager is provided a list of other location managers with the first
 * manager in the list being the highest priority. When this location manager is asked to serve a file request, it does
 * so using some or all of the underlying location managers.
 * <p/>
 * For those familiar, this location manager is similar to UnionFS or AUFS Linux filesystems. Its purpose is very much
 * the same.
 * 
 * @author Zachary Palmer
 */
public class UnionLocationManager extends AbstractLocationManager
{
	/** The backing locations. */
	private List<? extends LocationManager> backingLocationManagers;

	/**
	 * Creates a new location manager.
	 * 
	 * @param encodingName The character encoding to use on files produced by this location manager. While this affects
	 *            the result of {@link #getEncodingName()}, it has no other impact as the underlying managers know which
	 *            encodings they are using.
	 * @param backingLocationManagers The location managers which back this manager.
	 * @throws IllegalArgumentException If the list of backing location managers is empty.
	 */
	public UnionLocationManager(String encodingName, List<? extends LocationManager> backingLocationManagers)
	{
		super(encodingName);

		this.backingLocationManagers = backingLocationManagers;
		if (this.backingLocationManagers.size() == 0)
		{
			throw new IllegalArgumentException(
					"UnionLocationManager can't handle an empty backing location manager list.");
		}
	}

	/**
	 * Creates a new location manager. This constructor is provided for convenience and parses the specified path string
	 * into a number of components. Each path component which is a file is treated as a ZIP archive; each path component
	 * which is a directory is treated as a location root.
	 * 
	 * @param encodingName The character encoding to use on files produced by this location manager.
	 * @param path The path to use for this location manager.
	 * @throws IllegalArgumentException If the path string is empty.
	 * @throws IOException If canonicalization of a pathname fails.
	 * @throws FileNotFoundException If one of the specified pathnames does not exist.
	 */
	public UnionLocationManager(String encodingName, String path) throws IOException, FileNotFoundException
	{
		this(encodingName, instantiatePath(encodingName, path));
	}

	/**
	 * Retrieves a file object for this location manager. The semantic of this call is as follows:
	 * <ul>
	 * <li>If the request is for a writable file, each manager is called in turn until a manager produces a file which
	 * can support writing.</li>
	 * <li>If the request is not for a writable file, each manager is called in turn until a manager produces a file
	 * which exists. If no managers have a file which exists, the above process for writable files is executed.</li>
	 * <li>If either of the above processes produces no file, the file returned by this method is the file returned by
	 * the first location manager.</li>
	 * </ul>
	 * 
	 * @see {@link LocationManager#getFile(String, String, boolean)}
	 */
	@Override
	public BsjFileObject getFile(String packageName, String relativeName, boolean writable) throws IOException
	{
		BsjFileObject fileObject;
		if (!writable)
		{
			// Find the first file that exists
			for (LocationManager manager : this.backingLocationManagers)
			{
				fileObject = manager.getFile(packageName, relativeName, writable);
				if (fileObject.exists())
				{
					return fileObject;
				}
			}
		}

		for (LocationManager manager : this.backingLocationManagers)
		{
			fileObject = manager.getFile(packageName, relativeName, writable);
			if (fileObject.isWritable())
			{
				return fileObject;
			}
		}

		return this.backingLocationManagers.get(0).getFile(packageName, relativeName, writable);
	}

	/**
	 * Retrieves a file object for this location manager. The semantic of this call is as follows:
	 * <ul>
	 * <li>If the request is for a writable file, each manager is called in turn until a manager produces a file which
	 * can support writing.</li>
	 * <li>If the request is not for a writable file, each manager is called in turn until a manager produces a file
	 * which exists. If no managers have a file which exists, the above process for writable files is executed.</li>
	 * <li>If either of the above processes produces no file, the file returned by this method is the file returned by
	 * the first location manager.</li>
	 * </ul>
	 * 
	 * @see {@link LocationManager#getJavaFile(String, Kind, boolean)}
	 */
	@Override
	public BsjFileObject getJavaFile(String className, Kind kind, boolean writable) throws IOException
	{
		BsjFileObject fileObject;
		if (!writable)
		{
			// Find the first file that exists
			for (LocationManager manager : this.backingLocationManagers)
			{
				fileObject = manager.getJavaFile(className, kind, writable);
				if (fileObject.exists())
				{
					return fileObject;
				}
			}
		}

		for (LocationManager manager : this.backingLocationManagers)
		{
			fileObject = manager.getJavaFile(className, kind, writable);
			if (fileObject.isWritable())
			{
				return fileObject;
			}
		}

		return this.backingLocationManagers.get(0).getJavaFile(className, kind, writable);
	}

	/**
	 * Generates a list of the files in a specific package name. This method will simply perform the listing operation
	 * on all of its backing locations and assemble the results into a single iterable object. This means that if the
	 * backing locations overlap, it is possible to get "duplicates": two file objects may represent the same backing
	 * resource. These duplicates are not filtered out by this method, as it would be computationally expensive to do so
	 * and not terribly common for duplicates to occur. Callers may wish to filter out duplicates on their own.
	 */
	@Override
	public Iterable<? extends BsjFileObject> listFiles(String packageName, Collection<Kind> kinds, boolean recurse)
			throws IOException
	{
		// TODO: is it okay according to the FileManager interface for this method to return duplicates?
		List<Iterable<? extends BsjFileObject>> iterables = new ArrayList<Iterable<? extends BsjFileObject>>();
		for (LocationManager manager : this.backingLocationManagers)
		{
			iterables.add(manager.listFiles(packageName, kinds, recurse));
		}
		return new CompoundIterable<BsjFileObject>(iterables);
	}

	/**
	 * This utility method is used by the path constructor of this class to instantiate backing location managers from
	 * the specified path string.
	 * 
	 * @param encodingName The name of the encoding to use for the backing managers or <code>null</code> to use the
	 *            default platform encoding.
	 * @param path The path string to use.
	 * @return The location managers to use when instantiating the {@link UnionLocationManager}.
	 * @throws IOException If canonicalization of a pathname fails.
	 * @throws FileNotFoundException If one of the specified pathnames does not exist.
	 */
	private static List<? extends LocationManager> instantiatePath(String encodingName, String path)
			throws IOException, FileNotFoundException
	{
		List<LocationManager> managers = new ArrayList<LocationManager>();
		
		// use a different classpath separator for windows or unix
		for (String component : path.split(File.pathSeparator))
		{
			File file = new File(component);
			file = file.getCanonicalFile();
			LocationManager manager;
			if (file.isFile())
			{
				manager = new ZipFileLocationManager(encodingName, file);
			} else if (file.isDirectory())
			{
				manager = new RegularFileLocationManager(encodingName, file);
			} else
			{
				// TODO: can we do anything here?  FNFE causes problems because default boot classpath has nonexistents
				continue;
				//throw new FileNotFoundException(component + " does not exist or cannot be used");
			}
			managers.add(manager);
		}
		return managers;
	}
}
