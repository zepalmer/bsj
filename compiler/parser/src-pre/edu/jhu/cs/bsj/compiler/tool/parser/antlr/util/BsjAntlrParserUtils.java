package edu.jhu.cs.bsj.compiler.tool.parser.antlr.util;

import org.antlr.runtime.Token;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.exception.parser.BsjParserException;
import edu.jhu.cs.bsj.compiler.exception.parser.InvalidFloatingPointLiteralException;

public class BsjAntlrParserUtils
{
	/**
	 * Unescapes the provided string. Textual escape codes are replaced with the characters they represent.
	 * 
	 * @param string The string to unescape.
	 * @return The unescaped string.
	 */
	public static final String unescape(String string)
	{
		char[] chars = string.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < chars.length)
		{
			if (chars[i] == '\\')
			{
				i++;
				if (chars[i] >= '0' && chars[i] <= '9')
				{
					StringBuilder nums = new StringBuilder();
					while (nums.length() < 3 && i < chars.length - 1 && chars[i] >= '0' && chars[i] <= '9')
					{
						nums.append(chars[i]);
						i++;
					}
					// We don't need to bounds check - no one will pass us illegal escape codes
					char c = (char) (Integer.parseInt(nums.toString()));
					sb.append(c);
				} else
				{
					switch (chars[i])
					{
						case 'b':
							sb.append('\b');
							break;
						case 't':
							sb.append('\t');
							break;
						case 'n':
							sb.append('\n');
							break;
						case 'f':
							sb.append('\f');
							break;
						case 'r':
							sb.append('\r');
							break;
						case '"':
							sb.append('"');
							break;
						case '\'':
							sb.append('\'');
							break;
						case '\\':
							sb.append('\\');
							break;
						default:
							throw new IllegalStateException("Parser fed unescape an illegal escape code: \\" + chars[i]
									+ " (in string \"" + string + "\")");
					}
					i++;
				}
			} else
			{
				sb.append(chars[i]);
				i++;
			}
		}
		return sb.toString();
	}

	/**
	 * Produces a location for the specified token.
	 * 
	 * @param token The token for which a location string is desired.
	 */
	public static String getTokenLocation(Token token)
	{
		return token.getLine() + ":" + token.getCharPositionInLine();
	}

	/**
	 * Determines whether or not the specified string represents a floating point zero.
	 * 
	 * @param s The string in question (with no float or double suffix).
	 * @return <code>true</code> if this string represents a zero.
	 */
	private static boolean isFloatingPointZero(String s)
	{
		s = s.toLowerCase();
		if (s.startsWith("0x"))
		{
			for (char c : s.toCharArray())
			{
				if ((c >= '1' && c <= '9') || (c >= 'a' && c <= 'f'))
				{
					// Non-zero value in the mantissa
					return false;
				} else if (c == 'p')
				{
					// We've hit the exponent; 0^k is zero enough for this function.
					return true;
				}
			}
			return true;
		} else
		{
			for (char c : s.toCharArray())
			{
				if (c >= '1' && c <= '9')
				{
					// Non-zero value in the mantissa
					return false;
				} else if (c == 'e')
				{
					// We've hit the exponent; 0^k is zero enough for this function.
					return true;
				}
			}
			return true;
		}
	}

	/**
	 * Parses the provided string as a <tt>float</tt>.
	 * 
	 * @param s The input string.
	 * @param source The BSJ source location at which this string appears.
	 * @return The parsed float.
	 * @throws BsjParserException If parsing failed.
	 */
	public static float parseFloat(String s, BsjSourceLocation source) throws BsjParserException
	{
		String nums = s.substring(0, s.length() - 1);
		float f = Float.parseFloat(nums);
		if (!isFloatingPointZero(s) && f == 0.0f)
		{
			throw new InvalidFloatingPointLiteralException(source, s,
					InvalidFloatingPointLiteralException.FailureType.TOO_SMALL);
		}
		if (Float.isInfinite(f))
		{
			throw new InvalidFloatingPointLiteralException(source, s,
					InvalidFloatingPointLiteralException.FailureType.TOO_LARGE);
		}
		return f;
	}

	/**
	 * Parses the provided string as a <tt>double</tt>.
	 * 
	 * @param s The input string.
	 * @param source The BSJ source location at which this string appears.
	 * @return The parsed double.
	 * @throws BsjParserException If parsing failed.
	 */
	public static double parseDouble(String s, BsjSourceLocation source)
		throws BsjParserException
	{
		String nums = s;
		if (s.endsWith("d") || s.endsWith("D"))
		{
			nums = s.substring(0, s.length() - 1);
		}
		double d = Double.parseDouble(nums);
		if (!isFloatingPointZero(s) && d == 0.0)
		{
			throw new InvalidFloatingPointLiteralException(source, s,
					InvalidFloatingPointLiteralException.FailureType.TOO_SMALL);
		}
		if (Double.isInfinite(d))
		{
			throw new InvalidFloatingPointLiteralException(source, s,
					InvalidFloatingPointLiteralException.FailureType.TOO_LARGE);
		}
		return d;
	}
}
