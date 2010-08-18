package edu.jhu.cs.bsj.compiler.impl.tool.parser;

import java.io.IOException;
import java.io.Reader;

import javax.tools.DiagnosticListener;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrLexer;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrParser;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;

/**
 * This class contains the functionality necessary to parse BSJ source files into BSJ heterogeneous ASTs. It relies on a
 * generated ANTLR parser which produces BSJ homogeneous ASTs from an ANTLR grammar. These homogeneous ASTs are then
 * converted into heterogeneous ASTs using a recursive reconstruction of the tree.
 * 
 * @author Zachary Palmer
 */
public class BsjParserImpl implements BsjParser
{
	/** The logger for this class. */
	private static final Logger LOGGER = Logger.getLogger(BsjParserImpl.class);
	
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
	 * {@inheritDoc}
	 */
	public CompilationUnitNode parse(String name, Reader reader,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Parsing compilation unit with name " + name);
		}
		
		if (diagnosticListener == null)
		{
			diagnosticListener = new DiagnosticPrintingListener<BsjSourceLocation>(System.err);
		}
		BsjAntlrLexer lexer = new BsjAntlrLexer(new ANTLRReaderStream(new JavaUnicodeEscapeReader(reader)));
		lexer.setDiagnosticListener(diagnosticListener);
		lexer.setResourceName(name);
		BsjAntlrParser parser = new BsjAntlrParser(new TokenRewriteStream(lexer));
		parser.setDiagnosticListener(diagnosticListener);
		parser.setResourceName(name);
		parser.setFactory(factory);

		CompilationUnitNode compilationUnitNode;
		try
		{
			compilationUnitNode = parser.compilationUnit(name);
		} catch (RecognitionException re)
		{
			throw new RuntimeException(re); // TODO: throw an exception of our own instead (to avoid passing ANTLR deps)
		}

		return compilationUnitNode;
	}

	@Override
	public <T extends Node> T parse(String name, int lineNumber, int columnNumber, Reader reader, ParseRule<T> rule,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IOException
	{
		if (diagnosticListener == null)
		{
			diagnosticListener = new DiagnosticPrintingListener<BsjSourceLocation>(System.err);
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
