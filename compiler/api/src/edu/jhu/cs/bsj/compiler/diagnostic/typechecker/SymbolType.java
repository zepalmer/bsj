package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

/**
 * Enumerates the types of symbols in the Java language.  A symbol is a language element to which a simple identifier
 * can be mapped in some scope.  Each symbol type has its own namespace; that is, the same name may map to different
 * symbols as long as those symbols are of different types.
 * @author Zachary Palmer
 */
public enum SymbolType
{
	/** Indicates types as symbols. */
	TYPE,
	/** Indicates methods as symbols. */
	METHOD,
	/** Indicates variables as symbols. */
	VARIABLE
}
