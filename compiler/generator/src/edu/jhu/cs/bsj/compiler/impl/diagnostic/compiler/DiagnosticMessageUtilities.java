package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.io.ByteArrayOutputStream;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.DependencyCycleDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;

/**
 * This class contains functions which are convenient for the generated source of diagnostic messages.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticMessageUtilities
{
	/**
	 * Prevent instantiation of utilities class.
	 */
	private DiagnosticMessageUtilities()
	{
	}

	/**
	 * Creates a diagnostic message for the {@link DependencyCycleDiagnostic} class based on the cycle it contains.
	 * The list of metaprograms must be exactly one larger than the list of targets.
	 * 
	 * @param metaprograms The metaprograms in the cycle.
	 * @param targets The targets in the cycle.
	 * @return The appropriate message.
	 */
	public static String getDependencyString(List<BsjSourceLocation> metaprograms, List<String> targets)
	{
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<targets.size();i++)
		{
			sb.append(metaprograms.get(i));
			sb.append(" -> ");
			sb.append(targets.get(i));
			sb.append(" -> ");
		}
		sb.append(metaprograms.get(metaprograms.size()-1));
		return sb.toString();
	}
	
	/**
	 * Creates a string containing an indented version of the stack trace of the provided exception.
	 * @param exception The exception to use.
	 * @return The resulting string.
	 */
	public static String getIndentedStackTraceString(Throwable e)
	{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PrependablePrintStream ps = new PrependablePrintStream(buffer, "\t", 1);
		e.printStackTrace(ps);
		ps.close();
		return buffer.toString();
	}
}
