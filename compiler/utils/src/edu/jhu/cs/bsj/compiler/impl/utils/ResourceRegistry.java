package edu.jhu.cs.bsj.compiler.impl.utils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * Used to track allocated resources through weak references.  The objects are added to the registry as they are
 * encountered.  The registry will occasionally attempt to purge itself of degraded weak references to conserve space.
 * This registry may be used to operate on all resources which are still reachable.
 * @author Zachary Palmer
 * @param <T> The type of object in this registry.
 */
public class ResourceRegistry<T> implements Iterable<T>
{
	/** The list of resource references. */
	private List<WeakReference<T>> resources;
	/** The threshold at which the registry will be cleaned. */
	private int cleanThreshold;

	public ResourceRegistry()
	{
		super();
		this.resources = new ArrayList<WeakReference<T>>();
		this.cleanThreshold = 8;
	}
	
	/**
	 * Registers a new resource with this registry.  If it still exists when the registry is cleared, it will be closed.
	 * @param resource The resource to register.
	 */
	public void register(T resource)
	{
		this.resources.add(new WeakReference<T>(resource));
		if (this.resources.size()>this.cleanThreshold)
		{
			performCleanup();
		}
	}
	
	/**
	 * Cleans the degraded weak references out of this registry.
	 */
	private void performCleanup()
	{
		int i=0;
		while (i<this.resources.size())
		{
			if (this.resources.get(i).get()==null)
			{
				this.resources.remove(i);
			} else
			{
				i++;
			}
		}
		this.cleanThreshold = Math.max(8, this.resources.size() * 2);
	}
	
	/**
	 * Obtains an iterator over this resource registry.  Note that no resource registrations can occur while this
	 * iterator is in use or a {@link ConcurrentModificationException} will occur.
	 */
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private Iterator<WeakReference<T>> backing = ResourceRegistry.this.resources.iterator();
			private T next;
			
			private void bufferUp()
			{
				while (this.next == null && this.backing.hasNext())
				{
					this.next = this.backing.next().get();
					if (this.next == null)
					{
						this.backing.remove();
					}
				}
			}

			@Override
			public boolean hasNext()
			{
				bufferUp();
				return this.next!=null;
			}

			@Override
			public T next()
			{
				bufferUp();
				T ret = this.next;
				this.next = null;
				return ret;
			}

			@Override
			public void remove()
			{
				this.backing.remove();
			}
		};
	}
	
	/**
	 * Empties this registry.
	 */
	public void clear()
	{
		this.resources.clear();
		this.cleanThreshold = 8;
	}
}
