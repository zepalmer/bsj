package edu.jhu.cs.bsj.compiler.utils.grammar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;

import edu.jhu.cs.bsj.compiler.impl.utils.PrependablePrintStream;
import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;
import edu.jhu.cs.bsj.compiler.utils.grammar.antlr.ANTLRv3Lexer;
import edu.jhu.cs.bsj.compiler.utils.grammar.antlr.ANTLRv3Parser;

/**
 * This module calculates the types of AST nodes which may be spliced into a given grammar rule.
 * 
 * @author Zachary Palmer
 */
public class SpliceIsolationAnalyzer
{
	// TODO

	// TODO: remove
	public static void main(String[] args) throws Exception
	{
		File grammarFile = new File(".." + File.separator + "parser" + File.separator + "resources" + File.separator
				+ "grammar" + File.separator + "BsjAntlr.g");
		// File grammarFile = new File("resources" + File.separator + "grammar" + File.separator + "ANTLRv3.g");
		FileInputStream grammarStream = new FileInputStream(grammarFile);
		ANTLRv3Lexer lexer = new ANTLRv3Lexer(new ANTLRInputStream(grammarStream));
		ANTLRv3Parser parser = new ANTLRv3Parser(new TokenRewriteStream(lexer));

		CommonTree tree = (CommonTree) parser.grammarDef().getTree();
		// System.out.println(treeString(tree, 0));
		RuleStringVisitor visitor = new RuleStringVisitor();
		visitTree(tree, visitor);
		System.out.println(visitor.toString());
	}

	private static void visitTree(CommonTree tree, CommonVisitor visitor)
	{
		boolean visit = visitor.visitChildren(tree);
		visitor.visitStart(tree);
		if (visit && tree.getChildren() != null)
		{
			for (Object o : tree.getChildren())
			{
				visitTree((CommonTree) o, visitor);
			}
		}
		visitor.visitStop(tree);
	}

	private interface CommonVisitor
	{
		public void visitStart(CommonTree tree);

		public void visitStop(CommonTree tree);

		public boolean visitChildren(CommonTree tree);
	}

	private static class RuleStringVisitor implements CommonVisitor
	{
		private ByteArrayOutputStream baos = new ByteArrayOutputStream();
		private PrependablePrintStream pps = new PrependablePrintStream(baos, "    ", 0);

		@Override
		public void visitStart(CommonTree tree)
		{
			if (!visitChildren(tree))
			{
				TreeStringVisitor visitor = new TreeStringVisitor()
				{
					@Override
					public boolean visitChildren(CommonTree tree)
					{
						switch (tree.getType())
						{
							case ANTLRv3Parser.ACTION:
							case ANTLRv3Parser.AT:
							case ANTLRv3Parser.SCOPE:
								return false;
						}
						return true;
					}
				};
				visitTree(tree, visitor);
				pps.println(visitor.toString());
			}
		}

		@Override
		public void visitStop(CommonTree tree)
		{
		}

		@Override
		public boolean visitChildren(CommonTree tree)
		{
			return tree.getType() != ANTLRv3Parser.RULE || Character.isUpperCase(tree.getChild(0).getText().charAt(0));
		}

		public String toString()
		{
			pps.flush();
			return baos.toString();
		}
	}

	private static class TreeStringVisitor implements CommonVisitor
	{
		private ByteArrayOutputStream baos = new ByteArrayOutputStream();
		private PrependablePrintStream pps = new PrependablePrintStream(baos, "    ", 0);

		@Override
		public void visitStart(CommonTree tree)
		{
			if (visitChildren(tree))
			{
				pps.println(tree.toString() + ":" + tree.getType());
				pps.incPrependCount();
			}
		}

		@Override
		public void visitStop(CommonTree tree)
		{
			if (visitChildren(tree))
			{
				pps.decPrependCount();
			}
		}

		@Override
		public boolean visitChildren(CommonTree tree)
		{
			return true;
		}

		public String toString()
		{
			pps.flush();
			return baos.toString();
		}
	}
}
