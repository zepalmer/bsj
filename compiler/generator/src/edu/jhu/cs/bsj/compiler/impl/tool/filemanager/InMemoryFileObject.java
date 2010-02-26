package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import edu.jhu.cs.bsj.compiler.impl.utils.StringUtilities;
import edu.jhu.cs.bsj.compiler.tool.filemanager.BsjFileObject;

public class InMemoryFileObject extends AbstractFileObject implements BsjFileObject
{
	/**
	 * Stores the content of this file object.
	 */
	private byte[] bytes = null;

	private String fileName;

	private Kind kind;

	/**
	 * Constructor.
	 * 
	 * @param encodingName the name of the encoding to use.
	 * @param fileName the name of the class.
	 * @param bytes the content of the class.
	 * @throws URISyntaxException on error.
	 */
	public InMemoryFileObject(String encodingName, String fileName, Kind kind) throws URISyntaxException
	{
		super(encodingName);
		this.fileName = fileName;
		this.kind = kind;
		// super(new URI("bsjmemfile://bsj/"+fileName), kind);
	}

	/**
	 * Returns the content of this file object.
	 * 
	 * @param ignoreEncodingErrors ignore errors in the encoding.
	 * @return the content of this file object.
	 */
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
	{
		if (bytes == null)
			return "";
		else
			return new String(bytes);
	}

	/**
	 * Opens an input stream for reading from this file object.
	 * 
	 * @return the input stream.
	 */
	@Override
	public InputStream openInputStream() throws IOException
	{
		if (bytes == null)
		{
			throw new FileNotFoundException("File does not exist: " + this.getName());
		} else
		{
			return new ByteArrayInputStream(bytes);
		}
	}

	/**
	 * Opens an output stream for writing to the content of this file.
	 * 
	 * @return the output stream.
	 * @throws IOException on error.
	 */
	@Override
	public OutputStream openOutputStream() throws IOException
	{
		// store the output stream in our buffer
		bytes = new byte[0];
		ByteArrayOutputStream ret = new ByteArrayOutputStream()
		{
			@Override
			public void close() throws IOException
			{
				bytes = this.toByteArray();
			}
		};
		return ret;
	}

	@Override
	public boolean exists()
	{
		return true;
	}

	@Override
	public String inferBinaryName()
	{
		return StringUtilities.removeSuffix(this.fileName, '.').replace('/', '.');
	}

	@Override
	public boolean isWritable()
	{
		return true;
	}

	@Override
	public boolean delete()
	{
		if (this.bytes == null)
		{
			return false;
		} else
		{
			this.bytes = null;
			return true;
		}
	}

	@Override
	public long getLastModified()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName()
	{
		return fileName;
	}

	@Override
	public URI toUri()
	{
		try
		{
			return new URI("bsjmemfile://bsj/" + fileName);
		} catch (URISyntaxException e)
		{
			return null;
		}
	}

	/**
	 * @return the bytes
	 */
	public byte[] getBytes()
	{
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes)
	{
		this.bytes = bytes;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * @return the kind
	 */
	public Kind getKind()
	{
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
}
