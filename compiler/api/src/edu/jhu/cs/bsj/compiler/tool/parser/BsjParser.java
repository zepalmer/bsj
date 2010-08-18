package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.Reader;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * This interface is used to parse BSJ source into a BSJ AST.
 * 
 * @author Zachary Palmer
 */
public interface BsjParser
{
	/**
	 * This method generates a heterogeneous BSJ AST represeenting a compilation unit from the provided source stream.
	 * 
	 * @param name The name of the compilation unit being parsed.
	 * @param reader The {@link Reader} to use to read the input file.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public CompilationUnitNode parse(String name, Reader reader,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException;

	/**
	 * This method generates a heterogeneous BSJ AST representing a code fragment from the provided source stream.
	 * 
	 * @param name The name of the compilation unit to use when creating source locations for this code fragment.
	 * @param lineNumber The one-based line number for the first character in the source stream.
	 * @param columnNumber The one-based column number for the first character in the source stream.
	 * @param reader The {@link Reader} to use to read the input file.
	 * @param rule The parse rule to use when parsing the source stream.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public <T extends Node> T parse(String name, int lineNumber, int columnNumber, Reader reader, ParseRule<T> rule,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException;
}