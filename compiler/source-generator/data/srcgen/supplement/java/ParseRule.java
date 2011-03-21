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
	private String name;
	private Collection<Class<? extends T>> bottomMostClasses;

	private ParseRule(String name, Collection<Class<? extends T>> bottomMostClasses)
	{
		this.name = name;
		this.bottomMostClasses = Collections.unmodifiableCollection(bottomMostClasses);
	}
	
	/**
	 * Retrieves a string naming this parse rule.
	 * @return The name of this parse rule.
	 */
	public String getName()
	{
		return this.name;
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
	
	@Override
	public String toString()
	{
		return this.name + " rule";
	}
	/* GEN:stop */
}