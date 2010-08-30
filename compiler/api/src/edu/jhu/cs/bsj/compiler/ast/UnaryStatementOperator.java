package edu.jhu.cs.bsj.compiler.ast;

public enum UnaryStatementOperator
{
	/** Unary statement operator used in the expression "<tt>x--</tt>". */ POSTFIX_DECREMENT,
	/** Unary statement operator used in the expression "<tt>x++</tt>". */ POSTFIX_INCREMENT,
	/** Unary statement operator used in the expression "<tt>--x</tt>". */ PREFIX_DECREMENT,
	/** Unary statement operator used in the expression "<tt>++x</tt>". */ PREFIX_INCREMENT,
}