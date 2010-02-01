package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

/**
 * Represents default task priorities.  This mechanism allows priority order to be centralized (in this file).  The
 * first element which appears here is the highest priority (should happen first).
 * @author Zachary Palmer
 */
public enum TaskPriority
{
	PARSE,
	// TODO
	CHEAT, // TODO: REMOVE
	SERIALIZE,
}
