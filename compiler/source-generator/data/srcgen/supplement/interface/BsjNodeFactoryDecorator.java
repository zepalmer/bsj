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

/* GEN:stop */
}