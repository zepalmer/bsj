package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

/**
 * This enumeration describes the states in which a compilation unit tracker can exist.
 * @author Zachary Palmer
 */
public enum CompilationUnitStatus
{
	/** Indicates that no work has been performed. */
	JUST_STARTED,
	/** Indicates that the file has been buffered and parsed. */
	PARSED,
	// TODO: more
	/** Indicates that the compilation unit is ready for source serialization. */
	READY_TO_SERIALIZE,
	/** Indicates that the compilation unit has been completely processed. */
	COMPLETE,
}