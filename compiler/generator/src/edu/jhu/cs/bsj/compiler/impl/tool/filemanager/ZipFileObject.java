package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * This implementation of {@link AbstractFileObject} represents a file inside of a ZIP file.
 * @author Zachary Palmer
 */
public class ZipFileObject extends AbstractZipFileObject implements BsjFileObject
{
	/** The {@link ZipEntry} that backs this file. */
	private ZipEntry entry;
	/**
	 * Creates a new file object for ZIP files.
	 * @param encodingName The name of the character encoding used to read this file.
	 * @param entry The entry which backs this file object.
	 * @param file The file which backs this file object.
	 */
	public ZipFileObject(String encodingName, ZipEntry entry, ZipFile file)
	{
		super(encodingName, file);
		this.entry = entry;
	}

	@Override
	public long getLastModified()
	{
		return this.entry.getTime();
	}

	@Override
	public String getName()
	{
		return this.entry.getName();
	}

	@Override
	public InputStream openInputStream() throws IOException
	{
		return this.file.getInputStream(this.entry);
	}

	@Override
	public String toString()
	{
		return "ZipFileObject (" + this.toUri() + ")";
	}

	@Override
	public boolean exists()
	{
		return true;
	}
}
