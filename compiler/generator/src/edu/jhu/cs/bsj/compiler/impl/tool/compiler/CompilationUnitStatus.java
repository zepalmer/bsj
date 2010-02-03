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
	
	/**
	 * Indicates that the compilation is ready for metaprogram execution.  A compilation unit tracker enters this state
	 * after parsing once the AST content of the file has been interpreted as static content of a metaprogram.  It also
	 * enters this state whenever additional metaprograms have been discovered and correctly handled.
	 */
	// TODO: more

	/** Indicates that the compilation unit is ready for source serialization. */
	READY_TO_SERIALIZE,
	/** Indicates that the compilation unit has been completely processed. */
	COMPLETE,
}