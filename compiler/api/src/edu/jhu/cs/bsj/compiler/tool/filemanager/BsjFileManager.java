package edu.jhu.cs.bsj.compiler.tool.filemanager;

import java.io.IOException;
import java.util.Collection;

import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject.Kind;

public interface BsjFileManager extends JavaFileManager
{
	/**
	 * This implementation of {@link JavaFileManager} places a stronger requirement on the return value of the file
	 * accessor methods.
	 * 
	 * @see JavaFileManager#getFileForInput(javax.tools.JavaFileManager.Location, String, String)
	 */
	@Override
	public BsjFileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException;

	/**
	 * This implementation of {@link JavaFileManager} places a stronger requirement on the return value of the file
	 * accessor methods.
	 * 
	 * @see JavaFileManager#getFileForOutput(javax.tools.JavaFileManager.Location, String, String, FileObject)
	 */
	@Override
	public BsjFileObject getFileForOutput(Location location, String packageName, String relativeName, FileObject sibling)
			throws IOException;

	/**
	 * This implementation of {@link JavaFileManager} places a stronger requirement on the return value of the file
	 * accessor methods.
	 * 
	 * @see JavaFileManager#getJavaFileForInput(javax.tools.JavaFileManager.Location, String,
	 *      javax.tools.JavaFileObject.Kind)
	 */
	@Override
	public BsjFileObject getJavaFileForInput(Location location, String className, Kind kind) throws IOException;

	/**
	 * This implementation of {@link JavaFileManager} places a stronger requirement on the return value of the file
	 * accessor methods.
	 * 
	 * @see JavaFileManager#getJavaFileForOutput(javax.tools.JavaFileManager.Location, String,
	 *      javax.tools.JavaFileObject.Kind, FileObject)
	 */
	@Override
	public BsjFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
			throws IOException;

	/**
	 * This method corresponds to the
	 * {@link JavaFileManager#list(javax.tools.JavaFileManager.Location, String, java.util.Set, boolean)} method but
	 * provides a stronger assurance about the returned values.
	 * 
	 * @param location The location at which the listing should occur.
	 * @param packageName The package to list.
	 * @param kinds The kinds of files to be accepted.
	 * @param recurse <code>true</code> to recurse; <code>false</code> otherwise.
	 * @return An iterable containing the files which were located.
	 * @throws IOException If an I/O error occurs.
	 */
	public Iterable<? extends BsjFileObject> listFiles(Location location, String packageName, Collection<Kind> kinds,
			boolean recurse) throws IOException;

	/**
	 * Determines which location manager is serving the specified location.
	 * 
	 * @param location The location in question.
	 * @return The location manager handling that location or <code>null</code> if this file manager does not recognize
	 *         the specified location.
	 */
	public LocationManager getLocationManager(Location location);
}
