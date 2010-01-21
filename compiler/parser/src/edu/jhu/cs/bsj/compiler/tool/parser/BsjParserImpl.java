package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.exception.BsjCompilerException;
import edu.jhu.cs.bsj.compiler.exception.BsjCompositeCompilerException;
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
	public CompilationUnitNode parse(InputStream is) throws IOException, BsjCompilerException, BsjCompositeCompilerException
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
		
		List<BsjCompilerException> exceptions = new ArrayList<BsjCompilerException>();
		if (lexer.getExceptions().size()>0)
		{
			exceptions.addAll(lexer.getExceptions());
		}
		if (parser.getExceptions().size()>0)
		{
			exceptions.addAll(parser.getExceptions());
		}
		if (exceptions.size()>0)
		{
			throw new BsjCompositeCompilerException(exceptions);
		}
		
		return compilationUnitNode;
	}
}
