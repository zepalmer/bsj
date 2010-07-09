/* GEN:headerstart */
/**
 * This implementation of the BSJ node operation decorates every method of a backing
 * operation with a uniform before and after call.  This permits allows proxying, adjusting
 * or logging the parameters and results of calls, or adaptation of the backing operation
 * to a different set of data types.  Note that only the first call is proxied; if the
 * backing operation calls itself, those calls are not intercepted.
 *
 * @param <POrig> The data parameter type for the original backing operation.
 * @param <ROrig> The return type for the original backing operation.
 * @param <PNew> The data parameter type for the new decorated operation.
 * @param <RNew> The return type for the decorated operation.
 *
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public abstract class BsjNodeOperationProxy<POrig,ROrig,PNew,RNew> implements BsjNodeOperation<PNew,RNew>
{
/* GEN:start */
    /** The backing operation to proxy. */
    private BsjNodeOperation<POrig,ROrig> backingOp;

    /**
     * Creates a new node operation proxy.
     * @param backingOp The backing operation to proxy.
     */
    public BsjNodeOperationProxy(BsjNodeOperation<POrig,ROrig> backingOp)
    {
        this.backingOp = backingOp;
    }

    /**
     * Called before every call to the backing operation.
     * @param p The incoming parameter data (compatible with the proxy interface).
     * @return The resulting parameter data (compatible with the backing interface).
     */
    protected abstract POrig before(PNew p);

    /**
     * Called after every call to the backing operation.
     * @param r The incoming return data (compatible with the backing interface).
     * @return The resulting return data (compatible with the return interface).
     */
    protected abstract RNew after(ROrig r);

/* GEN:stop */
}