package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.tools.JavaFileObject.Kind;

import edu.jhu.cs.bsj.compiler.impl.utils.EnumerationIterator;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This file manager allows access to files inside of a ZIP-formatted archive. The returned file objects do not allow
 * write operations.
 * 
 * @author Zachary Palmer
 */
public class ZipFileLocationManager extends AbstractLocationManager
{
	/** The file which backs this location manager. */
	private File file;
	/** The zip file which backs this location manager. */
	private ZipMetaCache zip;
	/** The separator used in zip file paths. */
	public static final char ZIP_FILE_SEPARATOR = '/';

	/**
	 * Creates a file location manager.
	 * 
	 * @param encodingName The name of the encoding to use when retrieving characters from this file.
	 * @param file The file containing the ZIP archive.
	 * @throws IOException If an I/O error occurs while reading the archive.
	 */
	public ZipFileLocationManager(String encodingName, File file) throws IOException
	{
		super(encodingName);
		this.file = file;
		this.zip = getZipMetaCache();
	}

	/**
	 * Ensures that the zip file resource is open and ready for reading.
	 * 
	 * @return The resource to use.
	 * @throws IOException If an I/O error occurs.
	 */
	private ZipMetaCache getZipMetaCache() throws IOException
	{
		if (this.zip == null)
		{
			this.zip = new ZipMetaCache(file);
		}
		return this.zip;
	}

	@Override
	public void close() throws IOException
	{
		super.close();
		this.zip.getZipFile().close();
		this.zip = null;
	}

	@Override
	public BsjFileObject getFile(String packageName, String relativeName, boolean writable) throws IOException
	{
		String name = packageName.replace('.', ZIP_FILE_SEPARATOR) + ZIP_FILE_SEPARATOR + relativeName;
		return getFileFromEntryName(name);
	}

	@Override
	public BsjFileObject getJavaFile(String className, Kind kind, boolean writable) throws IOException
	{
		String name = className.replace('.', ZIP_FILE_SEPARATOR) + kind.extension;
		return getFileFromEntryName(name);
	}

	private BsjFileObject getFileFromEntryName(String name)
	{
		ZipEntry entry = this.zip.getEntryMap().get(name);
		if (entry == null)
		{
			return new NonExistentZipFileObject(name, this.zip.getZipFile());
		}
		return new ZipFileObject(getEncodingName(), entry, this.zip.getZipFile());
	}

	@Override
	public Iterable<? extends BsjFileObject> listFiles(String packageName, Collection<Kind> kinds, boolean recurse)
			throws IOException
	{
		ListFilesCacheKey key = new ListFilesCacheKey(packageName, kinds, recurse);
		Iterable<? extends BsjFileObject> value = this.listFilesCache.get(key);
		if (value == null)
		{

			String prefix = packageName.replace('.', ZIP_FILE_SEPARATOR);
			List<BsjFileObject> ret = new ArrayList<BsjFileObject>();
			for (ZipEntry entry : this.zip.getEntryMap().values())
			{
				if (entry.isDirectory())
				{
					continue;
				}
				if (entry.getName().startsWith(prefix))
				{
					// If we're not recursing, make sure we skip subdirectory entries
					if (!recurse && entry.getName().substring(prefix.length() + 1).indexOf(ZIP_FILE_SEPARATOR) != -1)
					{
						continue;
					}
					for (Kind k : kinds)
					{
						if (entry.getName().endsWith(k.extension))
						{
							ret.add(getFileFromEntryName(entry.getName()));
							break;
						}
					}
				}
			}
			value = ret;
			this.listFilesCache.put(key, value);
		}

		return value;
	}

	private Map<ListFilesCacheKey, Iterable<? extends BsjFileObject>> listFilesCache = new HashMap<ZipFileLocationManager.ListFilesCacheKey, Iterable<? extends BsjFileObject>>();

	private static class ListFilesCacheKey
	{
		private String packageName;
		private Collection<Kind> kinds;
		private boolean recurse;

		public ListFilesCacheKey(String packageName, Collection<Kind> kinds, boolean recurse)
		{
			super();
			this.packageName = packageName;
			this.kinds = kinds;
			this.recurse = recurse;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + ((kinds == null) ? 0 : kinds.hashCode());
			result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
			result = prime * result + (recurse ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ListFilesCacheKey other = (ListFilesCacheKey) obj;
			if (kinds == null)
			{
				if (other.kinds != null)
					return false;
			} else if (!kinds.equals(other.kinds))
				return false;
			if (packageName == null)
			{
				if (other.packageName != null)
					return false;
			} else if (!packageName.equals(other.packageName))
				return false;
			if (recurse != other.recurse)
				return false;
			return true;
		}
	}

	/**
	 * A class containing the cached view of the ZIP resource that this manager is using.
	 * 
	 * @author Zachary Palmer
	 */
	private static class ZipMetaCache
	{
		/** The {@link ZipFile} representing this resource. */
		private ZipFile zipFile;
		/** A {@link Map} mapping each file by its name. */
		private Map<String, ZipEntry> entryMap;

		/**
		 * Creates a new cached metadata resource for the ZIP archive in the specified file.
		 * 
		 * @param file The file to use.
		 * @throws IOException If an I/O error occurs.
		 */
		public ZipMetaCache(File file) throws IOException
		{
			this.zipFile = new ZipFile(file);
			this.entryMap = new HashMap<String, ZipEntry>();
			for (ZipEntry entry : new EnumerationIterator<ZipEntry>(this.zipFile.entries()))
			{
				this.entryMap.put(entry.getName(), entry);
			}
			this.entryMap = Collections.unmodifiableMap(this.entryMap);
		}

		public ZipFile getZipFile()
		{
			return zipFile;
		}

		public Map<String, ZipEntry> getEntryMap()
		{
			return entryMap;
		}
	}
}
