package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

/**
 * Allows a set of {@link LocationManager} objects to be provided which dictate the behavior of this file manager.
 * @author Zachary Palmer
 */
public class LocationMappedFileManager implements JavaFileManager
{
	/** A mapping between locations and their managers. */
	private Map<Location,LocationManager> locationManagerMap;

	/**
	 * Creates a new location-mapped file manager.
	 * @param locationManagerMap The location manager map to use.
	 */
	public LocationMappedFileManager(Map<Location, LocationManager> locationManagerMap)
	{
		super();
		this.locationManagerMap = locationManagerMap;
	}

	@Override
	public void close() throws IOException
	{
		for (LocationManager manager : this.locationManagerMap.values())
		{
			manager.close();
		}
	}

	@Override
	public void flush() throws IOException
	{
		for (LocationManager manager : this.locationManagerMap.values())
		{
			manager.flush();
		}
	}

	@Override
	public ClassLoader getClassLoader(Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException
	{
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager==null)
			return null;
		
		return manager.getFile(packageName, relativeName);
	}

	@Override
	public FileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling)
			throws IOException
	{
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager==null)
			return null;
		
		return manager.getFile(packageName, relativeName);
	}

	@Override
	public JavaFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException
	{
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager==null)
			return null;
		
		return manager.getJavaFile(className, kind);
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
			throws IOException
	{
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager==null)
			return null;
		
		return manager.getJavaFile(className, kind);
	}

	/**
	 * Location-mapped file managers do not accept options in this fashion.  Thus, this method always returns
	 * <code>false</code>.
	 * @param current Ignored.
	 * @param remaining Ignored.
	 * @return <code>false</code>, always.
	 */
	@Override
	public boolean handleOption(String current, Iterator<String> remaining)
	{
		return false;
	}

	@Override
	public boolean hasLocation(Location location)
	{
		return this.locationManagerMap.containsKey(location);
	}

	@Override
	public String inferBinaryName(Location location, JavaFileObject file)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSameFile(FileObject a, FileObject b)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<JavaFileObject> list(Location location, String packageName, Set<Kind> kinds, boolean recurse)
			throws IOException
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This file manager does not couple configuration routines with it; thus, this method always returns
	 * <code>-1</code>.
	 * @param option Ignored.
	 * @return <code>-1</code>, always.
	 */
	@Override
	public int isSupportedOption(String option)
	{
		return -1;
	}
}
