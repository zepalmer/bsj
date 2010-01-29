package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;

import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

/**
 * This interface acts as an abstraction for the BSJ implementation of the {@link JavaFileManager}. This manager
 * represents a single location and serves its requests. This abstraction is useful to allow the BSJ compiler to juggle
 * these locations by constructing different {@link LocationMappedFileManager} objects.
 * 
 * @author Zachary Palmer
 */
public interface LocationManager extends Closeable, Flushable
{
	/**
	 * Closes all resources allocated by this location manager whether directly or indirectly.
	 * 
	 * @throws IOException If an I/O error occurs.
	 */
	public void close() throws IOException;

	/**
	 * Flushes all resources allocated by this location manager whether directly or indirectly.
	 * 
	 * @throws IOException If an I/O error occurs.
	 */
	public void flush() throws IOException;

	/**
	 * Retrieves a class loader for this location. This allows classes to be loaded out of this location as appropriate.
	 * If loading classes from this location makes no sense or is otherwise impossible, <code>null</code> may be
	 * returned.
	 * 
	 * @return The classloader for this location.
	 */
	public ClassLoader getClassLoader();

	/**
	 * Retrieves a file object for this location.
	 * 
	 * @param packageName The package in which the file object should exist.
	 * @param relativeName The relative name of the file object. This must be a path-rootless relative name.
	 * @param writable A hint indicating whether or not the caller expects to be able to write to the resulting file
	 *            object. This can usually be ignored but may be significant in some cases (such as in
	 *            {@link UnionLocationManager}).
	 * @return The resulting file object. Note that, unlike {@link JavaFileManager}, this method will always return a
	 *         non-<code>null</code> object regardless of whether or not the specified file exists.
	 * @throws IOException If an I/O error occurs.
	 */
	public BsjFileObject getFile(String packageName, String relativeName, boolean writable) throws IOException;

	/**
	 * Retrieves a file object for this location.
	 * 
	 * @param className The name of the class for which a file should be obtained.
	 * @param kind The kind of the file.
	 * @param writable A hint indicating whether or not the caller expects to be able to write to the resulting file
	 *            object. This can usually be ignored but may be significant in some cases (such as in
	 *            {@link UnionLocationManager}).
	 * @return The resulting file object. Note that, unlike {@link JavaFileManager}, this method will always return a
	 *         non-<code>null</code> object regardless of whether or not the specified file exists.
	 * @throws IOException If an I/O error occurs.
	 */
	public BsjFileObject getJavaFile(String className, Kind kind, boolean writable) throws IOException;

	/**
	 * Infers the binary name of the specified file.
	 * 
	 * @param file The file object for which a name should be inferred.
	 * @return The binary name, or <code>null</code> if that file object does not appear in this location.
	 * @see JavaFileManager#inferBinaryName(javax.tools.JavaFileManager.Location, JavaFileObject)
	 */
	public String inferBinaryName(JavaFileObject file);

	/**
	 * Lists the contents of this location in a specific package.
	 * 
	 * @param packageName The package for which a listing is required.
	 * @param kinds The kinds of files which should be included.
	 * @param recurse <code>true</code> to recurse into subdirectories; <code>false</code> otherwise.
	 * 
	 * @return The list of files in the specified position.
	 * @throws IOException If an I/O error occurs.
	 */
	public Iterable<? extends BsjFileObject> listFiles(String packageName, Collection<Kind> kinds, boolean recurse)
			throws IOException;
}
