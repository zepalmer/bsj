package edu.jhu.cs.bsj.compiler.lang.type;

/**
 * Describes the different levels of cast compatibility expressed by a casting conversion.
 * @author Zachary Palmer
 */
public enum CastCompatibility
{
	COMPATIBLE,
	INCOMPATIBLE,
	COMPATIBLE_WITH_WARNING
}
