package edu.jhu.cs.bsj.compiler.ast;

public enum BinaryOperator
{
	LOGICAL_AND,            // &
	LOGICAL_OR,             // |
	XOR,                    // ^

	CONDITIONAL_AND,        // &&
	CONDITIONAL_OR,         // ||

	DIVIDE,                 // /
	MINUS,                  // -
	MODULUS,                // %
	MULTIPLY,               // *
	PLUS,                   // +

	EQUAL,                  // ==
	NOT_EQUAL,              // !=
	
	GREATER_THAN,           // >
	GREATER_THAN_EQUAL,     // >=
	LESS_THAN,              // <
	LESS_THAN_EQUAL,        // <=

	LEFT_SHIFT,             // <<
	RIGHT_SHIFT,            // >>
	UNSIGNED_RIGHT_SHIFT    // >>>
}