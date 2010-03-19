package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.zip.ZipFile;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;

public abstract class AbstractZipFileObject extends AbstractFileObject
{
	/** The {@link ZipFile} that backs this file. */
	protected ZipFile file;

	public AbstractZipFileObject(String encodingName, ZipFile file)
	{
		super(encodingName);
		this.file = file;
	}

	@Override
	public boolean delete()
	{
		return false;
	}

	@Override
	public OutputStream openOutputStream() throws IOException
	{
		throw new IOException("Cannot modify contents of a ZIP file.");
	}

	public String inferBinaryName()
	{
		return StringUtilities.removeSuffix(getName(), '.').replace('/', '.');
	}

	@Override
	public URI toUri()
	{
		try
		{
			return new URI("jar:file:" + this.file.getName() + "!/" + getName());
		} catch (URISyntaxException e)
		{
			return null;
		}
	}

	@Override
	public boolean isWritable()
	{
		return false;
	}

	@Override
	public String getSimpleName()
	{
		return StringUtilities.removeSuffix(getName(), '/');
	}
}