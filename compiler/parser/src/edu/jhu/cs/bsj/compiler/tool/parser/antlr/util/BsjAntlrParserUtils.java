package edu.jhu.cs.bsj.compiler.tool.parser.antlr.util;

import java.util.ArrayList;
import java.util.List;

import javax.tools.DiagnosticListener;

import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.UnwantedTokenException;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.lexer.BsjLexerDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.BsjParserDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.lexer.GeneralLexerFailureDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.ExtraneousTokenDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.FloatingPointLiteralTooLargeDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.FloatingPointLiteralTooSmallDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.GeneralParseFailureDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.InvalidIntegerLiteralDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.MissingTokenDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.parser.UnexpectedTokenDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckerResult;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckingException;

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
                    while (nums.length() < 3 && i < chars.length && chars[i] >= '0' && chars[i] <= '9')
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
     * Determines the base of the specified character sequence if it is interpreted as a number.
     * 
     * @param c The character sequence.
     * @param i The index at which to start the examination.
     * @return The proposed base for this character sequence: one of <code>16</code>, <code>8</code>, or <code>10</code>
     *         .
     */
    private static final int getBase(char[] c, int i)
    {
        if (c.length > i + 1 && c[i] == '0' && (c[i + 1] == 'x' || c[i + 1] == 'X'))
        {
            return 16;
        } else if (c.length > i && c[i] == '0')
        {
            return 8;
        } else
        {
            return 10;
        }
    }

    /**
     * Parses the provided string as an <tt>int</tt>.
     * 
     * @param s The input string representing the literal.
     * @param isNegative <code>true</code> if this string is prepended with a minus sign; <code>false</code> otherwise.
     * @param location The {@link BsjSourceLocation} at which this parsing is occurring.
     * @param listener The listener to which diagnostics should be reported.
     * @param ruleName The name of the rule which is calling this method.
     * @return The resulting integer value. If an error occurs, <code>null</code> is returned.
     */
    public static Integer parseInt(String s, boolean isNegative, BsjSourceLocation location,
            DiagnosticListener<BsjSourceLocation> listener, String ruleName)
    {
        // We use this int parsing routine because Integer.parseInt is not up to the job.
        // Specifically, Integer.parseInt("0x80000000",16) causes an exception
        char[] chars = s.toCharArray();
        int index = 0;

        int base = getBase(chars, index);
        int acc;
        char c;
        switch (base)
        {
            case 10:
                return Integer.parseInt(isNegative ? ("-" + s) : s);
            case 16:
                if (chars.length <= 10)
                {
                    acc = 0;
                    for (int i = 2; i < chars.length; i++)
                    {
                        acc <<= 4;
                        c = chars[i];
                        acc += hexCharValue(c);
                    }
                    if (isNegative)
                        acc = -acc;
                    return acc;
                }
                break;
            case 8:
                if (chars.length < 12 || (chars.length == 12 && chars[1] <= '3'))
                {
                    acc = 0;
                    for (int i = 1; i < chars.length; i++)
                    {
                        acc <<= 3;
                        c = chars[i];
                        acc += (c - '0');
                    }
                    if (isNegative)
                        acc = -acc;
                    return acc;
                }
                break;
        }

        listener.report(new InvalidIntegerLiteralDiagnosticImpl(location, ruleName, (isNegative ? "-" : "") + s));
        return null;
    }

    /**
     * Parses the provided string as an <tt>long</tt>.
     * 
     * @param s The input string representing the literal.
     * @param isNegative <code>true</code> if this string is prepended with a minus sign; <code>false</code> otherwise.
     * @param location The {@link BsjSourceLocation} at which this parsing is occurring.
     * @param listener The listener to which diagnostics should be reported.
     * @param ruleName The name of the rule which is calling this method.
     * @return The resulting integer value. If an error occurs, <code>null</code> is returned.
     */
    public static Long parseLong(String s, boolean isNegative, BsjSourceLocation location,
            DiagnosticListener<BsjSourceLocation> listener, String ruleName)
    {
        // We use this int parsing routine because Long.parseLong is not up to the job.
        // Specifically, Long.parseLong("0x8000000000000000",16) causes an exception

        // chop off the suffix if it is present
        if (s.endsWith("L") || s.endsWith("l"))
        {
            s = s.substring(0, s.length() - 1);
        }

        char[] chars = s.toCharArray();
        int index = 0;

        int base = getBase(chars, index);
        long acc;
        char c;
        switch (base)
        {
            case 10:
                return Long.parseLong(isNegative ? ("-" + s) : s);
            case 16:
                if (chars.length <= 18)
                {
                    acc = 0;
                    for (int i = 2; i < chars.length; i++)
                    {
                        acc <<= 4;
                        c = chars[i];
                        acc += hexCharValue(c);
                    }
                    return acc;
                }
                break;
            case 8:
                if (chars.length < 23 || (chars.length == 23 && chars[1] <= '1'))
                {
                    acc = 0;
                    for (int i = 1; i < chars.length; i++)
                    {
                        acc <<= 3;
                        c = chars[i];
                        acc += (c - '0');
                    }
                    return acc;
                }
                break;
        }

        listener.report(new InvalidIntegerLiteralDiagnosticImpl(location, ruleName, (isNegative ? "-" : "") + s));
        return null;
    }

    private static int hexCharValue(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - '0';
        } else if (c >= 'a' && c <= 'f')
        {
            return c - ('a' - 10);
        } else if (c >= 'A' && c <= 'F')
        {
            return c - ('A' - 10);
        } else
        {
            throw new IllegalStateException("Illegal hex character: " + c);
        }
    }

    /**
     * Parses the provided string as a <tt>float</tt>.
     * 
     * @param s The input string representing the literal.
     * @param location The {@link BsjSourceLocation} at which this parsing is occurring.
     * @param listener The listener to which diagnostics should be reported.
     * @param ruleName The name of the rule which is calling this method.
     * @return The resulting floating point value, or {@link Float#NaN} if the value is invalid.
     */
    public static float parseFloat(String s, BsjSourceLocation location,
            DiagnosticListener<BsjSourceLocation> listener, String ruleName)
    {
        String nums = s.substring(0, s.length() - 1);
        float f = Float.parseFloat(nums);
        if (!isFloatingPointZero(s) && f == 0.0f)
        {
            listener.report(new FloatingPointLiteralTooSmallDiagnosticImpl(location, ruleName, s));
            return Float.NaN;
        }
        if (Float.isInfinite(f))
        {
            listener.report(new FloatingPointLiteralTooLargeDiagnosticImpl(location, ruleName, s));
            return Float.NaN;
        }
        return f;
    }

    /**
     * Parses the provided string as a <tt>float</tt>.
     * 
     * @param s The input string representing the literal.
     * @param location The {@link BsjSourceLocation} at which this parsing is occurring.
     * @param listener The listener to which diagnostics should be reported.
     * @param ruleName The name of the rule which is calling this method.
     * @return The resulting floating point value, or {@link Float#NaN} if the value is invalid.
     */
    public static double parseDouble(String s, BsjSourceLocation location,
            DiagnosticListener<BsjSourceLocation> listener, String ruleName)
    {
        String nums = s;
        if (s.endsWith("d") || s.endsWith("D"))
        {
            nums = s.substring(0, s.length() - 1);
        }
        double d = Double.parseDouble(nums);
        if (!isFloatingPointZero(s) && d == 0.0)
        {
            listener.report(new FloatingPointLiteralTooSmallDiagnosticImpl(location, ruleName, s));
            return Double.NaN;
        }
        if (Double.isInfinite(d))
        {
            listener.report(new FloatingPointLiteralTooLargeDiagnosticImpl(location, ruleName, s));
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
     * @param location The {@link BsjSourceLocation} on which the exception occurred.
     * @param last The most recently parsed token.
     * @param ruleName The name of the rule that threw the exception.
     * @return The corresponding {@link BsjParserDiagnostic}.
     */
    public static BsjParserDiagnostic convertFromParser(RecognitionException re, String[] tokenNames,
            BsjSourceLocation location, Token last, String ruleName)
    {
        if (re instanceof UnwantedTokenException)
        {
            UnwantedTokenException ute = (UnwantedTokenException) re;
            return new ExtraneousTokenDiagnosticImpl(location, ruleName, ute.expecting == Token.EOF ? "EOF"
                    : tokenNames[ute.expecting], last.getText());
        } else if (re instanceof org.antlr.runtime.MissingTokenException)
        {
            MissingTokenException mte = (MissingTokenException) re;
            return new MissingTokenDiagnosticImpl(location, ruleName, mte.expecting == Token.EOF ? "EOF"
                    : tokenNames[mte.expecting]);
        } else if (re instanceof MismatchedTokenException)
        {
            MismatchedTokenException mte = (MismatchedTokenException) re;
            return new UnexpectedTokenDiagnosticImpl(location, ruleName, last.getType() == Token.EOF ? "EOF"
                    : tokenNames[last.getType()], last.getText(), mte.expecting == Token.EOF ? "EOF"
                    : tokenNames[mte.expecting]);
        } else
        {
            return new GeneralParseFailureDiagnosticImpl(location, ruleName, last.getType() == Token.EOF ? "EOF"
                    : tokenNames[last.getType()], last.getText());
        }
    }

    /**
     * Processes an ANTLR {@link RecognitionException} for the BSJ ANTLR lexer, producing a {@link BsjLexerDiagnostic}
     * which reflects the same information. This method is used to prevent the BSJ API from thowing ANTLR errors and
     * thus causing the users of BSJ to have a build dependency on the ANTLR package.
     * 
     * @param e The ANTLR exception.
     * @param tokenNames The names of the tokens according to the lexer.
     * @param location The {@link BsjSourceLocation} on which the exception occurred.
     * @param last The most recently used character.
     * @return The corresponding {@link BsjLexerDiagnostic}.
     */
    public static BsjLexerDiagnostic convertFromLexer(RecognitionException re, String[] tokenNames,
            BsjSourceLocation location, int last)
    {
        // TODO: can we be more specific?
        return new GeneralLexerFailureDiagnosticImpl(location, last);
    }

    public static boolean isValidExpressionType(String ruleName, BsjTypechecker spliceTypechecker, Node spliceContext,
            NodeUnion<? extends ExpressionNode> expressionUnion, Class<? extends Node> expectedClass,
            Iterable<Class<? extends Node>> forbiddenClasses, IntStream input)
    {
        if (expressionUnion == null)
        {
            return false;
        }

        // Ensure that the expression is a normal node - no other case can be typechecked properly
        if (!expressionUnion.getType().equals(NodeUnion.Type.NORMAL))
        {
            // TODO: need to provide more information
            return false;
        }
        ExpressionNode expr = expressionUnion.getNormalNode();

        // Typecheck the expression
        TypecheckerResult result;
        try
        {
            result = spliceTypechecker.typecheck(expr, spliceContext);
        } catch (TypecheckingException e)
        {
            return false;
        }
        BsjType exprType = result.getType();
        // TODO: produce a semantically meaningful message here if the result type is an error
        BsjType expectedExprType = spliceTypechecker.getModelingFactory().makeMetaprogramClasspathType(expectedClass);
        if (!exprType.isMethodInvocationCompatibleWith(expectedExprType))
        {
            // TODO: need to provide more information
            return false;
        }

        // Ensure that this expression is not among the types which are handled by other rules
        List<BsjType> isForbiddenTypes = new ArrayList<BsjType>();
        for (Class<? extends Node> forbiddenType : forbiddenClasses)
        {
            BsjType exprForbiddenType = spliceTypechecker.getModelingFactory().makeMetaprogramClasspathType(
                    forbiddenType);
            if (exprType.isMethodInvocationCompatibleWith(exprForbiddenType))
            {
                isForbiddenTypes.add(exprForbiddenType);
            }
        }

        // If this type is simultaneously two or more of the forbidden types, that means that the node type in question
        // is ambiguous. This might happen for the splice of a Type rule if the expression's type is some class which is
        // both a PrimitiveTypeNode and a ReferenceTypeNode. One example is ~:null:~.
        if (isForbiddenTypes.size() > 1)
        {
            // TODO: need to provide more information
            return false;
        }

        // If the type is exactly one of the forbidden types, we simply fail to match this rule and carry on.
        if (isForbiddenTypes.size() == 1)
        {
            // TODO: need to provide more information
            return false;
        }

        // Otherwise, this expression's type matches; use it!
        return true;
    }
}
