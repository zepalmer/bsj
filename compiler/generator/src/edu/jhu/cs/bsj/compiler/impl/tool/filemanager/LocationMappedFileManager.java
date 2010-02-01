package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.impl.utils.TypeTranslatingIterable;

/**
 * Allows a set of {@link LocationManager} objects to be provided which dictate the behavior of this file manager.
 * 
 * @author Zachary Palmer
 */
public class LocationMappedFileManager implements BsjFileManager
{
	/** A logger for this class. */
	private Logger LOGGER = Logger.getLogger(this.getClass());

	/** A mapping between locations and their managers. */
	private Map<? extends Location, ? extends LocationManager> locationManagerMap;

	/**
	 * Creates a new location-mapped file manager.
	 * 
	 * @param locationManagerMap The location manager map to use.
	 */
	public <T extends Location, U extends LocationManager> LocationMappedFileManager(Map<T, U> locationManagerMap)
	{
		super();
		this.locationManagerMap = locationManagerMap;
	}
	
	/**
	 * Determines which location manager is serving the specified location.
	 * @param location The location in question.
	 * @return The location manager handling that location or <code>null</code> if this file manager does not recognize
	 * the specified location.
	 */
	public LocationManager getLocationManager(Location location)
	{
		return this.locationManagerMap.get(location);
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
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return null;

		return manager.getClassLoader();
	}

	@Override
	public BsjFileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("getFileForInput(" + location + ", " + packageName + ", " + relativeName + ")");
		}

		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return null;

		return manager.getFile(packageName, relativeName, false);
	}

	@Override
	public BsjFileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling)
			throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("getFileForOutput(" + location + ", " + packageName + ", " + relativeName + "," + sibling
					+ ")");
		}

		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return null;

		return manager.getFile(packageName, relativeName, true);
	}

	@Override
	public BsjFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("getJavaFileForInput(" + location + ", " + className + ", " + kind + ")");
		}
		
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return null;

		return manager.getJavaFile(className, kind, false);
	}

	@Override
	public BsjFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
			throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("getJavaFileForInput(" + location + ", " + className + ", " + kind + "," + sibling + ")");
		}
		
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return null;

		return manager.getJavaFile(className, kind, true);
	}

	/**
	 * Location-mapped file managers do not accept options in this fashion. Thus, this method always returns
	 * <code>false</code>.
	 * 
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
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return file.getName();

		return manager.inferBinaryName(file);
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
		return new TypeTranslatingIterable<JavaFileObject>(listFiles(location, packageName, kinds, recurse));
	}

	@Override
	public Iterable<? extends BsjFileObject> listFiles(Location location, String packageName, Collection<Kind> kinds,
			boolean recurse) throws IOException
	{
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("listFiles(" + location + ", \"" + packageName + "\", " + kinds + "," + recurse + ")");
		}
		
		LocationManager manager = this.locationManagerMap.get(location);
		if (manager == null)
			return Collections.emptyList();

		Iterable<? extends BsjFileObject> ret = manager.listFiles(packageName, kinds, recurse);
		
		if (LOGGER.isTraceEnabled())
		{
			LOGGER.trace("Found files: ");
			for (BsjFileObject bfo : ret)
			{
				LOGGER.trace("    " + bfo.getName());
			}
		}
		
		return ret;
	}

	/**
	 * This file manager does not couple configuration routines with it; thus, this method always returns
	 * <code>-1</code>.
	 * 
	 * @param option Ignored.
	 * @return <code>-1</code>, always.
	 */
	@Override
	public int isSupportedOption(String option)
	{
		return -1;
	}
}
