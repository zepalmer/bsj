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

	/**
	 * The pathname of the directory containing this file. If this file is contained in the root directory, this string
	 * will be the empty string.
	 */
	private String path;
	/**
	 * The name of the file represented by this object.
	 */
	private String name;
	/**
	 * The last time at which this file was modified.
	 */
	private long lastModified;

	private Kind kind;

	/**
	 * Constructor.
	 * 
	 * @param encodingName the name of the encoding to use.
	 * @param filename The filename of the file represented by this object.
	 * @param bytes the content of the class.
	 */
	public InMemoryFileObject(String encodingName, String filename, Kind kind)
	{
		super(encodingName);
		if (filename.contains("/"))
		{
			this.path = filename.substring(0, filename.lastIndexOf('/'));
			this.name = filename.substring(filename.lastIndexOf('/') + 1);
		} else
		{
			this.path = "";
			this.name = filename;
		}
		this.kind = kind;
		this.lastModified = 0;
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
		this.bytes = new byte[0];
		this.lastModified = System.currentTimeMillis();
		ByteArrayOutputStream ret = new ByteArrayOutputStream()
		{
			@Override
			public void close() throws IOException
			{
				InMemoryFileObject.this.bytes = this.toByteArray();
				InMemoryFileObject.this.lastModified = System.currentTimeMillis();
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
		String filePart = StringUtilities.removeSuffix(this.name, '.').replace('/', '.');
		if (this.path.length() > 0)
		{
			return this.path.replace('/', '.') + "." + filePart;
		} else
		{
			return filePart;
		}
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
			this.lastModified = 0;
			return true;
		}
	}

	@Override
	public long getLastModified()
	{
		return this.lastModified;
	}

	@Override
	public String getName()
	{
		return this.path + '/' + this.name;
	}

	@Override
	public URI toUri()
	{
		try
		{
			return new URI("bsjmemfile://bsj/" + getName());
		} catch (URISyntaxException e)
		{
			return null;
		}
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

	@Override
	public String getSimpleName()
	{
		return name;
	}

}
