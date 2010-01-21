/* GEN:headerstart */
/**
 * This interface is implemented by any object which can act as a factory for BSJ nodes.  It
 * is strongly advisable to ensure that all nodes in a given AST are produced from the same
 * factory, although the urgency of this restriction is implementation-dependent.
 *
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public interface BsjNodeFactory
{
/* GEN:start */
    /**
     * Changes the starting source location used for new nodes.
     * @param startLocation The new start location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    public void setStartSourceLocation(BsjSourceLocation startLocation);

    /**
     * Changes the ending source location used for new nodes.
     * @param stopLocation The new stop location to use for new nodes.  <code>null</code> is a permissible value and
     *                      indicates that no information is available.
     */
    public void setStopSourceLocation(BsjSourceLocation stopLocation);

/* GEN:stop */
}