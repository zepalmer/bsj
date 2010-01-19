package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.error.BsjCompilerError;
import edu.jhu.cs.bsj.compiler.error.BsjCompositeCompilerError;
import edu.jhu.cs.bsj.compiler.error.parser.BsjParserError;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjAntlrLexer;
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjAntlrParser;

/**
 * This class contains the functionality necessary to parse BSJ source files into BSJ heterogeneous ASTs. It relies on a
 * generated ANTLR parser which produces BSJ homogeneous ASTs from an ANTLR grammar. These homogeneous ASTs are then
 * converted into heterogeneous ASTs using a recursive reconstruction of the tree.
 * 
 * @author Zachary Palmer
 */
public class BsjParserImpl
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
	 * @throws IOException If an I/O error occurs.
	 * @throws BsjCompositeCompilerError If one or more parse errors occur.
	 */
	public CompilationUnitNode parse(InputStream is) throws IOException, BsjParserError, BsjCompositeCompilerError
	{
		BsjAntlrLexer lexer = new BsjAntlrLexer(new ANTLRInputStream(is));
		BsjAntlrParser parser = new BsjAntlrParser(new TokenRewriteStream(lexer));
		parser.setFactory(factory);

		CompilationUnitNode compilationUnitNode;
		try
		{
			compilationUnitNode = parser.compilationUnit();
		} catch (RecognitionException re)
		{
			throw new RuntimeException(re); // throw an exception of our own instead (to avoid passing ANTLR deps)
		}
		if (parser.getErrors().size()>0)
		{
			throw new BsjCompositeCompilerError(new ArrayList<BsjCompilerError>(parser.getErrors()));
		}
		return compilationUnitNode;
	}
}
