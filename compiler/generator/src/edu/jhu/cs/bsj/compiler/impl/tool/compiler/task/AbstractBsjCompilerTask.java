package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public abstract class AbstractBsjCompilerTask implements BsjCompilerTask
{
	/** A logger for this task. */
	protected final Logger LOGGER = Logger.getLogger(this.getClass());

	/** The next UID to assign to a task. */
	private static final AtomicInteger nextUID = new AtomicInteger(0);
	/** The priority of this task. */
	private TaskPriority priority;
	/** The UID for this task. */
	private int uid = nextUID.getAndIncrement();

	protected AbstractBsjCompilerTask(TaskPriority priority)
	{
		super();
		this.priority = priority;
	}

	public TaskPriority getPriority()
	{
		return priority;
	}

	public int getUid()
	{
		return uid;
	}

	@Override
	public int compareTo(BsjCompilerTask o)
	{
		int a = this.getPriority().getPriority();
		int b = o.getPriority().getPriority();
		if (a != b)
			return a - b;
	
		// Arbitrary but consistent ordering
		a = this.getClass().hashCode();
		b = this.getClass().hashCode();
		if (a != b)
			return a - b;
	
		a = this.getUid();
		b = o.getUid();
		if (a != b)
			return a - b;
	
		return 0;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}