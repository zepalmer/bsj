package edu.jhu.cs.bsj.compiler.tool.parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;

/**
 * This class contains the functionality necessary to parse BSJ source files into BSJ heterogeneous ASTs. It relies on a
 * generated ANTLR parser which produces BSJ homogeneous ASTs from an ANTLR grammar. These homogeneous ASTs are then
 * converted into heterogeneous ASTs using a recursive reconstruction of the tree.
 * 
 * @author Zachary Palmer
 */
public class BsjParser
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
	public BsjParser(BsjNodeFactory factory)
	{
		super();
		this.factory = factory;
	}

	/**
	 * This method generates a BSJ heterogeneous AST from the provided source stream.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * @throws RecognitionException If a recognition error occurs while parsing the provided stream.
	 */
	public CompilationUnitNode parse(InputStream is) throws IOException, RecognitionException
	{
		edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjLexer lexer = new edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjLexer(
				new ANTLRInputStream(is));
		edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjParser parser = new edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjParser(
				new TokenRewriteStream(lexer));
		parser.setFactory(factory);
		
		CompilationUnitNode compilationUnitNode = parser.compilationUnit();
		return compilationUnitNode;
	}
}
