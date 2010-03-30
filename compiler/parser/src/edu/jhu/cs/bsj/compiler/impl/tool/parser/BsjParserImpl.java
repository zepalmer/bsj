package edu.jhu.cs.bsj.compiler.impl.tool.parser;

import java.io.IOException;
import java.io.Reader;

import javax.tools.DiagnosticListener;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrLexer;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrParser;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;

/**
 * This class contains the functionality necessary to parse BSJ source files into BSJ heterogeneous ASTs. It relies on a
 * generated ANTLR parser which produces BSJ homogeneous ASTs from an ANTLR grammar. These homogeneous ASTs are then
 * converted into heterogeneous ASTs using a recursive reconstruction of the tree.
 * 
 * @author Zachary Palmer
 */
public class BsjParserImpl implements BsjParser
{
	/**
	 * The factory that this parser will use to construct AST nodes.
	 */
	private BsjNodeFactory factory;

	/**
	 * General constructor.
	 * 
	 * @param factory The factory that this parser should use to construct AST nodes.
	 */
	public BsjParserImpl(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	/**
	 * This method generates a BSJ heterogeneous AST from the provided source stream.
	 * 
	 * @param name The name of the compilation unit being parsed.
	 * @param reader The {@link Reader} to use to read the input file.
	 * @param diagnosticListener The listener to which diagnostics are reported. If <code>null</code>, a default
	 *            listener is used which reports messages to standard error.
	 * @throws IOException If an I/O error occurs.
	 */
	public CompilationUnitNode parse(String name, Reader reader, DiagnosticListener<BsjSourceLocation> diagnosticListener)
			throws IOException
	{
		if (diagnosticListener==null)
		{
			diagnosticListener = new DiagnosticPrintingListener<BsjSourceLocation>(System.err);
		}
		BsjAntlrLexer lexer = new BsjAntlrLexer(new ANTLRReaderStream(new JavaUnicodeEscapeReader(reader)));
		lexer.setDiagnosticListener(diagnosticListener);
		BsjAntlrParser parser = new BsjAntlrParser(new TokenRewriteStream(lexer));
		parser.setDiagnosticListener(diagnosticListener);
		parser.setFactory(factory);

		CompilationUnitNode compilationUnitNode;
		try
		{
			compilationUnitNode = parser.compilationUnit(name);
		} catch (RecognitionException re)
		{
			throw new RuntimeException(re); // throw an exception of our own instead (to avoid passing ANTLR deps)
		}

		return compilationUnitNode;
	}
}
