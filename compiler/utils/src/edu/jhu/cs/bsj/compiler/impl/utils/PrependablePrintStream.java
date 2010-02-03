package edu.jhu.cs.bsj.compiler.impl.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * This extension of {@link PrintStream} allows the user to specify a tag which will be prepended to every line written
 * to this {@link PrintStream}. Additionally, the number of times this tag will be prepended can also be specified.
 * 
 * @author Zachary Palmer
 * @since 2003
 */
public class PrependablePrintStream extends PrintStream
{
	// STATIC FIELDS /////////////////////////////////////////////////////////////////

	// CONSTANTS /////////////////////////////////////////////////////////////////////

	// NON-STATIC FIELDS /////////////////////////////////////////////////////////////

	/** The tag that is to be prepended to every line written to this PrependablePrintStream. */
	protected String tag;
	/** Whether or not auto-flushing is enabled. */
	protected boolean autoFlush;
	/** The number of times the tag is to be prepended to each line. */
	protected int prependCount;
	/** Whether or not to prepend the next write. */
	protected boolean prependNext;
	/** The ArrayList containing the Strings which represent the prepends at various levels. */
	protected List<String> prependStrings;
	/** The current prepend String. */
	protected String currentPrependString;

	// CONSTRUCTORS //////////////////////////////////////////////////////////////////

	/**
	 * Skeleton constructor. Assumes that there is no prepend tag at construction and that the stream should not flush
	 * automatically.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 */
	public PrependablePrintStream(OutputStream os)
	{
		this(os, false, "", 0);
	}

	/**
	 * Skeleton constructor. Assumes that the prepend tag should be written only once and that the stream should not
	 * flush automatically.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 * @param tag The String to prepend to all lines of this PrependablePrintStream.
	 */
	public PrependablePrintStream(OutputStream os, String tag)
	{
		this(os, false, tag, 1);
	}

	/**
	 * Skeleton constructor. Assumes that the stream should not flush automatically.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 * @param tag The String to prepend to all lines of this PrependablePrintStream.
	 * @param count The number of times a line is prepended with the tag.
	 */
	public PrependablePrintStream(OutputStream os, String tag, int count)
	{
		this(os, false, tag, count);
	}

	/**
	 * Skeleton constructor. Assumes that there is no prepend tag on construction.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 * @param autoFlush Determines whether or not the stream should be flushed after every byte array write, every call
	 *            to <code>println</code>, and every newline character.
	 */
	public PrependablePrintStream(OutputStream os, boolean autoFlush)
	{
		this(os, autoFlush, "", 0);
	}

	/**
	 * Skeleton constructor. Assumes that the tag is to be prepended only once.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 * @param autoFlush Determines whether or not the stream should be flushed after every byte array write, every call
	 *            to <code>println</code>, and every newline character.
	 * @param tag The String to prepend to all lines of this PrependablePrintStream.
	 */
	public PrependablePrintStream(OutputStream os, boolean autoFlush, String tag)
	{
		this(os, autoFlush, tag, 0);
	}

	/**
	 * Full constructor.
	 * 
	 * @param os The OutputStream to which data will be printed.
	 * @param autoFlush Determines whether or not the stream should be flushed after every byte array write, every call
	 *            to <code>println</code>, and every newline character.
	 * @param tag The String to prepend to all lines of this PrependablePrintStream.
	 * @param count The number of times a line is prepended with the tag.
	 */
	public PrependablePrintStream(OutputStream os, boolean autoFlush, String tag, int count)
	{
		super(os, autoFlush);
		this.autoFlush = autoFlush;
		this.tag = tag;
		prependCount = count;
		prependNext = true;
		prependStrings = new ArrayList<String>();
		// Create the prepend strings
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < count; i++)
		{
			sb.append(tag);
			prependStrings.add(sb.toString());
		}
		currentPrependString = sb.toString();
	}

	// NON-STATIC METHODS ////////////////////////////////////////////////////////////

	/**
	 * Sets the tag to a new value.
	 * 
	 * @param tag The new tag.
	 */
	public synchronized void setTag(String tag)
	{
		this.tag = tag;
		// Create the prepend strings
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < prependCount; i++)
		{
			sb.append(tag);
			prependStrings.add(sb.toString());
		}
		currentPrependString = sb.toString();
	}

	/**
	 * Sets the repeat count to a new value.
	 * 
	 * @param count The new repeat count.
	 */
	public synchronized void setPrependCount(int count)
	{
		if (count < 0)
			return;
		prependCount = count;
		if (count > prependStrings.size())
		{
			// Need to create more prepend strings
			int i = prependStrings.size();
			StringBuffer sb;
			if (prependStrings.size() == 0)
			{
				sb = new StringBuffer();
			} else
			{
				sb = new StringBuffer((String) (prependStrings.get(prependStrings.size() - 1)));
			}
			while (i < count)
			{
				sb.append(tag);
				prependStrings.add(sb.toString());
				i++;
			}
			currentPrependString = sb.toString();
		} else
		{
			if (count == 0)
			{
				currentPrependString = "";
			} else
			{
				currentPrependString = (String) (prependStrings.get(count - 1));
			}
		}
	}

	/**
	 * Retrieves the tag.
	 * 
	 * @return The current tag.
	 */
	public synchronized String getTag()
	{
		return tag;
	}

	/**
	 * Retrieves the number of times the tag will be written to each line.
	 * 
	 * @return The number of times the tag will be written to each line.
	 */
	public synchronized int getPrependCount()
	{
		return prependCount;
	}

	/**
	 * Increments the prepend count. This is provided as a convenience function.
	 */
	public synchronized void incPrependCount()
	{
		setPrependCount(getPrependCount() + 1);
	}

	/**
	 * Increments the prepend count. This is provided as a convenience function.
	 */
	public synchronized void decPrependCount()
	{
		setPrependCount(getPrependCount() - 1);
	}

	/**
	 * Increments the prepend count. This is provided as a convenience function.
	 * @param n The amount by which to increment the prepend count.
	 */
	public synchronized void incPrependCount(int n)
	{
		setPrependCount(getPrependCount() + n);
	}

	/**
	 * Increments the prepend count. This is provided as a convenience function.
	 * @param n The amount by which to decrement the prepend count.
	 */
	public synchronized void decPrependCount(int n)
	{
		setPrependCount(getPrependCount() - n);
	}

	// OVERRIDDEN PRINTSTREAM METHODS ////////////////////////////////////////////////

	@Override
	public PrintStream append(char c)
	{
		this.write(c);
		return this;
	}

	@Override
	public PrintStream append(CharSequence csq, int start, int end)
	{
		for (int i = start; i < end; i++)
		{
			this.write(csq.charAt(i));
		}
		return this;
	}

	@Override
	public PrintStream append(CharSequence csq)
	{
		for (int i = 0; i < csq.length(); i++)
		{
			this.write(csq.charAt(i));
		}
		return this;
	}

	@Override
	public PrintStream format(Locale l, String format, Object... args)
	{
		Formatter f = new Formatter(l);
		f.format(format, args);
		this.print(f.out());
		return this;
	}

	@Override
	public PrintStream format(String format, Object... args)
	{
		Formatter f = new Formatter();
		f.format(format, args);
		this.print(f.out());
		return this;
	}

	@Override
	public PrintStream printf(Locale l, String format, Object... args)
	{
		return this.format(l, format, args);
	}

	@Override
	public PrintStream printf(String format, Object... args)
	{
		return this.format(format, args);
	}

	/**
	 * Writes <code>b.length</code> bytes to this output stream.
	 * <p>
	 * The <code>write</code> method of <code>FilterOutputStream</code> calls its <code>write</code> method of three
	 * arguments with the arguments <code>b</code>, <code>0</code>, and <code>b.length</code>.
	 * <p>
	 * Note that this method does not call the one-argument <code>write</code> method of its underlying stream with the
	 * single argument <code>b</code>.
	 * <p>
	 * If this byte array contains any newline characters, appropriate prepending as per PrependablePrintStream is
	 * performed. This will result in the byte array being broken into smaller units.
	 * 
	 * @param b the data to be written.
	 * @exception IOException if an I/O error occurs.
	 * @see java.io.FilterOutputStream#write(byte[], int, int)
	 */
	public synchronized void write(byte[] b) throws IOException
	{
		this.write(b, 0, b.length);
	}

	/**
	 * Write the specified byte to this stream. If the byte is a newline and automatic flushing is enabled then the
	 * <code>flush</code> method will be invoked. If the byte is a newline, prepending will also occur.
	 * 
	 * @param b The byte to be written
	 * @see #print(char)
	 * @see #println(char)
	 */
	public synchronized void write(int b)
	{
		considerPrepend();
		super.write(b);
		if (b == '\n')
		{
			prependNext = true;
			if (autoFlush)
				super.flush();
		}
	}

	/**
	 * Write <code>len</code> bytes from the specified byte array starting at offset <code>off</code> to this stream. If
	 * automatic flushing is enabled then the <code>flush</code> method will be invoked.
	 * 
	 * <p>
	 * Note that the bytes will be written as given; to write characters that will be translated according to the
	 * platform's default character encoding, use the <code>print(char)</code> or <code>println(char)</code> methods.
	 * 
	 * @param buf A byte array
	 * @param off Offset from which to start taking bytes
	 * @param len Number of bytes to write
	 */
	public synchronized void write(byte[] buf, int off, int len)
	{
		int starting = off;
		while (starting < off + len)
		{
			int length = 0;
			while ((starting + length < off + len) && ((length == 0) || (buf[starting + length - 1] != '\n')))
				length++;
			byte[] output = new byte[length];
			System.arraycopy(buf, starting, output, 0, length);
			considerPrepend();
			super.write(output, 0, output.length);
			if (autoFlush)
				super.flush();
			if (output[output.length - 1] == '\n')
				prependNext = true;
			starting += length;
		}
	}

	/**
	 * Print a character. The character is translated into one or more bytes according to the platform's default
	 * character encoding, and these bytes are written in exactly the manner of the <code>{@link #write(int)}</code>
	 * method.
	 * <p>
	 * If this character is a newline, the prepend flag is set.
	 * 
	 * @param c The <code>char</code> to be printed
	 */
	public synchronized void print(char c)
	{
		considerPrepend();
		super.print(c);
		if (c == '\n')
		{
			prependNext = true;
			if (autoFlush)
				super.flush();
		}
	}

	/**
	 * Print an array of characters. The characters are converted into bytes according to the platform's default
	 * character encoding, and these bytes are written in exactly the manner of the <code>{@link #write(int)}</code>
	 * method.
	 * 
	 * @param s The array of chars to be printed
	 */
	public synchronized void print(char[] s)
	{
		for (final char ch : s)
			print(ch);
	}

	/**
	 * Print a string. If the argument is <code>null</code> then the string <code>"null"</code> is printed. Otherwise,
	 * the string's characters are converted into bytes according to the platform's default character encoding, and
	 * these bytes are written in exactly the manner of the <code>{@link #write(int)}</code> method.
	 * 
	 * @param s The <code>String</code> to be printed
	 */
	public synchronized void print(String s)
	{
		byte[] b = s.getBytes();
		this.write(b, 0, b.length);
	}

	/**
	 * Terminate the current line by writing the line separator string. The line separator string is defined by the
	 * system property <code>line.separator</code>, and is not necessarily a single newline character (<code>'\n'</code>
	 * ).
	 */
	public synchronized void println()
	{
		considerPrepend();
		super.println();
		if (autoFlush)
			super.flush();
		prependNext = true;
	}

	/**
	 * Print an object. The string produced by the <code>{@link
     * java.lang.String#valueOf(Object)}</code> method is translated into
	 * bytes according to the platform's default character encoding, and these bytes are written in exactly the manner
	 * of the <code>{@link #write(int)}</code> method.
	 * 
	 * @param obj The <code>Object</code> to be printed
	 * @see java.lang.Object#toString()
	 */
	public synchronized void print(Object obj)
	{
		this.print(obj.toString());
	}

	/**
	 * Print an array of characters and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(char[])}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x an array of chars to print.
	 */
	public synchronized void println(char[] x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a String and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(String)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>String</code> to be printed.
	 */
	public synchronized void println(String x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a character and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(char)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>char</code> to be printed.
	 */
	public synchronized void println(char x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print an Object and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(Object)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>Object</code> to be printed.
	 */
	public synchronized void println(Object x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a boolean value. The string produced by <code>{@link
     * java.lang.String#valueOf(boolean)}</code> is translated into bytes
	 * according to the platform's default character encoding, and these bytes are written in exactly the manner of the
	 * <code>{@link #write(int)}</code> method.
	 * 
	 * @param b The <code>boolean</code> to be printed
	 */
	public synchronized void print(boolean b)
	{
		considerPrepend();
		super.print(b);
	}

	/**
	 * Print an integer. The string produced by <code>{@link
     * java.lang.String#valueOf(int)}</code> is translated into bytes according
	 * to the platform's default character encoding, and these bytes are written in exactly the manner of the
	 * <code>{@link #write(int)}</code> method.
	 * 
	 * @param i The <code>int</code> to be printed
	 * @see java.lang.Integer#toString(int)
	 */
	public synchronized void print(int i)
	{
		considerPrepend();
		super.print(i);
	}

	/**
	 * Print a long integer. The string produced by <code>{@link
     * java.lang.String#valueOf(long)}</code> is translated into bytes
	 * according to the platform's default character encoding, and these bytes are written in exactly the manner of the
	 * <code>{@link #write(int)}</code> method.
	 * 
	 * @param l The <code>long</code> to be printed
	 */
	public synchronized void print(long l)
	{
		considerPrepend();
		super.print(l);
	}

	/**
	 * Print a floating-point number. The string produced by <code>{@link
     * java.lang.String#valueOf(float)}</code> is translated into
	 * bytes according to the platform's default character encoding, and these bytes are written in exactly the manner
	 * of the <code>{@link #write(int)}</code> method.
	 * 
	 * @param f The <code>float</code> to be printed
	 */
	public synchronized void print(float f)
	{
		considerPrepend();
		super.print(f);
	}

	/**
	 * Print a double-precision floating-point number. The string produced by
	 * <code>{@link java.lang.String#valueOf(double)}</code> is translated into bytes according to the platform's
	 * default character encoding, and these bytes are written in exactly the manner of the <code>{@link
     * #write(int)}</code> method.
	 * 
	 * @param d The <code>double</code> to be printed
	 */
	public synchronized void print(double d)
	{
		considerPrepend();
		super.print(d);
	}

	/**
	 * Print a boolean and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(boolean)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>boolean</code> to be printed
	 */
	public synchronized void println(boolean x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print an integer and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(int)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>int</code> to be printed.
	 */
	public synchronized void println(int x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a long and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(long)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x a The <code>long</code> to be printed.
	 */
	public synchronized void println(long x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a float and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(float)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>float</code> to be printed.
	 */
	public synchronized void println(float x)
	{
		this.print(x);
		this.println();
	}

	/**
	 * Print a double and then terminate the line. This method behaves as though it invokes
	 * <code>{@link #print(double)}</code> and then <code>{@link #println()}</code>.
	 * 
	 * @param x The <code>double</code> to be printed.
	 */
	public synchronized void println(double x)
	{
		this.print(x);
		this.println();
	}

	// PROTECTED NON-STATIC METHODS //////////////////////////////////////////////////

	/**
	 * Determines whether or not prepending should be performed. If so, writes the prepend tag as appropriate to this
	 * stream.
	 */
	protected synchronized void considerPrepend()
	{
		if (prependNext)
		{
			prependNext = false;
			super.print(getPrepend());
		}
	}

	/**
	 * Retrieves the string to use as a prepend.
	 */
	protected synchronized String getPrepend()
	{
		return currentPrependString;
	}

	// STATIC METHODS ////////////////////////////////////////////////////////////////

}