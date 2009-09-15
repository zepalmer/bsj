package edu.jhu.cs.bsj.compiler.ast;

public enum AssignmentOperator
{
	ASSIGNMENT,			              // =
	PLUS_ASSIGNMENT,	              // +=
	MINUS_ASSIGNMENT,                 // -=
	MULTIPLY_ASSIGNMENT,              // *=
	DIVIDE_ASSIGNMENT,                // /=
	AND_ASSIGNMENT,                   // &=
	OR_ASSIGNMENT,                    // |=
	XOR_ASSIGNMENT,                   // ^=
	MODULUS_ASSIGNMENT,               // %=
	LEFT_SHIFT_ASSIGNMENT,            // <<=
	RIGHT_SHIFT_ASSIGNMENT,           // >>=
	UNSIGNED_RIGHT_SHIFT_ASSIGNMENT,  // >>>=
}