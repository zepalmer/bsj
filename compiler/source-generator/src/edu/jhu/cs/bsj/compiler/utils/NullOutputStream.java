package edu.jhu.cs.bsj.compiler.utils;

import java.io.OutputStream;

/**
 * An output stream implementation that acts as a black hole.
 * 
 * @author Zachary Palmer
 */
public class NullOutputStream extends OutputStream
{

	@Override
	public void write(int b)
	{
	}

	@Override
	public void write(byte[] b)
	{
	}

	@Override
	public void write(byte[] b, int off, int len)
	{
	}

	@Override
	public void flush()
	{
	}

	@Override
	public void close()
	{
	}
}
