import java.util.ArrayList;
import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/* GEN:headerstart */
import edu.jhu.cs.bsj.compiler.tool.parser.antlr.*;

/**
 * This class is designed to "lift" a BSJ AST, transitioning it into a higher, more abstract stage of programming. The
 * parameters for all methods are the AST to process and a pairing. The pairing contains an expression describing how
 * the node factory is to be accessed and a list of block statements. The list of block statements is typically empty to
 * start; the lifter adds statements which would cause the input AST to be produced in the metaprogram. The return value
 * of every method is the name of the variable that the lifter used to describe the resulting AST.
 * <p/>
 * For example, consider the case in which one wishes to obtain an AST which indicates how one would construct an AST
 * indicating the integer literal 5. The input AST can be created very simply:
 * 
 * <pre>
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * </pre>
 * 
 * Now suppose one wanted to generate an AST which would represent the above code; that is, produce an AST representing
 * the code that makes an AST. In that case, this lifter is very convenient. The following code would be sufficient:
 * 
 * TODO: rework example code
 * 
 * <pre>
 * List&lt;BlockStatementNode&gt; list = new ArrayList&lt;BlockStatementNode&gt;();
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * BsjTreeLifter lifter = new BsjTreeLifter();
 * String varName = input.executeOperation(lifter, new Pair&lt;ExpressionNode, List&lt;BlockStatementNode&gt;&gt;(factoryExpression,
 * 		list));
 * </pre>
 * 
 * At the end of that call, <code>varName</code> would contain the name of a local variable which would have the
 * resulting AST node in the list of statements if that list were compiled and transformed into a method.
 * <p/>
 * Motivating use cases for this operation include code literals and initial metacompilation (where the original source
 * file is treated as something similar to a giant code literal).
 */
/* GEN:headerstop */
public class BsjTreeLifter implements BsjNodeOperation<Pair<ExpressionNode, List<BlockStatementNode>>, Void>
{
	/* GEN:start */
	protected ExpressionNode expressionizeString(String s)
	{
		if (s == null)
		{
			return factory.makeNullLiteralNode();
		} else
		{
			return factory.makeStringLiteralNode(s);
		}
	}

	protected ExpressionNode expressionizeCharacter(Character c)
	{
		return expressionizeChar(c);
	}

	protected ExpressionNode expressionizeInteger(Integer i)
	{
		return expressionizeInt(i);
	}

	protected ExpressionNode expressionizeBsjSourceLocation(BsjSourceLocation location)
	{
		if (location == null)
		{
			return factory.makeNullLiteralNode();
		} else
		{
			return factory.makeUnqualifiedClassInstantiationNode(
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("BsjSourceLocation"))),
					factory.makeTypeArgumentListNode(),
					factory.makeExpressionListNode(factory.makeStringLiteralNode(location.getResourceName()),
							factory.makeIntLiteralNode(location.getLine()),
							factory.makeIntLiteralNode(location.getColumn())), null);
		}
	}

	protected ExpressionNode expressionizeBsjRawCodeLiteralPayload(BsjRawCodeLiteralPayload payload)
	{
		if (payload == null)
		{
			return factory.makeNullLiteralNode();
		} else if (!(payload instanceof BsjRawCodeLiteralPayloadAntlrImpl))
		{
			throw new IllegalArgumentException("Invalid raw code literal payload type " + payload.getClass());
		} else
		{
			BsjRawCodeLiteralPayloadAntlrImpl payloadImpl = (BsjRawCodeLiteralPayloadAntlrImpl) payload;
			List<BsjTokenImpl> tokens = payloadImpl.getTokens();

			ExpressionListNode tokenInstantiationExpressionList;
			List<ExpressionNode> tokenInstantiationExpressions = new ArrayList<ExpressionNode>();

			for (BsjTokenImpl token : tokens)
			{
				tokenInstantiationExpressions.add(factory.makeUnqualifiedClassInstantiationNode(
						factory.makeUnparameterizedTypeNode(factory.parseNameNode("edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjTokenImpl")),
						factory.makeExpressionListNode(factory.makeIntLiteralNode(token.getChannel()),
								factory.makeIntLiteralNode(token.getCharPositionInLine()),
								factory.makeIntLiteralNode(token.getLine()),
								factory.makeStringLiteralNode(token.getText()),
								factory.makeIntLiteralNode(token.getTokenIndex()),
								factory.makeIntLiteralNode(token.getType()))));
			}
			tokenInstantiationExpressionList = factory.makeExpressionListNode(tokenInstantiationExpressions);

			return factory.makeUnqualifiedClassInstantiationNode(
					factory.makeUnparameterizedTypeNode(factory.makeSimpleNameNode(factory.makeIdentifierNode("BsjRawCodeLiteralPayload"))),
					factory.makeExpressionListNode(
							factory.makeStringLiteralNode(payloadImpl.getResourceName()),
							factory.makeMethodInvocationNode(
									factory.makeVariableAccessNode(factory.makeVariableAccessNode(
											factory.makeVariableAccessNode(factory.makeIdentifierNode("java")),
											factory.makeIdentifierNode("util")), factory.makeIdentifierNode("Arrays")),
									factory.makeIdentifierNode("asList"),
									tokenInstantiationExpressionList,
									factory.makeReferenceTypeListNode(factory.makeUnparameterizedTypeNode(factory.parseNameNode("edu.jhu.cs.bsj.compiler.tool.parser.antlr.BsjTokenImpl"))))));
		}
	}

	/* GEN:stop */
}