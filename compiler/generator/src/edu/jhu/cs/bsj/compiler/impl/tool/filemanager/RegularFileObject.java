package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

/**
 * This implementation of {@link AbstractFileObject} represents a file which is stored in a physical location on the
 * disk.
 * 
 * @author Zachary Palmer
 */
public class RegularFileObject extends AbstractFileObject implements BsjFileObject
{
	/** This file object's file. */
	private File file;
	/** The root of this file object's location (for binary inference). */
	private File root;
	/** The binary name of the file. */
	private String binaryName;

	/**
	 * Creates a regular file object.
	 * 
	 * @param encodingName The name of the character encoding to use when operating on this file.
	 * @param file The file to use.
	 * @param root The root of the file's compiler location.
	 * @throws IllegalArgumentException If the specified file is not a child of the specified root.
	 * @throws IOException If an I/O error occurs during canonicalization.
	 */
	public RegularFileObject(String encodingName, File file, File root)
		throws IOException
	{
		super(encodingName);
		// these two were previously calling getCanonicalFile(), but that caused problems with symlinks
		this.file = file;
		this.root = root;
		// validate root
		StringBuilder binaryNameBuilder = new StringBuilder();
		File f = this.file;
		boolean ok = false;
		while (f != null)
		{
			if (f.equals(this.root))
			{
				ok = true;
				break;
			}
			if (binaryNameBuilder.length()>0)
			{
				binaryNameBuilder.insert(0, '.');
				binaryNameBuilder.insert(0, f.getName());
			} else
			{
				// remove extension
				binaryNameBuilder.insert(0, StringUtilities.removeSuffix(f.getName(), '.'));
			}
			f = f.getParentFile();
		}
		if (!ok)
		{
			throw new IllegalArgumentException("File " + file + " is not a descendant of " + root);
		}
		this.binaryName = binaryNameBuilder.toString();
	}

	public File getFile()
	{
		return file;
	}

	public File getRoot()
	{
		return root;
	}

	@Override
	public String inferBinaryName()
	{
		if (file.exists())
		{
			return this.binaryName;
		} else
		{
			return null;
		}
	}

	@Override
	public boolean delete()
	{
		return this.file.delete();
	}

	@Override
	public long getLastModified()
	{
		return this.file.lastModified();
	}

	@Override
	public String getName()
	{
		return this.file.getName();
	}

	@Override
	public InputStream openInputStream() throws IOException
	{
		InputStream is = new FileInputStream(this.file);
		registerIOResource(is);
		return is;
	}

	@Override
	public OutputStream openOutputStream() throws IOException
	{
		this.file.getParentFile().mkdirs();
		OutputStream os = new FileOutputStream(this.file);
		registerIOResource(os);
		return os;
	}

	@Override
	public URI toUri()
	{
		return this.file.toURI();
	}

	@Override
	public boolean exists()
	{
		return this.file.exists();
	}

	@Override
	public boolean isWritable()
	{
		return true;
	}

	@Override
	public String toString()
	{
		return "RegularFileObject (" + binaryName + " -> " + file + ")";
	}

	@Override
	public String getSimpleName()
	{
		return this.file.getName();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		RegularFileObject other = (RegularFileObject) obj;
		if (file == null)
		{
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}
}
