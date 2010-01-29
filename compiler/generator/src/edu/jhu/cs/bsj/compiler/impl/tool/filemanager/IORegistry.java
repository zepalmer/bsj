package edu.jhu.cs.bsj.compiler.impl.tool.filemanager;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

import edu.jhu.cs.bsj.compiler.impl.utils.ResourceRegistry;

/**
 * This class is intended to be used as a base class for objects which need to provide I/O registry functionality.
 * @author Zachary Palmer
 */
public class IORegistry implements Closeable, Flushable
{
	/** The closeable object registry. */
	private ResourceRegistry<Closeable> closeableRegistry;
	/** The flushable object registry. */
	private ResourceRegistry<Flushable> flushableRegistry;
	
	/**
	 * Creates an empty I/O registry.
	 */
	protected IORegistry()
	{
		this.closeableRegistry = new ResourceRegistry<Closeable>();
		this.flushableRegistry = new ResourceRegistry<Flushable>();
	}

	/**
	 * Registers an I/O resource with this location manager. This is used to allow the manager to flush or close the
	 * resource when necessary.
	 * 
	 * @param resource The I/O resource to register.
	 */
	protected void registerIOResource(Closeable resource)
	{
		this.closeableRegistry.register(resource);
		if (resource instanceof Flushable)
		{
			this.flushableRegistry.register((Flushable) resource);
		}
	}

	@Override
	public void close() throws IOException
	{
		for (Closeable c : this.closeableRegistry)
		{
			try
			{
				c.close();
			} catch (IOException e)
			{
				// Not much we can do about that.
			}
		}
		this.closeableRegistry.clear();
		this.flushableRegistry.clear();
	}

	@Override
	public void flush() throws IOException
	{
		for (Flushable f : this.flushableRegistry)
		{
			try
			{
				f.flush();
			} catch (IOException e)
			{
				// Not much we can do about that.
			}
		}
	}
}
