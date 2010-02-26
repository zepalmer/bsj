package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.Reader;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

/**
 * This interface is used to parse BSJ source into a BSJ AST.
 * @author Zachary Palmer
 */
public interface BsjParser
{
	/**
	 * This method generates a BSJ heterogeneous AST from the provided source stream.
	 * 
	 * @param name The name of the compilation unit being parsed.
	 * @param reader The {@link Reader} to use to read the input file.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public CompilationUnitNode parse(String name, Reader reader,
			DiagnosticListener<? super JavaFileObject> diagnosticListener) throws IOException;

}