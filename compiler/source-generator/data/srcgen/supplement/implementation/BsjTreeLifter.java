import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;

public class BsjTreeLifter implements BsjNodeOperation<Pair<ExpressionNode, List<BlockStatementNode>>, Void>
{
	/* GEN:start */
	private int nextVariableId = 0;
	private String getUniqueName()
	{
		return "v" + (nextVariableId++);
	}
	/* GEN:stop */
}