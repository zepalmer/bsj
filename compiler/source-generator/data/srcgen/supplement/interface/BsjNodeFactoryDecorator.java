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
     * The decoration method.  This method is called after every node creation.
     * @param node The node that was just created.
     */
    protected abstract void decorate(Node node);

/* GEN:stop */
}