package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.Collection;
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
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypecheckerResult;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.TypecheckingMetadata;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
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

	public ReplaceCodeLiteralsTask(Node root)
	{
		super(TaskPriority.REPLACE_CODE_LITERALS);
		this.root = root;
	}

	@Override
	public void execute(final MetacompilationContext context) throws IOException
	{
		// TODO: remove this check one the typechecker is finished
		// It exists to allow programs which do not use code literals to continue to operate until the typechecker is
		// complete. Once the typechecker is complete, this check is purely redundant; until then, it prevents
		// erroneous NotImplementedYetExceptions from affecting programs which do not need that code to function.
		final int[] count = new int[] { 0 };
		this.root.receiveTyped(new BsjTypedNodeNoOpVisitor()
		{
			@Override
			public void visitCodeLiteralNodeStart(CodeLiteralNode node, boolean mostSpecific)
			{
				count[0]++;
			}

			@Override
			public void visitRawCodeLiteralNodeStart(RawCodeLiteralNode node, boolean mostSpecific)
			{
				count[0]++;
			}
		});
		if (count[0] == 0)
		{
			// Then there aren't any code literals in the AST. Skip this step.
			return;
		}

		// Typecheck the AST and then use the typechecking metadata to perform code literal replacement.
		TypecheckerManager typecheckerManager = new TypecheckerManager(this.root.getRootPackage(),
				context.getToolkit().getParser(), context.getToolkit().getCompilationUnitLoaderFactory().makeLoader(
						context.getDiagnosticListener()), context.getDiagnosticListener());
		TypecheckerResult result = typecheckerManager.getTypechecker().typecheck(this.root);
		TypecheckingMetadata metadata = result.getMetadata();

		final Map<Node, Node> nodeReplacementMap = new HashMap<Node, Node>();
		this.root.receiveTyped(new CodeLiteralReplacementVisitor(nodeReplacementMap, context, metadata));
		for (Map.Entry<Node, Node> entry : nodeReplacementMap.entrySet())
		{
			entry.getKey().getParent().replace(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Obtains an AST node representing the body of the specified code literal.
	 * @param context The metacompilation context to use.
	 * @param node The raw code literal to use.
	 * @param metadata The metadata from typechecking.
	 * @return The code literal to use.
	 */
	private Node interpretRawCodeLiteral(MetacompilationContext context, RawCodeLiteralNode node, TypecheckingMetadata metadata)
	{
		BsjType inContextType;
		if (metadata.getInContextType(node) == null)
		{
			throw new IllegalStateException("No in-context type established for code literal at " + node.getStartLocation());
		} else
		{
			inContextType = metadata.getInContextType(node);
		}
		Collection<? extends Node> results = metadata.getParseResult(node).getSelectionBag().selectAll(inContextType);
		if (results.size() == 0)
		{
			// Then this code literal is unparseable.
			// TODO: report an appropriate diagnostic
			throw new NotImplementedYetException("code literal at " + node.getStartLocation() + " has no parses");
		} else if (results.size() > 1)
		{
			// Then this code literal is ambiguous.
			// TODO: report an appropriate diagnostic
			throw new NotImplementedYetException("code literal at " + node.getStartLocation() + " has "
					+ results.size() + " parses");
		} else
		{
			return results.iterator().next();
		}
	}

	/**
	 * Performs the lifting of an AST node for this task.
	 * @param context The context to use.
	 * @param value The AST node to lift.
	 * @return The lifted AST.
	 */
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

	private final class CodeLiteralReplacementVisitor extends BsjTypedNodeNoOpVisitor
	{
		private final Map<Node, Node> nodeReplacementMap;
		private final MetacompilationContext context;
		private final TypecheckingMetadata metadata;
		private int levels = 0;

		private CodeLiteralReplacementVisitor(Map<Node, Node> nodeReplacementMap, MetacompilationContext context,
				TypecheckingMetadata metadata)
		{
			this.nodeReplacementMap = nodeReplacementMap;
			this.context = context;
			this.metadata = metadata;
		}

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
				nodeReplacementMap.put(node, liftNode(context, interpretRawCodeLiteral(context, node, metadata)));
			}
		}
	}

}
