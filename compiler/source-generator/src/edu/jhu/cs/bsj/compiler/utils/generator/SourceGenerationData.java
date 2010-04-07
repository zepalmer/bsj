package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.Collection;

/**
 * Represents the data stored in a source generator file.
 * 
 * @author Zachary Palmer
 */
public class SourceGenerationData
{
	private Collection<TypeDefinition> types;
	private Collection<DiagnosticDefinition> diagnostics;
	private Collection<UserDiagnosticDefinition> userDiagnostics;

	public SourceGenerationData(Collection<TypeDefinition> types, Collection<DiagnosticDefinition> diagnostics,
			Collection<UserDiagnosticDefinition> userDiagnostics)
	{
		super();
		this.types = types;
		this.diagnostics = diagnostics;
		this.userDiagnostics = userDiagnostics;
	}

	public Collection<TypeDefinition> getTypes()
	{
		return types;
	}

	public Collection<DiagnosticDefinition> getDiagnostics()
	{
		return diagnostics;
	}

	public Collection<UserDiagnosticDefinition> getUserDiagnostics()
	{
		return userDiagnostics;
	}

}
