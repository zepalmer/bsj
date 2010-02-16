/* GEN:headerstart */
import java.util.concurrent.atomic.AtomicLong;
/* GEN:headerstop */

public abstract class NameNodeImpl
{
	/* GEN:start */
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category)
	{
		// TODO: make this cleaner and more descriptive
		if (this.category == category)
			return;
		if (this.category == NameCategory.AMBIGUOUS)
		{
			if (category == NameCategory.PACKAGE || category == NameCategory.TYPE ||
					category == NameCategory.EXPRESSION)
			{
				this.category = category;
				return;
			}
		}
		if (this.category == NameCategory.PACKAGE_OR_TYPE)
		{
			if (category == NameCategory.PACKAGE || category == NameCategory.TYPE)
			{
				this.category = category;
				return;
			}
		}
		throw new IllegalStateException("Illegal name category transition: " + this.category + " => " + category);
	}

	/* GEN:stop */
}