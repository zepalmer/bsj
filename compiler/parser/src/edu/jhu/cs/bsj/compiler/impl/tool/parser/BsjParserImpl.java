package edu.jhu.cs.bsj.compiler.impl.tool.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import javax.tools.DiagnosticListener;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.TokenStream;
import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjRawCodeLiteralPayload;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrLexer;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.BsjAntlrParser;
import edu.jhu.cs.bsj.compiler.impl.tool.parser.antlr.util.ParserGeneratedUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.diagnostic.DiagnosticPrintingListener;
import edu.jhu.cs.bsj.compiler.tool.parser.BsjParser;
import edu.jhu.cs.bsj.compiler.tool.parser.ParseRule;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjRawCodeLiteralPayloadAntlrImpl;

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

	@Override
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

		// TODO: if we are given a compilation unit to parse which consists of a single splice, handle it gracefully
		// by logging a diagnostic or something.

		return parse(name, new TokenRewriteStream(lexer), ParseRule.COMPILATION_UNIT, diagnosticListener).getNormalNode();
	}

	@Override
	public <T extends Node> NodeUnion<? extends T> parse(BsjRawCodeLiteralPayload payload, ParseRule<T> rule,
			DiagnosticListener<BsjSourceLocation> diagnosticListener) throws IllegalArgumentException
	{
		if (!(payload instanceof BsjRawCodeLiteralPayloadAntlrImpl))
		{
			throw new IllegalStateException("Invalid payload type " + payload.getClass());
		}

		final String resourceName = ((BsjRawCodeLiteralPayloadAntlrImpl) payload).getResourceName();
		final List<? extends Token> tokens = ((BsjRawCodeLiteralPayloadAntlrImpl) payload).getTokens();

		if (tokens.size() == 0)
		{
			throw new IllegalArgumentException("Cannot parse empty token stream");
		}

		if (LOGGER.isTraceEnabled())
		{
			LOGGER.debug("Parsing code fragment using rule " + rule.getName());
			StringBuilder sb = new StringBuilder("    ");
			for (Token token : tokens)
			{
				sb.append(token.getText());
				sb.append(' ');
			}
			LOGGER.trace("Code fragment consists of the following tokens: " + sb.toString());
		}

		TokenStream tokenStream = new CommonTokenStream(new TokenSource()
		{
			private Iterator<? extends Token> it = tokens.iterator();

			@Override
			public String getSourceName()
			{
				return resourceName;
			}

			@Override
			public Token nextToken()
			{
				if (it.hasNext())
				{
					return new CommonToken(it.next());
				} else
				{
					return Token.EOF_TOKEN;
				}
			}
		});

		return parse(resourceName, tokenStream, rule, diagnosticListener);
	}

	private <T extends Node> NodeUnion<? extends T> parse(String name, TokenStream tokenStream, ParseRule<T> rule,
			DiagnosticListener<BsjSourceLocation> diagnosticListener)
	{
		BsjAntlrParser parser = new BsjAntlrParser(tokenStream);
		parser.setDiagnosticListener(diagnosticListener);
		parser.setResourceName(name);
		parser.setFactory(factory);

		String compilationUnitName = (name != null && name.contains(".") ? name.substring(0, name.indexOf('.')) : name);

		NodeUnion<? extends T> node;
		try
		{
			node = ParserGeneratedUtilities.parseFromAntlr(parser, rule, compilationUnitName);
		} catch (RecognitionException re)
		{
			throw new RuntimeException(re); // TODO: throw an exception of our own instead (to avoid passing ANTLR deps)
		}

		return node;
	}

}
