package edu.jhu.cs.bsj.compiler.ast;

/**
 * This enumeration describes the different access modifiers in the Java language.  A "lesser" access modifier is less
 * restrictive; that is, these modifiers are declared in order from least to most restrictive access.
 * @author Zachary Palmer
 */
public enum AccessModifier
{
	PUBLIC,
	PROTECTED,
	PACKAGE,
	PRIVATE
}
