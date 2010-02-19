package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.OutputStream;

/**
 * This {@link OutputStream} implementation acts as a black hole; data can be written to it, but that data is ignored.
 * @author Zachary Palmer
 */
public class NullOutputStream extends OutputStream
{
	@Override
	public void close()
	{
	}

	@Override
	public void flush()
	{
	}

	@Override
	public void write(byte[] b, int off, int len)
	{
	}

	@Override
	public void write(byte[] b)
	{
	}

	@Override
	public void write(int b)
	{
	}
}
