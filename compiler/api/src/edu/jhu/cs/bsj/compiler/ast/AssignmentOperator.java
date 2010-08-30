package edu.jhu.cs.bsj.compiler.ast;

public enum AssignmentOperator
{
	/** Assignment operator representing the token "<tt>=</tt>". */
	ASSIGNMENT,
	/** Assignment operator representing the token "<tt>+=</tt>". */
	PLUS_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>-=</tt>". */
	MINUS_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>*=</tt>". */
	MULTIPLY_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>/=</tt>". */
	DIVIDE_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>&=</tt>". */
	AND_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>|=</tt>". */
	OR_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>^=</tt>". */
	XOR_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>%=</tt>". */
	MODULUS_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>&lt;&lt;=</tt>". */
	LEFT_SHIFT_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>&gt;&gt;=</tt>". */
	RIGHT_SHIFT_ASSIGNMENT,
	/** Assignment operator representing the token "<tt>&gt;&gt;&gt;=</tt>". */
	UNSIGNED_RIGHT_SHIFT_ASSIGNMENT,
}