import java.util.Collections;

/* GEN:headerstart */
/**
 * This class is used as an enum-like structure which defines the parse rules set forth in the BSJ Language
 * Specification with respect to code literals. As a result of the need for a type parameter, the Java <tt>enum</tt>
 * type could not be used. Each of these elements represents a single parse rule which can be provided to a
 * {@link BsjParser}.
 * 
 * @param <T> An upper bound on the type of node that this parse rule produces.
 * 
 * @author Zachary Palmer
 */
/* GEN:headerstop */
public abstract class ParseRule<T extends Node>
{
	/* GEN:start */
	private Class<T> nodeClass;
	private Collection<Class<? extends T>> bottomMostClasses;

	private ParseRule(Class<T> nodeClass, Collection<Class<? extends T>> bottomMostClasses)
	{
		this.nodeClass = nodeClass;
		this.bottomMostClasses = Collections.unmodifiableCollection(bottomMostClasses);
	}

	/**
	 * Retrieves the type of node which is produced by this parse rule.
	 * 
	 * @return The type of node produced by this parse rule.
	 */
	public Class<T> getNodeClass()
	{
		return this.nodeClass;
	}

	/**
	 * Retrieves a collection of the most specific types which can be produced by this parse rule.
	 * 
	 * @return The most specific types which can be produced by this parse rule.
	 */
	public Collection<Class<? extends T>> getBottomMostClasses()
	{
		return this.bottomMostClasses;
	}
	/* GEN:stop */
}