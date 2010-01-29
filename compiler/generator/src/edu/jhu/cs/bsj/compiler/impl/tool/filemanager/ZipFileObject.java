package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

/**
 * This implementation of {@link AbstractFileObject} represents a file inside of a ZIP file.
 * @author Zachary Palmer
 */
public class ZipFileObject extends AbstractFileObject implements BinaryInferrableFileObject
{
	/** The {@link ZipEntry} that backs this file. */
	private ZipEntry entry;
	/** The {@link ZipFile} that backs this file. */
	private ZipFile file;
	
	/**
	 * Creates a new file object for ZIP files.
	 * @param encodingName The name of the character encoding used to read this file.
	 * @param entry The entry which backs this file object.
	 * @param file The file which backs this file object.
	 */
	public ZipFileObject(String encodingName, ZipEntry entry, ZipFile file)
	{
		super(encodingName);
		this.entry = entry;
		this.file = file;
	}

	@Override
	public boolean isNameCompatible(String simpleName, Kind kind)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete()
	{
		return false;
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
	public OutputStream openOutputStream() throws IOException
	{
		throw new IOException("Cannot modify contents of a ZIP file.");
	}

	@Override
	public URI toUri()
	{
		try
		{
			return new URI("jar:file:" + this.file.getName() + "!/" + this.entry.getName());
		} catch (URISyntaxException e)
		{
			return null;
		}
	}

	@Override
	public String inferBinaryName()
	{
		return StringUtilities.removeSuffix(this.entry.getName(), '.').replace('/', '.');
	}

	@Override
	public String toString()
	{
		return "ZipFileObject (" + this.toUri() + ")";
	}
}
