package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.util.concurrent.atomic.AtomicInteger;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;

/**
 * This base class provides functionality for compiler tasks.
 * @author Zachary Palmer
 */
public abstract class AbstractBsjCompilerTask implements BsjCompilerTask
{
	/** The next UID to assign to a task. */
	private static final AtomicInteger nextUID = new AtomicInteger(0);
	
	/** The tracker against which this task will executed. */
	private CompilationUnitTracker tracker;
	/** The priority of this task. */
	private TaskPriority priority;
	/** The UID for this task. */
	private int uid = nextUID.getAndIncrement();

	protected AbstractBsjCompilerTask(CompilationUnitTracker tracker, TaskPriority priority)
	{
		super();
		this.tracker = tracker;
		this.priority = priority;
	}

	public CompilationUnitTracker getTracker()
	{
		return tracker;
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
		if (this.getPriority().ordinal() < o.getPriority().ordinal())
			return -1;
		if (this.getPriority().ordinal() > o.getPriority().ordinal())
			return 1;
		
		// Arbitrary but consistent ordering
		if (this.getClass().hashCode() < o.getClass().hashCode())
			return -1;
		if (this.getClass().hashCode() > o.getClass().hashCode())
			return 1;
		if (this.getUid() < o.getUid())
			return -1;
		if (this.getUid() > o.getUid())
			return 1;
		
		return 0;
	}
}
