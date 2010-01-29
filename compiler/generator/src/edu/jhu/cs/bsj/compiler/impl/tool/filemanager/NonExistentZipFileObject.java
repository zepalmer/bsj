package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

public class NonExistentZipFileObject extends AbstractZipFileObject
{
	/** The name of the non-existent file object. */
	private String name;

	public NonExistentZipFileObject(String name, ZipFile zipFile)
	{
		super(null, zipFile);
		this.name = name;
	}

	@Override
	public long getLastModified()
	{
		return -1;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public InputStream openInputStream() throws IOException
	{
		throw new FileNotFoundException("File does not exist in ZIP file: " + toUri());
	}

	@Override
	public boolean exists()
	{
		return false;
	}
}
