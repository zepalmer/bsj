package edu.jhu.cs.bsj.compiler.impl.tool.typechecker;

import edu.jhu.cs.bsj.compiler.lang.type.BsjType;
import edu.jhu.cs.bsj.compiler.tool.typechecker.TypecheckerResult;

/**
 * This data structure contains the result of a typechecking operation.
 * 
 * @author Zachary Palmer
 */
public class TypecheckerResultImpl implements TypecheckerResult
{
	private BsjType type;
	private TypecheckerMetadataImpl metadata;

	public TypecheckerResultImpl(BsjType type, TypecheckerMetadataImpl metadata)
	{
		super();
		this.type = type;
		this.metadata = metadata;
	}

	@Override
	public BsjType getType()
	{
		return type;
	}

	@Override
	public TypecheckerMetadataImpl getMetadata()
	{
		return metadata;
	}

}
