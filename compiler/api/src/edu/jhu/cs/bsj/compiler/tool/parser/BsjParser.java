package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.Reader;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypechecker;

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
	 * @param name The name of the resource being parsed.
	 * @param reader The {@link Reader} to use to read the input file.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @return The AST node representing the parse.
	 * @throws IOException If an I/O error occurs.
	 */
	public CompilationUnitNode parse(String name, Reader reader,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException;

	/**
	 * This method generates a heterogeneous BSJ AST representing a code fragment from the provided source stream.
	 * 
	 * @param payload The payload to parse.
	 * @param rule The parse rule to use when parsing the payload.
	 * @param typechecker The typechecker to use when typechecking splice nodes or <code>null</code> if splice nodes are
	 *            not allowed.
	 * @param typecheckingContextNode The node to use as the namespace context when typechecking. If
	 *            <code>typechecker</code> is <code>null</code>, this value is ignored.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @return A union containing the AST node representing the parse.
	 * @throws IllegalArgumentException If the provided list of tokens is empty.
	 */
	public <T extends Node> NodeUnion<? extends T> parse(BsjRawCodeLiteralPayload payload, ParseRule<T> rule,
			BsjTypechecker typechecker, Node typecheckingContextNode,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IllegalArgumentException;
}