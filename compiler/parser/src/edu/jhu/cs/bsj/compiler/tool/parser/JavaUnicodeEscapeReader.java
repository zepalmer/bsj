package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

/**
 * This {@link Reader} decorator is designed to process an input stream of characters for Unicode escapes as specified
 * by the Java Language Specification v3.0 &#xA7;3. Strings of the form "<tt>&#x005c;u<i>xxxx</i></tt>" where each
 * <tt><i>x</i></tt> is a hexadecimal character are treated as Unicode escapes and replaced with the appropriate Unicode
 * character. Special considerations for the number of backslashes in a sequence and numerous instances of the
 * <tt>u</tt> character are also observed as described in the JLS.
 * 
 * @author Zachary Palmer
 * 
 */
public class JavaUnicodeEscapeReader extends Reader
{
	/** The reader we are decorating. */
	private Reader reader;
	/** The buffer of characters we are currently holding from the decorated reader. */
	private LinkedList<Character> buffer;
	/**
	 * Counts the number of concurrent backslashes which have been observed until this point.  This value reflects the
	 * number of returned backslashes, not the backslashes in the underlying reader.  It does not count backslashes
	 * currently in the buffer.
	 */
	private int backslashes;

	/**
	 * Creates a Unicode escape-reading wrapper around the provided reader.
	 * 
	 * @param reader The reader to decorate.
	 */
	public JavaUnicodeEscapeReader(Reader reader)
	{
		super();
		this.reader = reader;
		this.buffer = new LinkedList<Character>();
		this.backslashes = 0;
	}

	/**
	 * Peeks at a character at the given position in the underlying reader. This method will buffer characters as
	 * necessary to provide this information; characters will be held in this reader's buffer until they are consumed.
	 * 
	 * @param index The relative index to examine. <code>0</code> indicates the next unread character, <code>1</code>
	 *            indicates the next character after that, and so on.
	 * @return The character at that position or <code>-1</code> if the stream has ended by that position.
	 */
	private int peek(int index) throws IOException
	{
		while (buffer.size() <= index)
		{
			int read = this.reader.read();
			if (read == -1)
			{
				return read;
			} else
			{
				buffer.offer((char) read);
			}
		}
		return buffer.get(index);
	}

	/**
	 * Consumes the next character in the buffer. If no characters exist in the buffer, this method consumes the next
	 * buffer in the underlying reader.
	 * 
	 * @return The next character or <code>-1</code> if this reader has been exhausted both in buffer and underlying
	 *         reader.
	 * @throws IOException If an I/O error occurs.
	 */
	private int consume() throws IOException
	{
		int read = peek(0);
		if (buffer.size() > 0)
		{
			buffer.poll();
		}
		return read;
	}

	/**
	 * Pulls a single character from the underlying reader, handling Unicode escapes as they occur.
	 * 
	 * @return The next character to read or <code>-1</code> if the end of the stream has been reached.
	 * @throws IOException If an I/O error occurs while reading from the underlying reader.
	 */
	private int pull() throws IOException
	{
		// If it's not a backslash, go ahead and return it
		if (peek(0) != '\\')
		{
			this.backslashes = 0;
			return consume();
		}
		
		// If the count of backslashes since the last non-backslash is odd, this backslash can't start a Unicode escape
		if (this.backslashes % 2 != 0)
		{
			this.backslashes++;
			return consume();
		}
		
		// The next character must be a 'u' for this to be a Unicode escape
		if (peek(1) != 'u')
		{
			this.backslashes++;
			return consume();
		}
		
		// This is now recognized as a Unicode escape; we must validate and interpret it.
		// We might continue with any number of 'u' characters at this point
		int index = 2;
		while (peek(index) == 'u')
		{
			index++;
		}
		
		// The next four characters following the 'u' must be hexadecimal escapes or this escape code is invalid.
		int code = 0;
		for (int i=index; i < index + 4; i++)
		{
			code <<= 4;
			int hex = peek(i);
			if (hex >= '0' && hex <= '9')
			{
				code += hex - '0';
			} else if (hex >= 'a' && hex <= 'f')
			{
				code += hex - ('a' - 10);
			} else if (hex >= 'A' && hex <= 'F')
			{
				code += hex - ('A' - 10);
			} else
			{
				// This is an invalid Unicode escape.  The JLS dictates that this represents a compile error.
				// TODO: make a special exception type for this
				// TODO: track line and column number so we can report it in the exception
				StringBuilder sb = new StringBuilder();
				for (Character c : this.buffer)
				{
					sb.append(c);
				}
				throw new IOException("Invalid Unicode escape: " + sb.toString());
			}
		}
		
		// We now have a value for the Unicode escape.  Flush the buffer and return our value.
		this.buffer.clear();
		return code;
	}

	@Override
	public void close() throws IOException
	{
		this.reader.close();
	}

	@Override
	public int read() throws IOException
	{
		return pull();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		int reads = 0;
		int index = off;
		while (reads < len)
		{
			int read = pull();
			if (read == -1)
				break;
			cbuf[index++] = (char)read;
			reads++;
		}
		return reads == 0 ? -1 : reads;
	}
}
