package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;

/**
 * This base class provides functionality for compiler tasks.
 * @author Zachary Palmer
 */
public abstract class AbstractBsjCompilerTask implements BsjCompilerTask
{
	/** The tracker against which this task will executed. */
	private CompilationUnitTracker tracker;

	protected AbstractBsjCompilerTask(CompilationUnitTracker tracker)
	{
		super();
		this.tracker = tracker;
	}

	public CompilationUnitTracker getTracker()
	{
		return tracker;
	}
}
