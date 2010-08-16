package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.parsemap;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjExplicitlyDeclaredType;

/**
 * Objects of this class act as an environment for the BSJ type checker. In addition to (lazily) providing access to the
 * namespaces of the associated node, a BSJ environment maintains other environmental variables established by the BSJ
 * language specification. It should be noted that this environment then acts as both the typechecking environment and
 * the code literal parse mapping environment, allowing both operations to be performed in tandem.
 * 
 * @author Zachary Palmer
 */
public class ParseMapperEnvironment
{
	/** The current expected type of an upcoming code literal. */
	private BsjExplicitlyDeclaredType codeLiteralExpectedType;
	/** The current expected type of a code literal in a return expression. */
	private BsjExplicitlyDeclaredType codeLiteralExpectedReturnType;

	public ParseMapperEnvironment(BsjExplicitlyDeclaredType codeLiteralExpectedType,
			BsjExplicitlyDeclaredType codeLiteralExpectedReturnType)
	{
		super();
		this.codeLiteralExpectedType = codeLiteralExpectedType;
		this.codeLiteralExpectedReturnType = codeLiteralExpectedReturnType;
	}

	/**
	 * Retrieves the current expected type of a code literal.
	 * 
	 * @return The code literal to test.
	 */
	public BsjExplicitlyDeclaredType getCodeLiteralExpectedType()
	{
		return codeLiteralExpectedType;
	}

	/**
	 * Retrieves the current expected return type of a code literal.
	 * 
	 * @return The code literal to test.
	 */
	public BsjExplicitlyDeclaredType getCodeLiteralExpectedReturnType()
	{
		return codeLiteralExpectedReturnType;
	}

	/**
	 * Derives a new environment for the specified code literal type.
	 * 
	 * @param node The new node to use.
	 * @return The resulting environment.
	 */
	public ParseMapperEnvironment deriveForType(BsjExplicitlyDeclaredType codeLiteralExpectedType)
	{
		if (codeLiteralExpectedType.equals(this.codeLiteralExpectedType))
		{
			return this;
		} else
		{
			return new ParseMapperEnvironment(codeLiteralExpectedType, this.codeLiteralExpectedReturnType);
		}
	}

	/**
	 * Derives a new environment for the specified code literal return type.
	 * 
	 * @param node The new node to use.
	 * @return The resulting environment.
	 */
	public ParseMapperEnvironment deriveForExpectedReturnType(BsjExplicitlyDeclaredType codeLiteralReturnType)
	{
		if (codeLiteralExpectedReturnType.equals(this.codeLiteralExpectedReturnType))
		{
			return this;
		} else
		{
			return new ParseMapperEnvironment(this.codeLiteralExpectedType, codeLiteralReturnType);
		}
	}
}
