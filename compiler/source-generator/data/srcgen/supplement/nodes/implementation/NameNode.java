/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.names.*;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.*;
/* GEN:headerstop */

public abstract class NameNodeImpl
{
	/* GEN:start */
	public NameCategory getCategory(CompilationUnitLoader loader)
	{
		return NameCategorizer.SINGLETON.categorize(this, loader);
	}
	/* GEN:stop */
}