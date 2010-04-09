package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * This {@link OutputStream} implementation acts as a decorator which provides a mechanism for determining line and
 * column numbers for
 * <ul>
 * <li>The next character that will be written.</li>
 * <li>The character most recently written.</li>
 * <li>The most recently written character which does not conform to the definition of a whitespace character in
 * &#xA7;3.6 of the Java Language Specification.</li>
 * </ul>
 * Line and column numbers are 1-indexed.
 * 
 * @author Zachary Palmer
 */
public class LineAndColumnOutputStream extends OutputStream
{
	/** The line number of the cursor. */
	private int line;
	/** The column number of the cursor. */
	private int column;
	/** The line number of the cursor. */
	private int lastLine;
	/** The column number of the cursor. */
	private int lastColumn;
	/** The line number of the cursor. */
	private int lastNonWhitespaceLine;
	/** The column number of the cursor. */
	private int lastNonWhitespaceColumn;
	/** The backing stream for this decorator. */
	private OutputStream backingStream;

	public LineAndColumnOutputStream(OutputStream backingStream)
	{
		super();
		this.backingStream = backingStream;
		this.line = 1;
		this.column = 1;
		this.lastLine = 1;
		this.lastColumn = 0;
		this.lastNonWhitespaceLine = 1;
		this.lastNonWhitespaceColumn = 0;
	}

	@Override
	public void close() throws IOException
	{
		this.backingStream.close();
	}

	@Override
	public void flush() throws IOException
	{
		this.backingStream.flush();
	}

	@Override
	public void write(int b) throws IOException
	{
		lastLine = line;
		lastColumn = column;
		if (b != '\n' && b != ' ' && b != '\t' && b != '\r' && b != '\u000C')
		{
			lastNonWhitespaceLine = line;
			lastNonWhitespaceColumn = column;
		}
		if (b == '\n')
		{
			line++;
			column = 1;
		} else
		{
			column++;
		}
		this.backingStream.write(b);
	}

	/**
	 * Retrieves the line number for the cursor. If a character is written to this stream, it will appear on the given
	 * line.
	 * 
	 * @return The line number of the next character.
	 */
	public int getLine()
	{
		return line;
	}

	/**
	 * Retrieves the column number for the cursor. If a character is written to the stream, it will appear in the given
	 * column.
	 * 
	 * @return The column number of the next character.
	 */
	public int getColumn()
	{
		return column;
	}

	/**
	 * Retrieves the line number of the last character written to this stream.
	 * 
	 * @return The line number of the last character written to this stream. If no characters have yet been written to
	 *         this stream, returns <code>1</code>.
	 */
	public int getLastLine()
	{
		return lastLine;
	}

	/**
	 * Retrieves the column number of the last character written to this stream.
	 * 
	 * @return The column number of the last character written to this stream. If no characters have yet been written to
	 *         this stream, returns <code>0</code>.
	 */
	public int getLastColumn()
	{
		return lastColumn;
	}

	/**
	 * Retrieves the line number of the last character written to this stream which was not whitespace.
	 * 
	 * @return The line number of the last character written to this stream which was not whitespace. If no
	 *         non-whitespace characters have yet been written to this stream, returns <code>1</code>.
	 */
	public int getLastNonWhitespaceLine()
	{
		return lastNonWhitespaceLine;
	}

	/**
	 * Retrieves the column number of the last character written to this stream which was not whitespace.
	 * 
	 * @return The column number of the last character written to this stream which was not whitespace. If no
	 *         non-whitespace characters have yet been written to this stream, returns <code>0</code>.
	 */
	public int getLastNonWhitespaceColumn()
	{
		return lastNonWhitespaceColumn;
	}
}
