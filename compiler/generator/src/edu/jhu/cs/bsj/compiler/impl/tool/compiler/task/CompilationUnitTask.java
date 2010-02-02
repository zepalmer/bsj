package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;


import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilationUnitTracker;

/**
 * This base class provides functionality for compiler tasks which use a compilation unit.
 * 
 * @author Zachary Palmer
 */
public abstract class CompilationUnitTask extends AbstractBsjCompilerTask
{
	/** The tracker against which this task will executed. */
	private CompilationUnitTracker tracker;
	
	protected CompilationUnitTask(CompilationUnitTracker tracker, TaskPriority priority)
	{
		super(priority);
		this.tracker = tracker;
	}

	public CompilationUnitTracker getTracker()
	{
		return tracker;
	}
}
