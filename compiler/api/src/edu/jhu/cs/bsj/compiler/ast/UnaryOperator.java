package edu.jhu.cs.bsj.compiler.ast;

public enum UnaryOperator
{
	/** Unary expression operator representing the token "<tt>~</tt>". */
	BITWISE_COMPLEMENT,
	/** Unary expression operator representing the token "<tt>!</tt>". */
	LOGICAL_COMPLEMENT,
	/** Unary expression operator representing the token "<tt>-</tt>". */
	UNARY_MINUS,
	/** Unary expression operator representing the token "<tt>+</tt>". */
	UNARY_PLUS,
}