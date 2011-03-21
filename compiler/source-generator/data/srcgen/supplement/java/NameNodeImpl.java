/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.names.*;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.*;
/* GEN:headerstop */

public abstract class NameNodeImpl
{
	/* GEN:start */
	private NameCategory nameCategoryCacheValue = null;
	private long nameCategoryCacheModificationCount = 0;
	public NameCategory getCategory(CompilationUnitLoadingInfo info)
	{
		if (nameCategoryCacheModificationCount != getManager().getModificationCount() || nameCategoryCacheValue == null)
		{
			nameCategoryCacheValue = NameCategorizer.SINGLETON.categorize(this, info);
			nameCategoryCacheModificationCount = getManager().getModificationCount();
		}
		return nameCategoryCacheValue;
	}
	/* GEN:stop */
}