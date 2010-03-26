/* GEN:headerstart */
/**
 * This class allows simple decoration of all node construction methods on a node factory.
 *
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public class BsjNodeFactoryDecorator implements BsjNodeFactory
{
/* GEN:start */
    /** The backing factory. */
    BsjNodeFactory factory;

    /**
     * Creates a new decorating factory.
     * @param factory The backing factory.
     */
    public BsjNodeFactoryDecorator(BsjNodeFactory factory)
    {
        this.factory = factory;
    }
    
    /**
     * The "before" decoration method.  This method is called before every node creation.
     */
    protected abstract void before();

    /**
     * The "after" decoration method.  This method is called after every node creation.
     * @param node The node that was just created.
     */
    protected abstract void after(Node node);
    
	/**
	 * Retrieves the starting source location used for new nodes.
	 * 
	 * @return The start location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStartSourceLocation()
	{
		return this.factory.getStartSourceLocation();
	}

	/**
	 * Retrieves the ending source location used for new nodes.
	 * 
	 * @return The stop location used for new nodes. <code>null</code> is a permissible value and indicates that no
	 *         information is available.
	 */
	public BsjSourceLocation getStopSourceLocation()
	{
		return this.factory.getStopSourceLocation();
	}

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStartSourceLocation(BsjSourceLocation startLocation)
    {
        this.factory.setStartSourceLocation(startLocation);
    }

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStopSourceLocation(BsjSourceLocation stopLocation)
    {
        this.factory.setStopSourceLocation(stopLocation);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBinary()
    {
    	return this.factory.getBinary();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBinary(boolean binary)
    {
    	this.factory.setBinary(binary);
    }

	// MANUALLY SPECIFIED MAKE METHODS ///////////////////////////////////////
    // Since these methods call out to the other factory make methods, we don't decorate them.

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The default start and stop location are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(
    		QualifiedNameNode name)
    {
    	return this.factory.makeSingleStaticImportNode(name);
    }

	/**
	 * Creates a {@link SingleStaticImportNode}. The provided name is interpreted as the full name of the import; that
	 * is, the name "<tt>java.utils.Arrays.asList</tt>" would be used to create an import for that method by splitting
	 * the name between its type and final identifier. The specified start and stop locations are used.
	 */
	public SingleStaticImportNode makeSingleStaticImportNode(
    		QualifiedNameNode name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
    	return this.factory.makeSingleStaticImportNode(name, startLocation, stopLocation);
    }

/* GEN:stop */
}