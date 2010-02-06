package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.Collection;

/**
 * Represents the data stored in a source generator file.
 * @author Zachary Palmer
 */
public class SourceGenerationData
{
	private Collection<TypeDefinition> types;

	public SourceGenerationData(Collection<TypeDefinition> types)
	{
		super();
		this.types = types;
	}

	public Collection<TypeDefinition> getTypes()
	{
		return types;
	}
}
