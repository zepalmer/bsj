package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.Comparator;

/**
 * This enumeration describes the states in which a compilation unit tracker can exist.
 * @author Zachary Palmer
 */
public enum CompilationUnitStatus implements Comparator<CompilationUnitTracker>
{
	/** Indicates that no work has been performed. */
	JUST_STARTED(0),
	/** Indicates that the file has been buffered and parsed. */
	PARSED(100),
	// TODO: more
	/** Indicates that the compilation unit is ready for source serialization. */
	READY_TO_SERIALIZE(900),
	/** Indicates that the compilation unit has been completely processed. */
	COMPLETE(1000),
	
	;
	
	/** Describes the priority of trackers which have this status. */
	private int priority;

	private CompilationUnitStatus(int priority)
	{
		this.priority = priority;
	}

	/**
	 * Determines the priority of this status.  Statuses with lower priority numbers should be processed first.
	 * @return The priority number for this status.
	 */
	public int getPriority()
	{
		return priority;
	}

	/**
	 * Used to compare two trackers which have this status; the "lesser" tracker is the one which should be processed
	 * first.  This implementation simply defers to the trackers' UIDs for an arbitrary ordering.  Some status objects
	 * may override this method to provide status-specific priorities (such as metaprogram execution in dependency
	 * order).  To resolve ties, overrides of this method should always call back to this method.
	 * @param a The first tracker to compare.
	 * @param b The second tracker to compare.
	 * @return <code>-1</code>, <code>0</code>, or <code>1</code> as the first tracker should be executed before, in
	 * any relationship to, or after the second.
	 */
	@Override
	public int compare(CompilationUnitTracker a, CompilationUnitTracker b)
	{
		return a.getUid() - b.getUid();
	}
}