package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

/**
 * This enumeration describes the states in which a compilation unit tracker can exist.
 * @author Zachary Palmer
 */
public enum CompilationUnitStatus
{
	// TODO: states for name analysis, type building, type checking, etc.
	/** Indicates that no work has been performed. */
	JUST_STARTED,
	/** Indicates that the file has been buffered and parsed. */
	PARSED,
	/** Indicates that the file is ready for metaprogram extraction. */
	METAPROGRAMS_EXTRACTED,
	/** Indicates that the file is waiting for all metaprograms to terminate. */
	METAPROGRAMS_EXECUTED,
	/** Indicates that the compilation unit has been completely processed. */
	COMPLETE,
}