/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.*;
/* GEN:headerstop */

public abstract class VariableDeclaratorNodeImpl
{
	/* GEN:start */
	
	/**
	 * {@inheritDoc}
	 */
	public TypeNode getEffectiveType(BsjNodeFactory factory)
	{
		VariableDeclaratorOwnerNode owner = this.getNearestAncestorOfType(VariableDeclaratorOwnerNode.class);
		if (owner == null)
		{
			return null;
		}
		TypeNode t = owner.getType().deepCopy(factory);
		for (int i=0;i<this.getArrayLevels();i++)
		{
			t = factory.makeArrayTypeNode(t);
		}
		return t;
	}

	/* GEN:stop */
}