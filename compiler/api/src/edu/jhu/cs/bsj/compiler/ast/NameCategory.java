package edu.jhu.cs.bsj.compiler.ast;

/**
 * This enumeration describes the different categories in which a name can be placed.  They are enumerated here in the
 * same fashion as they are enumerated in the Java Language Specification v3.0 &#167;6.5.
 * @author Zachary Palmer
 */
public enum NameCategory
{
	/** Indicates that this name refers to a package. */
	PACKAGE,
	/** Indicates that this name refers to a type. */
	TYPE,
	/** Indicates that this name refers to an expression: a member field, local variable, parameter, or so on. */
	EXPRESSION,
	/** Indicates that this name refers to a method. */
	METHOD,
	/** Indicates that this name refers to either a package <i>or</i> a type. */
	PACKAGE_OR_TYPE,
	/** Indicates that this name refers to either a package, a type, or an expression. */
	AMBIGUOUS
}