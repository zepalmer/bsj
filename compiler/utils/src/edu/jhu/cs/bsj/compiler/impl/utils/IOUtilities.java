package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This utilities class contains I/O methods.
 * 
 * @author Zachary Palmer
 */
public class IOUtilities
{
	/**
	 * Prevents instantiation.
	 */
	private IOUtilities()
	{
	}

	/**
	 * Used to exhaust an {@link InputStream}, storing its contents in a buffer. This method does not close the input
	 * stream.
	 * 
	 * @param inputStream The input stream to read.
	 * @return The resulting buffer.
	 * @throws IOException If an I/O error occurs.
	 */
	public static byte[] readAll(InputStream is) throws IOException
	{
		byte[] buffer = new byte[2048];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int read;
		while ((read = is.read(buffer)) != -1)
		{
			baos.write(buffer, 0, read);
		}
		return baos.toByteArray();
	}
}
