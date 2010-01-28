package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import javax.tools.JavaFileObject.Kind;

/**
 * This utilities class contains functionality common to Java file manager implementations.
 * @author Zachary Palmer
 */
public class JavaFileManagerUtilities
{
	private JavaFileManagerUtilities()
	{
	}
	
	/**
	 * Assigns a {@link Kind} to the specified filename.
	 * @param name The filename.
	 * @return The kind of the file.
	 */
	public static Kind getKindFor(String filename)
	{
		for (Kind kind : Kind.values())
		{
			if (filename.endsWith(kind.extension))
			{
				return kind;
			}
		}
		// Note: we will never get here.  The Kind enumeration's last element is OTHER, which has an extension of
		// "".  All strings end with the empty string.
		throw new IllegalStateException("Exhausted Kind list with no match!");
	}
}
