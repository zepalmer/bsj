package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.CodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.RawCodeLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.BsjTreeLifter;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap.ParseMapEntry;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;

/**
 * This task replaces the code literals which appear in a given AST with equivalent factory method calls which will
 * compile correctly in Java.
 * 
 * @author Zachary Palmer
 */
public class ReplaceCodeLiteralsTask extends AbstractBsjCompilerTask
{
	/** The AST node which acts as the root for this replacement task. */
	private Node root;
	/** A lazily calculated value representing the parse map of the root AST node. */
	private Map<RawCodeLiteralNode, ParseMapEntry> parseMap;

	public ReplaceCodeLiteralsTask(Node root)
	{
		super(TaskPriority.REPLACE_CODE_LITERALS);
		this.root = root;
	}

	private Map<RawCodeLiteralNode, ParseMapEntry> getParseMap(MetacompilationContext context)
	{
		if (this.parseMap == null)
		{
			TypecheckerManager typecheckerManager = new TypecheckerManager(this.root.getRootPackage(),
					context.getToolkit().getParser(),
					context.getToolkit().getCompilationUnitLoaderFactory().makeLoader(context.getDiagnosticListener()),
					context.getDiagnosticListener());
			this.parseMap = typecheckerManager.getParseMapper().getParseMap(this.root);
		}
		return this.parseMap;
	}

	@Override
	public void execute(final MetacompilationContext context) throws IOException
	{
		this.parseMap = null;
		final Map<Node,Node> nodeReplacementMap = new HashMap<Node, Node>();
		this.root.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			private int levels = 0;

			@Override
			public void visitCodeLiteralNodeStart(CodeLiteralNode node, boolean mostSpecific)
			{
				levels++;
			}

			@Override
			public void visitRawCodeLiteralNodeStart(RawCodeLiteralNode node, boolean mostSpecific)
			{
				levels++;
			}

			@Override
			public void visitCodeLiteralNodeStop(CodeLiteralNode node, boolean mostSpecific)
			{
				levels--;
				if (levels == 0 && node.getParent() == null)
				{
					nodeReplacementMap.put(node, liftNode(context, node.getValue()));
				}
			}

			@Override
			public void visitRawCodeLiteralNodeStop(RawCodeLiteralNode node, boolean mostSpecific)
			{
				levels--;
				if (levels == 0 && node.getParent() != null)
				{
					nodeReplacementMap.put(node, liftNode(context, interpretRawCodeLiteral(context, node)));
				}
			}
		});
		for (Map.Entry<Node,Node> entry : nodeReplacementMap.entrySet())
		{
			entry.getKey().getParent().replace(entry.getKey(), entry.getValue());
		}
	}

	private Node interpretRawCodeLiteral(MetacompilationContext context, RawCodeLiteralNode node)
	{
		Map<RawCodeLiteralNode, ParseMapEntry> map = getParseMap(context);
		ParseMapEntry entry = map.get(node);
		if (entry == null)
		{
			throw new IllegalStateException("Parse mapper did not consider node " + node);
		}
		if (entry.getRules().size() == 0)
		{
			// Then this code literal is unparseable.
			// TODO: report an appropriate diagnostic
			throw new NotImplementedYetException("code literal at " + node.getStartLocation() + " has no parses");
		} else if (entry.getRules().size() > 1)
		{
			// Then this code literal is ambiguous.
			// TODO: report an appropriate diagnostic
			throw new NotImplementedYetException("code literal at " + node.getStartLocation() + " has "
					+ entry.getRules().size() + " parses");
		} else
		{
			return entry.getRules().iterator().next().getResult();
		}
	}

	private static Node liftNode(MetacompilationContext context, Node value)
	{
		BsjNodeFactory factory = context.getToolkit().getNodeFactory();
		BsjTreeLifter lifter = new BsjTreeLifter(factory);
		return value.executeOperation(
				lifter,
				factory.makeMethodInvocationNode(
						factory.makeMethodInvocationNode(
								factory.makeVariableAccessNode(
										factory.makeVariableAccessNode(
												factory.makeVariableAccessNode(
														factory.makeVariableAccessNode(
																factory.makeVariableAccessNode(
																		factory.makeVariableAccessNode(factory.makeIdentifierNode("edu")),
																		factory.makeIdentifierNode("jhu")),
																factory.makeIdentifierNode("cs")),
														factory.makeIdentifierNode("bsj")),
												factory.makeIdentifierNode("compiler")),
										factory.makeIdentifierNode("BsjServiceRegistry")),
								factory.makeIdentifierNode("getThreadLocalData")),
						factory.makeIdentifierNode("get"),
						factory.makeExpressionListNode(factory.makeVariableAccessNode(
								factory.makeVariableAccessNode(
										factory.makeVariableAccessNode(
												factory.makeVariableAccessNode(
														factory.makeVariableAccessNode(
																factory.makeVariableAccessNode(
																		factory.makeVariableAccessNode(
																				factory.makeVariableAccessNode(
																						factory.makeVariableAccessNode(
																								factory.makeVariableAccessNode(factory.makeIdentifierNode("edu")),
																								factory.makeIdentifierNode("jhu")),
																						factory.makeIdentifierNode("cs")),
																				factory.makeIdentifierNode("bsj")),
																		factory.makeIdentifierNode("compiler")),
																factory.makeIdentifierNode("tool")),
														factory.makeIdentifierNode("data")),
												factory.makeIdentifierNode("BsjThreadLocalData")),
										factory.makeIdentifierNode("Element")),
								factory.makeIdentifierNode("NODE_FACTORY")))));
	}
}
