package edu.jhu.cs.bsj.compiler.ast;

import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.DIVIDE;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.LEFT_SHIFT;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.LOGICAL_AND;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.LOGICAL_OR;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.MINUS;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.MODULUS;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.MULTIPLY;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.PLUS;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.RIGHT_SHIFT;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.UNSIGNED_RIGHT_SHIFT;
import static edu.jhu.cs.bsj.compiler.ast.BinaryOperator.XOR;

public enum AssignmentOperator
{
	/** Assignment operator representing the token "<tt>=</tt>". */
	ASSIGNMENT(null),
	/** Assignment operator representing the token "<tt>+=</tt>". */
	PLUS_ASSIGNMENT(PLUS),
	/** Assignment operator representing the token "<tt>-=</tt>". */
	MINUS_ASSIGNMENT(MINUS),
	/** Assignment operator representing the token "<tt>*=</tt>". */
	MULTIPLY_ASSIGNMENT(MULTIPLY),
	/** Assignment operator representing the token "<tt>/=</tt>". */
	DIVIDE_ASSIGNMENT(DIVIDE),
	/** Assignment operator representing the token "<tt>&=</tt>". */
	AND_ASSIGNMENT(LOGICAL_AND),
	/** Assignment operator representing the token "<tt>|=</tt>". */
	OR_ASSIGNMENT(LOGICAL_OR),
	/** Assignment operator representing the token "<tt>^=</tt>". */
	XOR_ASSIGNMENT(XOR),
	/** Assignment operator representing the token "<tt>%=</tt>". */
	MODULUS_ASSIGNMENT(MODULUS),
	/** Assignment operator representing the token "<tt>&lt;&lt;=</tt>". */
	LEFT_SHIFT_ASSIGNMENT(LEFT_SHIFT),
	/** Assignment operator representing the token "<tt>&gt;&gt;=</tt>". */
	RIGHT_SHIFT_ASSIGNMENT(RIGHT_SHIFT),
	/** Assignment operator representing the token "<tt>&gt;&gt;&gt;=</tt>". */
	UNSIGNED_RIGHT_SHIFT_ASSIGNMENT(UNSIGNED_RIGHT_SHIFT),

	;

	/** The binary operator abbreviated by this assignment or <code>null</code> if no such operator exists. */
	private BinaryOperator binaryOperator;

	private AssignmentOperator(BinaryOperator binaryOperator)
	{
		this.binaryOperator = binaryOperator;
	}

	/**
	 * Retrieves the binary operator abbreviated by this assignment.
	 * 
	 * @return The binary operator abbreviated by this assignment or <code>null</code> if no such operator exists.
	 */
	public BinaryOperator getBinaryOperator()
	{
		return binaryOperator;
	}
}