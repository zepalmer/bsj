package edu.jhu.cs.bsj.compiler.ast;

import java.util.Comparator;

public enum BinaryOperator
{
    DIVIDE(9),                 // /
    MODULUS(9),                // %
    MULTIPLY(9),               // *

    MINUS(8),                  // -
    PLUS(8),                   // +

    LEFT_SHIFT(7),             // <<
    RIGHT_SHIFT(7),            // >>
    UNSIGNED_RIGHT_SHIFT(7),   // >>>

    GREATER_THAN(6),           // >
    GREATER_THAN_EQUAL(6),     // >=
    LESS_THAN(6),              // <
    LESS_THAN_EQUAL(6),        // <=

    EQUAL(5),                  // ==
    NOT_EQUAL(5),              // !=
    
    LOGICAL_AND(4),            // &

    XOR(3),                    // ^
    
    LOGICAL_OR(2),             // |

	CONDITIONAL_AND(1),        // &&
	
	CONDITIONAL_OR(0)          // ||
	
	;
	
    /**
     * The precedence for this operation. 
     */
	private int precedence;
	
	/**
	 * Constructor.
	 * @param precedence the precedence for this operation.
	 */
	private BinaryOperator(int precedence)
	{
	    this.precedence = precedence;
	}
	
	/**
	 * Compares two binary operators in terms of their precedence.
	 */
	public class PrecedenceComparator implements Comparator<BinaryOperator>
	{
	    /**
	     * Compares two binary operators in terms of their precedence.
	     * @param a the first operator.
	     * @param b the second operator.
	     * @return -1, 0, or 1 if the first operator is less than, equal to,
	     *     or greater than the second in terms of precedence. 
	     */
        @Override
        public int compare(BinaryOperator a, BinaryOperator b)
        {
            if (a.precedence < b.precedence)
            {
                return -1;
            }
            else if (a.precedence > b.precedence)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }	    
	}	
}