/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
import static edu.jhu.cs.bsj.compiler.ast.NameCategory.*;
/* GEN:headerstop */

public abstract class NameNodeImpl
{
	/* GEN:start */
	/**
	 * This data structure maps pairs of name categories to the appropriate transition when category assertions are
	 * made.  When a mapping is not present, the transition in question is illegal.
	 */
	private static Map<Pair<NameCategory,NameCategory>,NameCategory> categoryTransitionMap;
	// Initialize the category transition map
	private static void addMapping(Map<Pair<NameCategory,NameCategory>,NameCategory> map, NameCategory prev,
			NameCategory assertion, NameCategory result)
	{
		map.put(new Pair<NameCategory,NameCategory>(prev,assertion), result);
	}
	static {
		Map<Pair<NameCategory,NameCategory>,NameCategory> map =
			new HashMap<Pair<NameCategory,NameCategory>,NameCategory>();
		
		addMapping(map, AMBIGUOUS, PACKAGE, PACKAGE);
		addMapping(map, AMBIGUOUS, TYPE, TYPE);
		addMapping(map, AMBIGUOUS, EXPRESSION, EXPRESSION);
		addMapping(map, AMBIGUOUS, PACKAGE_OR_TYPE, PACKAGE_OR_TYPE);
		addMapping(map, PACKAGE_OR_TYPE, PACKAGE, PACKAGE);
		addMapping(map, PACKAGE_OR_TYPE, TYPE, TYPE);
		
		categoryTransitionMap = Collections.unmodifiableMap(map);
	}
	
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category)
	{
		if (this.category == category)
			return;
		
		if (this.category == null)
		{
			this.category = category;
			return;
		}
		
		NameCategory result = categoryTransitionMap.get(new Pair<NameCategory,NameCategory>(this.category, category));
		if (result == null)
		{
			result = categoryTransitionMap.get(new Pair<NameCategory,NameCategory>(category, this.category));
		}
		if (result == null)
		{
			throw new IllegalStateException("Illegal name category transition: " + this.category + " => " + category);
		} else
		{
			this.category = result;
		}
	}

	/* GEN:stop */
}