package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.utils.IOUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;
import edu.jhu.cs.bsj.compiler.tool.filemanager.LocationManager;

/**
 * This location manager provides an abstract base class implementing the most common location management functionality.
 * 
 * @author Zachary Palmer
 */
public abstract class AbstractLocationManager extends IORegistry implements LocationManager
{
	/** The encoding name to provide to files. */
	private String encodingName;

	/**
	 * Creates a new location manager.
	 * @param encodingName The name of the encoding to use when reading text files.
	 */
	public AbstractLocationManager(String encodingName)
	{
		super();
		this.encodingName = encodingName;
	}
	
	/**
	 * Retrieves the encoding used to read text files.
	 * @return The character encoding used by this location manager.
	 */
	protected String getEncodingName()
	{
		return encodingName;
	}

	@Override
	public ClassLoader getClassLoader()
	{
		return new LocationClassLoader();
	}

	/**
	 * Provides a default implementation to infer binary names.  This implementation assumes that incoming file objects
	 * are {@link BsjFileObject}s; if they are not, the file object's raw name is used with the suffix
	 * stripped and path separators replaced by dots ('<code>.</code>').
	 * @param file The file object whose binary name should be inferred.
	 * @return The inferred binary name.
	 */
	@Override
	public String inferBinaryName(JavaFileObject file)
	{
		if (file instanceof BsjFileObject)
		{
			BsjFileObject bifo = (BsjFileObject)file;
			return bifo.inferBinaryName();
		}
		
		return StringUtilities.removeSuffix(file.getName(), '.').replace(File.separatorChar, '.');
	}
	
	/**
	 * Represents a classloader for the abstract location manager.
	 */
	private class LocationClassLoader extends ClassLoader
	{
		/** A mapping between class names and the corresponding class objects. */
		private Map<String,Class<?>> classMap = new HashMap<String, Class<?>>();
		
		@Override
		protected Class<?> findClass(String name) throws ClassNotFoundException
		{
			byte[] classBytes;

			JavaFileObject fileObject;
			try
			{
				fileObject = getJavaFile(name, Kind.CLASS, false);
			} catch (IOException ioe)
			{
				throw new ClassNotFoundException("Could not access class file", ioe);
			}
			if (fileObject == null)
			{
				throw new ClassNotFoundException("Class file does not exist");
			}

			try
			{
				InputStream is = fileObject.openInputStream();
				classBytes = IOUtilities.readAll(is);
				is.close();
			} catch (IOException ioe)
			{
				throw new ClassNotFoundException("Could not read class file", ioe);
			}

			return super.defineClass(name, classBytes, 0, classBytes.length);
		}

		@Override
		protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
		{
			if (classMap.containsKey(name))
			{
				return this.classMap.get(name);
			}
			
			Class<?> ret = null;
			// Always try our own loader first
			try
			{
				ret = findClass(name);
				if (resolve)
					resolveClass(ret);
			} catch (ClassNotFoundException e)
			{
				// Delegate to the default implementation
				ret = super.loadClass(name, resolve);
			}
			return ret;
		}
	}
}
