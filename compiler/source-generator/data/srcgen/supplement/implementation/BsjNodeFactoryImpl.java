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

	/** The callback module to provide to package nodes. */
	private PackageNodeCallback packageNodeCallback;

	/** The node manager to provide to all nodes. */
	private BsjNodeManager manager;

	/**
	 * Creates a new node factory.
	 * 
	 * @param packageNodeCallback The callback module to provide to package nodes to allow them to incite operations
	 *            such as the loading of other compilation units.
	 * @param manager The node manager to provide to all nodes to allow them to obtain and report information to a
	 *            global authority.
	 */
	public BsjNodeFactoryImpl(PackageNodeCallback packageNodeCallback, BsjNodeManager manager)
	{
		this.packageNodeCallback = packageNodeCallback;
		this.manager = manager;
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

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The default start and stop location are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name)
	{
		return makeSingleStaticImportNode(name.getBase(), name.getIdentifier());
	}

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The specified start and stop locations are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(QualifiedNameNode name, BsjSourceLocation startLocation,
			BsjSourceLocation stopLocation)
	{
		return makeSingleStaticImportNode(name.getBase(), name.getIdentifier(), startLocation, stopLocation);
	}

	/* GEN:stop */
}