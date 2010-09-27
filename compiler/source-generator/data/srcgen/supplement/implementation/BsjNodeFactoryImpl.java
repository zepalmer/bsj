/* GEN:headerstart */
/**
 * This class acts as a BSJ node factory for the standard BSJ compiler.
 * 
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public class BsjNodeFactoryImpl implements BsjNodeFactory
{
	/* GEN:start */
	/** The start location to use for new nodes. */
	private BsjSourceLocation startLocation;

	/** The stop location to use for new nodes. */
	private BsjSourceLocation stopLocation;

	/** The node manager to provide to all nodes. */
	private BsjNodeManager manager;
	
	/** Whether or not to mark created nodes as binary nodes. */
	private boolean binary;

	/**
	 * Creates a new node factory.
	 * 
	 * @param packageNodeCallback The callback module to provide to package nodes to allow them to incite operations
	 *            such as the loading of other compilation units.
	 * @param manager The node manager to provide to all nodes to allow them to obtain and report information to a
	 *            global authority.
	 */
	public BsjNodeFactoryImpl(BsjNodeManager manager)
	{
		this.manager = manager;
		this.binary = false;
	}

	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.startLocation;
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.stopLocation;
	}

	/**
	 * Changes the starting source location used for new nodes.
	 * 
	 * @param startLocation The new start location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStartSourceLocation(BsjSourceLocation startLocation)
	{
		this.startLocation = startLocation;
	}

	/**
	 * Changes the ending source location used for new nodes.
	 * 
	 * @param stopLocation The new stop location to use for new nodes. <code>null</code> is a permissible value and
	 *            indicates that no information is available.
	 */
	@Override
	public void setStopSourceLocation(BsjSourceLocation stopLocation)
	{
		this.stopLocation = stopLocation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean getBinary()
	{
		return this.binary;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBinary(boolean binary)
	{
		this.binary = binary;
	}

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this));
	}

	/**
	 * {@inheritDoc}
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation)
	{
		return makeSingleStaticImportNode(name.getBase().deepCopy(this), name.getIdentifier().deepCopy(this),
				startLocation, stopLocation);
	}

	/**
	 * {@inheritDoc}
	 */
	public NameNode parseNameNode(String name)
	{
		String[] components = name.split("\\.");
		NameNode node = null;
		for (String component : components)
		{
			if (node == null)
			{
				node = makeSimpleNameNode(makeIdentifierNode(component));
			} else
			{
				node = makeQualifiedNameNode(node, makeIdentifierNode(component));
			}
		}
		return node;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayTypeNode wrapArrayLevels(TypeNode type, int levels)
	{
		if (levels <= 0)
		{
			throw new IllegalArgumentException("Invalid level count: " + levels);
		}
		ArrayTypeNode ret = makeArrayTypeNode(type);
		for (int i=1;i<levels;i++)
		{
			ret = makeArrayTypeNode(ret);
		}
		return ret;
	}

	/* GEN:stop */
}