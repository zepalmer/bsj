package edu.jhu.cs.bsj.compiler.tool.parser;

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
						throw new IllegalStateException("Parser fed unescape an illegal escape code: \\" + chars[i] +
								" (in string \"" + string + "\")");
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
}
