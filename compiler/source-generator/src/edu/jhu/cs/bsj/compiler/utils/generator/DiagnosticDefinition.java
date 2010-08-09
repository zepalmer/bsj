package edu.jhu.cs.bsj.compiler.utils.generator;

import java.util.List;

/**
 * This class represents the definition for a BSJ diagnostic.
 * 
 * @author Zachary Palmer
 */
public class DiagnosticDefinition extends AbstractDiagnosticDefinition<DiagnosticDefinition>
{
	private DiagnosticExceptionDefinition exception;

	public DiagnosticDefinition(String baseName, String typeParameter, String superName, String superTypeArg,
			String constructorFooter,
			GenerationProfile profile, DiagnosticExceptionDefinition exception,
			List<DiagnosticPropertyDefinition> properties,
			List<MessagePropertyExpressionDefinition> messagePropertyExpressions, String docString, String code)
	{
		super(baseName, typeParameter, superName, superTypeArg, constructorFooter, profile, properties, messagePropertyExpressions,
				docString, code);
		this.exception = exception;
	}

	public DiagnosticExceptionDefinition getException()
	{
		return exception;
	}
}
