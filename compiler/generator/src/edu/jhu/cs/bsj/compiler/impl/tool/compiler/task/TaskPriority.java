package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

/**
 * Represents default task priorities.  This mechanism allows priority order to be centralized (in this file).  The
 * first element which appears here is the highest priority (should happen first).
 * @author Zachary Palmer
 */
public enum TaskPriority
{
	PARSE(100),
	LOAD_BINARY(100),
	CATEGORIZE(300),
	EXTRACT(400),
	COMPILE(500),
	EXECUTE(700),
	SERIALIZE(1000),
	
	;
	
	/** The priority for this compilation unit task. */
	private int priority;

	private TaskPriority(int priority)
	{
		this.priority = priority;
	}

	public int getPriority()
	{
		return priority;
	}
}
