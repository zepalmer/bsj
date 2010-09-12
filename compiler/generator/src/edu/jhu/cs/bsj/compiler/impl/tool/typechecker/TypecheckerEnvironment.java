package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * Objects of this class act as an environment for the BSJ type checker. They contain information which is not available
 * to the typechecking operation through the {@link TypecheckerManager}.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerEnvironment
{
	/**
	 * The type expected in context from the surrounding nodes.  This is used to check the type of values which are
	 * stored in variable declaration initializers and other such structures.
	 */
	private BsjType expectedType;
	
	/**
	 * Creates a new, empty typechecker environment.
	 */
	public TypecheckerEnvironment()
	{
		super();
		this.expectedType = null;
	}
	
	/**
	 * Creates a new typechecker environment configured with the provided parameters.
	 * @param parseMap The mapping from raw code literals to their parse map entries.
	 * @param expectedType The expected type defined by context.
	 */
	public TypecheckerEnvironment(BsjType expectedType)
	{
		super();
		this.expectedType = expectedType;
	}

	public BsjType getExpectedType()
	{
		return expectedType;
	}
	
	public TypecheckerEnvironment deriveWithExpectedType(BsjType type)
	{
		return new TypecheckerEnvironment(type);
	}

	@Override
	public String toString()
	{
		return "TypecheckerEnvironment [expectedType=" + expectedType + "]";
	}
}
