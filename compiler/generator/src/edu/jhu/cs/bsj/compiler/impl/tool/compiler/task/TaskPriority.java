package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

/**
 * Represents default task priorities.  This mechanism allows priority order to be centralized (in this file).  The
 * first element which appears here is the highest priority (should happen first).
 * @author Zachary Palmer
 */
public enum TaskPriority
{
	BUILD_ID_MAP(200),
	EXECUTE(400),
	APPLY_FINAL_PATCH(500),
	REPLACE_CODE_LITERALS(600),
	STRIP_BSJ_NODES(700),
	SANITY_CHECK(900),
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
