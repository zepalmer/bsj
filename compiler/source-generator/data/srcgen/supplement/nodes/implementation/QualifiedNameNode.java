/* GEN:headerstart */
/* GEN:headerstop */

public abstract class QualifiedNameNodeImpl
{
	/* GEN:start */
	/**
	 * Retrieves a string representation of this name.
	 * @return The string representation of this name.
	 */
	public String getNameString()
	{
		return getBase().getNameString() + "." + getIdentifier().getIdentifier();
	}
	
	/**
	 * Asserts that this node should fall into the specified category.  This override of the {@link NameNodeImpl}
	 * implementation also enforces certain constraints, such as that everything to the left of a package name must
	 * always be a package name.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	@Override
	public void assertCategory(NameCategory category)
	{
		super.assertCategory(category);
		switch (category)
		{
			case PACKAGE:
				if (getBase().getCategory() != NameCategory.PACKAGE)
				{
					getBase().assertCategory(NameCategory.PACKAGE);
				}
				break;
			case TYPE:
				if (getBase().getCategory() != NameCategory.PACKAGE || getBase().getCategory() != NameCategory.TYPE
						|| getBase().getCategory() != NameCategory.PACKAGE_OR_TYPE)
				{
					getBase().assertCategory(NameCategory.PACKAGE_OR_TYPE);
				}
				break;
		}
	}

	/* GEN:stop */
}