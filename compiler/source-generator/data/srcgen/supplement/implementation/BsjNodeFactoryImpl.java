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

    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStartSourceLocation(BsjSourceLocation startLocation)
    {
        this.startLocation = startLocation;
    }

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    @Override
    public void setStopSourceLocation(BsjSourceLocation stopLocation)
    {
        this.stopLocation = stopLocation;
    }

/* GEN:stop */
}