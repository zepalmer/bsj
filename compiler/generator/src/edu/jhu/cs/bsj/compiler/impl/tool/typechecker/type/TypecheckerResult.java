package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;

/**
 * This data structure contains the result of a typechecking operation.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerResult
{
	private BsjType type;
	private TypecheckingMetadata metadata;

	public TypecheckerResult(BsjType type, TypecheckingMetadata metadata)
	{
		super();
		this.type = type;
		this.metadata = metadata;
	}

	public BsjType getType()
	{
		return type;
	}

	public TypecheckingMetadata getMetadata()
	{
		return metadata;
	}

}
