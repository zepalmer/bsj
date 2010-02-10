package edu.jhu.cs.bsj.compiler.tool.parser.antlr.util;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.UnwantedTokenException;

import edu.jhu.cs.bsj.compiler.diagnostic.lexer.BsjLexerDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.lexer.GeneralLexerFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.BsjParserDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ExtraneousTokenDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.GeneralParseFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidFloatingPointLiteralDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.MissingTokenDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnexpectedTokenDiagnostic;

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
	 * @param s The input string representing the literal.
	 * @param lineNumber The line number at which the input string is found.
	 * @param columnNumber The column number at which the input string starts.
	 * @param resource The resource in which this input string is found.
	 * @param listener The listener to which diagnostics should be reported.
	 * @param ruleName The name of the rule which is calling this method.
	 * @return The resulting floating point value, or {@link Float#NaN} if the value is invalid.
	 */
	public static float parseFloat(String s, int lineNumber, int columnNumber, JavaFileObject resource,
			DiagnosticListener<? super JavaFileObject> listener, String ruleName)
	{
		String nums = s.substring(0, s.length() - 1);
		float f = Float.parseFloat(nums);
		if (!isFloatingPointZero(s) && f == 0.0f)
		{
			listener.report(new InvalidFloatingPointLiteralDiagnostic<JavaFileObject>(lineNumber, columnNumber,
					resource, ruleName, s, InvalidFloatingPointLiteralDiagnostic.FailureType.TOO_SMALL));
			return Float.NaN;
		}
		if (Float.isInfinite(f))
		{
			listener.report(new InvalidFloatingPointLiteralDiagnostic<JavaFileObject>(lineNumber, columnNumber,
					resource, ruleName, s, InvalidFloatingPointLiteralDiagnostic.FailureType.TOO_LARGE));
			return Float.NaN;
		}
		return f;
	}

	/**
	 * Parses the provided string as a <tt>float</tt>.
	 * 
	 * @param s The input string representing the literal.
	 * @param lineNumber The line number at which the input string is found.
	 * @param columnNumber The column number at which the input string starts.
	 * @param resource The resource in which this input string is found.
	 * @param listener The listener to which diagnostics should be reported.
	 * @param ruleName The name of the rule which is calling this method.
	 * @return The resulting floating point value, or {@link Float#NaN} if the value is invalid.
	 */
	public static double parseDouble(String s, int lineNumber, int columnNumber, JavaFileObject resource,
			DiagnosticListener<? super JavaFileObject> listener, String ruleName)
	{
		String nums = s;
		if (s.endsWith("d") || s.endsWith("D"))
		{
			nums = s.substring(0, s.length() - 1);
		}
		double d = Double.parseDouble(nums);
		if (!isFloatingPointZero(s) && d == 0.0)
		{
			listener.report(new InvalidFloatingPointLiteralDiagnostic<JavaFileObject>(lineNumber, columnNumber,
					resource, ruleName, s, InvalidFloatingPointLiteralDiagnostic.FailureType.TOO_SMALL));
			return Double.NaN;
		}
		if (Double.isInfinite(d))
		{
			listener.report(new InvalidFloatingPointLiteralDiagnostic<JavaFileObject>(lineNumber, columnNumber,
					resource, ruleName, s, InvalidFloatingPointLiteralDiagnostic.FailureType.TOO_LARGE));
			return Double.NaN;
		}
		return d;
	}

	/**
	 * Processes an ANTLR {@link RecognitionException} for the BSJ ANTLR parser, producing a {@link BsjParserDiagnostic}
	 * which reflects the same information. This method is used to prevent the BSJ API from thowing ANTLR errors and
	 * thus causing the users of BSJ to have a build dependency on the ANTLR package.
	 * 
	 * @param e The ANTLR exception.
	 * @param tokenNames The names of the tokens according to the parser.
	 * @param lineNumber The line number on which the exception occurred.
	 * @param columnNumber The column at which the exception occurred.
	 * @param resource The resource being parsed when the exception occurred.
	 * @param last The most recently parsed token.
	 * @param ruleName The name of the rule that threw the exception.
	 * @return The corresponding {@link BsjParserDiagnostic}.
	 */
	public static BsjParserDiagnostic<? extends JavaFileObject> convertFromParser(RecognitionException re,
			String[] tokenNames, int lineNumber, int columnNumber, JavaFileObject resource, Token last, String ruleName)
	{
		if (re instanceof UnwantedTokenException)
		{
			UnwantedTokenException ute = (UnwantedTokenException) re;
			return new ExtraneousTokenDiagnostic<JavaFileObject>(lineNumber, columnNumber, resource, ruleName,
					ute.expecting == Token.EOF ? "EOF" : tokenNames[ute.expecting], last.getText());
		} else if (re instanceof org.antlr.runtime.MissingTokenException)
		{
			MissingTokenException mte = (MissingTokenException) re;
			return new MissingTokenDiagnostic<JavaFileObject>(lineNumber, columnNumber, resource, ruleName,
					mte.expecting == Token.EOF ? "EOF" : tokenNames[mte.expecting]);
		} else if (re instanceof MismatchedTokenException)
		{
			MismatchedTokenException mte = (MismatchedTokenException) re;
			return new UnexpectedTokenDiagnostic<JavaFileObject>(lineNumber, columnNumber, resource, ruleName,
					last.getType() == Token.EOF ? "EOF" : tokenNames[last.getType()], last.getText(),
					mte.expecting == Token.EOF ? "EOF" : tokenNames[mte.expecting]);
		} else
		{
			return new GeneralParseFailureDiagnostic<JavaFileObject>(lineNumber, columnNumber, resource, ruleName,
					last.getType() == Token.EOF ? "EOF" : tokenNames[last.getType()], last.getText());
		}
	}

	/**
	 * Processes an ANTLR {@link RecognitionException} for the BSJ ANTLR lexer, producing a {@link BsjLexerDiagnostic}
	 * which reflects the same information. This method is used to prevent the BSJ API from thowing ANTLR errors and
	 * thus causing the users of BSJ to have a build dependency on the ANTLR package.
	 * 
	 * @param e The ANTLR exception.
	 * @param tokenNames The names of the tokens according to the lexer.
	 * @param lineNumber The line number on which the exception occurred.
	 * @param columnNumber The column at which the exception occurred.
	 * @param resource The resource being parsed when the exception occurred.
	 * @param last The most recently used character.
	 * @return The corresponding {@link BsjLexerDiagnostic}.
	 */
	public static BsjLexerDiagnostic<? extends JavaFileObject> convertFromLexer(RecognitionException re,
			String[] tokenNames, int lineNumber, int columnNumber, JavaFileObject resource, int last)
	{
		// TODO: can we be more specific?
		return new GeneralLexerFailureDiagnostic<JavaFileObject>(lineNumber, columnNumber, resource, last);
	}
}
