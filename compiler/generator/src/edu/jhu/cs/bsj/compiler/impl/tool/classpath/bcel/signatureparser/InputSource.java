package edu.jhu.cs.bsj.compiler.impl.tool.classpath.bcel.signatureparser;


/**
 * Acts as an input source for a simple lexer.  Implements on-demand read-ahead and buffering.
 * @author Zachary Palmer
 */
public interface InputSource
{
	/**
	 * Peeks at the next char in this input source.
	 * @return The next char which is available.
	 * @throws ParseException If no further chars are available.
	 */
	public char peek() throws ParseException;
	
	/**
	 * Consumes the next char in the input source.
	 * @return The next char which is available.
	 * @throws ParseException If no further chars are available.
	 */
	public char consume() throws ParseException;
	
	/**
	 * Examines the next char in the input source, raising an exception if it is not the expected char.  If it is, it
	 * is consumed.
	 * @param expected The expected char.
	 * @throws ParseException If the expected char was not seen.
	 */
	public void demand(char expected) throws ParseException;
	
	/**
	 * Determines whether or not the input source is exhausted.
	 * @return <code>true</code> if the input source is exhausted; <code>false</code> if it is not.
	 */
	public boolean isExhausted();
	
	/**
	 * Pushes the current state of the input source.  This call is such that a subsequent call to {@link #pop()}
	 * will restore the input source to the precise state it was in when this call was made.
	 */
	public void push();
	
	/**
	 * Pops the current state of the input source.  This restores the input state to the state it was in when the
	 * corresponding {@link #push()} call was made.  If no such corresponding call exists, an
	 * {@link IllegalStateException} is thrown.
	 */
	public void pop();
	
	/**
	 * Erases the most recently pushed state of the input source.  This deletes that recorded state without affecting
	 * the current state of this input source.
	 */
	public void erase();
}
