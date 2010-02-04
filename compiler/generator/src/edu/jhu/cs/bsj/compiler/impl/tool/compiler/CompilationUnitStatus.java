package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

/**
 * This enumeration describes the states in which a compilation unit tracker can exist.
 * @author Zachary Palmer
 */
public enum CompilationUnitStatus
{
	// TODO: it is possible that this enum and all of its related statuses are purely redundant
	// TODO: states for name analysis, type building, type checking, etc.
	/** Indicates that no work has been performed. */
	JUST_STARTED,
	/** Indicates that the file has been buffered and parsed. */
	PARSED,
	/** Indicates that metaprograms have been extracted from this file. */
	METAPROGRAMS_EXTRACTED,
	/** Indicates that all metaprograms for this compilation unit have executed. */
	METAPROGRAMS_EXECUTED,
	/** Indicates that the compilation unit has been completely processed. */
	COMPLETE,
}