import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

/* GEN:headerstart */
/**
 * This class is designed to "lift" a BSJ AST, transitioning it into a higher, more abstract stage of programming.  The
 * parameters for all methods are the AST to process and a pairing.  The pairing contains an expression describing how
 * the node factory is to be accessed and a list of block statements.  The list of block statements is typically empty
 * to start; the lifter adds statements which would cause the input AST to be produced in the metaprogram.  The return
 * value of every method is the name of the variable that the lifter used to describe the resulting AST.
 * <p/>
 * For example, consider the case in which one wishes to obtain an AST which indicates how one would construct an AST
 * indicating the integer literal 5.  The input AST can be created very simply:
 * <pre>
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * </pre>
 * Now suppose one wanted to generate an AST which would represent the above code; that is, produce an AST representing
 * the code that makes an AST.  In that case, this lifter is very convenient.  The following code would be sufficient:
 * <pre>
 * List&lt;BlockStatementNode&gt; list = new ArrayList&lt;BlockStatementNode&gt;();
 * IntLiteralNode input = factory.makeIntLiteralNode(5);
 * BsjTreeLifter lifter = new BsjTreeLifter();
 * String varName = input.executeOperation(lifter, new Pair&lt;ExpressionNode, List&lt;BlockStatementNode&gt;&gt;(
 *         factoryExpression, list));
 * </pre>
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
		return factory.makeStringLiteralNode(s);
	}
	
	protected ExpressionNode expressionizeCharacter(Character c)
	{
		return expressionizeChar(c);
	}
	
	protected ExpressionNode expressionizeInteger(Integer i)
	{
		return expressionizeInt(i);
	}
	
	/**
	 * The stack of type parameterizations for the ListNode handler.  If this stack is empty, the invoker of
	 * executeListNode is calling it directly (that is, it is not being called from this lifter directly).
	 */
	private Stack<String> argsForListNodeStack = new Stack<String>();
	/* GEN:stop */
}