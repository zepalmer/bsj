package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

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
