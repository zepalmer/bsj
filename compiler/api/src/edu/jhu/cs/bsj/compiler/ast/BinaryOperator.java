package edu.jhu.cs.bsj.compiler.ast;

import java.util.Comparator;

public enum BinaryOperator
{
	/** Binary operator representing the token "<tt>/</tt>". */
	DIVIDE(9),
	/** Binary operator representing the token "<tt>%</tt>". */
	MODULUS(9),
	/** Binary operator representing the token "<tt>*</tt>". */
	MULTIPLY(9),

	/** Binary operator representing the token "<tt>-</tt>". */
	MINUS(8),
	/** Binary operator representing the token "<tt>+</tt>". */
	PLUS(8),

	/** Binary operator representing the token "<tt>&lt;&lt;</tt>". */
	LEFT_SHIFT(7),
	/** Binary operator representing the token "<tt>&gt;&gt;</tt>". */
	RIGHT_SHIFT(7),
	/** Binary operator representing the token "<tt>&gt;&gt;&gt;</tt>". */
	UNSIGNED_RIGHT_SHIFT(7),

	/** Binary operator representing the token "<tt>&gt;</tt>". */
	GREATER_THAN(6),
	/** Binary operator representing the token "<tt>&gt;=</tt>". */
	GREATER_THAN_EQUAL(6),
	/** Binary operator representing the token "<tt>&lt;</tt>". */
	LESS_THAN(6),
	/** Binary operator representing the token "<tt>&lt;=</tt>". */
	LESS_THAN_EQUAL(6),

	/** Binary operator representing the token "<tt>==</tt>". */
	EQUAL(5),
	/** Binary operator representing the token "<tt>!=</tt>". */
	NOT_EQUAL(5),

	/** Binary operator representing the token "<tt>&</tt>". */
	LOGICAL_AND(4),

	/** Binary operator representing the token "<tt>^</tt>". */
	XOR(3),

	/** Binary operator representing the token "<tt>|</tt>". */
	LOGICAL_OR(2),

	/** Binary operator representing the token "<tt>&&</tt>". */
	CONDITIONAL_AND(1),

	/** Binary operator representing the token "<tt>||</tt>". */
	CONDITIONAL_OR(0),

	;

	/**
	 * The precedence for this operation.
	 */
	private int precedence;

	/**
	 * Constructor.
	 * 
	 * @param precedence the precedence for this operation.
	 */
	private BinaryOperator(int precedence)
	{
		this.precedence = precedence;
	}

	/**
	 * Compares two binary operators in terms of their precedence.
	 */
	public static class PrecedenceComparator implements Comparator<BinaryOperator>
	{
		/**
		 * Compares two binary operators in terms of their precedence.
		 * 
		 * @param a the first operator.
		 * @param b the second operator.
		 * @return -1, 0, or 1 if the first operator is less than, equal to, or greater than the second in terms of
		 *         precedence.
		 */
		@Override
		public int compare(BinaryOperator a, BinaryOperator b)
		{
			if (a.precedence < b.precedence)
			{
				return -1;
			} else if (a.precedence > b.precedence)
			{
				return 1;
			} else
			{
				return 0;
			}
		}
	}
}